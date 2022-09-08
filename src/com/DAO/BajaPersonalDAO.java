package com.DAO;

import com.connection.Conexion;
import com.model.ModelBajaPersonal;
import java.io.ByteArrayInputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        //    ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
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
             rs.close();
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

    /*Metodo listar*/
    public ArrayList<ModelBajaPersonal> Listar_PdfVO() {
        ArrayList<ModelBajaPersonal> list = new ArrayList<>();

        String sql = "SELECT id_baja,num_empleado,concat(abrev_nombre,' ',nombre,' ',ape_materno,' ',ape_paterno)nombreComp,motivo_salida,fecha_baja,notas,archivo\n"
                + "FROM tbl_empleado\n"
                + "INNER JOIN tbl_baja_personal\n"
                + "ON tbl_empleado.id_empleado=tbl_baja_personal.id_empleado";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ModelBajaPersonal vo = new ModelBajaPersonal();
                vo.setIdBaja(rs.getInt(1));
                vo.setNumEmp(rs.getString(2));
                vo.setNombreEmp(rs.getString(3));
                vo.setMotivoSalida(rs.getString(4));
                vo.setFecha(rs.getString(5));
                vo.setNotas(rs.getString(6));
                vo.setArchivo(rs.getBytes(7));
                list.add(vo);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
              //  ps.close();
                 rs.close();
                // conec.desconectar();
            } catch (Exception ex) {
                
            }
        }
        return list;
    }
 //Permite mostrar PDF contenido en la base de datos
    public void ejecutar_archivoPDF(int id) {

      
        PreparedStatement ps = null;
        ResultSet rs = null;
        byte[] b = null;

        try {
            ps = con.prepareStatement("SELECT archivo FROM tbl_baja_personal WHERE id_baja = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                b = rs.getBytes(1);
            }
            InputStream bos = new ByteArrayInputStream(b);

            int tamanoInput = bos.available();
            byte[] datosPDF = new byte[tamanoInput];
            bos.read(datosPDF, 0, tamanoInput);

            OutputStream out = new FileOutputStream("new.pdf");
            out.write(datosPDF);

            //abrir archivo
            out.close();
            bos.close();
            ps.close();
            rs.close();
           // cn.desconectar();

        } catch (IOException | NumberFormatException | SQLException ex) {
            System.out.println("Error al abrir archivo PDF " + ex.getMessage());
        }
    }
}
