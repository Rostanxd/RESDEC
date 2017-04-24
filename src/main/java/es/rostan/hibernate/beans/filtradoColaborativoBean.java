package es.rostan.hibernate.beans;

import es.rostan.hibernate.dao.appDAO;
import es.rostan.hibernate.dao.coeffPearsonDAO;
import es.rostan.hibernate.dao.matrizRelacionalDAO;
import es.rostan.hibernate.entidades.app;
import es.rostan.hibernate.entidades.coeffPearResultSet;
import es.rostan.hibernate.entidades.dispositivo;
import es.rostan.hibernate.entidades.metodo;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Rostan on 25/02/2017.
 */
@ManagedBean
@ViewScoped
public class filtradoColaborativoBean {

//    Metodo de la solucion
    private metodo metodoSelected = new metodo();

//    Lista de Metodos a utilizar.
    private List<metodo> lstMetodos = new ArrayList<metodo>();

//    Lista de apps a escoger
    private List<app> lstApp = new ArrayList<app>();

//    App seleccionada
    private app appSelected = new app();

//    Lista de dispositivos a escoger
    private List<dispositivo> lstDispositivo = new ArrayList<dispositivo>();

//    Dispositivo seleccionado
    private dispositivo dspSelected = new dispositivo();

//    No. de Resultados
    private Integer noResultados = 0;

//    Orden de resultados
    private String ordenResultados = "";

//    Conjunto resultado para el coeficiente de Pearson
    private List<coeffPearResultSet> lstCoeffPearson = new ArrayList<coeffPearResultSet>();

    @PostConstruct
    public void init(){
        this.noResultados = 5;
        this.ordenResultados = "dsc";
        this.cargaMetodos();
        this.cargarLstApps();
    }

//    METHODS
    private void cargaMetodos(){
        this.lstMetodos.add(new metodo(1, "Coeff. Pearson"));
        this.lstMetodos.add(new metodo(2, "Other..."));
    }

//    Carga de aplicaciones para escoger;
    private void cargarLstApps(){
        appDAO ad = new appDAO();
        this.lstApp = ad.getLstApp();
    }

//    Busca los dispositivos relacionados con la App
    public void searchDspConApp(app app){
        this.appSelected = app;

        System.out.println("Sistema de Recomendación: Calculo de Matriz referencial...");
        matrizRelacionalDAO mrd = new matrizRelacionalDAO();
        mrd.calculoMatrizRelacional(app);
        this.lstDispositivo = mrd.searchDspConApp(app);
    }

    public void calcularColaborativo() {
        System.out.println("Sistema de Recomendacion: Calculando...");
        System.out.println("Método seleccionado: " + this.metodoSelected.toString() + ".");

        System.out.println("Sistema de Recomendación: calculando recomendación");
        coeffPearsonDAO cpd = new coeffPearsonDAO();
        this.lstCoeffPearson = cpd.calculoCoeffPearson(this.dspSelected);

//            Orden
        if (ordenResultados.equals("dsc")) {
            orderAsc(this.lstCoeffPearson);
        } else {
            orderDsc(this.lstCoeffPearson);
        }

//            No. de dispositivos
        List<coeffPearResultSet> lstCpFiltrada = new ArrayList<coeffPearResultSet>();
        if (this.noResultados < this.getLstCoeffPearson().size()){
            for (int i = 0; i < this.noResultados; i++) {
                lstCpFiltrada.add(lstCoeffPearson.get(i));
            }
            this.lstCoeffPearson = lstCpFiltrada;
        }

        System.out.println("Sistema de Recomendación: Calculo terminado.");

        System.out.println(this.lstCoeffPearson.size());
        if (this.lstCoeffPearson.size() == 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "RESDEC: There are no related products.", "Error"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"RESDEC: Finished calculation.","Exito"));
        }
    }

    public void orderDsc(List<coeffPearResultSet> lstCp){
        Collections.sort(lstCp, new Comparator<coeffPearResultSet>(){
            @Override
            public int compare(coeffPearResultSet cp1, coeffPearResultSet cp2){
                return new Float(cp1.getValRs()).compareTo((float) cp2.getValRs());
            }
        });
    }

    public void orderAsc(List<coeffPearResultSet> lstCp){
        Collections.sort(lstCp, new Comparator<coeffPearResultSet>(){
            @Override
            public int compare(coeffPearResultSet cp1, coeffPearResultSet cp2){
                return new Float(cp2.getValRs()).compareTo((float) cp1.getValRs());
            }
        });
    }

//    GETTER Y SETTERS

    public List<metodo> getLstMetodos() {
        return lstMetodos;
    }

    public void setLstMetodos(List<metodo> lstMetodos) {
        this.lstMetodos = lstMetodos;
    }

    public metodo getMetodoSelected() {
        return metodoSelected;
    }

    public void setMetodoSelected(metodo metodoSelected) {
        this.metodoSelected = metodoSelected;
    }

    public List<app> getLstApp() {
        return lstApp;
    }

    public void setLstApp(List<app> lstApp) {
        this.lstApp = lstApp;
    }

    public app getAppSelected() {
        return appSelected;
    }

    public void setAppSelected(app appSelected) {
        this.appSelected = appSelected;
    }

    public List<dispositivo> getLstDispositivo() {
        return lstDispositivo;
    }

    public void setLstDispositivo(List<dispositivo> lstDispositivo) {
        this.lstDispositivo = lstDispositivo;
    }

    public dispositivo getDspSelected() {
        return dspSelected;
    }

    public void setDspSelected(dispositivo dspSelected) {
        this.dspSelected = dspSelected;
    }

    public Integer getNoResultados() {
        return noResultados;
    }

    public void setNoResultados(Integer noResultados) {
        this.noResultados = noResultados;
    }

    public String getOrdenResultados() {
        return ordenResultados;
    }

    public void setOrdenResultados(String ordenResultados) {
        this.ordenResultados = ordenResultados;
    }

    public List<coeffPearResultSet> getLstCoeffPearson() {
        return lstCoeffPearson;
    }

    public void setLstCoeffPearson(List<coeffPearResultSet> lstCoeffPearson) {
        this.lstCoeffPearson = lstCoeffPearson;
    }

}

