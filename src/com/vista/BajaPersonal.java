package com.vista;

import com.DAO.BajaPersonalDAO;

import com.model.ModelBajaPersonal;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class BajaPersonal extends javax.swing.JPanel {

    ModelBajaPersonal model = new ModelBajaPersonal();
    BajaPersonalDAO dao = new BajaPersonalDAO();
    String rutaArchivo;

    public BajaPersonal() {
        initComponents();
    }

    private void guardarStatus() throws FileNotFoundException {
        int idemp = dao.idEmpleado(txtNumEmp.getText());
        model.setId_emp(idemp);
        String motivo = (String) cmbMotivo.getSelectedItem();
        model.setMotivoSalida(motivo);
        SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
        String fechabaja = (formatofecha.format(txtFechaBaja.getDate()));
        model.setFecha(fechabaja);
        model.setNotas(txtNotas.getText());

        if (dao.registrar(model)==true) {
            dao.actualizarStatus(idemp);
             JOptionPane.showMessageDialog(null, "Status Actualizado");
        } else {
            JOptionPane.showMessageDialog(null, "Este Empleado/a ya esta dado de baja");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        txtNumEmp = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbMotivo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNotas = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        buttonBadges1 = new com.swing.ButtonBadges();
        txtFechaBaja = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        btnArchivo = new javax.swing.JButton();
        lbIconCheck = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        txtNumEmp.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel2.setText("Número de Empleado");

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel3.setText("Motivo de Salida");

        cmbMotivo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbMotivo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Separación Voluntaria", "Término de Contrato", "Ausentismo", "Otro" }));

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel4.setText("Notas");

        jScrollPane1.setToolTipText("Escribe un comentario que describa el motivo");

        txtNotas.setColumns(20);
        txtNotas.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtNotas.setRows(5);
        txtNotas.setText("Escriba un comentario que describa el motivo");
        txtNotas.setToolTipText("");
        txtNotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNotasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(txtNotas);

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel5.setText("Fecha");

        buttonBadges1.setBackground(new java.awt.Color(31, 44, 81));
        buttonBadges1.setForeground(new java.awt.Color(255, 255, 255));
        buttonBadges1.setText("Ver");
        buttonBadges1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        buttonBadges1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBadges1ActionPerformed(evt);
            }
        });

        txtFechaBaja.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButton1.setBackground(new java.awt.Color(31, 44, 81));
        jButton1.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnArchivo.setText("Archivo");
        btnArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonBadges1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNumEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbMotivo, 0, 182, Short.MAX_VALUE)
                            .addComponent(txtFechaBaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbIconCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtNumEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtFechaBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbIconCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonBadges1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 54;
        gridBagConstraints.ipady = 42;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jPanel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNotasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNotasMouseClicked
        txtNotas.setText("");

    }//GEN-LAST:event_txtNotasMouseClicked

    private void btnArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchivoActionPerformed
        // Inicia el JFileChooser
        JFileChooser fc = new JFileChooser();
        // Se crea un filtro de extensiones para que solamente pueda seleccionar archivos PDF
        FileFilter ff = new FileNameExtensionFilter("Archivo PDF", "pdf");
        // Se asigna el filtro al objeto JFileChooser
        fc.setFileFilter(ff);
        // Se muestra la ventana de JFilChooser

        int opcionav = fc.showOpenDialog(this);
        if (opcionav == JFileChooser.APPROVE_OPTION) {
            // Se asigna el archivo seleccionado a un objeto tipo File
            File archivoPDF = fc.getSelectedFile();
            rutaArchivo = archivoPDF.getAbsolutePath();
            try {
                byte[] pdf = new byte[(int) rutaArchivo.length()];
                InputStream input = new FileInputStream(rutaArchivo);
                input.read(pdf);

                if (rutaArchivo.isEmpty()) {

                    lbIconCheck.setIcon(null);
                    lbIconCheck.repaint();
                } else {
                    model.setArchivo(pdf);
                    lbIconCheck.setIcon(new ImageIcon("src/com/icon/check_circle_20px.png"));
                }

            } catch (IOException ex) {
                model.setArchivo(null);
                //System.out.println("Error al agregar archivo pdf "+ex.getMessage());
            }
            // Se sustituye la ruta por la ruta absoluta obtenida del objeto File
            int opcionpdf = JOptionPane.showConfirmDialog(null, "¿Quiere ver el Formato FUMP agregado?", "Archivo", JOptionPane.YES_NO_OPTION);
            if (opcionpdf == 0) {
                try {
                    Process p = Runtime.getRuntime().exec("rundll32 SHELL32.DLL,"
                            + "ShellExec_RunDLL " + rutaArchivo);
                } catch (Exception evvv) {
                    JOptionPane.showMessageDialog(null, "No se puede abrir el archivo de ayuda,"
                            + " probablemente fue borrado", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            lbIconCheck.setIcon(null);
            lbIconCheck.repaint();
            model.setArchivo(null);
        }

    }//GEN-LAST:event_btnArchivoActionPerformed

    private void buttonBadges1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBadges1ActionPerformed
  
    }//GEN-LAST:event_buttonBadges1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          try {
            if (rutaArchivo == null) {

                lbIconCheck.setIcon(null);
                lbIconCheck.repaint();
                model.setArchivo(null);
            }
            guardarStatus();
           
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BajaPersonal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArchivo;
    private com.swing.ButtonBadges buttonBadges1;
    private javax.swing.JComboBox<String> cmbMotivo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbIconCheck;
    private com.toedter.calendar.JDateChooser txtFechaBaja;
    private javax.swing.JTextArea txtNotas;
    private javax.swing.JTextField txtNumEmp;
    // End of variables declaration//GEN-END:variables
}
