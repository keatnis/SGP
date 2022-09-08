
package com.component;

import com.DAO.ReportesDAO;
import com.notification.Notification;

import com.vista.MainSystem;
import java.io.FileNotFoundException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class ActualizarLogo extends javax.swing.JDialog {

 String logo_path;
 ReportesDAO dao = new ReportesDAO();

    public ActualizarLogo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbLogo = new javax.swing.JComboBox<>();
        btnPath = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        lbCheck = new javax.swing.JLabel();
        lbLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Actualizacion de Logos");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbLogo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Logo 1", "Logo 2", "Logo 3", "Logo 4" }));
        getContentPane().add(cmbLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 29, 230, -1));

        btnPath.setText("Seleccionar archivo");
        btnPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPathActionPerformed(evt);
            }
        });
        getContentPane().add(btnPath, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 60, -1, -1));

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 132, 177, -1));
        getContentPane().add(lbCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(493, 60, 24, 23));

        lbLogo.setBorder(javax.swing.BorderFactory.createTitledBorder("Imagen"));
        getContentPane().add(lbLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 29, 251, 129));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
      int index =cmbLogo.getSelectedIndex();
     try {
         dao.actualizarLogo(index, logo_path);
         Notification n = new Notification(MainSystem.getFrames()[0], Notification.Type.SUCCESS, Notification.Location.CENTER, "Logo actualizado correctamente");
                    n.showNotification();
     } catch (FileNotFoundException ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage());
     }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPathActionPerformed
       FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo de imagen", "png", "jpg");
        JFileChooser selector = new JFileChooser();
        selector.setFileFilter(filtro);
        int opcionav = selector.showOpenDialog(this);
        if (opcionav == JFileChooser.APPROVE_OPTION) {
            logo_path = selector.getSelectedFile().getPath();
            //  this.ruta = selector.getSelectedFile().toString();
            rsscalelabel.RSScaleLabel.setScaleLabel(lbLogo,logo_path);
            lbCheck.setIcon(new ImageIcon("src/com/icon/check_circle_20px.png"));
        }
        else{
            lbCheck.setIcon(null);
        }
          
    }//GEN-LAST:event_btnPathActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnPath;
    private javax.swing.JComboBox<String> cmbLogo;
    private javax.swing.JLabel lbCheck;
    private javax.swing.JLabel lbLogo;
    // End of variables declaration//GEN-END:variables
}
