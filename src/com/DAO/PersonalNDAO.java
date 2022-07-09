package com.DAO;

import com.connection.Conexion;
import com.model.ModelPersonalN;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PersonalNDAO {

    String num;

    public void setNum(String num) {
        this.num = num;
    }
    Conexion con = new Conexion();
    PreparedStatement psql;
    ResultSet rs;
    Connection conn = con.getConnection();
    ModelPersonalN model = new ModelPersonalN();

    public boolean GuardarPersonal(ModelPersonalN dtPersonal) throws FileNotFoundException {

        String SentenciaSQL = "INSERT INTO tbl_empleado (num_empleado,abrev_nombre,nombre,ape_paterno,ape_materno,status,genero,fecha_nacimiento,telefono,correo_personal,correo_institucional,curp,rfc,imss,estado_civil,lengua_indigena,direccion,colonia,localidad,contacto_emergencia,parent_emerg,telefono_CE,tipo_sangre,foto_emp)"
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
           File image = new File(dtPersonal.getFoto_paht());
        //ruta puede ser: "/home/cmop/Desktop/1.jpg"
        FileInputStream fis = new FileInputStream(image);
        //Lo convertimos en un Stream
      
            psql = conn.prepareStatement(SentenciaSQL);

            // psql.setInt(1,0);
            psql.setString(1, dtPersonal.getNum_empleado());
            psql.setString(2, dtPersonal.getAbrev());
            psql.setString(3, dtPersonal.getNombres());
            psql.setString(4, dtPersonal.getApellidoP());
            psql.setString(5, dtPersonal.getApellidoM());
            psql.setInt(6, 1);
            psql.setString(7, dtPersonal.getSexo());
            //  psql.setDate(7, FechaNacimiento);
            //eliminamos la columna edad
            psql.setString(8, dtPersonal.getFechaNacimiento());
            psql.setString(9, dtPersonal.getTelefono());
            psql.setString(10, dtPersonal.getCorreoPersonal());
            psql.setString(11, dtPersonal.getCorreoInst());
            psql.setString(12, dtPersonal.getCURP());
            psql.setString(13, dtPersonal.getRFC());
            psql.setString(14, dtPersonal.getIMSS());
            psql.setString(15, dtPersonal.getEstadoCivil());
            psql.setString(16, dtPersonal.getLenguaIndigena());
            psql.setString(17, dtPersonal.getDirección());
            psql.setString(18, dtPersonal.getColonia());
            psql.setString(19, dtPersonal.getLocalidad());
            psql.setString(20, dtPersonal.getNombreCEmerg());
            psql.setString(21, dtPersonal.getParentestoCEmerg());
            psql.setString(22, dtPersonal.getTelefonoCE());
            psql.setString(23, dtPersonal.getTipoSangre());
           psql.setBinaryStream(24, fis, (int) image.length());

            psql.execute();
            psql.close();
            return true;
        } catch (SQLException ex) {

            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public ArrayList<ModelPersonalN> listPersonalR() {
        ArrayList listaPersonal = new ArrayList();
        ModelPersonalN personal;

        String SentenciaSQL = "select tbl_empleado.*,tbl_empleo.fecha_ingreso,tbl_empleo.area_adscripcion,tbl_empleo.jefe_inmediato from tbl_empleado,tbl_empleo where tbl_empleado.id_empleado=tbl_empleo.id_empleado";

        try {
            psql = conn.prepareStatement(SentenciaSQL);
            rs = psql.executeQuery();
            while (rs.next()) {
                personal = new ModelPersonalN();

                personal.setId(rs.getInt(1));
                personal.setNum_empleado(rs.getString(2));
                personal.setAbrev(rs.getString(3));
                personal.setNombres(rs.getString(4));
                personal.setApellidoP(rs.getString(5));
                personal.setApellidoM(rs.getString(6));
                personal.setEstadoi(rs.getInt(7));

                personal.setSexo(rs.getString(8));
                personal.setFechaNacimiento(rs.getString(9));
                personal.setTelefono(rs.getString(10));
                personal.setCorreoPersonal(rs.getString(11));
                personal.setCorreoInst(rs.getString(12));
                personal.setCURP(rs.getString(13));
                personal.setRFC(rs.getString(14));
                personal.setIMSS(rs.getString(15));
                personal.setEstadoCivil(rs.getString(16));
                personal.setLenguaIndigena(rs.getString(17));
                personal.setDirección(rs.getString(18));
                personal.setColonia(rs.getString(19));
                personal.setLocalidad(rs.getString(20));
                personal.setNombreCEmerg(rs.getString(21));
                personal.setParentestoCEmerg(rs.getString(22));
                personal.setTelefonoCE(rs.getString(23));
                personal.setTipoSangre(rs.getString(24));
                personal.setFechaIngreso(rs.getString(25));
                personal.setAreaAdscripción(rs.getString(26));
                personal.setJefeInmediato(rs.getString(27));

                listaPersonal.add(personal);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
//        } finally {
//            try {
//                if (conn != null) {
//                    con.cerrar();
//                }
//            } catch (SQLException ex) {
//
//                JOptionPane.showMessageDialog(null, "Error al intentar cerrar la conexión:\n"
//                        + ex, "Error en la operación", JOptionPane.ERROR_MESSAGE);
//            }
//        }
        return listaPersonal;
    }

    public ArrayList<ModelPersonalN> listPersonalPerfil(String num) {
        ArrayList listaPersonal = new ArrayList();

        ModelPersonalN personal;

        String SentenciaSQL = "select tbl_empleado.*,tbl_empleo.fecha_ingreso,tbl_empleo.area_adscripcion,tbl_empleo.jefe_inmediato from tbl_empleado,tbl_empleo where tbl_empleado.num_empleado='" + num + "'";

        try {
            psql = conn.prepareStatement(SentenciaSQL);
            rs = psql.executeQuery();
            while (rs.next()) {
                personal = new ModelPersonalN();

                personal.setId(rs.getInt(1));
                personal.setNum_empleado(rs.getString(2));
                personal.setAbrev(rs.getString(3));
                personal.setNombres(rs.getString(4));
                personal.setApellidoP(rs.getString(5));
                personal.setApellidoM(rs.getString(6));
                personal.setSexo(rs.getString(7));
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
                personal.setFechaIngreso(rs.getString(24));
                personal.setAreaAdscripción(rs.getString(25));
                personal.setJefeInmediato(rs.getString(26));

                listaPersonal.add(personal);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
//        } finally {
//            try {
//                if (conn != null) {
//                    con.cerrar();
//                }
//            } catch (SQLException ex) {
//
//                JOptionPane.showMessageDialog(null, "Error al intentar cerrar la conexión:\n"
//                        + ex, "Error en la operación", JOptionPane.ERROR_MESSAGE);
//            }
//        }
        return listaPersonal;
    }

    public void editarDatosG(ModelPersonalN dtPersonal) {
        int resultado = 0;

        String SentenciaSQL = "UPDATE tbl_empleado SET num_empleado=?,abrev_nombre=?,nombre=?,ape_materno=?,ape_paterno=?,genero=?,fecha_nacimiento=?,telefono=?,correo_personal=?,correo_institucional=?,curp=?,rfc=?,imss=?,estado_civil=?,lengua_indigena=?,direccion=?,colonia=?,localidad=?,contacto_emergencia=?,parent_emerg=?,telefono_CE=?,tipo_sangre=? WHERE num_empleado='" + dtPersonal.getNumEmpleado() + "'";

        try {

            psql = conn.prepareStatement(SentenciaSQL);
            //psql.setInt(1,0);
            psql.setString(1, dtPersonal.getNum_empleado());
            psql.setString(2, dtPersonal.getAbrev());
            psql.setString(3, dtPersonal.getNombres());
            psql.setString(4, dtPersonal.getApellidoP());
            psql.setString(5, dtPersonal.getApellidoM());
            psql.setString(6, dtPersonal.getSexo());
            //  psql.setDate(7, FechaNacimiento);
            //eliminamos la columna edad
            psql.setString(7, dtPersonal.getFechaNacimiento());
            psql.setString(8, dtPersonal.getTelefono());
            psql.setString(9, dtPersonal.getCorreoPersonal());
            psql.setString(10, dtPersonal.getCorreoInst());
            psql.setString(11, dtPersonal.getCURP());
            psql.setString(12, dtPersonal.getRFC());
            psql.setString(13, dtPersonal.getIMSS());
            psql.setString(14, dtPersonal.getEstadoCivil());
            psql.setString(15, dtPersonal.getLenguaIndigena());
            psql.setString(16, dtPersonal.getDirección());
            psql.setString(17, dtPersonal.getColonia());
            psql.setString(18, dtPersonal.getLocalidad());
            psql.setString(19, dtPersonal.getNombreCEmerg());
            psql.setString(20, dtPersonal.getParentestoCEmerg());
            psql.setString(21, dtPersonal.getTelefonoCE());
            psql.setString(22, dtPersonal.getTipoSangre());

            resultado = psql.executeUpdate();
            System.out.println("resultdo edit=" + resultado);
            if (resultado > 0) { //si resultado es >0 se ejecuto la transaccion correctamente
                JOptionPane.showMessageDialog(null, "El registro se actualizó correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar el registro");
            }
            psql.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        // return resultado;
    }

    public int eliminarAlumno(int id) {
        int resultado = 0;

        String SentenciaSQL = "DELETE FROM alumno WHERE idAlumno=?";

        try {
            conn = con.getConnection();
            psql = conn.prepareStatement(SentenciaSQL);
            psql.setInt(1, id);

            resultado = psql.executeUpdate();
            if (resultado > 0) { //si resultado es >0 se ejecuto la transaccion correctamente
                JOptionPane.showMessageDialog(null, "El registro se eliminó correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro");
            }
            psql.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return resultado;
    }

    public ArrayList<ModelPersonalN> buscarAlumnobyApellido(String ap) {
        ArrayList listaPersonal = new ArrayList();
        ModelPersonalN personal;

        String SentenciaSQL = "SELECT * FROM alumno WHERE aPaterno=?";

        try {
            conn = con.getConnection();
            psql = conn.prepareStatement(SentenciaSQL);
            psql.setString(1, ap);
            ResultSet rs = psql.executeQuery();
            while (rs.next()) {
                personal = new ModelPersonalN();
                personal.setId(rs.getInt(1));

                listaPersonal.add(personal);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return listaPersonal;
    }

    public int numEmpExiste(String numEmp) {

        String sql = "SELECT count(num_empleado) from tbl_empleado WHERE num_empleado=?";
        try {
            psql = conn.prepareStatement(sql);

            psql.setString(1, numEmp);
            rs = psql.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;

        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }

    }

    public boolean GuardarDatosLaboralesN(ModelPersonalN dtPersonal) {

        String SentenciaSQL = "INSERT INTO `tbl_empleo` (`plantel`,`tipo_contratacion`,`codigo`, `fecha_ingreso`, `jefe_inmediato`, `puesto`, `area_adscripcion`, `categoria`, `horas_laborales`, `tipo_plaza`, `sindicato`, `horario_trabajo`, `sueldo`,`formato_FUMP`,`id_empleado`) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";

        try {

            psql = conn.prepareStatement(SentenciaSQL);

            //psql.setInt(1,0);
            psql.setString(1, dtPersonal.getPlantel());
            psql.setString(2, dtPersonal.getTipoContratacion());
            psql.setString(3, dtPersonal.getCodigo());
            psql.setString(4, dtPersonal.getFechaIngreso());
         //   psql.setString(5, dtPersonal.getFechaTerminoCont());
            psql.setString(6, dtPersonal.getJefeInmediato());
            psql.setString(7, dtPersonal.getPuesto());
            //  psql.setDate(7, FechaNacimiento);
            //eliminamos la columna edad
            psql.setString(8, dtPersonal.getAreaAdscripción());
            psql.setString(9, dtPersonal.getCategoria());
            psql.setString(10, dtPersonal.getHorasLaborales());
            psql.setString(11, dtPersonal.getTipoPlaza());
            psql.setString(12, dtPersonal.getSindicato());
            psql.setString(13, dtPersonal.getHorarioTrabajo());
            psql.setString(14, dtPersonal.getSueldo());
            psql.setBytes(15, dtPersonal.getFormatoFUMP());
            psql.setInt(16, dtPersonal.getId());

            //     psql.setString(14, dtPersonal.getNumEmpleado());
            psql.execute();
            psql.close();
            return true;
        } catch (SQLException ex) {

            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
 public boolean GuardarDatosLaboralesH(ModelPersonalN dtPersonal) {

        String SentenciaSQL = "INSERT INTO `tbl_empleo` (`plantel`,`tipo_contratacion`,`codigo`, `fecha_ingreso`,`fecha_term_contrato`, `jefe_inmediato`, `puesto`, `area_adscripcion`, `categoria`, `horas_laborales`, `tipo_plaza`, `sindicato`, `horario_trabajo`, `sueldo`,`id_empleado`) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";

        try {

            psql = conn.prepareStatement(SentenciaSQL);

            //psql.setInt(1,0);
            psql.setString(1, dtPersonal.getPlantel());
            psql.setString(2, dtPersonal.getTipoContratacion());
            psql.setString(3, dtPersonal.getCodigo());
            psql.setString(4, dtPersonal.getFechaIngreso());
            psql.setString(5, dtPersonal.getFechaTerminoCont());
            psql.setString(6, dtPersonal.getJefeInmediato());
            psql.setString(7, dtPersonal.getPuesto());
            //  psql.setDate(7, FechaNacimiento);
            //eliminamos la columna edad
            psql.setString(8, dtPersonal.getAreaAdscripción());
            psql.setString(9, dtPersonal.getCategoria());
            psql.setString(10, dtPersonal.getHorasLaborales());
            psql.setString(11, dtPersonal.getTipoPlaza());
            psql.setString(12, dtPersonal.getSindicato());
            psql.setString(13, dtPersonal.getHorarioTrabajo());
            psql.setString(14, dtPersonal.getSueldo());
          //  psql.setBytes(15, dtPersonal.getFormatoFUMP());
            psql.setInt(16, dtPersonal.getId());

            //     psql.setString(14, dtPersonal.getNumEmpleado());
            psql.execute();
            psql.close();
            return true;
        } catch (SQLException ex) {

            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
    public int idEmpleado() {
        int id = 0;
        String sql = "select id_empleado from tbl_empleado order by id_empleado desc limit 1";
        try {
            psql = conn.prepareStatement(sql);

            rs = psql.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);

            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return id;
    }

    public boolean GuardarDerechohabiente(ModelPersonalN dtPersonal) {

        String SentenciaSQL = "INSERT INTO `db_rh`.`tbl_derechohabiente` (`num_empleado`, `nombre`, `fecha_nacimiento`, `parentesco`,`sexo`,`status`) VALUES (?,?,?,?,?,?);";

        try {

            psql = conn.prepareStatement(SentenciaSQL);

            //psql.setInt(1,0);
            psql.setString(1, dtPersonal.getNum_empleado());
            psql.setString(2, dtPersonal.getNombredh());
            psql.setString(3, dtPersonal.getFechaNacdh());
            psql.setString(4, dtPersonal.getParentesco());
            psql.setString(5, dtPersonal.getSexo());
            psql.setString(6, dtPersonal.getEstado());

            psql.execute();
            psql.close();

            return true;
        } catch (SQLException ex) {

            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public ArrayList<ModelPersonalN> listDerechohabiente() {
        ArrayList listaPersonal = new ArrayList();
        ModelPersonalN personal;

        String SentenciaSQL = "SELECT nombre,fecha_nacimiento,parentesco,sexo,TIMESTAMPDIFF(YEAR,fecha_nacimiento,CURDATE()) AS edadActual,status FROM db_rh.tbl_derechohabiente";

        try {
            psql = conn.prepareStatement(SentenciaSQL);
            rs = psql.executeQuery();
            while (rs.next()) {
                personal = new ModelPersonalN();

                personal.setNombredh(rs.getString(1));

                SimpleDateFormat formatofecha = new SimpleDateFormat("d MMM y");
                String pasofecha = (formatofecha.format(rs.getDate(2)));
                personal.setFechaNacdh(pasofecha);
                personal.setParentesco(rs.getString(3));
                personal.setSexo(rs.getString(4));
                personal.setEdaddh(rs.getString(5));
                personal.setEstado(rs.getString(6));

                listaPersonal.add(personal);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }

        return listaPersonal;
    }

}
