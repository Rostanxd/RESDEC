package es.rostan.hibernate.entidades;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by HP on 23/12/2016.
 */
@Entity
@Table(name = "modelo")
public class modelo implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "mdlCodigo")
    private long mdlCodigo;

    @Column(name = "mdlNombre")
    private String mdlNombre;

    @Column(name = "mdlEstado")
    private String mdlEstado;

//    CONSTRUCTORES
    public modelo(){}

    public modelo(long mdlCodigo, String mdlNombre, String mdlEstado) {
        this.mdlCodigo = mdlCodigo;
        this.mdlNombre = mdlNombre;
        this.mdlEstado = mdlEstado;
    }

//    GETTER Y SETTER
    public long getMdlCodigo() {
        return mdlCodigo;
    }

    public void setMdlCodigo(long mdlCodigo) {
        this.mdlCodigo = mdlCodigo;
    }

    public String getMdlNombre() {
        return mdlNombre;
    }

    public void setMdlNombre(String mdlNombre) {
        this.mdlNombre = mdlNombre;
    }

    public String getMdlEstado() {
        return mdlEstado;
    }

    public void setMdlEstado(String mdlEstado) {
        this.mdlEstado = mdlEstado;
    }

//    METHODS
    @Override
    public String toString() {
        return "modelo{" +
                "mdlEstado='" + mdlEstado + '\'' +
                ", mdlNombre='" + mdlNombre + '\'' +
                ", mdlCodigo='" + mdlCodigo + '\'' +
                '}';
    }
}
