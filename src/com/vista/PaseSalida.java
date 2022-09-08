package com.vista;

import com.DAO.BajaPersonalDAO;
import com.DAO.PaseSalidaDAO;
import com.DAO.ReportesDAO;
import com.DAO.UsuariosDAO;
import com.classes.Validaciones;
import com.component.EmpleadoSinFoto;
import com.component.RegistrosPaseSalida;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import com.connection.Conexion;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import net.sf.jasperreports.view.JasperViewer;

public class PaseSalida extends javax.swing.JPanel {

    Conexion con = new Conexion();
    PreparedStatement psql;
    ResultSet rs;

    Connection conn = con.getConnection();
    ReportesDAO dao = new ReportesDAO();

    PaseSalidaDAO daops = new PaseSalidaDAO();

    String numE, hora1, hora2;

    int id;

    public PaseSalida() {
        initComponents();
    }

    void generarReporte() throws IOException, JRException {

        try {
            JasperReport archivo = JasperCompileManager.compileReport("C:\\sgp\\reports\\pase_de_salida.jrxml");
            Map<String, Object> map = new HashMap<String, Object>();
        
            String foliop = daops.ObteneridPase();
            numE = txtNumE.getText();
            hora1 = txtHora1.getText();
            hora2 = txtHora2.getText();
            BajaPersonalDAO idemp = new BajaPersonalDAO();
            id = idemp.idEmpleado(numE);

            map.put("numEmp", numE);
            map.put("logo1", dao.Imagen(1));
            map.put("logo2", dao.Imagen(2));
            map.put("logo3", dao.Imagen(3));
            map.put("Hora1", hora1);
            map.put("Hora2", hora2);
            map.put("Folio", foliop);

            JasperPrint print = JasperFillManager.fillReport(archivo, map, conn);
            int n = print.getPages().size();
            if (n > 0) {
                JasperViewer view = new JasperViewer(print, false);

                view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                view.setVisible(true);

                daops.registrar(id, foliop, hora1, hora2);
            } else {
                JOptionPane.showMessageDialog(null, "Error, El número de empleado (a) ingresado no existe o está inactivo");
            }
        } catch (HeadlessException | JRException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public int idJefe(int idemp) {

        int id = 0;

        String sql = "select jefe_inmediato from tbl_empleo where id_empleado=?;";
        try {
            psql = conn.prepareStatement(sql);
            psql.setInt(1, idemp);
            rs = psql.executeQuery();

            if (rs.next()) {
                id = rs.getInt(1);

            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return id;
    }

    void VisualizarReporte() throws IOException, JRException{
        try {
            JasperReport archivo = JasperCompileManager.compileReport("C:\\sgp\\reports\\pase_de_salida.jrxml");
            Map<String, Object> map = new HashMap<String, Object>();
            String foliop = daops.ObteneridPase();
            numE = txtNumE.getText();
            hora1 = txtHora1.getText();
            hora2 = txtHora2.getText();
            if (foliop != null) {
                map.put("numEmp", numE);
                map.put("logo1", dao.Imagen(1));
                map.put("logo2", dao.Imagen(2));
                map.put("logo3", dao.Imagen(3));
                map.put("Hora1", hora1);
                map.put("Hora2", hora2);
                map.put("Folio", foliop);

                JasperPrint print = JasperFillManager.fillReport(archivo, map, conn);
                int n = print.getPages().size();
                if (n > 0) {
                    JasperViewer view = new JasperViewer(print, false);

                    view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    view.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "Error, El número de empleado (a) ingresado no existe o está inactivo");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El número de folio es nulo, verfique la Base de datos");
            }

        } catch (HeadlessException | JRException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

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
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setOpaque(false);
        setLayout(new java.awt.GridBagLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel1.setText("Número de empleado");

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel2.setText("Hora de salida");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/search_30px.png"))); // NOI18N
        jButton2.setText("Buscar");
        jButton2.setBorderPainted(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

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

        txtNumE.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N
        txtNumE.setPlaceholder("No. Empleado");

        txtHora1.setForeground(new java.awt.Color(102, 102, 102));
        txtHora1.setText("Salida");
        txtHora1.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N

        txtHora2.setForeground(new java.awt.Color(102, 102, 102));
        txtHora2.setText("Llegada");
        txtHora2.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNumE, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHora1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHora2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(btnGenerarReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtHora1, txtHora2, txtNumE});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumE, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtHora1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtHora2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(btnGenerarReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtHora1, txtHora2, txtNumE});

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 73;
        gridBagConstraints.ipady = 70;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 28, 10);
        add(jPanel1, gridBagConstraints);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/eye.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_END;
        add(jButton1, gridBagConstraints);

        jButton3.setText("Registros de este año");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 2, 0);
        add(jButton3, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteActionPerformed
        Validaciones.esCajaVacia(txtNumE, "Campo Núm. Emp está vacío !!");
        if (txtHora2.getText().equals("Llegada") || txtHora1.getText().equals("Salida")) {
            JOptionPane.showMessageDialog(null, "Asignar Hora de salida y llegada", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                generarReporte();
            } catch (IOException ex) {
                Logger.getLogger(PaseSalida.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JRException ex) {
                Logger.getLogger(PaseSalida.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_btnGenerarReporteActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        EmpleadoSinFoto dialog = new EmpleadoSinFoto(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                dialog.setVisible(false);
            }
        });

        dialog.setVisible(true);
        txtNumE.setText(dialog.getNume());

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            VisualizarReporte();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        RegistrosPaseSalida dialog = new RegistrosPaseSalida(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                // System.exit(0);
                dialog.setVisible(false);
            }
        });
        dialog.mostrarRegistros(dialog.TableRegistro);
        dialog.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.swing.ButtonBadges btnGenerarReporte;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private com.swing.TimeChooser txtHora1;
    private com.swing.TimeChooser txtHora2;
    private com.swing.JCTextField txtNumE;
    // End of variables declaration//GEN-END:variables
}
