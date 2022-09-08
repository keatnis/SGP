package com.DAO;

import com.connection.Conexion;
import com.model.ModelConvocatorias;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ConvocatoriasDAO extends Conexion {

    PreparedStatement ps = null;
    Connection con = getConnection();
    ResultSet rs = null;

    File imagen;
    FileInputStream fis;

    public int numEmpExiste(int id) {

        String sql = "SELECT count(id_convocatoria) from tbl_convocatoria WHERE id_convocatoria=?";
        try {
            ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return 1;
        }

    }

    public void registrar(ModelConvocatorias pers) throws FileNotFoundException {
        int resultado = 0;
        String sql = "INSERT INTO tbl_convocatoria (no_convocatoria,fecha_inicio,fecha_fin,no_vacante,fecha_publicacion,link_facebook,link_web,archivo,status,periodo) VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pers.getNoconvocatoria());
            ps.setString(2, pers.getFechaInicio());
            ps.setString(3, pers.getFechaFinalizacion());
            ps.setInt(4, pers.getNoVacante());
            ps.setString(5, pers.getFechaPublicación());
            ps.setString(6, pers.getLinkFacebook());
            ps.setString(7, pers.getLinkPW());
            ps.setBytes(8, pers.getArchivo());
            ps.setString(9, pers.getEstatus());
            ps.setString(10, pers.getPeriodo());

            resultado = ps.executeUpdate();
            if (resultado > 0) { //si resultado es >0 se ejecuto la transaccion correctamente
                JOptionPane.showMessageDialog(null, "Se guardo correctamente el registro de la convocatoria");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar el registro");
            }
            //    ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            //  Logger.getLogger(BajaPersonalDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public void update(ModelConvocatorias pers, int id) throws FileNotFoundException {
        int resultado = 0;
        String sql = "UPDATE tbl_convocatoria SET no_convocatoria=?,fecha_inicio=?,fecha_fin=?,no_vacante=?,fecha_publicacion=?,link_facebook=?,link_web=?,archivo=?,status=?,periodo=? WHERE id_convocatoria=" + id + ";";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pers.getNoconvocatoria());
            ps.setString(2, pers.getFechaInicio());
            ps.setString(3, pers.getFechaFinalizacion());
            ps.setInt(4, pers.getNoVacante());
            ps.setString(5, pers.getFechaPublicación());
            ps.setString(6, pers.getLinkFacebook());
            ps.setString(7, pers.getLinkPW());
            ps.setBytes(8, pers.getArchivo());
            ps.setString(9, pers.getEstatus());
            ps.setString(10, pers.getPeriodo());

            //  ps.setInt(11, pers.getId());
            resultado = ps.executeUpdate();
            if (resultado > 0) { //si resultado es >0 se ejecuto la transaccion correctamente
                JOptionPane.showMessageDialog(null, "Se actualiz+o correctamente el registro de la convocatoria");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar el registro");
            }
            //    ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            //  Logger.getLogger(BajaPersonalDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
    byte[] b;

    public byte[] getB() {
        return b;
    }

    public void setB(byte[] b) {
        this.b = b;
    }

    public void ejecutar_archivoPDF(int id) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        b = null;

        try {
            ps = con.prepareStatement("SELECT archivo FROM tbl_convocatoria WHERE id_convocatoria = ?");
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

            this.setB(b);
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

    public ArrayList<ModelConvocatorias> Listar_convocatorias() {
        String sql;
        LocalDateTime date_of_today = LocalDateTime.now();
        DateTimeFormatter format_date_of_today = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = date_of_today.format(format_date_of_today);
        ArrayList<ModelConvocatorias> list = new ArrayList<>();
        Conexion con = new Conexion();
        Connection conn = con.getConnection();

        sql = "SELECT id_convocatoria,periodo,no_convocatoria,fecha_inicio,fecha_fin,no_vacante,fecha_publicacion,link_facebook,link_web,archivo,status FROM db_rh.tbl_convocatoria;";

        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ModelConvocatorias vo = new ModelConvocatorias();
                vo.setId(rs.getInt(1));
                vo.setPeriodo(rs.getString(2));
                vo.setNoconvocatoria(rs.getString(3));
                vo.setFechaInicio(rs.getString(4));
                vo.setFechaFinalizacion(rs.getString(5));
                vo.setNoVacante(rs.getInt(6));
                vo.setFechaPublicación(rs.getString(7));
                vo.setLinkFacebook(rs.getString(8));
                vo.setLinkPW(rs.getString(9));
                vo.setArchivo(rs.getBytes(10));
                if (vo.getFechaFinalizacion().equals(formattedDate)) {
                    vo.setEstatus("Finalizado");
                } else {
                    vo.setEstatus(rs.getString(11));
                }

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

    public int eliminarRConv(int id) {
        int resultado = 0;

        String SentenciaSQL = "DELETE FROM tbl_convocatoria WHERE id_convocatoria=?";

        try {
            con = getConnection();
            ps = con.prepareStatement(SentenciaSQL);
            ps.setInt(1, id);

            resultado = ps.executeUpdate();
            if (resultado > 0) { //si resultado es >0 se ejecuto la transaccion correctamente
                JOptionPane.showMessageDialog(null, "El registro se eliminó correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro");
            }
            ps.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return resultado;
    }
}
