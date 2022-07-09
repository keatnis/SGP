
package com.component;


import com.model.ModelPerfil;
import com.model.ModelPersonalN;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;


public class Perfil extends javax.swing.JPanel {

  
    public Perfil() {
        initComponents();
    }

    public void addPerfilPersonal(ModelPerfil data){
        lbNombre.setText(data.getNombre());
        lbPuesto.setText(data.getPuesto());
        lbCumple.setText(data.getCumple());
        lbSueldo.setText(data.getSueldo());
        lbTelefono.setText(data.getTeléfono());
        lblNumEmp.setText(data.getNume());
        lblCorreo.setText(data.getCorreo());
        
      
    }
      @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
        super.paintComponent(grphcs);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageAvatar1 = new com.swing.ImageAvatar();
        lbNombre = new javax.swing.JLabel();
        lbPuesto = new javax.swing.JLabel();
        lbSueldo = new javax.swing.JLabel();
        lbCumple = new javax.swing.JLabel();
        lbTelefono = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        lblNumEmp = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

        imageAvatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/avatar.png"))); // NOI18N

        lbNombre.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        lbNombre.setText("Nombre completo");

        lbPuesto.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        lbPuesto.setForeground(new java.awt.Color(0, 102, 204));
        lbPuesto.setText("Puesto");

        lbSueldo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbSueldo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/get_cash_20px.png"))); // NOI18N
        lbSueldo.setText("Sueldo");

        lbCumple.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbCumple.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/birthday_20px.png"))); // NOI18N
        lbCumple.setText("Cumpleaños");

        lbTelefono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/phone_20px.png"))); // NOI18N
        lbTelefono.setText("Teléfono");

        lblCorreo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/gmail_logo_20px.png"))); // NOI18N
        lblCorreo.setText("Correo electronico");

        lblNumEmp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNumEmp.setForeground(new java.awt.Color(153, 102, 0));
        lblNumEmp.setText("Num. Emp");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTelefono)
                            .addComponent(lbSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCorreo)
                            .addComponent(lbCumple, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(lblNumEmp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(lbPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbNombre)
                            .addComponent(lbPuesto)
                            .addComponent(lblNumEmp))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbCumple)
                                .addGap(14, 14, 14))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lbSueldo)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbTelefono)
                            .addComponent(lblCorreo))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
  


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.swing.ImageAvatar imageAvatar1;
    private javax.swing.JLabel lbCumple;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbPuesto;
    private javax.swing.JLabel lbSueldo;
    private javax.swing.JLabel lbTelefono;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblNumEmp;
    // End of variables declaration//GEN-END:variables
}
