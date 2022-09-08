package com.model;

import javax.swing.Icon;

public class ModelEmpleado {

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

  

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ModelEmpleado(Icon icon, String name, String numEmp, String tipoContrato, String status) {
        this.icon = icon;
        this.name = name;
        this.numEmp = numEmp ;
        this.tipoContrato= tipoContrato;
        this.status = status;
    }

    public ModelEmpleado() {
    }

    private Icon icon;
    private String name;
    private String numEmp;
    private String tipoContrato;

    public String getNumEmp() {
        return numEmp;
    }

    public void setNumEmp(String numEmp) {
        this.numEmp = numEmp;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }
    private String status;

    public Object[] toDataTable() {
        return new Object[]{icon, name, numEmp, tipoContrato, status};
    }
}
