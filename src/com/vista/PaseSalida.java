
package com.vista;
import com.connection.Conectar;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import com.connection.Conexion;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.WindowConstants;
import net.sf.jasperreports.view.JasperViewer;
public class PaseSalida extends javax.swing.JPanel {
Conexion con;
    public PaseSalida() {
        initComponents();
    }
void generarReporte() throws JRException{
   JasperReport archivo = JasperCompileManager.compileReport("src/com/reports/pase_salida.jrxml");
        Map<String,Object> map = new HashMap<String, Object>();
        Conectar con = new Conectar("jdbc:mysql://localhost/db_rh?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        
        String numE=txtNumE.getText();
        String hora1=txtHora1.getText();
         String hora2=txtHora2.getText();
        map.put("NumEmp",numE);
        map.put("logo1", "src/com/icon/ede.png");
        map.put("logo3", "src/com/icon/guerrero.png");
        map.put("Hora1", hora1);
        map.put("Hora2", hora2);
        map.put("Folio", "001");
        JasperPrint prin = JasperFillManager.fillReport(archivo, map,con.getConnection());
       
        JasperViewer view = new JasperViewer(prin, false);
            view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            view.setVisible(true);
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        btnGenerarReporte = new com.swing.ButtonBadges();
        jLabel3 = new javax.swing.JLabel();
        txtNumE = new com.swing.JCTextField();
        txtHora1 = new com.swing.TimeChooser();
        txtHora2 = new com.swing.TimeChooser();

        setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel1.setText("Número de empleado");

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel2.setText("Hora de salida");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/search_30px.png"))); // NOI18N
        jButton2.setBorderPainted(false);

        btnGenerarReporte.setBackground(new java.awt.Color(31, 44, 81));
        btnGenerarReporte.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerarReporte.setText("Generar");
        btnGenerarReporte.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel3.setText("Hora de llegada");

        txtNumE.setPlaceholder("No. Empleado");

        txtHora1.setForeground(new java.awt.Color(102, 102, 102));
        txtHora1.setText("Salida");

        txtHora2.setForeground(new java.awt.Color(102, 102, 102));
        txtHora2.setText("Llegada");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHora1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtNumE, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel3)
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGenerarReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHora2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNumE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtHora1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtHora2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(btnGenerarReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 73;
        gridBagConstraints.ipady = 70;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 28, 10);
        add(jPanel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteActionPerformed
    try {
        generarReporte();
    } catch (JRException ex) {
        Logger.getLogger(PaseSalida.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_btnGenerarReporteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.swing.ButtonBadges btnGenerarReporte;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private com.swing.TimeChooser txtHora1;
    private com.swing.TimeChooser txtHora2;
    private com.swing.JCTextField txtNumE;
    // End of variables declaration//GEN-END:variables
}
