package com.DAO;

import com.connection.Conexion;
import com.model.ModelPersonalN;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ListadoDAO {

    Conexion con = new Conexion();
    PreparedStatement psql;
    ResultSet rs;
    Connection conn = con.getConnection();
    ModelPersonalN model = new ModelPersonalN();
    LocalDateTime date_of_today = LocalDateTime.now();
    DateTimeFormatter format_date_of_today = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String formattedDate = date_of_today.format(format_date_of_today);

    public ArrayList<ModelPersonalN> listPersonalCompleto() {
        ArrayList listaPersonal = new ArrayList();
        ModelPersonalN personal;

        String SentenciaSQL = "SELECT num_empleado,nombre,ape_paterno,ape_materno,status,genero,fecha_nacimiento,telefono,correo_personal,correo_institucional,curp,rfc,imss,estado_civil,lengua_indigena,concat(direccion,' ',colonia,' ',localidad)direccion,concat(parent_emerg,'--',telefono_CE)ContactoEmerg,tipo_sangre,plantel,tipo_contratacion,codigo,fecha_ingreso,fecha_term_contrato,jefe_inmediato,puesto,area_adscripcion,categoria,horas_laborales,tipo_plaza,sindicato,horario_trabajo,sueldo,nivel_estudio,carrera,institucion,estado,anio_egreso,titulo,posgrado,maestria,doctorado\n"
                + "FROM tbl_empleado\n"
                + "INNER JOIN tbl_empleo ON tbl_empleado.id_empleado=tbl_empleo.id_empleado\n"
                + "INNER JOIN tbl_formacion_academica ON tbl_empleado.id_empleado=tbl_formacion_academica.id_empleado;";

        try {
            psql = conn.prepareStatement(SentenciaSQL);
            rs = psql.executeQuery();
            while (rs.next()) {
                personal = new ModelPersonalN();
                personal.setNumEmpleado(rs.getString(1));
                personal.setNombres(rs.getString(2));
                personal.setApellidoP(rs.getString(3));
                personal.setApellidoM(rs.getString(4));
                if (rs.getString(5).equals("1")) {
                    personal.setStatus("Activo");
                } else {
                    personal.setStatus("Baja");
                }

                personal.setSexo(rs.getString(6));
                personal.setFechaNacimiento(rs.getString(7));

                personal.setTelefono(rs.getString(8));
                personal.setCorreoPersonal(rs.getString(9));
                personal.setCorreoInst(rs.getString(10));
                personal.setCURP(rs.getString(11));
                personal.setRFC(rs.getString(12));
                personal.setIMSS(rs.getString(13));
                personal.setEstadoCivil(rs.getString(14));
                personal.setLenguaIndigena(rs.getString(15));
                personal.setDirección(rs.getString(16));
                personal.setTelefonoCE(rs.getString(17));
                personal.setTipoSangre(rs.getString(18));

                personal.setPlantel(rs.getString(19));
                personal.setTipoContratacion(rs.getString(20));
                personal.setCodigo(rs.getString(21));
                // String pasofecha2 = (formatofecha.format(rs.getDate(22)));
                personal.setFechaIngreso(rs.getString(22));
                personal.setFechaTerminoCont(rs.getString(23));
                personal.setJefeInmediato(rs.getString(24));
                personal.setPuesto(rs.getString(25));
                personal.setAreaAdscripción(rs.getString(26));
                personal.setCategoria(rs.getString(27));
                personal.setHorasLaborales(rs.getString(28));
                personal.setTipoPlaza(rs.getString(29));
                personal.setSindicato(rs.getString(30));
                personal.setHorarioTrabajo(rs.getString(31));
                personal.setSueldo(rs.getString(32));

                personal.setNivelEstudios(rs.getString(33));
                personal.setCarreraProfesional(rs.getString(34));
                personal.setNombreInst(rs.getString(35));
                personal.setEstado(rs.getString(36));
                personal.setAnio_egreso(rs.getInt(37));
                personal.setConTitulo(rs.getString(38));
                personal.setConPosgrado(rs.getString(39));
                personal.setConMaestria(rs.getString(40));
                personal.setConDoctorado(rs.getString(41));

                listaPersonal.add(personal);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
//        } finally {
//            try {
//                if (conn != null) {
//                    con.cerrar();
//                }
//            } catch (SQLException ex) {
//
//                JOptionPane.showMessageDialog(null, "Error al intentar cerrar la conexión:\n"
//                        + ex, "Error en la operación", JOptionPane.ERROR_MESSAGE);
//            }
//        }
        return listaPersonal;
    }

    public ArrayList<ModelPersonalN> directorio() {
        ArrayList listaPersonal = new ArrayList();

        ModelPersonalN personal;

        String SentenciaSQL = "SELECT concat(nombre,' ',ape_paterno,' ',ape_materno)as nombre,concat(direccion,' ',colonia,' ',localidad)direccion,telefono,correo_institucional,telefono_CE FROM tbl_empleado;";
        try {
            psql = conn.prepareStatement(SentenciaSQL);
            rs = psql.executeQuery();
            while (rs.next()) {
                personal = new ModelPersonalN();

                personal.setNombres(rs.getString(1));
                personal.setDirección(rs.getString(2));
                personal.setTelefono(rs.getString(3));
                personal.setCorreoInst(rs.getString(4));
                personal.setTelefonoCE(rs.getString(5));

                listaPersonal.add(personal);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return listaPersonal;
    }

    public ArrayList<ModelPersonalN> listado() {
        ArrayList listaPersonal = new ArrayList();

        ModelPersonalN personal;

//        String SentenciaSQL = "SELECT num_empleado,concat(abrev_nombre,' ',nombre,' ',ape_paterno,' ',ape_materno)nombre,genero,area_adscripcion,puesto,fecha_ingreso,fecha_term_contrato,TIMESTAMPDIFF(YEAR, fecha_ingreso,curdate()) AS años_ant,\n"
//                + "  date_format( now(), '%m' ) - date_format( fecha_ingreso, '%m' ) -\n"
//                + "  ( date_format( now(), '%Y-00-%d') < date_format( fecha_ingreso, '%Y-00-%d' ) ) AS meses_ant,tipo_contratacion,status\n"
//                + "  FROM tbl_empleo\n"
//                + " INNER JOIN tbl_empleado \n"
//                + "  ON tbl_empleado.id_empleado=tbl_empleo.id_empleado;";
        String SentenciaSQL = " SELECT num_empleado,concat(ape_paterno,' ',ape_materno,' ',nombre)nombre,genero,area_adscripcion,puesto,fecha_ingreso,fecha_term_contrato,\n"
                + " FLOOR(CAST(TIMESTAMPDIFF(day,fecha_ingreso, curdate()) AS float) / 365.25) AS anios_ant,\n"
                + " FLOOR((CAST(TIMESTAMPDIFF(day,fecha_ingreso, curdate()) AS float) / 365.25 - FLOOR(CAST(TIMESTAMPDIFF(day,fecha_ingreso,curdate()) AS float) / 365.25)) * 12) AS meses_ant,tipo_contratacion,status,categoria\n"
                + "FROM tbl_empleo INNER JOIN tbl_empleado  ON tbl_empleado.id_empleado=tbl_empleo.id_empleado where status=1 ORDER BY FIELD(categoria,'Directivo','Administrativo','Docente','Servicios Generales','Honorarios'),ape_paterno asc;";
        try {
            psql = conn.prepareStatement(SentenciaSQL);
            rs = psql.executeQuery();
            while (rs.next()) {
                personal = new ModelPersonalN();

                personal.setNumEmpleado(rs.getString(1));
                personal.setNombres(rs.getString(2));
                personal.setSexo(rs.getString(3));
                personal.setAreaAdscripción(rs.getString(4));
                personal.setPuesto(rs.getString(5));
                personal.setFechaIngreso(rs.getString(6));
                personal.setFechaTerminoCont(rs.getString(7));

                int antA = rs.getInt(8);
                int antM = rs.getInt(9);
                if (antA < 0) {
                    antM = 0;
                    antA = 0;
                }

                personal.setAnt_añoI(antA);
                personal.setAntmesesI(antM);
                personal.setTipoContratacion(rs.getString(10));
                //  personal.setStatus(rs.getString(9));

                if (rs.getString(11).equals("1")) {
                    personal.setStatus("Activo");
                }

                personal.setCategoria(rs.getString(12));
                listaPersonal.add(personal);
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
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
//    //SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
//                if (rs.getString(7) == null || rs.getString(7).equals("N/A")) {
//                       personal.setStatus("Activo");  
//                } else {
//                    Date date1 = sdformat.parse(rs.getString(7));
//                    Date date2 = sdformat.parse(formattedDate);
//                    if (date1.after(date2)) {
//                        personal.setStatus("CVencido");
//                        System.out.println("date"+  date1+date2);
//                    }
//                    if (rs.getString(11).equals("1")) {
//                        personal.setStatus("Activo");
//                    } 
//                }
}
