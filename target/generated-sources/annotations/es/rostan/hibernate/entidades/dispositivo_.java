package es.rostan.hibernate.entidades;

import es.rostan.hibernate.entidades.caracteristica;
import es.rostan.hibernate.entidades.dispositivoApp;
import es.rostan.hibernate.entidades.marca;
import es.rostan.hibernate.entidades.modelo;
import es.rostan.hibernate.entidades.usrDspAppValoracion;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-03-29T17:42:52")
@StaticMetamodel(dispositivo.class)
public class dispositivo_ { 

    public static volatile SetAttribute<dispositivo, caracteristica> crcs;
    public static volatile SingularAttribute<dispositivo, marca> marca;
    public static volatile SingularAttribute<dispositivo, String> dspDescripcion;
    public static volatile SingularAttribute<dispositivo, String> dspEstado;
    public static volatile SetAttribute<dispositivo, usrDspAppValoracion> usrVotaciones;
    public static volatile SingularAttribute<dispositivo, Long> dspCodigo;
    public static volatile SingularAttribute<dispositivo, modelo> modelo;
    public static volatile SetAttribute<dispositivo, dispositivoApp> apps;

}