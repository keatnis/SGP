
package com.component;

import com.model.ModelCumpleaños;
import javax.swing.JPanel;


public class Cumpleaños extends javax.swing.JPanel {

   
    public Cumpleaños() {
        initComponents();
        
    }

   public Cumpleaños(ModelCumpleaños data) {
      lbIcon.setIcon(data.getIcon());
         lbIcon.repaint();
        lbNum.setText(data.getNumEmple());
        lbNombre.setText(data.getNombreCompleto());
        lbFecha.setText(data.getFechaNac());
        lbEdad.setText(data.getEdad2());
    }
  
public void setData(ModelCumpleaños data) {
         lbIcon.setIcon(data.getIcon());
         lbIcon.repaint();
        lbNum.setText(data.getNumEmple());
        lbNombre.setText(data.getNombreCompleto());
        lbFecha.setText(data.getFechaNac());
        lbEdad.setText(data.getEdad2());
       
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbIcon = new com.swing.ImageAvatar();
        lbNum = new javax.swing.JLabel();
        lbNombre = new javax.swing.JLabel();
        lbFecha = new javax.swing.JLabel();
        lbEdad = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/box.png"))); // NOI18N
        add(lbIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 111, 90));

        lbNum.setFont(new java.awt.Font("Poppins Medium", 0, 15)); // NOI18N
        lbNum.setForeground(new java.awt.Color(51, 51, 51));
        lbNum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNum.setText("Num");
        lbNum.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(lbNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 100, -1));

        lbNombre.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        lbNombre.setForeground(new java.awt.Color(51, 51, 51));
        lbNombre.setText("nombre");
        add(lbNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 194, -1));

        lbFecha.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        lbFecha.setForeground(new java.awt.Color(51, 51, 51));
        lbFecha.setText("Fecha");
        add(lbFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 160, -1));

        lbEdad.setFont(new java.awt.Font("Poppins", 1, 15)); // NOI18N
        lbEdad.setForeground(new java.awt.Color(0, 102, 204));
        lbEdad.setText("Edad:");
        add(lbEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 113, -1, 20));

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel1.setText("Edad:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 114, -1, 20));

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel3.setText("Nombre: ");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, -1, -1));

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel4.setText("Fecha Nacim.: ");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbEdad;
    private javax.swing.JLabel lbFecha;
    private com.swing.ImageAvatar lbIcon;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbNum;
    // End of variables declaration//GEN-END:variables
}
