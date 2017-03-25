package es.rostan.hibernate.beans;

import es.rostan.hibernate.dao.topPopularityDAO;
import es.rostan.hibernate.entidades.topPopularity;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
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
}
