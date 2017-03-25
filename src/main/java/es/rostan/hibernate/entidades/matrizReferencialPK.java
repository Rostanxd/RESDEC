package es.rostan.hibernate.entidades;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Rostan on 19/02/2017.
 */
@Embeddable
public class matrizReferencialPK implements Serializable{
    @Column(name = "appCodigo")
    private long appCodigo;

    @Column(name = "crcCodigo")
    private long crcCodigo;

//    CONSTRUCTOR
    public matrizReferencialPK(){}

    public matrizReferencialPK(long appCodigo, long crcCodigo) {
        this.appCodigo = appCodigo;
        this.crcCodigo = crcCodigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof matrizReferencialPK)) return false;

        matrizReferencialPK that = (matrizReferencialPK) o;

        if (appCodigo != that.appCodigo) return false;
        return crcCodigo == that.crcCodigo;
    }

    @Override
    public int hashCode() {
        int result = (int) (appCodigo ^ (appCodigo >>> 32));
        result = 31 * result + (int) (crcCodigo ^ (crcCodigo >>> 32));
        return result;
    }
}
