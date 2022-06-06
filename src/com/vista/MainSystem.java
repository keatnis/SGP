
package com.vista;

import com.formdev.flatlaf.FlatLightLaf;
import com.model.ModelUsers;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.UIManager;

public class MainSystem extends javax.swing.JFrame {
//private final ModelUsers user;


    public MainSystem() {
          
        initComponents();
        this.showForm(new Dasboard(),"Dasboard");

   // this.setShape(new RoundRectangle2D.Double(0, 0, getWidth(),getHeight(), 20, 20));
      // this.user = user;
     //   lbUser.setText(user.getNombre());
//    if(user.getAvatar()==null){
//
//
//       imgAvatar.setIcon(new ImageIcon(getClass().getResource("/com/icon/avatar.png")));
//
//
//    }else{
//         imgAvatar.setIcon(new ImageIcon(user.getAvatar()));
//    }
        this.repaint();
    }
    

  public void showForm(Component form) {
        showForm(form, "");
    }
  
    public void showForm(Component form, String title) {
       lbTitle.setText(title);
        panelBody.removeAll();
        panelBody.add(form, BorderLayout.CENTER);
        panelBody.repaint();
        panelBody.revalidate();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popMenuUsuario = new javax.swing.JPopupMenu();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem25 = new javax.swing.JMenuItem();
        panelEnc = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        imgAvatar = new com.swing.ImageAvatar();
        lbUser = new javax.swing.JLabel();
        buttonBadges1 = new com.swing.ButtonBadges();
        buttonBadges2 = new com.swing.ButtonBadges();
        lbTitle = new javax.swing.JLabel();
        panelBody = new javax.swing.JPanel();
        MenuBar = new javax.swing.JMenuBar();
        Dasboard = new javax.swing.JMenu();
        menuPersonal = new javax.swing.JMenu();
        menuPNomina = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenu11 = new javax.swing.JMenu();

        jMenuItem17.setText("Cambiar Icono");
        jMenuItem17.setActionCommand("cvbvb");
        popMenuUsuario.add(jMenuItem17);
        jMenuItem17.getAccessibleContext().setAccessibleName("MenuUser");
        jMenuItem17.getAccessibleContext().setAccessibleDescription("MenuUser");

        jMenuItem18.setText("Cambiar conrtraseña");
        popMenuUsuario.add(jMenuItem18);
        popMenuUsuario.add(jSeparator1);

        jMenuItem25.setText("Cerrar Sesion");
        popMenuUsuario.add(jMenuItem25);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelEnc.setInheritsPopupMenu(true);
        panelEnc.setPreferredSize(new java.awt.Dimension(1374, 74));

        imgAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/avatar.png"))); // NOI18N

        lbUser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbUser.setForeground(new java.awt.Color(51, 51, 51));
        lbUser.setText("User Name");

        buttonBadges1.setBackground(new java.awt.Color(240, 240, 240));
        buttonBadges1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/settings_25px.png"))); // NOI18N
        buttonBadges1.setComponentPopupMenu(popMenuUsuario);
        buttonBadges1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonBadges1MouseClicked(evt);
            }
        });
        buttonBadges1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBadges1ActionPerformed(evt);
            }
        });

        buttonBadges2.setBackground(new java.awt.Color(240, 240, 240));
        buttonBadges2.setForeground(new java.awt.Color(0, 30, 176));
        buttonBadges2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/notification.png"))); // NOI18N
        buttonBadges2.setBadges(8);

        lbTitle.setFont(new java.awt.Font("Poppins SemiBold", 1, 20)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(51, 51, 51));
        lbTitle.setText("Titulo del Módulo");

        javax.swing.GroupLayout panelEncLayout = new javax.swing.GroupLayout(panelEnc);
        panelEnc.setLayout(panelEncLayout);
        panelEncLayout.setHorizontalGroup(
            panelEncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEncLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelEncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEncLayout.createSequentialGroup()
                        .addComponent(buttonBadges2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonBadges1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbUser, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(11, 11, 11)
                .addComponent(imgAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelEncLayout.setVerticalGroup(
            panelEncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEncLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelEncLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbTitle))
            .addGroup(panelEncLayout.createSequentialGroup()
                .addComponent(lbUser)
                .addGroup(panelEncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonBadges2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonBadges1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(imgAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        panelBody.setOpaque(false);
        panelBody.setLayout(new java.awt.BorderLayout());

        MenuBar.setBackground(new java.awt.Color(31, 44, 81));
        MenuBar.setBorderPainted(false);

        Dasboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/dashboard_1.png"))); // NOI18N
        Dasboard.setText("Inicio");
        Dasboard.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Dasboard.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/dashboard_press.png"))); // NOI18N
        Dasboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DasboardMouseClicked(evt);
            }
        });
        MenuBar.add(Dasboard);

        menuPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/people_1.png"))); // NOI18N
        menuPersonal.setText("Personal");
        menuPersonal.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/people_press.png"))); // NOI18N
        menuPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPersonalActionPerformed(evt);
            }
        });

        menuPNomina.setText("Lista");
        menuPNomina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPNominaActionPerformed(evt);
            }
        });
        menuPersonal.add(menuPNomina);

        jMenuItem6.setText("Dar de Alta");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        menuPersonal.add(jMenuItem6);

        jMenuItem7.setText("Dar de Baja");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        menuPersonal.add(jMenuItem7);

        jMenuItem9.setText("Perfil de personal");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        menuPersonal.add(jMenuItem9);

        jMenuItem23.setText("Directorio");
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        menuPersonal.add(jMenuItem23);

        MenuBar.add(menuPersonal);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/search_2.png"))); // NOI18N
        jMenu4.setText("Documentos");

        jMenuItem10.setText("Expediente del personal");
        jMenu4.add(jMenuItem10);

        jMenuItem21.setText("Justificantes");
        jMenu4.add(jMenuItem21);

        MenuBar.add(jMenu4);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/report.png"))); // NOI18N
        jMenu6.setText("Contro de Incidencias");

        jMenuItem2.setText("Reportar Incidencia");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem2);

        jMenuItem11.setText("Generar pase de Salida");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem11);

        jMenuItem22.setText("Ver registros");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem22);

        MenuBar.add(jMenu6);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/export_pdf.png"))); // NOI18N
        jMenu5.setText("Informes");

        jMenuItem3.setText("Generar un Reporte del Personal");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem3);

        jMenuItem8.setText("Ficha de Personal");
        jMenu5.add(jMenuItem8);

        jMenu2.setText("Generar una Lista de ");

        jMenuItem12.setText("Dias Festivos");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem12);

        jMenuItem13.setText("Personal  de Nómina");
        jMenu2.add(jMenuItem13);

        jMenuItem14.setText("Personal por honorarios");
        jMenu2.add(jMenuItem14);

        jMenuItem15.setText("Directorio");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem15);
        jMenu2.add(jMenuItem16);

        jMenuItem24.setText("Otro");
        jMenuItem24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem24ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem24);

        jMenu5.add(jMenu2);

        MenuBar.add(jMenu5);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/caducidad.png"))); // NOI18N
        jMenu7.setText("Caducidad");
        jMenu7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu7MouseClicked(evt);
            }
        });
        MenuBar.add(jMenu7);

        jMenu10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/user_menu.png"))); // NOI18N
        jMenu10.setText("Usuarios");
        jMenu10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu10ActionPerformed(evt);
            }
        });

        jMenuItem19.setText("Usuarios Registrados");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem19);

        jMenuItem20.setText("Registrar Nuevo Usuario");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem20);

        MenuBar.add(jMenu10);

        jMenu9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/database_adm.png"))); // NOI18N
        jMenu9.setText("Ajustes");
        jMenu9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu9MouseClicked(evt);
            }
        });
        jMenu9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu9ActionPerformed(evt);
            }
        });
        MenuBar.add(jMenu9);

        jMenu11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/help_m.png"))); // NOI18N
        jMenu11.setText("Ayuda");
        MenuBar.add(jMenu11);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBody, javax.swing.GroupLayout.DEFAULT_SIZE, 1377, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelEnc, javax.swing.GroupLayout.DEFAULT_SIZE, 1367, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelEnc, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBody, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPersonalActionPerformed
      
    }//GEN-LAST:event_menuPersonalActionPerformed

    private void menuPNominaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPNominaActionPerformed
      this.showForm(new Personal(),"Listado de Personal");
    }//GEN-LAST:event_menuPNominaActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenu10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu10ActionPerformed
    // this.showForm(new Usuarios(),"Usuarios");
    }//GEN-LAST:event_jMenu10ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
       this.showForm(new Usuarios(),"Usuarios");
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
      this.showForm(new RegistrarUsuario(),"Nuevo Usuario");
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void DasboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DasboardMouseClicked
        // TODO add your handling code here:
        this.showForm(new Dasboard(),"Dasboard");
    }//GEN-LAST:event_DasboardMouseClicked

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
       this.showForm(new RegistrarPN(),"Registro de Personal");
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        this.showForm(new BajaPersonal(),"Motivo de Baja");
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
      this.showForm(new ReportarIncidencia(),"Reportar Incidencia");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
     this.showForm(new PaseSalida(),"Generar Pase de Salida");
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
    this.showForm(new PerfilPersonal(), "Perfil del personal seleccionado");
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed
     this.showForm(new RegistroIncidencias(),"Registro de incidencias");
    }//GEN-LAST:event_jMenuItem22ActionPerformed

    private void jMenu9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu9ActionPerformed
     this.showForm(new Mantenimiento(),"Mantenimiento");
    }//GEN-LAST:event_jMenu9ActionPerformed

    private void jMenu9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu9MouseClicked
       this.showForm(new Mantenimiento(),"Mantenimiento");
    }//GEN-LAST:event_jMenu9MouseClicked

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
    this.showForm(new ListaPersonal(),"Generar un Listado de personal");
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed
     this.showForm(new Directorio(),"Directorio");
    }//GEN-LAST:event_jMenuItem23ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
     this.showForm(new DiasFestivos(),"Generar un reporte de días festivos");
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenu7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu7MouseClicked
      this.showForm(new Caducidad(),"Vencimiento de documentos");
    }//GEN-LAST:event_jMenu7MouseClicked

    private void jMenuItem24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem24ActionPerformed
    //prueba de grafica
    this.showForm(new ReporteGenero(),"Reporte GEnero");
    }//GEN-LAST:event_jMenuItem24ActionPerformed

    private void buttonBadges1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBadges1ActionPerformed
      buttonBadges1.setComponentPopupMenu(popMenuUsuario);
    }//GEN-LAST:event_buttonBadges1ActionPerformed

    private void buttonBadges1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonBadges1MouseClicked
         buttonBadges1.setComponentPopupMenu(popMenuUsuario);
    }//GEN-LAST:event_buttonBadges1MouseClicked

//    public static void main(ModelUsers user) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MainSystem(user).setVisible(true);
//            }
//        });
//    }

  
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");

        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainSystem().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Dasboard;
    private javax.swing.JMenuBar MenuBar;
    private com.swing.ButtonBadges buttonBadges1;
    private com.swing.ButtonBadges buttonBadges2;
    private com.swing.ImageAvatar imgAvatar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    public javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbUser;
    private javax.swing.JMenuItem menuPNomina;
    private javax.swing.JMenu menuPersonal;
    public javax.swing.JPanel panelBody;
    private javax.swing.JPanel panelEnc;
    private javax.swing.JPopupMenu popMenuUsuario;
    // End of variables declaration//GEN-END:variables
}
