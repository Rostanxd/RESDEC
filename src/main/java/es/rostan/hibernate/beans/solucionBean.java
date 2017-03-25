package es.rostan.hibernate.beans;

import es.rostan.hibernate.dao.solucionDAO;
import es.rostan.hibernate.entidades.*;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.*;

/**
 * Created by Rostan on 20/12/2016.
 */
@ManagedBean
@ViewScoped
public class solucionBean {

    private solucion sol = new solucion();

    private List<dispositivo> lstDspConApp = new ArrayList<dispositivo>();  //  Lista de dispositivos a poder usar (Colavorativo)

    private List<dispositivo> lstDspConCrc = new ArrayList<dispositivo>();  // Lista de dispositivos que tienen las caracteristicas escogidas (Contenido)

    private List<caracteristica> lstCrc = new ArrayList<caracteristica>();  //  Lista de caracteristicas a filtrar entre los dispositivos

    private String calMatriz = "";  //  Especificara el metodo para la media de los dispositivos

    private String sisRecom = "";   //  Especificara cual metodo se usara para el calculo lineal

    private Integer noReg = 0;  //  Numero de dispositvos a vizualizar

    private String order = "";  //  Orden del array

    @PostConstruct
    public void init(){

    }

//    GETTER Y SETTER

    public solucion getSol() {
        return sol;
    }

    public void setSol(solucion sol) {
        this.sol = sol;
    }

    public String getCalMatriz() {
        return calMatriz;
    }

    public void setCalMatriz(String calMatriz) {
        this.calMatriz = calMatriz;
    }

    public String getSisRecom() {
        return sisRecom;
    }

    public void setSisRecom(String sisRecom) {
        this.sisRecom = sisRecom;
    }

    public List<dispositivo> getLstDspConApp() {
        return lstDspConApp;
    }

    public void setLstDspConApp(List<dispositivo> lstDspConApp) {
        this.lstDspConApp = lstDspConApp;
    }

    public List<dispositivo> getLstDspConCrc() {
        return lstDspConCrc;
    }

    public void setLstDspConCrc(List<dispositivo> lstDspConCrc) {
        this.lstDspConCrc = lstDspConCrc;
    }

    public Integer getNoReg() {
        return noReg;
    }

    public void setNoReg(Integer noReg) {
        this.noReg = noReg;
    }

    public void setApp(app app){
        this.sol.setApp(app);
    }

    public void setDspBase(dispositivo dspBase){
        this.sol.setDspBase(dspBase);
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public List<caracteristica> getLstCrc() {
        return lstCrc;
    }

    public void setLstCrc(List<caracteristica> lstCrc) {
        this.lstCrc = lstCrc;
    }

    //    METODOS

    public void calculoMatrizDspApp(){
        solucionDAO sd = new solucionDAO();
        sd.matrizDspApp();
    }

    public void procesar(){
        //  Pregunta si se usara el metodo de Coeff Pearson
        System.out.println("El sistema de recomendacion a usar es: "+sisRecom);

        if (sisRecom.equals("CPE")) {
            System.out.println("Entro...");

            solucionDAO sd = new solucionDAO();
            sd.calculoCoeffPearson(this.sol);

            List<coeffPearResultSet> lstCp = new ArrayList<coeffPearResultSet>();
            lstCp = this.sol.getCffPerResSet();

//            Orden
            if (order.equals("asc")) {
                orderAsc(lstCp);
            }else{
                orderDsc(lstCp);
            }

//            No. de dispositivos
            List<coeffPearResultSet> lstCpFiltrada = new ArrayList<coeffPearResultSet>();
            for (int i = 0; i < this.noReg; i++) {
                lstCpFiltrada.add(lstCp.get(i));
            }

            this.sol.setCffPerResSet(lstCpFiltrada);
        }
    }

    public void getDspConApp(){
        solucionDAO sd = new solucionDAO();
//        sd.matrizDspApp();
        this.lstDspConApp = sd.searchDspConApp(this.sol.getApp());
    }

    public void getDspConCrc(){
        solucionDAO sd = new solucionDAO();
        this.lstDspConCrc = sd.searchDspConCrc(this.sol.lstCrc);
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
}
