
package com.component;

import com.model.ModelCumpleaños;


public class Cumpleaños extends javax.swing.JPanel {

   
    public Cumpleaños() {
        initComponents();
    }
  
public void setData(ModelCumpleaños data) {
      //  lbIcon.setIcon(data.getIcon());
        lbNum.setText(data.getNumEmple());
        lbNombre.setText(data.getNombreCompleto());
        lbFecha.setText(data.getFechaNac());
        lbEdad.setText(data.getEdad2());
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageAvatar1 = new com.swing.ImageAvatar();
        lbNum = new javax.swing.JLabel();
        lbNombre = new javax.swing.JLabel();
        lbFecha = new javax.swing.JLabel();
        lbEdad = new javax.swing.JLabel();

        imageAvatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/box.png"))); // NOI18N

        lbNum.setFont(new java.awt.Font("Poppins ExtraLight", 0, 14)); // NOI18N
        lbNum.setText("Num");

        lbNombre.setFont(new java.awt.Font("Poppins Light", 0, 16)); // NOI18N
        lbNombre.setText("nombre");

        lbFecha.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbFecha.setForeground(new java.awt.Color(0, 51, 102));
        lbFecha.setText("Fecha");

        lbEdad.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lbEdad.setForeground(new java.awt.Color(102, 102, 102));
        lbEdad.setText("Edad:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lbEdad)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNum)
                    .addComponent(lbNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbFecha)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lbNum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbFecha))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbEdad)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.swing.ImageAvatar imageAvatar1;
    private javax.swing.JLabel lbEdad;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbNum;
    // End of variables declaration//GEN-END:variables
}
