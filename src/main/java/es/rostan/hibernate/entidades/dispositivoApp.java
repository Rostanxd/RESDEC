package es.rostan.hibernate.entidades;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Rostan on 10/12/2016.
 */

@Entity
@Table(name = "matrizDspApp")
@IdClass(dspAppPk.class)
public class dispositivoApp implements Serializable{

    @Id
    private long dspCodigo;

    @Id
    private long appCodigo;

    @Column(name = "calificacion")
    private Double dspAppCalificacion;

    @ManyToOne
    @JoinColumn(name = "dspCodigo", updatable = false, insertable = false,
            referencedColumnName = "dspCodigo")
    private dispositivo dsp;

    @ManyToOne
    @JoinColumn(name = "appCodigo", updatable = false, insertable = false,
            referencedColumnName = "appCodigo")
    private app app;

    public long getDspCodigo() {
        return dspCodigo;
    }

    public void setDspCodigo(long dspCodigo) {
        this.dspCodigo = dspCodigo;
    }

    public long getAppCodigo() {
        return appCodigo;
    }

    public void setAppCodigo(long appCodigo) {
        this.appCodigo = appCodigo;
    }

    public Double getDspAppCalificacion() {
        return dspAppCalificacion;
    }

    public void setDspAppCalificacion(Double calificacion) {
        this.dspAppCalificacion = calificacion;
    }

    public dispositivo getDsp() {
        return dsp;
    }

    public void setDsp(dispositivo dsp) {
        this.dsp = dsp;
    }

    public es.rostan.hibernate.entidades.app getApp() {
        return app;
    }

    public void setApp(es.rostan.hibernate.entidades.app app) {
        this.app = app;
    }
}
