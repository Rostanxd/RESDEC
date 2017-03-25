package es.rostan.hibernate.entidades;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Rostan on 13/12/2016.
 */
@Embeddable
public class usrDspAppPK implements Serializable{
    @Column(name = "usrCodigo")
    private long usrCodigo;

    @Column(name = "dspCodigo")
    private long dspCodigo;

    @Column(name = "appCodigo")
    private long appCodigo;

//    CONSTRUCTORES

    public usrDspAppPK(){}

    public usrDspAppPK(Integer usrCodigo, long dspCodigo, long appCodigo) {
        this.usrCodigo = usrCodigo;
        this.dspCodigo = dspCodigo;
        this.appCodigo = appCodigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof usrDspAppPK)) return false;

        usrDspAppPK that = (usrDspAppPK) o;

        if (usrCodigo != that.usrCodigo) return false;
        if (dspCodigo != that.dspCodigo) return false;
        return appCodigo == that.appCodigo;

    }

    @Override
    public int hashCode() {
        int result = (int) (usrCodigo ^ (usrCodigo >>> 32));
        result = 31 * result + (int) (dspCodigo ^ (dspCodigo >>> 32));
        result = 31 * result + (int) (appCodigo ^ (appCodigo >>> 32));
        return result;
    }
}
