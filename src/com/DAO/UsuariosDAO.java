package com.DAO;

import com.connection.Conexion;
import com.model.ModelUsers;
import com.mysql.cj.jdbc.Blob;
import com.vista.RegistrarUsuario;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class UsuariosDAO extends Conexion {

    RegistrarUsuario regU;
    File imagen;
    FileInputStream fis;
    public boolean registrar(ModelUsers usr) throws FileNotFoundException {
        PreparedStatement ps = null;
        Connection con = getConnection();
       
       
           imagen = new File(usr.getRuta());
           fis= new FileInputStream(imagen);
        
           
        String sql = "INSERT INTO tbl_usuario (usuario, nombre, cargo, correo, last_session, tipo_usuario, status,password,avatar) VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, usr.getUsuario());
            ps.setString(2, usr.getNombre());
            ps.setString(3, usr.getCargo());
            ps.setString(4, usr.getCorreo());
            ps.setString(5, usr.getLast_session());
            ps.setString(6, usr.getTipo());
            ps.setString(7, usr.getEstado());
            ps.setString(8, usr.getPassword());
            ps.setBinaryStream(9, fis, (int) imagen.length());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public int usuarioExiste(String usr) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();

        String sql = "SELECT count(id_usuario) from tbl_usuario WHERE usuario=?";
        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, usr);
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

    public boolean login(ModelUsers usr) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();

        String sql = "SELECT id_usuario,usuario,password,nombre,tipo_usuario,avatar from tbl_usuario WHERE usuario=? and `status`='Activo' limit 1";
        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, usr.getUsuario());
            rs = ps.executeQuery();

            if (rs.next()) {

                Blob blob = (Blob) rs.getBlob("avatar");

                byte[] data = blob.getBytes(1, (int) blob.length());
                BufferedImage img = null;
                try {
                    img = ImageIO.read(new ByteArrayInputStream(data));
                } catch (IOException ex) {
                    Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (usr.getPassword().equals(rs.getString(3))) {
                    usr.setId_usuario(rs.getInt(1));
                    usr.setNombre(rs.getString(4));
                    usr.setTipo(rs.getString(5));
                    usr.setAvatar(img);
                  
                    return true;
                } else {
                    return false;
                }

            }
            return false;

        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
}
