package es.rostan.hibernate.beans;

import es.rostan.hibernate.dao.subcategoriaDAO;
import es.rostan.hibernate.entidades.subcategoria;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rostan on 17/02/2017.
 */
@ManagedBean
public class subcategoriaBean {

    private List<subcategoria> lstSubcategoria = new ArrayList<subcategoria>();

    @PostConstruct
    public void init(){
        searchSubcategorias();
    }

//    GETTERS Y SETTERS

    public List<subcategoria> getLstSubcategoria() {
        return lstSubcategoria;
    }

    public void setLstSubcategoria(List<subcategoria> lstSubcategoria) {
        this.lstSubcategoria = lstSubcategoria;
    }


//    METODOS

    public void searchSubcategorias(){
        subcategoriaDAO sd = new subcategoriaDAO();
        this.lstSubcategoria = sd.getLstSubCtg();
    }
}
