package com.vista;

import static com.vista.Ajustes.ventana2;
import static com.vista.Ajustes.usuarios;
import static com.vista.Ajustes.bd;
import java.awt.CardLayout;

public class Ajustes extends javax.swing.JPanel {

    final static String ventana1 = "Ajustes";
    final static String ventana2 = "Mantenimiento";
    final static String usuarios = "Usuarios";
    final static String bd = "Base de datos";
    final static String actEnc ="Ventana Encabezados";
    Mantenimiento v2 = new Mantenimiento();
    Usuarios v3 = new Usuarios();
    BaseDatos base = new BaseDatos();
     Encabezados encabezados = new Encabezados();
    public Ajustes() {
        initComponents();
        this.add(v2, ventana2);
        this.add(v3, usuarios);
        this.add(base, bd);
        this.add(encabezados,actEnc);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnActualizacion = new javax.swing.JButton();
        btnUsuarios = new javax.swing.JButton();
        btnBD = new javax.swing.JButton();
        btnEncazados = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        setOpaque(false);
        setLayout(new java.awt.GridBagLayout());

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnActualizacion.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        btnActualizacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/icons8-aprobar-y-actualizar-48.png"))); // NOI18N
        btnActualizacion.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnActualizacion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActualizacion.setLabel("<html> <center>Actualizar y agregar Jefe Inmediato, Puestos y Areas de Adscripción</center></html> ");
        btnActualizacion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnActualizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizacionActionPerformed(evt);
            }
        });
        jPanel2.add(btnActualizacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 200, 111));

        btnUsuarios.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        btnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/icons8-user-64.png"))); // NOI18N
        btnUsuarios.setText("Usuarios");
        btnUsuarios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUsuarios.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });
        jPanel2.add(btnUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 200, 111));

        btnBD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/icons8-configuración-de-datos-48.png"))); // NOI18N
        btnBD.setText("Respaldo Base de datos");
        btnBD.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBD.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBDActionPerformed(evt);
            }
        });
        jPanel2.add(btnBD, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 200, 111));

        btnEncazados.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEncazados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/icons8-heading-title--64.png"))); // NOI18N
        btnEncazados.setText("<html><center>Modificar encabezados de Reportes</center></html>");
        btnEncazados.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEncazados.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEncazados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncazadosActionPerformed(evt);
            }
        });
        jPanel2.add(btnEncazados, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 50, 200, 111));

        add(jPanel2, new java.awt.GridBagConstraints());
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizacionActionPerformed
        CardLayout cl = (CardLayout) (this.getLayout());
        cl.show(this, ventana2);
    }//GEN-LAST:event_btnActualizacionActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        CardLayout cl = (CardLayout) (this.getLayout());
        cl.show(this, usuarios);
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBDActionPerformed
        CardLayout cl = (CardLayout) (this.getLayout());
        cl.show(this, bd);
    }//GEN-LAST:event_btnBDActionPerformed

    private void btnEncazadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncazadosActionPerformed
     CardLayout cl = (CardLayout) (this.getLayout());
        cl.show(this, actEnc);
    }//GEN-LAST:event_btnEncazadosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizacion;
    private javax.swing.JButton btnBD;
    private javax.swing.JButton btnEncazados;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
