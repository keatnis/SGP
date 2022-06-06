package com.vista;

import com.model.Hash;
import javax.swing.JFileChooser;
import com.model.ModelUsers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import com.connection.Conexion;
import com.DAO.UsuariosDAO;
import com.swing.ImageAvatar;
import java.awt.Image;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileNameExtensionFilter;

public class RegistrarUsuario extends javax.swing.JPanel {

    Conexion con = new Conexion();
    private String tipoU;
    public String ruta;
    public ImageIcon icono;

    public RegistrarUsuario() {
        initComponents();
        ObteberTipo();

    }

    public void ObteberTipo() {
        try {
            con.getConnection();
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT *FROM tbl_tipo_usuario");
            ResultSet res = pstm.executeQuery();

            while (res.next()) {
                tipoU = res.getString("nombre");
                this.cmbTipo.addItem(tipoU);
            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        bgSexoUser = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCargo = new com.swing.JCTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCorreo = new com.swing.JCTextField();
        txtPassword = new javax.swing.JPasswordField();
        txtConfirmar = new javax.swing.JPasswordField();
        btnGuardar = new com.swing.ButtonBadges();
        txtNombre = new com.swing.JCTextField();
        txtUsuario = new com.swing.JCTextField();
        jPanel2 = new javax.swing.JPanel();
        lbFoto = new com.swing.ImageAvatar();
        jButton3 = new javax.swing.JButton();
        buttonBadges3 = new com.swing.ButtonBadges();
        lbAvatar = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(600, 400));
        setLayout(new java.awt.GridBagLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(568, 700));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setText("Nombre Completo");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Sexo");

        bgSexoUser.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton1.setText("Mujer");

        bgSexoUser.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton2.setText("Hombre");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Usuario");

        cmbTipo.setSelectedIndex(-1);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Tipo de usuario");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Cargo");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Correo");

        txtCargo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCargo.setName(""); // NOI18N
        txtCargo.setPlaceholder("Cargo");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setText("Contraseña");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setText("Confirmar contraseña");

        txtCorreo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCorreo.setName(""); // NOI18N
        txtCorreo.setPlaceholder("Correo");

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtConfirmar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnGuardar.setBackground(new java.awt.Color(31, 44, 81));
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar y Salir");
        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNombre.setName(""); // NOI18N
        txtNombre.setPlaceholder("Nombre Completo");

        txtUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUsuario.setName(""); // NOI18N
        txtUsuario.setPlaceholder("Usuario");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Avatar"));

        lbFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/avatar.png"))); // NOI18N

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/add_25px.png"))); // NOI18N
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(0, 17, Short.MAX_VALUE))
            .addComponent(lbFoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonBadges3.setText("Cancelar");
        buttonBadges3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel6))
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jRadioButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jRadioButton2)
                                .addGap(37, 37, 37))
                            .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCargo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPassword)
                            .addComponent(txtConfirmar))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(buttonBadges3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(180, 180, 180))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(lbAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonBadges3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 32;
        gridBagConstraints.ipady = 24;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jPanel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        ImageAvatar ia = new ImageAvatar();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo de imagen", "png", "jpg");
        JFileChooser selector = new JFileChooser();
        selector.setFileFilter(filtro);
        int opcion = selector.showOpenDialog(this);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            String nombreArchivo = selector.getSelectedFile().getPath();
            this.ruta = selector.getSelectedFile().toString();
   

            icono = new ImageIcon(nombreArchivo);
       //     ImageIcon nuevoIcono = new ImageIcon(ia.toImage(icono));
            lbFoto.setIcon(new ImageIcon(ia.toImage(icono)));
            lbFoto.repaint();

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        UsuariosDAO sqluser = new UsuariosDAO();
        ModelUsers mod = new ModelUsers();
        ImageAvatar ia = new ImageAvatar();
        String pass = new String(txtPassword.getPassword());
        String passCon = new String(txtConfirmar.getPassword());
        tipoU = (String) cmbTipo.getSelectedItem();
      
        if (pass.equals(passCon)) {

            if (sqluser.usuarioExiste(txtUsuario.getText()) == 0) {

                String nuevoPass = Hash.sha1(pass);

                mod.setUsuario(txtUsuario.getText());
                mod.setNombre(txtNombre.getText());
                mod.setCargo(txtCargo.getText());
                mod.setCorreo(txtCorreo.getText());
                mod.setPassword(nuevoPass);
                mod.setTipo(tipoU);
                mod.setEstado("Activo");
               
                if(icono==null){
                 JOptionPane.showMessageDialog(null, "Escoja un foto de perfil");
                }else{
                    mod.setRuta(ruta);
                    mod.setAvatar(ia.toImage(icono));
                     
                }
   
                try {
                    if (sqluser.registrar(mod)) {
                        JOptionPane.showMessageDialog(null, "registrado");
                    } else {
                        JOptionPane.showMessageDialog(null, ERROR);
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(RegistrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Usuario ya existe!!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
        }


    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgSexoUser;
    private com.swing.ButtonBadges btnGuardar;
    private com.swing.ButtonBadges buttonBadges3;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JLabel lbAvatar;
    private com.swing.ImageAvatar lbFoto;
    private com.swing.JCTextField txtCargo;
    private javax.swing.JPasswordField txtConfirmar;
    private com.swing.JCTextField txtCorreo;
    private com.swing.JCTextField txtNombre;
    private javax.swing.JPasswordField txtPassword;
    private com.swing.JCTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
