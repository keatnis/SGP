package com.vista;

import com.DAO.BajaPersonalDAO;
import com.DAO.DocumentacionDAO;
import com.DAO.FormacionAcademicaDAO;
import com.DAO.PersonalNDAO;
import com.classes.Autocomplete;
import com.component.Tipo;
import com.classes.Validaciones;
import com.DAO.ConsultasJAP;
import com.model.ModelDocumentacion;
import com.model.ModelFormacionAcademica;
import com.model.ModelPersonalN;
import com.notification.Notification;
import com.swing.ImageAvatar;
import java.awt.Desktop;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public final class RegistrarPN extends javax.swing.JPanel {

    public String ruta, rutaFUMP;
    private String tipo;
    int id;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public ImageIcon icono;
    ModelPersonalN model = new ModelPersonalN();
    PersonalNDAO DAO = new PersonalNDAO();
    BajaPersonalDAO daoBaja = new BajaPersonalDAO();

    ModelFormacionAcademica modelfa = new ModelFormacionAcademica();
    FormacionAcademicaDAO daofa = new FormacionAcademicaDAO();
    ModelDocumentacion modeldoc = new ModelDocumentacion();
    DocumentacionDAO daodoc = new DocumentacionDAO();

    public RegistrarPN() {
        initComponents();
        init();
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
        cmbEstadoCivil.setSelectedIndex(-1);
        cmbLenguaIndig.setSelectedIndex(0);
        cmbTsangre.setSelectedIndex(0);
        txtCalle.setText("");
        txtColonia.setText("");
        txtLocalidad.setText("");
        txtTelefonoCE.setText("");
        cmbParentescoCE.setSelectedIndex(0);
        txtTelefonoCE.setText("");
        sexo.clearSelection();
        txtMunicipio.setText("");
        padre_madre.clearSelection();
        txtcp.setText("");
        txtFechaNac.setDate(null);
        //  cmbEstadoCivil.setSelectedIndex(0);
        padre_madre.clearSelection();
    }

    void bloquear_laborales() {
        cmbPlantel.setEnabled(false);
        txtCodFinanzas.setEnabled(false);
        FechaIngreso.setEnabled(false);
        FechaInicioContrato.setEnabled(false);
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

    }

    void limpiar_laborales() {
        cmbPlantel.setSelectedIndex(0);;
        txtCodFinanzas.setText("");

        FechaIngreso.setEnabled(false);
        FechaInicioContrato.setEnabled(false);
        model.setFormatoFUMP(null);
        cmbArea.setSelectedIndex(0);
        cmbPuesto.setSelectedIndex(0);
        cmbArea.setSelectedIndex(0);
        cmbCategoria.setSelectedIndex(0);
        txtHoras.setText("");
        cmbPlaza.setSelectedIndex(0);
        cmbSindicato.setSelectedIndex(0);
        txtHorario.setText("");
        txtSueldo.setText("");
        FechaIngreso.setDate(null);
        FechaInicioContrato.setDate(null);

    }

    void desbloquear_laborales() {
        cmbPlantel.setEnabled(true);
        txtCodFinanzas.setEnabled(true);
        FechaIngreso.setEnabled(true);
        FechaInicioContrato.setEnabled(true);
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

        } else if (this.getTipo().equals("Honorarios")) {
            btnFUMP.setEnabled(false);
            FechaInicioContrato.setEnabled(true);
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

        btnSave.setEnabled(false);
        btnAgregarFoto.setEnabled(false);
        btnQuitarFoto.setEnabled(false);
        lbFoto.setEnabled(false);
        rbSI.setEnabled(false);
        rbNO.setEnabled(false);
        txtMunicipio.setEditable(false);
        txtcp.setEnabled(false);

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
        if (rbSI.isSelected() != true && rbNO.isSelected() != true) {
            JOptionPane.showMessageDialog(null, "Seleccionar si es o no Padre/Madre");
        }

        if (txtCorreoPers.getText().isEmpty() && txtCorreoInst.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Correo NO ASIGNADO", "Aviso", JOptionPane.WARNING_MESSAGE);
        }

        SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
        String pasofecha = (formatofecha.format(txtFechaNac.getDate()));
        Calendar calendar = Calendar.getInstance();
        Date dateObj = calendar.getTime();
        String formattedDate = formatofecha.format(dateObj);
        if (txtFechaNac.getDate() != null) {
            if (pasofecha == null ? formattedDate == null : pasofecha.equals(formattedDate)) {
                JOptionPane.showInternalMessageDialog(null, "La fecha de nacimiento es incorrecta", "Aviso!", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showInternalMessageDialog(null, "La fecha de nacimiento NO ESTÁ ASIGNADA", "Aviso!", JOptionPane.ERROR_MESSAGE);
        }

        int opcion1 = cmbParentescoCE.getSelectedIndex();

        if (txtNombreContacto.getText().isEmpty() && opcion1 >= 0) {
            JOptionPane.showMessageDialog(null, "Parentesco seleccionado sin Asignar Nombre del Parentesto");

        }

        if (txtNombreContacto == null && txtTelefonoCE.equals("-") && opcion1 == 0) {
            cmbParentescoCE.setSelectedIndex(-1);
            model.setNombreCEmerg("");
            model.setTelefonoCE("");
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
        rbSI.setEnabled(true);
        rbNO.setEnabled(true);
        txtMunicipio.setEditable(true);
        txtcp.setEnabled(true);
    }

    void limpiar_FA() {
        cmbNivelEstudios.setSelectedIndex(0);
        txtCarrera.setText("");
        txtInstitucion.setText("");
        cmbEstados.setSelectedIndex(0);
        txtAñoEgreso.setText("");
        cbTitulo.setSelected(false);
        cbPosgrado.setSelected(false);
        cbMaestria.setSelected(false);
        cbDoctorado.setSelected(false);
        fechaINE.setDate(null);
        fechaISSSTE.setDate(null);
        modeldoc.setLinkDrive(null);

        txtnombre.setText("");
        txtFechaNacDH.setDate(null);
        cmbParentescoDH.setSelectedIndex(0);
        sexodh.clearSelection();
    }

    void init() {

        //JOptionPane.showConfirmDialog(null, new Tipoynum(), "Escoger que tipo  a registrar", JOptionPane.WARNING_MESSAGE);
        comboBox();
        jTabbedPane.setEnabledAt(0, true);
        jTabbedPane.setEnabledAt(1, true);
        jTabbedPane.setEnabledAt(2, false);
        jTabbedPane.setEnabledAt(3, false);
        jTabbedPane.setEnabledAt(4, false);
        id = daoBaja.idEmpleado(txtNumEmp.getText());
        jTabbedPane.setSelectedIndex(0);
        acompletar();
    }

    void campos_laborales() {
        if (cmbJefe.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "No ha seleccionado el jefe inmediato, en caso de encontrarlo favor de registrarlo en menú 'Ajustes > Agregar Jefe'");
        }
        Validaciones.cmbNoSeleccionado(cmbPlantel, "Campo plantel no seleccionado");
        if (txtCodFinanzas.getText().isEmpty()) {
            lbCodFError.setText("Campo Vacío!");
        } else {
            lbCodFError.setText("");
        }
        // Validaciones.cmbNoSeleccionado(cmbJefe, "Seleccione Jefe inmediato");
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

    private void acompletar() {
        List palabras = new ArrayList<String>();
        palabras.add("itsm-tlapa.edu.mx");
        txtCorreoInst.setFocusTraversalKeysEnabled(false);

        Autocomplete autoComplete = new Autocomplete(txtCorreoInst, palabras);
        txtCorreoInst.getDocument().addDocumentListener(autoComplete);

// Maps the tab key to the commit action, which finishes the autocomplete
// when given a suggestion
        txtCorreoInst.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "commit");
        txtCorreoInst.getActionMap().put("commit", autoComplete.new CommitAction());
    }

    private int GuardarDatosLaboralesN() {
        //  model.setNumEmpleado(txtNumEmp.getText());
        if (DAO.numEmpExiste(txtNumEmp.getText()) == 1) {
            String plantel = (String) cmbPlantel.getSelectedItem();
            model.setPlantel(plantel);

            model.setTipoContratacion(this.getTipo());
            model.setCodigo(txtCodFinanzas.getText());

            SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
            String pasofecha = (formatofecha.format(FechaIngreso.getDate()));

            model.setFechaIngreso(pasofecha);

            if (FechaInicioContrato.getDate() != null) {

                String pasofecha2 = (formatofecha.format(FechaInicioContrato.getDate()));

                model.setFechaInicioCont(pasofecha2);
            } else {
                model.setFechaInicioCont("N/A");
            }
            if (FechaTermContrato.getDate() != null) {

                String pasofecha2 = (formatofecha.format(FechaTermContrato.getDate()));

                model.setFechaTerminoCont(pasofecha2);
            } else {
                model.setFechaTerminoCont("N/A");
            }
            String cadena = (String) cmbJefe.getSelectedItem();

//Compilamos el regex y el matcher al texto, ignorando mayúsculas/minúsculas (esto es estándar)
            Pattern pattern = Pattern.compile("([0-9]+)", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(cadena);
            String ultima = cadena.substring(cadena.lastIndexOf("-") + 1);

            // lbJefe.setText(ultima);
//Ahora sí, vemos si coincide el patrón con el texto
            if (matcher.find()) {
                //Coincidió => obtener el valor del grupo 1

                String idjefe = matcher.group(1);
                model.setJefeInmediato(idjefe);

            } else {
                JOptionPane.showMessageDialog(null, "No se estrado correctamente el nombre/id del jefe");
            }

            String puesto = (String) cmbPuesto.getSelectedItem();
            Matcher matcher2 = pattern.matcher(puesto);
            if (matcher2.find()) {
                //Coincidió => obtener el valor del grupo 1

                String idpuesto = matcher2.group(1);
                System.out.println("puesto " + puesto);
                model.setId_puesto(idpuesto);

            }
            String puestos = puesto.substring(puesto.lastIndexOf("-") + 1);
            model.setPuesto(puestos);

            String area = (String) cmbArea.getSelectedItem();
            Matcher matcher3 = pattern.matcher(area);
            if (matcher3.find()) {
                //Coincidió => obtener el valor del grupo 1

                String idpuesto = matcher3.group(1);
                model.setId_area(idpuesto);

            } else {
                JOptionPane.showMessageDialog(null, "No se estrado correctamente el nombre/id del jefe");
            }
            String areas = area.substring(area.lastIndexOf("-") + 1);
            // model.setPuesto(areas);

            model.setAreaAdscripción(areas);
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
                //   JOptionPane.showMessageDialog(null, "Registro guardado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, ERROR);
            }

        } else {
            JOptionPane.showMessageDialog(null, "No existe un registro con este numero de emp.");
        }
        return 1;
    }

    private int GuardarDatosG() throws FileNotFoundException {
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
            model.setNombreCEmerg(txtNombreContacto.getText());
            if (rbSI.isSelected()) {
                model.setPadreomadre("1");
            } else if (rbNO.isSelected()) {
                model.setPadreomadre("0");
            }

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

            model.setMunicipio(txtMunicipio.getText());
            model.setCodPostal(txtcp.getText());

            if (DAO.GuardarPersonal(model)) {
                //  JOptionPane.showMessageDialog(null, "Regristrado correctamente");

            } else {
                JOptionPane.showMessageDialog(null, ERROR);
            }

        } else {
            JOptionPane.showMessageDialog(null, "El número de empleado ya está en uso");
        }
        return 1;
    }

    void comboBox() {
        ConsultasJAP jap = new ConsultasJAP();
        jap.ObteberArea(cmbArea);
        jap.ObteberJefe(cmbJefe);
        jap.ObteberPuestos(cmbPuesto);
        String[] estadoq = {" ", "Aguascalientes", "Baja California", "Baja California Sur", "Campeche", "Chiapas", "Chihuahua", "Coahuila de Zaragoza", "Colima", "Ciudad de México", "Durango", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco", "Estado de Mexico", "Michoacan de Ocampo", "Morelos", "Nayarit", "Nuevo Leon", "Oaxaca", "Puebla", "Queretaro de Arteaga", "Quintana Roo", "San Luis Potosi", "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz de Ignacio de la Llave", "Yucatan", "Zacatecas"};
        //   ArrayList<String> estados = new ArrayList<>(Arrays.asList("Aguascalientes","Baja California","Baja California Sur","Campeche","Chiapas","Chihuahua","Coahuila de Zaragoza","Colima","Ciudad de México","Durango","Guanajuato","Guerrero","Hidalgo","Jalisco","Estado de Mexico","Michoacan de Ocampo","Morelos","Nayarit","Nuevo Leon","Oaxaca","Puebla","Queretaro de Arteaga","Quintana Roo","San Luis Potosi","Sinaloa","Sonora","Tabasco","Tamaulipas","Tlaxcala","Veracruz de Ignacio de la Llave","Yucatan","Zacatecas"));
        cmbEstados.setModel(new javax.swing.DefaultComboBoxModel<>(estadoq));

    }

    private void validar_fa() {
        Validaciones.cmbNoSeleccionado(cmbNivelEstudios, "Seleccionar el Nivel de Estudios");
        if (txtCarrera.getText().isEmpty()) {
            //  Validaciones.esCajaVacia(txtCarrera,"");
        }
        int index = cmbNivelEstudios.getSelectedIndex();
        if (index >= 2 && txtInstitucion.getText().isEmpty()) {
            Validaciones.esCajaVacia(txtInstitucion, "Nombre de la institucion no establecida");
        }
        Validaciones.cmbNoSeleccionado(cmbEstados, "Estado no seleccionado");
        if (index > 1 && txtAñoEgreso.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Año de egreso no establecido");
        }

    }

    private int registrar_formacionAcademica() {

        if (DAO.numEmpExiste(txtNumEmp.getText()) == 1) {

            int id = daoBaja.idEmpleado(txtNumEmp.getText());
            modelfa.setId(id);
            String nivel = (String) cmbNivelEstudios.getSelectedItem();
            modelfa.setNivelEstudios(nivel);
            modelfa.setCarreraProfesional(txtCarrera.getText());
            modelfa.setNombreInst(txtInstitucion.getText());
            String estado = (String) cmbEstados.getSelectedItem();
            modelfa.setEntidadFed(estado);
            modelfa.setAnioEgreso(txtAñoEgreso.getText());

            if (cbTitulo.isSelected()) {
                modelfa.setConTitulo("1");
            } else {
                modelfa.setConTitulo("0");
            }

            if (cbPosgrado.isSelected()) {
                modelfa.setConPosgrado("1");
            } else {
                modelfa.setConPosgrado("0");
            }
            if (cbMaestria.isSelected()) {
                modelfa.setConMaestria("1");
            } else {
                modelfa.setConMaestria("0");
            }
            if (cbDoctorado.isSelected()) {
                modelfa.setConDoctorado("1");
            } else {
                modelfa.setConDoctorado("0");
            }

            daofa.registrar(modelfa);

        } else {
            JOptionPane.showMessageDialog(null, "Nose puede registrar ID no registrado");
        }
        return 1;
    }

    private int registrar_derechohabiente() {
        if (DAO.numEmpExiste(txtNumEmp.getText()) == 1) {

            model.setId(DAO.idEmpleado());
            model.setNombredh(txtnombre.getText());
            if (txtFechaNacDH.getDate() == null) {
                model.setFechaNacdh("");
            } else {
                SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
                String pasofecha = (formatofecha.format(txtFechaNacDH.getDate()));
                model.setFechaNacdh(pasofecha);
            }

            String parent = (String) cmbParentescoDH.getSelectedItem();
            model.setParentesco(parent);
            String sexodh = null;
            if (rbMujer1.isSelected()) {
                sexodh = "M";
            }
            if (rbHombre1.isSelected()) {
                sexodh = "H";
            }
            model.setSexo(sexodh);
            model.setEstado("1");

            if (DAO.GuardarDerechohabiente(model)) {
                JOptionPane.showMessageDialog(null, "Derechohabiente regristrado correctamente");

            } else {
                JOptionPane.showMessageDialog(null, ERROR);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Antes de registrar un derechohabiente debe ** GUARDAR ** los datos primero");
        }
        return 1;
    }

    private void registrar_documentacion() {

        int ide = daoBaja.idEmpleado(txtNumEmp.getText());
        if (DAO.numEmpExiste(txtNumEmp.getText()) <= 2) {
            modeldoc.setId(ide);
            if (fechaINE.getDate() != null) {
                SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
                String pasofecha = (formatofecha.format(fechaINE.getDate()));
                modeldoc.setNombre("INE");
                modeldoc.setFechaVencimiento(pasofecha);

                daodoc.GuardarDocumentacion(modeldoc);
            } else {
                JOptionPane.showMessageDialog(null, "Se recomienda proporcionar la vigencia del INE, para notificar su vencimiento");
            }

            if (fechaISSSTE.getDate() != null) {

                SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
                String pasofecha = (formatofecha.format(fechaISSSTE.getDate()));
                modeldoc.setNombre("ISSSTE");
                modeldoc.setFechaVencimiento(pasofecha);
                daodoc.GuardarDocumentacion(modeldoc);

            } else {
                JOptionPane.showMessageDialog(null, "Se recomienda proporcionar la vigencia del ISSSTE, para notificar su vencimiento");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Ya se registró");
        }

    }

    private int registrar_documentosEntregados(JTable table) {
        if (DAO.numEmpExiste(txtNumEmp.getText()) == 1) {
            int idoc = daoBaja.idEmpleado(txtNumEmp.getText());
            modeldoc.setId(idoc);

            Boolean solicitud = Boolean.parseBoolean(table.getValueAt(0, 2).toString());
            Boolean cv = Boolean.parseBoolean(table.getValueAt(1, 2).toString());
            Boolean acta_nac = Boolean.parseBoolean(table.getValueAt(2, 2).toString());
            Boolean cartas_recom = Boolean.parseBoolean(table.getValueAt(3, 2).toString());
            Boolean carta_no_inhab = Boolean.parseBoolean(table.getValueAt(4, 2).toString());
            Boolean carta_antced = Boolean.parseBoolean(table.getValueAt(5, 2).toString());
            Boolean certif_med = Boolean.parseBoolean(table.getValueAt(6, 2).toString());
            Boolean cartilla_serv = Boolean.parseBoolean(table.getValueAt(7, 2).toString());
            Boolean fotografias = Boolean.parseBoolean(table.getValueAt(8, 2).toString());
            Boolean credencial = Boolean.parseBoolean(table.getValueAt(9, 2).toString());
            Boolean comprob_domc = Boolean.parseBoolean(table.getValueAt(10, 2).toString());
            Boolean curp = Boolean.parseBoolean(table.getValueAt(11, 2).toString());
            Boolean doc_preparacion = Boolean.parseBoolean(table.getValueAt(12, 2).toString());
            Boolean titulo = Boolean.parseBoolean(table.getValueAt(13, 2).toString());
            Boolean ced_prof = Boolean.parseBoolean(table.getValueAt(14, 2).toString());
            Boolean exam_opocision = Boolean.parseBoolean(table.getValueAt(15, 2).toString());
            Boolean exam_psicometrico = Boolean.parseBoolean(table.getValueAt(16, 2).toString());

            int solicitudint = solicitud ? 1 : 0;
            modeldoc.setSolicitudEmp(solicitudint);
            int cvint = cv ? 1 : 0;
            modeldoc.setCv(cvint);
            int acta_nacint = acta_nac ? 1 : 0;
            modeldoc.setActaNacimiento(acta_nacint);
            int castas_recomint = cartas_recom ? 1 : 0;
            modeldoc.setCartasRecom(castas_recomint);
            int carta_no_inhabint = carta_no_inhab ? 1 : 0;
            modeldoc.setCartaNoHabilitacion(carta_no_inhabint);
            int carta_antcedint = carta_antced ? 1 : 0;
            modeldoc.setCartaAntecedentes(carta_antcedint);
            int certif_medint = certif_med ? 1 : 0;
            modeldoc.setCartificadoMed(certif_medint);
            int cartilla_servint = cartilla_serv ? 1 : 0;
            modeldoc.setCartillaServicio(cartilla_servint);
            int fotografiasint = fotografias ? 1 : 0;
            modeldoc.setFotografias(fotografiasint);
            int credencialint = credencial ? 1 : 0;
            modeldoc.setIneB(credencialint);
            int comprob_domcint = comprob_domc ? 1 : 0;
            modeldoc.setComprobante_dom(comprob_domcint);
            int curpint = curp ? 1 : 0;
            modeldoc.setCurp(curpint);
            int doc_preparacionint = doc_preparacion ? 1 : 0;
            modeldoc.setDocumentosPreparacion(doc_preparacionint);
            int tituloint = titulo ? 1 : 0;
            modeldoc.setTitulo(tituloint);
            int ced_profint = ced_prof ? 1 : 0;
            modeldoc.setCedula_prof(ced_profint);
            int exam_opocisionint = exam_opocision ? 1 : 0;
            modeldoc.setExamenOposicion(exam_opocisionint);
            int exam_psicometricoint = exam_psicometrico ? 1 : 0;
            modeldoc.setExamenPsicometrico(exam_psicometricoint);
            modeldoc.setLinkDrive(modeldoc.getLinkDrive());
            try {
                if (daodoc.GuardarDocumentosEntregados(modeldoc) == 1) {
                    //   JOptionPane.showMessageDialog(null, "Guardado");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        } else {
            JOptionPane.showMessageDialog(null, "El número de empleado/a no esta registrado, para continuar favor de registrar el número");
        }
        return 1;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sexo = new javax.swing.ButtonGroup();
        opcion = new javax.swing.ButtonGroup();
        lenguaIndigena = new javax.swing.ButtonGroup();
        sexodh = new javax.swing.ButtonGroup();
        padre_madre = new javax.swing.ButtonGroup();
        jInternalFrame1 = new javax.swing.JInternalFrame();
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
        jLabel81 = new javax.swing.JLabel();
        cmbPlantel = new javax.swing.JComboBox<>();
        txtSueldo = new javax.swing.JFormattedTextField();
        btnFUMP = new javax.swing.JButton();
        jLabel82 = new javax.swing.JLabel();
        FechaInicioContrato = new com.toedter.calendar.JDateChooser();
        lbCodFError = new javax.swing.JLabel();
        lbIconCheck = new javax.swing.JLabel();
        cmbArea = new javax.swing.JComboBox<>();
        cmbPuesto = new javax.swing.JComboBox<>();
        cmbJefe = new javax.swing.JComboBox<>();
        jLabel83 = new javax.swing.JLabel();
        FechaTermContrato = new com.toedter.calendar.JDateChooser();
        tp_FormaciónAcadémica = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        cmbNivelEstudios = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cmbEstados = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        cbTitulo = new javax.swing.JCheckBox();
        txtInstitucion = new com.swing.JCTextField();
        txtCarrera = new com.swing.JCTextField();
        cbPosgrado = new javax.swing.JCheckBox();
        jLabel55 = new javax.swing.JLabel();
        cbDoctorado = new javax.swing.JCheckBox();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        cbMaestria = new javax.swing.JCheckBox();
        txtAñoEgreso = new com.swing.JCTextField();
        tp_Documentación = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        fechaINE = new com.toedter.calendar.JDateChooser();
        jLabel22 = new javax.swing.JLabel();
        fechaISSSTE = new com.toedter.calendar.JDateChooser();
        jLabel46 = new javax.swing.JLabel();
        btbAgregarURL = new javax.swing.JButton();
        lblLink = new javax.swing.JLabel();
        lbAgregado = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableDoc = new javax.swing.JTable();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        tb_Farmacias = new javax.swing.JPanel();
        panelRFamiliar = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        cmbParentescoDH = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtFechaNacDH = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        rbHombre1 = new javax.swing.JRadioButton();
        rbMujer1 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        txtnombre = new com.swing.JCTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1200, 709));
        setRequestFocusEnabled(false);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });

        jInternalFrame1.setClosable(true);
        jInternalFrame1.setIconifiable(true);
        jInternalFrame1.setResizable(true);
        jInternalFrame1.setTitle("Nuevo Registro");
        jInternalFrame1.setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/plus_+_20px.png"))); // NOI18N
        jInternalFrame1.setVisible(true);
        jInternalFrame1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jInternalFrame1FocusLost(evt);
            }
        });

        gral.setOpaque(false);
        gral.setPreferredSize(new java.awt.Dimension(1218, 729));
        gral.setLayout(new javax.swing.BoxLayout(gral, javax.swing.BoxLayout.LINE_AXIS));

        jTabbedPane.setOpaque(false);
        jTabbedPane.setForeground(new java.awt.Color(0, 102, 204));
        jTabbedPane.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane.setFont(new java.awt.Font("Poppins Medium", 0, 16)); // NOI18N
        jTabbedPane.setOpaque(true);
        jTabbedPane.setPreferredSize(new java.awt.Dimension(1205, 910));

        TB_DatosGenerales.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        TB_DatosGenerales.setPreferredSize(new java.awt.Dimension(1000, 871));

        pdatosgenerales.setOpaque(false);
        pdatosgenerales.setPreferredSize(new java.awt.Dimension(800, 808));

        jPanel1.setOpaque(false);
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

        sexo.add(rbHombre);
        rbHombre.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        rbHombre.setText("Hombre");
        rbHombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbHombreActionPerformed(evt);
            }
        });

        sexo.add(rbMujer);
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

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contacto de Emergencia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel7.setOpaque(false);

        jLabel29.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel29.setText("Teléfono");

        jLabel26.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel26.setText("Nombre");

        jLabel40.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel40.setText("Parentesco");

        cmbParentescoCE.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        cmbParentescoCE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Esposa", "Esposo", "Hijo", "Hija", "Padre", "Madre", "Hermana", "Hermano", "Amigo", "Amiga", "Otro parentesco" }));
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

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cmbParentescoCE, txtNombreContacto, txtTelefonoCE});

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

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cmbParentescoCE, txtNombreContacto, txtTelefonoCE});

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

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Domicilio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel6.setOpaque(false);

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

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtCalle, txtColonia, txtLocalidad, txtMunicipio, txtcp});

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

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtCalle, txtColonia, txtLocalidad, txtMunicipio, txtcp});

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

        padre_madre.add(rbSI);
        rbSI.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        rbSI.setText("Si");

        padre_madre.add(rbNO);
        rbNO.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        rbNO.setText("No");

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
                        .addComponent(rbMujer)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cmbEstadoCivil, cmbLenguaIndig, cmbTsangre, txtAMaterno, txtAPaterno, txtAbrev, txtCURP, txtCorreoInst, txtCorreoPers, txtFechaNac, txtIMSS, txtNombre, txtRFC, txtTelefono});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                            .addComponent(jLabel24)))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cmbEstadoCivil, cmbLenguaIndig, cmbTsangre, txtAMaterno, txtAPaterno, txtAbrev, txtCURP, txtCorreoInst, txtCorreoPers, txtFechaNac, txtIMSS, txtNombre, txtRFC, txtTelefono});

        javax.swing.GroupLayout pdatosgeneralesLayout = new javax.swing.GroupLayout(pdatosgenerales);
        pdatosgenerales.setLayout(pdatosgeneralesLayout);
        pdatosgeneralesLayout.setHorizontalGroup(
            pdatosgeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pdatosgeneralesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 788, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        pdatosgeneralesLayout.setVerticalGroup(
            pdatosgeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pdatosgeneralesLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 798, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        TB_DatosGenerales.setViewportView(pdatosgenerales);

        jTabbedPane.addTab("Datos Generales", TB_DatosGenerales);

        tb_laboral.setOpaque(false);

        panel1.setOpaque(false);

        tp_DatosLaborales.setOpaque(false);

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
        jLabel74.setText("Jefe(a) Inmediato(a)");

        jLabel75.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel75.setText("Tipo de Plaza");

        jLabel76.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel76.setText("Horario de Trabajo");

        jLabel77.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel77.setText("Área de Adscripcion");

        jLabel78.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel78.setText("Sindicato");

        txtCodFinanzas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCodFinanzas.setNextFocusableComponent(FechaIngreso);
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

        jLabel81.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel81.setText("Plantel");

        cmbPlantel.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        cmbPlantel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Tlapa", "Olinalá", "Iliatenco" }));
        cmbPlantel.setName(""); // NOI18N

        txtSueldo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        txtSueldo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnFUMP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/export_pdf.png"))); // NOI18N
        btnFUMP.setText("Agregar FUMP");
        btnFUMP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFUMPActionPerformed(evt);
            }
        });

        jLabel82.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel82.setText("Inicio de Contrato");

        FechaInicioContrato.setToolTipText("Si omite este apartado se registra como \"N/A\" por default.");
        FechaInicioContrato.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        FechaInicioContrato.setMaxSelectableDate(new java.util.Date(253370790097000L));
        FechaInicioContrato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FechaInicioContratoKeyReleased(evt);
            }
        });

        lbCodFError.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbCodFError.setForeground(new java.awt.Color(204, 0, 0));

        cmbArea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", " " }));

        cmbPuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        cmbJefe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jLabel83.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel83.setText("Terminación de Contrato");

        FechaTermContrato.setToolTipText("Si omite este apartado se registra como \"N/A\" por default.");
        FechaTermContrato.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        FechaTermContrato.setMaxSelectableDate(new java.util.Date(253370790097000L));
        FechaTermContrato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FechaTermContratoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout tp_DatosLaboralesLayout = new javax.swing.GroupLayout(tp_DatosLaborales);
        tp_DatosLaborales.setLayout(tp_DatosLaboralesLayout);
        tp_DatosLaboralesLayout.setHorizontalGroup(
            tp_DatosLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tp_DatosLaboralesLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(tp_DatosLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel81, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel70, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel71, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel72, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel77, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel80, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel73, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel75, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel78, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel76, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel79, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(tp_DatosLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tp_DatosLaboralesLayout.createSequentialGroup()
                        .addGroup(tp_DatosLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbArea, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(tp_DatosLaboralesLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(tp_DatosLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbPlantel, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCodFinanzas, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(FechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbPlaza, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbSindicato, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(tp_DatosLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tp_DatosLaboralesLayout.createSequentialGroup()
                                .addGap(328, 328, 328)
                                .addComponent(lbIconCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(tp_DatosLaboralesLayout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addGroup(tp_DatosLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(tp_DatosLaboralesLayout.createSequentialGroup()
                                        .addGroup(tp_DatosLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel82)
                                            .addComponent(jLabel83))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(tp_DatosLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmbJefe, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(FechaInicioContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(FechaTermContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbCodFError, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnFUMP, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(119, 119, 119))
        );
        tp_DatosLaboralesLayout.setVerticalGroup(
            tp_DatosLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tp_DatosLaboralesLayout.createSequentialGroup()
                .addGroup(tp_DatosLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tp_DatosLaboralesLayout.createSequentialGroup()
                        .addGroup(tp_DatosLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tp_DatosLaboralesLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel81)
                                .addGap(11, 11, 11)
                                .addGroup(tp_DatosLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(tp_DatosLaboralesLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel70))
                                    .addComponent(lbCodFError, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addComponent(jLabel71)
                                .addGap(35, 35, 35))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tp_DatosLaboralesLayout.createSequentialGroup()
                                .addGroup(tp_DatosLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(tp_DatosLaboralesLayout.createSequentialGroup()
                                        .addComponent(cmbJefe, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(FechaInicioContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(21, 21, 21)
                                        .addComponent(FechaTermContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(tp_DatosLaboralesLayout.createSequentialGroup()
                                        .addComponent(jLabel74)
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabel82)
                                        .addGap(17, 17, 17)
                                        .addComponent(jLabel83)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(tp_DatosLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnFUMP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel72))
                        .addGap(26, 26, 26)
                        .addComponent(lbIconCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel80)
                        .addGap(18, 18, 18)
                        .addGroup(tp_DatosLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel73)
                            .addComponent(txtHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(tp_DatosLaboralesLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(cmbPlantel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(txtCodFinanzas, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(FechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(cmbPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(tp_DatosLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbArea, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel77))
                        .addGap(18, 18, 18)
                        .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(tp_DatosLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbPlaza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel75))
                .addGap(36, 36, 36)
                .addGroup(tp_DatosLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel78)
                    .addComponent(cmbSindicato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(tp_DatosLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel76)
                    .addComponent(txtHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(tp_DatosLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel79)
                    .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tp_DatosLaborales, javax.swing.GroupLayout.PREFERRED_SIZE, 974, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(tp_DatosLaborales, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tb_laboralLayout = new javax.swing.GroupLayout(tb_laboral);
        tb_laboral.setLayout(tb_laboralLayout);
        tb_laboralLayout.setHorizontalGroup(
            tb_laboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        tb_laboralLayout.setVerticalGroup(
            tb_laboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tb_laboralLayout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        jTabbedPane.addTab("Datos Laborales", tb_laboral);

        tp_FormaciónAcadémica.setOpaque(false);

        jLabel14.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel14.setText("Nivel de Estudios");

        cmbNivelEstudios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Sin estudios", "Primaria", "Secundaria", "Bachillerato preparatoria o equivalente", "Profesional Técnico", "Capacitación para el Trabajo", "Técnico Superior Universitario", "Licenciatura", "Especialización", "Maestría", "Posgrado", "Doctorado", "Otro" }));

        jLabel16.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel16.setText("Nombre de la Institución ");

        jLabel17.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel17.setText("Carrera Profesional");

        jLabel18.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel18.setText("¿Tiene Maestría?");

        jLabel19.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel19.setText("Entidad Federativa");

        jLabel20.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel20.setText("Año de Egreso");

        jLabel21.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel21.setText("¿Cuenta conTitulo?");

        cbTitulo.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        cbTitulo.setText("Si");

        txtInstitucion.setPlaceholder("Nombre de la Institución");

        txtCarrera.setPlaceholder("Carrera");

        cbPosgrado.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        cbPosgrado.setText("Si");

        jLabel55.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel55.setText("¿Tiene doctorado?");

        cbDoctorado.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        cbDoctorado.setText("Si");

        jLabel11.setForeground(new java.awt.Color(51, 0, 204));
        jLabel11.setText("* Seleccionar la opción en caso de que sea verdadero");

        jLabel33.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel33.setText("¿Tiene Posgrado?");

        cbMaestria.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        cbMaestria.setText("Si");

        txtAñoEgreso.setPlaceholder("Año de egreso");
        txtAñoEgreso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAñoEgresoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout tp_FormaciónAcadémicaLayout = new javax.swing.GroupLayout(tp_FormaciónAcadémica);
        tp_FormaciónAcadémica.setLayout(tp_FormaciónAcadémicaLayout);
        tp_FormaciónAcadémicaLayout.setHorizontalGroup(
            tp_FormaciónAcadémicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tp_FormaciónAcadémicaLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(tp_FormaciónAcadémicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(tp_FormaciónAcadémicaLayout.createSequentialGroup()
                        .addGroup(tp_FormaciónAcadémicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel17)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addGroup(tp_FormaciónAcadémicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(tp_FormaciónAcadémicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel55)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tp_FormaciónAcadémicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbNivelEstudios, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCarrera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtInstitucion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbEstados, 0, 200, Short.MAX_VALUE)
                            .addComponent(cbTitulo)
                            .addComponent(cbPosgrado)
                            .addComponent(cbMaestria)
                            .addComponent(cbDoctorado)
                            .addComponent(txtAñoEgreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(193, 193, 193))
        );

        tp_FormaciónAcadémicaLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cmbEstados, cmbNivelEstudios, txtCarrera, txtInstitucion});

        tp_FormaciónAcadémicaLayout.setVerticalGroup(
            tp_FormaciónAcadémicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tp_FormaciónAcadémicaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(tp_FormaciónAcadémicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addGroup(tp_FormaciónAcadémicaLayout.createSequentialGroup()
                        .addComponent(cmbNivelEstudios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(tp_FormaciónAcadémicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(20, 20, 20)
                        .addGroup(tp_FormaciónAcadémicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtInstitucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addGroup(tp_FormaciónAcadémicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addGap(21, 21, 21)
                        .addGroup(tp_FormaciónAcadémicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20)
                            .addComponent(txtAñoEgreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(tp_FormaciónAcadémicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tp_FormaciónAcadémicaLayout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel33)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel18))
                    .addGroup(tp_FormaciónAcadémicaLayout.createSequentialGroup()
                        .addComponent(cbTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbPosgrado)
                        .addGap(13, 13, 13)
                        .addComponent(cbMaestria)))
                .addGap(7, 7, 7)
                .addGroup(tp_FormaciónAcadémicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel55)
                    .addComponent(cbDoctorado))
                .addGap(51, 51, 51))
        );

        tp_FormaciónAcadémicaLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cmbEstados, cmbNivelEstudios, txtCarrera, txtInstitucion});

        jTabbedPane.addTab("Formacion Académica", tp_FormaciónAcadémica);

        tp_Documentación.setOpaque(false);
        tp_Documentación.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Favor de Registrar el Vencimieto de los siguientes documentos:");
        tp_Documentación.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("ISSSTE *");
        tp_Documentación.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, -1, -1));

        fechaINE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tp_Documentación.add(fechaINE, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 200, 36));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Credencial de Elector (INE)");
        tp_Documentación.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        fechaISSSTE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tp_Documentación.add(fechaISSSTE, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, 200, 32));

        jLabel46.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel46.setText("Link de ubicación de la documentación:");
        jLabel46.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        tp_Documentación.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, -1, -1));

        btbAgregarURL.setText("Agregar enlace");
        btbAgregarURL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbAgregarURLActionPerformed(evt);
            }
        });
        tp_Documentación.add(btbAgregarURL, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 230, 120, 30));

        lblLink.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/google_drive.png"))); // NOI18N
        lblLink.setText("<html>Comprobar : <a href=\\\"\\\">Google Drive</a></html>");
        lblLink.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblLink.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLinkMouseClicked(evt);
            }
        });
        tp_Documentación.add(lblLink, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 280, -1, -1));
        tp_Documentación.add(lbAgregado, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 230, 30, 30));

        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tableDoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "Solicitud de Empleo", false},
                {"2", "Curriculum Vitae",false},
                {"3", "Acta de Nacimiento", false},
                {"4", "Cartas de Recomendación", false},
                {"5", "Carta de no inhabilitación", false},
                {"6", "Carta de  antecedentes no penales", false},
                {"7", "Certificado Médico", false},
                {"8", "Cartilla de Servicio Militar", false},
                {"9", "Dos fotografías tamaño infantil a color", false},
                {"10", "Credencial de Elector", false},
                {"11", "Comprobante de domicilio", false},
                {"12", "CURP", false},
                {"13", "Documentos de preparación", false},
                {"14", "Título", false},
                {"15", "Cédula Profesional", false},
                {"16", "Examen de oposición",false},
                {"17", "Examen Psicométrico", false}
            },
            new String [] {
                "No.", "Documento", "Entregado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableDoc);
        if (tableDoc.getColumnModel().getColumnCount() > 0) {
            tableDoc.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableDoc.getColumnModel().getColumn(1).setMinWidth(200);
            tableDoc.getColumnModel().getColumn(1).setPreferredWidth(200);
            tableDoc.getColumnModel().getColumn(2).setMinWidth(80);
            tableDoc.getColumnModel().getColumn(2).setPreferredWidth(80);
        }

        tp_Documentación.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 480, 310));
        tp_Documentación.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 700, 10));

        jLabel12.setText("En la siguiente tabla marque como verdadero a los documentos que fueron entregados por el empleado/a para integregar a su expediente ");
        tp_Documentación.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, -1));

        jTabbedPane.addTab("Documentación", tp_Documentación);

        tb_Farmacias.setOpaque(false);
        tb_Farmacias.setPreferredSize(new java.awt.Dimension(500, 623));

        panelRFamiliar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Familiar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins", 0, 12))); // NOI18N
        panelRFamiliar.setOpaque(false);

        jLabel9.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel9.setText("Parentesco");

        cmbParentescoDH.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        cmbParentescoDH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Padre", "Madre", "Esposa", "Esposo", "Hijo", "Hija", "otro" }));

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel7.setText("Fecha de Nacimiento");

        txtFechaNacDH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel10.setText("Sexo");

        sexodh.add(rbHombre1);
        rbHombre1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbHombre1.setText("Hombre");

        sexodh.add(rbMujer1);
        rbMujer1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbMujer1.setText("Mujer");

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel1.setText("Nombre");

        javax.swing.GroupLayout panelRFamiliarLayout = new javax.swing.GroupLayout(panelRFamiliar);
        panelRFamiliar.setLayout(panelRFamiliarLayout);
        panelRFamiliarLayout.setHorizontalGroup(
            panelRFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRFamiliarLayout.createSequentialGroup()
                .addGroup(panelRFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRFamiliarLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel9))
                    .addGroup(panelRFamiliarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelRFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelRFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(panelRFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelRFamiliarLayout.createSequentialGroup()
                                .addComponent(rbHombre1)
                                .addGap(32, 32, 32)
                                .addComponent(rbMujer1))
                            .addComponent(txtFechaNacDH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtnombre, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                            .addComponent(cmbParentescoDH, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRFamiliarLayout.setVerticalGroup(
            panelRFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRFamiliarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(rbHombre1))
                    .addComponent(rbMujer1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRFamiliarLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9))
                    .addGroup(panelRFamiliarLayout.createSequentialGroup()
                        .addComponent(txtFechaNacDH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbParentescoDH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(92, 92, 92))
        );

        jToolBar1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar1.setRollover(true);
        jToolBar1.setOpaque(false);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/add_25px.png"))); // NOI18N
        jButton1.setText("Nuevo");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/save_35px.png"))); // NOI18N
        btnGuardar.setText("Añadir");
        btnGuardar.setFocusable(false);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnGuardar);

        javax.swing.GroupLayout tb_FarmaciasLayout = new javax.swing.GroupLayout(tb_Farmacias);
        tb_Farmacias.setLayout(tb_FarmaciasLayout);
        tb_FarmaciasLayout.setHorizontalGroup(
            tb_FarmaciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tb_FarmaciasLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(tb_FarmaciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(tb_FarmaciasLayout.createSequentialGroup()
                        .addComponent(panelRFamiliar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(366, Short.MAX_VALUE))
        );
        tb_FarmaciasLayout.setVerticalGroup(
            tb_FarmaciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tb_FarmaciasLayout.createSequentialGroup()
                .addGroup(tb_FarmaciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tb_FarmaciasLayout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(tb_FarmaciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tb_FarmaciasLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(tb_FarmaciasLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(panelRFamiliar, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(tb_FarmaciasLayout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(264, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Farmacias", tb_Farmacias);

        gral.add(jTabbedPane);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnNuevo.setBackground(new java.awt.Color(0, 102, 51));
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
        jPanel2.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 23, 130, -1));

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
        jPanel2.add(btnAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 130, -1));

        btnSiguiente.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        btnSiguiente.setText("Siguiente >");
        btnSiguiente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSiguiente.setIconTextGap(6);
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        jPanel2.add(btnSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 130, -1));

        btnSave.setBackground(new java.awt.Color(255, 255, 255));
        btnSave.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSave.setText("Guardar datos");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel2.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 130, 30));

        gral.add(jPanel2);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1219, Short.MAX_VALUE)
            .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jInternalFrame1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(gral, javax.swing.GroupLayout.PREFERRED_SIZE, 1199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 674, Short.MAX_VALUE)
            .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jInternalFrame1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(gral, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 16, Short.MAX_VALUE)
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 9, Short.MAX_VALUE)
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );
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
                // jTabbedPane.setEnabledAt(5, false);
                jTabbedPane.setSelectedIndex(0);
                break;
            case 2:

                jTabbedPane.setEnabledAt(0, true);
                jTabbedPane.setEnabledAt(1, true);
                jTabbedPane.setEnabledAt(2, false);
                jTabbedPane.setEnabledAt(3, false);
                jTabbedPane.setEnabledAt(4, false);
                //   jTabbedPane.setEnabledAt(5, false);
                jTabbedPane.setSelectedIndex(1);
                break;
            case 3:

                jTabbedPane.setEnabledAt(0, true);
                jTabbedPane.setEnabledAt(1, true);
                jTabbedPane.setEnabledAt(2, true);
                jTabbedPane.setEnabledAt(3, false);
                jTabbedPane.setEnabledAt(4, false);
                //   jTabbedPane.setEnabledAt(5, false);
                jTabbedPane.setSelectedIndex(2);
                break;
            case 4:

                jTabbedPane.setEnabledAt(0, true);
                jTabbedPane.setEnabledAt(1, true);
                jTabbedPane.setEnabledAt(2, true);
                jTabbedPane.setEnabledAt(3, true);
                jTabbedPane.setEnabledAt(4, false);
                //   jTabbedPane.setEnabledAt(5, false);
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
                //     jTabbedPane.setEnabledAt(5, false);

                validar_camposvacios();

                desbloquear_laborales();
                jTabbedPane.setSelectedIndex(1);
                break;
            case 1:

                jTabbedPane.setEnabledAt(0, true);
                jTabbedPane.setEnabledAt(1, true);
                jTabbedPane.setEnabledAt(2, true);
                jTabbedPane.setEnabledAt(3, false);
                jTabbedPane.setEnabledAt(4, false);
                //   jTabbedPane.setEnabledAt(5, false);
                campos_laborales();

                jTabbedPane.setSelectedIndex(2);

                break;
            case 2:

                jTabbedPane.setEnabledAt(0, true);
                jTabbedPane.setEnabledAt(1, true);
                jTabbedPane.setEnabledAt(2, true);
                jTabbedPane.setEnabledAt(3, true);
                jTabbedPane.setEnabledAt(4, false);
                //     jTabbedPane.setEnabledAt(5, false);
                validar_fa();
                jTabbedPane.setSelectedIndex(3);
                break;
            case 3:

                jTabbedPane.setEnabledAt(0, true);
                jTabbedPane.setEnabledAt(1, true);
                jTabbedPane.setEnabledAt(2, true);
                jTabbedPane.setEnabledAt(3, true);
                jTabbedPane.setEnabledAt(4, true);
                // jTabbedPane.setEnabledAt(5, false);
                btnSave.setEnabled(true);
                jTabbedPane.setSelectedIndex(4);

                break;
            case 4:
                btnSiguiente.setEnabled(false);
                jTabbedPane.setEnabledAt(0, true);
                jTabbedPane.setEnabledAt(1, true);
                jTabbedPane.setEnabledAt(2, true);
                jTabbedPane.setEnabledAt(3, true);
                jTabbedPane.setEnabledAt(4, true);
                //   jTabbedPane.setEnabledAt(5, true);

                //      jTabbedPane.setSelectedIndex(5);
//                btnGuardar.setEnabled(true);
                break;

            default:

                break;
        }

    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed

        Tipo dialog = new Tipo(new javax.swing.JFrame(), true);
        dialog.setVisible(true);

        if (dialog.numemp == null) {
            bloquear();
        } else {
            limpiar();
            limpiar_laborales();
            limpiar_FA();
            desbloquear();
            txtNumEmp.setText("" + dialog.getNum());
            this.setTipo(dialog.getTipoContratacion());
        }
//   try {
//            Desktop.getDesktop().browse(new URI("https://drive.google.com/drive/folders/1DvKbFO-0kpRrpbHoYCOT_zMYmRvpck3T?usp=sharing"));
//        } catch (URISyntaxException | IOException ex) {
//
//        }
//text  .. <html> Enlace a : <a href=\"\">Google Drive</a></html>
    }//GEN-LAST:event_btnNuevoActionPerformed

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
                    lbIconCheck.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/check_circle_20px.png")));
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
        //   Validaciones.soloRecibeTexto(evt);
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
        // Validaciones.esNumeroEntero(evt);
        //  Validaciones.revisarLongitud(evt, txtIMSS, 11);
    }//GEN-LAST:event_txtIMSSKeyTyped

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

    private void FechaInicioContratoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FechaInicioContratoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_FechaInicioContratoKeyReleased
    public Image get_Image(String ruta) {
        try {
            ImageIcon imageIcon = new ImageIcon(getClass().getResource(ruta));
            Image mainIcon = imageIcon.getImage();
            return mainIcon;
        } catch (Exception e) {
        }
        return null;
    }
    private void btnQuitarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarFotoActionPerformed
        ImageAvatar ia = new ImageAvatar();

        if (rbHombre.isSelected()) {

            icono = new ImageIcon("/com/icon/foto_hombre.jpg");
            //     ImageIcon nuevoIcono = new ImageIcon(ia.toImage(icono));
            lbFoto.setIcon(new ImageIcon(ia.toImage(icono)));
            lbFoto.repaint();
            model.setFoto_paht("/com/icon/foto_hombre.jpg");

//            icono = new ImageIcon("src/com/icon/foto_hombre.jpg");
//            //     ImageIcon nuevoIcono = new ImageIcon(ia.toImage(icono));
        } else if (rbMujer.isSelected()) {
            icono = new ImageIcon("/com/icon/foto_mujer.png");
            //     ImageIcon nuevoIcono = new ImageIcon(ia.toImage(icono));
            lbFoto.setIcon(new ImageIcon(ia.toImage(icono)));
            lbFoto.repaint();
            model.setFoto_paht("/com/icon/foto_mujer.png");
        }

    }//GEN-LAST:event_btnQuitarFotoActionPerformed

    private void rbHombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbHombreActionPerformed

        ImageIcon icono = new ImageIcon(get_Image("/com/icon/foto_hombre.jpg"));

        lbFoto.setIcon(icono);
        lbFoto.repaint();

        String[] eCivil_o = {" ", "Soltero", "Casado", "Viudo", "Divorciado", "Unión Libre", "Otro"};

        cmbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(eCivil_o));
    }//GEN-LAST:event_rbHombreActionPerformed

    private void rbMujerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMujerActionPerformed
        ImageIcon icono = new ImageIcon(get_Image("/com/icon/foto_mujer.png"));
        lbFoto.setIcon(icono);
        lbFoto.repaint();
        String[] eCivil_a = {" ", "Soltera", "Casada", "Viuda", "Divorciada", "Unión Libre", "Otro"};
        cmbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(eCivil_a));
    }//GEN-LAST:event_rbMujerActionPerformed

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost

    }//GEN-LAST:event_formFocusLost

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden

    }//GEN-LAST:event_formComponentHidden

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked


    }//GEN-LAST:event_btnGuardarMouseClicked

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        registrar_derechohabiente();


    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txtnombre.setText("");
        sexodh.clearSelection();
        txtFechaNacDH.setDate(null);
        cmbParentescoDH.setSelectedIndex(0);


    }//GEN-LAST:event_jButton1ActionPerformed

    private void btbAgregarURLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbAgregarURLActionPerformed
        String link = JOptionPane.showInputDialog("Pegue el link a Google Drive");
        modeldoc.setLinkDrive(link);
        lbAgregado.setIcon(new javax.swing.ImageIcon(getClass().getResource("src/com/icon/check_circle_20px.png")));
        lbAgregado.repaint();
        if (link == null) {
            lbAgregado.setIcon(null);
            lbAgregado.repaint();
        }

    }//GEN-LAST:event_btbAgregarURLActionPerformed

    private void lblLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLinkMouseClicked

        try {

            if (modeldoc.getLinkDrive() == null) {
                Notification n = new Notification(MainSystem.getFrames()[0], Notification.Type.WARNING, Notification.Location.CENTER, "No se ha asignado un Link, Agréguelo pulsando el botón agregar");
                n.showNotification();

            } else {
                Desktop.getDesktop().browse(new URI(modeldoc.getLinkDrive()));
            }

        } catch (URISyntaxException | IOException ex) {

        }
    }//GEN-LAST:event_lblLinkMouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (txtFechaNac.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Campo ** Fecha de Nacimiento ** vacío", "Error", JOptionPane.ERROR_MESSAGE);
        }

        if (FechaIngreso.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Establecer fecha de Ingreso");
        }
        if (FechaInicioContrato.getDate() == null && this.getTipo().equals("Honorarios")) {
            JOptionPane.showMessageDialog(null, "Establecer fecha terminación de contrato ");

        }
        try {
            GuardarDatosG();
            registrar_formacionAcademica();
            registrar_documentacion();
            registrar_documentosEntregados(tableDoc);
            GuardarDatosLaboralesN();

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            Notification panel = new Notification(MainSystem.getFrames()[0], Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Datos Generales registrados correctamente");
            panel.showNotification();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtTelefonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTelefonoMouseClicked
        txtTelefono.setCaretPosition(0);
    }//GEN-LAST:event_txtTelefonoMouseClicked

    private void txtTelefonoCEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTelefonoCEMouseClicked
        txtTelefonoCE.setCaretPosition(0);
    }//GEN-LAST:event_txtTelefonoCEMouseClicked

    private void txtMunicipioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMunicipioKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMunicipioKeyTyped

    private void txtcpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcpKeyTyped
        Validaciones.revisarLongitud(evt, txtcp, 5);
    }//GEN-LAST:event_txtcpKeyTyped

    private void txtAñoEgresoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAñoEgresoKeyTyped
        Validaciones.esNumeroEntero(evt);
        Validaciones.revisarLongitud(evt, txtAñoEgreso, 4);
    }//GEN-LAST:event_txtAñoEgresoKeyTyped

    private void FechaTermContratoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FechaTermContratoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_FechaTermContratoKeyReleased

    private void jInternalFrame1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jInternalFrame1FocusLost

    }//GEN-LAST:event_jInternalFrame1FocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    com.toedter.calendar.JDateChooser FechaIngreso;
    com.toedter.calendar.JDateChooser FechaInicioContrato;
    com.toedter.calendar.JDateChooser FechaTermContrato;
    javax.swing.JScrollPane TB_DatosGenerales;
    javax.swing.JButton btbAgregarURL;
    com.swing.ButtonBadges btnAgregarFoto;
    javax.swing.JButton btnAnterior;
    javax.swing.JButton btnFUMP;
    javax.swing.JButton btnGuardar;
    javax.swing.JButton btnNuevo;
    javax.swing.JButton btnQuitarFoto;
    javax.swing.JButton btnSave;
    javax.swing.JButton btnSiguiente;
    javax.swing.JCheckBox cbDoctorado;
    javax.swing.JCheckBox cbMaestria;
    javax.swing.JCheckBox cbPosgrado;
    javax.swing.JCheckBox cbTitulo;
    javax.swing.JComboBox<String> cmbArea;
    javax.swing.JComboBox<String> cmbCategoria;
    javax.swing.JComboBox<String> cmbEstadoCivil;
    javax.swing.JComboBox<String> cmbEstados;
    javax.swing.JComboBox<String> cmbJefe;
    javax.swing.JComboBox<String> cmbLenguaIndig;
    javax.swing.JComboBox<String> cmbNivelEstudios;
    javax.swing.JComboBox<String> cmbParentescoCE;
    javax.swing.JComboBox<String> cmbParentescoDH;
    javax.swing.JComboBox<String> cmbPlantel;
    javax.swing.JComboBox<String> cmbPlaza;
    javax.swing.JComboBox<String> cmbPuesto;
    javax.swing.JComboBox<String> cmbSindicato;
    javax.swing.JComboBox<String> cmbTsangre;
    com.toedter.calendar.JDateChooser fechaINE;
    com.toedter.calendar.JDateChooser fechaISSSTE;
    javax.swing.JPanel gral;
    javax.swing.JButton jButton1;
    javax.swing.JInternalFrame jInternalFrame1;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel10;
    javax.swing.JLabel jLabel11;
    javax.swing.JLabel jLabel12;
    javax.swing.JLabel jLabel13;
    javax.swing.JLabel jLabel14;
    javax.swing.JLabel jLabel15;
    javax.swing.JLabel jLabel16;
    javax.swing.JLabel jLabel17;
    javax.swing.JLabel jLabel18;
    javax.swing.JLabel jLabel19;
    javax.swing.JLabel jLabel2;
    javax.swing.JLabel jLabel20;
    javax.swing.JLabel jLabel21;
    javax.swing.JLabel jLabel22;
    javax.swing.JLabel jLabel23;
    javax.swing.JLabel jLabel24;
    javax.swing.JLabel jLabel25;
    javax.swing.JLabel jLabel26;
    javax.swing.JLabel jLabel27;
    javax.swing.JLabel jLabel28;
    javax.swing.JLabel jLabel29;
    javax.swing.JLabel jLabel3;
    javax.swing.JLabel jLabel30;
    javax.swing.JLabel jLabel32;
    javax.swing.JLabel jLabel33;
    javax.swing.JLabel jLabel38;
    javax.swing.JLabel jLabel39;
    javax.swing.JLabel jLabel4;
    javax.swing.JLabel jLabel40;
    javax.swing.JLabel jLabel41;
    javax.swing.JLabel jLabel42;
    javax.swing.JLabel jLabel43;
    javax.swing.JLabel jLabel44;
    javax.swing.JLabel jLabel45;
    javax.swing.JLabel jLabel46;
    javax.swing.JLabel jLabel47;
    javax.swing.JLabel jLabel5;
    javax.swing.JLabel jLabel53;
    javax.swing.JLabel jLabel55;
    javax.swing.JLabel jLabel58;
    javax.swing.JLabel jLabel6;
    javax.swing.JLabel jLabel7;
    javax.swing.JLabel jLabel70;
    javax.swing.JLabel jLabel71;
    javax.swing.JLabel jLabel72;
    javax.swing.JLabel jLabel73;
    javax.swing.JLabel jLabel74;
    javax.swing.JLabel jLabel75;
    javax.swing.JLabel jLabel76;
    javax.swing.JLabel jLabel77;
    javax.swing.JLabel jLabel78;
    javax.swing.JLabel jLabel79;
    javax.swing.JLabel jLabel8;
    javax.swing.JLabel jLabel80;
    javax.swing.JLabel jLabel81;
    javax.swing.JLabel jLabel82;
    javax.swing.JLabel jLabel83;
    javax.swing.JLabel jLabel9;
    javax.swing.JPanel jPanel1;
    javax.swing.JPanel jPanel2;
    javax.swing.JPanel jPanel6;
    javax.swing.JPanel jPanel7;
    javax.swing.JScrollPane jScrollPane2;
    javax.swing.JSeparator jSeparator1;
    javax.swing.JSeparator jSeparator2;
    javax.swing.JSeparator jSeparator3;
    javax.swing.JSeparator jSeparator4;
    javax.swing.JTabbedPane jTabbedPane;
    javax.swing.JToolBar jToolBar1;
    javax.swing.JLabel lbAgregado;
    javax.swing.JLabel lbCodFError;
    javax.swing.JLabel lbCorreoError;
    javax.swing.JLabel lbCorreoInstError;
    javax.swing.JLabel lbErrorCURP;
    com.swing.ImageAvatar lbFoto;
    javax.swing.JLabel lbIconCheck;
    javax.swing.JLabel lbRFCError;
    javax.swing.JLabel lblLink;
    javax.swing.ButtonGroup lenguaIndigena;
    javax.swing.ButtonGroup opcion;
    javax.swing.ButtonGroup padre_madre;
    javax.swing.JPanel panel1;
    javax.swing.JPanel panelRFamiliar;
    com.swing.PanelRound panelRound2;
    public javax.swing.JPanel pdatosgenerales;
    javax.swing.JRadioButton rbHombre;
    javax.swing.JRadioButton rbHombre1;
    javax.swing.JRadioButton rbMujer;
    javax.swing.JRadioButton rbMujer1;
    javax.swing.JRadioButton rbNO;
    javax.swing.JRadioButton rbSI;
    javax.swing.ButtonGroup sexo;
    javax.swing.ButtonGroup sexodh;
    javax.swing.JTable tableDoc;
    javax.swing.JPanel tb_Farmacias;
    javax.swing.JPanel tb_laboral;
    javax.swing.JPanel tp_DatosLaborales;
    javax.swing.JPanel tp_Documentación;
    javax.swing.JPanel tp_FormaciónAcadémica;
    com.swing.JCTextField txtAMaterno;
    com.swing.JCTextField txtAPaterno;
    com.swing.JCTextField txtAbrev;
    com.swing.JCTextField txtAñoEgreso;
    com.swing.JCTextField txtCURP;
    com.swing.JCTextField txtCalle;
    com.swing.JCTextField txtCarrera;
    com.swing.JCTextField txtCodFinanzas;
    com.swing.JCTextField txtColonia;
    com.swing.JCTextField txtCorreoInst;
    com.swing.JCTextField txtCorreoPers;
    com.toedter.calendar.JDateChooser txtFechaNac;
    com.toedter.calendar.JDateChooser txtFechaNacDH;
    com.swing.JCTextField txtHorario;
    com.swing.JCTextField txtHoras;
    com.swing.JCTextField txtIMSS;
    com.swing.JCTextField txtInstitucion;
    com.swing.JCTextField txtLocalidad;
    com.swing.JCTextField txtMunicipio;
    com.swing.JCTextField txtNombre;
    com.swing.JCTextField txtNombreContacto;
    public com.swing.JCTextField txtNumEmp;
    com.swing.JCTextField txtRFC;
    javax.swing.JFormattedTextField txtSueldo;
    javax.swing.JFormattedTextField txtTelefono;
    javax.swing.JFormattedTextField txtTelefonoCE;
    com.swing.JCTextField txtcp;
    com.swing.JCTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
