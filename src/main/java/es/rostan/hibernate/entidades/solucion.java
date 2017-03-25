package es.rostan.hibernate.entidades;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rostan on 20/12/2016.
 */
public class solucion {

    public app app = new app();

    public List<caracteristica> lstCrc = new ArrayList<caracteristica>();

    public List<String> lstCrcCodigo = new ArrayList<String>();

    public dispositivo dspBase = new dispositivo();

    public List<coeffPearResultSet> cffPerResSet = new ArrayList<coeffPearResultSet>();   //  Alamacenara el result set del coeficiente de pearson.

//    GETTER Y SETTER

    public es.rostan.hibernate.entidades.app getApp() {
        return app;
    }

    public void setApp(es.rostan.hibernate.entidades.app app) {
        this.app = app;
    }

    public List<caracteristica> getLstCrc() {
        return lstCrc;
    }

    public List<String> getLstCrcCodigo() {
        return lstCrcCodigo;
    }

    public void setLstCrcCodigo(List<String> lstCrcCodigo) {
        this.lstCrcCodigo = lstCrcCodigo;
    }

    public void setLstCrc(List<caracteristica> lstCrc) {
        this.lstCrc = lstCrc;
    }

    public dispositivo getDspBase() {
        return dspBase;
    }

    public void setDspBase(dispositivo dspBase) {
        this.dspBase = dspBase;
    }

    public List<coeffPearResultSet> getCffPerResSet() {
        return cffPerResSet;
    }

    public void setCffPerResSet(List<coeffPearResultSet> cffPerResSet) {
        this.cffPerResSet = cffPerResSet;
    }

}
