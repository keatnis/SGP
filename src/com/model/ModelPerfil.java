package com.model;

import javax.swing.Icon;

public class ModelPerfil {

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getCumple() {
        return cumple;
    }

    public void setCumple(String cumple) {
        this.cumple = cumple;
    }

    public String getSueldo() {
        return sueldo;
    }

    public void setSueldo(String sueldo) {
        this.sueldo = sueldo;
    }

    public String getTeléfono() {
        return teléfono;
    }

    public void setTeléfono(String teléfono) {
        this.teléfono = teléfono;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

//    public ModelPerfil(String nombre,String puesto,String cumple,String sueldo,String telefono){
//        this.nombre = nombre;
//        this.puesto = puesto;
//        this.cumple = cumple;
//        this.sueldo = sueldo;
//        this.teléfono = telefono;
//        
//    }
    private String nombre;
    private String puesto;
    private String cumple;
    private String sueldo;
    private String teléfono;
    private String nume;
    private String correo;
    private String status;
    private String area;
     private Icon icon;

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

}
