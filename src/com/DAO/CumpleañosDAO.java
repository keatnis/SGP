package com.DAO;

import com.connection.Conexion;
import com.model.ModelCumpleaños;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class CumpleañosDAO {

    Conexion con = new Conexion();
    PreparedStatement psql = null;
    ResultSet rs;
    Connection conn = con.getConnection();
    Calendar fecha = new GregorianCalendar();
    int mes = fecha.get(Calendar.MONTH) + 1;

    public ArrayList<ModelCumpleaños> listCump() throws IOException {
        ArrayList listaCump = new ArrayList();
        ModelCumpleaños personal;

        String SentenciaSQL = " SELECT num_empleado, concat(abrev_nombre,' ',nombre,' ',ape_paterno,' ',ape_materno)nombreComp, date_format(fecha_nacimiento,'%m-%d') AS fecha ,\n"
                + "  YEAR(CURDATE())-YEAR(fecha_nacimiento) + IF(DATE_FORMAT(CURDATE(),'%m-%d') > DATE_FORMAT(fecha_nacimiento,'%m-%d'), 0 , -1 ) AS edadActual,foto_emp FROM tbl_empleado where month(fecha_nacimiento)='" + mes + "'";

        try {
            psql = conn.prepareStatement(SentenciaSQL);
            rs = psql.executeQuery();
            while (rs.next()) {
                personal = new ModelCumpleaños();
                personal.setNumEmple(rs.getString(1));
                personal.setNombreCompleto(rs.getString(2));
                personal.setFechaNac(rs.getString(3));
                personal.setEdad2(rs.getString(4));
                InputStream imgstream = rs.getBinaryStream("foto_emp");
              
                if (imgstream == null) {
                    personal.setIcon(null);
                } else {
                      Image image = ImageIO.read(imgstream);
                    personal.setIcon(new ImageIcon(image));
                    listaCump.add(personal);
                }

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return listaCump;
    }

    public ArrayList<ModelCumpleaños> listFestividades() {
        ArrayList listaFest = new ArrayList();
        ModelCumpleaños personal;

        String SentenciaSQL = "select fecha,TIMESTAMPDIFF(day, curdate(),fecha) AS dias_faltantes,nombre from tbl_evento where month(fecha)='" + mes + "';";

        try {
            psql = conn.prepareStatement(SentenciaSQL);
            rs = psql.executeQuery();
            while (rs.next()) {
                personal = new ModelCumpleaños();
                SimpleDateFormat formatofecha = new SimpleDateFormat("MM-dd");
                String pasofecha = (formatofecha.format(rs.getDate(1)));
                personal.setFecha(pasofecha);
                personal.setDias_falt(rs.getInt(2));
                personal.setNombresFestividad(rs.getString(3));
                listaFest.add(personal);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
        return listaFest;
    }
}
