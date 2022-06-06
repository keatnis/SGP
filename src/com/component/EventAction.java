package com.component;

import com.model.ModelUsers;

public interface EventAction {
    public void delete(ModelUsers usuario);
    public void update(ModelUsers usuario);
}
