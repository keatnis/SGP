package com.vista;

import com.DAO.BajaPersonalDAO;
import com.DAO.IncidenciasDAO;
import com.classes.Validaciones;
import com.model.ModelReportarIncidencia;
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
import com.classes.data_session;
import com.component.EmpleadoSinFoto;
import com.component.RegistroIncidencia;
import com.model.ModelUsers;

public class ReportarIncidencia extends javax.swing.JPanel {

    ModelReportarIncidencia model = new ModelReportarIncidencia();
    IncidenciasDAO dao = new IncidenciasDAO();
    BajaPersonalDAO daob = new BajaPersonalDAO();

    String nombreusr;
    String rutaArchivo;
    File ruta;

    public ReportarIncidencia(String usr) {
        this.nombreusr = usr;
        initComponents();
    }

    void Validar() {

        if (fecha_de.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Fecha Inicio no se ha asignado");
        }
        if (fecha_hasta.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Fecha Final no se ha asignado");
        }
        Validaciones.esCajaVacia(txtNumEmp, "Número de empleado (a) no se ha asignado");
        Validaciones.cmbNoSeleccionado(cmbTipoIncidencia, "No se ha seleccionado el tipo de incidencia");
        if (cbJI.isSelected() == true && ruta == null) {
            JOptionPane.showMessageDialog(null, "Seleccionó que la incidencia es justificada pero no se ha agregado ningun justificante");
        }

    }

    private void saveIncidencia() throws FileNotFoundException {
        int id = daob.idEmpleado(txtNumEmp.getText());
        Validar();
        model.setIdEmp(id);

        SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
        String fechade = (formatofecha.format(fecha_de.getDate()));
        String fechahasta = (formatofecha.format(fecha_hasta.getDate()));
        model.setFecha_de(fechade);
        model.setFecha_hasta(fechahasta);

        String tipo = (String) cmbTipoIncidencia.getSelectedItem();
        model.setTipoIncidencia(tipo);
        boolean just = cbJI.isSelected();
        int justi = just ? 1 : 0;
        model.setEsJustificada(justi);
        model.setNota(txtNota.getText());

        model.setNomuser(nombreusr);

        if (just == true && ruta != null) {
            try {
                byte[] pdf = new byte[(int) ruta.length()];
                InputStream input = new FileInputStream(ruta);
                input.read(pdf);
                model.setArchivo(pdf);

                dao.registrar(model);

            } catch (IOException ex) {
                //   model.setArchivo(null);
                JOptionPane.showMessageDialog(null, "Error al agregar archivo pdf " + ex.getMessage());
            }
        } else if (just == true && ruta == null) {
            int opcion = JOptionPane.showConfirmDialog(null, "No se ha agregado ningún archivo aún, desea agregarlo? ");
            if (opcion == 0) {
                agregar_pdf();
            } else {
                model.setArchivo(null);
            }

        } else if (just == false && ruta != null) {
            JOptionPane.showMessageDialog(null, "Se agregó un justificante sin marcar que es justificado, si desea quitar el archivo seleccione el botón ' Adjuntar justificante' y luego de clic cancelar");
        }
        if (just == false && ruta == null) {
            model.setArchivo(null);
            dao.registrar(model);
        }

    }

    private void agregar_pdf() {
        // Inicia el JFileChooser
        JFileChooser fc = new JFileChooser();
        // Se crea un filtro de extensiones para que solamente pueda seleccionar archivos PDF
        FileFilter ff = new FileNameExtensionFilter("Archivo PDF", "pdf", "jpg", "png");
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
                lbIconCheck.setIcon(new ImageIcon("src/com/icon/check_circle_20px.png"));
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
            ruta = null;
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNumEmp = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbTipoIncidencia = new javax.swing.JComboBox<>();
        cbJI = new javax.swing.JCheckBox();
        btnAddFile = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNota = new javax.swing.JTextArea();
        buttonBadges1 = new com.swing.ButtonBadges();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        fecha_de = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        fecha_hasta = new com.toedter.calendar.JDateChooser();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        lbIconCheck = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        setOpaque(false);
        setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel2.setText("Número de empleado/a:");

        txtNumEmp.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNumEmp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumEmpKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumEmpKeyTyped(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/search_30px.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel6.setText("Tipo de Incidencia:");

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel7.setText("¿Es justificada?");

        cmbTipoIncidencia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbTipoIncidencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Evento  de convivencia familiar", "Comisiones", "Corresponsabilidad Laboral", "Cuidado a terceros", "Falta justificada", "Falta injustificada", "Horas extras", "Incapacidad", "Modificación del salario", "Licencia sin goce de sueldo", "Permiso por maternidad", "Permiso por lactancia", "Permiso por paternidad", "Permiso por nupcias", "Permiso por muerte de familiar", "Retardo", "Otro" }));

        btnAddFile.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAddFile.setText("Adjuntar justificante");
        btnAddFile.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAddFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFileActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel10.setText("Notas");

        txtNota.setColumns(5);
        txtNota.setRows(5);
        txtNota.setPreferredSize(new java.awt.Dimension(44, 50));
        jScrollPane1.setViewportView(txtNota);

        buttonBadges1.setBackground(new java.awt.Color(31, 44, 81));
        buttonBadges1.setForeground(new java.awt.Color(255, 255, 255));
        buttonBadges1.setText("Guardar");
        buttonBadges1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonBadges1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBadges1ActionPerformed(evt);
            }
        });

        jToolBar1.setRollover(true);
        jToolBar1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel1.setText("Fecha:   ");
        jToolBar1.add(jLabel1);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 153));
        jLabel8.setText("De  ");
        jToolBar1.add(jLabel8);
        jToolBar1.add(fecha_de);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 153));
        jLabel9.setText("  Hasta  ");
        jToolBar1.add(jLabel9);
        jToolBar1.add(fecha_hasta);

        jLabel3.setText("* Marcar en caso de que sea verdadero");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/icons8-search-in-list-35.png"))); // NOI18N
        jButton2.setText("Ver registros ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNumEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmbTipoIncidencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAddFile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbIconCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbJI)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(280, 280, 280)
                .addComponent(buttonBadges1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtNumEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel6))
                    .addComponent(cmbTipoIncidencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7)
                        .addComponent(cbJI, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddFile)
                    .addComponent(lbIconCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(buttonBadges1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        add(jPanel1, new java.awt.GridBagConstraints());
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFileActionPerformed
        agregar_pdf();

    }//GEN-LAST:event_btnAddFileActionPerformed

    private void txtNumEmpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumEmpKeyReleased
//          if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//               id=daob.idEmpleado(txtNumEmp.getText());
//          }
//       
    }//GEN-LAST:event_txtNumEmpKeyReleased

    private void txtNumEmpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumEmpKeyTyped


    }//GEN-LAST:event_txtNumEmpKeyTyped

    private void buttonBadges1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBadges1ActionPerformed
        try {
            saveIncidencia();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_buttonBadges1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        RegistroIncidencia dialog = new RegistroIncidencia(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                dialog.setVisible(false);
            }
        });
        dialog.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        EmpleadoSinFoto dialog = new EmpleadoSinFoto(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                dialog.setVisible(false);
            }
        });

        dialog.setVisible(true);
        txtNumEmp.setText(dialog.getNume());
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddFile;
    private com.swing.ButtonBadges buttonBadges1;
    private javax.swing.JCheckBox cbJI;
    private javax.swing.JComboBox<String> cmbTipoIncidencia;
    private com.toedter.calendar.JDateChooser fecha_de;
    private com.toedter.calendar.JDateChooser fecha_hasta;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lbIconCheck;
    private javax.swing.JTextArea txtNota;
    private javax.swing.JTextField txtNumEmp;
    // End of variables declaration//GEN-END:variables

}
