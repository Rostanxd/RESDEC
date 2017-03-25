package es.rostan.hibernate.entidades;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Rostan on 11/12/2016.
 */
@Embeddable
public class dspAppPk implements Serializable{
    @Column(name = "dspCodigo")
    private long dspCodigo;

    @Column(name = "appCodigo")
    private long appCodigo;

    public dspAppPk(){}

    public dspAppPk(long dspCodigo, long appCodigo) {
        this.dspCodigo = dspCodigo;
        this.appCodigo = appCodigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof dspAppPk)) return false;

        dspAppPk dspAppPk = (dspAppPk) o;

        if (dspCodigo != dspAppPk.dspCodigo) return false;
        return appCodigo == dspAppPk.appCodigo;

    }

    @Override
    public int hashCode() {
        int result = (int) (dspCodigo ^ (dspCodigo >>> 32));
        result = 31 * result + (int) (appCodigo ^ (appCodigo >>> 32));
        return result;
    }
}
