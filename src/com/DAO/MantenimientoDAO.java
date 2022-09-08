package com.DAO;

import com.connection.Conexion;
import com.model.MantenimientoModel;
import com.model.ModelPersonalN;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MantenimientoDAO {

    Conexion con = new Conexion();
    PreparedStatement psql;
    ResultSet rs;
    Connection cn = con.getConnection();

    public int GuardarJefes(String clave, String nombre, String aPaterno, String aMatern, String puesto) {
        int resultado = 0;

        String SentenciaSQL
                = "INSERT INTO tbl_jefeInmediato(abrev,nombre,ape_paterno,ape_materno,puesto)"
                + " VALUES (?,?,?,?,?)";

        try {

            psql = cn.prepareStatement(SentenciaSQL);

            //psql.setInt(1,0);
            psql.setString(1, clave);
            psql.setString(2, nombre);
            psql.setString(3, aPaterno);
            psql.setString(4, aMatern);
            psql.setString(5, puesto);

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

    public ArrayList<MantenimientoModel> listJI() {
        ArrayList listaJefes = new ArrayList();
        MantenimientoModel personal;

        String SentenciaSQL = "SELECT id_jefeInmediato, concat(abrev,' ',nombre,' ',ape_paterno,' ',ape_materno)nombreJefe,puesto FROM db_rh.tbl_jefeinmediato";

        try {
            psql = cn.prepareStatement(SentenciaSQL);
            ResultSet rs = psql.executeQuery();
            while (rs.next()) {
                personal = new MantenimientoModel();

                personal.setId(rs.getInt(1));
                personal.setNombre(rs.getString(2));
                personal.setPuesto(rs.getString(3));
                listaJefes.add(personal);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }

        return listaJefes;
    }

    public void editarDatosJI(MantenimientoModel dtPersonal) {
        int resultado = 0;

        String SentenciaSQL = "UPDATE db_rh.tbl_jefeinmediato  SET abrev=?,nombre=?,ape_paterno=?,ape_materno=?,puesto=?  where id_jefeInmediato=" + dtPersonal.getId() + "";

        try {

            psql = cn.prepareStatement(SentenciaSQL);

            psql.setString(1, dtPersonal.getAbrev());
            psql.setString(2, dtPersonal.getNombre());
            psql.setString(3, dtPersonal.getApePaterno());
            psql.setString(4, dtPersonal.getApeMaterno());
            psql.setString(5, dtPersonal.getPuesto());

            resultado = psql.executeUpdate();

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

    public int eliminarJefeInm(int id) {
        int resultado = 0;

        String SentenciaSQL = "DELETE FROM tbl_jefeinmediato WHERE id_jefeInmediato=?";

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

    public ArrayList<MantenimientoModel> obtenerDatosJE(String id) {
        ArrayList listaPersonal = new ArrayList();
        MantenimientoModel personal;

        String SentenciaSQL = "SELECT  abrev,nombre,ape_paterno,ape_materno FROM db_rh.tbl_jefeinmediato where id_jefeInmediato=?;";

        try {
            cn = con.getConnection();
            psql = cn.prepareStatement(SentenciaSQL);
            psql.setString(1, id);
            ResultSet rs = psql.executeQuery();
            while (rs.next()) {
                personal = new MantenimientoModel();
                //   personal.setId(rs.getInt(1));
                personal.setAbrev(rs.getString(1));
                personal.setNombre(rs.getString(2));
                personal.setApePaterno(rs.getString(3));
                personal.setApeMaterno(rs.getString(4));
                listaPersonal.add(personal);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return listaPersonal;
    }

    public int numEmpExiste(String numEmp) {
        PreparedStatement ps = null;

        String sql = "SELECT count(num_empleado) from tbl_empleado WHERE id_empleado=?";
        try {
            ps = cn.prepareStatement(sql);

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

    public int GuardarPuesto(String nombre) {
        int resultado = 0;

        String SentenciaSQL
                = "INSERT INTO tbl_puesto(nombre)"
                + " VALUES (?)";

        try {
            psql = cn.prepareStatement(SentenciaSQL);
            psql.setString(1, nombre);

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

    public ArrayList<MantenimientoModel> listPuestos() {
        ArrayList listaPuestos = new ArrayList();
        MantenimientoModel personal;

        String SentenciaSQL = "SELECT id_puesto,nombre FROM db_rh.tbl_puesto";

        try {
            psql = cn.prepareStatement(SentenciaSQL);
            rs = psql.executeQuery();
            while (rs.next()) {
                personal = new MantenimientoModel();

                personal.setId(rs.getInt(1));
                personal.setNombre(rs.getString(2));

                listaPuestos.add(personal);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }

        return listaPuestos;
    }

    public void editarDatosPuestos(MantenimientoModel dtPersonal) {
        int resultado = 0;

        String SentenciaSQL = "UPDATE db_rh.tbl_puesto  SET nombre=?  where id_puesto=" + dtPersonal.getId() + "";

        try {

            psql = cn.prepareStatement(SentenciaSQL);

            psql.setString(1, dtPersonal.getNombre());

            resultado = psql.executeUpdate();

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

    public int eliminarPuesto(int id) {
        int resultado = 0;

        String SentenciaSQL = "DELETE FROM tbl_puesto WHERE id_puesto=?";

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

    public int GuardarArea(String nombre) {
        int resultado = 0;

        String SentenciaSQL
                = "INSERT INTO tbl_area(nombre)"
                + " VALUES (?)";

        try {
            psql = cn.prepareStatement(SentenciaSQL);
            psql.setString(1, nombre);

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

    public ArrayList<MantenimientoModel> listAreas() {
        ArrayList listaPuestos = new ArrayList();
        MantenimientoModel personal;

        String SentenciaSQL = "SELECT id_area,nombre FROM tbl_area";

        try {
            psql = cn.prepareStatement(SentenciaSQL);
            rs = psql.executeQuery();
            while (rs.next()) {
                personal = new MantenimientoModel();

                personal.setId(rs.getInt(1));
                personal.setNombre(rs.getString(2));

                listaPuestos.add(personal);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }

        return listaPuestos;
    }

    public void editarArea(MantenimientoModel dtPersonal) {
        int resultado = 0;

        String SentenciaSQL = "UPDATE db_rh.tbl_area  SET nombre=?  where id_area=" + dtPersonal.getId() + "";

        try {

            psql = cn.prepareStatement(SentenciaSQL);

            psql.setString(1, dtPersonal.getNombre());

            resultado = psql.executeUpdate();

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

    public int eliminarArea(int id) {
        int resultado = 0;

        String SentenciaSQL = "DELETE FROM tbl_area WHERE id_area=?";

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
}
