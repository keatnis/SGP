package com.DAO;

import com.connection.Conexion;
import com.model.ModelReports;
import com.model.ModelUsers;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ReportesDAO {

    Conexion con = new Conexion();
    PreparedStatement psql;
    ResultSet rs;
    Connection conn = con.getConnection();

    public ArrayList<ModelReports> listReporteGenero() {
        ArrayList listaJefes = new ArrayList();
        ModelReports personal;

        String SentenciaSQL = "SELECT  num_empleado,concat(abrev_nombre,' ',nombre,' ',ape_paterno,' ',ape_materno)nombreCompleto,genero from db_rh.tbl_empleado order by num_empleado";
        try {
            psql = conn.prepareStatement(SentenciaSQL);
            ResultSet rs = psql.executeQuery();
            while (rs.next()) {
                personal = new ModelReports();

                personal.setNumEmp(rs.getString(1));
                personal.setNombreCompleto(rs.getString(2));
                personal.setSexo(rs.getString(3));
                listaJefes.add(personal);
                //extraaaa

            }
        } catch (SQLException e) {
            System.err.println(e);
        }

        return listaJefes;
    }

    public ArrayList<ModelReports> listReporteGeneroMujer() {
        ArrayList listaJefes = new ArrayList();
        ModelReports personal;
        String SentenciaSQL = "SELECT  num_empleado,concat(abrev_nombre,' ',nombre,' ',ape_paterno,' ',ape_materno)nombreCompleto,genero from db_rh.tbl_empleado where genero='M' order by num_empleado;";

        try {
            psql = conn.prepareStatement(SentenciaSQL);
            rs = psql.executeQuery();
            while (rs.next()) {
                personal = new ModelReports();

                personal.setNumEmp(rs.getString(1));
                personal.setNombreCompleto(rs.getString(2));
                personal.setSexo(rs.getString(3));
                listaJefes.add(personal);
                //extraaaa

            }
        } catch (SQLException e) {
            System.err.println(e);
        }

        return listaJefes;
    }

    public ArrayList<ModelReports> listReporteGeneroHombre() {
        ArrayList listaJefes = new ArrayList();
        ModelReports personal;

        String SentenciaSQL = "SELECT  num_empleado,concat(abrev_nombre,' ',nombre,' ',ape_paterno,' ',ape_materno)nombreCompleto,genero from db_rh.tbl_empleado where genero='H' order by num_empleado;";

        try {
            psql = conn.prepareStatement(SentenciaSQL);
            rs = psql.executeQuery();
            while (rs.next()) {
                personal = new ModelReports();

                personal.setNumEmp(rs.getString(1));
                personal.setNombreCompleto(rs.getString(2));
                personal.setSexo(rs.getString(3));
                listaJefes.add(personal);
                //extraaaa

            }
        } catch (SQLException e) {
            System.err.println(e);
        }

        return listaJefes;
    }

    public InputStream Imagen(int id_data) {

        InputStream inp = null;
        String query = "SELECT imagen_logo FROM tbl_itsm where id_data='" + id_data + "'";

        try {
            psql = conn.prepareStatement(query);
            rs = psql.executeQuery();
            while (rs.next()) {
                inp = rs.getBinaryStream("imagen_logo");
                //   inp = rs.getBinaryStream("imagen_1");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } 
//        finally {
//            try {
//                rs.close();
////                ps.close();
////                db.desconectar();
//            } catch (SQLException ex) {
//            }
//        }
        return inp;
    }

    public void actualizarLogo(int id,String ruta) throws FileNotFoundException {
        File imagen;
        FileInputStream fis;
        PreparedStatement ps = null;

        imagen = new File(ruta);
        fis = new FileInputStream(imagen);

        String sql = "UPDATE tbl_itsm SET imagen_logo=? WHERE id_data=?";
   
        try {
            ps = conn.prepareStatement(sql);
            ps.setBinaryStream(1, fis, (int) imagen.length());
             ps.setInt(2,id); 
            ps.execute();
           
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
         
        }

    }
     public InputStream Foto(int id_emp) {

        InputStream inp = null;
        String query = "SELECT foto_emp FROM tbl_empleado where id_empleado='" + id_emp + "'";

        try {
            psql = conn.prepareStatement(query);
            rs = psql.executeQuery();
            while (rs.next()) {
                inp = rs.getBinaryStream("foto_emp");
                //   inp = rs.getBinaryStream("imagen_1");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                rs.close();
//                ps.close();
//                db.desconectar();
            } catch (SQLException ex) {
            }
        }
        return inp;
    }
}
