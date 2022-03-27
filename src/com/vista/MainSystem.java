
package com.vista;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Component;
import java.awt.geom.RoundRectangle2D;
import java.time.LocalDate;
import javax.swing.UIManager;

public class MainSystem extends javax.swing.JFrame {

   
    public MainSystem() {
        initComponents();
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        int dia = now.getDayOfMonth();
        int month = now.getMonthValue();
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", " ;Septiembre",
             "Octubre", "Noviembre", "Diciemrbre"};
        lbFecha.setText("Hoy es " + dia + " de " + meses[month - 1] + " de " + year);   
   // this.setShape(new RoundRectangle2D.Double(0, 0, getWidth(),getHeight(), 20, 20));
    }
public void showForm(Component form) {
      // lbTitle.setText(title);
        panelBody.removeAll();
        panelBody.add(form);
        panelBody.repaint();
        panelBody.revalidate();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menus = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbFecha = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        imageAvatar1 = new com.swing.ImageAvatar();
        jLabel5 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        panelBody = new javax.swing.JPanel();
        MenuBar = new javax.swing.JMenuBar();
        Dasboard = new javax.swing.JMenu();
        menuPersonal = new javax.swing.JMenu();
        menuPNomina = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenu11 = new javax.swing.JMenu();

        menus.setAlignmentX(0.8F);
        menus.setAlignmentY(0.7F);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/Close_press.png"))); // NOI18N
        jMenuItem1.setText("jMenuItem1");
        menus.add(jMenuItem1);

        jMenu3.setText("jMenu3");

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/help.png"))); // NOI18N
        jMenuItem4.setText("jMenuItem4");
        jMenu3.add(jMenuItem4);

        jMenuItem5.setText("jMenuItem5");
        jMenu3.add(jMenuItem5);

        menus.add(jMenu3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(31, 44, 81));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Instituto Tecnológico Superior de la Montaña");

        lbFecha.setBackground(new java.awt.Color(255, 255, 255));
        lbFecha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbFecha.setForeground(new java.awt.Color(255, 255, 255));
        lbFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/today_20px.png"))); // NOI18N
        lbFecha.setText("Fecha de Hoy");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/itsm.png"))); // NOI18N
        jLabel4.setText("SGP");

        imageAvatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/avatar.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("User Name");

        jButton4.setBackground(new java.awt.Color(31, 44, 81));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/logout.png"))); // NOI18N
        jButton4.setBorderPainted(false);
        jButton4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/Logout_press.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 329, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(0, 0, 0)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelBody.setOpaque(false);
        panelBody.setLayout(new java.awt.BorderLayout());

        MenuBar.setBackground(new java.awt.Color(31, 44, 81));
        MenuBar.setBorderPainted(false);

        Dasboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/dashboard_1.png"))); // NOI18N
        Dasboard.setText("Tablero");
        Dasboard.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/dashboard_press.png"))); // NOI18N
        Dasboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DasboardActionPerformed(evt);
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

        menuPNomina.setText("Personal de Nómina");
        menuPNomina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPNominaActionPerformed(evt);
            }
        });
        menuPersonal.add(menuPNomina);

        jMenuItem6.setText("Personal por Honorarios");
        menuPersonal.add(jMenuItem6);

        jMenuItem7.setText("Dar de Baja");
        menuPersonal.add(jMenuItem7);

        jMenuItem9.setText("Expediente de Personal");
        menuPersonal.add(jMenuItem9);

        MenuBar.add(menuPersonal);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/search_2.png"))); // NOI18N
        jMenu4.setText("Consultas");

        jMenuItem10.setText("Consulta rápida");
        jMenu4.add(jMenuItem10);

        MenuBar.add(jMenu4);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/export_pdf.png"))); // NOI18N
        jMenu5.setText("Reporte");

        jMenuItem3.setText("Generar un Reporte");
        jMenu5.add(jMenuItem3);

        jMenuItem8.setText("Ficha de Personal");
        jMenu5.add(jMenuItem8);

        jMenu2.setText("Generar un Reporte");

        jMenuItem12.setText("Dias Festivos");
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

        jMenuItem16.setText("Otro");
        jMenu2.add(jMenuItem16);

        jMenu5.add(jMenu2);

        MenuBar.add(jMenu5);

        jMenu6.setText("Acciones");

        jMenuItem2.setText("Reportar Incidencia");
        jMenu6.add(jMenuItem2);

        jMenuItem11.setText("Generar pase de Salida");
        jMenu6.add(jMenuItem11);

        MenuBar.add(jMenu6);

        jMenu9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/database_adm.png"))); // NOI18N
        jMenu9.setText("Mantenimientos");
        MenuBar.add(jMenu9);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/Google Calendar.png"))); // NOI18N
        jMenu1.setText("Calendario");

        jMenuItem17.setText("Calendario Escolar");
        jMenu1.add(jMenuItem17);

        jMenuItem18.setText("Calendario de Google");
        jMenu1.add(jMenuItem18);

        MenuBar.add(jMenu1);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/caducidad.png"))); // NOI18N
        jMenu7.setText("Caducidad");
        MenuBar.add(jMenu7);

        jMenu10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/user_menu.png"))); // NOI18N
        jMenu10.setText("Usuarios");
        jMenu10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu10ActionPerformed(evt);
            }
        });

        jMenuItem19.setText("prueba");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem19);

        MenuBar.add(jMenu10);

        jMenu11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/help_m.png"))); // NOI18N
        jMenu11.setText("Ayuda");
        MenuBar.add(jMenu11);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelBody, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPersonalActionPerformed
      
    }//GEN-LAST:event_menuPersonalActionPerformed

    private void menuPNominaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPNominaActionPerformed
      this.showForm(new PersonalNomina());
    }//GEN-LAST:event_menuPNominaActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void DasboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DasboardActionPerformed
     showForm(new Dasboard());
    }//GEN-LAST:event_DasboardActionPerformed

    private void jMenu10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu10ActionPerformed
     this.showForm(new Usuarios());
    }//GEN-LAST:event_jMenu10ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
       this.showForm(new Usuarios());
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    /**
     * @param args the command line arguments
     */
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
    private com.swing.ImageAvatar imageAvatar1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuItem jMenuItem1;
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
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JMenuItem menuPNomina;
    private javax.swing.JMenu menuPersonal;
    private javax.swing.JPopupMenu menus;
    public javax.swing.JPanel panelBody;
    // End of variables declaration//GEN-END:variables
}
