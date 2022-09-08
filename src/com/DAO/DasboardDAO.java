
package com.DAO;

import com.connection.Conexion;
import com.model.ModelDasboard;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class DasboardDAO extends Conexion{
     PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
     public int usuarioExiste(int das) {
    
       

        String sql = "SELECT count(id_usuario) from tbl_usuario";
        try {
            ps = con.prepareStatement(sql);

            ps.setInt(1, das);
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
         public void listDatos(){
               
               ModelDasboard md= new ModelDasboard();
         try {     
      
            ps = con.prepareStatement(
            "SELECT count(id_usuario) from usuarios");                       
            rs = ps.executeQuery();
            rs.next();
            md.setMax(String.valueOf(rs.getInt("id_usuario")));
            rs.close();
          }catch(SQLException e){
         System.out.println(e);
    }
         }
}
