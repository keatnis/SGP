package com.vista;

import com.DAO.BajaPersonalDAO;
import com.classes.Validaciones;
import com.component.ListaPersonalBaja;

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
    File ruta;

    public BajaPersonal() {
        initComponents();
    }

    private void guardarStatus(File ruta) throws FileNotFoundException {
        
        int idemp = dao.idEmpleado(txtNumEmp.getText());
        model.setId_emp(idemp);
        String motivo = (String) cmbMotivo.getSelectedItem();
        model.setMotivoSalida(motivo);
        SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
        String fechabaja = (formatofecha.format(txtFechaBaja.getDate()));
        model.setFecha(fechabaja);
        model.setNotas(txtNotas.getText());

        if (ruta != null) {
            try {
                byte[] pdf = new byte[(int) ruta.length()];
                InputStream input = new FileInputStream(ruta);
                input.read(pdf);
                model.setArchivo(pdf);
                if (dao.registrar(model) == true) {
                    dao.actualizarStatus(idemp);
                    JOptionPane.showMessageDialog(null, "Status Actualizado: Empleado (a) dado de baja");
                } else {
                    JOptionPane.showMessageDialog(null, "Este Empleado/a ya esta dado de baja");
                }
            } catch (IOException ex) {
                //   model.setArchivo(null);
                JOptionPane.showMessageDialog(null, "Error al agregar archivo pdf " + ex.getMessage());
            }
        } else {
            int opcion = JOptionPane.showConfirmDialog(null, "No se ha agregado ningún archivo aún, desea agregarlo? ");
            if (opcion == 0) {
                agregar_pdf();
            } else {
                model.setArchivo(null);
            }
        }

    }
    void validar_campos(){
        Validaciones.esCajaVacia(txtNumEmp, "Campo Núm. Emp. Vacío");
        Validaciones.cmbNoSeleccionado(cmbMotivo, "Motivo no seleccionado");
        if(txtFechaBaja.getDate() == null){
            JOptionPane.showMessageDialog(null,"Fecha de baja no asignada");
            
        }
        if(ruta == null){
             JOptionPane.showMessageDialog(null,"No ha agregado ningún archivo");
        }
        
    }
    private void agregar_pdf() {
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
            ruta = new File(rutaArchivo);
            if (rutaArchivo.trim().length() != 0) {
                //                    byte[] pdf = new byte[(int) rutaArchivo.length()];
//                    InputStream input = new FileInputStream(rutaArchivo);
//                    input.read(pdf);
//                    model.setArchivo(pdf);
//                    model.setArchivo(pdf);
//  guardarStatus(ruta);
                lbIconCheck.setIcon(new javax.swing.ImageIcon(getClass().getResource("src/com/icon/check_circle_20px.png")));
            } else {
                lbIconCheck.setIcon(null);
                lbIconCheck.repaint();
            } //  model.setArchivo(null);

            // Se sustituye la ruta por la ruta absoluta obtenida del objeto File
            int opcionpdf = JOptionPane.showConfirmDialog(null, "¿Quiere ver el archivo agregado?", "Archivo", JOptionPane.YES_NO_OPTION);
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
        txtFechaBaja = new com.toedter.calendar.JDateChooser();
        btnArchivo = new javax.swing.JButton();
        lbIconCheck = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        buttonBadges1 = new com.swing.ButtonBadges();

        setOpaque(false);
        setLayout(new java.awt.GridBagLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txtNumEmp.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel2.setText("Número de Empleado");

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel3.setText("Motivo de Salida");

        cmbMotivo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbMotivo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Renuncia", "Separación Voluntaria", "Término de Contrato", "Ausentismo", "Fallecimiento", "Otro" }));

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel4.setText("Notas");

        jScrollPane1.setToolTipText("Escribe un comentario que describa el motivo");

        txtNotas.setColumns(20);
        txtNotas.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtNotas.setLineWrap(true);
        txtNotas.setRows(5);
        txtNotas.setToolTipText("Este apartado es para escribir una nota o comentario");
        txtNotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNotasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(txtNotas);

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel5.setText("Fecha");

        txtFechaBaja.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnArchivo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/pdf30.png"))); // NOI18N
        btnArchivo.setText("Añadir archivo");
        btnArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchivoActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/icons8-search-in-list-35.png"))); // NOI18N
        jButton2.setText("Ver registros");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        buttonBadges1.setBackground(new java.awt.Color(31, 44, 81));
        buttonBadges1.setForeground(new java.awt.Color(255, 255, 255));
        buttonBadges1.setText("Guardar");
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
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(buttonBadges1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(229, 229, 229))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbMotivo, 0, 182, Short.MAX_VALUE)
                                    .addComponent(txtFechaBaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNumEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                .addComponent(jButton2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbIconCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnArchivo, cmbMotivo, txtFechaBaja, txtNumEmp});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtNumEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(cmbMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addComponent(jLabel5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jButton2))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(txtFechaBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnArchivo)
                    .addComponent(lbIconCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(buttonBadges1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cmbMotivo, txtFechaBaja, txtNumEmp});

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
        agregar_pdf();
    }//GEN-LAST:event_btnArchivoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ListaPersonalBaja dialog = new ListaPersonalBaja(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                // System.exit(0);
                dialog.setVisible(false);
            }
        });
        dialog.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void buttonBadges1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBadges1ActionPerformed
    try {
            validar_campos();
            if (rutaArchivo == null) {

                lbIconCheck.setIcon(null);
                lbIconCheck.repaint();
                model.setArchivo(null);
            }else{
                 guardarStatus(ruta);
            }
           

        } catch (FileNotFoundException ex) {
              JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }//GEN-LAST:event_buttonBadges1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArchivo;
    private com.swing.ButtonBadges buttonBadges1;
    private javax.swing.JComboBox<String> cmbMotivo;
    private javax.swing.JButton jButton2;
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
