package com.vista;

import com.model.ModelUsers;
import com.DAO.UsuariosDAO;
import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JOptionPane;
import com.model.Hash;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import com.vista.MainSystem;
import java.awt.event.KeyEvent;
import javax.swing.Icon;

public class Login extends javax.swing.JFrame {

    Hash hash;
    private Login splashFrame = this;

    public Login() {
        initComponents();
        this.setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
//        Image img = new ImageIcon("src/com/icon/tecnm_logo.png").getImage();
//        ImageIcon img2 = new ImageIcon(img.getScaledInstance(134, 68, Image.SCALE_SMOOTH));
//        lb1.setIcon(img2);

        Image img4 = this.toImage(new javax.swing.ImageIcon(getClass().getResource("/com/icon/itsm.png")));
        ImageIcon img3 = new ImageIcon(img4.getScaledInstance(80, 60, Image.SCALE_SMOOTH));
        lb2.setIcon(img3);
        
        // startThread();

    }
       public Image toImage(Icon icon) {
        return ((ImageIcon) icon).getImage();
    }
    private void startThread(ModelUsers user) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                MainSystem appFrame =new MainSystem(user, splashFrame);
                appFrame.setLocationRelativeTo(null);
                appFrame.setVisible(true);
                dispose();
            }

        });
        thread.start();
    }
     private void startThread2(ModelUsers user) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                MainSystem2 appFrame =new MainSystem2(user, splashFrame);
                appFrame.setLocationRelativeTo(null);
                appFrame.setVisible(true);
                dispose();
            }

        });
        thread.start();
    }
private void login(){
      UsuariosDAO modsql = new UsuariosDAO();
        ModelUsers mod = new ModelUsers();

        String pass = new String(txtPassword.getPassword());
        if (!txtUsuario.getText().equals("") && !pass.equals("")) {
            String nuevopass = hash.sha1(pass);
            mod.setUsuario(txtUsuario.getText());
            mod.setPassword(nuevopass);

            if (modsql.login(mod)) {

                // this.dispose();
                if (mod.getTipo().equals("Administrador")) {
                    startThread(mod);

////                   
                } else {
                    startThread2(mod);
                }
             

            } else {
                JOptionPane.showMessageDialog(null, "Datos incorrectos");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Campos vacios favor de ingresar los datos !!!");
        }

}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jButton3 = new javax.swing.JButton();
        cardLogin = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lb2 = new javax.swing.JLabel();
        lbprogress = new javax.swing.JLabel();
        capa = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtPassword = new com.swing.PasswordField();
        txtUsuario = new com.swing.TextField1();
        btnIngresar = new com.swing.ButtonBadges();
        jButton2 = new javax.swing.JButton();
        ProgressBar = new javax.swing.JProgressBar();

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Gestión de Personal");
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Bienvenido (a)!");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("<html>Favor de introducir sus datos para acceder al sistema.</html>");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("al Sistema de Gestión de Personal");

        lbprogress.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        lbprogress.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(44, 44, 44))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lb2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGap(64, 64, 64)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(46, Short.MAX_VALUE))
                    .addComponent(lbprogress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(lb2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(11, 11, 11)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbprogress, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        capa.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel5.setText("Inicio de Sesión");

        txtPassword.setText("asd");
        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPassword.setLabelText("Contraseña");
        txtPassword.setSelectionColor(new java.awt.Color(31, 44, 81));
        txtPassword.setShowAndHide(true);
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPasswordKeyReleased(evt);
            }
        });

        txtUsuario.setText("admin");
        txtUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUsuario.setLabelText("Usuario");

        btnIngresar.setBackground(new java.awt.Color(0, 51, 102));
        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setText("Ingresar");
        btnIngresar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/Close.png"))); // NOI18N
        jButton2.setToolTipText("Salir");
        jButton2.setBorderPainted(false);
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/Close_press.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout capaLayout = new javax.swing.GroupLayout(capa);
        capa.setLayout(capaLayout);
        capaLayout.setHorizontalGroup(
            capaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, capaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(capaLayout.createSequentialGroup()
                .addGroup(capaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(capaLayout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(capaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(capaLayout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel5))
                    .addGroup(capaLayout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        capaLayout.setVerticalGroup(
            capaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(capaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addGap(47, 47, 47)
                .addComponent(jLabel5)
                .addGap(35, 35, 35)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        ProgressBar.setForeground(new java.awt.Color(255, 103, 15));

        javax.swing.GroupLayout cardLoginLayout = new javax.swing.GroupLayout(cardLogin);
        cardLogin.setLayout(cardLoginLayout);
        cardLoginLayout.setHorizontalGroup(
            cardLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardLoginLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(capa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(ProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        cardLoginLayout.setVerticalGroup(
            cardLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardLoginLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(cardLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(capa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(ProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cardLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        cardLogin.getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
      login();
      lbprogress.setText("Iniciando ...");
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void txtPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyReleased
      if(evt.getKeyCode() == KeyEvent.VK_ENTER){
          lbprogress.setText("Iniciando ...");
          login();
      }
    }//GEN-LAST:event_txtPasswordKeyReleased

    public static void main(String args[]) {
//        try {
//
//            UIManager.setLookAndFeel(new FlatLightLaf());
//            UIManager.put("Button.arc", 100);
//            UIManager.put("TextComponent.arc", 10);
//        } catch (Exception ex) {
//            System.err.println("Failed to initialize LaF");
//
//        }
        FlatIntelliJLaf.registerCustomDefaultsSource("com/style");
//        FlatLightLaf.setup();
        FlatIntelliJLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar ProgressBar;
    private com.swing.ButtonBadges btnIngresar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel capa;
    private javax.swing.JPanel cardLogin;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lbprogress;
    private com.swing.PasswordField txtPassword;
    private com.swing.TextField1 txtUsuario;
    // End of variables declaration//GEN-END:variables

    public JProgressBar getProgressBar() {
        return ProgressBar;
    }
        public JLabel getlbprogress() {
        return lbprogress;
    }
}
