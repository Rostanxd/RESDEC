package es.rostan.hibernate.beans;

import es.rostan.hibernate.dao.caracteristicaDAO;
import es.rostan.hibernate.entidades.caracteristica;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rostan on 04/12/2016.
 */
@ManagedBean
@ViewScoped
public class CaracteristicaBean {

    private caracteristica crc = new caracteristica();

    private List<caracteristica> lstCrc = new ArrayList();

    private String btnAccion;

//    CONSTRUCTOR VACIO

    public CaracteristicaBean(){

    }

//    GETTERS Y SETTERS

    public caracteristica getCrc() {
        return crc;
    }

    public void setCrc(caracteristica crc) {
        this.crc = crc;
    }

    public List<caracteristica> getLstCrc() {
        return lstCrc;
    }

    public void setLstCrc(List<caracteristica> lstCrc) {
        this.lstCrc = lstCrc;
    }

    public String getBtnAccion() {
        return btnAccion;
    }

    public void setBtnAccion(String btnAccion) {
        this.btnAccion = btnAccion;
    }

//    METHODS

    public void operar() throws Exception{
        if (btnAccion.equals("Ingresar")) {
            this.insertCrc();
            this.limpiar();

        } else if (btnAccion.equals("Modificar")) {
            this.updateCrc();
            this.limpiar();

        }
    }

    public void limpiar(){
        this.crc.setCrcCodigo(0);
        this.crc.setCrcDescripcion("");
    }


    public void searchLstCrc() throws Exception{
        caracteristicaDAO cd = new caracteristicaDAO();

        List<caracteristica> lstCrc;

        try{
            lstCrc = cd.getLstCrc();
            if(lstCrc != null){
                this.lstCrc = lstCrc;
            }
        }catch (Exception e){
            throw e;
        }
    }

    public void insertCrc() throws Exception{
        caracteristicaDAO cd = new caracteristicaDAO();
        cd.insertCrc(this.crc);
    }

    public void searchCrc(caracteristica inCrc) throws Exception{
        caracteristicaDAO cd = new caracteristicaDAO();
        caracteristica crc = cd.getCrc(inCrc);
        if(crc!=null){
            this.crc = crc;
            this.btnAccion = "Modificar";
        }
    }

    private void updateCrc() throws Exception{
        caracteristicaDAO cd = new caracteristicaDAO();
        cd.updateCrc(this.crc);
    }

    public void deletecrc() throws Exception{
        caracteristicaDAO cd = new caracteristicaDAO();
        cd.deleteCrc(this.crc);
    }

}
