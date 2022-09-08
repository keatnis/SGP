package com.component;

import com.DAO.IncidenciasDAO;
import com.classes.ExportarExcel;
import com.connection.Conexion;
import com.model.ModelReportarIncidencia;
import com.swing.imgTabla;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.print.PrinterException;
import java.io.File;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class RegistroIncidencia extends javax.swing.JDialog {

    IncidenciasDAO dao = new IncidenciasDAO();

    public RegistroIncidencia(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
         String[] meses = {" ", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        cmbMes.setModel(new javax.swing.DefaultComboBoxModel<>(meses));
        cmbAño.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026" }));
        visualizar_PdfVO(tbl_incidencias);
    }

    public ArrayList<ModelReportarIncidencia> Listar_PdfVO() {
        String sql;
        int mescmb = cmbMes.getSelectedIndex();
        String año = (String) cmbAño.getSelectedItem();
        ArrayList<ModelReportarIncidencia> list = new ArrayList<>();
        Conexion con = new Conexion();
        Connection conn = con.getConnection();
        if (mescmb == 0) {
            sql = "SELECT id_incidencia,concat(abrev_nombre,' ',nombre,' ',ape_materno,' ',ape_paterno)nombre,num_empleado,\n"
                    + "fecha_inicio,fecha_fin,tipo_incidencia,esjustificada,archivo,nota,usuario,fecha_registro\n"
                    + "FROM tbl_incidencia INNER JOIN tbl_empleado\n"
                    + " ON tbl_empleado.id_empleado=tbl_incidencia.id_empleado "
                    + "where year(fecha_registro)='" + año + "';";
        } else {
            sql = "SELECT id_incidencia,concat(abrev_nombre,' ',nombre,' ',ape_materno,' ',ape_paterno)nombre,num_empleado,\n"
                    + "fecha_inicio,fecha_fin,tipo_incidencia,esjustificada,archivo,nota,usuario,fecha_registro\n"
                    + "FROM tbl_incidencia INNER JOIN tbl_empleado\n"
                    + " ON tbl_empleado.id_empleado=tbl_incidencia.id_empleado "
                    + "where MONTH(fecha_registro)=" + mescmb + " and year(fecha_registro)='" + año + "';";
        }

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
        dt.addColumn("Usuario que registró");
        dt.addColumn("Fecha de registro");

        ImageIcon icono = null;
        if (get_Image("/com/icon/pdf30.png") != null) {
            icono = new ImageIcon(get_Image("/com/icon/pdf30.png"));
        }

        dao = new IncidenciasDAO();
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
                fila[9] = vo.getNomuser();
                fila[10] = vo.getFechaReg();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_incidencias = new javax.swing.JTable();
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
        setTitle("Registro de incidencias");

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tbl_incidencias.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        tbl_incidencias.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_incidencias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_incidenciasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_incidencias);

        jSplitPane1.setDividerSize(10);

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
        txtBuscar.setMinimumSize(new java.awt.Dimension(180, 30));
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

        btnMostrar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnMostrar.setForeground(new java.awt.Color(102, 0, 204));
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addGap(0, 8, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cmbAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jSplitPane1.setRightComponent(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1074, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1064, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 306, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_incidenciasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_incidenciasMouseClicked
        int column = tbl_incidencias.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / tbl_incidencias.getRowHeight();
        //activa_boton(false, true, true);
        // txtname.setEnabled(true);
        if (row < tbl_incidencias.getRowCount() && row >= 0 && column < tbl_incidencias.getColumnCount() && column >= 0) {
            int id = (int) tbl_incidencias.getValueAt(row, 0);

            Object value = tbl_incidencias.getValueAt(row, column);
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
    }//GEN-LAST:event_tbl_incidenciasMouseClicked

    private void btnPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFActionPerformed
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal.getTime()));
        String reporte = JOptionPane.showInputDialog(null, "Escriba el tìtulo de la hoja");

        try {
            MessageFormat headerFormat = new MessageFormat("Reportes de " + reporte);

            MessageFormat footerFormat = new MessageFormat(dateFormat.format(cal.getTime()));

            tbl_incidencias.print(JTable.PrintMode.FIT_WIDTH, headerFormat, footerFormat);
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnPDFActionPerformed

    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed
        ExportarExcel ex = new ExportarExcel();
        try {
            ex.exportarExcel(tbl_incidencias);

        } catch (IOException ex1) {
            JOptionPane.showMessageDialog(null, ex1.getMessage());
        }
    }//GEN-LAST:event_btnExcelActionPerformed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        DefaultTableModel modelt = (DefaultTableModel) tbl_incidencias.getModel();
        String query = txtBuscar.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modelt);
        tbl_incidencias.setRowSorter(tr);
        if (query != "") {
            tr.setRowFilter(RowFilter.regexFilter("(?i)" + query));
            //rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        } else {
            tbl_incidencias.setRowSorter(tr);
        }
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        visualizar_PdfVO(tbl_incidencias);
    }//GEN-LAST:event_btnMostrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnPDF;
    public javax.swing.JComboBox<String> cmbAño;
    public javax.swing.JComboBox<String> cmbMes;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable tbl_incidencias;
    private javax.swing.JToolBar toolbar;
    private com.swing.JCTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
