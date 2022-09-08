package com.model;

import javax.swing.Icon;

public class ModelPersonalN {

    //Getters y Setters de los datos generales del Personal
    private String num_empleado, Abrev, Nombres, ApellidoP, ApellidoM, Sexo, FechaNacimiento, EDAD, CURP, RFC, IMSS, Telefono, CorreoPersonal, CorreoInst, LenguaIndigena,
            Incapacidad, EstadoCivil, TipoSangre, Dirección, Colonia, Localidad, NombreCEmerg, ParentestoCEmerg, TelefonoCE, foto_paht, Status,municipio,codPostal;
       String id_area,id_puesto,fechaInicioCont;   

    public String getFechaInicioCont() {
        return fechaInicioCont;
    }

    public void setFechaInicioCont(String fechaInicioCont) {
        this.fechaInicioCont = fechaInicioCont;
    }

    public String getId_area() {
        return id_area;
    }

    public void setId_area(String id_area) {
        this.id_area = id_area;
    }

    public String getId_puesto() {
        return id_puesto;
    }

    public void setId_puesto(String id_puesto) {
        this.id_puesto = id_puesto;
    }

   private String antmeses,ant_año,sexodh;
int id_dh;
    public int getId_dh() {
        return id_dh;
    }

    public void setId_dh(int id_dh) {
        this.id_dh = id_dh;
    }
    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }
    public String getSexodh() {
        return sexodh;
    }

    public void setSexodh(String sexodh) {
        this.sexodh = sexodh;
    }
 private int antmesesI,ant_añoI,anio_egreso;

    public int getAnio_egreso() {
        return anio_egreso;
    }

    public void setAnio_egreso(int anio_egreso) {
        this.anio_egreso = anio_egreso;
    }
 
 String NivelEstudios,nombreInst,CarreraProfesional,entidadFed,anioEgreso, conTitulo,conPosgrado,conMaestria,conDoctorado;

    public String getNivelEstudios() {
        return NivelEstudios;
    }

    public void setNivelEstudios(String NivelEstudios) {
        this.NivelEstudios = NivelEstudios;
    }

    public String getNombreInst() {
        return nombreInst;
    }

    public void setNombreInst(String nombreInst) {
        this.nombreInst = nombreInst;
    }

    public String getCarreraProfesional() {
        return CarreraProfesional;
    }

    public void setCarreraProfesional(String CarreraProfesional) {
        this.CarreraProfesional = CarreraProfesional;
    }

    public String getEntidadFed() {
        return entidadFed;
    }

    public void setEntidadFed(String entidadFed) {
        this.entidadFed = entidadFed;
    }

    public String getAnioEgreso() {
        return anioEgreso;
    }

    public void setAnioEgreso(String anioEgreso) {
        this.anioEgreso = anioEgreso;
    }

    public String getConTitulo() {
        return conTitulo;
    }

    public void setConTitulo(String conTitulo) {
        this.conTitulo = conTitulo;
    }

    public String getConPosgrado() {
        return conPosgrado;
    }

    public void setConPosgrado(String conPosgrado) {
        this.conPosgrado = conPosgrado;
    }

    public String getConMaestria() {
        return conMaestria;
    }

    public void setConMaestria(String conMaestria) {
        this.conMaestria = conMaestria;
    }

    public String getConDoctorado() {
        return conDoctorado;
    }

    public void setConDoctorado(String conDoctorado) {
        this.conDoctorado = conDoctorado;
    }

    public int getAntmesesI() {
        return antmesesI;
    }

    public void setAntmesesI(int antmesesI) {
        this.antmesesI = antmesesI;
    }

    public int getAnt_añoI() {
        return ant_añoI;
    }

    public void setAnt_añoI(int ant_añoI) {
        this.ant_añoI = ant_añoI;
    }
    public String getAntmeses() {
        return antmeses;
    }

    public void setAntmeses(String antmeses) {
        this.antmeses = antmeses;
    }

    public String getAnt_año() {
        return ant_año;
    }

    public void setAnt_año(String ant_año) {
        this.ant_año = ant_año;
    }
    private Icon icon;

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    private int Id, estado1;
//getters y setters de los datos de la tabla empleo
    String codigo, fechaTerminoCont, fechaIngreso, jefeInmediato, puesto, areaAdscripción, categoria, horasLaborales, tipoPlaza, sindicato, horarioTrabajo, sueldo, plantel, tipoContratacion, numEmpleado;

    //derecho habiente
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
    byte[] formatoFUMP;

    public byte[] getFormatoFUMP() {
        return formatoFUMP;
    }

    public void setFormatoFUMP(byte[] formatoFUMP) {
        this.formatoFUMP = formatoFUMP;
    }

    public String getFoto_paht() {
        return foto_paht;
    }

    public void setFoto_paht(String foto_paht) {
        this.foto_paht = foto_paht;
    }

    public String getFechaTerminoCont() {
        return fechaTerminoCont;
    }

    public void setFechaTerminoCont(String fechaTerminoCont) {
        this.fechaTerminoCont = fechaTerminoCont;
    }
//getters y setters de los datos de la tabla derechohabiente
    String nombredh, fechaNacdh, parentesco, padreomadre, estado;
int  edaddh, edadMesesdh;
    public int getEdadMesesdh() {
        return edadMesesdh;
    }

    public void setEdadMesesdh(int edadMesesdh) {
        this.edadMesesdh = edadMesesdh;
    }

    public int getEstadoi() {
        return estado1;
    }

    public void setEstadoi(int estado1) {
        this.estado1 = estado1;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getEdaddh() {
        return edaddh;
    }

    public void setEdaddh(int edaddh) {
        this.edaddh = edaddh;
    }

    public String getNombredh() {
        return nombredh;
    }

    public void setNombredh(String nombredh) {
        this.nombredh = nombredh;
    }

    public String getFechaNacdh() {
        return fechaNacdh;
    }

    public void setFechaNacdh(String fechaNacdh) {
        this.fechaNacdh = fechaNacdh;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getPadreomadre() {
        return padreomadre;
    }

    public void setPadreomadre(String padreomadre) {
        this.padreomadre = padreomadre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getJefeInmediato() {
        return jefeInmediato;
    }

    public void setJefeInmediato(String jefeInmediato) {
        this.jefeInmediato = jefeInmediato;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getAreaAdscripción() {
        return areaAdscripción;
    }

    public void setAreaAdscripción(String areaAdscripción) {
        this.areaAdscripción = areaAdscripción;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getHorasLaborales() {
        return horasLaborales;
    }

    public void setHorasLaborales(String horasLaborales) {
        this.horasLaborales = horasLaborales;
    }

    public String getTipoPlaza() {
        return tipoPlaza;
    }

    public void setTipoPlaza(String tipoPlaza) {
        this.tipoPlaza = tipoPlaza;
    }

    public String getSindicato() {
        return sindicato;
    }

    public void setSindicato(String sindicato) {
        this.sindicato = sindicato;
    }

    public String getHorarioTrabajo() {
        return horarioTrabajo;
    }

    public void setHorarioTrabajo(String horarioTrabajo) {
        this.horarioTrabajo = horarioTrabajo;
    }

    public String getSueldo() {
        return sueldo;
    }

    public void setSueldo(String sueldo) {
        this.sueldo = sueldo;
    }

    public String getPlantel() {
        return plantel;
    }

    public void setPlantel(String plantel) {
        this.plantel = plantel;
    }

    public String getTipoContratacion() {
        return tipoContratacion;
    }

    public void setTipoContratacion(String tipoContratacion) {
        this.tipoContratacion = tipoContratacion;
    }

    public String getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(String numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
    private String a;

    public int getId() {
        return Id;
    }

    public String getNum_empleado() {
        return num_empleado;
    }

    public void setNum_empleado(String num_empleado) {
        this.num_empleado = num_empleado;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getEDAD() {
        return EDAD;
    }

    public void setEDAD(String EDAD) {
        this.EDAD = EDAD;
    }

    public String getAbrev() {
        return Abrev;
    }

    public void setAbrev(String Abrev) {
        this.Abrev = Abrev;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidoP() {
        return ApellidoP;
    }

    public void setApellidoP(String ApellidoP) {
        this.ApellidoP = ApellidoP;
    }

    public String getApellidoM() {
        return ApellidoM;
    }

    public void setApellidoM(String ApellidoM) {
        this.ApellidoM = ApellidoM;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getIMSS() {
        return IMSS;
    }

    public void setIMSS(String IMSS) {
        this.IMSS = IMSS;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCorreoPersonal() {
        return CorreoPersonal;
    }

    public void setCorreoPersonal(String CorreoPersonal) {
        this.CorreoPersonal = CorreoPersonal;
    }

    public String getCorreoInst() {
        return CorreoInst;
    }

    public void setCorreoInst(String CorreoInst) {
        this.CorreoInst = CorreoInst;
    }

    public String getLenguaIndigena() {
        return LenguaIndigena;
    }

    public void setLenguaIndigena(String LenguaIndigena) {
        this.LenguaIndigena = LenguaIndigena;
    }

    public String getIncapacidad() {
        return Incapacidad;
    }

    public void setIncapacidad(String Incapacidad) {
        this.Incapacidad = Incapacidad;
    }

    public String getEstadoCivil() {
        return EstadoCivil;
    }

    public void setEstadoCivil(String EstadoCivil) {
        this.EstadoCivil = EstadoCivil;
    }

    public String getTipoSangre() {
        return TipoSangre;
    }

    public void setTipoSangre(String TipoSangre) {
        this.TipoSangre = TipoSangre;
    }

    public String getDirección() {
        return Dirección;
    }

    public void setDirección(String Dirección) {
        this.Dirección = Dirección;
    }

    public String getColonia() {
        return Colonia;
    }

    public void setColonia(String Colonia) {
        this.Colonia = Colonia;
    }

    public String getLocalidad() {
        return Localidad;
    }

    public void setLocalidad(String Localidad) {
        this.Localidad = Localidad;
    }

    public String getNombreCEmerg() {
        return NombreCEmerg;
    }

    public void setNombreCEmerg(String NombreCEmerg) {
        this.NombreCEmerg = NombreCEmerg;
    }

    public String getParentestoCEmerg() {
        return ParentestoCEmerg;
    }

    public void setParentestoCEmerg(String ParentestoCEmerg) {
        this.ParentestoCEmerg = ParentestoCEmerg;
    }

    public String getTelefonoCE() {
        return TelefonoCE;
    }

    public void setTelefonoCE(String TelefonoCE) {
        this.TelefonoCE = TelefonoCE;
    }
}
