package com.vista.edit;

import com.DAO.PersonalNDAO;
import com.classes.Validaciones;
import com.ibm.icu.text.SimpleDateFormat;
import com.model.ModelPersonalN;
import static java.awt.image.ImageObserver.ERROR;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class editarDL extends javax.swing.JDialog {
 public String  rutaFUMP;
    ModelPersonalN model = new ModelPersonalN();
   PersonalNDAO DAO = new PersonalNDAO();
    public editarDL(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public void showData(ModelPersonalN data) {
        cmbPlantel.setSelectedItem(data.getPlantel());
        txtCodFinanzas.setText(data.getCodigo());
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(data.getFechaIngreso());
            FechaIngreso.setDate(date);
        } catch (ParseException ex) {
            Logger.getLogger(editarDG.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (data.getFechaTerminoCont().equals("N/A")) {
                FechaTermContrato.setDate(null);

            } else {
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(data.getFechaTerminoCont());

                FechaTermContrato.setDate(date);
            }

        } catch (ParseException ex) {
            Logger.getLogger(editarDG.class.getName()).log(Level.SEVERE, null, ex);
        }
        cmbJefe.setSelectedItem(data.getJefeInmediato());
        cmbPuesto.setSelectedItem(data.getPuesto());
        cmbArea.setSelectedItem(data.getAreaAdscripción());
        cmbCategoria.setSelectedItem(data.getCategoria());
        txtHoras.setText(data.getHorasLaborales());
        cmbPlaza.setSelectedItem(data.getTipoPlaza());
        cmbSindicato.setSelectedItem(data.getSindicato());
        txtHorario.setText(data.getHorarioTrabajo());
        txtSueldo.setText(data.getSueldo());
        cmb.setSelectedItem(data.getTipoContratacion());
    }

    private void UpdateDatosLaborales() {
        //  model.setNumEmpleado(txtNumEmp.getText());
        if (id > 0) {
            String plantel = (String) cmbPlantel.getSelectedItem();
            model.setPlantel(plantel);
            String tipoc = (String) cmb.getSelectedItem();
            model.setTipoContratacion(tipoc);
            model.setCodigo(txtCodFinanzas.getText());

            java.text.SimpleDateFormat formatofecha = new java.text.SimpleDateFormat("yyyy-MM-dd");
            String pasofecha = (formatofecha.format(FechaIngreso.getDate()));

            model.setFechaIngreso(pasofecha);
            if (FechaTermContrato.getDate() != null) {

                String pasofecha2 = (formatofecha.format(FechaTermContrato.getDate()));

                model.setFechaTerminoCont(pasofecha2);
            } else {
                model.setFechaTerminoCont("N/A");
            }
            String jefe = (String) cmbJefe.getSelectedItem();
            model.setJefeInmediato(jefe);
            String puesto = (String) cmbPuesto.getSelectedItem();
            model.setPuesto(puesto);

            String area = (String) cmbArea.getSelectedItem();
            model.setAreaAdscripción(area);
            String categoria = (String) cmbCategoria.getSelectedItem();
            model.setCategoria(categoria);
            model.setHorasLaborales(txtHoras.getText());

            String plaza = (String) cmbPlaza.getSelectedItem();
            model.setTipoPlaza(plaza);
            String sindicato = (String) cmbSindicato.getSelectedItem();
            model.setSindicato(sindicato);
            model.setHorarioTrabajo(txtHorario.getText());
            model.setSueldo(txtSueldo.getText());
            

            if (DAO.UpdateDL(model,id)) {
// Notification panel = new Notification(new MainSystem(), Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Datos Generales registrados correctamente");
                JOptionPane.showMessageDialog(null, "Registro guardado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, ERROR);
            }

        } else {
            JOptionPane.showMessageDialog(null, "No existe un registro con este numero de emp.");
        }
      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tb_laboral = new javax.swing.JPanel();
        panel1 = new javax.swing.JPanel();
        tp_DatosLaborales = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        cmbPlaza = new javax.swing.JComboBox<>();
        jLabel71 = new javax.swing.JLabel();
        FechaIngreso = new com.toedter.calendar.JDateChooser();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        txtCodFinanzas = new com.swing.JCTextField();
        txtHorario = new com.swing.JCTextField();
        jLabel79 = new javax.swing.JLabel();
        cmbSindicato = new javax.swing.JComboBox<>();
        txtHoras = new com.swing.JCTextField();
        jLabel80 = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        cmbJefe = new javax.swing.JComboBox<>();
        jLabel81 = new javax.swing.JLabel();
        cmbPlantel = new javax.swing.JComboBox<>();
        cmbPuesto = new javax.swing.JComboBox<>();
        cmbArea = new javax.swing.JComboBox<>();
        txtSueldo = new javax.swing.JFormattedTextField();
        btnFUMP = new javax.swing.JButton();
        jLabel82 = new javax.swing.JLabel();
        FechaTermContrato = new com.toedter.calendar.JDateChooser();
        cbTermino = new javax.swing.JCheckBox();
        lbCodFError = new javax.swing.JLabel();
        lbIconCheck = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cmb = new javax.swing.JComboBox<>();
        btnActualizarDL = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar datos laborales");

        tb_laboral.setLayout(new java.awt.CardLayout());

        jLabel70.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel70.setText("Código");

        cmbPlaza.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbPlaza.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Base", "Sección", "Supernumerario", "Confianza", "Ninguno", "Otro" }));

        jLabel71.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel71.setText("Fecha de ingreso");

        FechaIngreso.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        FechaIngreso.setMaxSelectableDate(new java.util.Date(253370790097000L));
        FechaIngreso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FechaIngresoKeyReleased(evt);
            }
        });

        jLabel72.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel72.setText("Puesto Laboral");

        jLabel73.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel73.setText("Horas Laborales");

        jLabel74.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel74.setText("Jefe Inmediato");

        jLabel75.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel75.setText("Tipo de Plaza");

        jLabel76.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel76.setText("Horario de Trabajo");

        jLabel77.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel77.setText("Área de Adscripcion");

        jLabel78.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel78.setText("Sindicato");

        txtCodFinanzas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCodFinanzas.setPlaceholder("Código de Finanzas");
        txtCodFinanzas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodFinanzasKeyTyped(evt);
            }
        });

        txtHorario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtHorario.setPlaceholder("Horario");

        jLabel79.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel79.setText("Sueldo Mensual");

        cmbSindicato.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbSindicato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "SUSPEG", "SITITSME", "Otro", "Ninguno" }));

        txtHoras.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtHoras.setPlaceholder("Horas");
        txtHoras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHorasKeyTyped(evt);
            }
        });

        jLabel80.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel80.setText("Categoria");

        cmbCategoria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Directivo", "Administrativo", "Servicios Generales", "Docente", "Honorarios" }));

        cmbJefe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbJefe.setMaximumRowCount(38);
        cmbJefe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));

        jLabel81.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel81.setText("Plantel");

        cmbPlantel.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        cmbPlantel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Tlapa", "Olinalá", "Iliatenco" }));
        cmbPlantel.setName(""); // NOI18N

        cmbPuesto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbPuesto.setMaximumRowCount(38);
        cmbPuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cmbPuesto.setEnabled(false);

        cmbArea.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbArea.setMaximumRowCount(30);
        cmbArea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cmbArea.setToolTipText("");

        txtSueldo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        txtSueldo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnFUMP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/pdf30.png"))); // NOI18N
        btnFUMP.setText("Actualizar FUMP");
        btnFUMP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFUMPActionPerformed(evt);
            }
        });

        jLabel82.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel82.setText("Terminación de Contrato");

        FechaTermContrato.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        FechaTermContrato.setMaxSelectableDate(new java.util.Date(253370790097000L));
        FechaTermContrato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FechaTermContratoKeyReleased(evt);
            }
        });

        cbTermino.setText("Habilitar");
        cbTermino.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTerminoItemStateChanged(evt);
            }
        });

        lbCodFError.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbCodFError.setForeground(new java.awt.Color(204, 0, 0));

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Tipo");

        cmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccionar --", "Nómina", "Honorarios" }));
        cmb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbItemStateChanged(evt);
            }
        });
        cmb.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cmbPropertyChange(evt);
            }
        });

        btnActualizarDL.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        btnActualizarDL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/icons8-aprobar-y-actualizar-48.png"))); // NOI18N
        btnActualizarDL.setText("Actualizar datos");
        btnActualizarDL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarDLActionPerformed(evt);
            }
        });

        jButton2.setText("Actualizar Puesto");

        javax.swing.GroupLayout tp_DatosLaboralesLayout = new javax.swing.GroupLayout(tp_DatosLaborales);
        tp_DatosLaborales.setLayout(tp_DatosLaboralesLayout);
        tp_DatosLaboralesLayout.setHorizontalGroup(
            tp_DatosLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tp_DatosLaboralesLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(tp_DatosLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel81)
                    .addComponent(jLabel70)
                    .addComponent(jLabel71)
                    .addComponent(jLabel82)
                    .addComponent(jLabel74)
                    .addComponent(jLabel72)
                    .addComponent(jLabel77)
                    .addComponent(jLabel80)
                    .addComponent(jLabel73)
                    .addComponent(jLabel75)
                    .addComponent(jLabel78)
                    .addComponent(jLabel76)
                    .addComponent(jLabel79))
                .addGap(30, 30, 30)
                .addGroup(tp_DatosLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbPlantel, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodFinanzas, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FechaTermContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbJefe, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbArea, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbPlaza, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbSindicato, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(tp_DatosLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tp_DatosLaboralesLayout.createSequentialGroup()
                        .addGroup(tp_DatosLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tp_DatosLaboralesLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(cbTermino))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tp_DatosLaboralesLayout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                .addGroup(tp_DatosLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tp_DatosLaboralesLayout.createSequentialGroup()
                                        .addComponent(btnFUMP, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbIconCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31))
                                    .addComponent(lbCodFError, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tp_DatosLaboralesLayout.createSequentialGroup()
                        .addGroup(tp_DatosLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(tp_DatosLaboralesLayout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(btnActualizarDL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(tp_DatosLaboralesLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(26, 26, 26)
                                .addComponent(cmb, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(39, 39, 39))))
        );

        tp_DatosLaboralesLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {FechaIngreso, FechaTermContrato, cmbArea, cmbCategoria, cmbJefe, cmbPlantel, cmbPlaza, cmbPuesto, cmbSindicato, txtCodFinanzas, txtHorario, txtHoras, txtSueldo});

        tp_DatosLaboralesLayout.setVerticalGroup(
            tp_DatosLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tp_DatosLaboralesLayout.createSequentialGroup()
                .addGroup(tp_DatosLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tp_DatosLaboralesLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel81))
                    .addGroup(tp_DatosLaboralesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(tp_DatosLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbPlantel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addGroup(tp_DatosLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tp_DatosLaboralesLayout.createSequentialGroup()
                        .addGroup(tp_DatosLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tp_DatosLaboralesLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel70))
                            .addGroup(tp_DatosLaboralesLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lbCodFError, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(7, 7, 7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tp_DatosLaboralesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodFinanzas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(tp_DatosLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(tp_DatosLaboralesLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel71)
                        .addGap(17, 17, 17)
                        .addComponent(jLabel82))
                    .addGroup(tp_DatosLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(tp_DatosLaboralesLayout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addComponent(cbTermino))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tp_DatosLaboralesLayout.createSequentialGroup()
                            .addGap(7, 7, 7)
                            .addComponent(FechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(FechaTermContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(tp_DatosLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tp_DatosLaboralesLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel74))
                    .addGroup(tp_DatosLaboralesLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cmbJefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(tp_DatosLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tp_DatosLaboralesLayout.createSequentialGroup()
                        .addGroup(tp_DatosLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tp_DatosLaboralesLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel72))
                            .addGroup(tp_DatosLaboralesLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(tp_DatosLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmbPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2)
                                    .addComponent(btnFUMP))))
                        .addGap(5, 5, 5)
                        .addGroup(tp_DatosLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel77))
                        .addGap(14, 14, 14)
                        .addGroup(tp_DatosLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel80)
                            .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(tp_DatosLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel73)
                            .addComponent(txtHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(tp_DatosLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel75)
                            .addComponent(cmbPlaza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(tp_DatosLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tp_DatosLaboralesLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel78))
                            .addGroup(tp_DatosLaboralesLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(cmbSindicato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(tp_DatosLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tp_DatosLaboralesLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel76))
                            .addGroup(tp_DatosLaboralesLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(tp_DatosLaboralesLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lbIconCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(tp_DatosLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tp_DatosLaboralesLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel79))
                    .addGroup(tp_DatosLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnActualizarDL, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        tp_DatosLaboralesLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {FechaIngreso, FechaTermContrato, cmbArea, cmbCategoria, cmbJefe, cmbPlantel, cmbPlaza, cmbPuesto, cmbSindicato, txtCodFinanzas, txtHorario, txtHoras, txtSueldo});

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(tp_DatosLaborales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(tp_DatosLaborales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        tb_laboral.add(panel1, "card3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 984, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(tb_laboral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 662, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(tb_laboral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
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

    private void FechaIngresoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FechaIngresoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_FechaIngresoKeyReleased

    private void txtCodFinanzasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodFinanzasKeyTyped
        Validaciones.soloRecibeTextoyNumero(evt);
        Validaciones.revisarLongitud(evt, txtCodFinanzas, 7);
    }//GEN-LAST:event_txtCodFinanzasKeyTyped

    private void txtHorasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHorasKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHorasKeyTyped

    private void btnFUMPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFUMPActionPerformed
      // Inicia el JFileChooser
        JFileChooser fc = new JFileChooser();
        // Se crea un filtro de extensiones para que solamente pueda seleccionar archivos PDF
        FileFilter ff = new FileNameExtensionFilter("Archivo PDF", "pdf");
        // Se asigna el filtro al objeto JFileChooser
        fc.setFileFilter(ff);
        // Se muestra la ventana de JFilChooser
        int opcionav = fc.showOpenDialog(this);
        if (opcionav == JFileChooser.APPROVE_OPTION) {
            // Se asigna el archivo seleccionado a un objeto tipo File
            File archivoPDF = fc.getSelectedFile();
            rutaFUMP = archivoPDF.getAbsolutePath();
            try {
                byte[] pdf = new byte[(int) rutaFUMP.length()];
                InputStream input = new FileInputStream(rutaFUMP);
                input.read(pdf);

                if (rutaFUMP.isEmpty()) {

                    lbIconCheck.setIcon(null);
                    lbIconCheck.repaint();
                } else {
                    model.setFormatoFUMP(pdf);
                    lbIconCheck.setIcon(new ImageIcon("src/com/icon/check_circle_20px.png"));
                }

            } catch (IOException ex) {
                model.setFormatoFUMP(null);
                //System.out.println("Error al agregar archivo pdf "+ex.getMessage());
            }
            // Se sustituye la ruta por la ruta absoluta obtenida del objeto File
            int opcionpdf = JOptionPane.showConfirmDialog(null, "¿Quiere ver el Formato FUMP agregado?", "Archivo", JOptionPane.YES_NO_OPTION);
            if (opcionpdf == 0) {
                try {
                    Process p = Runtime.getRuntime().exec("rundll32 SHELL32.DLL,"
                            + "ShellExec_RunDLL " + rutaFUMP);
                } catch (Exception evvv) {
                    JOptionPane.showMessageDialog(null, "No se puede abrir el archivo de ayuda,"
                            + " probablemente fue borrado", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            lbIconCheck.setIcon(null);
            lbIconCheck.repaint();
            model.setFormatoFUMP(null);
        }

    
    }//GEN-LAST:event_btnFUMPActionPerformed

    private void FechaTermContratoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FechaTermContratoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_FechaTermContratoKeyReleased

    private void cbTerminoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTerminoItemStateChanged
        if (cbTermino.isSelected()) {
            FechaTermContrato.setEnabled(true);

        } else {
            FechaTermContrato.setEnabled(false);
        }
    }//GEN-LAST:event_cbTerminoItemStateChanged

    private void cmbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbItemStateChanged

    }//GEN-LAST:event_cmbItemStateChanged

    private void cmbPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmbPropertyChange

    }//GEN-LAST:event_cmbPropertyChange

    private void btnActualizarDLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarDLActionPerformed
UpdateDatosLaborales();
    }//GEN-LAST:event_btnActualizarDLActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser FechaIngreso;
    private com.toedter.calendar.JDateChooser FechaTermContrato;
    private javax.swing.JButton btnActualizarDL;
    private javax.swing.JButton btnFUMP;
    private javax.swing.JCheckBox cbTermino;
    private javax.swing.JComboBox<String> cmb;
    public javax.swing.JComboBox<String> cmbArea;
    private javax.swing.JComboBox<String> cmbCategoria;
    public javax.swing.JComboBox<String> cmbJefe;
    private javax.swing.JComboBox<String> cmbPlantel;
    private javax.swing.JComboBox<String> cmbPlaza;
    public javax.swing.JComboBox<String> cmbPuesto;
    private javax.swing.JComboBox<String> cmbSindicato;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbCodFError;
    private javax.swing.JLabel lbIconCheck;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel tb_laboral;
    private javax.swing.JPanel tp_DatosLaborales;
    private com.swing.JCTextField txtCodFinanzas;
    private com.swing.JCTextField txtHorario;
    private com.swing.JCTextField txtHoras;
    private javax.swing.JFormattedTextField txtSueldo;
    // End of variables declaration//GEN-END:variables
 private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
