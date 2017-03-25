package es.rostan.hibernate.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Rostan on 14/09/2016.
 */

@Entity
@Table(name = "app")
public class app implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "appCodigo")
    private long appCodigo;

    @Column(name = "appDescripcion")
    private String appDescripcion;

//    ATT RELACIONES
    @OneToMany(mappedBy = "app")
    private Set<dispositivoApp> dsps = new HashSet<dispositivoApp>(0);

    @OneToMany(mappedBy = "app")
    private Set<usrDspAppValoracion> usrVotaciones = new HashSet<usrDspAppValoracion>(0);

    public void addDsp(dispositivo dsp, Double calificacion){
        dispositivoApp da = new dispositivoApp();
        da.setDsp(dsp);
        da.setApp(this);
        da.setDspCodigo(dsp.getDspCodigo());
        da.setAppCodigo(this.getAppCodigo());
        da.setDspAppCalificacion(calificacion);

        this.dsps.add(da);
        dsp.getApps().add(da);
    }

    public void addVotacion(usuario usr, dispositivo dsp, Integer usrDspAppValor){
        usrDspAppValoracion uv = new usrDspAppValoracion();
        uv.setUsr(usr);
        uv.setDsp(dsp);
        uv.setApp(this);
        uv.setUsrCodigo(usr.getUsrCodigo());
        uv.setDspCodigo(dsp.getDspCodigo());
        uv.setAppCodigo(this.getAppCodigo());

        usr.getUsrVotaciones().add(uv);
        dsp.getUsrVotaciones().add(uv);
        this.usrVotaciones.add(uv);
    }

    //  CONSTRUCTORES
    public app(){}  //  Constructor vacio para hbernate

    public app(long appCodigo, String appDescripcion) {
        this.appCodigo = appCodigo;
        this.appDescripcion = appDescripcion;
    }

    //  GETTER Y SETTERS
    public long getAppCodigo() {
        return appCodigo;
    }

    public void setAppCodigo(long appCodigo) {
        this.appCodigo = appCodigo;
    }

    public String getAppDescripcion() {
        return appDescripcion;
    }

    public void setAppDescripcion(String appDescripcion) {
        this.appDescripcion = appDescripcion;
    }

    public Set<dispositivoApp> getDsps() {
        return dsps;
    }

    public void setDsps(Set<dispositivoApp> dspApp) {
        this.dsps = dspApp;
    }

    public Set<usrDspAppValoracion> getUsrVotaciones() {
        return usrVotaciones;
    }

    public void setUsrVotaciones(Set<usrDspAppValoracion> usrVotaciones) {
        this.usrVotaciones = usrVotaciones;
    }

    //  METODOS
    @Override
    public String toString() {
        return "app{" +
                "appCodigo='" + appCodigo + '\'' +
                ", appDescripcion='" + appDescripcion + '\'' +
                '}';
    }
}
