package es.rostan.hibernate.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Rostan on 13/12/2016.
 */
@Entity
@Table(name = "usuario")
public class usuario implements Serializable{
    @Id
    @GeneratedValue
    @Column(name = "usrCodigo")
    private long usrCodigo;

    @Column(name = "usrEdad")
    private Integer usrEdad;

    @Column(name = "usrGenero")
    private Integer usrGenero;

    @Column(name = "usrOcupacion")
    private Integer usrOcupacion;

    @Column(name = "usrEstudios")
    private Integer usrEstudios;

    @Column(name = "usrIntereses")
    private Integer usrIntereses;

    @Column(name = "usrFrcInternet")
    private Integer usrFrcInternet;

    @Column(name = "usrNumApp")
    private Integer usrNumApp;

    @Column(name = "usrAppInstall")
    private Integer usrAppInstall;

    @Column(name = "usrAppProm")
    private Integer usrAppProm;

//    ATT RELACIONADOS
    @OneToMany(mappedBy = "usr")
    private Set<usrDspAppValoracion> usrVotaciones = new HashSet<usrDspAppValoracion>();

    public void addVotacion(dispositivo dsp, app app, Integer usrDspAppValor){
        usrDspAppValoracion uv = new usrDspAppValoracion();
        uv.setUsr(this);
        uv.setDsp(dsp);
        uv.setApp(app);
        uv.setUsrCodigo(this.getUsrCodigo());
        uv.setDspCodigo(dsp.getDspCodigo());
        uv.setAppCodigo(app.getAppCodigo());

        this.getUsrVotaciones().add(uv);
        dsp.getUsrVotaciones().add(uv);
        app.getUsrVotaciones().add(uv);
    }

//    CONSTRUCTORES

    public usuario(){}

    public usuario(Integer usrCodigo, Integer usrEdad, Integer usrGenero, Integer usrOcupacion, Integer usrEstudios, Integer usrIntereses, Integer usrFrcInternet, Integer usrNumApp, Integer usrAppInstall, Integer usrAppProm) {
        this.usrCodigo = usrCodigo;
        this.usrEdad = usrEdad;
        this.usrGenero = usrGenero;
        this.usrOcupacion = usrOcupacion;
        this.usrEstudios = usrEstudios;
        this.usrIntereses = usrIntereses;
        this.usrFrcInternet = usrFrcInternet;
        this.usrNumApp = usrNumApp;
        this.usrAppInstall = usrAppInstall;
        this.usrAppProm = usrAppProm;
    }

    //    GETTER Y SETTERS

    public long getUsrCodigo() {
        return usrCodigo;
    }

    public void setUsrCodigo(long usrCodigo) {
        this.usrCodigo = usrCodigo;
    }

    public Integer getUsrEdad() {
        return usrEdad;
    }

    public void setUsrEdad(Integer usrEdad) {
        this.usrEdad = usrEdad;
    }

    public Integer getUsrGenero() {
        return usrGenero;
    }

    public void setUsrGenero(Integer usrGenero) {
        this.usrGenero = usrGenero;
    }

    public Integer getUsrOcupacion() {
        return usrOcupacion;
    }

    public void setUsrOcupacion(Integer usrOcupacion) {
        this.usrOcupacion = usrOcupacion;
    }

    public Integer getUsrEstudios() {
        return usrEstudios;
    }

    public void setUsrEstudios(Integer usrEstudios) {
        this.usrEstudios = usrEstudios;
    }

    public Integer getUsrIntereses() {
        return usrIntereses;
    }

    public void setUsrIntereses(Integer usrIntereses) {
        this.usrIntereses = usrIntereses;
    }

    public Integer getUsrFrcInternet() {
        return usrFrcInternet;
    }

    public void setUsrFrcInternet(Integer usrFrcInternet) {
        this.usrFrcInternet = usrFrcInternet;
    }

    public Integer getUsrNumApp() {
        return usrNumApp;
    }

    public void setUsrNumApp(Integer usrNumApp) {
        this.usrNumApp = usrNumApp;
    }

    public Integer getUsrAppInstall() {
        return usrAppInstall;
    }

    public void setUsrAppInstall(Integer usrAppInstall) {
        this.usrAppInstall = usrAppInstall;
    }

    public Integer getUsrAppProm() {
        return usrAppProm;
    }

    public void setUsrAppProm(Integer usrAppProm) {
        this.usrAppProm = usrAppProm;
    }

    public Set<usrDspAppValoracion> getUsrVotaciones() {
        return usrVotaciones;
    }

    public void setUsrVotaciones(Set<usrDspAppValoracion> usrVotaciones) {
        this.usrVotaciones = usrVotaciones;
    }

    //    METHODS

    @Override
    public String toString() {
        return "usuario{" +
                "usrCodigo=" + usrCodigo +
                ", usrEdad=" + usrEdad +
                ", usrGenero=" + usrGenero +
                ", usrOcupacion=" + usrOcupacion +
                ", usrEstudios=" + usrEstudios +
                ", usrIntereses=" + usrIntereses +
                ", usrFrcInternet=" + usrFrcInternet +
                ", usrNumApp=" + usrNumApp +
                ", usrAppInstall=" + usrAppInstall +
                ", usrAppProm=" + usrAppProm +
                '}';
    }
}
