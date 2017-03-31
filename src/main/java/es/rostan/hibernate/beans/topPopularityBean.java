package es.rostan.hibernate.beans;

import es.rostan.hibernate.dao.topPopularityDAO;
import es.rostan.hibernate.entidades.app;
import es.rostan.hibernate.entidades.topPopularity;

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
 * Created by Rostan on 20/03/2017.
 */
@ManagedBean
@ViewScoped
public class topPopularityBean {

    //  App para Top Popularity
    private app appSelected;

    //  Lista de aplicacionesa  escoger
    private List<app> lstApp;

    //  No. de registros a visualizar
    private Integer noResultados = 0;

    List<topPopularity> lstTopPopularity = new ArrayList<topPopularity>();

    private String ordenResultados = "";

    @PostConstruct
    public void init(){
        this.noResultados = 5;
        this.ordenResultados = "dsc"; //  Descendente
    }

    //  METODOS
    public void cargaTopPopularity(){
        topPopularityDAO tpd = new topPopularityDAO();
        List<topPopularity> lstTopPopularity2 = tpd.cargaTopPopularity(this.ordenResultados);
        this.lstTopPopularity.clear();

        for (int i=0; i < noResultados; i++){
            this.lstTopPopularity.add(new topPopularity(lstTopPopularity2.get(i).getDispositivo(),
                    lstTopPopularity2.get(i).getValor()));
        }

        System.out.println("Top Popularity: Terminado.");
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Sistema de Recomendación: Calculo terminado.","Exito"));
    }

    public void cargarAppsNuevas(){
        System.out.println("Carga Apss nuevas...");
        topPopularityDAO tpd = new topPopularityDAO();
        this.lstApp = tpd.cargarAppsNuevas();
    }

    public void asignaApp(app a){
        System.out.println(a.toString());
        this.appSelected = a;
    }

    //  GETTERS Y SETTERS
    public Integer getNoResultados() {
        return noResultados;
    }

    public void setNoResultados(Integer noResultados) {
        this.noResultados = noResultados;
    }

    public List<topPopularity> getLstTopPopularity() {
        return lstTopPopularity;
    }

    public void setLstTopPopularity(List<topPopularity> lstTopPopularity) {
        this.lstTopPopularity = lstTopPopularity;
    }

    public String getOrdenResultados() {
        return ordenResultados;
    }

    public void setOrdenResultados(String ordenResultados) {
        this.ordenResultados = ordenResultados;
    }

    public app getAppSelected() {
        return appSelected;
    }

    public void setAppSelected(app appSelected) {
        this.appSelected = appSelected;
    }

    public List<app> getLstApp() {
        return lstApp;
    }

    public void setLstApp(List<app> lstApp) {
        this.lstApp = lstApp;
    }
}
