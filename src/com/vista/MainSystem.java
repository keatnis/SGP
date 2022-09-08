package com.vista;

import com.DAO.CaducidadDAO;
import com.DAO.CumpleañosDAO;
import com.classes.PanelBackground;
import com.component.cambiarContraseña;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.model.ModelCaducidad;
import com.model.ModelCumpleaños;
import com.model.ModelUsers;
import com.notification.Notification;
import com.swing.dialog.MessageDialog;
import java.awt.BorderLayout;
import java.awt.Component;
//import java.awt.Frame;
import com.vista.Login;
import ds.desktop.notify.DesktopNotify;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class MainSystem extends javax.swing.JFrame {

    private ModelUsers user;
    private Notification.Type type;
    private Login splashFrame;
    private PanelBackground panelBackground;

    public MainSystem() {

        initComponents();
        MenuBar.setVisible(false);
        this.showForm(new Dasboard(), "Dasboard");
        changeBackgroundImage("");
//        this.showForm(new Dasboard(), "Dasboard");

    }

    public void changeBackgroundImage(String image) {
        if (image.equals("")) {
            panelBackground1.setImage(new ImageIcon(getClass().getResource("/com/icon/3133.jpg")));
        } else {
            String path = "/com/raven/background/1.jpg" + image;
            panelBackground1.setImage(new ImageIcon(getClass().getResource(path)));
        }
    }
//    public MainSystem(ModelUsers user) {
//
//        initComponents();
//        this.showForm(new Dasboard(), "Dasboard");
//
//        // this.setShape(new RoundRectangle2D.Double(0, 0, getWidth(),getHeight(), 20, 20));
//        this.user = user;
//        lbUser.setText(user.getNombre());
//        if (user.getAvatar() == null) {
//
//            imgAvatar.setIcon(new ImageIcon(getClass().getResource("src/com/icon/avatar.png")));
//
//        } else {
//            imgAvatar.setIcon(new ImageIcon(user.getAvatar()));
//        }
//        this.repaint();
//    }

    MainSystem(ModelUsers user, Login splashFrame) {
        this.splashFrame = splashFrame;
        setProgress(0, "Cargando componentes del Sistema");
        initComponents();
        setProgress(15, "Conectándose la base de datos");
        setProgress(23, "Cargando Módulos");
        this.showForm(new Dasboard(), "Dasboard");
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
        cambiarAvatar = new javax.swing.JMenuItem();
        cambiarContraseña = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        CerrarSesion = new javax.swing.JMenuItem();
        panelBackground1 = new com.classes.PanelBackground();
        panelEnc = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        imgAvatar = new com.swing.ImageAvatar();
        lbUser = new javax.swing.JLabel();
        buttonBadges2 = new com.swing.ButtonBadges();
        lbTitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        panelBody = new javax.swing.JPanel();
        MenuBar = new javax.swing.JMenuBar();
        Dasboard = new javax.swing.JMenu();
        menuPersonal = new javax.swing.JMenu();
        menuLista = new javax.swing.JMenuItem();
        dardeAlta = new javax.swing.JMenuItem();
        baja = new javax.swing.JMenuItem();
        perfil = new javax.swing.JMenuItem();
        directorio = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
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
        convocatorias = new javax.swing.JMenu();
        cursos = new javax.swing.JMenu();
        ajustes = new javax.swing.JMenu();
        ayuda = new javax.swing.JMenu();

        cambiarAvatar.setText("Cambiar Icono");
        cambiarAvatar.setActionCommand("cvbvb");
        popMenuUsuario.add(cambiarAvatar);
        cambiarAvatar.getAccessibleContext().setAccessibleName("MenuUser");
        cambiarAvatar.getAccessibleContext().setAccessibleDescription("MenuUser");

        cambiarContraseña.setText("Cambiar conrtraseña");
        cambiarContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarContraseñaActionPerformed(evt);
            }
        });
        popMenuUsuario.add(cambiarContraseña);
        popMenuUsuario.add(jSeparator1);

        CerrarSesion.setText("Cerrar Sesion");
        CerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarSesionActionPerformed(evt);
            }
        });
        popMenuUsuario.add(CerrarSesion);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("SISTEMA DE GESTIÓN DE PERSONAL");
        setMaximumSize(new java.awt.Dimension(3647, 2147));
        setPreferredSize(new java.awt.Dimension(1300, 723));
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

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/settings_25px.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setComponentPopupMenu(popMenuUsuario);
        jButton1.setContentAreaFilled(false);

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 400, Short.MAX_VALUE)
                .addComponent(lbTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 283, Short.MAX_VALUE)
                .addGroup(panelEncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbUser, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                    .addGroup(panelEncLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonBadges2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(imgAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        panelEncLayout.setVerticalGroup(
            panelEncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEncLayout.createSequentialGroup()
                .addGroup(panelEncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEncLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelEncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTitle))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelEncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panelEncLayout.createSequentialGroup()
                            .addComponent(lbUser)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panelEncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonBadges2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                        .addComponent(imgAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelBody.setOpaque(false);
        panelBody.setLayout(new java.awt.BorderLayout());

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

        Dasboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/dashboard_1.png"))); // NOI18N
        Dasboard.setText("Inicio");
        Dasboard.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
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

        menuLista.setText("Lista");
        menuLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListaActionPerformed(evt);
            }
        });
        menuPersonal.add(menuLista);

        dardeAlta.setText("Dar de Alta");
        dardeAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dardeAltaActionPerformed(evt);
            }
        });
        menuPersonal.add(dardeAlta);

        baja.setText("Dar de Baja");
        baja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bajaActionPerformed(evt);
            }
        });
        menuPersonal.add(baja);

        perfil.setText("Perfil de personal");
        perfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perfilActionPerformed(evt);
            }
        });
        menuPersonal.add(perfil);

        directorio.setText("Directorio");
        directorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                directorioActionPerformed(evt);
            }
        });
        menuPersonal.add(directorio);

        jMenuItem1.setText("Listado Completo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuPersonal.add(jMenuItem1);

        MenuBar.add(menuPersonal);

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
        informes.setText("Reportes");

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

        convocatorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/icons8-attract-customers-48.png"))); // NOI18N
        convocatorias.setText("Convocatorias");
        convocatorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                convocatoriasMouseClicked(evt);
            }
        });
        MenuBar.add(convocatorias);

        cursos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/icons8-client-management-48.png"))); // NOI18N
        cursos.setText("Capacitación");
        cursos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cursosMouseClicked(evt);
            }
        });
        MenuBar.add(cursos);

        ajustes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/database_adm.png"))); // NOI18N
        ajustes.setText("Ajustes");
        ajustes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ajustesMouseClicked(evt);
            }
        });
        ajustes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajustesActionPerformed(evt);
            }
        });
        MenuBar.add(ajustes);

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

    private void menuPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPersonalActionPerformed

    }//GEN-LAST:event_menuPersonalActionPerformed

    private void menuListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListaActionPerformed
        this.showForm(new ListadoPersonal(), "Listado de personal acivo");
    }//GEN-LAST:event_menuListaActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void DasboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DasboardMouseClicked
        // TODO add your handling code here:
        this.showForm(new Dasboard(), "Dasboard");
    }//GEN-LAST:event_DasboardMouseClicked

    private void dardeAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dardeAltaActionPerformed
        this.showForm(new RegistrarPN(), "Registro de Personal");
    }//GEN-LAST:event_dardeAltaActionPerformed

    private void bajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bajaActionPerformed
        this.showForm(new BajaPersonal(), "Motivo de Baja");
    }//GEN-LAST:event_bajaActionPerformed

    private void reportarincidenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportarincidenciaActionPerformed
        this.showForm(new ReportarIncidencia(user.getUsuario()), "Reportar Incidencia");
    }//GEN-LAST:event_reportarincidenciaActionPerformed

    private void pasesalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasesalidaActionPerformed
        this.showForm(new PaseSalida(), "Generar Pase de Salida");
    }//GEN-LAST:event_pasesalidaActionPerformed

    private void perfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perfilActionPerformed
        this.showForm(new Perfil(), "Modificar y actualizar datos");
    }//GEN-LAST:event_perfilActionPerformed

    private void verRegistrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verRegistrosActionPerformed
        this.showForm(new RegistroIncidencias(), "Registro de incidencias");
    }//GEN-LAST:event_verRegistrosActionPerformed

    private void ajustesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajustesActionPerformed
        this.showForm(new Mantenimiento(), "Mantenimiento");
    }//GEN-LAST:event_ajustesActionPerformed

    private void ajustesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ajustesMouseClicked
        this.showForm(new Ajustes(), "Ajustes");
    }//GEN-LAST:event_ajustesMouseClicked

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        this.showForm(new ListadoPersonal(), "Generar un Listado de personal");
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void directorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_directorioActionPerformed
        this.showForm(new Directorio(), "Directorio");
    }//GEN-LAST:event_directorioActionPerformed

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

    private void convocatoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_convocatoriasMouseClicked
        this.showForm(new Reclutamiento(), "Convocatorias");
    }//GEN-LAST:event_convocatoriasMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        if (!MenuBar.isVisible()) {
            MenuBar.setVisible(true);
        } else {
            MenuBar.setVisible(false);
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void cursosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cursosMouseClicked
        this.showForm(new Cursos(), "Cursos");
    }//GEN-LAST:event_cursosMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.showForm(new Listado(), "Lista de Personal");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        MessageDialog obj = new MessageDialog(this);
        obj.showMessage("¿Está seguro(a) que desea salir del sistema?", "Al darle clic en aceptar, se apagará el sistema");


    }//GEN-LAST:event_formWindowClosing

    private void CerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarSesionActionPerformed

        int option = JOptionPane.showConfirmDialog(null, "Aviso", "Esta seguro(a) de cerrar el sistema?", JOptionPane.OK_CANCEL_OPTION);
        if (option == 0) {
            this.dispose();
            Login login = new Login();
            login.setVisible(true);
        }


    }//GEN-LAST:event_CerrarSesionActionPerformed

    private void cambiarContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarContraseñaActionPerformed
        cambiarContraseña dialog = new cambiarContraseña(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                dialog.setVisible(false);
            }
        });
        dialog.changePassword(user);
        dialog.setVisible(true);

    }//GEN-LAST:event_cambiarContraseñaActionPerformed

//    public static void main(ModelUsers user) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MainSystem(user).setVisible(true);
//            }
//        });
//    }
    public static void main(String args[]) {
        FlatIntelliJLaf.registerCustomDefaultsSource("com/style");
        FlatLightLaf.setup();
        FlatIntelliJLaf.setup();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainSystem().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CerrarSesion;
    private javax.swing.JMenu Dasboard;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem ReportarIncidencia;
    private javax.swing.JMenu ajustes;
    private javax.swing.JMenu ayuda;
    private javax.swing.JMenuItem baja;
    private com.swing.ButtonBadges buttonBadges2;
    private javax.swing.JMenu caducidad;
    private javax.swing.JMenuItem cambiarAvatar;
    private javax.swing.JMenuItem cambiarContraseña;
    private javax.swing.JMenu convocatorias;
    private javax.swing.JMenu cursos;
    private javax.swing.JMenuItem dardeAlta;
    private javax.swing.JMenuItem directorio;
    private com.swing.ImageAvatar imgAvatar;
    private javax.swing.JMenu incidencias;
    private javax.swing.JMenu informes;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    public javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbUser;
    private javax.swing.JMenuItem menuLista;
    private javax.swing.JMenu menuPersonal;
    private com.classes.PanelBackground panelBackground1;
    public javax.swing.JPanel panelBody;
    private javax.swing.JPanel panelEnc;
    private javax.swing.JMenuItem pasesalida;
    private javax.swing.JMenuItem perfil;
    private javax.swing.JPopupMenu popMenuUsuario;
    private javax.swing.JMenuItem reportarincidencia;
    private javax.swing.JMenuItem verRegistros;
    // End of variables declaration//GEN-END:variables
}
