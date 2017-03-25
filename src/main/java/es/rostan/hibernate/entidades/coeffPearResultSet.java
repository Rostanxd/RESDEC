package es.rostan.hibernate.entidades;

/**
 * Created by Rostan on 19/12/2016.
 */
public class coeffPearResultSet{

    public dispositivo dspRs = new dispositivo();

    public double valRs = 0.0;

//    CONSTRUCTORES

    public coeffPearResultSet(){}

    public coeffPearResultSet(dispositivo dspRs, double valRs) {
        this.dspRs = dspRs;
        this.valRs = valRs;
    }

    //    GETTERS Y SETTERS

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

}
