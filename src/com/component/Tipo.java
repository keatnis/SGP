package com.component;

import com.DAO.PersonalNDAO;
import com.classes.GenerarCod;
import com.connection.Conexion;
import com.model.ModelPersonalN;
import com.notification.Notification;
import com.vista.MainSystem;

import com.vista.RegistrarPN;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Tipo extends javax.swing.JDialog {

    PersonalNDAO DAO = new PersonalNDAO();
    ModelPersonalN model = new ModelPersonalN();
   
    Conexion con = new Conexion();
    Statement st = null;
    ResultSet rs;
    Connection conn = con.getConnection();
    public String numemp, tipoContratacion;

    Matcher mat, mat2;
    RegistrarPN reg = new RegistrarPN();

    public Tipo(java.awt.Frame parent, boolean modal) {

        super(parent, modal);
        initComponents();
    }

    private void ObtenerCodNomina() {

        int j;

        String n = "";
        String SQL = "SELECT max(num_empleado) from tbl_empleado,tbl_empleo where tbl_empleado.id_empleado=tbl_empleo.id_empleado and tipo_contratacion='Nómina'";
//         String SQL="select count(*) from factura";
//        String SQL="SELECT MAX(cod_emp) AS cod_emp FROM empleado";
//        String SQL="SELECT @@identity AS ID";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(SQL);
            if (rs.next()) {
                n = rs.getString(1);
            }

            if (n == null) {
                txtNumEmpleado.setText("001");
            } else {
//                char r1 = n.charAt(2);
//
//                String r = "";
//                r = "" + r1;

                j = Integer.parseInt(n);
                GenerarCod gen = new GenerarCod();
                gen.generar(j);
                txtNumEmpleado.setText("" + gen.serie());

            }
            rs.close();
          
        } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }
    //método para obnetener serie para el personal de honorarios

    private void ObtenerCodHonorarios() {

        int j;

        String n = "";
        String SQL = "SELECT max(num_empleado) from tbl_empleado,tbl_empleo where tbl_empleado.id_empleado=tbl_empleo.id_empleado and tipo_contratacion='Honorarios'";
//         String SQL="select count(*) from factura";
//        String SQL="SELECT MAX(cod_emp) AS cod_emp FROM empleado";
//        String SQL="SELECT @@identity AS ID";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(SQL);
            if (rs.next()) {
                n = rs.getString(1);
            }

            if (n == null) {
                txtNumEmpleado.setText("H-001");
            } else {
                char r1 = n.charAt(2);
                char r2 = n.charAt(3);
                char r3 = n.charAt(4);
                String r = "";
                r = "" + r1 + r2 + r3;

                j = Integer.parseInt(r);
                GenerarCod gen = new GenerarCod();
                gen.generar(j);
                txtNumEmpleado.setText("H-" + gen.serie());

            }
            rs.close();
              st.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }

    void validarN() {

        Pattern pat2 = Pattern.compile("[0-9]{2,3}");
        mat2 = pat2.matcher(txtNumEmpleado.getText());
        Pattern pat = Pattern.compile("[H]{1}-[0-9]{3}");
        mat = pat.matcher(txtNumEmpleado.getText());
        if (mat.matches() == false && mat2.matches() == false) {

            JOptionPane.showMessageDialog(null, "Número de empleado/a ** inválido **");

        } else if (txtNumEmpleado.getText().length() > 5) {
            JOptionPane.showMessageDialog(null, "Número de empleado/a ** inválido **");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmb = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtNumEmpleado = new com.swing.JCTextField();
        btnObtener = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Requerido");
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setModal(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tipo");

        cmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccionar --", "Nómina", "Honorarios" }));
        cmb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbItemStateChanged(evt);
            }
        });
        cmb.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cmbPropertyChange(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Número de empleado /a");

        txtNumEmpleado.setPlaceholder("Número y/o identificador");
        txtNumEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtNumEmpleadoMouseExited(evt);
            }
        });

        btnObtener.setText("Obtener");
        btnObtener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObtenerActionPerformed(evt);
            }
        });

        btnAceptar.setBackground(new java.awt.Color(0, 102, 255));
        btnAceptar.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/help_m.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(45, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNumEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(btnObtener))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cmb, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(166, 166, 166))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNumEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnObtener))
                .addGap(37, 37, 37)
                .addComponent(btnAceptar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmbPropertyChange

    }//GEN-LAST:event_cmbPropertyChange

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (DAO.numEmpExiste(txtNumEmpleado.getText()) == 0) {

            validarN();
            int opcion = cmb.getSelectedIndex();
            if ((mat.matches() || mat2.matches()) && (txtNumEmpleado.getText().length() >= 3)) {

                numemp = txtNumEmpleado.getText();
                if (opcion >= 1 && (txtNumEmpleado.getText().length() >= 3)) {
                    String opc = (String) cmb.getSelectedItem();
                    this.setNum(numemp);
                    this.setTipoContratacion(opc);
                    this.setVisible(false);
                    Notification n = new Notification(MainSystem.getFrames()[0], Notification.Type.INFO, Notification.Location.CENTER, "Verificar que los datos ingresados sean correctos antes de dar clic en Siguiente!!");
                    n.showNotification();
                } else if ((opcion == 0 || txtNumEmpleado.getText().isEmpty())) {

                    JOptionPane.showMessageDialog(null, "Campos vacíos: Seleccione y asigne datos a los campos");
                }

            }
        } else {
            Notification n = new Notification(MainSystem.getFrames()[0], Notification.Type.WARNING, Notification.Location.TOP_CENTER, "El numero de empleado/a ya está registrado");
            n.showNotification();
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnObtenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObtenerActionPerformed
        int opcion = cmb.getSelectedIndex();
        if (opcion == 1) {

            ObtenerCodNomina();
        } else if (opcion == 2) {

            ObtenerCodHonorarios();
        } else if (opcion <= 0) {
            JOptionPane.showMessageDialog(null, "Seleccione el Tipo de Contratacion", "Mensaje", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnObtenerActionPerformed

    private void txtNumEmpleadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNumEmpleadoMouseExited

    }//GEN-LAST:event_txtNumEmpleadoMouseExited

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void cmbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbItemStateChanged
        txtNumEmpleado.setText("");
    }//GEN-LAST:event_cmbItemStateChanged
    public String num;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getTipoContratacion() {
        return tipoContratacion;
    }

    public void setTipoContratacion(String tipoContratacion) {
        this.tipoContratacion = tipoContratacion;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnObtener;
    private javax.swing.JComboBox<String> cmb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private com.swing.JCTextField txtNumEmpleado;
    // End of variables declaration//GEN-END:variables
}
