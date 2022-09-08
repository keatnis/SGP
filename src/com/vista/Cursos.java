package com.vista;

import com.DAO.CursoDAO;
import com.DAO.ReportesDAO;
import com.component.EmpleadoSinFoto;
import com.connection.Conexion;
import java.awt.CardLayout;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class Cursos extends javax.swing.JPanel {

    final static String ventana1 = "Ajustes";
    final static String ventana2 = "Ajustes";
    final static String ventana3 = "Ajustes";

    CursoDAO dao = new CursoDAO();
    Conexion con = new Conexion();

    public Cursos() {
        initComponents();
    }

    private void reporte() throws JRException {

        JasperReport archivo = JasperCompileManager.compileReport("C:\\sgp\\reports\\evaluacion_jefe.jrxml");
        Map<String, Object> map = new HashMap<String, Object>();
             dao.setClave(txtClave.getText());
        int numReg = dao.listado().size();
        boolean firstFlag = true;
        JasperPrint jp1 = null;
        JasperPrint jp2 = null;
        ReportesDAO img = new ReportesDAO();
        for (int i = 0; i < numReg; i++) {

            int id = dao.listado().get(i).getIdemp();
            String clave = dao.listado().get(i).getClaveCurso();
            String idjefe = dao.listado().get(i).getId_jefe();
            String idd = String.valueOf(id);
            map.put("id", idd);
            map.put("clave", clave);
            map.put("id_jefe", idjefe);
            map.put("img1", img.Imagen(1));
            map.put("img2", img.Imagen(2));
            if (firstFlag) {
                jp1 = JasperFillManager.fillReport(archivo, map, con.getConnection());
                firstFlag = false;
            } else {
                jp2 = JasperFillManager.fillReport(archivo, map, con.getConnection());
                jp1.addPage(jp2.getPages().get(0));
            }
        }
        JasperViewer.viewReport(jp1, false);

    }

    private void reporteSI() throws JRException {

        JasperReport archivo = JasperCompileManager.compileReport("C:\\sgp\\reports\\evaluacion_jefe.jrxml");
        Map<String, Object> map = new HashMap<String, Object>();
      //  Conectar con = new Conectar("jdbc:mysql://localhost/db_rh?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
     
      dao.setClave(txtClave.getText());
        int numReg = dao.listadoSI().size();
        boolean firstFlag = true;
        JasperPrint jp1 = null;
        JasperPrint jp2 = null;
        ReportesDAO img = new ReportesDAO();
        for (int i = 0; i < numReg; i++) {

            int id = dao.listado().get(i).getIdemp();
            String clave = dao.listado().get(i).getClaveCurso();
            String idjefe = dao.listado().get(i).getId_jefe();
            String idd = String.valueOf(id);
            map.put("id", idd);
            map.put("clave", clave);
            map.put("id_jefe", idjefe);
            map.put("img1", img.Imagen(1));
            map.put("img2", img.Imagen(2));
            if (firstFlag) {
                jp1 = JasperFillManager.fillReport(archivo, map, con.getConnection());
                firstFlag = false;
            } else {
                jp2 = JasperFillManager.fillReport(archivo, map, con.getConnection());
                jp1.addPage(jp2.getPages().get(0));
            }
        }
        JasperViewer.viewReport(jp1, false);

    }

    /* para crear reporte
   SELECT clave_curso,nombre_curso,fecha_inicio,fecha_finalizacion,concat(abrev_nombre,' ',nombre,' ',ape_paterno,' ',ape_materno)AS nombre,jefe_inmediato, tbl_curso.id_empleado
FROM tbl_curso INNER JOIN tbl_empleado ON tbl_curso.id_empleado=tbl_empleado.id_empleado
INNER JOIN tbl_empleo ON tbl_curso.id_empleado=tbl_empleo.id_empleado where clave_curso=15422;
     */
    public void tabla(int id, String nombre) {
        DefaultTableModel modelt = (DefaultTableModel) tabla.getModel();
        Object[] columna = new Object[2];
        columna[0] = id;
        columna[1] = nombre;

        String ids = Integer.toString(id);
        boolean exist = false;
        for (int i = 0; i < tabla.getRowCount(); i++) {
            String s = tabla.getValueAt(i, 0).toString();
            //el id de la fila i-esima
            if (ids.equals(s)) {
                exist = true;
                JOptionPane.showMessageDialog(null, "Ya está registrado, evite duplicar el id");
                break;
            }
        }
        if (!exist) {
            modelt.addRow(columna);
            tabla.setModel(modelt);
        }

    }

    void Llenar_tablaA() {
        DefaultTableModel modelt = (DefaultTableModel) tablaAsistencia.getModel();
        dao.setClave(txtClave.getText());
        int numReg = dao.listado().size();

        txtNombre.setText(dao.listado().get(0).getNombreCurso());
        //numReg de solo UNA TABLA faltan las demas
        Object[] columna = new Object[4];

        for (int i = 0; i < numReg; i++) {

//            columna[0] = this.Empleados().get(i).getIcon();
            columna[0] = dao.listado().get(i).getIdemp();
            columna[1] = dao.listado().get(i).getNombreEmp();
            columna[2] = dao.listado().get(i).getClaveCurso();
            if (dao.listado().get(i).getAsistencia() == null || dao.listado().get(i).getAsistencia().equals("0")) {
                columna[3] = false;
            } else if (!dao.listado().get(i).getAsistencia().equals("0") || dao.listado().get(i).getAsistencia() != null) {
                columna[3] = true;
            }

            modelt.addRow(columna);
        }
    }

    private void guardar() {
        // SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
        String clave = txtClave.getText();
//        String fechaini = (formatofecha.format(fecha1.getDate()));
//        String fechafinal = (formatofecha.format(fecha2.getDate()));
        String fechar = txtFecha.getText();
        String nombrecurso = txtNombre.getText();
        int idt = 0;
        for (int i = 0; i < tabla.getRowCount(); i++) {
            idt = (int) tabla.getValueAt(i, 0);
            dao.registrar(nombrecurso, clave, fechar, idt);

        }
        JOptionPane.showMessageDialog(null, "Se guardó correctamente la lista de los participantes");

    }

    public void eliminar(JTable tabla) {
        DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
        int a = tabla.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }
        // listDH(tabla);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        todos_si = new javax.swing.ButtonGroup();
        pcurso = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        txtNombre = new com.swing.JCTextField();
        txtClave = new com.swing.JCTextField();
        jLabel4 = new javax.swing.JLabel();
        card = new javax.swing.JPanel();
        pRegistroCurso = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        pRegistroAsistencia = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAsistencia = new javax.swing.JTable();
        btnUpdate = new javax.swing.JButton();
        pGenerarFormato = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        rbTodos = new javax.swing.JRadioButton();
        rbSI = new javax.swing.JRadioButton();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        rb1 = new javax.swing.JRadioButton();
        rb2 = new javax.swing.JRadioButton();
        rb3 = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        txtFecha = new com.swing.JCTextField();

        jMenuItem1.setText("jMenuItem1");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setOpaque(false);
        setLayout(new java.awt.GridBagLayout());

        pcurso.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel1.setText("Nombre del Curso:");

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel2.setText("Participantes:");

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel3.setText("Clave del curso:");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        txtNombre.setPlaceholder("Nombre del curso");

        txtClave.setPlaceholder("Clave del curso");
        txtClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClaveActionPerformed(evt);
            }
        });
        txtClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtClaveKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel4.setText("Fecha de realizacion");

        card.setLayout(new java.awt.CardLayout());

        pRegistroCurso.setOpaque(false);

        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/save_35px.png"))); // NOI18N
        jButton1.setText("Guardar datos ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pRegistroCursoLayout = new javax.swing.GroupLayout(pRegistroCurso);
        pRegistroCurso.setLayout(pRegistroCursoLayout);
        pRegistroCursoLayout.setHorizontalGroup(
            pRegistroCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pRegistroCursoLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(pRegistroCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        pRegistroCursoLayout.setVerticalGroup(
            pRegistroCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pRegistroCursoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                .addContainerGap())
        );

        card.add(pRegistroCurso, "card2");

        pRegistroAsistencia.setOpaque(false);

        jLabel6.setText("Lista de participantes registrrados en el curso");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tablaAsistencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id. Emp.", "Nombre", "Clave del curso", "Asistió"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaAsistencia);
        if (tablaAsistencia.getColumnModel().getColumnCount() > 0) {
            tablaAsistencia.getColumnModel().getColumn(1).setPreferredWidth(200);
            tablaAsistencia.getColumnModel().getColumn(2).setPreferredWidth(100);
            tablaAsistencia.getColumnModel().getColumn(3).setPreferredWidth(68);
        }

        btnUpdate.setText("Registrar asistencia");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pRegistroAsistenciaLayout = new javax.swing.GroupLayout(pRegistroAsistencia);
        pRegistroAsistencia.setLayout(pRegistroAsistenciaLayout);
        pRegistroAsistenciaLayout.setHorizontalGroup(
            pRegistroAsistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pRegistroAsistenciaLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel6)
                .addGap(36, 36, 36)
                .addComponent(btnUpdate)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
        );
        pRegistroAsistenciaLayout.setVerticalGroup(
            pRegistroAsistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pRegistroAsistenciaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pRegistroAsistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(btnUpdate))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                .addContainerGap())
        );

        card.add(pRegistroAsistencia, "card3");

        pGenerarFormato.setOpaque(false);

        jLabel7.setText("Generar formato de evaluación");

        jRadioButton1.setText("Evaluación del jefe(a) inmediato(a)");

        jRadioButton2.setText("Evaluación del participante");

        todos_si.add(rbTodos);
        rbTodos.setText("Todos");
        rbTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTodosActionPerformed(evt);
            }
        });

        todos_si.add(rbSI);
        rbSI.setText("Solo los que asistieron");

        jButton3.setText("Generar formatos");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel8.setText("*antes de generar los formatos asegurese introducir la clave del curso");

        jLabel9.setText("Formato:");

        jLabel10.setText("Elija:");

        javax.swing.GroupLayout pGenerarFormatoLayout = new javax.swing.GroupLayout(pGenerarFormato);
        pGenerarFormato.setLayout(pGenerarFormatoLayout);
        pGenerarFormatoLayout.setHorizontalGroup(
            pGenerarFormatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pGenerarFormatoLayout.createSequentialGroup()
                .addGroup(pGenerarFormatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pGenerarFormatoLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addGroup(pGenerarFormatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(pGenerarFormatoLayout.createSequentialGroup()
                                .addComponent(jRadioButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton2))))
                    .addGroup(pGenerarFormatoLayout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jLabel7))
                    .addGroup(pGenerarFormatoLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(rbTodos)
                        .addGap(18, 18, 18)
                        .addGroup(pGenerarFormatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbSI))))
                .addContainerGap(116, Short.MAX_VALUE))
        );
        pGenerarFormatoLayout.setVerticalGroup(
            pGenerarFormatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pGenerarFormatoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(14, 14, 14)
                .addGroup(pGenerarFormatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(pGenerarFormatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbTodos)
                    .addComponent(rbSI)
                    .addComponent(jLabel10))
                .addGap(49, 49, 49)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(335, Short.MAX_VALUE))
        );

        card.add(pGenerarFormato, "card4");

        jButton5.setText("Buscar");

        rb1.setBackground(new java.awt.Color(0, 153, 0));
        buttonGroup1.add(rb1);
        rb1.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        rb1.setForeground(new java.awt.Color(255, 255, 255));
        rb1.setText("Registrar Curso");
        rb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb1ActionPerformed(evt);
            }
        });

        rb2.setBackground(new java.awt.Color(0, 102, 204));
        buttonGroup1.add(rb2);
        rb2.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        rb2.setForeground(new java.awt.Color(255, 255, 255));
        rb2.setText("Registrar asistencia");
        rb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb2ActionPerformed(evt);
            }
        });

        rb3.setBackground(new java.awt.Color(255, 153, 153));
        buttonGroup1.add(rb3);
        rb3.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        rb3.setText("Generar formato de evaluación");
        rb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb3ActionPerformed(evt);
            }
        });

        jButton2.setText("Agregar link de los archivos (constacias,listas de asistencia)");

        txtFecha.setPlaceholder("Fecha de realización");

        javax.swing.GroupLayout pcursoLayout = new javax.swing.GroupLayout(pcurso);
        pcurso.setLayout(pcursoLayout);
        pcursoLayout.setHorizontalGroup(
            pcursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pcursoLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(pcursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pcursoLayout.createSequentialGroup()
                        .addGroup(pcursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(39, 39, 39)
                        .addGroup(pcursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pcursoLayout.createSequentialGroup()
                                .addGroup(pcursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pcursoLayout.createSequentialGroup()
                                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 61, Short.MAX_VALUE))
                                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5))
                            .addGroup(pcursoLayout.createSequentialGroup()
                                .addGroup(pcursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                    .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(card, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(pcursoLayout.createSequentialGroup()
                        .addGroup(pcursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pcursoLayout.createSequentialGroup()
                                .addComponent(rb1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rb2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rb3))
                            .addComponent(jButton2))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pcursoLayout.setVerticalGroup(
            pcursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pcursoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pcursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb1)
                    .addComponent(rb2)
                    .addComponent(rb3))
                .addGap(18, 18, 18)
                .addGroup(pcursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pcursoLayout.createSequentialGroup()
                        .addComponent(card, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pcursoLayout.createSequentialGroup()
                        .addGroup(pcursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pcursoLayout.createSequentialGroup()
                                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(4, 4, 4))
                            .addGroup(pcursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15)
                        .addGroup(pcursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pcursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pcursoLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(7, 7, 7))
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pcursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(42, 42, 42))))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        add(pcurso, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        EmpleadoSinFoto dialog = new EmpleadoSinFoto(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                dialog.setVisible(false);
            }
        });
        dialog.btnAdd.addActionListener((java.awt.event.ActionEvent evt1) -> {
            int idd = dao.idEmpleado(dialog.getNume());
            tabla(idd, dialog.getNombre());
        });

        dialog.setVisible(true);

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClaveActionPerformed

    }//GEN-LAST:event_txtClaveActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        guardar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void rb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb1ActionPerformed
        //pRegistroCurso.setVisible(true);
//        pRegistroCurso.setVisible(false);
//        pGenerarFormato.setVisible(false);
        card.add(pRegistroCurso, ventana1);
        CardLayout cl = (CardLayout) (card.getLayout());

        cl.show(card, ventana1);
    }//GEN-LAST:event_rb1ActionPerformed

    private void rb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb2ActionPerformed

        card.add(pRegistroAsistencia, ventana2);
        CardLayout cl = (CardLayout) (card.getLayout());
        cl.show(card, ventana2);
    }//GEN-LAST:event_rb2ActionPerformed

    private void rb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb3ActionPerformed
        card.add(pGenerarFormato, ventana3);
        CardLayout cl = (CardLayout) (card.getLayout());
        cl.show(card, ventana3);
    }//GEN-LAST:event_rb3ActionPerformed

    private void txtClaveKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClaveKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (rb2.isSelected() && !txtClave.getText().isEmpty()) {
                //   fecha1.setEnabled(false);
                txtFecha.setEnabled(false);
                txtNombre.setEnabled(false);
                btnAgregar.setEnabled(false);
                eliminar(tablaAsistencia);
                Llenar_tablaA();

            }
        }
    }//GEN-LAST:event_txtClaveKeyReleased

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int idta = 0;
        for (int i = 0; i < tablaAsistencia.getRowCount(); i++) {
            idta = (int) tablaAsistencia.getValueAt(i, 0);
            Boolean asistencia = (Boolean) tablaAsistencia.getValueAt(i, 3);
            int asistenciaint = asistencia ? 1 : 0;

            dao.updateAsistencia(idta, asistenciaint);

        }
        JOptionPane.showMessageDialog(null, "Se guardó correctamecte la lista");
        //  Llenar_tablaA();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked

    }//GEN-LAST:event_tablaMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int filaInicio = tabla.getSelectedRow();
        int numFS = tabla.getSelectedRowCount();

        if (filaInicio >= 0) {
            tabla.removeRowSelectionInterval(filaInicio, numFS);
            Llenar_tablaA();
        } else {
            JOptionPane.showMessageDialog(null, "debes seleccionar solo una fila");
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (rbTodos.isSelected()) {
            try {
                reporte();

            } catch (JRException ex) {
                Logger.getLogger(Cursos.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        } else if (rbSI.isSelected()) {
            try {
                reporteSI();

            } catch (JRException ex) {
                Logger.getLogger(Cursos.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void rbTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTodosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbTodosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel card;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pGenerarFormato;
    private javax.swing.JPanel pRegistroAsistencia;
    private javax.swing.JPanel pRegistroCurso;
    private javax.swing.JPanel pcurso;
    private javax.swing.JRadioButton rb1;
    private javax.swing.JRadioButton rb2;
    private javax.swing.JRadioButton rb3;
    private javax.swing.JRadioButton rbSI;
    private javax.swing.JRadioButton rbTodos;
    private javax.swing.JTable tabla;
    private javax.swing.JTable tablaAsistencia;
    private javax.swing.ButtonGroup todos_si;
    private com.swing.JCTextField txtClave;
    private com.swing.JCTextField txtFecha;
    private com.swing.JCTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
