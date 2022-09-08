package com.vista;

import com.DAO.CaducidadDAO;
import com.DAO.CumpleañosDAO;
import com.classes.PanelBackground;
import com.model.ModelCaducidad;
import com.model.ModelCumpleaños;
import com.model.ModelUsers;
import com.notification.Notification;
import java.awt.BorderLayout;
import java.awt.Component;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.swing.dialog.MessageDialog;
import ds.desktop.notify.DesktopNotify;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class MainSystem2 extends javax.swing.JFrame {

    private ModelUsers user;
    private Notification.Type type;
    private Login splashFrame;
    private PanelBackground panelBackground;

    public MainSystem2() {

        initComponents();
      //  MenuBar.setVisible(false);
      

    }

   
    public void changeBackgroundImage(String image) {
        if (image.equals("")) {
            panelBackground1.setImage(new ImageIcon(getClass().getResource("/com/icon/3133.jpg")));
        } else {
            String path = "/com/raven/background/1.jpg" + image;
            panelBackground1.setImage(new ImageIcon(getClass().getResource(path)));
        }
    }

    MainSystem2(ModelUsers user, Login splashFrame) {
        this.splashFrame = splashFrame;
        setProgress(0, "Cargando componentes del Sistema");
        initComponents();
        setProgress(15, "Conectándose la base de datos");
        setProgress(23, "Cargando Módulos");
       this.showForm(new Empty(), "Inicio");
        setProgress(65, "Cargando interfaces");
        // this.setShape(new RoundRectangle2D.Double(0, 0, getWidth(),getHeight(), 20, 20));
        this.user = user;
        lbUser.setText(user.getNombre());
        if (user.getAvatar() == null) {

            imgAvatar.setIcon(new ImageIcon(getClass().getResource("src/com/icon/avatar.png")));

        } else {
            imgAvatar.setIcon(new ImageIcon(user.getAvatar()));
        }
        this.repaint();
        lbTitle.setText("");
        setProgress(65, "Cargando interfaces");
        changeBackgroundImage("");
        setProgress(100, "Carga completa");
        initn();
       
    }

    void prueba(Notification.Type type, Notification.Location location, String message) {
        Notification nt = new Notification(this, type, location, message);
        nt.showNotification();

    }

    private void setProgress(int percent, String information) {
        splashFrame.getlbprogress().setText(information);
        splashFrame.getProgressBar().setValue(percent);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            JOptionPane.showMessageDialog(null, "No se pudo ejecutar");
        }
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

    private void caducidad() {

        CaducidadDAO daocad = new CaducidadDAO();

        LocalDateTime date_of_today = LocalDateTime.now();
        DateTimeFormatter format_date_of_today = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = date_of_today.format(format_date_of_today);
        ArrayList<ModelCaducidad> list = daocad.listado();
        ModelCaducidad vo;
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                vo = list.get(i);

                if (vo.getFecha_vencimiento().equals(formattedDate)) {
                    DesktopNotify.showDesktopMessage(
                            "Notificacion de Caducidad",
                            "El doumento(" + vo.getNombre_doc() + ") de " + vo.getNombre() + " caduca hoy!",
                            DesktopNotify.WARNING);
                }
            }
        }
    }

    private void avisoCumpleaños() throws IOException {

        CumpleañosDAO daocum = new CumpleañosDAO();
        LocalDate date_of_today = LocalDate.now();
        DateTimeFormatter format_date_of_today = DateTimeFormatter.ofPattern("MM-dd");
        String formattedDate = date_of_today.format(format_date_of_today);
        ArrayList<ModelCumpleaños> list = daocum.listCump();
        ModelCumpleaños vo;
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                vo = list.get(i);

                if (vo.getFechaNac().equals(formattedDate)) {
                    DesktopNotify.showDesktopMessage(
                            " Notificacion de Cumpleaños",
                            "" + vo.getNombreCompleto() + " cumple años hoy!!",
                            DesktopNotify.INFORMATION);
                }
            }
        }
    }

    public void initn() {
        caducidad();
        try {
            avisoCumpleaños();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popMenuUsuario = new javax.swing.JPopupMenu();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem25 = new javax.swing.JMenuItem();
        panelBackground1 = new com.classes.PanelBackground();
        panelEnc = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        imgAvatar = new com.swing.ImageAvatar();
        lbUser = new javax.swing.JLabel();
        buttonBadges2 = new com.swing.ButtonBadges();
        lbTitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panelBody = new javax.swing.JPanel();
        etiquetaReloj = new javax.swing.JLabel();
        lbFecha = new javax.swing.JLabel();
        MenuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        incidencias = new javax.swing.JMenu();
        pasesalida = new javax.swing.JMenuItem();
        ReportarIncidencia = new javax.swing.JMenuItem();
        reportarincidencia = new javax.swing.JMenuItem();
        verRegistros = new javax.swing.JMenuItem();
        informes = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        caducidad = new javax.swing.JMenu();
        ayuda = new javax.swing.JMenu();

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
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panelBackground1.setBackground(new java.awt.Color(51, 153, 255));

        panelEnc.setBackground(new java.awt.Color(0, 47, 85));
        panelEnc.setInheritsPopupMenu(true);
        panelEnc.setOpaque(false);
        panelEnc.setPreferredSize(new java.awt.Dimension(1374, 74));

        imgAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/avatar.png"))); // NOI18N

        lbUser.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbUser.setForeground(new java.awt.Color(255, 255, 255));
        lbUser.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbUser.setText("User Name");
        lbUser.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        buttonBadges2.setForeground(new java.awt.Color(0, 30, 176));
        buttonBadges2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/notification.png"))); // NOI18N
        buttonBadges2.setBadges(8);
        buttonBadges2.setBorderPainted(false);
        buttonBadges2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBadges2ActionPerformed(evt);
            }
        });

        lbTitle.setFont(new java.awt.Font("Poppins SemiBold", 1, 20)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(255, 255, 255));
        lbTitle.setText("Titulo del Módulo");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/icons8-menú-30.png"))); // NOI18N
        jLabel1.setText("MENÚ");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelEncLayout = new javax.swing.GroupLayout(panelEnc);
        panelEnc.setLayout(panelEncLayout);
        panelEncLayout.setHorizontalGroup(
            panelEncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEncLayout.createSequentialGroup()
                .addGroup(panelEncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEncLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelEncLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 404, Short.MAX_VALUE)
                .addComponent(lbTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 283, Short.MAX_VALUE)
                .addGroup(panelEncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonBadges2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbUser, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imgAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        panelEncLayout.setVerticalGroup(
            panelEncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEncLayout.createSequentialGroup()
                .addGroup(panelEncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEncLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelEncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelEncLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(lbTitle)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelEncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panelEncLayout.createSequentialGroup()
                            .addComponent(lbUser)
                            .addGap(1, 1, 1)
                            .addComponent(buttonBadges2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(imgAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelBody.setOpaque(false);
        panelBody.setLayout(new java.awt.BorderLayout());

        etiquetaReloj.setFont(new java.awt.Font("Century Gothic", 0, 48)); // NOI18N
        etiquetaReloj.setForeground(new java.awt.Color(255, 255, 255));
        etiquetaReloj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaReloj.setText("jLabel2");
        panelBody.add(etiquetaReloj, java.awt.BorderLayout.CENTER);

        lbFecha.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        lbFecha.setForeground(new java.awt.Color(255, 255, 255));
        lbFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFecha.setText("Hoy es ");
        panelBody.add(lbFecha, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout panelBackground1Layout = new javax.swing.GroupLayout(panelBackground1);
        panelBackground1.setLayout(panelBackground1Layout);
        panelBackground1Layout.setHorizontalGroup(
            panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBackground1Layout.createSequentialGroup()
                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelEnc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1279, Short.MAX_VALUE)
                    .addComponent(panelBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        panelBackground1Layout.setVerticalGroup(
            panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackground1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelEnc, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelBody, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        MenuBar.setBackground(new java.awt.Color(31, 44, 81));
        MenuBar.setBorderPainted(false);
        MenuBar.setFocusTraversalPolicyProvider(true);
        MenuBar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MenuBar.setOpaque(false);
        MenuBar.setPreferredSize(new java.awt.Dimension(903, 28));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/dashboard_1.png"))); // NOI18N
        jMenu1.setText("Inicio");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        MenuBar.add(jMenu1);

        incidencias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/icons8-documento-30.png"))); // NOI18N
        incidencias.setText("Control de Incidencias");
        incidencias.setFocusPainted(true);

        pasesalida.setText("Generar pase de Salida");
        pasesalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasesalidaActionPerformed(evt);
            }
        });
        incidencias.add(pasesalida);

        ReportarIncidencia.setText("Persmiso Económico");
        ReportarIncidencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReportarIncidenciaActionPerformed(evt);
            }
        });
        incidencias.add(ReportarIncidencia);

        reportarincidencia.setText("Reportar Incidencia");
        reportarincidencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportarincidenciaActionPerformed(evt);
            }
        });
        incidencias.add(reportarincidencia);

        verRegistros.setText("Ver registros");
        verRegistros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verRegistrosActionPerformed(evt);
            }
        });
        incidencias.add(verRegistros);

        MenuBar.add(incidencias);

        informes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/pdf30.png"))); // NOI18N
        informes.setText("Informes");

        jMenuItem3.setText("Generar un Reporte del Personal");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        informes.add(jMenuItem3);

        jMenuItem8.setText("Ficha de Personal");
        informes.add(jMenuItem8);

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

        informes.add(jMenu2);

        MenuBar.add(informes);

        caducidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/caducidad.png"))); // NOI18N
        caducidad.setText("Caducidad");
        caducidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                caducidadMouseClicked(evt);
            }
        });
        MenuBar.add(caducidad);

        ayuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/help_m.png"))); // NOI18N
        ayuda.setText("Ayuda");
        MenuBar.add(ayuda);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void reportarincidenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportarincidenciaActionPerformed
        this.showForm(new ReportarIncidencia(user.getUsuario()), "Reportar Incidencia");
    }//GEN-LAST:event_reportarincidenciaActionPerformed

    private void pasesalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasesalidaActionPerformed
        this.showForm(new PaseSalida(), "Generar Pase de Salida");
    }//GEN-LAST:event_pasesalidaActionPerformed

    private void verRegistrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verRegistrosActionPerformed
        this.showForm(new RegistroIncidencias(), "Registro de incidencias");
    }//GEN-LAST:event_verRegistrosActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        this.showForm(new ListadoPersonal(), "Generar un Listado de personal");
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        this.showForm(new DiasFestivos(), "Generar un reporte de días festivos");
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void caducidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_caducidadMouseClicked
        this.showForm(new Caducidad(), "Vencimiento de documentos");
    }//GEN-LAST:event_caducidadMouseClicked

    private void jMenuItem24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem24ActionPerformed
        //prueba de grafica
        this.showForm(new Reporte(), "Reporte GEnero");
    }//GEN-LAST:event_jMenuItem24ActionPerformed

    private void ReportarIncidenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReportarIncidenciaActionPerformed
        this.showForm(new PermisoEconomico(), "Genrerar Permiso Económico");
    }//GEN-LAST:event_ReportarIncidenciaActionPerformed

    private void buttonBadges2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBadges2ActionPerformed
        initn();
    }//GEN-LAST:event_buttonBadges2ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        if (!MenuBar.isVisible()) {
            MenuBar.setVisible(true);
        } else {
            MenuBar.setVisible(false);
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
   this.showForm(new Empty(), "Inicio");
    }//GEN-LAST:event_jMenu1MouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       MessageDialog obj = new MessageDialog(this);
        obj.showMessage("¿Está seguro(a) que desea cerrar la ventana?", "Al darle clic en aceptar, se apagará el sistema");
    }//GEN-LAST:event_formWindowClosing

//    public static void main(String args[]) {
//        FlatIntelliJLaf.registerCustomDefaultsSource("com/style");
////        FlatLightLaf.setup();
//        FlatIntelliJLaf.setup();
//
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MainSystem2().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem ReportarIncidencia;
    private javax.swing.JMenu ayuda;
    private com.swing.ButtonBadges buttonBadges2;
    private javax.swing.JMenu caducidad;
    private javax.swing.JLabel etiquetaReloj;
    private com.swing.ImageAvatar imgAvatar;
    private javax.swing.JMenu incidencias;
    private javax.swing.JMenu informes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel lbFecha;
    public javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbUser;
    private com.classes.PanelBackground panelBackground1;
    public javax.swing.JPanel panelBody;
    private javax.swing.JPanel panelEnc;
    private javax.swing.JMenuItem pasesalida;
    private javax.swing.JPopupMenu popMenuUsuario;
    private javax.swing.JMenuItem reportarincidencia;
    private javax.swing.JMenuItem verRegistros;
    // End of variables declaration//GEN-END:variables
}
