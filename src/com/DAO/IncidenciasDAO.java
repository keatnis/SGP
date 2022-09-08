package com.DAO;

import com.connection.Conexion;

import com.model.ModelReportarIncidencia;
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
import javax.swing.JOptionPane;

public class IncidenciasDAO extends Conexion {
    
    PreparedStatement ps = null;
    Connection con = getConnection();
    ResultSet rs = null;
    
    File imagen;
    FileInputStream fis;
    
    public void registrar(ModelReportarIncidencia pers) throws FileNotFoundException {
        int resultado = 0;
        String sql = "INSERT INTO tbl_incidencia (id_empleado,fecha_inicio,fecha_fin,tipo_incidencia,esjustificada,archivo,nota,usuario,fecha_registro) VALUES(?,?,?,?,?,?,?,?,curdate())";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pers.getIdEmp());
            ps.setString(2, pers.getFecha_de());
            ps.setString(3, pers.getFecha_hasta());
            ps.setString(4, pers.getTipoIncidencia());
            ps.setInt(5, pers.getEsJustificada());
            ps.setBytes(6, pers.getArchivo());
            ps.setString(7, pers.getNota());
            ps.setString(8, pers.getNomuser());
            
            resultado = ps.executeUpdate();
            if (resultado > 0) { //si resultado es >0 se ejecuto la transaccion correctamente
                JOptionPane.showMessageDialog(null, "Se guardo correctamente el registro de la incidencia");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar el registro");
            }
            //    ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            //  Logger.getLogger(BajaPersonalDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        
    }
    
   

    public void ejecutar_archivoPDF(int id) {
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        byte[] b = null;
        
        try {
            ps = con.prepareStatement("SELECT archivo FROM tbl_incidencia WHERE id_incidencia = ?");
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
