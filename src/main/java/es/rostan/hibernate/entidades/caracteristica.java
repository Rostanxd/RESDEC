package es.rostan.hibernate.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Rostan on 13/09/2016.
 * Clase
 */

@Entity
@Table(name = "caracteristica")
public class caracteristica implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "crcCodigo")
    private long crcCodigo;

    @Column(name = "crcDescripcion")
    private String crcDescripcion;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "crcs")
    private Set<dispositivo> disps = new HashSet<dispositivo>(0);

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subCodigo")
    private subcategoria subcategoria = new subcategoria();

    //  CONSTRUCTORES
    public caracteristica(){}   //  Constructor vacio para hibernate

    public caracteristica(long crcCodigo, String crcDescripcion, subcategoria subcategoria) {
        this.crcCodigo = crcCodigo;
        this.crcDescripcion = crcDescripcion;
        this.subcategoria = subcategoria;
    }

    //  GETTER Y SETTERS
    public long getCrcCodigo() {
        return crcCodigo;
    }

    public void setCrcCodigo(long crcCodigo) {
        this.crcCodigo = crcCodigo;
    }

    public String getCrcDescripcion() {
        return crcDescripcion;
    }

    public void setCrcDescripcion(String crcDescripcion) {
        this.crcDescripcion = crcDescripcion;
    }

    public es.rostan.hibernate.entidades.subcategoria getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(es.rostan.hibernate.entidades.subcategoria subcategoria) {
        this.subcategoria = subcategoria;
    }

    //  METODOS

    @Override
    public String toString() {
        return "caracteristica{" +
                "crcCodigo=" + crcCodigo +
                ", crcDescripcion='" + crcDescripcion + '\'' +
                ", subcategoria=" + subcategoria.getSubDescripcion() +
                '}';
    }
}
