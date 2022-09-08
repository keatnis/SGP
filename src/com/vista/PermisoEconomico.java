package com.vista;

import com.DAO.BajaPersonalDAO;
import com.DAO.PermisoEconomicoDAO;
import com.DAO.ReportesDAO;
import com.classes.Validaciones;
import com.component.EmpleadoSinFoto;
import com.component.RegistrosPermisos;
import com.connection.Conexion;
import com.model.ModelPermisoEconomico;
import java.awt.HeadlessException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class PermisoEconomico extends javax.swing.JPanel {

    int diff_dia = 0, de, al, mes;
    String mesL;
    String dias;
    ModelPermisoEconomico modper = new ModelPermisoEconomico();
    PermisoEconomicoDAO dao = new PermisoEconomicoDAO();
    BajaPersonalDAO daobaja = new BajaPersonalDAO();

    public PermisoEconomico() {
        initComponents();

    }
    private void validar(){
        Validaciones.esCajaVacia(txtNumEmp, "El campo número de empleado(a) está vació. En caso de no conocerlo pulse el botón Buscar y seleccione dos veces para asignar el número en el campo");
        if(fecha1.getDate()==null){
            JOptionPane.showMessageDialog(null, "Asigne una fecha de inicio");
            
        }
        if(fecha2.getDate()==null){
            JOptionPane.showMessageDialog(null, "Asigne una fechafinal");
            
        }
    }
    private void obtenerDatos() {
validar();
        if (fecha2.getCalendar().get(Calendar.DATE) < fecha1.getCalendar().get(Calendar.DATE)) {
            if (fecha2.getCalendar().get(Calendar.MONTH) == fecha1.getCalendar().get(Calendar.MONTH)) {
                JOptionPane.showMessageDialog(null, "Verifique la fecha del segundo mes");
            } else {
                diff_dia = ((fecha1.getCalendar().get(Calendar.DATE)
                        + fecha2.getCalendar().get(Calendar.DATE)) - fecha1.getCalendar().getActualMaximum(Calendar.DAY_OF_MONTH)) + 1;
            }

        } else {
            diff_dia = (fecha2.getCalendar().get(Calendar.DATE)
                    - fecha1.getCalendar().get(Calendar.DATE)) + 1;

        }
        dias = Integer.toString(diff_dia);
        lbDias.setText(dias);
        de = fecha1.getCalendar().get(Calendar.DAY_OF_MONTH);
        al = fecha2.getCalendar().get(Calendar.DAY_OF_MONTH);
        if (diff_dia > 3) {
            JOptionPane.showMessageDialog(null, "Verifique las fechas seleccionadas, la cantidad de días permitidos sobrepasan");
        }
        mes = fecha2.getCalendar().get(Calendar.MONTH);
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", " Septiembre", "Octubre", "Noviembre", "Diciemrbre"};
        mesL = meses[mes];

    }

    private void guardarDB() {
        int id = daobaja.idEmpleado(txtNumEmp.getText());
        modper.setId(id);
        SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
        String fechade = (formatofecha.format(fecha1.getDate()));
        String fechaal = (formatofecha.format(fecha2.getDate()));
        modper.setFecha_de(fechade);
        modper.setFecha_al(fechaal);
        modper.setDias(diff_dia);

        dao.registrar(modper);
    }

    void generarReporte() throws IOException, JRException {
        try {
            JasperReport archivo = JasperCompileManager.compileReport("C:\\sgp\\reports\\permiso_economico.jrxml");
            Map<String, Object> map = new HashMap<String, Object>();
         
            Conexion conn= new Conexion();
            String numE = txtNumEmp.getText();

            ReportesDAO img = new ReportesDAO();

            obtenerDatos();

            map.put("numEmp", numE);
            map.put("img1", img.Imagen(1));
            map.put("img2", img.Imagen(2));
            map.put("img3", img.Imagen(3));
            map.put("pie_pag",img.Imagen(4));
            map.put("dias", diff_dia);
            map.put("del", Integer.toString(de));
            map.put("al", Integer.toString(al));
            map.put("mes", mesL);

            JasperPrint print = JasperFillManager.fillReport(archivo, map, conn.getConnection());
            int n = print.getPages().size();
            if (n > 0 && diff_dia<4) {

                JasperViewer view = new JasperViewer(print, false);

                view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                view.setVisible(true);
                guardarDB();

            } else {
                JOptionPane.showMessageDialog(null, "Error, no hay paginas");
            }
        } catch (HeadlessException | JRException e) {
            System.out.println("" + e);
        }

    }
/*  int id2 = daobaja.idEmpleado(txtNumEmp.getText());
        SimpleDateFormat formatofechap = new SimpleDateFormat("MM");
        String mess = (formatofechap.format(fecha1.getDate()));
        int m = Integer.parseInt(mess);
        int countmes = dao.count_almes(id2, m);

        int countaño = dao.count_alyear(id2);
        int cuentat = countaño + diff_dia;
        int cuentamt = countmes + diff_dia;
         if (diff_dia > 3) {
            JOptionPane.showMessageDialog(null, "Verifique las fechas seleccionadas, la cantidad de días permitidos sobrepasan");
        }
        if (countmes > 3) {
            JOptionPane.showMessageDialog(null, "Ya alcanzó el límite de este mes: " + countmes + " días");
        } else if (cuentamt > 3) {
            JOptionPane.showMessageDialog(null, "Rebasaría los días económicos permitidos de este mes (3), hasta ahorita lleva " + countmes);
        } else if (countaño > 9) {
            JOptionPane.showMessageDialog(null, "Rebasó el límite de permisos permitidos de este año,registro de db");
            
        } else if (countaño == 9) {
            JOptionPane.showMessageDialog(null, "Ya alcanzó el límite de permisos para este año ");
        } else if (cuentat > 9) {
            JOptionPane.showMessageDialog(null, "Sobrepasará el límite de días económicos permitidos, " + cuentat + " días");
        }else if (cuentamt <= 3 && cuentat <= 9) {
            try {
                generarReporte();
            } catch (IOException | JRException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNumEmp = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fecha1 = new com.toedter.calendar.JDateChooser();
        fecha2 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbDias = new javax.swing.JLabel();
        btnRegistros = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        buttonBadges1 = new com.swing.ButtonBadges();

        setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        setOpaque(false);
        setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel1.setText("Número de empleado/a:");

        txtNumEmp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel2.setText("de");

        fecha1.setDateFormatString("yyyy-MM-dd");
        fecha1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        fecha2.setDateFormatString("yyyy-MM-dd");
        fecha2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fecha2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                fecha2PropertyChange(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel3.setText("al");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/eye.png"))); // NOI18N
        jLabel4.setText("Total de días: ");
        jLabel4.setToolTipText("");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        lbDias.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N

        btnRegistros.setText("Registros");
        btnRegistros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrosActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/search_30px.png"))); // NOI18N
        jButton3.setText("Buscar");
        jButton3.setBorderPainted(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/eye.png"))); // NOI18N
        jButton2.setText("Visualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        buttonBadges1.setBackground(new java.awt.Color(31, 44, 81));
        buttonBadges1.setForeground(new java.awt.Color(255, 255, 255));
        buttonBadges1.setText("Generar");
        buttonBadges1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        buttonBadges1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBadges1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(7, 7, 7)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtNumEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(47, 47, 47)
                                        .addComponent(jButton3))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(fecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbDias, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(buttonBadges1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(197, 197, 197)))
                        .addGap(0, 13, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnRegistros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {fecha1, fecha2, txtNumEmp});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1))
                    .addComponent(txtNumEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(fecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel3))
                            .addComponent(fecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDias, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addGap(50, 50, 50)
                .addComponent(buttonBadges1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistros))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {fecha1, fecha2, txtNumEmp});

        add(jPanel1, new java.awt.GridBagConstraints());
    }// </editor-fold>//GEN-END:initComponents
//para img pie_pag  map.put("logo1", "src/com/icon/ede.png");
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        EmpleadoSinFoto dialog = new EmpleadoSinFoto(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                dialog.setVisible(false);
            }
        });
        dialog.setVisible(true);
        txtNumEmp.setText(dialog.getNume());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnRegistrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrosActionPerformed
        LocalDate now = LocalDate.now();
        int year = now.getYear();

        int month = now.getMonthValue();
        RegistrosPermisos dialog = new RegistrosPermisos(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                dialog.setVisible(false);
            }
        });
        String years=String.valueOf(year);
   
        dialog.cmbMes.setSelectedIndex(month);
        dialog.cmbAño.setSelectedItem(years);
        dialog.setVisible(true);


    }//GEN-LAST:event_btnRegistrosActionPerformed

    private void fecha2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_fecha2PropertyChange
        //  obtenerDatos();
    }//GEN-LAST:event_fecha2PropertyChange

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        obtenerDatos();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JOptionPane.showMessageDialog(null, "Aqui se puede visualizar, pero NO se registra en la base de datos");
       validar();
        try {
            generarReporte();
        } catch (IOException | JRException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void buttonBadges1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBadges1ActionPerformed
       int id2 = daobaja.idEmpleado(txtNumEmp.getText());
        SimpleDateFormat formatofechap = new SimpleDateFormat("MM");
        String mess = (formatofechap.format(fecha1.getDate()));
        int m = Integer.parseInt(mess);
        int countmes = dao.count_almes(id2, m);

        int countaño = dao.count_alyear(id2);
        int cuentat = countaño + diff_dia;
        int cuentamt = countmes + diff_dia;
         if (diff_dia > 3) {
            JOptionPane.showMessageDialog(null, "Verifique las fechas seleccionadas, la cantidad de días permitidos sobrepasan");
        }
        if (countmes > 3) {
            JOptionPane.showMessageDialog(null, "Ya alcanzó el límite de este mes: " + countmes + " días");
        } else if (cuentamt > 3) {
            JOptionPane.showMessageDialog(null, "Rebasaría los días económicos permitidos de este mes (3), hasta ahorita lleva " + countmes);
        } else if (countaño > 9) {
            JOptionPane.showMessageDialog(null, "Rebasó el límite de permisos permitidos de este año,registro de db");
            
        } else if (countaño == 9) {
            JOptionPane.showMessageDialog(null, "Ya alcanzó el límite de permisos para este año ");
        } else if (cuentat > 9) {
            JOptionPane.showMessageDialog(null, "Sobrepasará el límite de días económicos permitidos, " + cuentat + " días");
        }else if (cuentamt <= 3 && cuentat <= 9) {
            try {
                generarReporte();
            } catch (IOException | JRException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_buttonBadges1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistros;
    private com.swing.ButtonBadges buttonBadges1;
    private com.toedter.calendar.JDateChooser fecha1;
    private com.toedter.calendar.JDateChooser fecha2;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbDias;
    private javax.swing.JTextField txtNumEmp;
    // End of variables declaration//GEN-END:variables
}
