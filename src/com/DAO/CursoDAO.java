package com.DAO;

import com.connection.Conexion;
import com.model.ModelCurso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CursoDAO extends Conexion {

    PreparedStatement ps = null;
    Connection con = getConnection();
    ResultSet rs = null;
    ModelCurso model = new ModelCurso();

    public int idEmpleado(String num) {
        int id = 0;

        String sql = "select id_empleado from tbl_empleado where num_empleado=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, num);
            rs = ps.executeQuery();

            if (rs.next()) {
                id = rs.getInt(1);

            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return id;
    }

    public void registrar(String nombre, String clave, String fecha, int idemp) {
        int resultado = 0;
        String sql = "INSERT INTO tbl_curso (nombre_curso,clave_curso,fecha_realizacion,id_empleado) VALUES(?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, clave);
            ps.setString(3, fecha);
            //    ps.setString(4, fecha2);
            ps.setInt(4, idemp);

            resultado = ps.executeUpdate();
            if (resultado == 0) {
                JOptionPane.showMessageDialog(null, "No se pudo guardar el registro");
            }
            //    ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            //  Logger.getLogger(BajaPersonalDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public void updateAsistencia(int ide, int asis) {
        int resultado = 0;
        String sql = "UPDATE tbl_curso SET asistencia=? where id_empleado=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, asis);
            ps.setInt(2, ide);

            resultado = ps.executeUpdate();
            if (resultado == 0) {
                JOptionPane.showMessageDialog(null, "No se pudo guardar el registro");
            }            //    ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            //  Logger.getLogger(BajaPersonalDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public ArrayList<ModelCurso> listado() {
        ArrayList listaPersonal = new ArrayList();

        ModelCurso personal;

        String SentenciaSQL = "SELECT clave_curso,nombre_curso,fecha_realizacion,concat(abrev_nombre,' ',nombre,' ',ape_paterno,' ',ape_materno)AS nombre, tbl_curso.id_empleado,asistencia,jefe_inmediato\n"
                + "FROM tbl_curso INNER JOIN tbl_empleado ON tbl_curso.id_empleado=tbl_empleado.id_empleado\n"
                + "INNER JOIN tbl_empleo ON tbl_empleo.id_empleado=tbl_curso.id_empleado\n"
                + "where clave_curso='" + this.getClave() + "';";

        try {
            ps = con.prepareStatement(SentenciaSQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                personal = new ModelCurso();

                personal.setClaveCurso(rs.getString(1));
                personal.setNombreCurso(rs.getString(2));
                personal.setFechaRealizacion(rs.getString(3));
                //     personal.setFechafin(rs.getString(4));
                personal.setNombreEmp(rs.getString(4));
                personal.setIdemp(rs.getInt(5));
                personal.setAsistencia(rs.getString(6));
                personal.setId_jefe(rs.getString(7));

                listaPersonal.add(personal);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
//        finally {
//            try {
//                if (con != null) {
//                    this.cerrar();
//                }
//            } catch (SQLException ex) {
//
//                JOptionPane.showMessageDialog(null, "Error al intentar cerrar la conexión:\n"
//                        + ex, "Error en la operación", JOptionPane.ERROR_MESSAGE);
//            }
//        } 
        return listaPersonal;
    }
     public ArrayList<ModelCurso> listadoSI() {
        ArrayList listaPersonal = new ArrayList();

        ModelCurso personal;

        String SentenciaSQL = "SELECT clave_curso,nombre_curso,fecha_realizacion,concat(abrev_nombre,' ',nombre,' ',ape_paterno,' ',ape_materno)AS nombre, tbl_curso.id_empleado,asistencia,jefe_inmediato\n"
                + "FROM tbl_curso INNER JOIN tbl_empleado ON tbl_curso.id_empleado=tbl_empleado.id_empleado\n"
                + "INNER JOIN tbl_empleo ON tbl_empleo.id_empleado=tbl_curso.id_empleado\n"
                + "where clave_curso='" + this.getClave() + "' AND asistencia=1;";

        try {
            ps = con.prepareStatement(SentenciaSQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                personal = new ModelCurso();

                personal.setClaveCurso(rs.getString(1));
                personal.setNombreCurso(rs.getString(2));
                personal.setFechaRealizacion(rs.getString(3));
                //     personal.setFechafin(rs.getString(4));
                personal.setNombreEmp(rs.getString(4));
                personal.setIdemp(rs.getInt(5));
                personal.setAsistencia(rs.getString(6));
                personal.setId_jefe(rs.getString(7));

                listaPersonal.add(personal);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
//        finally {
//            try {
//                if (con != null) {
//                    this.cerrar();
//                }
//            } catch (SQLException ex) {
//
//                JOptionPane.showMessageDialog(null, "Error al intentar cerrar la conexión:\n"
//                        + ex, "Error en la operación", JOptionPane.ERROR_MESSAGE);
//            }
//        } 
        return listaPersonal;
    }
    private String clave;

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
