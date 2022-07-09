package com.DAO;

import com.connection.Conexion;
import com.model.ModelReports;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
}
