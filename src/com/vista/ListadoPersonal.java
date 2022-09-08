package com.vista;

import com.DAO.ConsultasJAP;
import com.DAO.ListadoDAO;
import com.classes.ExportarExcel;
import com.table.status.Tabla2;
import java.awt.print.PrinterException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

public class ListadoPersonal extends javax.swing.JPanel {

    ListadoDAO dao = new ListadoDAO();

    public ListadoPersonal() {
        initComponents();

        init();
        visualizar_PdfVO(table_data);
        // LlenarTabla(table_data);

    }

//    public ArrayList<ModelPersonalN> listado() {
//        ArrayList listaPersonal = new ArrayList();
//        Conexion con = new Conexion();
//        PreparedStatement psql;
//        ResultSet rs;
//        Connection conn = con.getConnection();
//
//        ModelPersonalN personal;
//
//        String SentenciaSQL = "SELECT num_empleado,concat(abrev_nombre,' ',nombre,' ',ape_paterno,' ',ape_materno)nombre,genero,area_adscripcion,puesto,fecha_ingreso,fecha_term_contrato,\n"
//                + " FLOOR(CAST(TIMESTAMPDIFF(day,fecha_ingreso, curdate()) AS float) / 365.25) AS anios_ant,\n"
//                + " FLOOR((CAST(TIMESTAMPDIFF(day,fecha_ingreso, curdate()) AS float) / 365.25 - FLOOR(CAST(TIMESTAMPDIFF(day,fecha_ingreso,curdate()) AS float) / 365.25)) * 12) AS meses_ant,tipo_contratacion,status,categoria\n"
//                + "FROM tbl_empleo INNER JOIN tbl_empleado  ON tbl_empleado.id_empleado=tbl_empleo.id_empleado "
//                + " where area_adscripcion LIKE '" + filtroArea.getSelectedItem() + "' and puesto LIKE '" + filtroPuesto.getSelectedItem() + "' and tipo_contratacion like '" + filtroTipo.getSelectedItem() + "'"
//                + " and categoria like '" + cmbCategoria.getSelectedItem() + "';";
//
//        try {
//            psql = conn.prepareStatement(SentenciaSQL);
//            rs = psql.executeQuery();
//            while (rs.next()) {
//                personal = new ModelPersonalN();
//
//                personal.setNumEmpleado(rs.getString(1));
//                personal.setNombres(rs.getString(2));
//                personal.setSexo(rs.getString(3));
//                personal.setAreaAdscripción(rs.getString(4));
//                personal.setPuesto(rs.getString(5));
//                personal.setFechaIngreso(rs.getString(6));
//                personal.setFechaTerminoCont(rs.getString(7));
//
//                int antA = rs.getInt(8);
//                int antM = rs.getInt(9);
//                if (antA < 0) {
//                    antM = 0;
//                    antA = 0;
//                }
//                personal.setAnt_añoI(antA);
//                personal.setAntmesesI(antM);
//                personal.setTipoContratacion(rs.getString(10));
//                //  personal.setStatus(rs.getString(9));
//                if (rs.getString(11).equals("1")) {
//                    personal.setStatus("Activo");
//                } else {
//                    personal.setStatus("Inactivo");
//                }
//                personal.setCategoria(rs.getString(12));
//                listaPersonal.add(personal);
//            }
//        } catch (SQLException e) {
//            System.err.println(e);
//        } finally {
//            try {
//                if (conn != null) {
//                    con.cerrar();
//                }
//            } catch (SQLException ex) {
//
//                JOptionPane.showMessageDialog(null, "Error al intentar cerrar la conexión:\n"
//                        + ex, "Error en la operación", JOptionPane.ERROR_MESSAGE);
//            }
//        }
//        return listaPersonal;
//    }
    private void init() {
        ConsultasJAP jap = new ConsultasJAP();
        jap.ObteberArea2(filtroArea);
        jap.ObteberPuestos2(filtroPuesto);

    }

    public void visualizar_PdfVO(JTable tabla) {
        // tabla.setDefaultRenderer(Object.class, new imgTabla());
        JLabel lb = new JLabel();

        Tabla2 miRender = new Tabla2();
        tabla.setDefaultRenderer(Object.class, miRender);
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("NÚM. EMP");
        dt.addColumn("NOMBRE");
        dt.addColumn("SEXO");
        dt.addColumn("ÁREA DE ADSCRIPCIÓN");
        dt.addColumn("PUESTO/CARGO");
        dt.addColumn("CATEGORÍA");
        dt.addColumn("FECHA INGRESO");
        dt.addColumn("FECHA TERMINO");
        dt.addColumn("ANTIGÜEDAD");
        dt.addColumn("N/H");
        dt.addColumn("ESTATUS");

        int numReg = dao.listado().size();

        Object[] columna = new Object[11];

        for (int i = 0; i < numReg; i++) {
            columna[0] = dao.listado().get(i).getNumEmpleado();
            columna[1] = dao.listado().get(i).getNombres();
            columna[2] = dao.listado().get(i).getSexo();
            columna[3] = dao.listado().get(i).getAreaAdscripción();
            columna[4] = dao.listado().get(i).getPuesto();
            columna[5] = dao.listado().get(i).getCategoria();
            columna[6] = dao.listado().get(i).getFechaIngreso();
            //    columna[7] = dao.listado().get(i).getFechaTerminoCont()  
//            if (dao.listado().get(i).getFechaTerminoCont() == null) {
//                columna[7] = dao.listado().get(i).getFechaTerminoCont();
//            }else if (dao.listado().get(i).getFechaTerminoCont() != null || dao.listado().get(i).getFechaTerminoCont().equals("N/A")) {
//                columna[7] = this.cal(dao.listado().get(i).getFechaTerminoCont());
//            }
            columna[7] = dao.listado().get(i).getFechaTerminoCont();
            columna[8] = dao.listado().get(i).getAnt_añoI() + " Año (s) y " + dao.listado().get(i).getAntmesesI() + " meses";
            columna[9] = dao.listado().get(i).getTipoContratacion();
            columna[10] = dao.listado().get(i).getStatus();
            //     txtnombrep.setText(dao.listado().get(0).getNombres());

            //    table_data.set
            int total = tabla.getRowCount();
            String totalLista = Integer.toString(total);
            lbTotal.setText(totalLista);

//               
            dt.addRow(columna);
        }
        tabla.setModel(dt);

        tabla.setRowHeight(32);

        int[] anchos = {60, 230, 70, 250, 250, 150, 120, 120, 160, 60, 90};
        for (int i = 0; i < tabla.getColumnCount(); i++) {
            //    table_data.set
            tabla.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabla.doLayout();
    }

    private String cal(String res) {

        LocalDateTime date_of_today = LocalDateTime.now();
        DateTimeFormatter format_date_of_today = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = date_of_today.format(format_date_of_today);
        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
        // Date date2 = sdformat.parse(res);
        if (formattedDate.compareTo(res) > 0) {
            res = "CVencido";
        }

        return res;
    }

    public void LlenarTabla(JTable tablaD) {

        DefaultTableModel modelt = (DefaultTableModel) tablaD.getModel();

        int numReg = dao.listado().size();

        Object[] columna = new Object[11];

        for (int i = 0; i < numReg; i++) {
            columna[0] = dao.listado().get(i).getNumEmpleado();
            columna[1] = dao.listado().get(i).getNombres();
            columna[2] = dao.listado().get(i).getSexo();
            columna[3] = dao.listado().get(i).getAreaAdscripción();
            columna[4] = dao.listado().get(i).getPuesto();
            columna[5] = dao.listado().get(i).getCategoria();
            columna[6] = dao.listado().get(i).getFechaIngreso();
            columna[7] = dao.listado().get(i).getFechaTerminoCont();
            columna[8] = dao.listado().get(i).getAnt_añoI() + " Año (s) y " + dao.listado().get(i).getAntmesesI() + " meses";
            columna[9] = dao.listado().get(i).getTipoContratacion();
            columna[10] = dao.listado().get(i).getStatus();
            //     txtnombrep.setText(dao.listado().get(0).getNombres());

            //    table_data.set
            int total = tablaD.getRowCount();
            String totalLista = Integer.toString(total);
            lbTotal.setText(totalLista);

        }
        modelt.addRow(columna);
        int[] anchos = {55, 150, 50, 200, 200, 88, 100, 100, 150, 100, 80};
        for (int j = 0; j < tablaD.getColumnCount(); j++) {
            tablaD.getColumnModel().getColumn(j).setPreferredWidth(anchos[j]);
        }
    }

//    public void LlenarTabla2(JTable tablaD) {
//
//        DefaultTableModel modelt = (DefaultTableModel) tablaD.getModel();
//        //  tablaD.a
//        int numReg = this.listado().size();
//
//        Object[] columna = new Object[11];
//
//        for (int i = 0; i < numReg; i++) {
//            columna[0] = this.listado().get(i).getNumEmpleado();
//            columna[1] = this.listado().get(i).getNombres();
//            columna[2] = this.listado().get(i).getSexo();
//            columna[3] = this.listado().get(i).getAreaAdscripción();
//            columna[4] = this.listado().get(i).getPuesto();
//            columna[5] = this.listado().get(i).getCategoria();
//            columna[6] = this.listado().get(i).getFechaIngreso();
//            columna[7] = this.listado().get(i).getFechaTerminoCont();
//            columna[8] = this.listado().get(i).getAnt_añoI() + " Año (s) y " + dao.listado().get(i).getAntmesesI() + " meses";
//            columna[9] = this.listado().get(i).getTipoContratacion();
//            columna[10] = this.listado().get(i).getStatus();
//            //     txtnombrep.setText(dao.listado().get(0).getNombres());
//            modelt.addRow(columna);
//            int total = tablaD.getRowCount();
//            String totalLista = Integer.toString(total);
//            lbTotal.setText(totalLista);
//        }
//
//    }
    public void eliminar(JTable tabla) {
        DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
        int a = tabla.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        totalRows = new javax.swing.JLabel();
        filtroArea = new javax.swing.JComboBox<>();
        btnExportar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        filtroPuesto = new javax.swing.JComboBox<>();
        lbTotal = new javax.swing.JLabel();
        filtroTipo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        filtroGenero = new javax.swing.JComboBox<>();
        cmbCategoria = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtBuscar = new com.swing.JCTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_data = new javax.swing.JTable();

        setMinimumSize(new java.awt.Dimension(1189, 723));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1289, 723));

        filtroArea.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        filtroArea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        filtroArea.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filtroAreaItemStateChanged(evt);
            }
        });

        btnExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/pdf30.png"))); // NOI18N
        btnExportar.setText("Exportar tabla");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/microsoft_excel_2019_30px.png"))); // NOI18N
        jButton1.setText("Excel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        filtroPuesto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        filtroPuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        filtroPuesto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filtroPuestoItemStateChanged(evt);
            }
        });

        lbTotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbTotal.setForeground(null);
        lbTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTotal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        filtroTipo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        filtroTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Nómina", "Honorarios" }));
        filtroTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filtroTipoItemStateChanged(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Tipo");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Área");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Puesto");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(null);
        jLabel5.setText("TOTAL:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Sexo");

        filtroGenero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        filtroGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "H", "M" }));
        filtroGenero.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filtroGeneroItemStateChanged(evt);
            }
        });

        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Directivo", "Administrativo", "Servicios Generales", "Docente", "Honorarios" }));
        cmbCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCategoriaItemStateChanged(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Categoría");

        txtBuscar.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txtBuscar.setPlaceholder("Buscar...");
        txtBuscar.setPreferredSize(new java.awt.Dimension(200, 14));
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/search_30px.png"))); // NOI18N

        jScrollPane1.setPreferredSize(new java.awt.Dimension(582, 402));

        table_data.setAutoCreateRowSorter(true);
        table_data.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table_data);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(42, 42, 42))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filtroArea, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filtroPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel8))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filtroTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filtroGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 281, Short.MAX_VALUE)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addGap(57, 57, 57))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(totalRows)
                        .addGap(51, 51, 51))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cmbCategoria, filtroTipo});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(totalRows)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(filtroArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(filtroTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(filtroPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8)
                                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(filtroGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(btnExportar)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cmbCategoria, filtroTipo});

    }// </editor-fold>//GEN-END:initComponents

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal.getTime()));
        String reporte = JOptionPane.showInputDialog(null, "Escriba el tìtulo de la hoja");

        try {
            MessageFormat headerFormat = new MessageFormat("Reportes de " + reporte);

            MessageFormat footerFormat = new MessageFormat(dateFormat.format(cal.getTime()));

            table_data.print(JTable.PrintMode.NORMAL, headerFormat, footerFormat);
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnExportarActionPerformed

    private void filtroAreaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filtroAreaItemStateChanged
        DefaultTableModel modelt = (DefaultTableModel) table_data.getModel();

        String cadena = (String) filtroArea.getSelectedItem();

        String query = cadena;
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modelt);
        table_data.setRowSorter(tr);
        if (query != " ") {
            tr.setRowFilter(RowFilter.regexFilter("(?i)" + query));

        } else {
            table_data.setRowSorter(tr);
        }
        int total = table_data.getRowCount();
        String totalLista = Integer.toString(total);
        lbTotal.setText(totalLista);
    }//GEN-LAST:event_filtroAreaItemStateChanged

    private void filtroTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filtroTipoItemStateChanged
        DefaultTableModel modelt = (DefaultTableModel) table_data.getModel();
        String query = filtroTipo.getSelectedItem().toString();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modelt);
        table_data.setRowSorter(tr);
        if (query != " ") {
            tr.setRowFilter(RowFilter.regexFilter("(?i)" + query));
        } else {
            table_data.setRowSorter(tr);
        }
        int total = table_data.getRowCount();
        String totalLista = Integer.toString(total);
        lbTotal.setText(totalLista);
    }//GEN-LAST:event_filtroTipoItemStateChanged

    private void filtroPuestoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filtroPuestoItemStateChanged
        DefaultTableModel modelt = (DefaultTableModel) table_data.getModel();
        String query = filtroPuesto.getSelectedItem().toString();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modelt);
        table_data.setRowSorter(tr);
        if (query != " ") {
            tr.setRowFilter(RowFilter.regexFilter(query));
        } else {
            table_data.setRowSorter(tr);
        }
        int total = table_data.getRowCount();
        String totalLista = Integer.toString(total);
        lbTotal.setText(totalLista);
    }//GEN-LAST:event_filtroPuestoItemStateChanged

    private void filtroGeneroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filtroGeneroItemStateChanged
        DefaultTableModel modelt = (DefaultTableModel) table_data.getModel();
        String query = filtroGenero.getSelectedItem().toString();
        //    String query2 = filtroStatus.getSelectedItem().toString();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modelt);
        table_data.setRowSorter(tr);

        if (query != " ") {
            // tr.setRowFilter(RowFilter.regexFilter(query2));
            tr.setRowFilter(RowFilter.regexFilter(query, 2));
        } else {
            table_data.setRowSorter(tr);
        }
        int total = table_data.getRowCount();
        String totalLista = Integer.toString(total);
        lbTotal.setText(totalLista);
    }//GEN-LAST:event_filtroGeneroItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ExportarExcel ex = new ExportarExcel();
        try {
            ex.exportarExcel(table_data);

        } catch (IOException ex1) {
            JOptionPane.showMessageDialog(null, ex1.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmbCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCategoriaItemStateChanged

        DefaultTableModel modelt = (DefaultTableModel) table_data.getModel();
        String query = (String) cmbCategoria.getSelectedItem();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modelt);
        table_data.setRowSorter(tr);
        if (query != "") {
            tr.setRowFilter(RowFilter.regexFilter("(?i)" + query));
            //rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        } else {
            table_data.setRowSorter(tr);
        }
    }//GEN-LAST:event_cmbCategoriaItemStateChanged

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        DefaultTableModel modelt = (DefaultTableModel) table_data.getModel();
        String query = txtBuscar.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modelt);
        table_data.setRowSorter(tr);
        if (query != "") {
            tr.setRowFilter(RowFilter.regexFilter("(?i)" + query));
            //rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        } else {
            table_data.setRowSorter(tr);
        }
    }//GEN-LAST:event_txtBuscarKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportar;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> filtroArea;
    private javax.swing.JComboBox<String> filtroGenero;
    private javax.swing.JComboBox<String> filtroPuesto;
    private javax.swing.JComboBox<String> filtroTipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JTable table_data;
    private javax.swing.JLabel totalRows;
    private com.swing.JCTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
