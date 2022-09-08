package com.vista.edit;

import com.DAO.BajaPersonalDAO;
import com.DAO.PersonalNDAO;
import com.classes.Validaciones;
import com.ibm.icu.text.SimpleDateFormat;
import com.model.ModelPersonalN;
import com.swing.ImageAvatar;
import java.awt.event.KeyEvent;
import static java.awt.image.ImageObserver.ERROR;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.regex.Matcher;
import javax.swing.JOptionPane;

public class editarDG extends javax.swing.JDialog {

    public ImageIcon icono;
    ModelPersonalN model = new ModelPersonalN();
    PersonalNDAO DAO = new PersonalNDAO();
    BajaPersonalDAO daoBaja = new BajaPersonalDAO();
    private int id;
    Set<String> s;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public editarDG(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        s = new TreeSet<>();
        s.add("@itsm-tlapa.edu.mx");
      //  s.add("itsm-tlapa.edu.mx");
        initComponents();
    }

    public void editData(ModelPersonalN data) {
        txtNumEmp.setText(data.getNumEmpleado());
        txtAbrev.setText(data.getAbrev());
        txtNombre.setText(data.getNombres());
        txtAPaterno.setText(data.getApellidoP());
        txtAMaterno.setText(data.getApellidoM());
        if (data.getSexo().equals("M")) {
            rbMujer.setSelected(true);
            lbFoto.repaint();
            String[] eCivil_a = {" ", "Soltera", "Casada", "Viuda", "Divorciada", "Unión Libre", "Otro"};

            cmbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(eCivil_a));
        } else {
            rbHombre.setSelected(true);
            lbFoto.repaint();
            String[] eCivil_o = {" ", "Soltero", "Casado", "Viudo", "Divorciado", "Unión Libre", "Otro"};
            cmbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(eCivil_o));
        }

        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(data.getFechaNacimiento());
            txtFechaNac.setDate(date);
        } catch (ParseException ex) {
            Logger.getLogger(editarDG.class.getName()).log(Level.SEVERE, null, ex);
        }

        cmbEstadoCivil.setSelectedItem(data.getEstadoCivil());
        txtTelefono.setText(data.getTelefono());
        txtIMSS.setText(data.getIMSS());
        txtCURP.setText(data.getCURP());
        txtRFC.setText(data.getRFC());
        txtCorreoPers.setText(data.getCorreoPersonal());
        txtCorreoInst.setText(data.getCorreoInst());
        cmbTsangre.setSelectedItem(data.getTipoSangre());
        cmbLenguaIndig.setSelectedItem(data.getLenguaIndigena());
        lbFoto.setIcon(data.getIcon());
        txtNombreContacto.setText(data.getNombreCEmerg());
        cmbParentescoCE.setSelectedItem(data.getParentestoCEmerg());
        txtTelefonoCE.setText(data.getTelefonoCE());
        txtCalle.setText(data.getDirección());
        txtColonia.setText(data.getColonia());
        txtLocalidad.setText(data.getLocalidad());
        if(data.getPadreomadre().equals("1")){
            rbSI.setSelected(true);
        }else if(data.equals("N/A")){
            rbpm.clearSelection();
        }
        else{
            rbNO.setSelected(true);
        }
        

    }

    private void UpdateDatosG() throws FileNotFoundException {

        if (id > 0) {

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
            java.text.SimpleDateFormat formatofecha = new java.text.SimpleDateFormat("yyyy-MM-dd");
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

            String tipoSangre = (String) cmbTsangre.getSelectedItem();
            model.setTipoSangre(tipoSangre);

            model.setDirección(txtCalle.getText());
            model.setColonia(txtColonia.getText());
            model.setLocalidad(txtLocalidad.getText());
            model.setNombreCEmerg(txtTelefonoCE.getText());
            if (model.getFoto_paht() == null) {
                if (rbHombre.isSelected()) {
                    model.setFoto_paht("src/com/icon/foto_hombre.jpg");
                } else {
                    model.setFoto_paht("src/com/icon/foto_mujer.png");
                }

            } else {

                model.setFoto_paht(model.getFoto_paht());
            }
            String ParentescoCE = (String) cmbParentescoCE.getSelectedItem();
            model.setParentestoCEmerg(ParentescoCE);
            model.setTelefonoCE(txtTelefonoCE.getText());
            if(rbSI.isSelected()){
                model.setPadreomadre("1");
            }else if(!rbSI.isSelected() && !rbNO.isSelected()){
                 model.setPadreomadre("N/A");
            }else if(rbNO.isSelected()){
                 model.setPadreomadre("0");
            }
            if (DAO.editarDatosG(model, id) == 0) {
                JOptionPane.showMessageDialog(null, "Actualizado correctamente");

            } else {
                JOptionPane.showMessageDialog(null, ERROR);
            }

        } else {
            JOptionPane.showMessageDialog(null, "");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbpm = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        pdatosgenerales = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
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
        txtNombreContacto = new com.swing.JCTextField();
        txtTelefonoCE = new javax.swing.JFormattedTextField();
        txtFechaNac = new com.toedter.calendar.JDateChooser();
        txtNumEmp = new com.swing.JCTextField();
        jLabel53 = new javax.swing.JLabel();
        panelRound2 = new com.swing.PanelRound();
        btnAgregarFoto = new com.swing.ButtonBadges();
        lbFoto = new com.swing.ImageAvatar();
        btnQuitarFoto = new javax.swing.JButton();
        cmbEstadoCivil = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        txtCalle = new com.swing.JCTextField();
        jLabel39 = new javax.swing.JLabel();
        txtLocalidad = new com.swing.JCTextField();
        jLabel41 = new javax.swing.JLabel();
        txtColonia = new com.swing.JCTextField();
        jLabel45 = new javax.swing.JLabel();
        txtMunicipio = new com.swing.JCTextField();
        txtcp = new com.swing.JCTextField();
        jLabel47 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtAbrev = new com.swing.JCTextField();
        txtTelefono = new javax.swing.JFormattedTextField();
        lbRFCError = new javax.swing.JLabel();
        lbErrorCURP = new javax.swing.JLabel();
        lbCorreoInstError = new javax.swing.JLabel();
        lbCorreoError = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        rbSI = new javax.swing.JRadioButton();
        rbNO = new javax.swing.JRadioButton();
        btnUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar datos generales");
        setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N

        pdatosgenerales.setPreferredSize(new java.awt.Dimension(888, 863));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 808));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        jLabel58.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel58.setText("Abrebiatura");

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel2.setText("Nombre (s) *");

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtNombre.setPlaceholder("Nombre (s)");
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel3.setText("Apellido Paterno");

        txtAPaterno.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtAPaterno.setPlaceholder("Apellido Paterno");
        txtAPaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAPaternoKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel5.setText("Apellido Materno");

        txtAMaterno.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtAMaterno.setPlaceholder("Apellido Materno");
        txtAMaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAMaternoKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel4.setText("Sexo");

        rbHombre.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        rbHombre.setText("Hombre");
        rbHombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbHombreActionPerformed(evt);
            }
        });

        rbMujer.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        rbMujer.setText("Mujer");
        rbMujer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMujerActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel6.setText("Fecha de Nacimiento");

        jLabel25.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel25.setText("Telefono Celular");

        jLabel32.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel32.setText("Correo Personal");

        jLabel28.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel28.setText("Correo Institucional");

        jLabel30.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel30.setText("Lengua Indígena");

        txtCorreoPers.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtCorreoPers.setPlaceholder("Correo Personal");
        txtCorreoPers.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorreoPersKeyTyped(evt);
            }
        });

        txtCorreoInst.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtCorreoInst.setPlaceholder("Correo Institucional");
        txtCorreoInst.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorreoInstKeyTyped(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel24.setText("Tipo de Sangre");

        cmbTsangre.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        cmbTsangre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "A+", "B+", "AB+", "O+", "A-", "B-", "AB-", "O-" }));

        jLabel43.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel43.setText("CURP");

        txtCURP.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtCURP.setPlaceholder("CURP");
        txtCURP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCURPKeyTyped(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel44.setText("RFC");

        txtRFC.setToolTipText("Registro Federal de Contribuyentes (RFC)");
        txtRFC.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtRFC.setPlaceholder("RFC");
        txtRFC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRFCKeyTyped(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel42.setText("IMSS");

        txtIMSS.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtIMSS.setPlaceholder("IMSS");
        txtIMSS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIMSSKeyTyped(evt);
            }
        });

        cmbLenguaIndig.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        cmbLenguaIndig.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Náhuatl", "Maya", "Izeltal", "Mixteco", "Tsotsil", "Zapoteco", "Otomí", "Totonaco", "Tlapaneco", "Chol", "Mazateco", "Ninguno" }));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contacto de Emergencia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel29.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel29.setText("Teléfono");

        jLabel26.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel26.setText("Nombre");

        jLabel40.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel40.setText("Parentesco");

        cmbParentescoCE.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        cmbParentescoCE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Esposa", "Esposo", "Hijo", "Hija", "Padre", "Madre", "Hernano", "Hermano", "Amigo", "Amiga", "Otro parentesco" }));
        cmbParentescoCE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbParentescoCEActionPerformed(evt);
            }
        });

        txtNombreContacto.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtNombreContacto.setPlaceholder("Nombre Completo");
        txtNombreContacto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreContactoKeyTyped(evt);
            }
        });

        try {
            txtTelefonoCE.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-#######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefonoCE.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        txtTelefonoCE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTelefonoCEMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(jLabel40)
                    .addComponent(jLabel29))
                .addGap(13, 13, 13)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombreContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbParentescoCE, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefonoCE, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
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
                    .addComponent(txtTelefonoCE, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtFechaNac.setBackground(new java.awt.Color(244, 244, 244));
        txtFechaNac.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(244, 244, 244)));
        txtFechaNac.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        txtFechaNac.setMaxSelectableDate(new java.util.Date(253370790109000L));
        txtFechaNac.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtFechaNacPropertyChange(evt);
            }
        });

        txtNumEmp.setEditable(false);
        txtNumEmp.setForeground(new java.awt.Color(153, 0, 0));
        txtNumEmp.setFont(new java.awt.Font("Poppins", 1, 22)); // NOI18N
        txtNumEmp.setPlaceholder("No.");

        jLabel53.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel53.setText("Número de Empleado /a:");
        jLabel53.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel53MouseClicked(evt);
            }
        });

        panelRound2.setBackground(new java.awt.Color(255, 255, 255));

        btnAgregarFoto.setBackground(new java.awt.Color(204, 51, 0));
        btnAgregarFoto.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarFoto.setText("Agregar");
        btnAgregarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarFotoActionPerformed(evt);
            }
        });

        lbFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/foto_hombre.jpg"))); // NOI18N

        btnQuitarFoto.setText("Quitar");
        btnQuitarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarFotoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(btnAgregarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnQuitarFoto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuitarFoto))
                .addGap(21, 21, 21))
        );

        cmbEstadoCivil.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        jLabel27.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel27.setText("Estado Civil");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Domicilio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel38.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel38.setText("Dirección");

        txtCalle.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtCalle.setPlaceholder("Calle y Número Exterior");

        jLabel39.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel39.setText("Colonia");

        txtLocalidad.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtLocalidad.setPlaceholder("Localidad");
        txtLocalidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLocalidadKeyTyped(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel41.setText("Localidad");

        txtColonia.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtColonia.setPlaceholder("Colonia");
        txtColonia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtColoniaKeyTyped(evt);
            }
        });

        jLabel45.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel45.setText("Municipio");

        txtMunicipio.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtMunicipio.setPlaceholder("Municipio");
        txtMunicipio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMunicipioKeyTyped(evt);
            }
        });

        txtcp.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtcp.setPlaceholder("Código Postal");
        txtcp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcpKeyTyped(evt);
            }
        });

        jLabel47.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel47.setText("C.P.");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addComponent(jLabel39)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtColonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtColonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtAbrev.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtAbrev.setPlaceholder("Abrev.");
        txtAbrev.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAbrevKeyTyped(evt);
            }
        });

        try {
            txtTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-#######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefono.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        txtTelefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTelefonoMouseClicked(evt);
            }
        });

        lbRFCError.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbRFCError.setForeground(new java.awt.Color(204, 0, 0));

        lbErrorCURP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbErrorCURP.setForeground(new java.awt.Color(204, 0, 0));

        lbCorreoInstError.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbCorreoInstError.setForeground(new java.awt.Color(204, 0, 0));
        lbCorreoInstError.setAutoscrolls(true);

        lbCorreoError.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbCorreoError.setForeground(new java.awt.Color(204, 0, 0));
        lbCorreoError.setAutoscrolls(true);

        jLabel23.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel23.setText("¿Es padre o madre?");

        rbpm.add(rbSI);
        rbSI.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        rbSI.setText("Si");

        rbpm.add(rbNO);
        rbNO.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        rbNO.setText("No");

        btnUpdate.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(51, 51, 51));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/icons8-aprobar-y-actualizar-48.png"))); // NOI18N
        btnUpdate.setText("Actualizar");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel32)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel43)
                                    .addComponent(jLabel44)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel30)
                                    .addComponent(jLabel24))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtAbrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtAPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtAMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCorreoPers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCorreoInst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtIMSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCURP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbLenguaIndig, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbTsangre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbErrorCURP, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addComponent(rbSI)
                                        .addGap(53, 53, 53)
                                        .addComponent(rbNO))))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(85, 85, 85)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel53)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNumEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(lbCorreoInstError, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(lbRFCError, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(lbCorreoError, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(rbHombre)
                        .addGap(6, 6, 6)
                        .addComponent(rbMujer))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel58))
                    .addComponent(txtAbrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel53)
                            .addComponent(txtNumEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel2)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel3)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel5)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel4)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel6)
                        .addGap(17, 17, 17)
                        .addComponent(jLabel32))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtAPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtAMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(rbHombre))
                            .addComponent(rbMujer))
                        .addGap(5, 5, 5)
                        .addComponent(txtFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(txtCorreoPers, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lbCorreoError, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(txtCorreoInst, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lbCorreoInstError, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel25))
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIMSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCURP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(lbErrorCURP, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbRFCError, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                            .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(cmbEstadoCivil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbSI)
                                    .addComponent(rbNO)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel23)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbLenguaIndig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbTsangre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))))
                .addGap(18, 18, 18)
                .addComponent(btnUpdate)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pdatosgeneralesLayout = new javax.swing.GroupLayout(pdatosgenerales);
        pdatosgenerales.setLayout(pdatosgeneralesLayout);
        pdatosgeneralesLayout.setHorizontalGroup(
            pdatosgeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pdatosgeneralesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pdatosgeneralesLayout.setVerticalGroup(
            pdatosgeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pdatosgeneralesLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 863, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(pdatosgenerales);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 861, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleDescription("En esta ventana se modifica y se actualiza la información");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        Validaciones.soloRecibeTexto(evt);
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtAPaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAPaternoKeyTyped
        Validaciones.soloRecibeTexto(evt);
    }//GEN-LAST:event_txtAPaternoKeyTyped

    private void txtAMaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAMaternoKeyTyped
        Validaciones.soloRecibeTexto(evt);
    }//GEN-LAST:event_txtAMaternoKeyTyped

    private void rbHombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbHombreActionPerformed
        lbFoto.setIcon(new ImageIcon("src/com/icon/foto_hombre.jpg"));
        lbFoto.repaint();

        String[] eCivil_o = {" ", "Soltero", "Casado", "Viudo", "Divorciado", "Unión Libre", "Otro"};

        cmbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(eCivil_o));
    }//GEN-LAST:event_rbHombreActionPerformed

    private void rbMujerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMujerActionPerformed
        lbFoto.setIcon(new ImageIcon("src/com/icon/foto_mujer.png"));
        lbFoto.repaint();
        String[] eCivil_a = {" ", "Soltera", "Casada", "Viuda", "Divorciada", "Unión Libre", "Otro"};
        cmbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(eCivil_a));
    }//GEN-LAST:event_rbMujerActionPerformed

    private void txtCorreoPersKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoPersKeyTyped
        Matcher mat;
        Pattern pat = Pattern.compile("^([a-zA-Z0-9_!#$%&'\\*+/=?{|}~^.-]+@[a-zA-Z0-9.-]+)$");

        mat = pat.matcher(txtCorreoPers.getText());
        if (mat.matches() == false) {
            Validaciones.revisarLongitud(evt, txtCorreoPers, 100);
            lbCorreoError.setText("Correo incorrecto!");

        } else {
            lbCorreoError.setText("");
        }

        //lbCorreoError
    }//GEN-LAST:event_txtCorreoPersKeyTyped

    private void txtCorreoInstKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoInstKeyTyped
        Matcher mat;
        Pattern pat = Pattern.compile("^[a-zA-Z0-9_!#$%&'\\*+/=?{|}~^.-]+@itsm-tlapa.edu.mx\\s");

        mat = pat.matcher(txtCorreoInst.getText());
        if (mat.matches() == false) {
            Validaciones.revisarLongitud(evt, txtCorreoInst, 100);
            lbCorreoInstError.setText("Correo incorrecto!");

        } else {
            lbCorreoInstError.setText("");
        }
    }//GEN-LAST:event_txtCorreoInstKeyTyped

    private void txtCURPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCURPKeyTyped
        Matcher mat;
        Pattern pat = Pattern.compile("^(([A-Z][AEIOUX][A-Z]{2}\\d{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[12]\\d|3[01])[HM](?:AS|B[CS]|C[CLMSH]|D[FG]|G[TR]|HG|JC|M[CNS]|N[ETL]|OC|PL|Q[TR]|S[PLR]|T[CSL]|VZ|YN|ZS)[B-DF-HJ-NP-TV-Z]{3}[A-Z\\d])(\\d))$");
        mat = pat.matcher(txtCURP.getText());
        Validaciones.revisarLongitud(evt, txtCURP, 18);
        if (mat.matches() == false) {
            lbErrorCURP.setText("CURP incorecto!");

        } else {
            lbErrorCURP.setText("");
            //txtCURP.transferFocus();
        }

        char c = evt.getKeyChar();
        if (Character.isLetterOrDigit(c)) {
            //Codigo
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_txtCURPKeyTyped

    private void txtRFCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRFCKeyTyped
        Matcher mat, mat2;
        Pattern pat2 = Pattern.compile("^(([A-ZÑ&]{4})([0-9]{2})([0][13578]|[1][02])(([0][1-9]|[12][\\d])|[3][01])([A-Z0-9]{3}))|(([A-ZÑ&]{4})([0-9]{2})([0][13456789]|[1][012])(([0][1-9]|[12][\\d])|[3][0])([A-Z0-9]{3}))|(([A-ZÑ&]{4})([02468][048]|[13579][26])[0][2]([0][1-9]|[12][\\d])([A-Z0-9]{3}))|(([A-ZÑ&]{4})([0-9]{2})[0][2]([0][1-9]|[1][0-9]|[2][0-8])([A-Z0-9]{3}))$");
        mat2 = pat2.matcher(txtRFC.getText());
        Pattern pat = Pattern.compile("^(([A-ZÑ&]{3})([0-9]{2})([0][13578]|[1][02])(([0][1-9]|[12][\\d])|[3][01])([A-Z0-9]{3}))|(([A-ZÑ&]{3})([0-9]{2})([0][13456789]|[1][012])(([0][1-9]|[12][\\d])|[3][0])([A-Z0-9]{3}))|(([A-ZÑ&]{3})([02468][048]|[13579][26])[0][2]([0][1-9]|[12][\\d])([A-Z0-9]{3}))|(([A-ZÑ&]{3})([0-9]{2})[0][2]([0][1-9]|[1][0-9]|[2][0-8])([A-Z0-9]{3}))$");
        mat = pat.matcher(txtRFC.getText());
        Validaciones.revisarLongitud(evt, txtRFC, 13);
        if (mat.matches() == false && mat2.matches() == false) {

            lbRFCError.setText("RFC incorecto!");

        } else {
            lbRFCError.setText("");
        }

        char c = evt.getKeyChar();
        if (Character.isLetterOrDigit(c)) {
            //Codigo
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_txtRFCKeyTyped

    private void txtIMSSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIMSSKeyTyped
        // Validaciones.esNumeroEntero(evt);
        //  Validaciones.revisarLongitud(evt, txtIMSS, 11);
    }//GEN-LAST:event_txtIMSSKeyTyped

    private void cmbParentescoCEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbParentescoCEActionPerformed

    }//GEN-LAST:event_cmbParentescoCEActionPerformed

    private void txtNombreContactoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreContactoKeyTyped
        Validaciones.soloRecibeTexto(evt);
    }//GEN-LAST:event_txtNombreContactoKeyTyped

    private void txtTelefonoCEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTelefonoCEMouseClicked
        txtTelefonoCE.setCaretPosition(0);
    }//GEN-LAST:event_txtTelefonoCEMouseClicked

    private void txtFechaNacPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtFechaNacPropertyChange

    }//GEN-LAST:event_txtFechaNacPropertyChange

    private void jLabel53MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel53MouseClicked

    }//GEN-LAST:event_jLabel53MouseClicked

    private void btnAgregarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarFotoActionPerformed

        ImageAvatar ia = new ImageAvatar();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo de imagen", "png", "jpg");
        JFileChooser selector = new JFileChooser();
        selector.setFileFilter(filtro);
        int opcionav = selector.showOpenDialog(this);
        if (opcionav == JFileChooser.APPROVE_OPTION) {
            String foto_path = selector.getSelectedFile().getPath();
            //  this.ruta = selector.getSelectedFile().toString();

            // txtRutaFoto.setText(nombreArchivo);
            icono = new ImageIcon(foto_path);

            //     ImageIcon nuevoIcono = new ImageIcon(ia.toImage(icono));
            lbFoto.setIcon(new ImageIcon(ia.toImage(icono)));
            lbFoto.repaint();
            model.setFoto_paht(foto_path);
        }
    }//GEN-LAST:event_btnAgregarFotoActionPerformed

    private void btnQuitarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarFotoActionPerformed
        ImageAvatar ia = new ImageAvatar();

        if (rbHombre.isSelected()) {
            icono = new ImageIcon("src/com/icon/foto_hombre.jpg");
            //     ImageIcon nuevoIcono = new ImageIcon(ia.toImage(icono));
            lbFoto.setIcon(new ImageIcon(ia.toImage(icono)));
            lbFoto.repaint();
            model.setFoto_paht("src/com/icon/foto_hombre.jpg");
        } else if (rbMujer.isSelected()) {
            icono = new ImageIcon("src/com/icon/foto_mujer.png");
            //     ImageIcon nuevoIcono = new ImageIcon(ia.toImage(icono));
            lbFoto.setIcon(new ImageIcon(ia.toImage(icono)));
            lbFoto.repaint();
            model.setFoto_paht("src/com/icon/foto_mujer.png");
        }
    }//GEN-LAST:event_btnQuitarFotoActionPerformed

    private void txtLocalidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLocalidadKeyTyped
        //   Validaciones.soloRecibeTexto(evt);
    }//GEN-LAST:event_txtLocalidadKeyTyped

    private void txtColoniaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtColoniaKeyTyped
        Validaciones.soloRecibeTexto(evt);
    }//GEN-LAST:event_txtColoniaKeyTyped

    private void txtMunicipioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMunicipioKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMunicipioKeyTyped

    private void txtcpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcpKeyTyped
        Validaciones.revisarLongitud(evt, txtcp, 5);
    }//GEN-LAST:event_txtcpKeyTyped

    private void txtAbrevKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAbrevKeyTyped

        Validaciones.soloRecibeTextoConPunto(evt);
    }//GEN-LAST:event_txtAbrevKeyTyped

    private void txtTelefonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTelefonoMouseClicked
        txtTelefono.setCaretPosition(0);
    }//GEN-LAST:event_txtTelefonoMouseClicked

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked

    }//GEN-LAST:event_jPanel1MouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            UpdateDatosG();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.swing.ButtonBadges btnAgregarFoto;
    private javax.swing.JButton btnQuitarFoto;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbEstadoCivil;
    private javax.swing.JComboBox<String> cmbLenguaIndig;
    private javax.swing.JComboBox<String> cmbParentescoCE;
    private javax.swing.JComboBox<String> cmbTsangre;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbCorreoError;
    private javax.swing.JLabel lbCorreoInstError;
    private javax.swing.JLabel lbErrorCURP;
    private com.swing.ImageAvatar lbFoto;
    private javax.swing.JLabel lbRFCError;
    private com.swing.PanelRound panelRound2;
    public javax.swing.JPanel pdatosgenerales;
    private javax.swing.JRadioButton rbHombre;
    private javax.swing.JRadioButton rbMujer;
    private javax.swing.JRadioButton rbNO;
    private javax.swing.JRadioButton rbSI;
    private javax.swing.ButtonGroup rbpm;
    private com.swing.JCTextField txtAMaterno;
    private com.swing.JCTextField txtAPaterno;
    private com.swing.JCTextField txtAbrev;
    private com.swing.JCTextField txtCURP;
    private com.swing.JCTextField txtCalle;
    private com.swing.JCTextField txtColonia;
    private com.swing.JCTextField txtCorreoInst;
    private com.swing.JCTextField txtCorreoPers;
    private com.toedter.calendar.JDateChooser txtFechaNac;
    private com.swing.JCTextField txtIMSS;
    private com.swing.JCTextField txtLocalidad;
    private com.swing.JCTextField txtMunicipio;
    private com.swing.JCTextField txtNombre;
    private com.swing.JCTextField txtNombreContacto;
    public com.swing.JCTextField txtNumEmp;
    private com.swing.JCTextField txtRFC;
    private javax.swing.JFormattedTextField txtTelefono;
    private javax.swing.JFormattedTextField txtTelefonoCE;
    private com.swing.JCTextField txtcp;
    // End of variables declaration//GEN-END:variables
}
