package com.vista;

import com.DAO.PersonalNDAO;

import com.component.GestionEncabezadoTabla;
import com.component.RegistrarFamiliar;
import com.component.Tipo;
import com.classes.Validaciones;
import com.connection.Conexion;
import com.model.ModelPersonalN;
import com.notification.Notification;
import com.swing.ImageAvatar;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

public final class RegistrarPN extends javax.swing.JPanel {

    public String ruta, rutaFUMP;
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public ImageIcon icono;
    ModelPersonalN model = new ModelPersonalN();
    PersonalNDAO DAO = new PersonalNDAO();
    Conexion con = new Conexion();

    public RegistrarPN() {
        initComponents();
        init();
        ObteberJefe();
        ObteberPuestos();
        ObteberArea();
        bloquear();
        bloquear_laborales();
    }

    void limpiar() {
        txtNumEmp.setText("");
        txtAbrev.setText("");
        txtNombre.setText("");
        txtAPaterno.setText("");
        txtAMaterno.setText("");
        txtTelefono.setText("");
        txtCorreoPers.setText("");
        txtCorreoInst.setText("");
        txtCURP.setText("");
        txtRFC.setText("");
        txtIMSS.setText("");
        cmbEstadoCivil.setSelectedItem(0);
        cmbLenguaIndig.setSelectedItem(0);
        cmbTsangre.setSelectedItem(0);
        txtCalle.setText("");
        txtColonia.setText("");
        txtLocalidad.setText("");
        txtTelefonoCE.setText("");
        cmbParentescoCE.setSelectedItem(0);
        txtTelefonoCE.setText("");
        sexo.clearSelection();
    }

    void bloquear_laborales() {
        cmbPlantel.setEnabled(false);
        txtCodFinanzas.setEnabled(false);
        FechaIngreso.setEnabled(false);
        FechaTermContrato.setEnabled(false);
        cmbJefe.setEnabled(false);
        cmbPuesto.setEnabled(false);
        cmbArea.setEnabled(false);
        cmbCategoria.setEnabled(false);
        txtHoras.setEnabled(false);
        cmbPlaza.setEnabled(false);
        cmbSindicato.setEnabled(false);
        txtHorario.setEnabled(false);
        txtSueldo.setEnabled(false);
        btnFUMP.setEnabled(false);
        cbTermino.setEnabled(false);
    }

    void desbloquear_laborales() {
        cmbPlantel.setEnabled(true);
        txtCodFinanzas.setEnabled(true);
        FechaIngreso.setEnabled(false);

        cmbJefe.setEnabled(true);
        cmbPuesto.setEnabled(true);
        cmbArea.setEnabled(true);
        cmbCategoria.setEnabled(true);
        txtHoras.setEnabled(true);
        cmbPlaza.setEnabled(true);
        cmbSindicato.setEnabled(true);
        txtHorario.setEnabled(true);
        txtSueldo.setEnabled(true);
        if (this.getTipo().equals("Nómina")) {
            btnFUMP.setEnabled(true);
            cbTermino.setEnabled(true);
        } else if (this.getTipo().equals("Honorarios")) {
            btnFUMP.setEnabled(false);
            FechaTermContrato.setEnabled(true);
        }

    }

    void bloquear() {
        btnAnterior.setEnabled(false);
        btnSiguiente.setEnabled(false);
        txtNumEmp.setEnabled(false);
        txtAbrev.setEnabled(false);
        txtNombre.setEnabled(false);
        txtAPaterno.setEnabled(false);
        txtAMaterno.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtCorreoPers.setEnabled(false);
        txtCorreoInst.setEnabled(false);
        txtCURP.setEnabled(false);
        txtRFC.setEnabled(false);
        txtIMSS.setEnabled(false);
        cmbLenguaIndig.setEnabled(false);
        cmbTsangre.setEnabled(false);
        txtCalle.setEnabled(false);
        txtColonia.setEnabled(false);
        txtLocalidad.setEnabled(false);
        cmbEstadoCivil.setEnabled(false);
        txtNombreContacto.setEnabled(false);
        cmbParentescoCE.setEnabled(false);
        txtTelefonoCE.setEnabled(false);
        txtFechaNac.setEnabled(false);
        rbMujer.setEnabled(false);
        rbHombre.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnAgregarFoto.setEnabled(false);
        btnQuitarFoto.setEnabled(false);
        lbFoto.setEnabled(false);

    }

    void validar_camposvacios() {

        Validaciones.esCajaVacia(this.txtAbrev, "Campo de ** Abrev. Vacío");
        Validaciones.esCajaVacia(this.txtNombre, "Campo ** Nombre (s) ** está vacio");
        Validaciones.esCajaVacia(this.txtAPaterno, "Campo ** Apellido Paterno  ** está vacío");
        Validaciones.esCajaVacia(this.txtAMaterno, "Campo ** Apellido Materno ** está vacío");
        Validaciones.esCajaVacia(this.txtTelefono, "Número de Teléfono NO ASIGNADO");

        if (rbHombre.isSelected() != true && rbMujer.isSelected() != true) {
            JOptionPane.showMessageDialog(null, "Seleccionar campo ** SEXO");
        }

        Validaciones.cmbNoSeleccionado(cmbEstadoCivil, "Estado Civil NO SELECCIONADO");
        Validaciones.cmbNoSeleccionado(cmbTsangre, "Tipo de Sangre NO SELECCIONADO");

        if (txtCorreoPers.getText().isEmpty() && txtCorreoInst.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Correo NO ASIGNADO", "Aviso", JOptionPane.WARNING_MESSAGE);
        }

        SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
        String pasofecha = (formatofecha.format(txtFechaNac.getDate()));
        Calendar calendar = Calendar.getInstance();
        Date dateObj = calendar.getTime();
        String formattedDate = formatofecha.format(dateObj);
       if(txtFechaNac.getDate() !=null) {
          if (pasofecha == null ? formattedDate == null : pasofecha.equals(formattedDate)) {
           JOptionPane.showInternalMessageDialog(null, "La fecha de nacimiento es incorrecta", "Aviso!", JOptionPane.WARNING_MESSAGE);
        } 
       }else{
              JOptionPane.showInternalMessageDialog(null, "La fecha de nacimiento NO ESTÁ ASIGNADA", "Aviso!", JOptionPane.ERROR_MESSAGE);
          }
        
        int opcion1 = cmbParentescoCE.getSelectedIndex();

        if (txtNombreContacto == null && txtNombreContacto == null && opcion1 >= 0) {
            JOptionPane.showMessageDialog(null, "Parentesco seleccionado sin Asignar Nombre del Parentesto");

        }

        if (txtNombreContacto == null && txtTelefonoCE == null) {

            // JOptionPane.showMessageDialog(null, "Seleccionar Parentesto del Contacto de Emergencia");
            cmbParentescoCE.setSelectedIndex(-1);
        } else if (txtNombreContacto == null && txtNombreContacto == null && opcion1 == 0) {
            Validaciones.cmbNoSeleccionado(cmbParentescoCE, "Contacto de Emergencia sin asignar");
        }
        if (txtCalle.getText().isEmpty() && txtColonia.getText().isEmpty() && txtLocalidad.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Domicilio no asignado");
        }
        Validaciones.esCajaVacia(this.txtTelefono, "Campo ** Teléfono vacío");
        //    Validaciones.esCajaVacia(this.txtRFC, "Campo ** RFC vacío");     
        Validaciones.esCajaVacia(this.txtCURP, "Campo ** CURP vacío");
        Validaciones.cmbNoSeleccionado(cmbLenguaIndig, "Lengua Indigena No Seleccionado");
    }

    void desbloquear() {

        txtNumEmp.setEnabled(true);
        txtAbrev.setEnabled(true);
        txtNombre.setEnabled(true);
        txtAPaterno.setEnabled(true);
        txtAMaterno.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtCorreoPers.setEnabled(true);
        txtCorreoInst.setEnabled(true);
        txtCURP.setEnabled(true);
        txtRFC.setEnabled(true);
        txtIMSS.setEnabled(true);
        txtCURP.setEnabled(true);
        cmbEstadoCivil.setEnabled(true);
        cmbLenguaIndig.setEnabled(true);
        cmbTsangre.setEnabled(true);
        txtCalle.setEnabled(true);
        txtColonia.setEnabled(true);
        txtLocalidad.setEnabled(true);
        txtNombreContacto.setEnabled(true);
        cmbParentescoCE.setEnabled(true);
        txtTelefonoCE.setEnabled(true);
        btnAnterior.setEnabled(true);
        btnSiguiente.setEnabled(true);
        txtFechaNac.setEnabled(true);
        rbMujer.setEnabled(true);
        rbHombre.setEnabled(true);
        //   btnGuardar.setEnabled(true);
        btnAgregarFoto.setEnabled(true);
        btnQuitarFoto.setEnabled(true);
        lbFoto.setEnabled(true);
    }

    void init() {

        //JOptionPane.showConfirmDialog(null, new Tipoynum(), "Escoger que tipo  a registrar", JOptionPane.WARNING_MESSAGE);
        comboBox();
        jTabbedPane.setEnabledAt(0, true);
        jTabbedPane.setEnabledAt(1, false);
        jTabbedPane.setEnabledAt(2, false);
        jTabbedPane.setEnabledAt(3, false);
        jTabbedPane.setEnabledAt(4, false);
        jTabbedPane.setEnabledAt(5, false);
        jTabbedPane.setSelectedIndex(0);

    }

    void campos_laborales() {

        Validaciones.cmbNoSeleccionado(cmbPlantel, "Campo plantel no seleccionado");
        if (txtCodFinanzas.getText().isEmpty()) {
            lbCodFError.setText("Campo Vacío!");
        } else {
            lbCodFError.setText("");
        }
        Validaciones.cmbNoSeleccionado(cmbJefe, "Seleccione Jefe inmediato");
        Validaciones.cmbNoSeleccionado(cmbArea, "Seleccione el Área de adscripción");
        Validaciones.cmbNoSeleccionado(cmbCategoria, "Seleccionar Categoría");
        int opcion_c = cmbCategoria.getSelectedIndex();
        if (opcion_c == 4) {
            Validaciones.esCajaVacia(txtHoras, "Campo de Horas Laborales vacía");

        }
        Validaciones.cmbNoSeleccionado(cmbPlaza, "Seleccione la Plaza");
        Validaciones.cmbNoSeleccionado(cmbSindicato, "Seleccione el Sindicato");
        Validaciones.esCajaVacia(txtHorario, "Campo Horario de Trabajo Vacío");

    }

    public void ObteberJefe() {

        try {

            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT concat(abrev,' ',nombre,' ',ape_paterno,' ',ape_materno)nombreJefe FROM db_rh.tbl_jefeinmediato");
            ResultSet res = pstm.executeQuery();

            while (res.next()) {
                String tipoU = res.getString("nombreJefe");
                this.cmbJefe.addItem(tipoU);
            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void ObteberArea() {

        try {

            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT nombre FROM tbl_area");
            ResultSet res = pstm.executeQuery();

            while (res.next()) {
                String area = res.getString("nombre");
                this.cmbArea.addItem(area);
            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void ObteberPuestos() {

        try {

            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT nombre FROM db_rh.tbl_puesto");
            ResultSet res = pstm.executeQuery();

            while (res.next()) {
                String nombrep = res.getString("nombre");
                this.cmbPuesto.addItem(nombrep);
            }
            res.close();

        } catch (SQLException e) {
            System.out.println(e);
//        } finally {
//            try {
//                if (con != null) {
//                    con.cerrar();
//                }
//            } catch (SQLException ex) {
//
//                JOptionPane.showMessageDialog(null, "Error al intentar cerrar la conexión:\n"
//                        + ex, "Error en la operación", JOptionPane.ERROR_MESSAGE);
//            }
        }

    }

    private void GuardarDatosLaboralesN() {
        //  model.setNumEmpleado(txtNumEmp.getText());
        if (DAO.numEmpExiste(txtNumEmp.getText()) == 1) {
            String plantel = (String) cmbPlantel.getSelectedItem();
            model.setPlantel(plantel);

            model.setTipoContratacion(this.getTipo());
            model.setCodigo(txtCodFinanzas.getText());

            SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
            String pasofecha = (formatofecha.format(FechaIngreso.getDate()));

            model.setFechaIngreso(pasofecha);

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
            model.setId(DAO.idEmpleado());

            if (DAO.GuardarDatosLaboralesN(model)) {
// Notification panel = new Notification(new MainSystem(), Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Datos Generales registrados correctamente");
                JOptionPane.showMessageDialog(null, "Registro guardado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, ERROR);
            }

        } else {
            JOptionPane.showMessageDialog(null, "No existe un registro con este numero de emp.");
        }
    }

    private void GuardarDatosLaboralesH() {
        //  model.setNumEmpleado(txtNumEmp.getText());
        if (DAO.numEmpExiste(txtNumEmp.getText()) == 1) {
            String plantel = (String) cmbPlantel.getSelectedItem();
            model.setPlantel(plantel);

            model.setTipoContratacion(this.getTipo());
            model.setCodigo(txtCodFinanzas.getText());

            SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
            String pasofecha = (formatofecha.format(FechaIngreso.getDate()));

            model.setFechaIngreso(pasofecha);

            String pasofechaterm = (formatofecha.format(FechaTermContrato.getDate()));
            model.setFechaTerminoCont(pasofechaterm);

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
            model.setId(DAO.idEmpleado());

            if (DAO.GuardarDatosLaboralesH(model)) {
// Notification panel = new Notification(new MainSystem(), Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Datos Generales registrados correctamente");
                JOptionPane.showMessageDialog(null, "Registro guardado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, ERROR);
            }

        } else {
            JOptionPane.showMessageDialog(null, "No existe un registro con este numero de emp.");
        }
    }

    private void GuardarDatosG() throws FileNotFoundException {
        if (DAO.numEmpExiste(txtNumEmp.getText()) == 0) {
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

            String tipoSangre = (String) cmbTsangre.getSelectedItem();
            model.setTipoSangre(tipoSangre);

            model.setDirección(txtCalle.getText());
            model.setColonia(txtColonia.getText());
            model.setLocalidad(txtLocalidad.getText());
            model.setNombreCEmerg(txtTelefonoCE.getText());
            if (model.getFoto_paht() == null) {
                model.setFoto_paht("src/com/icon/foto_emp.png");
            } else {
                System.out.println("ruta asig " + model.getFoto_paht());
                model.setFoto_paht(model.getFoto_paht());
            }
            String ParentescoCE = (String) cmbParentescoCE.getSelectedItem();
            model.setParentestoCEmerg(ParentescoCE);
            model.setTelefonoCE(txtTelefonoCE.getText());

            if (DAO.GuardarPersonal(model)) {
                JOptionPane.showMessageDialog(null, "Regristrado correctamente");

            } else {
                JOptionPane.showMessageDialog(null, ERROR);
            }

        } else {
            JOptionPane.showMessageDialog(null, "El número de empleado ya está en uso");
        }
    }

    private void listFamiliares(JTable tablaD) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaD.setModel(modeloTabla);
        JTableHeader jtableHeader = tablaD.getTableHeader();
        jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
        tablaD.setTableHeader(jtableHeader);
        tablaD.setRowHeight(20);

        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Fecha Nacimiento");
        modeloTabla.addColumn("Parentesco");
        modeloTabla.addColumn("Edad");
        modeloTabla.addColumn("Sexo");
        modeloTabla.addColumn("Estado");

        TableColumnModel columnModel = tablaD.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(200);
        columnModel.getColumn(1).setPreferredWidth(200);
        columnModel.getColumn(2).setPreferredWidth(80);
        columnModel.getColumn(3).setPreferredWidth(60);
        columnModel.getColumn(4).setPreferredWidth(60);
        columnModel.getColumn(5).setPreferredWidth(80);

        int numReg = DAO.listDerechohabiente().size();
        //numReg de solo UNA TABLA faltan las demas
        Object[] columna = new Object[6];

        for (int i = 0; i < numReg; i++) {
            columna[0] = DAO.listDerechohabiente().get(i).getNombredh();
            columna[1] = DAO.listDerechohabiente().get(i).getFechaNacdh();
            columna[2] = DAO.listDerechohabiente().get(i).getParentesco();
            columna[3] = DAO.listDerechohabiente().get(i).getSexo();
            columna[4] = DAO.listDerechohabiente().get(i).getEdaddh();
            columna[5] = DAO.listDerechohabiente().get(i).getEstado();
            modeloTabla.addRow(columna);

//            int total = tablaD.getRowCount();
//            String totalLista = Integer.toString(total);
//          //  totalR.setText(totalLista);
        }
    }

    void comboBox() {
        String[] estado = {"Aguascalientes", "Baja California", "Baja California Sur", "Campeche", "Chiapas", "Chihuahua", "Coahuila de Zaragoza", "Colima", "Ciudad de México", "Durango", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco", "Estado de Mexico", "Michoacan de Ocampo", "Morelos", "Nayarit", "Nuevo Leon", "Oaxaca", "Puebla", "Queretaro de Arteaga", "Quintana Roo", "San Luis Potosi", "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz de Ignacio de la Llave", "Yucatan", "Zacatecas"};
        //   ArrayList<String> estados = new ArrayList<>(Arrays.asList("Aguascalientes","Baja California","Baja California Sur","Campeche","Chiapas","Chihuahua","Coahuila de Zaragoza","Colima","Ciudad de México","Durango","Guanajuato","Guerrero","Hidalgo","Jalisco","Estado de Mexico","Michoacan de Ocampo","Morelos","Nayarit","Nuevo Leon","Oaxaca","Puebla","Queretaro de Arteaga","Quintana Roo","San Luis Potosi","Sinaloa","Sonora","Tabasco","Tamaulipas","Tlaxcala","Veracruz de Ignacio de la Llave","Yucatan","Zacatecas"));
        cmbEstados.setModel(new javax.swing.DefaultComboBoxModel<>(estado));
    }

//    private void tipo_NH(){
//        System.out.println("tipo a mostrar"+  this.getTipo());
//        if(this.getTipo().equals("Nómina")){
//            this.panel1.setVisible(true);
//            this.panel2.setVisible(false);
//        }
//        else{
//             this.panel1.setVisible(false);
//            this.panel2.setVisible(true);
//        }
//        
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        sexo = new javax.swing.ButtonGroup();
        opcion = new javax.swing.ButtonGroup();
        lenguaIndigena = new javax.swing.ButtonGroup();
        gral = new javax.swing.JPanel();
        jTabbedPane = new javax.swing.JTabbedPane();
        TB_DatosGenerales = new javax.swing.JScrollPane();
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
        jSeparator1 = new javax.swing.JSeparator();
        txtAbrev = new com.swing.JCTextField();
        txtTelefono = new javax.swing.JFormattedTextField();
        lbRFCError = new javax.swing.JLabel();
        lbErrorCURP = new javax.swing.JLabel();
        lbCorreoInstError = new javax.swing.JLabel();
        lbCorreoError = new javax.swing.JLabel();
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
        tb_Farmacias = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableFamiliares = new javax.swing.JTable();
        btnListarFamiliares = new javax.swing.JButton();
        tp_Documentación = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel22 = new javax.swing.JLabel();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jLabel46 = new javax.swing.JLabel();
        jCTextField11 = new com.swing.JCTextField();
        jLabel45 = new javax.swing.JLabel();
        tp_Otros = new javax.swing.JPanel();
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
        buttonBadges2 = new com.swing.ButtonBadges();
        jLabel48 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        tp_FormaciónAcadémica = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cmbEstados = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton6 = new javax.swing.JButton();
        jCTextField1 = new com.swing.JCTextField();
        jCTextField2 = new com.swing.JCTextField();
        jCheckBox5 = new javax.swing.JCheckBox();
        jLabel55 = new javax.swing.JLabel();
        jCheckBox6 = new javax.swing.JCheckBox();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        jPanel2 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        btnGuardar = new com.swing.ButtonBadges();

        setPreferredSize(new java.awt.Dimension(1200, 709));
        setLayout(new java.awt.GridBagLayout());

        gral.setPreferredSize(new java.awt.Dimension(1218, 729));
        gral.setLayout(new javax.swing.BoxLayout(gral, javax.swing.BoxLayout.LINE_AXIS));

        jTabbedPane.setForeground(new java.awt.Color(0, 102, 204));
        jTabbedPane.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane.setFont(new java.awt.Font("Poppins Medium", 0, 16)); // NOI18N
        jTabbedPane.setPreferredSize(new java.awt.Dimension(1205, 910));

        TB_DatosGenerales.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        TB_DatosGenerales.setPreferredSize(new java.awt.Dimension(1000, 871));

        pdatosgenerales.setPreferredSize(new java.awt.Dimension(1205, 910));

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 808));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel58.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel58.setText("Abrebiatura");
        jPanel1.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 20, 87, -1));

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel2.setText("Nombre (s) *");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 70, 104, -1));

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtNombre.setPlaceholder("Nombre (s)");
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 57, -1, 30));

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel3.setText("Apellido Paterno");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 108, -1, -1));

        txtAPaterno.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtAPaterno.setPlaceholder("Apellido Paterno");
        txtAPaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAPaternoKeyTyped(evt);
            }
        });
        jPanel1.add(txtAPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 105, -1, 30));

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel5.setText("Apellido Materno");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 156, -1, -1));

        txtAMaterno.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtAMaterno.setPlaceholder("Apellido Materno");
        txtAMaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAMaternoKeyTyped(evt);
            }
        });
        jPanel1.add(txtAMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 153, -1, 30));

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel4.setText("Sexo");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 201, -1, -1));

        sexo.add(rbHombre);
        rbHombre.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        rbHombre.setText("Hombre");
        rbHombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbHombreActionPerformed(evt);
            }
        });
        jPanel1.add(rbHombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 202, -1, -1));

        sexo.add(rbMujer);
        rbMujer.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        rbMujer.setText("Mujer");
        rbMujer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMujerActionPerformed(evt);
            }
        });
        jPanel1.add(rbMujer, new org.netbeans.lib.awtextra.AbsoluteConstraints(341, 201, -1, -1));

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel6.setText("Fecha de Nacimiento");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 245, -1, -1));

        jLabel25.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel25.setText("Telefono Celular");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 343, 140, -1));

        jLabel32.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel32.setText("Correo Personal");
        jPanel1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 583, -1, -1));

        jLabel28.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel28.setText("Correo Institucional");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 643, -1, -1));

        jLabel30.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel30.setText("Lengua Indígena");
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 743, -1, -1));

        txtCorreoPers.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtCorreoPers.setPlaceholder("Correo Personal");
        txtCorreoPers.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorreoPersKeyTyped(evt);
            }
        });
        jPanel1.add(txtCorreoPers, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 583, -1, 30));

        txtCorreoInst.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtCorreoInst.setPlaceholder("Correo Institucional");
        txtCorreoInst.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorreoInstKeyTyped(evt);
            }
        });
        jPanel1.add(txtCorreoInst, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 633, -1, 30));

        jLabel24.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel24.setText("Tipo de Sangre");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 693, -1, -1));

        cmbTsangre.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        cmbTsangre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccionar --", "A+", "B+", "AB+", "O+", "A-", "B-", "AB-", "O-" }));
        jPanel1.add(cmbTsangre, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 688, 190, -1));

        jLabel43.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel43.setText("CURP");
        jPanel1.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 458, -1, 30));

        txtCURP.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtCURP.setPlaceholder("CURP");
        txtCURP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCURPKeyTyped(evt);
            }
        });
        jPanel1.add(txtCURP, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 458, -1, -1));

        jLabel44.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel44.setText("RFC");
        jPanel1.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 508, -1, 30));

        txtRFC.setToolTipText("Registro Federal de Contribuyentes (RFC)");
        txtRFC.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtRFC.setPlaceholder("RFC");
        txtRFC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRFCKeyTyped(evt);
            }
        });
        jPanel1.add(txtRFC, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 510, -1, -1));

        jLabel42.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel42.setText("IMSS");
        jPanel1.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 408, 40, 30));

        txtIMSS.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtIMSS.setPlaceholder("IMSS");
        txtIMSS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIMSSKeyTyped(evt);
            }
        });
        jPanel1.add(txtIMSS, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 408, -1, -1));

        cmbLenguaIndig.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        cmbLenguaIndig.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccionar--", "Náhuatl", "Maya", "Izeltal", "Mixteco", "Tsotsil", "Zapoteco", "Otomí", "Totonaco", "Tlapaneco", "Chol", "Mazateco", "Ninguno" }));
        jPanel1.add(cmbLenguaIndig, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 743, 190, -1));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contacto de Emergencia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel29.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel29.setText("Teléfono");

        jLabel26.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel26.setText("Nombre");

        jLabel40.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel40.setText("Parentesco");

        cmbParentescoCE.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        cmbParentescoCE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccionar --", "Esposa / Esposo", "Hijo / Hija", "Padre / Madre", "Hernano / Hermano", "Amigo / Amiga", "Otro parentesco" }));
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

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(37, 37, 37)
                        .addComponent(txtNombreContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40)
                            .addComponent(jLabel29))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbParentescoCE, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefonoCE, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(498, 388, -1, -1));

        txtFechaNac.setBackground(new java.awt.Color(244, 244, 244));
        txtFechaNac.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(244, 244, 244)));
        txtFechaNac.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        txtFechaNac.setMaxSelectableDate(new java.util.Date(253370790109000L));
        txtFechaNac.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtFechaNacPropertyChange(evt);
            }
        });
        jPanel1.add(txtFechaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 238, 199, 30));

        txtNumEmp.setForeground(new java.awt.Color(153, 0, 0));
        txtNumEmp.setActionCommand("<Not Set>");
        txtNumEmp.setFont(new java.awt.Font("Poppins", 1, 22)); // NOI18N
        txtNumEmp.setPlaceholder("No.");
        jPanel1.add(txtNumEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 14, 96, 42));

        jLabel53.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel53.setText("Número de Empleado /a");
        jLabel53.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel53MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(498, 27, -1, -1));

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
                .addContainerGap(54, Short.MAX_VALUE))
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

        jPanel1.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(507, 63, 260, 260));

        cmbEstadoCivil.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        cmbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccionar --", "Soltero /a", "Casado /a", "Viudo /a", "Divorciado /a", "Unión Libre" }));
        jPanel1.add(cmbEstadoCivil, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 279, 200, -1));

        jLabel27.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel27.setText("Estado Civil");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 290, 90, -1));

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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addComponent(jLabel39)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtColonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 601, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 388, 370, 10));

        txtAbrev.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtAbrev.setPlaceholder("Abrev.");
        txtAbrev.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAbrevKeyTyped(evt);
            }
        });
        jPanel1.add(txtAbrev, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, -1));

        try {
            txtTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-#######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefono.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 200, 30));

        lbRFCError.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbRFCError.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(lbRFCError, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 546, 200, -1));

        lbErrorCURP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbErrorCURP.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(lbErrorCURP, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 490, 200, 20));

        lbCorreoInstError.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbCorreoInstError.setForeground(new java.awt.Color(204, 0, 0));
        lbCorreoInstError.setAutoscrolls(true);
        jPanel1.add(lbCorreoInstError, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 660, 200, 20));

        lbCorreoError.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbCorreoError.setForeground(new java.awt.Color(204, 0, 0));
        lbCorreoError.setAutoscrolls(true);
        jPanel1.add(lbCorreoError, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 610, 200, 20));

        javax.swing.GroupLayout pdatosgeneralesLayout = new javax.swing.GroupLayout(pdatosgenerales);
        pdatosgenerales.setLayout(pdatosgeneralesLayout);
        pdatosgeneralesLayout.setHorizontalGroup(
            pdatosgeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pdatosgeneralesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 858, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(337, Short.MAX_VALUE))
        );
        pdatosgeneralesLayout.setVerticalGroup(
            pdatosgeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pdatosgeneralesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 827, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        TB_DatosGenerales.setViewportView(pdatosgenerales);

        jTabbedPane.addTab("Datos Generales", TB_DatosGenerales);

        tb_laboral.setLayout(new java.awt.CardLayout());

        tp_DatosLaborales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel70.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel70.setText("Código");
        tp_DatosLaborales.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));

        cmbPlaza.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccione--", "Base", "Sección", "Supernumerario", "Confianza", "Ninguno", "Otro" }));
        tp_DatosLaborales.add(cmbPlaza, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 400, 200, -1));

        jLabel71.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel71.setText("Fecha de ingreso");
        tp_DatosLaborales.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));

        FechaIngreso.setMaxSelectableDate(new java.util.Date(253370790097000L));
        FechaIngreso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FechaIngresoKeyReleased(evt);
            }
        });
        tp_DatosLaborales.add(FechaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 200, 29));

        jLabel72.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel72.setText("Puesto Laboral");
        tp_DatosLaborales.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, -1, -1));

        jLabel73.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel73.setText("Horas Laborales");
        tp_DatosLaborales.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, -1, -1));

        jLabel74.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel74.setText("Jefe Inmediato");
        tp_DatosLaborales.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, -1, -1));

        jLabel75.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel75.setText("Tipo de Plaza");
        tp_DatosLaborales.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, -1, -1));

        jLabel76.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel76.setText("Horario de Trabajo");
        tp_DatosLaborales.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 500, -1, -1));

        jLabel77.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel77.setText("Área de Adscripcion");
        tp_DatosLaborales.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, -1, -1));

        jLabel78.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel78.setText("Sindicato");
        tp_DatosLaborales.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, -1, -1));

        txtCodFinanzas.setNextFocusableComponent(FechaIngreso);
        txtCodFinanzas.setPlaceholder("Código de Finanzas");
        txtCodFinanzas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodFinanzasKeyTyped(evt);
            }
        });
        tp_DatosLaborales.add(txtCodFinanzas, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, -1, -1));

        txtHorario.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtHorario.setPlaceholder("Horario");
        tp_DatosLaborales.add(txtHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 500, -1, -1));

        jLabel79.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel79.setText("Sueldo");
        tp_DatosLaborales.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 550, -1, -1));

        cmbSindicato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "SUSPEG", "SITITSME", "Otro", "Ninguno" }));
        tp_DatosLaborales.add(cmbSindicato, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 450, 200, -1));

        txtHoras.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtHoras.setPlaceholder("Horas");
        txtHoras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHorasKeyTyped(evt);
            }
        });
        tp_DatosLaborales.add(txtHoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, 193, -1));

        jLabel80.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel80.setText("Categoria");
        tp_DatosLaborales.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, -1, -1));

        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccionar --", "Directivo", "Administrativo", "Servicios Generales", "Docente", "Honorarios" }));
        tp_DatosLaborales.add(cmbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, 193, -1));

        cmbJefe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccionar --" }));
        tp_DatosLaborales.add(cmbJefe, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, 193, -1));

        jLabel81.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel81.setText("Plantel");
        tp_DatosLaborales.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

        cmbPlantel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccionar --", "Tlapa", "Olinalá", "Iliatenco" }));
        cmbPlantel.setName(""); // NOI18N
        tp_DatosLaborales.add(cmbPlantel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 200, -1));

        cmbPuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccionar --" }));
        tp_DatosLaborales.add(cmbPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, 193, -1));

        cmbArea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Selecnionar ---" }));
        tp_DatosLaborales.add(cmbArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, 193, -1));

        txtSueldo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("¤#,##0.00"))));
        txtSueldo.setText("$");
        txtSueldo.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        tp_DatosLaborales.add(txtSueldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 550, 200, 33));

        btnFUMP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/export_pdf.png"))); // NOI18N
        btnFUMP.setText("Agregar FUMP");
        btnFUMP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFUMPActionPerformed(evt);
            }
        });
        tp_DatosLaborales.add(btnFUMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, 150, 40));

        jLabel82.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel82.setText("Terminación de Contrato");
        tp_DatosLaborales.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, -1, -1));

        FechaTermContrato.setMaxSelectableDate(new java.util.Date(253370790097000L));
        FechaTermContrato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FechaTermContratoKeyReleased(evt);
            }
        });
        tp_DatosLaborales.add(FechaTermContrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 140, 200, 29));

        cbTermino.setText("No Aplica");
        cbTermino.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTerminoItemStateChanged(evt);
            }
        });
        tp_DatosLaborales.add(cbTermino, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 150, -1, -1));

        lbCodFError.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbCodFError.setForeground(new java.awt.Color(204, 0, 0));
        tp_DatosLaborales.add(lbCodFError, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 64, 80, 20));
        tp_DatosLaborales.add(lbIconCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 220, 50, 40));

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tp_DatosLaborales, javax.swing.GroupLayout.DEFAULT_SIZE, 879, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(tp_DatosLaborales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tb_laboral.add(panel1, "card3");

        jTabbedPane.addTab("Datos Laborales", tb_laboral);

        tb_Farmacias.setPreferredSize(new java.awt.Dimension(500, 623));

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

        javax.swing.GroupLayout tb_FarmaciasLayout = new javax.swing.GroupLayout(tb_Farmacias);
        tb_Farmacias.setLayout(tb_FarmaciasLayout);
        tb_FarmaciasLayout.setHorizontalGroup(
            tb_FarmaciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tb_FarmaciasLayout.createSequentialGroup()
                .addGroup(tb_FarmaciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tb_FarmaciasLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox2))
                    .addGroup(tb_FarmaciasLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(tb_FarmaciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tb_FarmaciasLayout.createSequentialGroup()
                .addComponent(btnListarFamiliares)
                .addGap(33, 33, 33))
        );
        tb_FarmaciasLayout.setVerticalGroup(
            tb_FarmaciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tb_FarmaciasLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(tb_FarmaciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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

        jTabbedPane.addTab("Farmacias", tb_Farmacias);

        tp_Documentación.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel36.setText("<html> Enlace a : <a href=\\\"\\\">Google Drive</a></html>");
        jLabel36.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel36MouseClicked(evt);
            }
        });
        tp_Documentación.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 365, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Favor de Registrar el Vencimieto de los siguientes documentos");
        tp_Documentación.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 49, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("ISSSTE");
        tp_Documentación.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 166, -1, -1));
        tp_Documentación.add(jDateChooser3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 161, 36));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Credencial de Elector (INE)");
        tp_Documentación.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 109, -1, -1));
        tp_Documentación.add(jDateChooser4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 163, 32));

        jLabel46.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel46.setText("Enlace de ubicación de la documentación digitalizada:");
        tp_Documentación.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 262, -1, -1));

        jCTextField11.setPlaceholder("Link a Google Drive");
        tp_Documentación.add(jCTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 300, 347, -1));

        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/google_drive.png"))); // NOI18N
        tp_Documentación.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, -1, 31));

        jTabbedPane.addTab("Documentación", tp_Documentación);

        jLabel50.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel50.setText("¿Ha padecido COVID-19 ?");

        opcion.add(jRadioButton3);
        jRadioButton3.setText("Si");

        opcion.add(jRadioButton4);
        jRadioButton4.setText("No");

        jLabel51.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel51.setText("¿ Está vacunado /a ?");

        jLabel56.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel56.setText("Marca de la vacuna");

        jLabel57.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel57.setText("Comprobante de Vacunación");

        jButton7.setText("Agregar");

        jCTextField22.setPlaceholder("Ubicación");

        buttonBadges2.setBackground(new java.awt.Color(204, 204, 204));
        buttonBadges2.setText("Anterior");

        jLabel48.setText("¿ Padece de alguna enfermedad?");

        jLabel52.setText("Padecimiento que lo considere vulnerable");

        javax.swing.GroupLayout tp_OtrosLayout = new javax.swing.GroupLayout(tp_Otros);
        tp_Otros.setLayout(tp_OtrosLayout);
        tp_OtrosLayout.setHorizontalGroup(
            tp_OtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tp_OtrosLayout.createSequentialGroup()
                .addGroup(tp_OtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tp_OtrosLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(tp_OtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel57)
                            .addGroup(tp_OtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel50)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tp_OtrosLayout.createSequentialGroup()
                                    .addGroup(tp_OtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel51)
                                        .addComponent(jLabel56))
                                    .addGap(10, 10, 10)))
                            .addComponent(jLabel52))
                        .addGap(18, 18, 18)
                        .addGroup(tp_OtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tp_OtrosLayout.createSequentialGroup()
                                .addComponent(jButton7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(tp_OtrosLayout.createSequentialGroup()
                                .addComponent(jRadioButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton4))
                            .addComponent(jCheckBox3)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(tp_OtrosLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(buttonBadges2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tp_OtrosLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel48)))
                .addContainerGap())
        );
        tp_OtrosLayout.setVerticalGroup(
            tp_OtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tp_OtrosLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(tp_OtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(tp_OtrosLayout.createSequentialGroup()
                        .addGroup(tp_OtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel50)
                            .addComponent(jRadioButton3)
                            .addComponent(jRadioButton4))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel51))
                    .addComponent(jCheckBox3))
                .addGap(18, 18, 18)
                .addGroup(tp_OtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56))
                .addGap(39, 39, 39)
                .addGroup(tp_OtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(jButton7)
                    .addComponent(jCTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jLabel52)
                .addGap(18, 18, 18)
                .addComponent(buttonBadges2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(210, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Otros", tp_Otros);

        tp_FormaciónAcadémica.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Nivel de Estudios");
        tp_FormaciónAcadémica.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, -1));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Licenciatura", "Maestría", "Doctorado", "Diplomado", "Otro" }));
        tp_FormaciónAcadémica.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 200, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Nombre de la Institución ");
        tp_FormaciónAcadémica.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Carrera Profesional");
        tp_FormaciónAcadémica.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("¿Tiene Posgrado?");
        tp_FormaciónAcadémica.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 120, -1));

        cmbEstados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        tp_FormaciónAcadémica.add(cmbEstados, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 200, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Entidad Federativa");
        tp_FormaciónAcadémica.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Año de Egreso");
        tp_FormaciónAcadémica.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, -1, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("¿Cuenta conTitulo?");
        tp_FormaciónAcadémica.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, -1, 21));
        tp_FormaciónAcadémica.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, -1, -1));

        jButton6.setText("Buscar");
        tp_FormaciónAcadémica.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, -1, -1));

        jCTextField1.setPlaceholder("Nombre de la Institución");
        tp_FormaciónAcadémica.add(jCTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, -1, -1));

        jCTextField2.setPlaceholder("Carrera");
        tp_FormaciónAcadémica.add(jCTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, -1, -1));
        tp_FormaciónAcadémica.add(jCheckBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, -1, -1));

        jLabel55.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel55.setText("¿Tiene doctorado?");
        tp_FormaciónAcadémica.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, 120, -1));
        tp_FormaciónAcadémica.add(jCheckBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, -1, -1));

        jYearChooser1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        tp_FormaciónAcadémica.add(jYearChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 199, -1));

        jTabbedPane.addTab("Formacion Académica", tp_FormaciónAcadémica);

        gral.add(jTabbedPane);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnNuevo.setBackground(new java.awt.Color(0, 153, 51));
        btnNuevo.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevo.setFocusable(false);
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setLabel("     NUEVO     ");
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel2.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 23, -1, -1));

        btnAnterior.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        btnAnterior.setText(" <  Anterior");
        btnAnterior.setFocusable(false);
        btnAnterior.setHideActionText(true);
        btnAnterior.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });
        jPanel2.add(btnAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 120, -1));

        btnSiguiente.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        btnSiguiente.setText("Siguiente >");
        btnSiguiente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSiguiente.setIconTextGap(6);
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        jPanel2.add(btnSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 120, -1));

        btnGuardar.setBackground(new java.awt.Color(31, 44, 81));
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("    Guardar    ");
        btnGuardar.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 150, 120, -1));

        gral.add(jPanel2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 80;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        add(gral, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        int select = jTabbedPane.getSelectedIndex();

        switch (select) {

            case 1:

                jTabbedPane.setEnabledAt(0, true);
                jTabbedPane.setEnabledAt(1, false);
                jTabbedPane.setEnabledAt(2, false);
                jTabbedPane.setEnabledAt(3, false);
                jTabbedPane.setEnabledAt(4, false);
                jTabbedPane.setEnabledAt(5, false);
                jTabbedPane.setSelectedIndex(0);
                break;
            case 2:

                jTabbedPane.setEnabledAt(0, true);
                jTabbedPane.setEnabledAt(1, true);
                jTabbedPane.setEnabledAt(2, false);
                jTabbedPane.setEnabledAt(3, false);
                jTabbedPane.setEnabledAt(4, false);
                jTabbedPane.setEnabledAt(5, false);
                jTabbedPane.setSelectedIndex(1);
                break;
            case 3:

                jTabbedPane.setEnabledAt(0, true);
                jTabbedPane.setEnabledAt(1, true);
                jTabbedPane.setEnabledAt(2, true);
                jTabbedPane.setEnabledAt(3, false);
                jTabbedPane.setEnabledAt(4, false);
                jTabbedPane.setEnabledAt(5, false);
                jTabbedPane.setSelectedIndex(2);
                break;
            case 4:

                jTabbedPane.setEnabledAt(0, true);
                jTabbedPane.setEnabledAt(1, true);
                jTabbedPane.setEnabledAt(2, true);
                jTabbedPane.setEnabledAt(3, true);
                jTabbedPane.setEnabledAt(4, false);
                jTabbedPane.setEnabledAt(5, false);
                jTabbedPane.setSelectedIndex(3);
                break;
            case 5:

                jTabbedPane.setEnabledAt(0, true);
                jTabbedPane.setEnabledAt(1, true);
                jTabbedPane.setEnabledAt(2, true);
                jTabbedPane.setEnabledAt(3, true);
                jTabbedPane.setEnabledAt(4, true);
                jTabbedPane.setEnabledAt(5, false);
                jTabbedPane.setSelectedIndex(4);
                break;
            default:

                break;
        }


    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed

        int select = jTabbedPane.getSelectedIndex();

        switch (select) {
            case 0:

                jTabbedPane.setEnabledAt(0, true);
                jTabbedPane.setEnabledAt(1, true);
                jTabbedPane.setEnabledAt(2, false);
                jTabbedPane.setEnabledAt(3, false);
                jTabbedPane.setEnabledAt(4, false);
                jTabbedPane.setEnabledAt(5, false);
                validar_camposvacios();

                jTabbedPane.setSelectedIndex(1);
                desbloquear_laborales();
                break;
            case 1:

                jTabbedPane.setEnabledAt(0, true);
                jTabbedPane.setEnabledAt(1, true);
                jTabbedPane.setEnabledAt(2, true);
                jTabbedPane.setEnabledAt(3, false);
                jTabbedPane.setEnabledAt(4, false);
                jTabbedPane.setEnabledAt(5, false);
                campos_laborales();
                jTabbedPane.setSelectedIndex(2);

                break;
            case 2:

                jTabbedPane.setEnabledAt(0, true);
                jTabbedPane.setEnabledAt(1, true);
                jTabbedPane.setEnabledAt(2, true);
                jTabbedPane.setEnabledAt(3, true);
                jTabbedPane.setEnabledAt(4, false);
                jTabbedPane.setEnabledAt(5, false);
                jTabbedPane.setSelectedIndex(3);
                break;
            case 3:

                jTabbedPane.setEnabledAt(0, true);
                jTabbedPane.setEnabledAt(1, true);
                jTabbedPane.setEnabledAt(2, true);
                jTabbedPane.setEnabledAt(3, true);
                jTabbedPane.setEnabledAt(4, true);
                jTabbedPane.setEnabledAt(5, false);
                jTabbedPane.setSelectedIndex(4);
                break;
            case 4:

                jTabbedPane.setEnabledAt(0, true);
                jTabbedPane.setEnabledAt(1, true);
                jTabbedPane.setEnabledAt(2, true);
                jTabbedPane.setEnabledAt(3, true);
                jTabbedPane.setEnabledAt(4, true);
                jTabbedPane.setEnabledAt(5, true);
                jTabbedPane.setSelectedIndex(5);
                btnGuardar.setEnabled(true);
                break;

            default:

                break;
        }

    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //  txtFechaNac.setCalendar(Calendar.getInstance());
        validar_camposvacios();
        if (txtFechaNac.getDate() != null) {

            try {
                GuardarDatosG();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(RegistrarPN.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Campo ** Fecha de Nacimiento ** vacío", "Error", JOptionPane.ERROR_MESSAGE);
        }
        campos_laborales();
        if (FechaIngreso.getDate() != null || FechaTermContrato.getDate() != null) {
            if (this.getTipo().equals("Nómina")) {
                GuardarDatosLaboralesN();
            } else if (this.getTipo().equals("Honorarios")) {
                GuardarDatosLaboralesH();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Campo ** Fecha de ingreso vacío ", "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiar();
        desbloquear();
        Tipo dialog = new Tipo(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
        txtNumEmp.setText("" + dialog.getNum());
        this.setTipo(dialog.getTipoContratacion());
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void jLabel36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel36MouseClicked
        try {
            Desktop.getDesktop().browse(new URI("https://drive.google.com/drive/folders/1DvKbFO-0kpRrpbHoYCOT_zMYmRvpck3T?usp=sharing"));
        } catch (URISyntaxException | IOException ex) {

        }
    }//GEN-LAST:event_jLabel36MouseClicked

    private void btnListarFamiliaresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarFamiliaresActionPerformed
        listFamiliares(tableFamiliares);
    }//GEN-LAST:event_btnListarFamiliaresActionPerformed

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

    private void btnFUMPActionPerformed(java.awt.event.ActionEvent evt) {
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

    }
    private void txtHorasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHorasKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHorasKeyTyped

    private void txtCodFinanzasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodFinanzasKeyTyped
        Validaciones.soloRecibeTextoyNumero(evt);
        Validaciones.revisarLongitud(evt, txtCodFinanzas, 7);
    }//GEN-LAST:event_txtCodFinanzasKeyTyped

    private void FechaIngresoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FechaIngresoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_FechaIngresoKeyReleased

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked

    }//GEN-LAST:event_jPanel1MouseClicked

    private void txtAbrevKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAbrevKeyTyped

        Validaciones.soloRecibeTextoConPunto(evt);

    }//GEN-LAST:event_txtAbrevKeyTyped

    private void txtColoniaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtColoniaKeyTyped
        Validaciones.soloRecibeTexto(evt);
    }//GEN-LAST:event_txtColoniaKeyTyped

    private void txtLocalidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLocalidadKeyTyped
        Validaciones.soloRecibeTexto(evt);
    }//GEN-LAST:event_txtLocalidadKeyTyped

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

    private void jLabel53MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel53MouseClicked

    }//GEN-LAST:event_jLabel53MouseClicked

    private void txtFechaNacPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtFechaNacPropertyChange

    }//GEN-LAST:event_txtFechaNacPropertyChange

    private void txtNombreContactoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreContactoKeyTyped
        Validaciones.soloRecibeTexto(evt);
    }//GEN-LAST:event_txtNombreContactoKeyTyped

    private void cmbParentescoCEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbParentescoCEActionPerformed

    }//GEN-LAST:event_cmbParentescoCEActionPerformed

    private void txtIMSSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIMSSKeyTyped
        Validaciones.esNumeroEntero(evt);
        Validaciones.revisarLongitud(evt, txtIMSS, 11);
    }//GEN-LAST:event_txtIMSSKeyTyped

    private void txtRFCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRFCKeyTyped
        Matcher mat, mat2;
        Pattern pat2 = Pattern.compile("^(([A-ZÑ&]{4})([0-9]{2})([0][13578]|[1][02])(([0][1-9]|[12][\\d])|[3][01])([A-Z0-9]{3}))|(([A-ZÑ&]{4})([0-9]{2})([0][13456789]|[1][012])(([0][1-9]|[12][\\d])|[3][0])([A-Z0-9]{3}))|(([A-ZÑ&]{4})([02468][048]|[13579][26])[0][2]([0][1-9]|[12][\\d])([A-Z0-9]{3}))|(([A-ZÑ&]{4})([0-9]{2})[0][2]([0][1-9]|[1][0-9]|[2][0-8])([A-Z0-9]{3}))$");
        mat2 = pat2.matcher(txtRFC.getText());
        Pattern pat = Pattern.compile("^(([A-ZÑ&]{3})([0-9]{2})([0][13578]|[1][02])(([0][1-9]|[12][\\d])|[3][01])([A-Z0-9]{3}))|(([A-ZÑ&]{3})([0-9]{2})([0][13456789]|[1][012])(([0][1-9]|[12][\\d])|[3][0])([A-Z0-9]{3}))|(([A-ZÑ&]{3})([02468][048]|[13579][26])[0][2]([0][1-9]|[12][\\d])([A-Z0-9]{3}))|(([A-ZÑ&]{3})([0-9]{2})[0][2]([0][1-9]|[1][0-9]|[2][0-8])([A-Z0-9]{3}))$");
        mat = pat.matcher(txtRFC.getText());
        if (mat.matches() == false && mat2.matches() == false) {
            Validaciones.revisarLongitud(evt, txtRFC, 13);
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

    private void txtCURPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCURPKeyTyped
        Matcher mat;
        Pattern pat = Pattern.compile("^(([A-Z][AEIOUX][A-Z]{2}\\d{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[12]\\d|3[01])[HM](?:AS|B[CS]|C[CLMSH]|D[FG]|G[TR]|HG|JC|M[CNS]|N[ETL]|OC|PL|Q[TR]|S[PLR]|T[CSL]|VZ|YN|ZS)[B-DF-HJ-NP-TV-Z]{3}[A-Z\\d])(\\d))$");
        mat = pat.matcher(txtCURP.getText());
        if (mat.matches() == false) {
            Validaciones.revisarLongitud(evt, txtCURP, 18);
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

    private void txtCorreoInstKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoInstKeyTyped
        Matcher mat;
        Pattern pat = Pattern.compile("^[a-zA-Z0-9_!#$%&'\\*+/=?{|}~^.-]+@itsm-tlapa.edu.mx$");

        mat = pat.matcher(txtCorreoInst.getText());
        if (mat.matches() == false) {
            Validaciones.revisarLongitud(evt, txtCorreoInst, 100);
            lbCorreoInstError.setText("Correo incorrecto!");

        } else {
            lbCorreoInstError.setText("");
        }
    }//GEN-LAST:event_txtCorreoInstKeyTyped

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

    private void txtAMaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAMaternoKeyTyped
        Validaciones.soloRecibeTexto(evt);
    }//GEN-LAST:event_txtAMaternoKeyTyped

    private void txtAPaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAPaternoKeyTyped
        Validaciones.soloRecibeTexto(evt);
    }//GEN-LAST:event_txtAPaternoKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        Validaciones.soloRecibeTexto(evt);
    }//GEN-LAST:event_txtNombreKeyTyped

    private void FechaTermContratoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FechaTermContratoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_FechaTermContratoKeyReleased

    private void cbTerminoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTerminoItemStateChanged
        if (cbTermino.isSelected()) {
            FechaTermContrato.setEnabled(false);

        } else {
            FechaTermContrato.setEnabled(true);
        }
    }//GEN-LAST:event_cbTerminoItemStateChanged

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

    private void rbHombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbHombreActionPerformed
        lbFoto.setIcon(new ImageIcon("src/com/icon/foto_hombre.jpg"));
        lbFoto.repaint();
    }//GEN-LAST:event_rbHombreActionPerformed

    private void rbMujerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMujerActionPerformed
        lbFoto.setIcon(new ImageIcon("src/com/icon/foto_mujer.png"));
        lbFoto.repaint();
    }//GEN-LAST:event_rbMujerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser FechaIngreso;
    private com.toedter.calendar.JDateChooser FechaTermContrato;
    private javax.swing.JScrollPane TB_DatosGenerales;
    private com.swing.ButtonBadges btnAgregarFoto;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnFUMP;
    private com.swing.ButtonBadges btnGuardar;
    private javax.swing.JButton btnListarFamiliares;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnQuitarFoto;
    private javax.swing.JButton btnSiguiente;
    private com.swing.ButtonBadges buttonBadges2;
    private javax.swing.JCheckBox cbTermino;
    private javax.swing.JComboBox<String> cmbArea;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbEstadoCivil;
    private javax.swing.JComboBox<String> cmbEstados;
    private javax.swing.JComboBox<String> cmbJefe;
    private javax.swing.JComboBox<String> cmbLenguaIndig;
    private javax.swing.JComboBox<String> cmbParentescoCE;
    private javax.swing.JComboBox<String> cmbPlantel;
    private javax.swing.JComboBox<String> cmbPlaza;
    private javax.swing.JComboBox<String> cmbPuesto;
    private javax.swing.JComboBox<String> cmbSindicato;
    private javax.swing.JComboBox<String> cmbTsangre;
    private javax.swing.JPanel gral;
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
    private javax.swing.JComboBox<String> jComboBox3;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
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
    private javax.swing.JLabel jLabel36;
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
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel6;
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTextField jTextField1;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private javax.swing.JLabel lbCodFError;
    private javax.swing.JLabel lbCorreoError;
    private javax.swing.JLabel lbCorreoInstError;
    private javax.swing.JLabel lbErrorCURP;
    private com.swing.ImageAvatar lbFoto;
    private javax.swing.JLabel lbIconCheck;
    private javax.swing.JLabel lbRFCError;
    private javax.swing.ButtonGroup lenguaIndigena;
    private javax.swing.ButtonGroup opcion;
    private javax.swing.JPanel panel1;
    private com.swing.PanelRound panelRound2;
    public javax.swing.JPanel pdatosgenerales;
    private javax.swing.JRadioButton rbHombre;
    private javax.swing.JRadioButton rbMujer;
    private javax.swing.ButtonGroup sexo;
    private javax.swing.JTable tableFamiliares;
    private javax.swing.JPanel tb_Farmacias;
    private javax.swing.JPanel tb_laboral;
    private javax.swing.JPanel tp_DatosLaborales;
    private javax.swing.JPanel tp_Documentación;
    private javax.swing.JPanel tp_FormaciónAcadémica;
    private javax.swing.JPanel tp_Otros;
    private com.swing.JCTextField txtAMaterno;
    private com.swing.JCTextField txtAPaterno;
    private com.swing.JCTextField txtAbrev;
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
    private com.swing.JCTextField txtRFC;
    private javax.swing.JFormattedTextField txtSueldo;
    private javax.swing.JFormattedTextField txtTelefono;
    private javax.swing.JFormattedTextField txtTelefonoCE;
    // End of variables declaration//GEN-END:variables
}
