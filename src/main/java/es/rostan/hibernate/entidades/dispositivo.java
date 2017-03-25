package es.rostan.hibernate.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * Created by Rostan on 14/09/2016.
 */

@Entity
@Table(name = "dispositivo")
public class dispositivo implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "dspCodigo")
    private long dspCodigo;

    @Column(name = "dspDescripcion")
    private String dspDescripcion;

    @Column(name = "dspEstado")
    private String dspEstado;

//    ATT RELACIONADOS
    @OneToMany(mappedBy = "dsp")
    private Set<dispositivoApp> apps = new HashSet<dispositivoApp>(0);

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "dispositivoCrc", catalog = "dbbaseconocimiento", joinColumns = {
            @JoinColumn(name = "dspCodigo", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "crcCodigo", nullable = false, updatable = false)})
    private Set<caracteristica> crcs = new HashSet<caracteristica>(0);

    @OneToMany(mappedBy = "dsp")
    private Set<usrDspAppValoracion> usrVotaciones = new HashSet<usrDspAppValoracion>(0);

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mrcCodigo")
    private marca marca;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mdlCodigo")
    private modelo modelo;

    //  CONSTRUCTORES
    public dispositivo() {} //  Constructor vacio para hibernate.

    public dispositivo(long dspCodigo, String dspDescripcion, String dspEstado) {
        this.dspCodigo = dspCodigo;
        this.dspDescripcion = dspDescripcion;
        this.dspEstado = dspEstado;
    }

    //  GETTERS Y SETTERS
    public long getDspCodigo() {
        return dspCodigo;
    }

    public void setDspCodigo(long dspCodigo) {
        this.dspCodigo = dspCodigo;
    }

    public String getDspDescripcion() {
        return dspDescripcion;
    }

    public void setDspDescripcion(String dspDescripcion) {
        this.dspDescripcion = dspDescripcion;
    }

    public String getDspEstado() {
        return dspEstado;
    }

    public void setDspEstado(String dspEstado) {
        this.dspEstado = dspEstado;
    }

    public Set<dispositivoApp> getApps() {
        return apps;
    }

    public void setApps(Set<dispositivoApp> dspApp) {
        this.apps = dspApp;
    }

    public Set<caracteristica> getCrcs() {
        return crcs;
    }

    public void setCrcs(Set<caracteristica> crcs) {
        this.crcs = crcs;
    }

    public Set<usrDspAppValoracion> getUsrVotaciones() {
        return usrVotaciones;
    }

    public void setUsrVotaciones(Set<usrDspAppValoracion> usrVotaciones) {
        this.usrVotaciones = usrVotaciones;
    }

    public es.rostan.hibernate.entidades.marca getMarca() {
        return marca;
    }

    public void setMarca(es.rostan.hibernate.entidades.marca marca) {
        this.marca = marca;
    }

    public es.rostan.hibernate.entidades.modelo getModelo() {
        return modelo;
    }

    public void setModelo(es.rostan.hibernate.entidades.modelo modelo) {
        this.modelo = modelo;
    }

    //  METODOS
    @Override
    public String toString() {
        return "dispositivo{" +
                "dspCodigo='" + dspCodigo + '\'' +
                ", dspDescripcion='" + dspDescripcion + '\'' +
                ", dspEstado='" + dspEstado + '\'' +
                '}';
    }

    public void addVotacion(usuario usr, app app, Integer usrDspAppValor){
        usrDspAppValoracion uv = new usrDspAppValoracion();
        uv.setUsr(usr);
        uv.setDsp(this);
        uv.setApp(app);
        uv.setUsrCodigo(usr.getUsrCodigo());
        uv.setDspCodigo(this.getDspCodigo());
        uv.setAppCodigo(app.getAppCodigo());

        usr.getUsrVotaciones().add(uv);
        this.getUsrVotaciones().add(uv);
        app.getUsrVotaciones().add(uv);
    }

//    Metodo para verificar alguna caracteristica.
    public String existeCrc(caracteristica crc){
        Set<caracteristica> crcsDisp = new HashSet<caracteristica>(this.crcs);
        String res = "False";

        for (caracteristica c : crcs){
            if(c.getCrcCodigo() == crc.getCrcCodigo()){
                res = "True";
                break;
            }
        }
        return res;
    }

    //    Metodo para verificar alguna aplicacion.
    public String existeApp(app app){
        Set<dispositivoApp> setDa = new HashSet<dispositivoApp>(this.apps);
        String res = "False";

        for (dispositivoApp da : setDa) {
            if (da.getApp().equals(app)) {
                res = "True";
                break;
            }
        }
        return res;
    }

    public Double calificacionApp(app app) {
        Double res = 0.0;
        for (dispositivoApp da :apps){
            if(app.getAppCodigo() == da.getAppCodigo()){
                res = da.getDspAppCalificacion();
            }
        }
        return res;
    }
}
