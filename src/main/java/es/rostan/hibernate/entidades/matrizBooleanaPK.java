package es.rostan.hibernate.entidades;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Rostan on 23/02/2017.
 */
@Embeddable
public class matrizBooleanaPK implements Serializable{
    @Column(name = "appCodigo")
    private long appCodigo;

    @Column(name = "dspCodigo")
    private long dspCodigo;

    @Column(name = "crcCodigo")
    private long crcCodigo;

//    CONSTRUCTOR
    public matrizBooleanaPK(){}

    public matrizBooleanaPK(long appCodigo, long dspCodigo, long crcCodigo) {
        this.appCodigo = appCodigo;
        this.dspCodigo = dspCodigo;
        this.crcCodigo = crcCodigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof matrizBooleanaPK)) return false;

        matrizBooleanaPK that = (matrizBooleanaPK) o;

        if (appCodigo != that.appCodigo) return false;
        if (dspCodigo != that.dspCodigo) return false;
        return crcCodigo == that.crcCodigo;
    }

    @Override
    public int hashCode() {
        int result = (int) (appCodigo ^ (appCodigo >>> 32));
        result = 31 * result + (int) (dspCodigo ^ (dspCodigo >>> 32));
        result = 31 * result + (int) (crcCodigo ^ (crcCodigo >>> 32));
        return result;
    }
}
