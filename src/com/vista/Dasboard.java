package com.vista;

import com.component.ModelCard;
import com.component.ModelNoticeBoard;
import com.model.ModelDasboard;
import java.awt.Color;
import com.DAO.DasboardDAO;
import com.component.Model_Card2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import com.connection.Conexion;
import com.notification.Notification;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.CardLayout;
import java.time.LocalDate;
import javax.swing.ImageIcon;
import com.vista.MainSystem;
public class Dasboard extends javax.swing.JPanel  {

    ModelDasboard das;
    DasboardDAO dao;
    String total;
  // MainSystem main=new MainSystem();
    ReporteGenero rg=new ReporteGenero();
    
final static String ventana1 = "Ventana ";
final static String ventana2 = "Card with JTextField";


ReporteGenero v2=new ReporteGenero();
    public Dasboard() {
        initComponents();
        initNoticeBoard();
        listDatos();
   
    }

    void initNoticeBoard() {
       LocalDate now = LocalDate.now();
        int year = now.getYear();
        int dia = now.getDayOfMonth();
        int month = now.getMonthValue();
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", " ;Septiembre",
             "Octubre", "Noviembre", "Diciemrbre"};
   

       this.add(v2,ventana2);
        noticeBoard.addDate("04/10/2021");
        noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(94, 49, 238), "Hidemode", "Now", "Sets the hide mode for the component. If the hide mode has been specified in the This hide mode can be overridden by the component constraint."));
      
        String fecha=dia + " de " + meses[month - 1] + " de " + year;
        card0011.setData(new Model_Card2(new ImageIcon(getClass().getResource("/com/icon/today_20px.png")), "Hoy es", fecha,""));
    }

                 
    
    public void listDatos() {
       Conexion cc = new Conexion();
       Connection con = cc.getConnection();
       ModelDasboard md = new ModelDasboard();
        try {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT count(id_empleado) from tbl_empleado");
            ResultSet res = ps.executeQuery();
            res.next();
            total = String.valueOf(res.getInt("count(id_empleado)"));
            md.setMax(String.valueOf(res.getInt("count(id_empleado)")));
            System.out.println("esto " + md.getMax());
            res.close();

            card1.setData(new ModelCard(null, null, null, total, "Total de Personal Activo"));
            card2.setData(new ModelCard(null, null, null, total, "Personal de Nómina"));
            card3.setData(new ModelCard(null, null, null, "0", "Personal por Honorarios"));
            card4.setData(new ModelCard(null, null, null, "0", "Personal dado de baja"));
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelRound2 = new com.swing.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        card1 = new com.component.Card();
        card2 = new com.component.Card();
        card3 = new com.component.Card();
        card4 = new com.component.Card();
        panelRound3 = new com.swing.PanelRound();
        jLabel3 = new javax.swing.JLabel();
        lbDepartamento = new javax.swing.JLabel();
        lbCategoria = new javax.swing.JLabel();
        lbGenero = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        card0011 = new com.component.Card001();
        panelRound1 = new com.swing.PanelRound();
        noticeBoard = new com.component.NoticeBoard();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        panelRound2.setBackground(new java.awt.Color(255, 255, 255));
        panelRound2.setForeground(new java.awt.Color(153, 153, 153));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Este mes cumplen años");

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Fecha de nacimiento", "Edad"
            }
        ));
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setEnabled(false);
        jTable1.setRowHeight(18);
        jTable1.setRowSelectionAllowed(false);
        jTable1.setShowGrid(true);
        jTable1.setShowVerticalLines(false);
        jScrollPane2.setViewportView(jTable1);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/globos-de-aire (1).png"))); // NOI18N

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(211, 211, 211)
                        .addComponent(jLabel4))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel2)
                        .addGap(41, 41, 41)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)))
                .addContainerGap(96, Short.MAX_VALUE))
        );

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

        panelRound3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Reportes");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbDepartamento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbDepartamento.setText("Personal por departamento");
        lbDepartamento.setToolTipText("");
        lbDepartamento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbDepartamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbDepartamentoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbDepartamentoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbDepartamentoMouseExited(evt);
            }
        });

        lbCategoria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbCategoria.setText("Personal por categoría");
        lbCategoria.setToolTipText("");
        lbCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbCategoriaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbCategoriaMouseExited(evt);
            }
        });

        lbGenero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbGenero.setText("Personal por género");
        lbGenero.setToolTipText("");
        lbGenero.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
                .addGap(25, 25, 25)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(77, 77, 77)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(40, 40, 40))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(lbDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(lbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        card0011.setColor1(new java.awt.Color(102, 102, 255));
        card0011.setColor2(new java.awt.Color(0, 153, 153));

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Próximos Eventos");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(noticeBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(noticeBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(card0011, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(card0011, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents
  
    private void lbDepartamentoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDepartamentoMouseEntered
        lbDepartamento.setFont(new java.awt.Font("Segoe UI", 1, 14));
    }//GEN-LAST:event_lbDepartamentoMouseEntered

    private void lbDepartamentoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDepartamentoMouseExited
        lbDepartamento.setFont(new java.awt.Font("Segoe UI", 0, 14));
    }//GEN-LAST:event_lbDepartamentoMouseExited

    private void lbCategoriaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCategoriaMouseEntered
        lbCategoria.setFont(new java.awt.Font("Segoe UI", 1, 14));
    }//GEN-LAST:event_lbCategoriaMouseEntered

    private void lbCategoriaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCategoriaMouseExited
        lbCategoria.setFont(new java.awt.Font("Segoe UI", 0, 14));
    }//GEN-LAST:event_lbCategoriaMouseExited

    private void lbGeneroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbGeneroMouseEntered
        lbGenero.setFont(new java.awt.Font("Segoe UI", 1, 14));
    }//GEN-LAST:event_lbGeneroMouseEntered

    private void lbGeneroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbGeneroMouseExited
        lbGenero.setFont(new java.awt.Font("Segoe UI", 0, 14));
    }//GEN-LAST:event_lbGeneroMouseExited

    private void lbGeneroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbGeneroMouseClicked
  
          CardLayout cl=(CardLayout)(this.getLayout());
     cl.show(this, ventana2);
        Notification panel = new Notification(new MainSystem(), Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Reporte de personal por Género");
        panel.showNotification();

    }//GEN-LAST:event_lbGeneroMouseClicked

    private void lbDepartamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDepartamentoMouseClicked
     //  main.showForm(new ReporteGenero());
    }//GEN-LAST:event_lbDepartamentoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.component.Card001 card0011;
    private com.component.Card card1;
    private com.component.Card card2;
    private com.component.Card card3;
    private com.component.Card card4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbCategoria;
    private javax.swing.JLabel lbDepartamento;
    public javax.swing.JLabel lbGenero;
    private com.component.NoticeBoard noticeBoard;
    private com.swing.PanelRound panelRound1;
    private com.swing.PanelRound panelRound2;
    private com.swing.PanelRound panelRound3;
    // End of variables declaration//GEN-END:variables
}
