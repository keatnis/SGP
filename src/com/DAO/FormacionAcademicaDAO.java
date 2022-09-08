package com.DAO;

import com.connection.Conexion;
import com.model.ModelFormacionAcademica;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class FormacionAcademicaDAO extends Conexion {

    PreparedStatement ps = null;
    Connection con = getConnection();
    ResultSet rs = null;

    public void registrar(ModelFormacionAcademica form) {

        String sql = "INSERT INTO tbl_formacion_academica(id_empleado,nivel_estudio,carrera,institucion,estado,anio_egreso,titulo,posgrado,maestria,doctorado) VALUES(?,?,?,?,?,?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, form.getId());
            ps.setString(2, form.getNivelEstudios());
            ps.setString(3, form.getCarreraProfesional());
            ps.setString(4, form.getNombreInst());
            ps.setString(5, form.getEntidadFed());
            ps.setString(6, form.getAnioEgreso());
            ps.setString(7, form.getConTitulo());
            ps.setString(8, form.getConPosgrado());
            ps.setString(9, form.getConMaestria());
            ps.setString(10, form.getConDoctorado());
            ps.execute();
            //   con.close();
            //  JOptionPane.showMessageDialog(null,"Registrado FA");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            //  Logger.getLogger(BajaPersonalDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public void update(ModelFormacionAcademica form, int id) {

        String sql = "UPDATE tbl_formacion_academica SET nivel_estudio=?,carrera=?,institucion=?,estado=?,anio_egreso=?,titulo=?,posgrado=?,maestria=?,doctorado=? where id_empleado=" + id + "";

        try {
            ps = con.prepareStatement(sql);
            //   ps.setInt(1, form.getId());
            ps.setString(1, form.getNivelEstudios());
            ps.setString(2, form.getCarreraProfesional());
            ps.setString(3, form.getNombreInst());
            ps.setString(4, form.getEntidadFed());
            ps.setString(5, form.getAnioEgreso());
            ps.setString(6, form.getConTitulo());
            ps.setString(7, form.getConPosgrado());
            ps.setString(8, form.getConMaestria());
            ps.setString(9, form.getConDoctorado());
            ps.execute();
            //   con.close();
            JOptionPane.showMessageDialog(null,"Datos actualizados con exito");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            //  Logger.getLogger(BajaPersonalDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
}
