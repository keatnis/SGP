package com.DAO;

import com.connection.Conexion;
import com.model.ModelCaducidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CaducidadDAO {

    Conexion con = new Conexion();
    PreparedStatement psql;
    ResultSet rs;
    Connection conn = con.getConnection();

    public ArrayList<ModelCaducidad> listado() {
        ArrayList listaPersonal = new ArrayList();

        ModelCaducidad personal;

        String SentenciaSQL = "SELECT num_empleado,concat(abrev_nombre, ' ',nombre,' ',ape_paterno,' ',ape_materno)nombre,nombre_documento,fecha_vencimiento,TIMESTAMPDIFF(DAY,curdate(),fecha_vencimiento) AS dias_faltantes\n"
                + "FROM tbl_documentacion\n"
                + "INNER JOIN tbl_empleado \n"
                + "ON tbl_documentacion.id_empleado=tbl_empleado.id_empleado order by dias_faltantes;";

        try {
            psql = conn.prepareStatement(SentenciaSQL);
            rs = psql.executeQuery();
            while (rs.next()) {
                personal = new ModelCaducidad();

                personal.setNumemp(rs.getString(1));
                personal.setNombre(rs.getString(2));
                personal.setNombre_doc(rs.getString(3));
                personal.setFecha_vencimiento(rs.getString(4));
                personal.setDias_faltantes(rs.getInt(5));

                listaPersonal.add(personal);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }finally {
            try {
                if (conn != null) {
                    con.cerrar();
                }
            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(null, "Error al intentar cerrar la conexión:\n"
                        + ex, "Error en la operación", JOptionPane.ERROR_MESSAGE);
            }
        } 
        return listaPersonal;
    }
    
}
