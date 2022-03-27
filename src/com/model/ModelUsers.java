package com.model;

import com.component.EventAction;
import com.component.ModelAction;
import java.text.DecimalFormat;


public class ModelUsers {

 

    

    public ModelUsers( String nombre, String usuario, String tipo,String estado ) {
      
        this.nombre = nombre;
        this.usuario =usuario;
        this.tipo = tipo;
        this.estado = estado;
    }

    public ModelUsers() {
    }

   
    private String nombre;
    private String usuario;
    private String tipo;
    private String estado;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Object[] toRowTable(EventAction event) {
       
        return new Object[]{nombre, usuario, tipo, estado, new ModelAction(this, event)};
    }
}
