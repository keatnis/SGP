package com.classes;

import com.DAO.ConsultasJAP;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import javax.swing.JOptionPane;

public class purebas extends javax.swing.JFrame {

    public purebas() {
        initComponents();
        obt();
    }

    private void obt() {
        ConsultasJAP jap = new ConsultasJAP();
        jap.ObteberJefe(cmbJefe);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbJefe = new javax.swing.JComboBox<>();
        lbId = new javax.swing.JLabel();
        lbJefe = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cmbJefe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", " " }));
        cmbJefe.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbJefeItemStateChanged(evt);
            }
        });

        lbId.setText("id");

        lbJefe.setText("jefe");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(cmbJefe, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbJefe)
                            .addComponent(lbId))))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(cmbJefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbId)
                .addGap(31, 31, 31)
                .addComponent(lbJefe)
                .addContainerGap(129, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbJefeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbJefeItemStateChanged
        String cadena = (String) cmbJefe.getSelectedItem();

//Compilamos el regex y el matcher al texto, ignorando mayúsculas/minúsculas (esto es estándar)
        Pattern pattern = Pattern.compile("([0-9]+)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(cadena);

        String ultima = cadena.substring(cadena.lastIndexOf("-") + 1);
        lbJefe.setText(ultima);
//Ahora sí, vemos si coincide el patrón con el texto
        if (matcher.find()) {
            //Coincidió => obtener el valor del grupo 1

            String edad = matcher.group(1);
            lbId.setText(edad);

        } else {
          JOptionPane.showMessageDialog(null,"No se estrado correctamente el nombre/id del jefe");
        }
    }//GEN-LAST:event_cmbJefeItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(purebas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(purebas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(purebas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(purebas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new purebas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbJefe;
    private javax.swing.JLabel lbId;
    private javax.swing.JLabel lbJefe;
    // End of variables declaration//GEN-END:variables
}
