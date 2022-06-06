package com.DAO;

import com.connection.Conexion;
import com.model.ModelPersonalN;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PersonalNDAO {

    Conexion con = new Conexion();
    PreparedStatement psql;
    ResultSet rs;

    public boolean GuardarPersonal(ModelPersonalN dtPersonal) {
        PreparedStatement ps = null;
        Connection conn = con.getConnection();

        String SentenciaSQL = "INSERT INTO tbl_empleado (num_empleado,abrev_nombre,nombre,ape_materno,ape_paterno,genero,fecha_nacimiento,telefono,correo_personal,correo_institucional,curp,rfc,imss,estado_civil,lengua_indigena,direccion,colonia,localidad,contacto_emergencia,parent_emerg,telefono_CE,tipo_sangre)"
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

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

      PreparedStatement ps = null;
        Connection conn = con.getConnection();
        
        String SentenciaSQL = "SELECT *FROM tbl_empleado";

        try {
        psql = conn.prepareStatement(SentenciaSQL);
            ResultSet rs = psql.executeQuery();
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
        Connection cn = null;

        String SentenciaSQL = "UPDATE tbl_empleado SET num_empleado=?,abrev_nombre=?,nombre=?,ape_materno=?,ape_paterno=?,genero=?,fecha_nacimiento=?,telefono=?,correo_personal=?,correo_institucional=?,curp=?,rfc=?,imss=?,estado_civil=?,lengua_indigena=?,direccion=?,colonia=?,localidad=?,contacto_emergencia=?,parent_emerg=?,telefono_CE=?,tipo_sangre=? WHERE id_empleado=?";

        try {
            cn = con.getConnection();
            psql = cn.prepareStatement(SentenciaSQL);
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
        Connection cn = null;

        String SentenciaSQL = "DELETE FROM alumno WHERE idAlumno=?";

        try {
            cn = con.getConnection();
            psql = cn.prepareStatement(SentenciaSQL);
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

        Connection cn = null;
        String SentenciaSQL = "SELECT * FROM alumno WHERE aPaterno=?";

        try {
            cn = con.getConnection();
            psql = cn.prepareStatement(SentenciaSQL);
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
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = con.getConnection();

        String sql = "SELECT count(num_empleado) from tbl_empleado WHERE id_empleado=?";
        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, numEmp);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;

        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }

    }
}
