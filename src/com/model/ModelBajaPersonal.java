
package com.model;

public class ModelBajaPersonal {
    String NumEmp,MotivoSalida,Notas,fecha;
  byte [] archivo;

    public byte[] getArchivo() {
        return archivo;
    }

    public void setArchivo(byte[] archivo) {
        this.archivo = archivo;
    }
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
  int id_emp;

    public int getId_emp() {
        return id_emp;
    }

    public void setId_emp(int id_emp) {
        this.id_emp = id_emp;
    }
    public String getNumEmp() {
        return NumEmp;
    }

    public void setNumEmp(String NumEmp) {
        this.NumEmp = NumEmp;
    }

    public String getMotivoSalida() {
        return MotivoSalida;
    }

    public void setMotivoSalida(String MotivoSalida) {
        this.MotivoSalida = MotivoSalida;
    }

    public String getNotas() {
        return Notas;
    }

    public void setNotas(String Notas) {
        this.Notas = Notas;
    }
    
}
