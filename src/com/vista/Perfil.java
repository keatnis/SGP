package com.vista;

import com.model.ModelPersonalN;
import java.awt.event.KeyEvent;
import com.DAO.BajaPersonalDAO;
import com.DAO.ConsultasJAP;
import com.DAO.PersonalNDAO;
import com.connection.Conexion;
import com.model.ModelCurso;
import com.model.ModelDocumentacion;
import com.notification.Notification;
import com.vista.edit.editarDG;
import com.vista.edit.editarDH;
import com.vista.edit.editarDL;
import com.vista.edit.editarFA;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class Perfil extends javax.swing.JPanel {

    BajaPersonalDAO daobaja = new BajaPersonalDAO();
    Conexion con = new Conexion();
    PreparedStatement psql;
    ResultSet rs;
    Connection conn = con.getConnection();
    //  ModelPersonalN model = new ModelPersonalN();
    PersonalNDAO dao = new PersonalNDAO();
    ModelPersonalN personal;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    InputStream imgstream;
    Image image;
    private byte[] b;

    public Perfil() {
        initComponents();
        cleantxt();

    }

    public void showData(ModelPersonalN data) {
        lbNumEmp.setText(data.getNumEmpleado());
        lbNombre.setText(data.getAbrev() + " " + data.getNombres() + " " + data.getApellidoP() + " " + data.getApellidoM());
        lbSexo.setText(data.getSexo());
        if (data.getSexo().equals("H")) {
            lbEsMadre_padre.setText("Es Padre:");
        } else {
            lbEsMadre_padre.setText("Es Madre:");
        }
        lbFechaNac.setText(data.getFechaNacimiento());
        lbEstadoCivil.setText(data.getEstadoCivil());
        lbTelefono.setText(data.getTelefono());
        lbIMSS.setText(data.getIMSS());
        lbRFC.setText(data.getRFC());
        lbCURP.setText(data.getCURP());
        labelStatus1.setText(data.getStatus());
        imageAvatar1.setIcon(data.getIcon());
        imageAvatar1.repaint();
        lbCorreo.setText(data.getCorreoPersonal());
        lbCorreoInst.setText(data.getCorreoInst());
        lbTipoSangre.setText(data.getTipoSangre());
        lbLengua.setText(data.getLenguaIndigena());
        lbDireccion.setText("<html>" + data.getDirección() + ",Col. " + data.getColonia() + ", " + data.getLocalidad() + "</html>");
        lbPlantel.setText(data.getPlantel());
        lbCodigo.setText(data.getCodigo());
        lbFechaIngreso.setText(data.getFechaIngreso());
        lbPuesto.setText(data.getPuesto());
        lbTipoPlaza.setText(data.getTipoPlaza());
        lbSindicato.setText(data.getSindicato());
        lbHorario.setText(data.getHorarioTrabajo());
        lbSueldo.setText(data.getSueldo());
        lbTermCont.setText(data.getFechaTerminoCont());
        lbCategoria.setText(data.getCategoria());
        lbArea.setText(data.getAreaAdscripción());
        lbHoras.setText(data.getHorasLaborales());
        lbJefe.setText(data.getJefeInmediato());
        lbtype.setText(data.getTipoContratacion());
        lbNivelEst.setText(data.getNivelEstudios());
        lbNombreInst.setText(data.getNombreInst());
        lbCarrera.setText(data.getCarreraProfesional());
        lbEntidad.setText(data.getEntidadFed());
        lbAño.setText("" + data.getAnio_egreso());
        lbEdad.setText(data.getEDAD());
        lbAntiguedad.setText("" + data.getAnt_añoI() + " años y " + data.getAntmesesI() + " meses");
        if (data.getConTitulo().equals("1")) {
            lbTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/check_circle_20px.png")));
        } else {
            lbTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/Close.png")));
        }
        if (data.getConPosgrado().equals("1")) {
            lbPosgrado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/check_circle_20px.png")));
        } else {
            lbPosgrado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/Close.png")));
        }
        if (data.getConMaestria().equals("1")) {
            lbMaestria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/check_circle_20px.png")));
        } else {
            lbMaestria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/Close.png")));
        }
        if (data.getConDoctorado().equals("1")) {
            lbDoctorado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/check_circle_20px.png")));
        } else {
            lbDoctorado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/Close.png")));
        }
        lcContactoE.setText("<html>" + "Su " + data.getParentestoCEmerg() + " - " + data.getNombreCEmerg() + "<br>" + "Tel. " + data.getTelefonoCE() + "</html>");
        if (data.getPadreomadre() == null) {
            lbpadre_madre.setText("NA");
            //lbEsMadre_padre.setText("Es padre/madre");
        } else if (data.getPadreomadre().equals("1")) {
            lbpadre_madre.setText("Si");

        } else {
            lbpadre_madre.setText("No");
        }

    }

    private void cleantxt() {

        lbNumEmp.setText("");
        lbNombre.setText("");
        lbSexo.setText("");
        lbFechaNac.setText("");
        lbEstadoCivil.setText("");
        lbTelefono.setText("");
        lbIMSS.setText("");
        lbRFC.setText("");
        lbCURP.setText("");
        labelStatus1.setText("");
        imageAvatar1.setIcon(null);
        imageAvatar1.repaint();
        lbCorreo.setText("");
        lbCorreoInst.setText("");
        lbTipoSangre.setText("");
        lbLengua.setText("");
        lbDireccion.setText("");
        lbPlantel.setText("");
        lbCodigo.setText("");
        lbFechaIngreso.setText("");
        lbPuesto.setText("");
        lbTipoPlaza.setText("");
        lbSindicato.setText("");
        lbHorario.setText("");
        lbSueldo.setText("");
        lbTermCont.setText("");
        lbCategoria.setText("");
        lbArea.setText("");
        lbHoras.setText("");
        lbJefe.setText("");
        lbtype.setText("");
        lbNivelEst.setText("");
        lbNombreInst.setText("");
        lbCarrera.setText("");
        lbEntidad.setText("");
        lbAño.setText("");
        lbEdad.setText("");
        lbAntiguedad.setText("");
        lbEsMadre_padre.setText("");
        lcContactoE.setText("");
        lbpadre_madre.setText("");

    }

    public void listDH(JTable tabla) {

        DefaultTableModel dt = (DefaultTableModel) tabla.getModel();
        dao.setId(id);
        int numReg = dao.listDerechohabiente().size();
        Object[] columna = new Object[7];

        for (int i = 0; i < numReg; i++) {
            columna[0] = dao.listDerechohabiente().get(i).getId_dh();
            columna[1] = dao.listDerechohabiente().get(i).getNombredh();
            columna[2] = dao.listDerechohabiente().get(i).getFechaNacdh();
            columna[3] = dao.listDerechohabiente().get(i).getSexodh();
            columna[4] = dao.listDerechohabiente().get(i).getParentesco();
            columna[5] = dao.listDerechohabiente().get(i).getEdaddh() + " año (s) y " + dao.listDerechohabiente().get(i).getEdadMesesdh() + " meses";
            columna[6] = dao.listDerechohabiente().get(i).getStatus();
            dt.addRow(columna);
        }

    }

    private void FullDatabyId(int id) {

//        String SentenciaSQL = "SELECT num_empleado,abrev_nombre,nombre,ape_paterno,ape_materno,status,genero,fecha_nacimiento,telefono,correo_personal,correo_institucional,curp,rfc,imss,estado_civil,lengua_indigena,direccion,colonia,localidad,contacto_emergencia,parent_emerg,telefono_CE,tipo_sangre,foto_emp,plantel,tipo_contratacion,codigo,fecha_ingreso,fecha_term_contrato,jefe_inmediato,puesto,area_adscripcion,categoria,horas_laborales,tipo_plaza,sindicato,horario_trabajo,sueldo,nivel_estudio,carrera,institucion,estado,año_egreso,titulo,posgrado,maestria,doctorado\n"
//                + "         ,YEAR(CURDATE())-YEAR(fecha_nacimiento) + IF(DATE_FORMAT(CURDATE(),'%m-%d') > DATE_FORMAT(fecha_nacimiento,'%m-%d'), 0 , -1 ) AS edadActual,\n"
//                + "         TIMESTAMPDIFF(YEAR, fecha_ingreso,curdate()) AS años_ant, date_format( now(), '%m' ) - date_format( fecha_ingreso, '%m' ) -( date_format( now(), '%Y-00-%d') < date_format( fecha_ingreso, '%Y-00-%d' ) ) as meses_ant,esPadre_Madre\n"
//                + "         FROM tbl_empleado\n"
//                + "		 INNER JOIN tbl_empleo ON tbl_empleado.id_empleado=tbl_empleo.id_empleado\n"
//                + "		 INNER JOIN tbl_formacion_academica ON tbl_empleado.id_empleado=tbl_formacion_academica.id_empleado where tbl_empleado.id_empleado='" + id + "';";
        String SentenciaSQL = "SELECT num_empleado,abrev_nombre,nombre,ape_paterno,ape_materno,status,genero,fecha_nacimiento,telefono,correo_personal,correo_institucional,curp,rfc,imss,estado_civil,lengua_indigena,direccion,colonia,localidad,contacto_emergencia,parent_emerg,telefono_CE,tipo_sangre,foto_emp,plantel,tipo_contratacion,codigo,fecha_ingreso,fecha_term_contrato,(SELECT concat(abrev,' ',nombre,' ',ape_paterno,ape_materno) from tbl_jefeinmediato where id_jefeInmediato=jefe_inmediato) AS jefe_inmediato,puesto,area_adscripcion,categoria,horas_laborales,tipo_plaza,sindicato,horario_trabajo,sueldo,nivel_estudio,carrera,institucion,estado,anio_egreso,titulo,posgrado,maestria,doctorado\n"
                + "         ,YEAR(CURDATE())-YEAR(fecha_nacimiento) + IF(DATE_FORMAT(CURDATE(),'%m-%d') > DATE_FORMAT(fecha_nacimiento,'%m-%d'), 0 , -1 ) AS edadActual,\n"
                + "         FLOOR(CAST(TIMESTAMPDIFF(day,fecha_ingreso, curdate()) AS float) / 365.25) AS anios_ant, "
                + "    FLOOR((CAST(TIMESTAMPDIFF(day,fecha_ingreso, curdate()) AS float) / 365.25 - FLOOR(CAST(TIMESTAMPDIFF(day,fecha_ingreso,curdate()) AS float) / 365.25)) * 12) as meses_ant,esPadre_Madre\n"
                + "         FROM tbl_empleado\n"
                + "		 INNER JOIN tbl_empleo ON tbl_empleado.id_empleado=tbl_empleo.id_empleado\n"
                + "		 INNER JOIN tbl_formacion_academica ON tbl_empleado.id_empleado=tbl_formacion_academica.id_empleado where tbl_empleado.id_empleado='" + id + "';";
        try {
            psql = conn.prepareStatement(SentenciaSQL);
            rs = psql.executeQuery();
            while (rs.next()) {
                personal = new ModelPersonalN();
                personal.setNumEmpleado(rs.getString(1));
                personal.setAbrev(rs.getString(2));
                personal.setNombres(rs.getString(3));
                personal.setApellidoP(rs.getString(4));
                personal.setApellidoM(rs.getString(5));
                if (rs.getString(6).equals("1")) {
                    personal.setStatus("Activo");
                } else {
                    personal.setStatus("Inactivo");
                }

                personal.setSexo(rs.getString(7));

                // String pasofecha = (formatofecha.format(rs.getDate(8)));
                personal.setFechaNacimiento(rs.getString(8));
                personal.setTelefono(rs.getString(9));
                personal.setCorreoPersonal(rs.getString(10));
                personal.setCorreoInst(rs.getString(11));
                personal.setCURP(rs.getString(12));
                personal.setRFC(rs.getString(13));
                personal.setIMSS(rs.getString(14));
                personal.setEstadoCivil(rs.getString(15));
                personal.setLenguaIndigena(rs.getString(16));
                personal.setDirección(rs.getString(17));
                personal.setColonia(rs.getString(18));
                personal.setLocalidad(rs.getString(19));
                personal.setNombreCEmerg(rs.getString(20));
                personal.setParentestoCEmerg(rs.getString(21));
                personal.setTelefonoCE(rs.getString(22));
                personal.setTipoSangre(rs.getString(23));
                personal.setId(id);
                   
                imgstream = rs.getBinaryStream(24);
                if (imgstream == null) {
                    personal.setIcon(null);
                } else {
                    try {
                        image = ImageIO.read(imgstream);

                        personal.setIcon(new ImageIcon(image));
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }

                personal.setPlantel(rs.getString(25));
                personal.setTipoContratacion(rs.getString(26));
                personal.setCodigo(rs.getString(27));
                // String pasofecha2 = (formatofecha.format(rs.getDate(28)));
                personal.setFechaIngreso(rs.getString(28));
                personal.setFechaTerminoCont(rs.getString(29));
                personal.setJefeInmediato(rs.getString(30));
                personal.setPuesto(rs.getString(31));
                personal.setAreaAdscripción(rs.getString(32));
                personal.setCategoria(rs.getString(33));
                personal.setHorasLaborales(rs.getString(34));
                personal.setTipoPlaza(rs.getString(35));
                personal.setSindicato(rs.getString(36));
                personal.setHorarioTrabajo(rs.getString(37));
                personal.setSueldo(rs.getString(38));
                personal.setNivelEstudios(rs.getString(39));
                personal.setCarreraProfesional(rs.getString(40));
                personal.setNombreInst(rs.getString(41));
                personal.setEntidadFed(rs.getString(42));
                personal.setAnio_egreso(rs.getInt(43));
                personal.setConTitulo(rs.getString(44));
                personal.setConPosgrado(rs.getString(45));
                personal.setConMaestria(rs.getString(46));
                personal.setConDoctorado(rs.getString(47));
                personal.setEDAD(rs.getString(48));
                int antA = rs.getInt(49);
                int antM = rs.getInt(50);
                if (antA < 0) {
                    antM = 0;
                    antA = 0;
                }
                personal.setAnt_añoI(antA);
                personal.setAntmesesI(antM);
                personal.setPadreomadre(rs.getString(51));

                this.showData(personal);
                //    listaPersonal.add(personal);
                // rs.close();
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
//        finally {
//            try {
//                if (conn != null) {
//                    con.cerrar();
//                }
//            } catch (SQLException ex) {
//
//                JOptionPane.showMessageDialog(null, "Error al intentar cerrar la conexión:\n"
//                        + ex, "Error en la operación", JOptionPane.ERROR_MESSAGE);
//            }
        // }
        // return listaPersonal;
    }

    public void ejecutar_archivoPDF(int id) {

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.getConnection().prepareStatement("SELECT formato_FUMP FROM tbl_empleo WHERE id_empleado =?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                b = rs.getBytes(1);

            }

            if (b == null) {

                JOptionPane.showMessageDialog(null, "No hay archivo que mostrar!");
            } else {
                try (InputStream bos = new ByteArrayInputStream(b)) {
                    int tamanoInput = bos.available();

                    byte[] datosPDF = new byte[tamanoInput];
                    bos.read(datosPDF, 0, tamanoInput);

                    OutputStream out = new FileOutputStream("new.pdf");
                    out.write(datosPDF);

                    //abrir archivo
                    out.close();
                }
                ps.close();
                rs.close();
                // cn.desconectar();

            }

        } catch (IOException | NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al abrir archivo PDF " + ex.getMessage());
        }
    }

    public void eliminar(JTable tabla) {
        DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
        int a = tabla.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }
        listDH(tabla);
    }

    public void eliminar_filas(JTable tabla) {
        DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
        int a = tabla.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }

    }

    public ArrayList<ModelDocumentacion> listadodoc() {
        ArrayList listaPersonal = new ArrayList();

        ModelDocumentacion personal;

        String SentenciaSQL = "SELECT id_documento,nombre_documento,fecha_vencimiento from tbl_documentacion where id_empleado='" + this.getId() + "'";

        try {
            psql = conn.prepareStatement(SentenciaSQL);
            rs = psql.executeQuery();
            while (rs.next()) {
                personal = new ModelDocumentacion();

                personal.setId(rs.getInt(1));
                personal.setNombre(rs.getString(2));
                personal.setFechaVencimiento(rs.getString(3));

                listaPersonal.add(personal);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }

        return listaPersonal;
    }

    private void doc_db() {
        int numReg = this.listadodoc().size();

        for (int i = 0; i < numReg; i++) {
            if (this.listadodoc().get(i).getNombre().equals("INE")) {
                lbFINE.setText(this.listadodoc().get(i).getFechaVencimiento());

            }
            if (this.listadodoc().get(i).getNombre().equals("ISSSTE")) {
                lbISSSTE.setText(this.listadodoc().get(i).getFechaVencimiento());
            }

        }
    }

    public ArrayList<ModelCurso> listadodocurso() {
        ArrayList listaPersonal = new ArrayList();

        ModelCurso personal;

        String SentenciaSQL = "SELECT id_curso,nombre_curso,clave_curso,fecha_realizacion FROM  tbl_curso where id_empleado='" + this.getId() + "' and asistencia=1 order by fecha_realizacion;";

        try {
            psql = conn.prepareStatement(SentenciaSQL);
            rs = psql.executeQuery();
            while (rs.next()) {
                personal = new ModelCurso();

                personal.setId_jefe(rs.getString(1));
                personal.setNombreCurso(rs.getString(2));
                personal.setClaveCurso(rs.getString(3));
                personal.setFechaRealizacion(rs.getString(4));

                listaPersonal.add(personal);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }

        return listaPersonal;
    }

    private void llenar_cursos() {
        id = daobaja.idEmpleado(txtNumEmpUp.getText());
        this.setId(id);
        DefaultTableModel modelt = (DefaultTableModel) tbl_curso.getModel();

        int numReg = this.listadodocurso().size();

        Object[] columna = new Object[4];
        for (int i = 0; i < numReg; i++) {
            columna[0] = this.listadodocurso().get(i).getId_jefe();
            columna[1] = this.listadodocurso().get(i).getNombreCurso();
            columna[2] = this.listadodocurso().get(i).getClaveCurso();
            columna[3] = this.listadodocurso().get(i).getFechaRealizacion();
            //   columna[4] = this.listadodocurso().get(i).getNombreEmp();
            modelt.addRow(columna);
        }
    }

    private void doc_db2() {
        int numReg = this.listadodoc().size();
        System.out.println("num " + numReg);
        for (int i = 0; i < numReg; i++) {
            if (this.listadodoc().get(i).getNombre().equals("INE")) {
                lbFINE.setText(this.listadodoc().get(i).getFechaVencimiento());

                System.out.println("fs" + this.listadodoc().get(i).getFechaVencimiento());
            }
            if (this.listadodoc().get(i).getNombre().equals("ISSSTE")) {
                lbISSSTE.setText(this.listadodoc().get(i).getFechaVencimiento());
            }

        }
    }

    public ArrayList<ModelDocumentacion> listado_docentreg() {
        ArrayList listaPersonal = new ArrayList();

        ModelDocumentacion personal;

        String SentenciaSQL = "SELECT * from tbl_documentoentregado where id_empleado='" + this.getId() + "'";

        try {
            psql = conn.prepareStatement(SentenciaSQL);
            rs = psql.executeQuery();
            while (rs.next()) {
                personal = new ModelDocumentacion();

                personal.setId(rs.getInt(1));
                personal.setNombre(rs.getString(2));
                personal.setFechaVencimiento(rs.getString(3));

                listaPersonal.add(personal);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }

        return listaPersonal;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        txtNumEmpUp = new com.swing.JCTextField();
        jButton2 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jp = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        datosGen = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        editarDG = new javax.swing.JButton();
        lbNombre = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbSexo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbFechaNac = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbTelefono = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbEstadoCivil = new javax.swing.JLabel();
        lbIMSS = new javax.swing.JLabel();
        lbRFC = new javax.swing.JLabel();
        lbCURP = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbCorreo = new javax.swing.JLabel();
        labelStatus1 = new com.table.status.LabelStatus();
        imageAvatar1 = new com.swing.ImageAvatar();
        lbCorreoInst = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbTipoSangre = new javax.swing.JLabel();
        lbLengua = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbDireccion = new javax.swing.JLabel();
        lbNumEmp = new javax.swing.JLabel();
        lcContactoE = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        lbEdad = new javax.swing.JLabel();
        lbAntiguedad = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lbEsMadre_padre = new javax.swing.JLabel();
        lbpadre_madre = new javax.swing.JLabel();
        datosLaborales = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        lbPlantel = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbCodigo = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        lbTipoPlaza = new javax.swing.JLabel();
        lbSindicato = new javax.swing.JLabel();
        lbFechaIngreso = new javax.swing.JLabel();
        lbSueldo = new javax.swing.JLabel();
        lbHorario = new javax.swing.JLabel();
        lbTermCont = new javax.swing.JLabel();
        lbCategoria = new javax.swing.JLabel();
        lbPuesto = new javax.swing.JLabel();
        lbArea = new javax.swing.JLabel();
        lbHoras = new javax.swing.JLabel();
        lbJefe = new javax.swing.JLabel();
        lbtype = new com.table.status.LabelType();
        jLabel18 = new javax.swing.JLabel();
        editarDL = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnHistorial = new javax.swing.JButton();
        datosFormacion = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        lbNivelEst = new javax.swing.JLabel();
        lbNombreInst = new javax.swing.JLabel();
        lbCarrera = new javax.swing.JLabel();
        lbEntidad = new javax.swing.JLabel();
        lbAño = new javax.swing.JLabel();
        lbMaestria = new javax.swing.JLabel();
        lbDoctorado = new javax.swing.JLabel();
        lbPosgrado = new javax.swing.JLabel();
        lbTitulo = new javax.swing.JLabel();
        editarFA = new javax.swing.JButton();
        Farmacias = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableDH = new javax.swing.JTable();
        editarDH = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableDoc = new javax.swing.JTable();
        jLabel34 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        lbFINE = new javax.swing.JLabel();
        lbISSSTE = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_curso = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1149, 538));
        setLayout(new java.awt.GridBagLayout());

        jPanel2.setOpaque(false);

        txtNumEmpUp.setPlaceholder("Buscar por No. emp.");
        txtNumEmpUp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumEmpUpKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumEmpUpKeyTyped(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/search_30px.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(590, 590, 590)
                .addComponent(txtNumEmpUp, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton2))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNumEmpUp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 139, 0, 0);
        add(jPanel2, gridBagConstraints);

        jTabbedPane1.setForeground(java.awt.SystemColor.textHighlight);
        jTabbedPane1.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N

        jp.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        datosGen.setBackground(new java.awt.Color(253, 253, 253));
        datosGen.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Personales\n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins", 1, 14), new java.awt.Color(0, 51, 102))); // NOI18N
        datosGen.setForeground(new java.awt.Color(0, 0, 51));

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Nombre Completo:");

        editarDG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/edit.png"))); // NOI18N
        editarDG.setText("Editar");
        editarDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarDGActionPerformed(evt);
            }
        });

        lbNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbNombre.setForeground(new java.awt.Color(0, 102, 153));
        lbNombre.setText("lbNom");

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Sexo:");

        lbSexo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbSexo.setForeground(new java.awt.Color(0, 102, 153));
        lbSexo.setText("lbSexo");

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Fecha de nacimiento:");

        lbFechaNac.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbFechaNac.setForeground(new java.awt.Color(0, 102, 153));
        lbFechaNac.setText("lbFechaNac");

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Teléfono:");

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("IMSS:");

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Estado Civil:");

        lbTelefono.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTelefono.setForeground(new java.awt.Color(0, 102, 153));
        lbTelefono.setText("tel");

        jLabel9.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("RFC:");

        jLabel10.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("CURP:");

        lbEstadoCivil.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbEstadoCivil.setForeground(new java.awt.Color(0, 102, 153));
        lbEstadoCivil.setText("jLabel11");

        lbIMSS.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbIMSS.setForeground(new java.awt.Color(0, 102, 153));
        lbIMSS.setText("imss");

        lbRFC.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbRFC.setForeground(new java.awt.Color(0, 102, 153));
        lbRFC.setText("lbRFC");

        lbCURP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbCURP.setForeground(new java.awt.Color(0, 102, 153));
        lbCURP.setText("lbcurp");

        jLabel8.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Correo Personal: ");

        lbCorreo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbCorreo.setForeground(new java.awt.Color(0, 102, 153));
        lbCorreo.setText("correo");

        labelStatus1.setText("Activo");
        labelStatus1.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N

        lbCorreoInst.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbCorreoInst.setForeground(new java.awt.Color(0, 102, 153));
        lbCorreoInst.setText("lbCorreoinst");

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText(" Correo Institucional:");

        jLabel11.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Tipo de Sangre");

        lbTipoSangre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTipoSangre.setForeground(new java.awt.Color(0, 102, 153));
        lbTipoSangre.setText("tipos");

        lbLengua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbLengua.setForeground(new java.awt.Color(0, 102, 153));
        lbLengua.setText("lengua");

        jLabel14.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Dirección:");

        lbDireccion.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        lbDireccion.setForeground(new java.awt.Color(0, 102, 204));
        lbDireccion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbDireccion.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lbNumEmp.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbNumEmp.setForeground(new java.awt.Color(0, 51, 153));
        lbNumEmp.setText("001");

        lcContactoE.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lcContactoE.setForeground(new java.awt.Color(0, 102, 153));
        lcContactoE.setText("contacto");
        lcContactoE.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel12.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Lengua Indigena:");

        jLabel19.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("<html>\n<P align=\"right\">\nEn caso de emergencia contactar a:</html>");
        jLabel19.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel19.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabel27.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel27.setText("Edad Actual:");

        jLabel28.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel28.setText("Antigüedad:");

        lbEdad.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        lbEdad.setForeground(new java.awt.Color(255, 51, 0));
        lbEdad.setText("00");

        lbAntiguedad.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        lbAntiguedad.setForeground(new java.awt.Color(255, 51, 0));
        lbAntiguedad.setText("00");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/icons8-instalando-actualizaciones-25.png"))); // NOI18N
        jButton1.setText("Descargar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lbEsMadre_padre.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        lbEsMadre_padre.setForeground(new java.awt.Color(51, 51, 51));
        lbEsMadre_padre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbEsMadre_padre.setText("Es madre:");

        lbpadre_madre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbpadre_madre.setForeground(new java.awt.Color(0, 102, 153));
        lbpadre_madre.setText("jLabel11");

        javax.swing.GroupLayout datosGenLayout = new javax.swing.GroupLayout(datosGen);
        datosGen.setLayout(datosGenLayout);
        datosGenLayout.setHorizontalGroup(
            datosGenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosGenLayout.createSequentialGroup()
                .addGroup(datosGenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(datosGenLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel1))
                    .addGroup(datosGenLayout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jLabel2))
                    .addGroup(datosGenLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel3))
                    .addGroup(datosGenLayout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jLabel5))
                    .addGroup(datosGenLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel8))
                    .addGroup(datosGenLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(datosGenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNombre)
                    .addComponent(lbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCorreo)
                    .addComponent(lbCorreoInst)
                    .addComponent(lcContactoE, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(118, 118, 118)
                .addGroup(datosGenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(datosGenLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel6))
                    .addGroup(datosGenLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jLabel9))
                    .addGroup(datosGenLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel10))
                    .addGroup(datosGenLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel7))
                    .addGroup(datosGenLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(datosGenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(datosGenLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(lbEsMadre_padre))))
                    .addComponent(jLabel12)
                    .addGroup(datosGenLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel14)))
                .addGap(6, 6, 6)
                .addGroup(datosGenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbIMSS)
                    .addComponent(lbRFC)
                    .addComponent(lbCURP)
                    .addComponent(lbEstadoCivil)
                    .addComponent(lbpadre_madre)
                    .addComponent(lbTipoSangre)
                    .addComponent(lbLengua)
                    .addComponent(lbDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(datosGenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(datosGenLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(labelStatus1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(datosGenLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(lbNumEmp))
                    .addGroup(datosGenLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(datosGenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28))
                        .addGap(5, 5, 5)
                        .addGroup(datosGenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbEdad)
                            .addComponent(lbAntiguedad))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosGenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(editarDG, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        datosGenLayout.setVerticalGroup(
            datosGenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosGenLayout.createSequentialGroup()
                .addGroup(datosGenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(datosGenLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel2)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel3)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel5)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel8)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(datosGenLayout.createSequentialGroup()
                        .addComponent(lbNombre)
                        .addGap(10, 10, 10)
                        .addComponent(lbSexo)
                        .addGap(10, 10, 10)
                        .addComponent(lbFechaNac)
                        .addGap(13, 13, 13)
                        .addComponent(lbTelefono)
                        .addGap(9, 9, 9)
                        .addComponent(lbCorreo)
                        .addGap(8, 8, 8)
                        .addComponent(lbCorreoInst)
                        .addGap(13, 13, 13)
                        .addComponent(lcContactoE, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(datosGenLayout.createSequentialGroup()
                        .addGroup(datosGenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNumEmp)
                            .addGroup(datosGenLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(labelStatus1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(datosGenLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(editarDG)
                                .addGap(18, 18, 18)
                                .addGroup(datosGenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1)
                                    .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(10, 10, 10)
                        .addGroup(datosGenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(lbEdad)
                            .addGroup(datosGenLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(datosGenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel28)
                                    .addComponent(lbAntiguedad)))))
                    .addGroup(datosGenLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(datosGenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(datosGenLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(8, 8, 8)
                                .addComponent(jLabel9)
                                .addGap(8, 8, 8)
                                .addComponent(jLabel10)
                                .addGap(6, 6, 6)
                                .addComponent(jLabel7)
                                .addGap(6, 6, 6)
                                .addGroup(datosGenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(datosGenLayout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(jLabel11))
                                    .addComponent(lbEsMadre_padre))
                                .addGap(6, 6, 6)
                                .addComponent(jLabel12)
                                .addGap(2, 2, 2)
                                .addComponent(jLabel14))
                            .addGroup(datosGenLayout.createSequentialGroup()
                                .addComponent(lbIMSS)
                                .addGap(10, 10, 10)
                                .addComponent(lbRFC)
                                .addGap(10, 10, 10)
                                .addComponent(lbCURP)
                                .addGap(8, 8, 8)
                                .addComponent(lbEstadoCivil)
                                .addGap(8, 8, 8)
                                .addComponent(lbpadre_madre)
                                .addGap(1, 1, 1)
                                .addComponent(lbTipoSangre)
                                .addGap(8, 8, 8)
                                .addComponent(lbLengua)
                                .addGap(4, 4, 4)
                                .addComponent(lbDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );

        datosLaborales.setBackground(new java.awt.Color(255, 255, 255));
        datosLaborales.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Laborales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(0, 51, 102))); // NOI18N
        datosLaborales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Plantel:");
        datosLaborales.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, -1, -1));

        lbPlantel.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        lbPlantel.setForeground(new java.awt.Color(0, 102, 153));
        lbPlantel.setText("lbPlantel");
        datosLaborales.add(lbPlantel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, -1, -1));

        jLabel15.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Código:");
        datosLaborales.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, -1));

        lbCodigo.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        lbCodigo.setForeground(new java.awt.Color(0, 102, 153));
        lbCodigo.setText("lbCodigo");
        datosLaborales.add(lbCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, -1, -1));

        jLabel17.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("Fecha Ingreso:");
        datosLaborales.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, -1));

        jLabel82.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(51, 51, 51));
        jLabel82.setText("Terminación de Contrato:");
        datosLaborales.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, -1, -1));

        jLabel74.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(51, 51, 51));
        jLabel74.setText("Jefe Inmediato:");
        datosLaborales.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, -1, -1));

        jLabel72.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(51, 51, 51));
        jLabel72.setText("Puesto Laboral:");
        datosLaborales.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, -1, -1));

        jLabel77.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(51, 51, 51));
        jLabel77.setText("Área de Adscripcion:");
        datosLaborales.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, -1, -1));

        jLabel80.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(51, 51, 51));
        jLabel80.setText("Categoria:");
        datosLaborales.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, -1, -1));

        jLabel73.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(51, 51, 51));
        jLabel73.setText("Horas Laborales:");
        datosLaborales.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, -1, -1));

        jLabel75.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(51, 51, 51));
        jLabel75.setText("Tipo de Plaza:");
        datosLaborales.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));

        jLabel78.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(51, 51, 51));
        jLabel78.setText("Sindicato:");
        datosLaborales.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, -1, -1));

        jLabel76.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(51, 51, 51));
        jLabel76.setText("Horario de Trabajo:");
        datosLaborales.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        jLabel79.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(51, 51, 51));
        jLabel79.setText("Monto Mensual:");
        datosLaborales.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, -1));

        lbTipoPlaza.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        lbTipoPlaza.setForeground(new java.awt.Color(0, 102, 153));
        lbTipoPlaza.setText("plaza");
        datosLaborales.add(lbTipoPlaza, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, -1, -1));

        lbSindicato.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        lbSindicato.setForeground(new java.awt.Color(0, 102, 153));
        lbSindicato.setText("sindicato");
        datosLaborales.add(lbSindicato, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, -1, -1));

        lbFechaIngreso.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        lbFechaIngreso.setForeground(new java.awt.Color(0, 102, 153));
        lbFechaIngreso.setText("fecha");
        datosLaborales.add(lbFechaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, -1, -1));

        lbSueldo.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        lbSueldo.setForeground(new java.awt.Color(0, 102, 153));
        lbSueldo.setText("m");
        datosLaborales.add(lbSueldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, -1, -1));

        lbHorario.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        lbHorario.setForeground(new java.awt.Color(0, 102, 153));
        lbHorario.setText("h");
        datosLaborales.add(lbHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, -1, -1));

        lbTermCont.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        lbTermCont.setForeground(new java.awt.Color(255, 153, 0));
        lbTermCont.setText("jLabel18");
        datosLaborales.add(lbTermCont, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 40, -1, -1));

        lbCategoria.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        lbCategoria.setForeground(new java.awt.Color(0, 102, 153));
        lbCategoria.setText("ca");
        datosLaborales.add(lbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, -1, -1));

        lbPuesto.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        lbPuesto.setForeground(new java.awt.Color(0, 102, 153));
        lbPuesto.setText("jLabel18");
        datosLaborales.add(lbPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 110, -1, -1));

        lbArea.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        lbArea.setForeground(new java.awt.Color(0, 102, 153));
        lbArea.setText("jLabel18");
        datosLaborales.add(lbArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 140, -1, -1));

        lbHoras.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        lbHoras.setForeground(new java.awt.Color(0, 102, 153));
        lbHoras.setText("jLabel18");
        datosLaborales.add(lbHoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 170, -1, -1));

        lbJefe.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        lbJefe.setForeground(new java.awt.Color(0, 102, 153));
        lbJefe.setText("jLabel18");
        datosLaborales.add(lbJefe, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 200, -1, -1));

        lbtype.setText("labelType1");
        lbtype.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        datosLaborales.add(lbtype, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 40, 110, -1));

        jLabel18.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel18.setText("Tipo:");
        datosLaborales.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 40, -1, -1));

        editarDL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/edit.png"))); // NOI18N
        editarDL.setText("Editar");
        editarDL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarDLActionPerformed(evt);
            }
        });
        datosLaborales.add(editarDL, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 10, 102, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/eye.png"))); // NOI18N
        jButton3.setText("Ver FUMP");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        datosLaborales.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 210, 120, -1));

        btnHistorial.setText("Historial de Cambios de Puesto");
        datosLaborales.add(btnHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 240, -1, -1));

        datosFormacion.setBackground(new java.awt.Color(255, 255, 255));
        datosFormacion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Formación Académica", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins", 1, 14), new java.awt.Color(0, 51, 102))); // NOI18N

        jLabel16.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Nivel de Estudios:");

        jLabel20.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 51, 51));
        jLabel20.setText("Carrera Profesional:");

        jLabel21.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setText("Nombre de la Institución: ");

        jLabel22.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(51, 51, 51));
        jLabel22.setText("Entidad Federativa:");

        jLabel23.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(51, 51, 51));
        jLabel23.setText("Año de Egreso:");

        jLabel24.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(51, 51, 51));
        jLabel24.setText("¿Cuenta conTitulo?");

        jLabel33.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(51, 51, 51));
        jLabel33.setText("¿Tiene Posgrado?");

        jLabel25.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(51, 51, 51));
        jLabel25.setText("¿Tiene Maestría?");

        jLabel55.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(51, 51, 51));
        jLabel55.setText("¿Tiene doctorado?");

        lbNivelEst.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        lbNivelEst.setForeground(new java.awt.Color(0, 102, 153));
        lbNivelEst.setText("jLabel26");

        lbNombreInst.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        lbNombreInst.setForeground(new java.awt.Color(0, 102, 153));
        lbNombreInst.setText("lb");

        lbCarrera.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        lbCarrera.setForeground(new java.awt.Color(0, 102, 153));
        lbCarrera.setText("jLabel26");

        lbEntidad.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        lbEntidad.setForeground(new java.awt.Color(0, 102, 153));
        lbEntidad.setText("jLabel26");

        lbAño.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        lbAño.setForeground(new java.awt.Color(0, 102, 153));
        lbAño.setText("jLabel26");

        lbMaestria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/check_circle_20px.png"))); // NOI18N

        lbDoctorado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/check_circle_20px.png"))); // NOI18N

        lbPosgrado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/check_circle_20px.png"))); // NOI18N

        lbTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/Close.png"))); // NOI18N

        editarFA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/edit.png"))); // NOI18N
        editarFA.setText("Editar");
        editarFA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarFAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout datosFormacionLayout = new javax.swing.GroupLayout(datosFormacion);
        datosFormacion.setLayout(datosFormacionLayout);
        datosFormacionLayout.setHorizontalGroup(
            datosFormacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosFormacionLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(datosFormacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21)
                    .addComponent(jLabel16)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addGroup(datosFormacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(datosFormacionLayout.createSequentialGroup()
                        .addGroup(datosFormacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNivelEst)
                            .addComponent(lbNombreInst)
                            .addComponent(lbCarrera)
                            .addComponent(lbEntidad))
                        .addGap(197, 197, 197)
                        .addGroup(datosFormacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(datosFormacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel33)
                                .addGroup(datosFormacionLayout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(jLabel25)))
                            .addComponent(jLabel55)
                            .addGroup(datosFormacionLayout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addGap(4, 4, 4)))
                        .addGroup(datosFormacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(datosFormacionLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(datosFormacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(datosFormacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lbPosgrado, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbDoctorado))
                                    .addGroup(datosFormacionLayout.createSequentialGroup()
                                        .addComponent(lbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(editarFA, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(datosFormacionLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbMaestria, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(lbAño))
                .addContainerGap())
        );
        datosFormacionLayout.setVerticalGroup(
            datosFormacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, datosFormacionLayout.createSequentialGroup()
                .addGroup(datosFormacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(datosFormacionLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lbTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(datosFormacionLayout.createSequentialGroup()
                        .addGroup(datosFormacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(datosFormacionLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(datosFormacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbNivelEst)))
                            .addGroup(datosFormacionLayout.createSequentialGroup()
                                .addComponent(editarFA)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(datosFormacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(datosFormacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21)
                        .addComponent(lbNombreInst))
                    .addComponent(lbPosgrado)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(datosFormacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, datosFormacionLayout.createSequentialGroup()
                        .addGroup(datosFormacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(lbMaestria)
                            .addGroup(datosFormacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel20)
                                .addComponent(lbCarrera)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(datosFormacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(jLabel55)
                            .addComponent(lbEntidad)))
                    .addComponent(lbDoctorado, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(datosFormacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(lbAño))
                .addGap(21, 21, 21))
        );

        Farmacias.setBackground(new java.awt.Color(255, 255, 255));
        Farmacias.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Farmacias", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins", 1, 14), new java.awt.Color(0, 102, 153))); // NOI18N

        tableDH.setAutoCreateRowSorter(true);
        tableDH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableDH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre Completo", "Fecha Nacimiento", "Sexo", "Parentesco", "Edad Actual", "Estatus"
            }
        ));
        jScrollPane2.setViewportView(tableDH);
        if (tableDH.getColumnModel().getColumnCount() > 0) {
            tableDH.getColumnModel().getColumn(0).setResizable(false);
            tableDH.getColumnModel().getColumn(0).setPreferredWidth(30);
            tableDH.getColumnModel().getColumn(1).setPreferredWidth(200);
            tableDH.getColumnModel().getColumn(2).setPreferredWidth(200);
            tableDH.getColumnModel().getColumn(3).setPreferredWidth(70);
            tableDH.getColumnModel().getColumn(4).setPreferredWidth(90);
            tableDH.getColumnModel().getColumn(5).setPreferredWidth(150);
            tableDH.getColumnModel().getColumn(6).setPreferredWidth(80);
        }

        editarDH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/edit.png"))); // NOI18N
        editarDH.setText("Editar");
        editarDH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarDHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FarmaciasLayout = new javax.swing.GroupLayout(Farmacias);
        Farmacias.setLayout(FarmaciasLayout);
        FarmaciasLayout.setHorizontalGroup(
            FarmaciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FarmaciasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editarDH, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        FarmaciasLayout.setVerticalGroup(
            FarmaciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FarmaciasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
            .addGroup(FarmaciasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(editarDH)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(datosGen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(datosLaborales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(datosFormacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Farmacias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(datosGen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(datosLaborales, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(datosFormacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Farmacias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jp.setViewportView(jPanel5);
        jPanel5.getAccessibleContext().setAccessibleParent(this);

        jTabbedPane1.addTab("Datos", jp);
        jp.getAccessibleContext().setAccessibleParent(this);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setText("Declaración");
        jPanel3.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(578, 211, -1, -1));

        jLabel29.setText("Contrato");
        jPanel3.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(578, 186, -1, -1));

        jLabel32.setText("Documentos entregados:");
        jPanel3.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 132, -1, -1));

        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

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
        jScrollPane3.setViewportView(tableDoc);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 480, 310));

        jLabel34.setText("Vigencia de Credencial de Elector (INE)");
        jPanel3.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(423, 57, -1, -1));

        jLabel36.setText("Vigencia del ISSSTE:");
        jPanel3.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 112, -1, -1));

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/google_drive.png"))); // NOI18N
        jLabel38.setText("<html>Link de documentación : <a href=\\\"\\\">Google Drive</a></html>");
        jPanel3.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 227, 24));

        lbFINE.setForeground(new java.awt.Color(255, 153, 0));
        jPanel3.add(lbFINE, new org.netbeans.lib.awtextra.AbsoluteConstraints(627, 57, 123, 22));

        lbISSSTE.setForeground(new java.awt.Color(255, 153, 0));
        jPanel3.add(lbISSSTE, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 110, 120, 20));

        jTabbedPane1.addTab("Documentos", jPanel3);

        jLabel30.setText("Cursos que ha tomado:");

        tbl_curso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Curso", "Fecha realización"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_curso);
        if (tbl_curso.getColumnModel().getColumnCount() > 0) {
            tbl_curso.getColumnModel().getColumn(0).setPreferredWidth(30);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(295, 295, 295)
                        .addComponent(jLabel30)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel30)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cursos", jPanel4);

        jPanel6.setOpaque(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 745, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(471, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(164, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Incidencias", jPanel6);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 461;
        gridBagConstraints.ipady = 126;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        add(jTabbedPane1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNumEmpUpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumEmpUpKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txtNumEmpUp.getText().isEmpty()) {
                cleantxt();
                DefaultTableModel tb = (DefaultTableModel) tableDH.getModel();
                int a = tableDH.getRowCount() - 1;
                for (int i = a; i >= 0; i--) {
                    tb.removeRow(tb.getRowCount() - 1);
                }
            } else {
                id = daobaja.idEmpleado(txtNumEmpUp.getText());
                this.FullDatabyId(id);
                eliminar(tableDH);
                this.setId(id);
                doc_db();
                eliminar_filas(tbl_curso);
                llenar_cursos();
            }

        }

    }//GEN-LAST:event_txtNumEmpUpKeyReleased

    private void txtNumEmpUpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumEmpUpKeyTyped

    }//GEN-LAST:event_txtNumEmpUpKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed


    }//GEN-LAST:event_jButton2ActionPerformed

    private void editarDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarDGActionPerformed
        if (txtNumEmpUp.getText().isEmpty()) {
            cleantxt();
            JOptionPane.showMessageDialog(null, "Empy data");
        } else {

            editarDG dialog = new editarDG(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    dialog.setVisible(false);
                }
            });
            dialog.setId(id);
            dialog.editData(personal);
            dialog.setVisible(true);
        }


    }//GEN-LAST:event_editarDGActionPerformed

    private void editarDLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarDLActionPerformed
        ConsultasJAP jap = new ConsultasJAP();
        editarDL dialog = new editarDL(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                dialog.setVisible(false);
            }
        });
        jap.ObteberArea(dialog.cmbArea);
        jap.ObteberJefe(dialog.cmbJefe);
        jap.ObteberPuestos(dialog.cmbPuesto);

        dialog.showData(personal);
        dialog.setId(id);
        dialog.setVisible(true);
    }//GEN-LAST:event_editarDLActionPerformed

    private void editarFAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarFAActionPerformed
        editarFA dialog = new editarFA(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                dialog.setVisible(false);
            }
        });
        String[] estadoq = {" ", "Aguascalientes", "Baja California", "Baja California Sur", "Campeche", "Chiapas", "Chihuahua", "Coahuila de Zaragoza", "Colima", "Ciudad de México", "Durango", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco", "Estado de Mexico", "Michoacan de Ocampo", "Morelos", "Nayarit", "Nuevo Leon", "Oaxaca", "Puebla", "Queretaro de Arteaga", "Quintana Roo", "San Luis Potosi", "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz de Ignacio de la Llave", "Yucatan", "Zacatecas"};
        dialog.cmbEstados.setModel(new javax.swing.DefaultComboBoxModel<>(estadoq));
        dialog.setId(id);
        dialog.showFA(personal);
        dialog.setVisible(true);

    }//GEN-LAST:event_editarFAActionPerformed

    private void editarDHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarDHActionPerformed
        editarDH dialog = new editarDH(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                dialog.setVisible(false);
            }
        });
        dialog.setId_emp(id);
        this.listDH(dialog.tbl_derechohabiente);
        dialog.setVisible(true);
    }//GEN-LAST:event_editarDHActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo de imagen", "png", "jpg");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar imagen");
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            String ruta = chooser.getSelectedFile().toString().concat(".png");
//     FileOutputStream fos = null;
            try {
                File photo = new File(ruta);
                ImageIO.write((RenderedImage) image, "png", photo);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        if (b == null) {
            JOptionPane.showMessageDialog(null, "No hay archivo");
        } else {

            ejecutar_archivoPDF(id);
            try {
                Desktop.getDesktop().open(new File("new.pdf"));
            } catch (Exception ex) {
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Farmacias;
    private javax.swing.JButton btnHistorial;
    private javax.swing.JPanel datosFormacion;
    private javax.swing.JPanel datosGen;
    private javax.swing.JPanel datosLaborales;
    private javax.swing.JButton editarDG;
    private javax.swing.JButton editarDH;
    private javax.swing.JButton editarDL;
    private javax.swing.JButton editarFA;
    private com.swing.ImageAvatar imageAvatar1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
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
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JScrollPane jp;
    private com.table.status.LabelStatus labelStatus1;
    private javax.swing.JLabel lbAntiguedad;
    private javax.swing.JLabel lbArea;
    private javax.swing.JLabel lbAño;
    private javax.swing.JLabel lbCURP;
    private javax.swing.JLabel lbCarrera;
    private javax.swing.JLabel lbCategoria;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbCorreo;
    private javax.swing.JLabel lbCorreoInst;
    private javax.swing.JLabel lbDireccion;
    private javax.swing.JLabel lbDoctorado;
    private javax.swing.JLabel lbEdad;
    private javax.swing.JLabel lbEntidad;
    private javax.swing.JLabel lbEsMadre_padre;
    private javax.swing.JLabel lbEstadoCivil;
    private javax.swing.JLabel lbFINE;
    private javax.swing.JLabel lbFechaIngreso;
    private javax.swing.JLabel lbFechaNac;
    private javax.swing.JLabel lbHorario;
    private javax.swing.JLabel lbHoras;
    private javax.swing.JLabel lbIMSS;
    private javax.swing.JLabel lbISSSTE;
    private javax.swing.JLabel lbJefe;
    private javax.swing.JLabel lbLengua;
    private javax.swing.JLabel lbMaestria;
    private javax.swing.JLabel lbNivelEst;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbNombreInst;
    private javax.swing.JLabel lbNumEmp;
    private javax.swing.JLabel lbPlantel;
    private javax.swing.JLabel lbPosgrado;
    private javax.swing.JLabel lbPuesto;
    private javax.swing.JLabel lbRFC;
    private javax.swing.JLabel lbSexo;
    private javax.swing.JLabel lbSindicato;
    private javax.swing.JLabel lbSueldo;
    private javax.swing.JLabel lbTelefono;
    private javax.swing.JLabel lbTermCont;
    private javax.swing.JLabel lbTipoPlaza;
    private javax.swing.JLabel lbTipoSangre;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JLabel lbpadre_madre;
    private com.table.status.LabelType lbtype;
    private javax.swing.JLabel lcContactoE;
    private javax.swing.JTable tableDH;
    private javax.swing.JTable tableDoc;
    private javax.swing.JTable tbl_curso;
    private com.swing.JCTextField txtNumEmpUp;
    // End of variables declaration//GEN-END:variables
}
