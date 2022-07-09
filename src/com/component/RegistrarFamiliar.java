
package com.component;

import com.DAO.PersonalNDAO;
import com.model.ModelPersonalN;
import com.vista.RegistrarPN;
import java.awt.geom.RoundRectangle2D;
import static java.awt.image.ImageObserver.ERROR;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class RegistrarFamiliar extends javax.swing.JDialog {
 ModelPersonalN model = new ModelPersonalN();
    PersonalNDAO DAO = new PersonalNDAO();
RegistrarPN regis=new RegistrarPN();
    public RegistrarFamiliar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sexo = new javax.swing.ButtonGroup();
        panelRound1 = new com.swing.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtFechaNac = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        cmbParentesco = new javax.swing.JComboBox<>();
        txtnombre = new com.swing.JCTextField();
        buttonBadges1 = new com.swing.ButtonBadges();
        jLabel4 = new javax.swing.JLabel();
        rbHombre = new javax.swing.JRadioButton();
        rbMujer = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de Derechohabiente");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new java.awt.CardLayout());

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Nombre");

        jLabel2.setText("Fecha de Nacimiento");

        jLabel3.setText("Parentesco");

        cmbParentesco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccione--", "Padre", "Madre", "Esposa", "Esposo", "Hijo", "Hija", "otro" }));

        buttonBadges1.setBackground(new java.awt.Color(31, 44, 81));
        buttonBadges1.setForeground(new java.awt.Color(255, 255, 255));
        buttonBadges1.setText("Agregar");
        buttonBadges1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        buttonBadges1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBadges1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Sexo");

        sexo.add(rbHombre);
        rbHombre.setText("Hombre");

        sexo.add(rbMujer);
        rbMujer.setText("Mujer");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound1Layout.createSequentialGroup()
                            .addGap(55, 55, 55)
                            .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel3)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel4)))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(rbHombre)
                        .addGap(18, 18, 18)
                        .addComponent(rbMujer))
                    .addComponent(txtnombre, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                    .addComponent(cmbParentesco, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaNac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(63, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(buttonBadges1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(148, 148, 148))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbHombre)
                    .addComponent(rbMujer)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                        .addComponent(txtFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbParentesco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(33, 33, 33)
                .addComponent(buttonBadges1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        getContentPane().add(panelRound1, "card2");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonBadges1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBadges1ActionPerformed
        
        if (DAO.numEmpExiste(model.getNumEmpleado()) == 0) {
            model.setNum_empleado(model.getNumEmpleado());
          
            model.setNombredh(txtnombre.getText());
           
            SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
            String pasofecha = (formatofecha.format(txtFechaNac.getDate()));
  
            model.setFechaNacdh(pasofecha);
            String parent = (String) cmbParentesco.getSelectedItem();
            model.setParentesco(parent);
           
            String sexo = null;
            if (rbMujer.isSelected()) {
                sexo = "M";
            }
            if (rbHombre.isSelected()) {
                sexo = "H";
            }
            model.setSexo(sexo);
            model.setEstado("Activo (a)");

            if (DAO.GuardarDerechohabiente(model)) {
                JOptionPane.showMessageDialog(null, "Regristrado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, ERROR);
            }

        } else {
            JOptionPane.showMessageDialog(null, "El número de empleado ya está en uso o está vacío");
        }
    }//GEN-LAST:event_buttonBadges1ActionPerformed

  
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.swing.ButtonBadges buttonBadges1;
    private javax.swing.JComboBox<String> cmbParentesco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private com.swing.PanelRound panelRound1;
    private javax.swing.JRadioButton rbHombre;
    private javax.swing.JRadioButton rbMujer;
    private javax.swing.ButtonGroup sexo;
    private com.toedter.calendar.JDateChooser txtFechaNac;
    private com.swing.JCTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
