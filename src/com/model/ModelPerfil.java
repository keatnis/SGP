
package com.model;


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
    public ModelPerfil(String nombre,String puesto,String cumple,String sueldo,String telefono){
        this.nombre = nombre;
        this.puesto = puesto;
        this.cumple = cumple;
        this.sueldo = sueldo;
        this.teléfono = telefono;
        
    }
    public ModelPerfil(){
        
    }
private String nombre;
private String puesto;
private String cumple;
private String sueldo;
private String teléfono;
}
