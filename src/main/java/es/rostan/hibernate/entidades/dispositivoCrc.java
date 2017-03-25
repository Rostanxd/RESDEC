package es.rostan.hibernate.entidades;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Rostan on 08/02/2017.
 */

@Entity
@Table(name = "dispositivoCrc")
@IdClass(dspCrcPK.class)
public class dispositivoCrc implements Serializable{

    @Id
    private long dspCodigo;

    @Id
    private long crcCodigo;

    @ManyToOne
    @JoinColumn(name = "dspCodigo", updatable = false, insertable = false,
        referencedColumnName = "dspCodigo")
    private dispositivo dsp;

    @ManyToOne
    @JoinColumn(name = "crcCodigo", updatable = false, insertable = false,
        referencedColumnName = "crcCodigo")
    private caracteristica crc;

    @Column(name = "dspCrcDescripcion")
    private String dspCrcDescripcion;

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

    public dispositivo getDsp() {
        return dsp;
    }

    public void setDsp(dispositivo dsp) {
        this.dsp = dsp;
    }

    public caracteristica getCrc() {
        return crc;
    }

    public void setCrc(caracteristica crc) {
        this.crc = crc;
    }
}
