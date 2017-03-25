package es.rostan.hibernate.beans;

import es.rostan.hibernate.dao.usrDAO;
import es.rostan.hibernate.entidades.usrDspAppValoracion;
import es.rostan.hibernate.entidades.usuario;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rostan on 14/12/2016.
 */
@ManagedBean
@ViewScoped
public class usrBean {
    private usuario usr = new usuario();

    private List<usuario> lstUsr = new ArrayList<usuario>();

    private List<usrDspAppValoracion> lstUsrValoracion = new ArrayList<usrDspAppValoracion>();

    private String btnAction = "";

//    CONSTRUCTOR

    public usrBean(){}

//    GETTERS Y SETTERS
    public usuario getUsr() {
        return usr;
    }

    public void setUsr(usuario usr) {
        this.usr = usr;
    }

    public List<usuario> getLstUsr() {
        return lstUsr;
    }

    public void setLstUsr(List<usuario> lstUsr) {
        this.lstUsr = lstUsr;
    }

    public String getBtnAction() {
        return btnAction;
    }

    public void setBtnAction(String btnAction) {
        this.btnAction = btnAction;
    }

    public List<usrDspAppValoracion> getLstUsrValoracion() {
        return lstUsrValoracion;
    }

    public void setLstUsrValoracion(List<usrDspAppValoracion> lstUsrValoracion) {
        this.lstUsrValoracion = lstUsrValoracion;
    }

    //    METHODS
    public void searchLstUsr() throws Exception{
        usrDAO ud = new usrDAO();
        List<usuario> lstUsr = new ArrayList<usuario>();

        try{
            lstUsr = ud.getLstUsr();

            if(lstUsr != null){
                this.lstUsr = lstUsr;
            }
        }catch(Exception e){
            throw e;
        }
    }

    public void searchUsr(usuario usr){
        this.usr = usr;
    }

    public void searchUsrValoraciones(usuario usr) throws Exception{
        usrDAO ud = new usrDAO();
        List<usrDspAppValoracion> lstUsrValoracion = new ArrayList<usrDspAppValoracion>();
        try {
            if (lstUsrValoracion != null) {
                this.lstUsrValoracion = ud.getLstUsrValoracion(usr);
            }
        }catch(Exception e){
            throw e;
        }
    }
}
