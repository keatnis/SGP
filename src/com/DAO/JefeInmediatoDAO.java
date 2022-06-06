package com.DAO;

import com.connection.Conexion;
import com.model.JefeInmediatoModel;
import com.model.ModelPersonalN;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class JefeInmediatoDAO {

    Conexion con = new Conexion();
    PreparedStatement psql;
    ResultSet rs;

    public int GuardarJefes(String clave, String nombre, String aPaterno, String aMatern) {
         int resultado = 0;
        Connection cn = null;

        String SentenciaSQL = 

                "INSERT INTO tbl_jefeInmediato(abrev,nombre,ape_paterno,ape_materno)"
                + " VALUES (?,?,?,?)";
    
        try {

             cn = con.getConnection();
            psql = cn.prepareStatement(SentenciaSQL);

            //psql.setInt(1,0);
            psql.setString(1, clave);
            psql.setString(2, nombre);
            psql.setString(3, aPaterno);
            psql.setString(4, aMatern);

            resultado = psql.executeUpdate();
            if (resultado > 0) { //si resultado es >0 se ejecuto la transaccion correctamente
                JOptionPane.showMessageDialog(null, "Se guardo correctamente el registro");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar el registro");
            }
            psql.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al intentar almacenar guardar un registro:\n"
                    + e, "Error en la operación", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        
        }
        return resultado;
    }

    public ArrayList<JefeInmediatoModel> listJI() {
        ArrayList listaJefes = new ArrayList();
        JefeInmediatoModel personal;

        PreparedStatement ps = null;
        Connection conn = con.getConnection();

        String SentenciaSQL = "SELECT id_jefeInmediato, concat(abrev,' ',nombre,' ',ape_paterno,' ',ape_materno)nombreJefe FROM db_rh.tbl_jefeinmediato";

        try {
            psql = conn.prepareStatement(SentenciaSQL);
            ResultSet rs = psql.executeQuery();
            while (rs.next()) {
                personal = new JefeInmediatoModel();

                personal.setId(rs.getInt(1));
                personal.setNombre(rs.getString(2));

                listaJefes.add(personal);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
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
//        }
        return listaJefes;
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
