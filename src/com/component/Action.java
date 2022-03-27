package com.component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Action extends javax.swing.JPanel {

    public Action(ModelAction data) {
        initComponents();
        cmdEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                data.getEvent().update(data.getUser());
            }
        });
        cmdDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                data.getEvent().delete(data.getUser());
            }
        });
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        grphcs.setColor(new Color(230, 230, 230));
        grphcs.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdDelete = new javax.swing.JButton();
        cmdEdit = new javax.swing.JButton();

        cmdDelete.setBackground(new java.awt.Color(255, 255, 255));
        cmdDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/Delete.png"))); // NOI18N
        cmdDelete.setBorderPainted(false);

        cmdEdit.setBackground(new java.awt.Color(255, 255, 255));
        cmdEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/edit.png"))); // NOI18N
        cmdEdit.setBorderPainted(false);
        cmdEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmdEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cmdEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmdEdit)
            .addComponent(cmdDelete)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdDelete;
    private javax.swing.JButton cmdEdit;
    // End of variables declaration//GEN-END:variables
}
