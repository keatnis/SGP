package com.component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class Message extends javax.swing.JDialog {

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    private boolean ok;
    private final Animator animator;
    private boolean show = true;

    public Message(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        setOpacity(0f);
        getContentPane().setBackground(Color.WHITE);
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                if (show) {
                    setOpacity(fraction);
                } else {
                    setOpacity(1f - fraction);
                }
            }

            @Override
            public void end() {
                if (show == false) {
                    setVisible(false);
                }
            }

        };
        animator = new Animator(200, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
    }

    public void showMessage(String message) {
        lbMessage.setText(message);
        animator.start();
        setVisible(true);
    }
  
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbMessage = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        buttonBadges1 = new com.swing.ButtonBadges();
        buttonBadges2 = new com.swing.ButtonBadges();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75, 134, 253)));

        lbMessage.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbMessage.setText("Message");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/box.png"))); // NOI18N

        buttonBadges1.setBackground(new java.awt.Color(31, 44, 81));
        buttonBadges1.setForeground(new java.awt.Color(255, 255, 255));
        buttonBadges1.setText("Aceptar");
        buttonBadges1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBadges1ActionPerformed(evt);
            }
        });

        buttonBadges2.setBackground(new java.awt.Color(204, 204, 204));
        buttonBadges2.setForeground(new java.awt.Color(51, 51, 51));
        buttonBadges2.setText("Cancel");
        buttonBadges2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBadges2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(buttonBadges1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonBadges2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonBadges1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonBadges2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed

    }//GEN-LAST:event_button2ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
 
    }//GEN-LAST:event_button1ActionPerformed

    private void buttonBadges1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBadges1ActionPerformed
         ok = true;
        
    }//GEN-LAST:event_buttonBadges1ActionPerformed

    private void buttonBadges2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBadges2ActionPerformed
      closeMenu();
    }//GEN-LAST:event_buttonBadges2ActionPerformed

    private void closeMenu() {
        if (animator.isRunning()) {
            animator.stop();
        }
        show = false;
        animator.start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.swing.ButtonBadges buttonBadges1;
    private com.swing.ButtonBadges buttonBadges2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbMessage;
    // End of variables declaration//GEN-END:variables
}
