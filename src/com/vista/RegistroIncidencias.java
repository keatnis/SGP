package com.vista;

import com.DAO.IncidenciasDAO;
import com.DAO.PaseSalidaDAO;
import com.classes.ExportarExcel;
import com.classes.Render;
import com.connection.Conexion;
import com.model.ModelPaseSalida;
import com.model.ModelPermisoEconomico;
import com.model.ModelReportarIncidencia;
import com.swing.imgTabla;
import java.awt.Desktop;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class RegistroIncidencias extends javax.swing.JPanel {

    String fecha1, fecha2;
    Conexion con = new Conexion();
    Connection conn = con.getConnection();
    IncidenciasDAO dao = new IncidenciasDAO();

    public RegistroIncidencias() {
        initComponents();
    }

    public void mostrarRegistros(JTable tabla) {

        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        dt.addColumn("No.");
        dt.addColumn("Num. Emp");
        dt.addColumn("Nombre");
        dt.addColumn("Categoria");
        dt.addColumn("Tipo");
        dt.addColumn("Plantel");
        dt.addColumn("Fecha que se solicitó");
        dt.addColumn("Fecha Inicio");
        dt.addColumn("Fecha Termino");
        dt.addColumn("Dia (s)");
        ModelPermisoEconomico vo;
        ArrayList<ModelPermisoEconomico> list = this.listarRegistros();

        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Object fila[] = new Object[10];
                vo = list.get(i);

                fila[0] = String.valueOf(i);
                fila[1] = vo.getNumEmp();
                fila[2] = vo.getNombre();
                fila[3] = vo.getCategoria();
                fila[4] = vo.getTipo();
                fila[5] = vo.getPlantel();
                fila[6] = vo.getFecha_solicitada();
                fila[7] = vo.getFecha_de();
                fila[8] = vo.getFecha_al();
                fila[9] = vo.getDias();
//                if (vo.getArchivo() != null) {
//                    fila[6] = new JButton(icono);
//                } else {
//                    fila[6] = new JButton("Vacio");
//                }

                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(32);
            tabla.setShowVerticalLines(true);
        }

    }

    private void init() {
        if (fechade.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Fecha 'Desde' no asignado");
        } else if (fechahasta.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Fecha 'Hasta' no signado");
        }
        if (!rbPases.isSelected() && !rbPermisos.isSelected() && !rbIncidencias.isSelected()) {
            JOptionPane.showMessageDialog(null, "No seleccionado ninguna opción a mostrar");
        }
        SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
        fecha1 = (formatofecha.format(fechade.getDate()));
        fecha2 = (formatofecha.format(fechahasta.getDate()));
    }

    public ArrayList<ModelPaseSalida> listarRegistrosPase() {
        init();
        ArrayList<ModelPaseSalida> list = new ArrayList<>();

        String sql
                = " SELECT num_empleado,concat(abrev_nombre,' ',nombre,' ',ape_paterno,' ',ape_materno,' ')AS nombre,fecha,folio,hora_salida,hora_llegada,observacion\n"
                + "           FROM tbl_pase_salida\n"
                + "               INNER JOIN tbl_empleado\n"
                + "                ON tbl_pase_salida.id_empleado=tbl_empleado.id_empleado\n"
                + " where   fecha BETWEEN '" + fecha1 + "' AND '" + fecha2 + "';";
        ResultSet rs1 = null;

        PreparedStatement ps = null;
        try {

            ps = conn.prepareStatement(sql);
            ps.executeQuery();
            rs1 = ps.executeQuery();
            while (rs1.next()) {
                ModelPaseSalida vo = new ModelPaseSalida();
                //  vo.setNp(rs1.getInt(1));
                vo.setNump(rs1.getString(1));
                vo.setNombre(rs1.getString(2));
                vo.setFecha(rs1.getString(3));
                vo.setFolio(rs1.getString(4));
                vo.setHoraSalida(rs1.getString(5));
                vo.setHoraLlegada(rs1.getString(6));
                vo.setObservaciones(rs1.getString(7));
                list.add(vo);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return list;
    }

    public void mostrarPases(JTable tabla) {

        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //  dt.addColumn("N/P");
        dt.addColumn("Num. Emp");
        dt.addColumn("Nombre");
        dt.addColumn("Fecha");
        dt.addColumn("Folio");
        dt.addColumn("Hora Salida");
        dt.addColumn("Hora de Llegada");
        dt.addColumn("Observación");

        ModelPaseSalida vo;
        ArrayList<ModelPaseSalida> list = this.listarRegistrosPase();

        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Object fila[] = new Object[9];
                vo = list.get(i);
                //  fila[0] = String.valueOf(i);
                fila[0] = vo.getNump();
                fila[1] = vo.getNombre();
                fila[2] = vo.getFecha();
                fila[3] = vo.getFolio();
                fila[4] = vo.getHoraSalida();
                fila[5] = vo.getHoraLlegada();
                fila[6] = vo.getObservaciones();

                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(32);
            tabla.setShowVerticalLines(true);
        }

    }

    public ArrayList<ModelPermisoEconomico> listarRegistros() {
        init();
        ArrayList<ModelPermisoEconomico> list = new ArrayList<>();

        String sql = "SELECT num_empleado,concat(abrev_nombre, ' ',nombre,' ',ape_paterno,' ',ape_materno,' ')as nombre,categoria,tipo_contratacion,plantel, fecha_solicitada,fecha_de,fecha_al,dias\n"
                + "               FROM tbl_permiso_economico\n"
                + "              INNER JOIN tbl_empleado ON tbl_empleado.id_empleado=tbl_permiso_economico.id_empleado\n"
                + "               inner JOIN tbl_empleo ON tbl_permiso_economico.id_empleado =tbl_empleo.id_empleado\n"
                + "             where   fecha_solicitada  BETWEEN '" + fecha1 + "' AND '" + fecha2 + "';";

        ResultSet rs1 = null;

        PreparedStatement ps = null;
        try {

            ps = conn.prepareStatement(sql);
            ps.executeQuery();
            rs1 = ps.executeQuery();
            while (rs1.next()) {
                ModelPermisoEconomico vo = new ModelPermisoEconomico();
                //  vo.setNp(rs1.getInt(1));
                vo.setNumEmp(rs1.getString(1));
                vo.setNombre(rs1.getString(2));
                vo.setCategoria(rs1.getString(3));
                vo.setTipo(rs1.getString(4));
                vo.setPlantel(rs1.getString(5));
                vo.setFecha_solicitada(rs1.getString(6));
                vo.setFecha_de(rs1.getString(7));
                vo.setFecha_al(rs1.getString(8));
                vo.setDias(rs1.getInt(9));
                list.add(vo);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return list;
    }

    public ArrayList<ModelReportarIncidencia> Listar_PdfVO() {
        init();
        ArrayList<ModelReportarIncidencia> list = new ArrayList<>();
        Conexion con = new Conexion();
        Connection conn = con.getConnection();

        String sql = "SELECT id_incidencia,concat(abrev_nombre,' ',nombre,' ',ape_materno,' ',ape_paterno)nombre,num_empleado,\n"
                + "fecha_inicio,fecha_fin,tipo_incidencia,esjustificada,archivo,nota,usuario,fecha_registro\n"
                + "FROM tbl_incidencia INNER JOIN tbl_empleado\n"
                + " ON tbl_empleado.id_empleado=tbl_incidencia.id_empleado "
                + " where   fecha_registro  BETWEEN '" + fecha1 + "' AND '" + fecha2 + "';";

        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ModelReportarIncidencia vo = new ModelReportarIncidencia();
                vo.setIdIncidencia(rs.getInt(1));
                vo.setNombreEmp(rs.getString(2));
                vo.setNumEmp(rs.getString(3));
                vo.setFecha_de(rs.getString(4));
                vo.setFecha_hasta(rs.getString(5));
                vo.setTipoIncidencia(rs.getString(6));
                vo.setEsJustificada(rs.getInt(7));
                vo.setArchivo(rs.getBytes(8));
                vo.setNota(rs.getString(9));
                vo.setNomuser(rs.getString(10));
                vo.setFechaReg(rs.getString(11));
                list.add(vo);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                //  ps.close();
                rs.close();
                // conec.desconectar();
            } catch (Exception ex) {

            }
        }
        return list;
    }

    //Permite mostrar PDF contenido en la base de datos
    public void visualizar_PdfVO(JTable tabla) {
        tabla.setDefaultRenderer(Object.class, new imgTabla());

        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("ID");
        dt.addColumn("Nombre Completo");
        dt.addColumn("No. Emp.");
        dt.addColumn("Fecha Inicio");
        dt.addColumn("Fecha Fin");
        dt.addColumn("Tipo de incidencia");
        dt.addColumn("Es justificada");
        dt.addColumn("Justificante");
        dt.addColumn("Nota");
        dt.addColumn("Fecha de registro");
        dt.addColumn("Usuario que registró");

        ImageIcon icono = null;
        if (get_Image("/com/icon/pdf30.png") != null) {
            icono = new ImageIcon(get_Image("/com/icon/pdf30.png"));
        }

        ModelReportarIncidencia vo = new ModelReportarIncidencia();
        ArrayList<ModelReportarIncidencia> list = this.Listar_PdfVO();

        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Object fila[] = new Object[11];
                vo = list.get(i);
                fila[0] = vo.getIdIncidencia();
                fila[1] = vo.getNombreEmp();
                fila[2] = vo.getNumEmp();
                fila[3] = vo.getFecha_de();
                fila[4] = vo.getFecha_hasta();
                fila[5] = vo.getTipoIncidencia();
                String yn = Integer.toString(vo.getEsJustificada());
                if (yn.equals("1")) {
                    yn = "SI";
                } else {
                    yn = "NO";
                }
                fila[6] = yn;

                if (vo.getArchivo() != null) {
                    fila[7] = new JButton(icono);
                } else {
                    fila[7] = new JButton("Vacio");
                }
                fila[8] = vo.getNota();
                fila[9] = vo.getFechaReg();
                fila[10] = vo.getNomuser();
                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(32);
        }
    }

    public Image get_Image(String ruta) {
        try {
            ImageIcon imageIcon = new ImageIcon(getClass().getResource(ruta));
            Image mainIcon = imageIcon.getImage();
            return mainIcon;
        } catch (Exception e) {
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        registros_mostrar = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        fechade = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        fechahasta = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_data = new javax.swing.JTable();
        rbPases = new javax.swing.JRadioButton();
        rbPermisos = new javax.swing.JRadioButton();
        rbIncidencias = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        txtBuscar = new com.swing.JCTextField();
        jLabel5 = new javax.swing.JLabel();
        buttonBadges1 = new com.swing.ButtonBadges();
        btnExcel1 = new javax.swing.JButton();

        setOpaque(false);
        setLayout(new java.awt.GridBagLayout());

        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("*Seleccione el periodo de fecha a mostrar");

        fechade.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel2.setText("Desde");

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel3.setText("Hasta");

        fechahasta.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tbl_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_dataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_data);

        rbPases.setBackground(new java.awt.Color(204, 204, 255));
        registros_mostrar.add(rbPases);
        rbPases.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rbPases.setText("Pases de salida");

        rbPermisos.setBackground(new java.awt.Color(255, 204, 255));
        registros_mostrar.add(rbPermisos);
        rbPermisos.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rbPermisos.setText("Persmisos económicos");

        rbIncidencias.setBackground(new java.awt.Color(204, 255, 204));
        registros_mostrar.add(rbIncidencias);
        rbIncidencias.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rbIncidencias.setText("Incidencias reportadas");

        jLabel4.setFont(new java.awt.Font("Poppins", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("*Seleccione que registros desea mostrar");

        txtBuscar.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txtBuscar.setMinimumSize(new java.awt.Dimension(180, 30));
        txtBuscar.setPlaceholder("Buscar...");
        txtBuscar.setPreferredSize(new java.awt.Dimension(200, 14));
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/search_30px.png"))); // NOI18N

        buttonBadges1.setBackground(new java.awt.Color(255, 153, 0));
        buttonBadges1.setForeground(new java.awt.Color(255, 255, 255));
        buttonBadges1.setText("Mostrar");
        buttonBadges1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        buttonBadges1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBadges1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rbPases)
                                .addGap(11, 11, 11)
                                .addComponent(rbPermisos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbIncidencias))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fechade, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addGap(29, 29, 29)
                                .addComponent(fechahasta, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 138, Short.MAX_VALUE)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(buttonBadges1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbPases)
                            .addComponent(rbPermisos)
                            .addComponent(rbIncidencias)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(fechade, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                        .addComponent(fechahasta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(buttonBadges1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 138;
        gridBagConstraints.ipady = 373;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jPanel1, gridBagConstraints);

        btnExcel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/microsoft_excel_2019_30px.png"))); // NOI18N
        btnExcel1.setText("Exportar a Excel");
        btnExcel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcel1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 899, 5, 0);
        add(btnExcel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcel1ActionPerformed
        ExportarExcel ex = new ExportarExcel();
        try {
            ex.exportarExcel(tbl_data);

        } catch (IOException ex1) {
            JOptionPane.showMessageDialog(null, ex1.getMessage());
        }
    }//GEN-LAST:event_btnExcel1ActionPerformed

    private void tbl_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dataMouseClicked
        if (rbIncidencias.isSelected()) {
            int column = tbl_data.getColumnModel().getColumnIndexAtX(evt.getX());
            int row = evt.getY() / tbl_data.getRowHeight();
            //activa_boton(false, true, true);
            // txtname.setEnabled(true);
            if (row < tbl_data.getRowCount() && row >= 0 && column < tbl_data.getColumnCount() && column >= 0) {
                int id = (int) tbl_data.getValueAt(row, 0);

                Object value = tbl_data.getValueAt(row, column);
                if (value instanceof JButton) {
                    ((JButton) value).doClick();
                    JButton boton = (JButton) value;

                    if (boton.getText().equals("Vacio")) {
                        JOptionPane.showMessageDialog(null, "No hay archivo");
                    } else {

                        dao.ejecutar_archivoPDF(id);
                        try {
                            Desktop.getDesktop().open(new File("new.pdf"));
                        } catch (Exception ex) {
                        }
                    }

                }
            }
        }

    }//GEN-LAST:event_tbl_dataMouseClicked

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        DefaultTableModel modelt = (DefaultTableModel) tbl_data.getModel();
        String query = txtBuscar.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modelt);
        tbl_data.setRowSorter(tr);
        if (query != "") {
            tr.setRowFilter(RowFilter.regexFilter("(?i)" + query));
            //rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        } else {
            tbl_data.setRowSorter(tr);
        }
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void buttonBadges1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBadges1ActionPerformed
        if ((!rbPases.isSelected() && !rbPermisos.isSelected() && !rbIncidencias.isSelected())) {
            JOptionPane.showMessageDialog(null, "Seleccione una opción");
        } else {
            if (rbPases.isSelected()) {
                mostrarPases(tbl_data);
            } else if (rbPermisos.isSelected()) {
                mostrarRegistros(tbl_data);
            } else if (rbIncidencias.isSelected()) {
                visualizar_PdfVO(tbl_data);
            }
        }

    }//GEN-LAST:event_buttonBadges1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcel1;
    private com.swing.ButtonBadges buttonBadges1;
    private com.toedter.calendar.JDateChooser fechade;
    private com.toedter.calendar.JDateChooser fechahasta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbIncidencias;
    private javax.swing.JRadioButton rbPases;
    private javax.swing.JRadioButton rbPermisos;
    private javax.swing.ButtonGroup registros_mostrar;
    private javax.swing.JTable tbl_data;
    private com.swing.JCTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
