
package com.model;

public class ModelPermisoEconomico {
   int dias,id,mes;
   String fecha_de,fecha_al,fecha_solicitada,numEmp,nombre,categoria,tipo,plantel;

    public String getNumEmp() {
        return numEmp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPlantel() {
        return plantel;
    }

    public void setPlantel(String plantel) {
        this.plantel = plantel;
    }

    public void setNumEmp(String numEmp) {
        this.numEmp = numEmp;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public String getFecha_de() {
        return fecha_de;
    }

    public void setFecha_de(String fecha_de) {
        this.fecha_de = fecha_de;
    }

    public String getFecha_al() {
        return fecha_al;
    }

    public void setFecha_al(String fecha_al) {
        this.fecha_al = fecha_al;
    }

    public String getFecha_solicitada() {
        return fecha_solicitada;
    }

    public void setFecha_solicitada(String fecha_solicitada) {
        this.fecha_solicitada = fecha_solicitada;
    }
   
   
}
