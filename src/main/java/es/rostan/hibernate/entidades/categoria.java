package es.rostan.hibernate.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rostan on 12/02/2017.
 */
@Entity
@Table(name = "categoria")
public class categoria implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "ctgCodigo")
    private long ctgCodigo;

    @Column(name = "ctgDescripcion")
    private String ctgDescripcion;

    @OneToMany(mappedBy = "categoria")
    private List<subcategoria> lstSubcategoria = new ArrayList<subcategoria>();
//    CONSTRUCTORES
    public categoria(){}

    public categoria(String ctgDescripcion) {
        this.ctgDescripcion = ctgDescripcion;
    }

//    GETTER Y SETTER

    public long getCtgCodigo() {
        return ctgCodigo;
    }

    public String getCtgDescripcion() {
        return ctgDescripcion;
    }

    public void setCtgDescripcion(String ctgDescripcion) {
        this.ctgDescripcion = ctgDescripcion;
    }

//    STRING METHOD
    @Override
    public String toString() {
        return "categoria{" +
                "ctgCodigo=" + ctgCodigo +
                ", ctgDescripcion=" + ctgDescripcion +
                '}';
    }
}
