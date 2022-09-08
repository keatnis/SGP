package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    public static Connection conn;
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String user = "root";
    private static final String pass = "root";
    private static final String db = "db_rh?";
    //true en useSSL 
    private static final String uni="&autoReconnect=true&useSSL=false"; 
   private static final String unicode="useSSL=false&autoReconnect=true&useUnicode=yes&characterEncoding=UTF-8&";
    private static final String time = "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String url = "jdbc:mysql://192.168.1.65:3306/"+db+time+uni;
    public Conexion(){
        conn = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pass);
            // Connect?
            if(conn != null)
                System.out.println("Conexión establecida exitosamente");
        }catch (ClassNotFoundException | SQLException ex){
            JOptionPane.showMessageDialog(null,"Conexión Fallida:\n\n"+ex);
        }
    }
    
    public Connection getConnection(){
        return conn;
    }
     public void cerrar() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

}  

