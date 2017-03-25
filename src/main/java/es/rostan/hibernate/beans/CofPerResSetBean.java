package es.rostan.hibernate.beans;

import es.rostan.hibernate.entidades.coeffPearResultSet;
import es.rostan.hibernate.entidades.dispositivo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rostan on 18/12/2016.
 */
@ManagedBean
@ViewScoped
public class CofPerResSetBean {

    private coeffPearResultSet cpRs = new coeffPearResultSet();

    private dispositivo dspRs = new dispositivo();

    private double valRs = 0.0;

//    GETTER Y SETTERS

    public coeffPearResultSet getCpRs() {
        return cpRs;
    }

    public void setCpRs(coeffPearResultSet cpRs) {
        this.cpRs = cpRs;
    }

    public dispositivo getDspRs() {
        return dspRs;
    }

    public void setDspRs(dispositivo dspRs) {
        this.dspRs = dspRs;
    }

    public double getValRs() {
        return valRs;
    }

    public void setValRs(double valRs) {
        this.valRs = valRs;
    }

//    Metodos

    public void dspSelected(coeffPearResultSet cp){
        this.dspRs = cp.dspRs;
        this.valRs = cp.valRs;
    }
}
