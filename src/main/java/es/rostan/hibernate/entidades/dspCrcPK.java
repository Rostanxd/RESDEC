package es.rostan.hibernate.entidades;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Rostan on 08/02/2017.
 */
@Embeddable
public class dspCrcPK implements Serializable{
    @Column(name = "dspCodigo")
    private long dspCodigo;

    @Column(name = "crcCodigo")
    private long crcCodigo;

    public dspCrcPK(){}

    public dspCrcPK(long dspCodigo, long crcCodigo){
        this.dspCodigo = dspCodigo;
        this.crcCodigo = crcCodigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof dspCrcPK)) return false;

        dspCrcPK dspCrcPK = (dspCrcPK) o;

        if (dspCodigo != dspCrcPK.dspCodigo) return false;
        return crcCodigo == dspCrcPK.crcCodigo;

    }

    @Override
    public int hashCode() {
        int result = (int) (dspCodigo ^ (dspCodigo >>> 32));
        result = 31 * result + (int) (crcCodigo ^ (crcCodigo >>> 32));
        return result;
    }
}
