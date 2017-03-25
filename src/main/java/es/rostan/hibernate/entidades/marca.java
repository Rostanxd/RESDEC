package es.rostan.hibernate.entidades;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Rostan on 23/12/2016.
 */
@Entity
@Table(name = "marca")
public class marca implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "mrcCodigo")
    private long mrcCodigo;

    @Column(name = "mrcNombre")
    private String mrcNombre;

    @Column(name = "mrcEstado")
    private String mrcEstado;

//    cCONSTRUCTORES
    public marca(){}

    public marca(long mrcCodigo, String mrcNombre, String mrcEstado) {
        this.mrcCodigo = mrcCodigo;
        this.mrcNombre = mrcNombre;
        this.mrcEstado = mrcEstado;
    }

//    GETTER Y SETTER
    public long getMrcCodigo() {
        return mrcCodigo;
    }

    public void setMrcCodigo(long mrcCodigo) {
        this.mrcCodigo = mrcCodigo;
    }

    public String getMrcNombre() {
        return mrcNombre;
    }

    public void setMrcNombre(String mrcNombre) {
        this.mrcNombre = mrcNombre;
    }

    public String getMrcEstado() {
        return mrcEstado;
    }

    public void setMrcEstado(String mrcEstado) {
        this.mrcEstado = mrcEstado;
    }

//    METODOS
    @Override
    public String toString() {
        return "marca{" +
                "mrcCodigo='" + mrcCodigo + '\'' +
                ", mrcNombre='" + mrcNombre + '\'' +
                ", mrcEstado='" + mrcEstado + '\'' +
                '}';
    }
}
