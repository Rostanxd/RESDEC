package es.rostan.hibernate.beans;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import es.rostan.hibernate.dao.appDAO;
import es.rostan.hibernate.dao.matrizBooleanaDAO;
import es.rostan.hibernate.dao.matrizContenidoResultadoDAO;
import es.rostan.hibernate.dao.matrizReferencialDAO;
import es.rostan.hibernate.entidades.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Rostan on 22/02/2017.
 */
@ManagedBean
@ViewScoped
public class filtradoContenidoBean {

//    Lista de apps
    private List<app> lstApp = new ArrayList<app>();

//    App seleccionada
    private app appSelected = new app();

//    Caracteristicas para seleccionar
    private List<caracteristica> lstCaracteristicas = new ArrayList<caracteristica>();

//    Caracteristicas seleccionadas
    private List<caracteristica> lstCaracteristicasSelected = new ArrayList<caracteristica>();

//    No. de Regsitros
    private Integer noResultados = 0;

//    Orden de Resultados
    private String ordenResultados = "";

//    Matriz de Resultado por contenido
    private List<matrizContenidoResultado> lstMatrizContenidoResultado = new ArrayList<matrizContenidoResultado>();

    @PostConstruct
    public void init(){
        this.noResultados = 5;
        this.ordenResultados = "dsc";
        this.cargarLstApps();
    }

//    METHODS

//    Carga lista de aplicaciones para escoger
    private void cargarLstApps(){
        appDAO ad = new appDAO();
        this.lstApp = ad.getLstApp();
    }

//    Carga la lista de Caracteristicas a seleccionar
    public void cargarLstCaracteristicas(app a){
        matrizReferencialDAO mrd = new matrizReferencialDAO();
        this.appSelected = a;
        this.lstCaracteristicas = mrd.buscaCaracteristicasXApp(a);
        this.orderCrcXSubctg(this.lstCaracteristicas);
    }

    public void calcularContenido(){
        matrizReferencialDAO mrd = new matrizReferencialDAO();
        System.out.println("Creación de la Matriz Referencial...");
        mrd.insertaMatrizReferencial(this.appSelected, this.getLstCaracteristicasSelected());
        mrd.cargaMatrizReferencial(this.appSelected, this.getLstCaracteristicasSelected());

        System.out.println("Creación de la Matriz Booleana...");
        matrizBooleanaDAO mbd = new matrizBooleanaDAO();
        mbd.insertarMatrizBooleana(this.appSelected);

        System.out.println("Obteniendo Matriz Resultado...");
        matrizContenidoResultadoDAO mcrd = new matrizContenidoResultadoDAO();
        this.lstMatrizContenidoResultado = mcrd.listaContenidoResultado(this.appSelected);
        System.out.println("Matriz de resutlado por contenido lista..."+lstMatrizContenidoResultado.size());

//            Orden
        if (ordenResultados.equals("asc")) {
            orderAsc(this.lstMatrizContenidoResultado);
        } else {
            orderDsc(this.lstMatrizContenidoResultado);
        }

//            No. de dispositivos
        List<matrizContenidoResultado> lstFiltrada = new ArrayList<matrizContenidoResultado>();
        if (this.noResultados < this.lstMatrizContenidoResultado.size()){
            for (int i = 0; i < this.noResultados; i++) {
                lstFiltrada.add(lstMatrizContenidoResultado.get(i));
            }
            this.lstMatrizContenidoResultado = lstFiltrada;
        }

        System.out.println("Fin del Proceso...");
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Sistema de Recomendación: Calculo terminado.","Exito"));
    }

//    Ordena las Caracteristicas por la subcategoria
    public void orderCrcXSubctg(List<caracteristica> lstCrc){
        Collections.sort(lstCrc, new Comparator<caracteristica>(){
            @Override
            public int compare(caracteristica c1, caracteristica c2){
                return new String(c2.getSubcategoria().getSubDescripcion()).compareTo((String) c1.getSubcategoria().getSubDescripcion());
            }
        });
    }

    public void orderDsc(List<matrizContenidoResultado> lstRes){
        Collections.sort(lstRes, new Comparator<matrizContenidoResultado>(){
            @Override
            public int compare(matrizContenidoResultado cp1, matrizContenidoResultado cp2){
                return new Double(cp1.getValor()).compareTo((Double) cp2.getValor());
            }
        });
    }

    public void orderAsc(List<matrizContenidoResultado> lstRes){
        Collections.sort(lstRes, new Comparator<matrizContenidoResultado>(){
            @Override
            public int compare(matrizContenidoResultado cp1, matrizContenidoResultado cp2){
                return new Double(cp2.getValor()).compareTo((double) cp1.getValor());
            }
        });
    }

//    GETTERS Y SETTERS

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

    public List<caracteristica> getLstCaracteristicasSelected() {
        return lstCaracteristicasSelected;
    }

    public void setLstCaracteristicasSelected(List<caracteristica> lstCaracteristicasSelected) {
        this.lstCaracteristicasSelected = lstCaracteristicasSelected;
    }

    public List<caracteristica> getLstCaracteristicas() {
        return lstCaracteristicas;
    }

    public void setLstCaracteristicas(List<caracteristica> lstCaracteristicas) {
        this.lstCaracteristicas = lstCaracteristicas;
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

    public List<matrizContenidoResultado> getLstMatrizContenidoResultado() {
        return lstMatrizContenidoResultado;
    }

    public void setLstMatrizContenidoResultado(List<matrizContenidoResultado> lstMatrizContenidoResultado) {
        this.lstMatrizContenidoResultado = lstMatrizContenidoResultado;
    }
}
