package com.DAO;

import com.connection.Conexion;
import com.model.ModelBajaPersonal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class BajaPersonalDAO extends Conexion {

    PreparedStatement ps = null;
    Connection con = getConnection();
    ResultSet rs = null;
    ModelBajaPersonal model = new ModelBajaPersonal();
    File imagen;
    FileInputStream fis;

    public boolean registrar(ModelBajaPersonal pers) throws FileNotFoundException {

        String sql = "INSERT INTO tbl_baja_personal (id_empleado,motivo_salida,fecha_baja,notas,archivo) VALUES(?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);

            ps.setInt(1, pers.getId_emp());
            ps.setString(2, pers.getMotivoSalida());
            ps.setString(3, pers.getFecha());
            ps.setString(4, pers.getNotas());
            ps.setBytes(5, pers.getArchivo());

            ps.execute();
         //   con.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,ex);
          //  Logger.getLogger(BajaPersonalDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return true;

    }

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

        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return id;
    }

    public void actualizarStatus(int id_empleado) {

        String sql = "UPDATE tbl_empleado SET status=0 WHERE (id_empleado=?)";
        try {
            ps = con.prepareStatement(sql);

            ps.setInt(1, id_empleado);

            ps.executeUpdate();
            
          
        } catch (SQLException ex) {

            Logger.getLogger(BajaPersonalDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
}
