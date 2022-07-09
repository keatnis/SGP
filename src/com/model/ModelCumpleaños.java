
package com.model;

public class ModelCumpleaños {
    String numEmple,nombreCompleto,fechaNac,edad2;

    public String getEdad2() {
        return edad2;
    }

    public void setEdad2(String edad2) {
        this.edad2 = edad2;
    }
    int id,edad;

    public String getNumEmple() {
        return numEmple;
    }

    public void setNumEmple(String numEmple) {
        this.numEmple = numEmple;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
     public ModelCumpleaños(String numEmple, String nombreCompleto, String fechaNac, String edad2) {
      //  this.icon = icon;
       this.numEmple = numEmple;
      this.nombreCompleto= nombreCompleto;
       
        this.fechaNac = fechaNac;
        this.edad2 = edad2;
    }
     public ModelCumpleaños(){
         
     }
}
