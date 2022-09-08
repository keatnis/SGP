/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.component;

import com.classes.ExportarExcel;
import com.connection.Conexion;
import com.model.ModelPermisoEconomico;
import java.awt.print.PrinterException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class RegistrosPermisos extends javax.swing.JDialog {

    public RegistrosPermisos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        String[] meses = {" ", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        cmbMes.setModel(new javax.swing.DefaultComboBoxModel<>(meses));
        cmbAño.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026" }));
        mostrarRegistros(table_registros);
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
        dt.addColumn("Fecha de registro");
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

    public ArrayList<ModelPermisoEconomico> listarRegistros() {
       String sql;
        int mescmb = cmbMes.getSelectedIndex();
        String año = (String) cmbAño.getSelectedItem();
        ArrayList<ModelPermisoEconomico> list = new ArrayList<>();
        Conexion con = new Conexion();
        Connection conn = con.getConnection();
        
        if(mescmb==0){
           
               sql= "SELECT num_empleado,concat(abrev_nombre, ' ',nombre,' ',ape_paterno,' ',ape_materno,' ')as nombre,categoria,tipo_contratacion,plantel, fecha_solicitada,fecha_de,fecha_al,dias\n"
                + "FROM tbl_permiso_economico\n"
                + "INNER JOIN tbl_empleado ON tbl_empleado.id_empleado=tbl_permiso_economico.id_empleado\n"
                + "inner JOIN tbl_empleo ON tbl_permiso_economico.id_empleado =tbl_empleo.id_empleado\n"
                + "where  year(fecha_solicitada)='"+ año +"' order by plantel desc;";
        }else{
            sql = "SELECT num_empleado,concat(abrev_nombre, ' ',nombre,' ',ape_paterno,' ',ape_materno,' ')as nombre,categoria,tipo_contratacion,plantel, fecha_solicitada,fecha_de,fecha_al,dias\n"
                + "FROM tbl_permiso_economico\n"
                + "INNER JOIN tbl_empleado ON tbl_empleado.id_empleado=tbl_permiso_economico.id_empleado\n"
                + "inner JOIN tbl_empleo ON tbl_permiso_economico.id_empleado =tbl_empleo.id_empleado\n"
                + "where MONTH(fecha_solicitada)=" + mescmb + " and year(fecha_solicitada)='"+ año +"' order by plantel desc;";
        }
        
        ResultSet rs1 = null;
        ResultSet rs2;
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table_registros = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jSplitPane1 = new javax.swing.JSplitPane();
        toolbar = new javax.swing.JToolBar();
        btnPDF = new javax.swing.JButton();
        btnExcel = new javax.swing.JButton();
        txtBuscar = new com.swing.JCTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cmbMes = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cmbAño = new javax.swing.JComboBox<>();
        btnMostrar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        table_registros.setAutoCreateRowSorter(true);
        table_registros.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        table_registros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table_registros);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registros de los permisos económicos por mes y año");

        toolbar.setToolTipText("");
        toolbar.setMargin(new java.awt.Insets(10, 10, 10, 10));

        btnPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/pdf30.png"))); // NOI18N
        btnPDF.setText("Exportar PDF");
        btnPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPDFActionPerformed(evt);
            }
        });
        toolbar.add(btnPDF);

        btnExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/microsoft_excel_2019_30px.png"))); // NOI18N
        btnExcel.setText("Exportar a Excel");
        btnExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelActionPerformed(evt);
            }
        });
        toolbar.add(btnExcel);

        txtBuscar.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txtBuscar.setPlaceholder("Buscar...");
        txtBuscar.setPreferredSize(new java.awt.Dimension(200, 14));
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });
        toolbar.add(txtBuscar);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/search_30px.png"))); // NOI18N
        toolbar.add(jLabel4);

        jSplitPane1.setLeftComponent(toolbar);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mes");
        jSplitPane1.setRightComponent(jLabel2);

        cmbMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Año");

        cmbAño.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026" }));

        btnMostrar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnMostrar.setForeground(new java.awt.Color(0, 102, 102));
        btnMostrar.setText("Mostrar");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Mes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel5)
                .addGap(10, 10, 10)
                .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(cmbAño, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btnMostrar))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(cmbAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnMostrar, cmbAño, cmbMes});

        jSplitPane1.setRightComponent(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1064, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        mostrarRegistros(table_registros);
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void btnPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFActionPerformed
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Calendar cal = Calendar.getInstance();
    
        String reporte = JOptionPane.showInputDialog(null, "Escriba el tìtulo de la hoja");

        try {
            MessageFormat headerFormat = new MessageFormat("Reportes de " + reporte);

            MessageFormat footerFormat = new MessageFormat(dateFormat.format(cal.getTime()));

            table_registros.print(JTable.PrintMode.FIT_WIDTH, headerFormat, footerFormat);
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnPDFActionPerformed

    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed
        ExportarExcel ex= new ExportarExcel();
        try {
            ex.exportarExcel(table_registros);

        } catch (IOException ex1) {
            JOptionPane.showMessageDialog(null, ex1.getMessage());
        }
    }//GEN-LAST:event_btnExcelActionPerformed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        DefaultTableModel modelt = (DefaultTableModel) table_registros.getModel();
        String query = txtBuscar.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modelt);
        table_registros.setRowSorter(tr);
        if (query != "") {
            tr.setRowFilter(RowFilter.regexFilter("(?i)"+query));
            //rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        } else {
            table_registros.setRowSorter(tr);
        }
    }//GEN-LAST:event_txtBuscarKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnPDF;
    public javax.swing.JComboBox<String> cmbAño;
    public javax.swing.JComboBox<String> cmbMes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable table_registros;
    private javax.swing.JToolBar toolbar;
    private com.swing.JCTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
