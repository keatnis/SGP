package com.vista;

import com.DAO.CumpleañosDAO;
import com.component.ModelCard;
import com.model.ModelDasboard;
import com.DAO.DasboardDAO;
import com.component.ModelNoticeBoard;
import com.component.Model_Card2;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import com.connection.Conexion;
import com.model.ModelCumpleaños;
import com.vista.Reporte;
import java.time.LocalDate;
import javax.swing.ImageIcon;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import ds.desktop.notify.DesktopNotify;
import java.awt.Color;
import java.util.Random;

public final class Dasboard extends javax.swing.JPanel {

    ModelDasboard das;
    DasboardDAO dao;
    CumpleañosDAO daoCump = new CumpleañosDAO();

    String activo, inactivo, honorarios, nomina;

    public Dasboard() {
        initComponents();
        festividades();
        listDatos();
        init();
        initEventos();
    }

    public void init() {
        initNoticeBoard();
        try {
            listCumpleaños(JtableCumpleaños);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    public void initNoticeBoard() {

        LocalDate now = LocalDate.now();
        int year = now.getYear();
        int dia = now.getDayOfMonth();
        int month = now.getMonthValue();
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
            "Octubre", "Noviembre", "Diciemrbre"};
        Random randomGenerator = new Random();
        int red = randomGenerator.nextInt(255);
        int green = randomGenerator.nextInt(255);
        int blue = randomGenerator.nextInt(255);
//        noticeBoard.addDate("04/10/2021");
//        noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(94, 49, 238), "Hidemode", "Now", "Sets the hide ."));
        String fecha = dia + " de " + meses[month - 1] + " de " + year;
        card0011.setData(new Model_Card2(new ImageIcon(getClass().getResource("/com/icon/Today_64px.png")), "Hoy es", fecha, ""));
        card0011.setColor1(new Color(red, green, blue));
        
        

    }

    private void listCumpleaños(JTable tablaD) throws IOException {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaD.setModel(modeloTabla);

        tablaD.setRowHeight(20);

        modeloTabla.addColumn("Núm.Emp.");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Fecha (MM-dd)");
        modeloTabla.addColumn("Edad");
        //     modeloTabla.addColumn("Foto");
        TableColumnModel columnModel = tablaD.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(80);
        columnModel.getColumn(1).setPreferredWidth(200);
        columnModel.getColumn(2).setPreferredWidth(80);
        columnModel.getColumn(3).setPreferredWidth(70);
        //  columnModel.getColumn(4).setPreferredWidth(150);

        int numReg = daoCump.listCump().size();
        //numReg de solo UNA TABLA faltan las demas
        //   Object[] columna = new Object[4];
        int j = 0;
        for (int i = 0; i < numReg; i++) {

            String uno = daoCump.listCump().get(i).getNumEmple();
            String dos = daoCump.listCump().get(i).getNombreCompleto();
            String tres = daoCump.listCump().get(i).getFechaNac();
            String cuatro = daoCump.listCump().get(i).getEdad2();
          
            modeloTabla.addRow(new Object[]{uno, dos, tres, cuatro});

        }
    }

    private void initEventos() {
        Random randomGenerator = new Random();

        CumpleañosDAO dao2 = new CumpleañosDAO();
        //Recorrer el contenido del ArrayList
        ArrayList<ModelCumpleaños> arrayList = dao2.listFestividades();
        for (int i = 0; i < arrayList.size(); i++) {
            int red = randomGenerator.nextInt(255);
            int green = randomGenerator.nextInt(255);
            int blue = randomGenerator.nextInt(255);
            //Añadir cada elemento del ArrayList en el modelo de la lista
            noticeBoard1.addDate(arrayList.get(i).getFecha());
            card0011.setColor2(new Color(red, green, blue));
            noticeBoard1.addNoticeBoard(new ModelNoticeBoard(new Color(red, green, blue), "Barra de noticias", arrayList.get(i).getFecha(), arrayList.get(i).getNombresFestividad()));
        }
    }

    private void festividades() {
        LocalDate date_of_today = LocalDate.now();
        DateTimeFormatter format_date_of_today = DateTimeFormatter.ofPattern("MM-dd");

        String formattedDate = date_of_today.format(format_date_of_today);
        ArrayList<ModelCumpleaños> list = daoCump.listFestividades();

        ModelCumpleaños vo;
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                vo = list.get(i);

                if (vo.getFecha().equals(formattedDate) || (vo.getDias_falt() > 0 && vo.getDias_falt() <= 3)) {
                    DesktopNotify.showDesktopMessage(
                            "Notificacion de Festividad",
                            "Faltan " + vo.getDias_falt() + " día(s) para el " + vo.getNombresFestividad() + "!",
                            DesktopNotify.TIP);
                }
            }
        }
    }

    /**
     *
     */
    public void listDatos() {
        Conexion cc = new Conexion();
        Connection con = cc.getConnection();
        ResultSet res;
        try {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT (select count(id_empleado) from tbl_empleado where status=1 )as activo,(SELECT count(id_empleado) from tbl_empleado where status=0)as inactivo,sum( if(tipo_contratacion='Honorarios' and status=1,1,0))as honorarios,sum( if(tipo_contratacion='Nómina' and status=1,1,0))as nomina\n"
                    + "FROM tbl_empleo INNER JOIN tbl_empleado ON tbl_empleado.id_empleado=tbl_empleo.id_empleado;");
            res = ps.executeQuery();
            res.next();

            activo = String.valueOf(res.getInt("activo"));
            inactivo = String.valueOf(res.getInt("inactivo"));
            honorarios = String.valueOf(res.getInt("honorarios"));
            nomina = String.valueOf(res.getInt("nomina"));

            res.close();

            card1.setData(new ModelCard(null, null, null, activo, "Total de Personal Activo"));
            card2.setData(new ModelCard(null, null, null, nomina, "Personal de Nómina"));
            card3.setData(new ModelCard(null, null, null, honorarios, "Personal por Honorarios"));
            card4.setData(new ModelCard(null, null, null, inactivo, "Personal Inactivo"));

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (con != null) {
                    cc.cerrar();
                }
            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(null, "Error al intentar cerrar la conexión:\n"
                        + ex, "Error en la operación", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        card1 = new com.component.Card();
        card2 = new com.component.Card();
        card3 = new com.component.Card();
        card4 = new com.component.Card();
        card0011 = new com.component.Card001();
        jPanel4 = new javax.swing.JPanel();
        panelRound3 = new com.swing.PanelRound();
        jLabel3 = new javax.swing.JLabel();
        lbGenero = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        noticeBoard1 = new com.component.NoticeBoard();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        panelRound2 = new com.swing.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        lbimg = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtableCumpleaños = new com.component.Table();

        setOpaque(false);
        setLayout(new java.awt.GridBagLayout());

        jPanel1.setOpaque(false);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridLayout(1, 0, 8, 0));

        card1.setColor1(new java.awt.Color(0, 153, 0));
        card1.setColor2(new java.awt.Color(0, 102, 51));
        card1.setIcon(javaswingdev.GoogleMaterialDesignIcon.PEOPLE);
        jPanel2.add(card1);

        card2.setColor1(new java.awt.Color(0, 51, 102));
        card2.setColor2(new java.awt.Color(0, 51, 153));
        card2.setIcon(javaswingdev.GoogleMaterialDesignIcon.PERSON);
        card2.setInheritsPopupMenu(true);
        jPanel2.add(card2);

        card3.setColor1(new java.awt.Color(255, 153, 0));
        card3.setColor2(new java.awt.Color(255, 153, 0));
        card3.setIcon(javaswingdev.GoogleMaterialDesignIcon.PERSON);
        jPanel2.add(card3);

        card4.setColor1(java.awt.Color.red);
        card4.setColor2(new java.awt.Color(153, 0, 0));
        card4.setIcon(javaswingdev.GoogleMaterialDesignIcon.ARROW_DROP_DOWN);
        jPanel2.add(card4);

        card0011.setColor1(new java.awt.Color(0, 51, 204));
        card0011.setColor2(new java.awt.Color(0, 153, 153));

        jPanel4.setOpaque(false);

        panelRound3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Reportes");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbGenero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbGenero.setText("Reporte Gráfico >>Ver");
        lbGenero.setToolTipText("");
        lbGenero.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbGenero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbGeneroMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbGeneroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbGeneroMouseExited(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/analitica.png"))); // NOI18N

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(lbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(lbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setOpaque(false);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/icons8-evento-aceptado-de-forma-provisional-48.png"))); // NOI18N

        jButton1.setText("Añadir ");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Eventos y festividades de este mes");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(noticeBoard1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel4))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(noticeBoard1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelRound2.setBackground(new java.awt.Color(255, 255, 255));
        panelRound2.setForeground(new java.awt.Color(153, 153, 153));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Este mes cumplen años");

        lbimg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/icons8-fecha-de-cumpleaños-88.png"))); // NOI18N

        JtableCumpleaños.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        JtableCumpleaños.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(JtableCumpleaños);

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(65, 65, 65)
                        .addComponent(lbimg, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbimg, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel2)))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(card0011, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 989, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(card0011, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 13);
        add(jPanel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void lbGeneroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbGeneroMouseEntered
        lbGenero.setFont(new java.awt.Font("Segoe UI", 1, 14));
    }//GEN-LAST:event_lbGeneroMouseEntered

    private void lbGeneroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbGeneroMouseExited
        lbGenero.setFont(new java.awt.Font("Segoe UI", 0, 14));
    }//GEN-LAST:event_lbGeneroMouseExited

    private void lbGeneroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbGeneroMouseClicked
        Reporte rp = new Reporte();
        rp.setVisible(true);
    }//GEN-LAST:event_lbGeneroMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.component.Table JtableCumpleaños;
    private com.component.Card001 card0011;
    private com.component.Card card1;
    private com.component.Card card2;
    private com.component.Card card3;
    private com.component.Card card4;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lbGenero;
    private javax.swing.JLabel lbimg;
    private com.component.NoticeBoard noticeBoard1;
    private com.swing.PanelRound panelRound2;
    private com.swing.PanelRound panelRound3;
    // End of variables declaration//GEN-END:variables
}
