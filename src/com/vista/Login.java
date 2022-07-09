package com.vista;

import com.formdev.flatlaf.FlatLightLaf;
import com.model.ModelUsers;
import com.DAO.UsuariosDAO;
import com.component.splash2;
import com.component.splashMain;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import com.model.Hash;

public class Login extends javax.swing.JFrame {
   Hash hash;
  

    public Login() {
        initComponents();
  
        this.setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
    }
    private void splash(){
             splash2 sp = new splash2();
             sp.setVisible(true);
     
     try{
            for(int i=0; i<=100;i++){
            
                        Thread.sleep(100);
                  
                sp.LoadingValue.setText(i+" %");
                  sp.PBar.setValue(i);
                if(i==10){
                   sp.LoadingLabel.setText("Cargando Módulos...");
                }
                  if(i==25){
                    sp.LoadingLabel.setText("Iniciando...");
                  
                   //  ms.setVisible(true);
                    
                }
                  if(i==100){
                    sp.LoadingLabel.setText("Cargandando...");
                    
                  
                    
                }
               
            }
     }catch(Exception e){
                
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
        capa = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtPassword = new com.swing.PasswordField();
        txtUsuario = new com.swing.TextField1();
        btnIngresar = new com.swing.ButtonBadges();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(68, 68, 68)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(212, Short.MAX_VALUE))
        );

        capa.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel5.setText("Inicio de Sesión");

        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPassword.setLabelText("Contraseña");
        txtPassword.setSelectionColor(new java.awt.Color(31, 44, 81));
        txtPassword.setShowAndHide(true);

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

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/help.png"))); // NOI18N
        jButton1.setText("Ayuda");
        jButton1.setToolTipText("<html>Presione este botón si olvidó su usuario u contraseña <html>");
        jButton1.setBorderPainted(false);

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
                .addContainerGap(67, Short.MAX_VALUE)
                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jButton1)
                .addGap(33, 33, 33))
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
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        capaLayout.setVerticalGroup(
            capaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(capaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addGroup(capaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(capaLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel5)
                        .addGap(35, 35, 35)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(71, 71, 71))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, capaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91))))
        );

        javax.swing.GroupLayout cardLoginLayout = new javax.swing.GroupLayout(cardLogin);
        cardLogin.setLayout(cardLoginLayout);
        cardLoginLayout.setHorizontalGroup(
            cardLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardLoginLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(capa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        cardLoginLayout.setVerticalGroup(
            cardLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardLoginLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(cardLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(capa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cardLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
       UsuariosDAO modsql = new UsuariosDAO();
       ModelUsers mod = new ModelUsers();
    
       String pass =new String (txtPassword.getPassword());
       if(!txtUsuario.getText().equals("") && !pass.equals("")){
       String nuevopass = hash.sha1(pass);
       mod.setUsuario(txtUsuario.getText());
       mod.setPassword(nuevopass);
       
       if(modsql.login(mod)){
        
         
        this.dispose();
 
      //  splashMain sm =new splashMain(); 
//        MainSystem ms= new MainSystem(mod);
//        ms.setVisible(true);
      
          
       }else{
           JOptionPane.showMessageDialog(null, "Datos incorrectos");
       }
       }else{
           JOptionPane.showMessageDialog(null,"Campos vacios favor de ingresar los datos !!!");
       }

    }//GEN-LAST:event_btnIngresarActionPerformed

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");

        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.swing.ButtonBadges btnIngresar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel capa;
    private javax.swing.JPanel cardLogin;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private com.swing.PasswordField txtPassword;
    private com.swing.TextField1 txtUsuario;
    // End of variables declaration//GEN-END:variables
}
