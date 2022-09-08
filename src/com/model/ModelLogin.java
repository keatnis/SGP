package com.model;

public class ModelLogin {

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ModelLogin(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public ModelLogin() {
    }

    private String usuario;
    private String password;
}
