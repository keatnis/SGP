package com.component;

import com.model.ModelUsers;

public class ModelAction {

    public ModelUsers getUsuario() {
        return usuario;
    }

    public void setUser(ModelUsers user) {
        this.usuario = user;
    }

    public EventAction getEvent() {
        return event;
    }

    public void setEvent(EventAction event) {
        this.event = event;
    }

    public ModelAction(ModelUsers usuario, EventAction event) {
        this.usuario = usuario;
        this.event = event;
    }

    public ModelAction() {
    }

    private ModelUsers usuario;
    private EventAction event;
}
