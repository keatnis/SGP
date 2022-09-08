package com.DAO;

import com.connection.Conexion;
import com.model.ModelPermisoEconomico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PermisoEconomicoDAO extends Conexion {

    PreparedStatement psql;
    ResultSet rs;

    Connection conn = getConnection();

    public void registrar(ModelPermisoEconomico mod) {

        String sql = "INSERT INTO `db_rh`.`tbl_permiso_economico` (`id_empleado`, `fecha_de`, `fecha_al`, `dias`, `fecha_solicitada`) VALUES (?,?,?,?,curdate());";
        try {
            psql = conn.prepareStatement(sql);

            psql.setInt(1, mod.getId());
            psql.setString(2, mod.getFecha_de());
            psql.setString(3, mod.getFecha_al());
            psql.setInt(4, mod.getDias());

            psql.execute();
            // conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            //  Logger.getLogger(BajaPersonalDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public int count_almes(int idemp, int mes) {
        int count = 0;
//         LocalDate now = LocalDate.now();
//       
//        int mes = now.getMonthValue();
        String sql = " select MonthName(curdate()) as mes, sum(dias) as totalmes from tbl_permiso_economico where MONTH(fecha_al) =" + mes + " and id_empleado=?  and YEAR(fecha_solicitada)=YEAR(curdate()) Group By mes;";
        try {
            psql = conn.prepareStatement(sql);
            psql.setInt(1, idemp);
            rs = psql.executeQuery();

            if (rs.next()) {
                count = rs.getInt(2);

            }
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        return count;
    }

    public int count_alyear(int idemp) {
        int count = 0;
        String sql = "select sum(dias) as totalmes from tbl_permiso_economico where id_empleado=?  and YEAR(fecha_solicitada)=YEAR(curdate()) Group By year(curdate());";
        try {
            psql = conn.prepareStatement(sql);
            psql.setInt(1, idemp);
            rs = psql.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);

            }
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        return count;
    }

  
}
