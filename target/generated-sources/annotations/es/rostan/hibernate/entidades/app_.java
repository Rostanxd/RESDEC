package es.rostan.hibernate.entidades;

import es.rostan.hibernate.entidades.dispositivoApp;
import es.rostan.hibernate.entidades.usrDspAppValoracion;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-04-24T15:32:57")
@StaticMetamodel(app.class)
public class app_ { 

    public static volatile SingularAttribute<app, String> appDescripcion;
    public static volatile SingularAttribute<app, Long> appCodigo;
    public static volatile SetAttribute<app, usrDspAppValoracion> usrVotaciones;
    public static volatile SingularAttribute<app, String> appEstado;
    public static volatile SetAttribute<app, dispositivoApp> dsps;

}