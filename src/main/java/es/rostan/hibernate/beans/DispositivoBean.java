package es.rostan.hibernate.beans;

import es.rostan.hibernate.dao.dspDAO;
import es.rostan.hibernate.entidades.dispositivo;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP on 04/12/2016.
 */
@ManagedBean
@ViewScoped
public class DispositivoBean {

    private dispositivo dispositivo = new dispositivo();

    private List<dispositivo> lstDsp = new ArrayList();

    private String btnAccion = "";

    private String existe = "";

    @PostConstruct
    private void init(){
        this.searchLstDsp();
    }

//    GETTERS Y SETTERS

    public dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    public List<dispositivo> getLstDsp() {
        return lstDsp;
    }

    public void setLstDsp(List<dispositivo> lstDsp) {
        this.lstDsp = lstDsp;
    }

    public String getBtnAccion() {
        return btnAccion;
    }

    public void setBtnAccion(String btnAccion) {
        this.limpiar();
        this.btnAccion = btnAccion;
    }

    public String getExiste() {
        return existe;
    }

    public void setExiste(String existe) {
        this.existe = existe;
    }

//    METHODS

    public void operar() throws Exception{
        if (btnAccion.equals("Ingresar")) {
            this.insertDsp();
            this.limpiar();

        } else if (btnAccion.equals("Modificar")) {
            this.updateDsp();
            this.limpiar();

        }
    }

    public void limpiar(){
        this.dispositivo.setDspCodigo(0);
        this.dispositivo.setDspDescripcion("");
        this.dispositivo.setDspEstado("");
    }

    public void searchLstDsp(){
        dspDAO dd = new dspDAO();
        this.lstDsp = dd.getLstDsp();
    }

    private void insertDsp() throws Exception{
        dspDAO dd = new dspDAO();
        dd.insertDsp(this.dispositivo);
        this.searchLstDsp();
    }

    public void searchDsp(dispositivo inDsp) throws Exception{
        dspDAO dd = new dspDAO();
        dispositivo dsp = dd.getDsp(inDsp);

        if(dsp != null) {
            this.dispositivo = dsp;
            this.btnAccion = "Modificar";
        }
    }

    private void updateDsp() throws Exception{
        dspDAO dd = new dspDAO();
        dd.updateDsp(this.dispositivo);
    }

    public void deleteDsp() throws Exception{
        dspDAO dd = new dspDAO();
        dd.deleteDsp(this.dispositivo);
    }
}
