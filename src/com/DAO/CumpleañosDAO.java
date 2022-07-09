package com.DAO;

import com.connection.Conexion;
import com.model.ModelCumpleaños;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class CumpleañosDAO {

    Conexion con = new Conexion();
    PreparedStatement psql= null;
    ResultSet rs;
 Connection conn = con.getConnection();
   Calendar fecha = new GregorianCalendar();
        int mes = fecha.get(Calendar.MONTH)+1;
              
    public ArrayList<ModelCumpleaños> listCump() {
        ArrayList listaCump = new ArrayList();
        ModelCumpleaños personal;

      

        String SentenciaSQL = "SELECT num_empleado, concat(abrev_nombre,' ',nombre,' ',ape_paterno,' ',ape_materno)nombreComp,fecha_nacimiento,TIMESTAMPDIFF(YEAR,fecha_nacimiento,CURDATE()) AS edadActual FROM tbl_empleado where month(fecha_nacimiento)='"+mes+"'";

        try {
            psql = conn.prepareStatement(SentenciaSQL);
            rs = psql.executeQuery();
            while (rs.next()) {
                personal = new ModelCumpleaños();
                personal.setNumEmple(rs.getString(1));
                personal.setNombreCompleto(rs.getString(2));
              
                SimpleDateFormat formatofecha = new SimpleDateFormat("d MMM y");
            String pasofecha = (formatofecha.format(rs.getDate(3)));
                personal.setFechaNac(pasofecha);
                personal.setEdad2(rs.getString(4));

                listaCump.add(personal);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        
        
        return listaCump;
    }
 
}
