package com.DAO;

import com.classes.GenerarCod;
import com.connection.Conexion;
import com.model.ModelPaseSalida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PaseSalidaDAO extends Conexion {

    PreparedStatement psql;
    ResultSet rs;

    Connection conn = getConnection();

    public void registrar(int id, String folio, String horaSalida, String horaLlegada) {

        String sql = "INSERT INTO `db_rh`.`tbl_pase_salida` (`id_empleado`, `folio`, `hora_salida`, `hora_llegada`,fecha) VALUES (?,?,?,?,curdate())";
        try {
            psql = conn.prepareStatement(sql);

            psql.setInt(1, id);
            psql.setString(2, folio);
            psql.setString(3, horaSalida);
            psql.setString(4, horaLlegada);

            psql.execute();
            // conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            //  Logger.getLogger(BajaPersonalDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
  public void addObsv(String folio,String observacion) {

        String sql = "UPDATE tbl_pase_salida SET observacion=? where folio=?";
        try {
            psql = conn.prepareStatement(sql);
            psql.setString(1, observacion);
            psql.setString(2, folio);

            psql.execute();
            // conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            //  Logger.getLogger(BajaPersonalDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
    public String ObteneridPase() {

        int j = 0;
        String n = "";
        String foliof = null;
        String SQL = "SELECT count(id_pase) from tbl_pase_salida";

        try {
            psql = conn.prepareStatement(SQL);
            rs = psql.executeQuery();
            if (rs.next()) {
                j = rs.getInt("count(id_pase)");
            }

            if (j == 0) {
                j = 0;
            } else {

                GenerarCod gen = new GenerarCod();
                gen.generar(j);
                foliof = gen.serie();

            }

            rs.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return foliof;
    }

//    public boolean registrar(int id, String folio, String horaSalida, String horaLlegada) {
//
//        String sql = "INSERT INTO `db_rh`.`tbl_pase_salida` (`id_empleado`, `folio`, `hora_salida`, `hora_llegada`,fecha) VALUES (?,?,?,?,curdate())";
//        try {
//            psql = conn.prepareStatement(sql);
//
//            psql.setInt(1, id);
//            psql.setString(2, folio);
//            psql.setString(3, horaSalida);
//            psql.setString(4, horaLlegada);
//
//            psql.execute();
//            // conn.close();
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex.getMessage());
//            //  Logger.getLogger(BajaPersonalDAO.class.getName()).log(Level.SEVERE, null, ex);
//
//        }
//        return true;
//
//    }
    public ArrayList<ModelPaseSalida> listarRegistros() {
        ArrayList<ModelPaseSalida> list = new ArrayList<>();

        String sql
                = " SELECT num_empleado,concat(abrev_nombre,' ',nombre,' ',ape_paterno,' ',ape_materno,' ')AS nombre,fecha,folio,hora_salida,hora_llegada,observacion\n"
                + "           FROM tbl_pase_salida\n"
                + "               INNER JOIN tbl_empleado\n"
                + "                ON tbl_pase_salida.id_empleado=tbl_empleado.id_empleado\n"
                + "                where\n"
                + "                year(fecha)= year(curdate())\n"
                + "		   ORDER BY folio DESC";
        ResultSet rs1 = null;
        ResultSet rs2;
        PreparedStatement ps = null;
        try {

            ps = conn.prepareStatement(sql);
            ps.executeQuery();
            rs1 = ps.executeQuery();
            while (rs1.next()) {
                ModelPaseSalida vo = new ModelPaseSalida();
                //  vo.setNp(rs1.getInt(1));
                vo.setNump(rs1.getString(1));
                vo.setNombre(rs1.getString(2));
                vo.setFecha(rs1.getString(3));
                vo.setFolio(rs1.getString(4));
                vo.setHoraSalida(rs1.getString(5));
                vo.setHoraLlegada(rs1.getString(6));
                vo.setObservaciones(rs1.getString(7));
                list.add(vo);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return list;
    }

}
