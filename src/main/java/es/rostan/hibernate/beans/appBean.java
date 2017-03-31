package es.rostan.hibernate.beans;

import es.rostan.hibernate.dao.appDAO;
import es.rostan.hibernate.entidades.app;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rostan on 03/12/2016.
 */
@ManagedBean
@ViewScoped
public class appBean {

    private app app = new app();

    private List<app> lstApp = new ArrayList();

    private String btnAccion = "";

    public appBean(){

    }

    public app getApp() {
        return app;
    }

    public void setApp(app app) {
        this.app = app;
    }

    public List<app> getLstApp() {
        return lstApp;
    }

    public void setLstApp(List<app> lstApp) {
        this.lstApp = lstApp;
    }

    public String getBtnAccion() {
        return btnAccion;
    }

    public void setBtnAccion(String btnAccion) {
        this.limpiar();
        this.btnAccion = btnAccion;
        if (btnAccion.equals("Ingresar")){
            this.secuenciaApp();
        }
    }

    public void operar() throws Exception{
        if (btnAccion.equals("Ingresar")) {
            this.insertApp();
            this.limpiar();
        } else if (btnAccion.equals("Modificar")) {
            this.updateApp();
            this.limpiar();
        }
    }

    public void limpiar(){
        this.app.setAppCodigo(0);
        this.app.setAppDescripcion("");
    }

    public void searchLstApp() throws Exception{
        appDAO ad = new appDAO();
        List<app> lstApp;
        try{
            lstApp = ad.getLstApp();
            if( lstApp != null){
                this.lstApp = lstApp;
            }
        }catch(Exception e){
            throw e;
        }
    }

    public void insertApp() throws Exception{
        appDAO ad = new appDAO();
        this.app.setAppEstado("N");
        ad.insertApp(this.app);
    }

    public void searchApp(app inApp) throws Exception{
        appDAO ad = new appDAO();
        app app = ad.getApp(inApp);
        if(app != null){
            this.app = app;
            this.btnAccion = "Modificar";
        }
    }

    private void updateApp() throws Exception{
        appDAO ad = new appDAO();
        ad.updateApp(this.app);
    }

    public void deleteApp() throws Exception{
        appDAO ad = new appDAO();
        ad.deleteApp(this.app);
    }

    public void secuenciaApp(){
        appDAO ad = new appDAO();
        this.app.setAppCodigo(ad.secuenciaApp());
    }
}
