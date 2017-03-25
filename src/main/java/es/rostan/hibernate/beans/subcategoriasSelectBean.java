package es.rostan.hibernate.beans;

import es.rostan.hibernate.dao.subcategoriaDAO;
import es.rostan.hibernate.entidades.caracteristica;
import es.rostan.hibernate.entidades.subcategoria;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rostan on 16/02/2017.
 */
@ManagedBean
public class subcategoriasSelectBean {

    private List<subcategoria> lstSubcategoria = new ArrayList<subcategoria>();

    private List<caracteristica> lstCaracteristicasSelect = new ArrayList<caracteristica>();

    @PostConstruct
    public void init(){
        searchSubcategorias();
    }

//    GETTER Y SETTERS

    public List<subcategoria> getLstSubcategoria() {
        return lstSubcategoria;
    }

    public void setLstSubcategoria(List<subcategoria> lstSubcategoria) {
        this.lstSubcategoria = lstSubcategoria;
    }

    public List<caracteristica> getLstCaracteristicasSelect() {
        return lstCaracteristicasSelect;
    }

    public void setLstCaracteristicasSelect(List<caracteristica> lstCaracteristicasSelect) {
        this.lstCaracteristicasSelect = lstCaracteristicasSelect;
    }

    //    METODOS

    public void searchSubcategorias(){
        subcategoriaDAO sd = new subcategoriaDAO();
        this.lstSubcategoria = sd.getLstSubCtg();
    }

    public void cargarCrcASolucion(solucionBean sb){
        System.out.println(this.lstCaracteristicasSelect);
        sb.getSol().lstCrc = this.lstCaracteristicasSelect;
    }
}
