package es.rostan.hibernate.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rostan on 12/02/2017.
 */
@Entity
@Table(name = "subcategoria")
public class subcategoria implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "subCodigo")
    private long subCodigo;

    @Column(name = "subDescripcion")
    private String subDescripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ctgCodigo")
    private categoria categoria = new categoria();

    @OneToMany(mappedBy = "subcategoria")
    private List<caracteristica> lstCaracteristicas = new ArrayList<caracteristica>();

//    CONSTRUCTORES
    public subcategoria(){}

    public subcategoria(String subDescripcion, categoria categoria) {
        this.subDescripcion = subDescripcion;
        this.categoria = categoria;
    }

//    GETTER Y SETTER
    public long getSubCodigo() {
        return subCodigo;
    }

    public String getSubDescripcion() {
        return subDescripcion;
    }

    public void setSubDescripcion(String sbcDescripcion) {
        this.subDescripcion = sbcDescripcion;
    }

    public es.rostan.hibernate.entidades.categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(es.rostan.hibernate.entidades.categoria categoria) {
        this.categoria = categoria;
    }

    public List<caracteristica> getLstCaracteristicas() {
        return lstCaracteristicas;
    }

    public void setLstCaracteristicas(List<caracteristica> lstCaracteristicas) {
        this.lstCaracteristicas = lstCaracteristicas;
    }

    //    STRING METHOD

    @Override
    public String toString() {
        return "subcategoria{" +
                "subCodigo=" + subCodigo +
                ", subDescripcion='" + subDescripcion + '\'' +
                ", categoria=" + categoria.getCtgDescripcion() +
                '}';
    }
}
