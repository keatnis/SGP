
package com.vista;

import com.DAO.ListadoDAO;
import com.classes.ExportarExcel;
import java.awt.print.PrinterException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;



public class Directorio extends javax.swing.JPanel {

   ListadoDAO dao = new ListadoDAO();
    public Directorio() {
        initComponents();
        listDirectorio(tbl_directorio);
    }

  public void listDirectorio(JTable tabla) {

        DefaultTableModel dt = (DefaultTableModel) tabla.getModel();
       
        int numReg = dao.directorio().size();
        Object[] columna = new Object[5];

        for (int i = 0; i < numReg; i++) {
            columna[0] = dao.directorio().get(i).getNombres();
            columna[1] = dao.directorio().get(i).getDirección();
            columna[2] = dao.directorio().get(i).getTelefono();
            columna[3] = dao.directorio().get(i).getCorreoInst();
            columna[4] = dao.directorio().get(i).getTelefonoCE();
//            columna[5] = dao.directorio().get(i).getEdaddh() + " año (s) y " + dao.listDerechohabiente().get(i).getEdadMesesdh() + " meses";
//            columna[6] = dao.directorio().get(i).getStatus();
            dt.addRow(columna);
        }

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolbar = new javax.swing.JToolBar();
        btnPDF = new javax.swing.JButton();
        btnExcel = new javax.swing.JButton();
        txtBuscar = new com.swing.JCTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_directorio = new javax.swing.JTable();

        setOpaque(false);

        toolbar.setToolTipText("");
        toolbar.setMargin(new java.awt.Insets(10, 10, 10, 10));
        toolbar.setOpaque(false);

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/search_30px.png"))); // NOI18N
        toolbar.add(jLabel1);

        tbl_directorio.setAutoCreateRowSorter(true);
        tbl_directorio.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tbl_directorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Dirección", "Teléfono", "Correo", "Contacto de Emergencia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_directorio);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(toolbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(toolbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFActionPerformed
     DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal.getTime()));
        String reporte = JOptionPane.showInputDialog(null, "Escriba el tìtulo de la hoja");

        try {
            MessageFormat headerFormat = new MessageFormat("Reportes de " + reporte);

            MessageFormat footerFormat = new MessageFormat(dateFormat.format(cal.getTime()));

            tbl_directorio.print(JTable.PrintMode.FIT_WIDTH, headerFormat, footerFormat);
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnPDFActionPerformed

    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed
      ExportarExcel ex= new ExportarExcel();
        try {
            ex.exportarExcel(tbl_directorio);
            
        } catch (IOException ex1) {
            JOptionPane.showMessageDialog(null, ex1.getMessage());
        }
    }//GEN-LAST:event_btnExcelActionPerformed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
       DefaultTableModel modelt = (DefaultTableModel) tbl_directorio.getModel();
        String query = txtBuscar.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modelt);
        tbl_directorio.setRowSorter(tr);
        if (query != "") {
            tr.setRowFilter(RowFilter.regexFilter("(?i)"+query)); 
   //rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        } else {
            tbl_directorio.setRowSorter(tr);
        }

    }//GEN-LAST:event_txtBuscarKeyTyped


  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton btnPDF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_directorio;
    private javax.swing.JToolBar toolbar;
    private com.swing.JCTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
