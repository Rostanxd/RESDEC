package es.rostan.hibernate.entidades;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Rostan on 23/02/2017.
 */
@Entity
@Table(name = "matrizBooleana")
public class matrizBooleana implements Serializable{
    @Id
    private long appCodigo;

    @Id
    private long dspCodigo;

    @Id
    private long crcCodigo;

    @Column(name = "mtrBolExiste")
    private Boolean mtrBolExiste;

    @ManyToOne
    @JoinColumn(name = "appCodigo", updatable = false, insertable = false,
        referencedColumnName = "appCodigo")
    private app app;

    @ManyToOne
    @JoinColumn(name = "dspCodigo", updatable = false, insertable = false,
        referencedColumnName = "dspCodigo")
    private dispositivo dispositivo;

    @ManyToOne
    @JoinColumn(name = "crcCodigo", updatable = false, insertable = false,
        referencedColumnName = "crcCodigo")
    private caracteristica caracteristica;

//    CONSTRUCTORES
    public matrizBooleana(){

    }

    public matrizBooleana(Boolean mtrBolExiste, es.rostan.hibernate.entidades.app app, es.rostan.hibernate.entidades.dispositivo dispositivo, es.rostan.hibernate.entidades.caracteristica caracteristica) {
        this.mtrBolExiste = mtrBolExiste;
        this.app = app;
        this.dispositivo = dispositivo;
        this.caracteristica = caracteristica;
    }

//    GETTERS Y SETTERS
    public long getAppCodigo() {
        return appCodigo;
    }

    public void setAppCodigo(long appCodigo) {
        this.appCodigo = appCodigo;
    }

    public long getDspCodigo() {
        return dspCodigo;
    }

    public void setDspCodigo(long dspCodigo) {
        this.dspCodigo = dspCodigo;
    }

    public long getCrcCodigo() {
        return crcCodigo;
    }

    public void setCrcCodigo(long crcCodigo) {
        this.crcCodigo = crcCodigo;
    }

    public Boolean getMtrBolExiste() {
        return mtrBolExiste;
    }

    public void setMtrBolExiste(Boolean mtrBolExiste) {
        this.mtrBolExiste = mtrBolExiste;
    }

    public es.rostan.hibernate.entidades.app getApp() {
        return app;
    }

    public void setApp(es.rostan.hibernate.entidades.app app) {
        this.app = app;
    }

    public es.rostan.hibernate.entidades.dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(es.rostan.hibernate.entidades.dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    public es.rostan.hibernate.entidades.caracteristica getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(es.rostan.hibernate.entidades.caracteristica caracteristica) {
        this.caracteristica = caracteristica;
    }

    @Override
    public String toString() {
        return "matrizBooleana{" +
                "appCodigo=" + app.getAppDescripcion() +
                ", dspCodigo=" + dispositivo.getDspDescripcion() +
                ", crcCodigo=" + caracteristica.getCrcDescripcion() +
                ", mtrBolExiste=" + mtrBolExiste +
                '}';
    }
}
