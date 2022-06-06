
package com.vista;

import com.DAO.PersonalNDAO;
import com.component.AddJefeImn;
import com.component.RegistrarFamiliar;
import com.connection.Conexion;
import com.model.ModelPersonalN;
import com.notification.Notification;
import com.swing.ImageAvatar;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.ScrollPane;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class RegistrarPN extends javax.swing.JPanel {

    public String ruta;
    public ImageIcon icono;
    ModelPersonalN model = new ModelPersonalN();
    PersonalNDAO DAO = new PersonalNDAO();

    public RegistrarPN() {
        initComponents();
        init();
        ObteberJefe();
    }

    void init() {
             comboBox();
            jTabbedPane.setEnabledAt(0, true);
                jTabbedPane.setEnabledAt(1, true);
                jTabbedPane.setEnabledAt(2, false);
                jTabbedPane.setSelectedIndex(0);

    }
      public void ObteberJefe() {
          Conexion con = new Conexion();
        try {
            con.getConnection();
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT concat(abrev,' ',nombre,' ',ape_paterno,' ',ape_materno)nombreJefe FROM db_rh.tbl_jefeinmediato");
            ResultSet res = pstm.executeQuery();

            while (res.next()) {
              String  tipoU = res.getString("nombreJefe");
                this.cmbJefe.addItem(tipoU);
            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    private void GuardarDatosG(){
        if(DAO.numEmpExiste(txtNumEmp.getText()) ==0){
            model.setNum_empleado(txtNumEmp.getText());
            model.setAbrev(txtAbrev.getText());
            model.setNombres(txtNombre.getText());
            model.setApellidoP(txtAPaterno.getText());
            model.setApellidoM(txtAMaterno.getText());
            String sexo = null;
            if (rbMujer.isSelected()) {
                sexo = "M";
            }
            if (rbHombre.isSelected()) {
                sexo = "H";
            }
            model.setSexo(sexo);
            SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
            String pasofecha = (formatofecha.format(txtFechaNac.getDate()));
            model.setFechaNacimiento(pasofecha);
            model.setTelefono(txtTelefono.getText());
            model.setCorreoPersonal(txtCorreoPers.getText());
            model.setCorreoInst(txtCorreoInst.getText());
            model.setCURP(txtCURP.getText());
            model.setRFC(txtRFC.getText());
            model.setIMSS(txtIMSS.getText());
            String estadoCivil = (String) cmbEstadoCivil.getSelectedItem();
            model.setEstadoCivil(estadoCivil);
            String lenguaInd = (String) cmbLenguaIndig.getSelectedItem();
            model.setLenguaIndigena(lenguaInd);

            String tipoSangre=(String)cmbTsangre.getSelectedItem();
            model.setTipoSangre(tipoSangre);
       
            model.setDirección(txtCalle.getText());
            model.setColonia(txtColonia.getText());
            model.setLocalidad(txtLocalidad.getText());
            model.setNombreCEmerg(txtNombreContacto.getText());

            String ParentescoCE =(String)cmbParentescoCE.getSelectedItem();
            model.setParentestoCEmerg(ParentescoCE);
            model.setTelefonoCE(txtTelefonoCE.getText());

            if (DAO.GuardarPersonal(model)) {
 Notification panel = new Notification(new MainSystem(), Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Datos Generales registrados correctamente");
            } else {
                JOptionPane.showMessageDialog(null, ERROR);
            }

        }else{
            JOptionPane.showMessageDialog(null, "El número de empleado ya está en uso");
        }
    }
    void comboBox() {
        String[] estado = {"Aguascalientes", "Baja California", "Baja California Sur", "Campeche", "Chiapas", "Chihuahua", "Coahuila de Zaragoza", "Colima", "Ciudad de México", "Durango", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco", "Estado de Mexico", "Michoacan de Ocampo", "Morelos", "Nayarit", "Nuevo Leon", "Oaxaca", "Puebla", "Queretaro de Arteaga", "Quintana Roo", "San Luis Potosi", "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz de Ignacio de la Llave", "Yucatan", "Zacatecas"};
        //   ArrayList<String> estados = new ArrayList<>(Arrays.asList("Aguascalientes","Baja California","Baja California Sur","Campeche","Chiapas","Chihuahua","Coahuila de Zaragoza","Colima","Ciudad de México","Durango","Guanajuato","Guerrero","Hidalgo","Jalisco","Estado de Mexico","Michoacan de Ocampo","Morelos","Nayarit","Nuevo Leon","Oaxaca","Puebla","Queretaro de Arteaga","Quintana Roo","San Luis Potosi","Sinaloa","Sonora","Tabasco","Tamaulipas","Tlaxcala","Veracruz de Ignacio de la Llave","Yucatan","Zacatecas"));
        cmbEstados.setModel(new javax.swing.DefaultComboBoxModel<>(estado));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sexo = new javax.swing.ButtonGroup();
        opcion = new javax.swing.ButtonGroup();
        lenguaIndigena = new javax.swing.ButtonGroup();
        jTabbedPane = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        pdatosgenerales = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
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
        lbFoto1 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        txtRutaFoto1 = new javax.swing.JTextField();
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
        laboral = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cmbPlaza = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jFechaIngreso = new com.toedter.calendar.JDateChooser();
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
        jComboBox5 = new javax.swing.JComboBox<>();
        txtSueldo = new com.swing.JCTextField();
        jComboBox4 = new javax.swing.JComboBox<>();
        txtPuesto = new com.swing.JCTextField();
        txtHoras = new com.swing.JCTextField();
        txtArea = new com.swing.JCTextField();
        jLabel47 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        cmbJefe = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel22 = new javax.swing.JLabel();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jLabel46 = new javax.swing.JLabel();
        jCTextField11 = new com.swing.JCTextField();
        jLabel45 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
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

        setPreferredSize(new java.awt.Dimension(1000, 709));
        setLayout(new java.awt.GridBagLayout());

        jTabbedPane.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 808));

        jLabel58.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel58.setText("Abrebiatura");

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

        sexo.add(rbHombre);
        rbHombre.setText("Hombre");

        sexo.add(rbMujer);
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

        cmbLenguaIndig.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Náhuatl", "Maya", "Izeltal", "Mixteco", "Tsotsil", "Zapoteco", "Otomí", "Totonaco", "Tlapaneco", "Chol", "Mazateco", "Ninguno" }));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contacto de Emergencia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setText("Teléfono");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setText("Nombre");

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel40.setText("Parentesco");

        cmbParentescoCE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Padre", "Madre", "Esposa", "Esposo", "Hijo", "Hija", "amigo", "amiga", "otro" }));

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

        jLabel59.setText("Ruta");

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
                .addComponent(jLabel59)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRutaFoto1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                        .addComponent(buttonBadges, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addContainerGap(65, Short.MAX_VALUE))
            .addComponent(lbFoto1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lbFoto1, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addGap(11, 11, 11)
                .addComponent(buttonBadges, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(txtRutaFoto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(txtCURP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jLabel44)
                                .addGap(16, 16, 16)
                                .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addGap(32, 32, 32)
                                .addComponent(txtCorreoPers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addGap(10, 10, 10)
                                .addComponent(txtCorreoInst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel30)
                                    .addComponent(jLabel24))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(cmbTsangre, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmbLenguaIndig, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel25))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(102, 102, 102)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(303, 303, 303)
                        .addComponent(buttonBadges5, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardarDatosGenerales, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(48, 48, 48)
                                        .addComponent(jLabel2))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(jLabel3))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(jLabel5))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(92, 92, 92)
                                        .addComponent(jLabel4))
                                    .addComponent(jLabel6)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(89, 89, 89)
                                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(4, 4, 4)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtAPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(txtAMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(rbHombre)
                                        .addGap(28, 28, 28)
                                        .addComponent(rbMujer))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(txtFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(txtIMSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(139, 139, 139)
                                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel58)
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
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(jLabel58))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtAbrev, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel53))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNumEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(txtAPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtAMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbHombre)
                            .addComponent(rbMujer))
                        .addGap(13, 13, 13)
                        .addComponent(txtFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(txtIMSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCURP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel32))
                            .addComponent(txtCorreoPers, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel28))
                            .addComponent(txtCorreoInst, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel27)
                            .addComponent(cmbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(cmbTsangre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(cmbLenguaIndig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarDatosGenerales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonBadges5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78))
        );

        javax.swing.GroupLayout pdatosgeneralesLayout = new javax.swing.GroupLayout(pdatosgenerales);
        pdatosgenerales.setLayout(pdatosgeneralesLayout);
        pdatosgeneralesLayout.setHorizontalGroup(
            pdatosgeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pdatosgeneralesLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pdatosgeneralesLayout.setVerticalGroup(
            pdatosgeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pdatosgeneralesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 829, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(pdatosgenerales);

        jTabbedPane.addTab("Datos Generales", jScrollPane2);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Código");

        cmbPlaza.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tlapa de Comonfort", "Olinalá", "Iliatenco" }));
        cmbPlaza.setSelectedIndex(-1);

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

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "SNTE", "SITEM", "CNTE" }));
        jComboBox5.setSelectedIndex(-1);

        txtSueldo.setPlaceholder("Sueldo");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Nómina", "Honorarios" }));

        txtPuesto.setPlaceholder("Puesto");

        txtHoras.setPlaceholder("Horas");

        txtArea.setPlaceholder("Área");

        jLabel47.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel47.setText("Categoria");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccionar --", "Directivo", "Administrativo", "Serivio General", "Docente" }));

        cmbJefe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccionar --" }));

        javax.swing.GroupLayout laboralLayout = new javax.swing.GroupLayout(laboral);
        laboral.setLayout(laboralLayout);
        laboralLayout.setHorizontalGroup(
            laboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, laboralLayout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(laboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel34)
                    .addComponent(jLabel49)
                    .addComponent(jLabel1)
                    .addComponent(jLabel35)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10)
                    .addComponent(jLabel23)
                    .addGroup(laboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel13)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, laboralLayout.createSequentialGroup()
                            .addGap(0, 111, Short.MAX_VALUE)
                            .addGroup(laboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel47, javax.swing.GroupLayout.Alignment.TRAILING)))))
                .addGroup(laboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(laboralLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(laboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(laboralLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(laboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(laboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jComboBox4, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCodFinanzas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                            .addComponent(txtPuesto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtHoras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbPlaza, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbJefe, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(322, 322, 322))
            .addGroup(laboralLayout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addComponent(jLabel54)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        laboralLayout.setVerticalGroup(
            laboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(laboralLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(laboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(laboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCodFinanzas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(laboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(laboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(cmbJefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(laboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(laboralLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addGap(61, 61, 61))
                    .addGroup(laboralLayout.createSequentialGroup()
                        .addComponent(txtPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(laboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35))))
                .addGroup(laboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(laboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(laboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbPlaza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(laboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(laboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(txtHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(laboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90))
        );

        jTabbedPane.addTab("Datos Laborales", new javax.swing.ImageIcon(getClass().getResource("/com/icon/contact_details_80px.png")), laboral); // NOI18N

        jPanel3.setPreferredSize(new java.awt.Dimension(500, 623));

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

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addComponent(jCheckBox2))
                .addGap(41, 41, 41)
                .addComponent(jButton2)
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Farmacias", jPanel3);

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
        jLabel36.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jCTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel45))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8)
                    .addComponent(jLabel46)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(58, 58, 58)
                    .addComponent(jLabel22)
                    .addContainerGap(581, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel8)
                .addGap(26, 26, 26)
                .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(64, 64, 64)
                .addComponent(jLabel46)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(235, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(109, 109, 109)
                    .addComponent(jLabel22)
                    .addContainerGap(485, Short.MAX_VALUE)))
        );

        jTabbedPane.addTab("Documentación", jPanel2);

        jLabel50.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel50.setText("¿Ha padecido COVID-19 ?");

        opcion.add(jRadioButton3);
        jRadioButton3.setText("Si");

        opcion.add(jRadioButton4);
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

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel57)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel50)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel51)
                                        .addComponent(jLabel56))
                                    .addGap(10, 10, 10))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jButton7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jRadioButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton4))
                            .addComponent(jCheckBox3)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(buttonBadges2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(buttonBadges1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(210, 210, 210))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel50)
                            .addComponent(jRadioButton3)
                            .addComponent(jRadioButton4))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel51))
                    .addComponent(jCheckBox3))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56))
                .addGap(39, 39, 39)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(jButton7)
                    .addComponent(jCTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonBadges2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonBadges1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(247, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Otros", jPanel8);

        add(jTabbedPane, new java.awt.GridBagConstraints());
    }// </editor-fold>//GEN-END:initComponents

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

    private void jLabel36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel36MouseClicked
        try {
            Desktop.getDesktop().browse(new URI("https://drive.google.com/drive/folders/1DvKbFO-0kpRrpbHoYCOT_zMYmRvpck3T?usp=sharing"));
        } catch (URISyntaxException | IOException ex) {

        }
    }//GEN-LAST:event_jLabel36MouseClicked

    private void btnGuardarDatosGeneralesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarDatosGeneralesActionPerformed

  GuardarDatosG();
//   jTabbedPane.setEnabledAt(0, true);
//                jTabbedPane.setEnabledAt(1, true);
//                jTabbedPane.setEnabledAt(2, false);
//                jTabbedPane.setSelectedIndex(1);
    }//GEN-LAST:event_btnGuardarDatosGeneralesActionPerformed

    private void buttonBadgesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBadgesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonBadgesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.swing.ButtonBadges btnGuardarDatosGenerales;
    private com.swing.ButtonBadges buttonBadges;
    private com.swing.ButtonBadges buttonBadges1;
    private com.swing.ButtonBadges buttonBadges2;
    private com.swing.ButtonBadges buttonBadges5;
    private javax.swing.JComboBox<String> cmbEstadoCivil;
    private javax.swing.JComboBox<String> cmbEstados;
    private javax.swing.JComboBox<String> cmbJefe;
    private javax.swing.JComboBox<String> cmbLenguaIndig;
    private javax.swing.JComboBox<String> cmbParentescoCE;
    private javax.swing.JComboBox<String> cmbPlaza;
    private javax.swing.JComboBox<String> cmbTsangre;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private com.swing.JCTextField jCTextField1;
    private com.swing.JCTextField jCTextField11;
    private com.swing.JCTextField jCTextField2;
    private com.swing.JCTextField jCTextField22;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox10;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private com.toedter.calendar.JDateChooser jFechaIngreso;
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private javax.swing.JPanel laboral;
    private javax.swing.JLabel lbFoto1;
    private javax.swing.ButtonGroup lenguaIndigena;
    private javax.swing.ButtonGroup opcion;
    private com.swing.PanelRound panelRound2;
    private javax.swing.JPanel pdatosgenerales;
    private javax.swing.JRadioButton rbHombre;
    private javax.swing.JRadioButton rbMujer;
    private javax.swing.ButtonGroup sexo;
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
    private com.swing.JCTextField txtNumEmp;
    private com.swing.JCTextField txtPuesto;
    private com.swing.JCTextField txtRFC;
    private javax.swing.JTextField txtRutaFoto1;
    private com.swing.JCTextField txtSueldo;
    private com.swing.JCTextField txtTelefono;
    private com.swing.JCTextField txtTelefonoCE;
    // End of variables declaration//GEN-END:variables
}
