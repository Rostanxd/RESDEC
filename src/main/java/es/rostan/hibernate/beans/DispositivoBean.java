package es.rostan.hibernate.beans;

import es.rostan.hibernate.dao.dspDAO;
import es.rostan.hibernate.dao.marcaDAO;
import es.rostan.hibernate.dao.modeloDAO;
import es.rostan.hibernate.entidades.dispositivo;
import es.rostan.hibernate.entidades.marca;
import es.rostan.hibernate.entidades.modelo;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.convert.FacesConverter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP on 04/12/2016.
 */
@ManagedBean
@ViewScoped
public class DispositivoBean {

    private dispositivo dispositivo = new dispositivo();

    private modelo modeloSelected = new modelo();

    private marca marcaSelected = new marca();

    private List<dispositivo> lstDsp = new ArrayList<dispositivo>();

    private List<marca> lstMarcas = new ArrayList<marca>();

    private List<modelo> lstModelos = new ArrayList<modelo>();

    private String btnAccion = "";

    private String existe = "";

    private Boolean dspCodigoDisabled = true;

    @PostConstruct
    private void init(){
        this.searchLstDsp();
        this.cargaMarcas();
        this.cargaModelos();
        System.out.println(dispositivo.toString());
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

    public List<marca> getLstMarcas() {
        return lstMarcas;
    }

    public void setLstMarcas(List<marca> lstMarcas) {
        this.lstMarcas = lstMarcas;
    }

    public modelo getModeloSelected() {
        return modeloSelected;
    }

    public void setModeloSelected(modelo modeloSelected) {
        this.modeloSelected = modeloSelected;
    }

    public marca getMarcaSelected() {
        return marcaSelected;
    }

    public void setMarcaSelected(marca marcaSelected) {
        this.marcaSelected = marcaSelected;
    }

    public List<modelo> getLstModelos() {
        return lstModelos;
    }

    public void setLstModelos(List<modelo> lstModelos) {
        this.lstModelos = lstModelos;
    }

    public Boolean getDspCodigoDisabled() {
        return dspCodigoDisabled;
    }

    public void setDspCodigoDisabled(Boolean dspCodigoDisabled) {
        this.dspCodigoDisabled = dspCodigoDisabled;
    }

    //    METHODS

    public void operar() throws Exception{
        if (btnAccion.equals("Ingresar")) {
            this.insertDsp();
            this.limpiar();
            this.dspCodigoDisabled = false;

        } else if (btnAccion.equals("Modificar")) {
            this.updateDsp();
            this.limpiar();
            this.dspCodigoDisabled = true;
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

    public void secuenciaDsp(){
        dspDAO ad = new dspDAO();
        this.dispositivo.setDspCodigo(ad.secuenciaDsp());
    }

    public void cargaMarcas(){
        marcaDAO md = new marcaDAO();
        this.lstMarcas = md.lstMarcas();
    }

    public void cargaModelos(){
        modeloDAO md = new modeloDAO();
        this.lstModelos = md.lstModelos();
    }
}
