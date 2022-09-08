package com.component;

//import com.model.ModelUsers;

import com.model.ModelPaseSalida;


public interface EventAction {
    public void delete(ModelPaseSalida usuario);
    public void update(ModelPaseSalida usuario);
}
