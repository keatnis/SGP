package com.component;

import com.model.ModelUsers;

public class ModelAction {

    public ModelUsers getUser() {
        return user;
    }

    public void setUser(ModelUsers user) {
        this.user = user;
    }

    public EventAction getEvent() {
        return event;
    }

    public void setEvent(EventAction event) {
        this.event = event;
    }

    public ModelAction(ModelUsers user, EventAction event) {
        this.user = user;
        this.event = event;
    }

    public ModelAction() {
    }

    private ModelUsers user;
    private EventAction event;
}
