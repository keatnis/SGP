
package com.component;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author sosam
 */
public class PanelCargando extends javax.swing.JPanel {

    /**
     * Creates new form PanelCargando
     */
    public PanelCargando() {
        initComponents();
//        ImageIcon imgIcon = new ImageIcon(getClass().getResource("/com/icon/cargando.gif"));
//        Image imgEscalada = imgIcon.getImage().getScaledInstance(lbImage.getWidth(),
//                lbImage.getHeight(), Image.SCALE_SMOOTH);
//        Icon iconoEscalado = new ImageIcon(imgEscalada);
//        lbImage.setIcon(iconoEscalado);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new javax.swing.JPanel();
        lbImage = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(new java.awt.CardLayout());

        lbImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/cargando.gif"))); // NOI18N

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 668, Short.MAX_VALUE)
            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbImage, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 204, Short.MAX_VALUE)
            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                    .addContainerGap(16, Short.MAX_VALUE)
                    .addComponent(lbImage, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(17, Short.MAX_VALUE)))
        );

        add(panel1, "card3");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel lbImage;
    private javax.swing.JPanel panel1;
    // End of variables declaration//GEN-END:variables
}
