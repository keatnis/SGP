package com.DAO;

import com.connection.Conexion;
import com.model.ModelPersonalN;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class PersonalNDAO {

    Conexion con = new Conexion();
    PreparedStatement psql;
    ResultSet rs;
    Connection conn = con.getConnection();
    ModelPersonalN model = new ModelPersonalN();
    public Image get_Image(String ruta) {
        try {
            ImageIcon imageIcon = new ImageIcon(getClass().getResource(ruta));
            Image mainIcon = imageIcon.getImage();
            return mainIcon;
        } catch (Exception e) {
        }
        return null;
    }
    public boolean GuardarPersonal(ModelPersonalN dtPersonal) throws FileNotFoundException {

        String SentenciaSQL = "INSERT INTO tbl_empleado (num_empleado,abrev_nombre,nombre,ape_paterno,ape_materno,status,genero,fecha_nacimiento,telefono,correo_personal,correo_institucional,curp,rfc,imss,estado_civil,lengua_indigena,direccion,colonia,localidad,contacto_emergencia,parent_emerg,telefono_CE,tipo_sangre,foto_emp,esPadre_Madre,municipio,cod_postal)"
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            
            String image="";
            FileInputStream fis = null;
            try {
                  fis = new FileInputStream(image);
                image = new File(dtPersonal.getFoto_paht()).getCanonicalPath();
            } catch (IOException ex) {
                Logger.getLogger(PersonalNDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            //ruta puede ser: "/home/cmop/Desktop/1.jpg"
          
            //Lo convertimos en un Stream

            psql = conn.prepareStatement(SentenciaSQL);

            psql.setString(1, dtPersonal.getNum_empleado());
            psql.setString(2, dtPersonal.getAbrev());
            psql.setString(3, dtPersonal.getNombres());
            psql.setString(4, dtPersonal.getApellidoP());
            psql.setString(5, dtPersonal.getApellidoM());
            psql.setInt(6, 1);
            psql.setString(7, dtPersonal.getSexo());
            psql.setString(8, dtPersonal.getFechaNacimiento());
            psql.setString(9, dtPersonal.getTelefono());
            psql.setString(10, dtPersonal.getCorreoPersonal());
            psql.setString(11, dtPersonal.getCorreoInst());
            psql.setString(12, dtPersonal.getCURP());
            psql.setString(13, dtPersonal.getRFC());
            psql.setString(14, dtPersonal.getIMSS());
            psql.setString(15, dtPersonal.getEstadoCivil());
            psql.setString(16, dtPersonal.getLenguaIndigena());
            psql.setString(17, dtPersonal.getDirección());
            psql.setString(18, dtPersonal.getColonia());
            psql.setString(19, dtPersonal.getLocalidad());
            psql.setString(20, dtPersonal.getNombreCEmerg());
            psql.setString(21, dtPersonal.getParentestoCEmerg());
            psql.setString(22, dtPersonal.getTelefonoCE());
            psql.setString(23, dtPersonal.getTipoSangre());
            psql.setBinaryStream(24, fis, (int) image.length());
            psql.setString(25, dtPersonal.getPadreomadre());
            psql.setString(26, dtPersonal.getMunicipio());
            psql.setString(27, dtPersonal.getCodPostal());

            psql.execute();
            psql.close();
            return true;
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
    }

    public int editarDatosG(ModelPersonalN dtPersonal, int id) {
        int resultado = 0;

        String SentenciaSQL = "UPDATE tbl_empleado SET num_empleado=?,abrev_nombre=?,nombre=?,ape_paterno=?,ape_materno=?,status=?,genero=?,fecha_nacimiento=?,telefono=?,correo_personal=?,correo_institucional=?,curp=?,rfc=?,imss=?,estado_civil=?,lengua_indigena=?,direccion=?,colonia=?,localidad=?,contacto_emergencia=?,parent_emerg=?,telefono_CE=?,tipo_sangre=?,foto_emp=?,esPadre_Madre=?,municipio=?,cod_postal=? WHERE id_empleado='" + id + "'";

        try {
            File image = new File(dtPersonal.getFoto_paht());
            //ruta puede ser: "/home/cmop/Desktop/1.jpg"
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(image);
                //Lo convertimos en un Stream
            } catch (FileNotFoundException ex) {
                Logger.getLogger(PersonalNDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            psql = conn.prepareStatement(SentenciaSQL);

            // psql.setInt(1,0);
            psql.setString(1, dtPersonal.getNum_empleado());
            psql.setString(2, dtPersonal.getAbrev());
            psql.setString(3, dtPersonal.getNombres());
            psql.setString(4, dtPersonal.getApellidoP());
            psql.setString(5, dtPersonal.getApellidoM());
            psql.setInt(6, 1);
            psql.setString(7, dtPersonal.getSexo());
            //  psql.setDate(7, FechaNacimiento);
            //eliminamos la columna edad
            psql.setString(8, dtPersonal.getFechaNacimiento());
            psql.setString(9, dtPersonal.getTelefono());
            psql.setString(10, dtPersonal.getCorreoPersonal());
            psql.setString(11, dtPersonal.getCorreoInst());
            psql.setString(12, dtPersonal.getCURP());
            psql.setString(13, dtPersonal.getRFC());
            psql.setString(14, dtPersonal.getIMSS());
            psql.setString(15, dtPersonal.getEstadoCivil());
            psql.setString(16, dtPersonal.getLenguaIndigena());
            psql.setString(17, dtPersonal.getDirección());
            psql.setString(18, dtPersonal.getColonia());
            psql.setString(19, dtPersonal.getLocalidad());
            psql.setString(20, dtPersonal.getNombreCEmerg());
            psql.setString(21, dtPersonal.getParentestoCEmerg());
            psql.setString(22, dtPersonal.getTelefonoCE());
            psql.setString(23, dtPersonal.getTipoSangre());
            psql.setBinaryStream(24, fis, (int) image.length());
            psql.setString(25, dtPersonal.getPadreomadre());
            psql.setString(26, dtPersonal.getMunicipio());
            psql.setString(27, dtPersonal.getCodPostal());

            psql.executeUpdate();
            psql.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return 0;
    }

    public int numEmpExiste(String numEmp) {

        String sql = "SELECT count(num_empleado) from tbl_empleado WHERE num_empleado=?";
        try {
            psql = conn.prepareStatement(sql);

            psql.setString(1, numEmp);
            rs = psql.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return 1;
        }

    }

    public boolean GuardarDatosLaboralesN(ModelPersonalN dtPersonal) {

        String SentenciaSQL = "INSERT INTO `tbl_empleo` (`plantel`,`tipo_contratacion`,`codigo`, `fecha_ingreso`,`fecha_inicio_cont`,`fecha_term_contrato`, `jefe_inmediato`, `puesto`, `area_adscripcion`, `categoria`, `horas_laborales`, `tipo_plaza`, `sindicato`, `horario_trabajo`, `sueldo`,`formato_FUMP`,`id_empleado`,`id_puesto`,`id_area`)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            psql = conn.prepareStatement(SentenciaSQL);

            //psql.setInt(1,0);
            psql.setString(1, dtPersonal.getPlantel());
            psql.setString(2, dtPersonal.getTipoContratacion());
            psql.setString(3, dtPersonal.getCodigo());
            psql.setString(4, dtPersonal.getFechaIngreso());
            psql.setString(5, dtPersonal.getFechaInicioCont());
            psql.setString(6, dtPersonal.getFechaTerminoCont());

            psql.setString(7, dtPersonal.getJefeInmediato());
            psql.setString(8, dtPersonal.getPuesto());
            psql.setString(9, dtPersonal.getAreaAdscripción());
            psql.setString(10, dtPersonal.getCategoria());
            psql.setString(11, dtPersonal.getHorasLaborales());
            psql.setString(12, dtPersonal.getTipoPlaza());
            psql.setString(13, dtPersonal.getSindicato());
            psql.setString(14, dtPersonal.getHorarioTrabajo());
            psql.setString(15, dtPersonal.getSueldo());
            psql.setBytes(16, dtPersonal.getFormatoFUMP());
            psql.setInt(17, dtPersonal.getId());
            psql.setString(18, dtPersonal.getId_puesto());
            psql.setString(19, dtPersonal.getId_area());
            //     psql.setString(14, dtPersonal.getNumEmpleado());
            psql.executeUpdate();
            psql.close();
            return true;
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("s" + ex);
            return false;
        }

    }

    public boolean UpdateDL(ModelPersonalN dtPersonal, int id) {

        String SentenciaSQL = "UPDATE `tbl_empleo` SET `plantel`=?,`tipo_contratacion`=?,`codigo`=?, `fecha_ingreso`=?,`fecha_term_contrato`=?, `jefe_inmediato`=?, `puesto`=?, `area_adscripcion`=?, `categoria`=?, `horas_laborales`=?, `tipo_plaza`=?, `sindicato`=?, `horario_trabajo`=?, `sueldo`=?,`formato_FUMP`=? where`id_empleado`=" + id + " ";

        try {

            psql = conn.prepareStatement(SentenciaSQL);
            //    psql.setInt(id, id);
            //psql.setInt(1,0);
            psql.setString(1, dtPersonal.getPlantel());
            psql.setString(2, dtPersonal.getTipoContratacion());
            psql.setString(3, dtPersonal.getCodigo());
            psql.setString(4, dtPersonal.getFechaIngreso());
            psql.setString(5, dtPersonal.getFechaTerminoCont());
            psql.setString(6, dtPersonal.getJefeInmediato());
            psql.setString(7, dtPersonal.getPuesto());

            psql.setString(8, dtPersonal.getAreaAdscripción());
            psql.setString(9, dtPersonal.getCategoria());
            psql.setString(10, dtPersonal.getHorasLaborales());
            psql.setString(11, dtPersonal.getTipoPlaza());
            psql.setString(12, dtPersonal.getSindicato());
            psql.setString(13, dtPersonal.getHorarioTrabajo());
            psql.setString(14, dtPersonal.getSueldo());
            psql.setBytes(15, dtPersonal.getFormatoFUMP());

            //     psql.setString(14, dtPersonal.getNumEmpleado());
            psql.execute();
            psql.close();
            return true;
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }

    }

    public ArrayList<ModelPersonalN> listDerechohabiente() {
        ArrayList listaPersonal = new ArrayList();
        ModelPersonalN personal2 = null;
//        String SentenciaSQL = "SELECT nombre,fecha_nacimiento,parentesco,sexo,TIMESTAMPDIFF(YEAR, fecha_nacimiento,curdate()) AS EdadAnios,\n"
//                + " (date_format( now(), '%m' ) - date_format( fecha_nacimiento, '%m' )) -( date_format( now(), '%Y-00-%d') < date_format( fecha_nacimiento, '%Y-00-%d' ) ) AS EdadMeses,\n"
//                + " status,id_derechohabiente FROM db_rh.tbl_derechohabiente WHERE id_empleado="+id+";";

        String SentenciaSQL = "SELECT nombre,fecha_nacimiento,parentesco,sexo,\n"
                + "FLOOR(CAST(TIMESTAMPDIFF(day,fecha_nacimiento, curdate()) AS float) / 365.25) AS EdadAnios,\n"
                + " FLOOR((CAST(TIMESTAMPDIFF(day,fecha_nacimiento, curdate()) AS float) / 365.25 - FLOOR(CAST(TIMESTAMPDIFF(day, fecha_nacimiento,curdate()) AS float) / 365.25)) * 12) AS EdadMeses,status,id_derechohabiente\n"
                + " FROM db_rh.tbl_derechohabiente WHERE id_empleado=" + id + ";";

        try {

            psql = conn.prepareStatement(SentenciaSQL);
            rs = psql.executeQuery();

            while (rs.next()) {
                personal2 = new ModelPersonalN();
                personal2.setNombredh(rs.getString(1));
//                SimpleDateFormat formatofecha = new SimpleDateFormat("");
//                String pasofecha = (formatofecha.format(rs.getDate(2)));
                personal2.setFechaNacdh(rs.getString(2));
                personal2.setParentesco(rs.getString(3));
                personal2.setSexodh(rs.getString(4));
                personal2.setEdaddh(rs.getInt(5));
                int edadM = rs.getInt(6);
//                if (edadM < -1) {
//                    edadM += 12;
//                } else if (edadM == -1) {
//
//                } else {
//                    edadM += 0;
//                }
                personal2.setEdadMesesdh(edadM);
                if (rs.getString(7).equals("1")) {
                    personal2.setStatus("Activo");
                } else {
                    personal2.setStatus("Inactivo");
                }
                personal2.setId_dh(rs.getInt(8));
                listaPersonal.add(personal2);
                //  rs.close();
            }
        } catch (SQLException e) {
            System.err.println(e);
        }

        return listaPersonal;
    }

    public int idEmpleado() {
        int id = 0;
        String sql = "select id_empleado from tbl_empleado order by id_empleado desc limit 1";
        try {
            psql = conn.prepareStatement(sql);

            rs = psql.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        return id;
    }

    public boolean GuardarDerechohabiente(ModelPersonalN dtPersonal) {

        String SentenciaSQL = "INSERT INTO `db_rh`.`tbl_derechohabiente` (`id_empleado`, `nombre`, `fecha_nacimiento`, `parentesco`, `sexo`, `status`) VALUES(?,?,?,?,?,?)";

        try {

            psql = conn.prepareStatement(SentenciaSQL);

            //psql.setInt(1,0);
            psql.setInt(1, dtPersonal.getId());
            psql.setString(2, dtPersonal.getNombredh());
            psql.setString(3, dtPersonal.getFechaNacdh());
            psql.setString(4, dtPersonal.getParentesco());
            psql.setString(5, dtPersonal.getSexo());
            psql.setString(6, dtPersonal.getEstado());

            psql.execute();
            psql.close();

            return true;
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
    }

    public boolean UpdateDerechohabiente(ModelPersonalN dtPersonal, int idh) {

        String SentenciaSQL = "UPDATE `tbl_derechohabiente` SET `nombre`=?, `fecha_nacimiento`=?, `parentesco`=?, `sexo`=?, `status`=? WHERE id_derechohabiente=" + idh + "";

        try {

            psql = conn.prepareStatement(SentenciaSQL);

            //psql.setInt(1,0);
            // psql.setInt(1, dtPersonal.getId());
            psql.setString(1, dtPersonal.getNombredh());
            psql.setString(2, dtPersonal.getFechaNacdh());
            psql.setString(3, dtPersonal.getParentesco());
            psql.setString(4, dtPersonal.getSexo());
            psql.setString(5, dtPersonal.getEstado());

            psql.execute();

            psql.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        return true;
    }

    public int eliminarDH(int id) {
        int resultado = 0;

        String SentenciaSQL = "DELETE FROM tbl_derechohabiente WHERE id_derechohabiente=?";

        try {
            // con = conn.getConnection();
            psql = conn.prepareStatement(SentenciaSQL);
            psql.setInt(1, id);

            resultado = psql.executeUpdate();
            if (resultado > 0) { //si resultado es >0 se ejecuto la transaccion correctamente
                JOptionPane.showMessageDialog(null, "El registro se eliminó correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro");
            }
            psql.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return resultado;
    }
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    String num;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
    String esPadre, esMadre;

    public String getEsPadre() {
        return esPadre;
    }

    public void setEsPadre(String esPadre) {
        this.esPadre = esPadre;
    }

    public String getEsMadre() {
        return esMadre;
    }

    public void setEsMadre(String esMadre) {
        this.esMadre = esMadre;
    }

}
