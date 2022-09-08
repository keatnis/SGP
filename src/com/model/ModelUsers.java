package com.model;

import com.component.EventAction;
import com.component.ModelAction;
import java.awt.Image;



public class ModelUsers {


    public ModelUsers( String nombre, String usuario,String tipo,String estado ) {
      
        this.nombre = nombre;
        this.usuario =usuario;
        this.tipo = tipo;
        this.estado = estado;
    }
//  public ModelUsers(int id_usuario, String usuario ) {
//        this.id_usuario = id_usuario;
//        this.usuario = usuario;
// 
//    }
    public ModelUsers() {
    }

    private int id_usuario;
   private String nombre;
    private String usuario;
    private String tipo;
    private String estado;
    private String cargo;
    private String correo;
    private String last_session;
    private String password;
    private Image avatar;
    private String ruta;

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
 
    public Image getAvatar() {
        return avatar;
    }

    public void setAvatar(Image avatar) {
        this.avatar = avatar;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getLast_session() {
        return last_session;
    }

    public void setLast_session(String last_session) {
        this.last_session = last_session;
    }
   

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
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
