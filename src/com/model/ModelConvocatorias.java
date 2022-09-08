
package com.model;


public class ModelConvocatorias {
     String Noconvocatoria,fechaInicio,fechaFinalizacion,fechaPublicación,linkFacebook,linkPW,estatus,periodo;
     int noVacante,id;
     byte [] archivo;

    public byte[] getArchivo() {
        return archivo;
    }

    public void setArchivo(byte[] archivo) {
        this.archivo = archivo;
    }

    public String getEstatus() {
        return estatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getNoconvocatoria() {
        return Noconvocatoria;
    }

    public void setNoconvocatoria(String Noconvocatoria) {
        this.Noconvocatoria = Noconvocatoria;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(String fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public String getFechaPublicación() {
        return fechaPublicación;
    }

    public void setFechaPublicación(String fechaPublicación) {
        this.fechaPublicación = fechaPublicación;
    }

    public String getLinkFacebook() {
        return linkFacebook;
    }

    public void setLinkFacebook(String linkFacebook) {
        this.linkFacebook = linkFacebook;
    }

    public String getLinkPW() {
        return linkPW;
    }

    public void setLinkPW(String linkPW) {
        this.linkPW = linkPW;
    }

    public int getNoVacante() {
        return noVacante;
    }

    public void setNoVacante(int noVacante) {
        this.noVacante = noVacante;
    }

 
     
     
}
