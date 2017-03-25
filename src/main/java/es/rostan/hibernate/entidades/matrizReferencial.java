package es.rostan.hibernate.entidades;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Rostan on 19/02/2017.
 */

@Entity
@Table(name = "matrizReferencial")
public class matrizReferencial implements Serializable{
    @Id
    private long appCodigo;

    @Id
    private long crcCodigo;

    @Column(name = "mtrRefSumatoria")
    private Integer mtrRefSumatoria;

    @Column(name = "mtrRefContador")
    private Integer mtrRefContador;

    @ManyToOne
    @JoinColumn(name = "appCodigo", updatable = false, insertable = false,
            referencedColumnName = "appCodigo")
    private app app;

    @ManyToOne
    @JoinColumn(name = "crcCodigo", updatable = false, insertable = false,
            referencedColumnName = "CrcCodigo")
    private caracteristica caracteristica;

//    CONSTRUCTORES
    public matrizReferencial(){

    }

    public matrizReferencial(Integer mtrRefSumatoria, Integer mtrRefContador, es.rostan.hibernate.entidades.app app, es.rostan.hibernate.entidades.caracteristica caracteristica) {
        this.mtrRefSumatoria = mtrRefSumatoria;
        this.mtrRefContador = mtrRefContador;
        this.app = app;
        this.caracteristica = caracteristica;
    }

    //    GETTERs Y SETTERS
    public long getAppCodigo() {
        return appCodigo;
    }

    public void setAppCodigo(long appCodigo) {
        this.appCodigo = appCodigo;
    }

    public long getCrcCodigo() {
        return crcCodigo;
    }

    public void setCrcCodigo(long crcCodigo) {
        this.crcCodigo = crcCodigo;
    }

    public Integer getMtrRefSumatoria() {
        return mtrRefSumatoria;
    }

    public void setMtrRefSumatoria(Integer mtrRefSumatoria) {
        this.mtrRefSumatoria = mtrRefSumatoria;
    }

    public Integer getMtrRefContador() {
        return mtrRefContador;
    }

    public void setMtrRefContador(Integer mtrRefContador) {
        this.mtrRefContador = mtrRefContador;
    }

    public es.rostan.hibernate.entidades.app getApp() {
        return app;
    }

    public void setApp(es.rostan.hibernate.entidades.app app) {
        this.app = app;
    }

    public es.rostan.hibernate.entidades.caracteristica getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(es.rostan.hibernate.entidades.caracteristica caracteristica) {
        this.caracteristica = caracteristica;
    }

//    OVERRIDE

    @Override
    public String toString() {
        return "matrizReferencial{" +
                "appCodigo=" + appCodigo +
                ", crcCodigo=" + crcCodigo +
                ", mtrRefSumatoria=" + mtrRefSumatoria +
                ", mtrRefContador=" + mtrRefContador +
                ", app=" + app +
                ", caracteristica=" + caracteristica +
                '}';
    }
}
