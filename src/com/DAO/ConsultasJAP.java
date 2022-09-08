
package com.DAO;

import com.connection.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;


public class ConsultasJAP {
       Conexion con = new Conexion();
    public void ObteberJefe(JComboBox cmbJefe) {

        try {

            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT id_jefeInmediato,concat(abrev,' ',nombre,' ',ape_paterno,' ',ape_materno)nombreJefe FROM db_rh.tbl_jefeinmediato");
            ResultSet res = pstm.executeQuery();

            while (res.next()) {
                String tipoU = res.getString("nombreJefe");
                 String id = res.getString("id_jefeInmediato");
               cmbJefe.addItem( id +" - "+ tipoU);

            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void ObteberArea(JComboBox cmbArea) {

        try {

            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT * FROM tbl_area");
            ResultSet res = pstm.executeQuery();

            while (res.next()) {
                String id=res.getString("id_area");
                String area = res.getString("nombre");
               cmbArea.addItem(id+" - "+area);

            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void ObteberPuestos(JComboBox cmbPuesto) {

        try {

            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT * FROM db_rh.tbl_puesto");
            ResultSet res = pstm.executeQuery();

            while (res.next()) {
                  String id=res.getString("id_puesto");
                String nombrep = res.getString("nombre");
              cmbPuesto.addItem(id+" - "+nombrep);

            }
            res.close();

        } catch (SQLException e) {
            System.out.println(e);
//        } finally {
//            try {
//                if (con != null) {
//                    con.cerrar();
//                }
//            } catch (SQLException ex) {
//
//                JOptionPane.showMessageDialog(null, "Error al intentar cerrar la conexión:\n"
//                        + ex, "Error en la operación", JOptionPane.ERROR_MESSAGE);
//            }
        }
    }
public void ObteberJefe2(JComboBox cmbJefe) {

        try {

            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT concat(abrev,' ',nombre,' ',ape_paterno,' ',ape_materno)nombreJefe FROM db_rh.tbl_jefeinmediato");
            ResultSet res = pstm.executeQuery();

            while (res.next()) {
                String tipoU = res.getString("nombreJefe");
              
               cmbJefe.addItem(tipoU);

            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void ObteberArea2(JComboBox cmbArea) {

        try {

            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT nombre FROM tbl_area");
            ResultSet res = pstm.executeQuery();

            while (res.next()) {
              String area = res.getString("nombre");
               cmbArea.addItem(area);

            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void ObteberPuestos2(JComboBox cmbPuesto) {

        try {

            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT nombre FROM db_rh.tbl_puesto");
            ResultSet res = pstm.executeQuery();

            while (res.next()) {
                 
                String nombrep = res.getString("nombre");
              cmbPuesto.addItem(nombrep);

            }
            res.close();

        } catch (SQLException e) {
            System.out.println(e);

        }
    }
}
    
