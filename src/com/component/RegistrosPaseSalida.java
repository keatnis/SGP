package com.component;

import com.DAO.PaseSalidaDAO;
import com.classes.ExportarExcel;
import com.classes.Render;
import com.model.ModelPaseSalida;
import java.awt.print.PrinterException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RegistrosPaseSalida extends javax.swing.JDialog {

    PaseSalidaDAO dao = new PaseSalidaDAO();

    public RegistrosPaseSalida(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        mostrarRegistros(TableRegistro);

    }

    public void mostrarRegistros(JTable tabla) {

        tabla.setDefaultRenderer(Object.class, new Render());

        JButton btn1 = new JButton();
        btn1.setName("obs");
        btn1.setIcon(new ImageIcon(getClass().getResource("/com/icon/edit.png")));
        JButton btn2 = new JButton("Eliminar");
        btn2.setName("delete");
        btn2.setIcon(new ImageIcon(getClass().getResource("/com/icon/Delete.png")));

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
        dt.addColumn("Añadir Obsv.");
        // dt.addColumn("Opcion eliminar");

        ModelPaseSalida vo;
        ArrayList<ModelPaseSalida> list = dao.listarRegistros();

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
                fila[7] = btn1;
                //   fila[8] = btn2;
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableRegistro = new javax.swing.JTable();
        lblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/microsoft_excel_2019_30px.png"))); // NOI18N
        jButton1.setText("Excel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/pdf30.png"))); // NOI18N
        btnExportar.setText("Exportar");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        TableRegistro.setModel(new javax.swing.table.DefaultTableModel(
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
        TableRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableRegistroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableRegistro);

        lblTitulo.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblTitulo.setText("Registro de pases de salida");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 276, Short.MAX_VALUE)
                .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(306, 306, 306))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(385, 385, 385))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblTitulo)
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExportar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal.getTime()));
        String reporte = JOptionPane.showInputDialog(null, "Escriba el tìtulo de la hoja");

        try {
            MessageFormat headerFormat = new MessageFormat("Reportes de " + reporte);

            MessageFormat footerFormat = new MessageFormat(dateFormat.format(cal.getTime()));

            TableRegistro.print(JTable.PrintMode.FIT_WIDTH, headerFormat, footerFormat);
        } catch (PrinterException ex) {
            Logger.getLogger(RegistrosPaseSalida.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnExportarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ExportarExcel ex = new ExportarExcel();
        try {
            ex.exportarExcel(TableRegistro);

        } catch (IOException ex1) {
            JOptionPane.showMessageDialog(null, ex1.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TableRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableRegistroMouseClicked
        int column = TableRegistro.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / TableRegistro.getRowHeight();

        if (row < TableRegistro.getRowCount() && row >= 0 && column < TableRegistro.getColumnCount() && column >= 0) {
            Object value = TableRegistro.getValueAt(row, column);
            if (value instanceof JButton) {
                ((JButton) value).doClick();
                JButton boton = (JButton) value;

                if (boton.getName().equals("obs")) {
                    int filaEditar = TableRegistro.getSelectedRow();
                    int numFS = TableRegistro.getSelectedRowCount();
                    String obs = JOptionPane.showInputDialog(null, "Escriba la observación que desea agregar");
                    if (filaEditar >= 0 && numFS == 1) {
                       if(obs != null){
                         String folio = String.valueOf(TableRegistro.getValueAt(filaEditar, 3));
                          dao.addObsv(folio, obs);
                           mostrarRegistros(TableRegistro);
                            
                       }else{
                           JOptionPane.showMessageDialog(null, "No se agregó ningúna observación");
                       }
                        
                    }

                }

            }
        }
    }//GEN-LAST:event_TableRegistroMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable TableRegistro;
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
