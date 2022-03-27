package com.component;

import com.model.ModelUsers;

public interface EventAction {
    public void delete(ModelUsers user);
    public void update(ModelUsers user);
}
