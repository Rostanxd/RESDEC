package es.rostan.hibernate.entidades;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Rostan on 13/12/2016.
 */
@Entity
@Table(name = "usrDspAppValoracion")
public class usrDspAppValoracion implements Serializable{

    @Id
    private long usrCodigo;

    @Id
    private long dspCodigo;

    @Id
    private long appCodigo;

    @Column(name = "usrDspValor")
    private Integer usrDspAppValor;

    @ManyToOne
    @JoinColumn(name = "usrCodigo", updatable = false, insertable = false, referencedColumnName = "usrCodigo")
    private usuario usr;

    @ManyToOne
    @JoinColumn(name = "dspCodigo", updatable = false, insertable = false, referencedColumnName = "dspCodigo")
    private dispositivo dsp;

    @ManyToOne
    @JoinColumn(name = "appCodigo", updatable = false, insertable = false, referencedColumnName = "appCodigo")
    private app app;

//    GETTER Y SETTERS
    public long getUsrCodigo() {
        return usrCodigo;
    }

    public void setUsrCodigo(long usrCodigo) {
        this.usrCodigo = usrCodigo;
    }

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

    public Integer getUsrDspAppValor() {
        return usrDspAppValor;
    }

    public void setUsrDspAppValor(Integer usrDspValor) {
        this.usrDspAppValor = usrDspValor;
    }

    public usuario getUsr() {
        return usr;
    }

    public void setUsr(usuario usr) {
        this.usr = usr;
    }

    public dispositivo getDsp() {
        return dsp;
    }

    public void setDsp(dispositivo dsp) {
        this.dsp = dsp;
    }

    public app getApp() {
        return app;
    }

    public void setApp(app app) {
        this.app = app;
    }

//    METHODS
    @Override
    public String toString() {
        return "usrDspAppValoracion{" +
                "usrCodigo=" + usrCodigo +
                ", dspCodigo='" + dspCodigo + '\'' +
                ", appCodigo='" + appCodigo + '\'' +
                ", usrDspValor=" + usrDspAppValor +
                '}';
    }
}
