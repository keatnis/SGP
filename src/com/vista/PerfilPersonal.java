package com.vista;

import com.DAO.PersonalNDAO;
import com.component.RegistrarFamiliar;

import com.model.ModelPersonalN;
import com.swing.ImageAvatar;
import java.awt.Desktop;
import java.awt.Image;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import com.component.Perfil;
import com.model.ModelPerfil;
import javax.swing.filechooser.FileNameExtensionFilter;

public final class PerfilPersonal extends javax.swing.JPanel {

   

    public PerfilPersonal() {
        initComponents();
        init();
    }

    void init() {
         ModelPerfil model = new ModelPerfil();
         ModelPersonalN model2 = new ModelPersonalN();
   // PersonalNDAO dao = new PersonalNDAO();
       model.setNombre(model2.getNombres());
       model.setNume(model2.getNumEmpleado());
       model.setPuesto(model2.getPuesto());
       model.setCumple(model2.getFechaNacimiento());
     model.setCorreo(model2.getPuesto());
       model.setSueldo(model2.getSueldo());
       model.setTeléfono(model2.getTelefono());
////        String nombre = dao.listPersonalPerfil().get(0).getNombres();
//        String numEmp = dao.listPersonalPerfil().get(0).getNumEmpleado();
//        String puesto = dao.listPersonalPerfil().get(0).getPuesto();
//        String sueldo = dao.listPersonalPerfil().get(0).getCURP();
//        String telefono = dao.listPersonalPerfil().get(0).getPuesto();
//        String fechana = dao.listPersonalPerfil().get(0).getPuesto();
        perfil.addPerfilPersonal(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        buttonBadges3 = new com.swing.ButtonBadges();
        jLabel58 = new javax.swing.JLabel();
        jCTextField23 = new com.swing.JCTextField();
        perfil = new com.component.Perfil();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        pdatosgenerales = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        txtAbrev = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new com.swing.JCTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAPaterno = new com.swing.JCTextField();
        jLabel5 = new javax.swing.JLabel();
        txtAMaterno = new com.swing.JCTextField();
        jLabel4 = new javax.swing.JLabel();
        rbHombre = new javax.swing.JRadioButton();
        rbMujer = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtTelefono = new com.swing.JCTextField();
        txtCorreoPers = new com.swing.JCTextField();
        txtCorreoInst = new com.swing.JCTextField();
        jLabel24 = new javax.swing.JLabel();
        cmbTsangre = new javax.swing.JComboBox<>();
        jLabel43 = new javax.swing.JLabel();
        txtCURP = new com.swing.JCTextField();
        jLabel44 = new javax.swing.JLabel();
        txtRFC = new com.swing.JCTextField();
        jLabel42 = new javax.swing.JLabel();
        txtIMSS = new com.swing.JCTextField();
        cmbLenguaIndig = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        cmbParentescoCE = new javax.swing.JComboBox<>();
        txtTelefonoCE = new com.swing.JCTextField();
        txtNombreContacto = new com.swing.JCTextField();
        txtFechaNac = new com.toedter.calendar.JDateChooser();
        txtNumEmp = new com.swing.JCTextField();
        jLabel53 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        panelRound2 = new com.swing.PanelRound();
        lbFoto = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        txtRutaFoto = new javax.swing.JTextField();
        buttonBadges = new com.swing.ButtonBadges();
        cmbEstadoCivil = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        buttonBadges5 = new com.swing.ButtonBadges();
        jPanel6 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        txtCalle = new com.swing.JCTextField();
        jLabel39 = new javax.swing.JLabel();
        txtLocalidad = new com.swing.JCTextField();
        jLabel41 = new javax.swing.JLabel();
        txtColonia = new com.swing.JCTextField();
        btnGuardarDatosGenerales = new com.swing.ButtonBadges();
        jPanel4 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableFamiliares = new javax.swing.JTable();
        btnListarFamiliares = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cmbEstados = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton6 = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        jComboBox10 = new javax.swing.JComboBox<>();
        jCTextField1 = new com.swing.JCTextField();
        jCTextField2 = new com.swing.JCTextField();
        jCheckBox5 = new javax.swing.JCheckBox();
        jLabel55 = new javax.swing.JLabel();
        jCheckBox6 = new javax.swing.JCheckBox();
        jPanel8 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel22 = new javax.swing.JLabel();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jLabel46 = new javax.swing.JLabel();
        jCTextField11 = new com.swing.JCTextField();
        jLabel45 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel51 = new javax.swing.JLabel();
        jCheckBox3 = new javax.swing.JCheckBox();
        jTextField1 = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jCTextField22 = new com.swing.JCTextField();
        buttonBadges1 = new com.swing.ButtonBadges();
        buttonBadges2 = new com.swing.ButtonBadges();
        laboral = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cmbPlaza = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        FechaIngreso = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        txtCodFinanzas = new com.swing.JCTextField();
        txtHorario = new com.swing.JCTextField();
        jLabel54 = new javax.swing.JLabel();
        cmbSindicato = new javax.swing.JComboBox<>();
        txtSueldo = new com.swing.JCTextField();
        cmbTipoContratacion = new javax.swing.JComboBox<>();
        txtHoras = new com.swing.JCTextField();
        txtArea = new com.swing.JCTextField();
        jLabel47 = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        cmbJefe = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        cmbPlantel = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jSpinner1 = new javax.swing.JSpinner();
        txtPuesto = new javax.swing.JComboBox<>();

        buttonBadges3.setBackground(new java.awt.Color(31, 44, 81));
        buttonBadges3.setForeground(new java.awt.Color(255, 255, 255));
        buttonBadges3.setText("Actualizar los datos");
        buttonBadges3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/search_30px.png"))); // NOI18N

        jCTextField23.setPlaceholder("Buscar...");

        jTabbedPane.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        jPanel3.setPreferredSize(new java.awt.Dimension(800, 808));

        jLabel59.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel59.setText("Abrebiatura");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nombre (s)");

        txtNombre.setPlaceholder("Nombre (s)");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Apellido Paterno");

        txtAPaterno.setPlaceholder("Apellido Paterno");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Apellido Materno");

        txtAMaterno.setPlaceholder("Apellido Materno");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Sexo");

        rbHombre.setText("Hombre");

        rbMujer.setText("Mujer");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Fecha de Nacimiento");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setText("Telefono Celular");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel32.setText("Correo Personal");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setText("Correo Institucional");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel30.setText("Lengua Indígena");

        txtTelefono.setPlaceholder("Teléfono Celular");

        txtCorreoPers.setPlaceholder("Correo Personal");

        txtCorreoInst.setPlaceholder("Correo Institucional");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setText("Tipo de Sangre");

        cmbTsangre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el tipo de sangre", "A+", "B+", "AB+", "O+", "A-", "B-", "AB-", "O-" }));

        jLabel43.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel43.setText("CURP");

        txtCURP.setPlaceholder("CURP");

        jLabel44.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel44.setText("RFC");

        txtRFC.setPlaceholder("RFC");

        jLabel42.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel42.setText("IMSS");

        txtIMSS.setPlaceholder("IMSS");

        cmbLenguaIndig.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccione--", "Náhuatl", "Maya", "Izeltal", "Mixteco", "Tsotsil", "Zapoteco", "Otomí", "Totonaco", "Tlapaneco", "Chol", "Mazateco", "Ninguno" }));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contacto de Emergencia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setText("Teléfono");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setText("Nombre");

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel40.setText("Parentesco");

        cmbParentescoCE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccionar --", "Padre", "Madre", "Esposa", "Esposo", "Hijo", "Hija", "amigo", "amiga", "otro" }));
        cmbParentescoCE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbParentescoCEActionPerformed(evt);
            }
        });

        txtTelefonoCE.setPlaceholder("Teléfono");

        txtNombreContacto.setPlaceholder("Nombre Completo");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(txtTelefonoCE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombreContacto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbParentescoCE, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtNombreContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(cmbParentescoCE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txtTelefonoCE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        txtNumEmp.setPlaceholder("No. de empleado");

        jLabel53.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel53.setText("Número de Empleado");

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/info_10px.png"))); // NOI18N
        jLabel12.setToolTipText("El número de empleado a usar es");

        panelRound2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel60.setText("Ruta");

        buttonBadges.setBackground(new java.awt.Color(204, 51, 0));
        buttonBadges.setForeground(new java.awt.Color(255, 255, 255));
        buttonBadges.setText("Agregar");
        buttonBadges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBadgesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel60)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRutaFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                        .addComponent(buttonBadges, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addContainerGap(65, Short.MAX_VALUE))
            .addComponent(lbFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lbFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addGap(11, 11, 11)
                .addComponent(buttonBadges, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(txtRutaFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        cmbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Soltero (a)", "Casado (a)", "Viudo (a)", "Divorciado (a)", "Unión Libre" }));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setText("Estado Civil");

        buttonBadges5.setBackground(new java.awt.Color(204, 204, 204));
        buttonBadges5.setLabel("Cancelar");

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Domicilio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel38.setText("Dirección");

        txtCalle.setPlaceholder("Calle y Número Exterior");

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel39.setText("Colonia");

        txtLocalidad.setPlaceholder("Localidad");

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel41.setText("Localidad");

        txtColonia.setPlaceholder("Colonia");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addComponent(jLabel39)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtColonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(txtColonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(txtLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        btnGuardarDatosGenerales.setBackground(new java.awt.Color(0, 44, 83));
        btnGuardarDatosGenerales.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarDatosGenerales.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnGuardarDatosGenerales.setLabel("Guardar y continuar");
        btnGuardarDatosGenerales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarDatosGeneralesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(txtCURP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jLabel44)
                                .addGap(16, 16, 16)
                                .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addGap(32, 32, 32)
                                .addComponent(txtCorreoPers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addGap(10, 10, 10)
                                .addComponent(txtCorreoInst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel30)
                                    .addComponent(jLabel24))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(cmbTsangre, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmbLenguaIndig, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel25))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(102, 102, 102)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(303, 303, 303)
                        .addComponent(buttonBadges5, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardarDatosGenerales, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(48, 48, 48)
                                        .addComponent(jLabel2))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(jLabel3))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(jLabel5))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(92, 92, 92)
                                        .addComponent(jLabel4))
                                    .addComponent(jLabel6)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(89, 89, 89)
                                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(4, 4, 4)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtAPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(txtAMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(rbHombre)
                                        .addGap(28, 28, 28)
                                        .addComponent(rbMujer))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(txtFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(txtIMSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(139, 139, 139)
                                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel59)
                                .addGap(10, 10, 10)
                                .addComponent(txtAbrev, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(198, 198, 198)
                                .addComponent(jLabel53)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(txtNumEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(jLabel59))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtAbrev, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel53))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNumEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel2)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel3)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel5)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel4)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel6)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(txtAPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtAMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbHombre)
                            .addComponent(rbMujer))
                        .addGap(13, 13, 13)
                        .addComponent(txtFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(txtIMSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCURP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel32))
                            .addComponent(txtCorreoPers, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel28))
                            .addComponent(txtCorreoInst, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel27)
                            .addComponent(cmbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(cmbTsangre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(cmbLenguaIndig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarDatosGenerales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonBadges5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78))
        );

        javax.swing.GroupLayout pdatosgeneralesLayout = new javax.swing.GroupLayout(pdatosgenerales);
        pdatosgenerales.setLayout(pdatosgeneralesLayout);
        pdatosgeneralesLayout.setHorizontalGroup(
            pdatosgeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pdatosgeneralesLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pdatosgeneralesLayout.setVerticalGroup(
            pdatosgeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pdatosgeneralesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 829, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(pdatosgenerales);

        jTabbedPane.addTab("Datos Generales", jScrollPane2);

        jPanel4.setPreferredSize(new java.awt.Dimension(500, 623));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel31.setText("¿Tiene Hijos? ");

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/add_25px.png"))); // NOI18N
        jButton2.setText("Añadir Familiares");
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tableFamiliares.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableFamiliares.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Parentesco", "Edad", "Estado"
            }
        ));
        jScrollPane1.setViewportView(tableFamiliares);

        btnListarFamiliares.setText("Listar");
        btnListarFamiliares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarFamiliaresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox2))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(btnListarFamiliares)
                .addGap(33, 33, 33))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addComponent(jCheckBox2))
                .addGap(41, 41, 41)
                .addComponent(jButton2)
                .addGap(11, 11, 11)
                .addComponent(btnListarFamiliares)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Farmacias", jPanel4);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Nivel de Estudios");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Licenciatura", "Maestría", "Doctorado", "Diplomado", "Otro" }));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Nombre de la Institución ");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Carrera Profesional");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("¿Tiene Posgrado?");

        cmbEstados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Entidad Federativa");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Año de Egreso");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("¿Cuenta conTitulo?");

        jButton6.setText("Buscar");

        jLabel37.setText("Años");

        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "1", "2", "3", "4", "5", "6", "7", "8" }));

        jCTextField1.setPlaceholder("Nombre de la Institución");

        jCTextField2.setPlaceholder("Carrera");

        jLabel55.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel55.setText("¿Tiene doctorado?");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel14)
                        .addGap(16, 16, 16)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel37)
                        .addGap(6, 6, 6)
                        .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel17)
                        .addGap(14, 14, 14)
                        .addComponent(jCTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel16)
                        .addGap(5, 5, 5)
                        .addComponent(jCTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButton6))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel19)
                            .addComponent(jLabel21)
                            .addComponent(jLabel18)
                            .addComponent(jLabel55))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(cmbEstados, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox1)
                                    .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox5)
                                    .addComponent(jCheckBox6))))))
                .addGap(0, 0, 0))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel17))
                            .addComponent(jCTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel16)
                                .addComponent(jCTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jButton6)))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(cmbEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addComponent(jLabel20))
                    .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jCheckBox5))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel55)
                    .addComponent(jCheckBox6))
                .addContainerGap())
        );

        jTabbedPane.addTab("Formacion Académica", jPanel5);

        jLabel36.setText("<html> Enlace a : <a href=\\\"\\\">Google Drive</a></html>");
        jLabel36.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel36MouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Favor de Registrar el Vencimieto de los siguientes documentos");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("ISSSTE");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Credencial de Elector (INE)");

        jLabel46.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel46.setText("Enlace de ubicación de la documentación digitalizada:");

        jCTextField11.setPlaceholder("Link a Google Drive");

        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/google_drive.png"))); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jCTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel45))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8)
                    .addComponent(jLabel46)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(58, 58, 58)
                    .addComponent(jLabel22)
                    .addContainerGap(581, Short.MAX_VALUE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel8)
                .addGap(26, 26, 26)
                .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(64, 64, 64)
                .addComponent(jLabel46)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(284, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(109, 109, 109)
                    .addComponent(jLabel22)
                    .addContainerGap(534, Short.MAX_VALUE)))
        );

        jTabbedPane.addTab("Documentación", jPanel8);

        jLabel50.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel50.setText("¿Ha padecido COVID-19 ?");

        jRadioButton3.setText("Si");

        jRadioButton4.setText("No");

        jLabel51.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel51.setText("¿ Esta vacunado (a)?");

        jLabel56.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel56.setText("Marca de la vacuna");

        jLabel57.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel57.setText("Comprobante de Vacunación");

        jButton7.setText("Agregar");

        jCTextField22.setPlaceholder("Ubicación");

        buttonBadges1.setBackground(new java.awt.Color(31, 44, 81));
        buttonBadges1.setForeground(new java.awt.Color(255, 255, 255));
        buttonBadges1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        buttonBadges1.setLabel("Guardar datos");

        buttonBadges2.setBackground(new java.awt.Color(204, 204, 204));
        buttonBadges2.setText("Anterior");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel57)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel50)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel51)
                                        .addComponent(jLabel56))
                                    .addGap(10, 10, 10))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jButton7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jRadioButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton4))
                            .addComponent(jCheckBox3)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(buttonBadges2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(buttonBadges1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(210, 210, 210))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel50)
                            .addComponent(jRadioButton3)
                            .addComponent(jRadioButton4))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel51))
                    .addComponent(jCheckBox3))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56))
                .addGap(39, 39, 39)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(jButton7)
                    .addComponent(jCTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonBadges2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonBadges1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(296, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Otros", jPanel9);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Código");

        cmbPlaza.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccione--", "Plaza de Jornada", "Plaza por  Hora/semana/mes", "Definitiva", "Temporal" }));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Fecha de ingreso");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Puesto Laboral");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Horas Laborales");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Tipo de Contratación");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("Jefe Inmediato");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Tipo de Plaza");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel34.setText("Horario de Trabajo");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel35.setText("Área de Adscripcion");

        jLabel49.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel49.setText("Sindicato");

        txtCodFinanzas.setPlaceholder("Código de Finanzas");

        txtHorario.setPlaceholder("Horario");

        jLabel54.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel54.setText("Sueldo");

        cmbSindicato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "SNTE", "SITEM", "CNTE" }));

        txtSueldo.setPlaceholder("Sueldo");

        cmbTipoContratacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Nómina", "Honorarios" }));

        txtHoras.setPlaceholder("Horas");

        txtArea.setPlaceholder("Área");

        jLabel47.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel47.setText("Categoria");

        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccionar --", "Directivo", "Administrativo", "Serivio General", "Docente" }));

        cmbJefe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccionar --" }));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel33.setText("Plantel");

        cmbPlantel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccionar --", "Tlapa", "Olinalá", "Iliatenco" }));
        cmbPlantel.setName(""); // NOI18N

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/save_35px.png"))); // NOI18N
        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtPuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccionar --" }));

        javax.swing.GroupLayout laboralLayout = new javax.swing.GroupLayout(laboral);
        laboral.setLayout(laboralLayout);
        laboralLayout.setHorizontalGroup(
            laboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(laboralLayout.createSequentialGroup()
                .addGroup(laboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(laboralLayout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(cmbTipoContratacion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(laboralLayout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(jLabel33)
                        .addGap(18, 18, 18)
                        .addComponent(cmbPlantel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(laboralLayout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(txtCodFinanzas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(laboralLayout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(FechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(laboralLayout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(jLabel35)
                        .addGap(12, 12, 12)
                        .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(laboralLayout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(jLabel47)
                        .addGap(12, 12, 12)
                        .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(laboralLayout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jLabel11)
                        .addGap(12, 12, 12)
                        .addComponent(txtHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(laboralLayout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(jLabel1)
                        .addGap(12, 12, 12)
                        .addComponent(cmbPlaza, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(laboralLayout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(jLabel54)
                        .addGap(19, 19, 19)
                        .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(laboralLayout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addGroup(laboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(laboralLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(txtPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(laboralLayout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(18, 18, 18)
                                .addComponent(cmbJefe, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(laboralLayout.createSequentialGroup()
                .addGroup(laboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(laboralLayout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jLabel49)
                        .addGap(18, 18, 18)
                        .addComponent(cmbSindicato, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(laboralLayout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jLabel34)
                        .addGap(16, 16, 16)
                        .addComponent(txtHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
        );
        laboralLayout.setVerticalGroup(
            laboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(laboralLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(laboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(laboralLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel13))
                    .addComponent(cmbTipoContratacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(laboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(laboralLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel33))
                    .addComponent(cmbPlantel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(laboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(laboralLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel7))
                    .addComponent(txtCodFinanzas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(laboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(FechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(laboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(laboralLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel23))
                    .addComponent(cmbJefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(laboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(laboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(laboralLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel35))
                    .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(laboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(laboralLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel47))
                    .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(laboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(laboralLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel11))
                    .addGroup(laboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(laboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(laboralLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel1))
                    .addComponent(cmbPlaza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(laboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(laboralLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(laboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel49)
                            .addComponent(cmbSindicato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(laboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(laboralLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel34))
                            .addGroup(laboralLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(txtHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, laboralLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(53, 53, 53)))
                .addGroup(laboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(laboralLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel54))
                    .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61))
        );

        jTabbedPane.addTab("Datos Laborales", new javax.swing.ImageIcon(getClass().getResource("/com/icon/contact_details_80px.png")), laboral); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 804, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(perfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonBadges3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(285, 285, 285)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 49, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(perfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(buttonBadges3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 340, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbParentescoCEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbParentescoCEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbParentescoCEActionPerformed

    private void buttonBadgesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBadgesActionPerformed

        ImageAvatar ia = new ImageAvatar();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo de imagen", "png", "jpg");
        JFileChooser selector = new JFileChooser();
        selector.setFileFilter(filtro);
        int opcion = selector.showOpenDialog(this);
//        if (opcion == JFileChooser.APPROVE_OPTION) {
//            String nombreArchivo = selector.getSelectedFile().getPath();
//            this.ruta = selector.getSelectedFile().toString();
//
//            txtRutaFoto.setText(nombreArchivo);
//            icono = new ImageIcon(nombreArchivo);
//            //     ImageIcon nuevoIcono = new ImageIcon(ia.toImage(icono));
//            lbFoto.setIcon(new ImageIcon(ia.toImage(icono)));
//            lbFoto.repaint();
//
//        }
    }//GEN-LAST:event_buttonBadgesActionPerformed

    private void btnGuardarDatosGeneralesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarDatosGeneralesActionPerformed

//        GuardarDatosG();
//        jTabbedPane.setEnabledAt(0, true);
//        jTabbedPane.setEnabledAt(1, true);
//        jTabbedPane.setEnabledAt(2, false);
//        jTabbedPane.setEnabledAt(3, false);
//        jTabbedPane.setEnabledAt(4, false);
//        jTabbedPane.setSelectedIndex(1);
    }//GEN-LAST:event_btnGuardarDatosGeneralesActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        RegistrarFamiliar dialog = new RegistrarFamiliar(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                dialog.setVisible(false);
            }
        });
        dialog.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnListarFamiliaresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarFamiliaresActionPerformed
        // listFamiliares(tableFamiliares);
    }//GEN-LAST:event_btnListarFamiliaresActionPerformed

    private void jLabel36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel36MouseClicked
        try {
            Desktop.getDesktop().browse(new URI("https://drive.google.com/drive/folders/1DvKbFO-0kpRrpbHoYCOT_zMYmRvpck3T?usp=sharing"));
        } catch (URISyntaxException | IOException ex) {

        }
    }//GEN-LAST:event_jLabel36MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        GuardarDatosLaborales();
//        jTabbedPane.setEnabledAt(0, true);
//        jTabbedPane.setEnabledAt(1, true);
//        jTabbedPane.setEnabledAt(2, true);
//        jTabbedPane.setEnabledAt(3, false);
//        jTabbedPane.setEnabledAt(4, false);
//        jTabbedPane.setSelectedIndex(2);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser FechaIngreso;
    private com.swing.ButtonBadges btnGuardarDatosGenerales;
    private javax.swing.JButton btnListarFamiliares;
    private com.swing.ButtonBadges buttonBadges;
    private com.swing.ButtonBadges buttonBadges1;
    private com.swing.ButtonBadges buttonBadges2;
    private com.swing.ButtonBadges buttonBadges3;
    private com.swing.ButtonBadges buttonBadges5;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbEstadoCivil;
    private javax.swing.JComboBox<String> cmbEstados;
    private javax.swing.JComboBox<String> cmbJefe;
    private javax.swing.JComboBox<String> cmbLenguaIndig;
    private javax.swing.JComboBox<String> cmbParentescoCE;
    private javax.swing.JComboBox<String> cmbPlantel;
    private javax.swing.JComboBox<String> cmbPlaza;
    private javax.swing.JComboBox<String> cmbSindicato;
    private javax.swing.JComboBox<String> cmbTipoContratacion;
    private javax.swing.JComboBox<String> cmbTsangre;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private com.swing.JCTextField jCTextField1;
    private com.swing.JCTextField jCTextField11;
    private com.swing.JCTextField jCTextField2;
    private com.swing.JCTextField jCTextField22;
    private com.swing.JCTextField jCTextField23;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JComboBox<String> jComboBox10;
    private javax.swing.JComboBox<String> jComboBox3;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTextField jTextField1;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private javax.swing.JPanel laboral;
    private javax.swing.JLabel lbFoto;
    private com.swing.PanelRound panelRound2;
    private javax.swing.JPanel pdatosgenerales;
    private com.component.Perfil perfil;
    private javax.swing.JRadioButton rbHombre;
    private javax.swing.JRadioButton rbMujer;
    private javax.swing.JTable tableFamiliares;
    private com.swing.JCTextField txtAMaterno;
    private com.swing.JCTextField txtAPaterno;
    private javax.swing.JTextField txtAbrev;
    private com.swing.JCTextField txtArea;
    private com.swing.JCTextField txtCURP;
    private com.swing.JCTextField txtCalle;
    private com.swing.JCTextField txtCodFinanzas;
    private com.swing.JCTextField txtColonia;
    private com.swing.JCTextField txtCorreoInst;
    private com.swing.JCTextField txtCorreoPers;
    private com.toedter.calendar.JDateChooser txtFechaNac;
    private com.swing.JCTextField txtHorario;
    private com.swing.JCTextField txtHoras;
    private com.swing.JCTextField txtIMSS;
    private com.swing.JCTextField txtLocalidad;
    private com.swing.JCTextField txtNombre;
    private com.swing.JCTextField txtNombreContacto;
    public com.swing.JCTextField txtNumEmp;
    private javax.swing.JComboBox<String> txtPuesto;
    private com.swing.JCTextField txtRFC;
    private javax.swing.JTextField txtRutaFoto;
    private com.swing.JCTextField txtSueldo;
    private com.swing.JCTextField txtTelefono;
    private com.swing.JCTextField txtTelefonoCE;
    // End of variables declaration//GEN-END:variables
}
