package com.DAO;

import com.connection.Conexion;
import com.model.ModelDocumentacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DocumentacionDAO {

    Conexion con = new Conexion();
    PreparedStatement psql;
    ResultSet rs;
    Connection cn = con.getConnection();

    public int GuardarDocumentacion(ModelDocumentacion modeldoc) {
        int resultado = 0;

        String SentenciaSQL
                = "INSERT INTO tbl_documentacion(id_empleado,nombre_documento,fecha_vencimiento)"
                + " VALUES (?,?,?)";

        try {

            psql = cn.prepareStatement(SentenciaSQL);

            //psql.setInt(1,0);
            psql.setInt(1, modeldoc.getId());
            psql.setString(2, modeldoc.getNombre());
            psql.setString(3, modeldoc.getFechaVencimiento());
            resultado = psql.executeUpdate();
            if (resultado > 0) { //si resultado es >0 se ejecuto la transaccion correctamente
              //  JOptionPane.showMessageDialog(null, "Se guardo correctamente el registro");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar el registro");
            }
            psql.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al intentar almacenar guardar un registro:\n"
                    + e.getMessage(), "Error en la operación", JOptionPane.ERROR_MESSAGE);

        }
        return resultado;
    }

    public int GuardarDocumentosEntregados(ModelDocumentacion modeldoc) {
        int resultado = 0;

        String SentenciaSQL
                = "INSERT INTO `db_rh`.`tbl_documentoentregado` (`id_empleado`, `solicitud_empleo`, `curriculum_vitae`, `acta_nacimiento`, `cartas_recomen`, `carta_no_inhabilitacion`, `carta_ant_nopenales`, `certificado_medico`, `cartilla_servicio_militar`, `foto_tam_inf`, `ine`, `comprobante_dom`, `curp`, `documentos_preparación`, `titulo`, `cedula_prof`, `exame_oposicion`, `examen_psicometrico`,`link_drive`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

        try {

            psql = cn.prepareStatement(SentenciaSQL);

            //psql.setInt(1,0);
            psql.setInt(1, modeldoc.getId());
            psql.setInt(2, modeldoc.getSolicitudEmp());
            psql.setInt(3, modeldoc.getCv());
            psql.setInt(4, modeldoc.getActaNacimiento());
            psql.setInt(5, modeldoc.getCartasRecom());
            psql.setInt(6, modeldoc.getCartaNoHabilitacion());
            psql.setInt(7, modeldoc.getCartaAntecedentes());
            psql.setInt(8, modeldoc.getCartificadoMed());
            psql.setInt(9, modeldoc.getCartillaServicio());
            psql.setInt(10, modeldoc.getFotografias());
            psql.setInt(11, modeldoc.getIneB());
            psql.setInt(12, modeldoc.getComprobante_dom());
            psql.setInt(13, modeldoc.getCurp());
            psql.setInt(14, modeldoc.getDocumentosPreparacion());
            psql.setInt(15, modeldoc.getTitulo());
            psql.setInt(16, modeldoc.getCedula_prof());
            psql.setInt(17, modeldoc.getExamenOposicion());
            psql.setInt(18, modeldoc.getExamenPsicometrico());
            psql.setString(19, modeldoc.getLinkDrive());
            resultado = psql.executeUpdate();
            if (resultado > 0) { //si resultado es >0 se ejecuto la transaccion correctamente
              //  JOptionPane.showMessageDialog(null, "Se guardo correctamente el registro");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar el registro");
            }
            psql.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al intentar almacenar guardar un registro:\n"
                    + e.getMessage(), "Error en la operación", JOptionPane.ERROR_MESSAGE);

        }
        return resultado;
    }
}
