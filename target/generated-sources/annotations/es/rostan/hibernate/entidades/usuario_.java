package es.rostan.hibernate.entidades;

import es.rostan.hibernate.entidades.usrDspAppValoracion;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-02-17T12:08:28")
@StaticMetamodel(usuario.class)
public class usuario_ { 

    public static volatile SingularAttribute<usuario, Integer> usrEstudios;
    public static volatile SingularAttribute<usuario, Integer> usrOcupacion;
    public static volatile SetAttribute<usuario, usrDspAppValoracion> usrVotaciones;
    public static volatile SingularAttribute<usuario, Integer> usrAppProm;
    public static volatile SingularAttribute<usuario, Integer> usrFrcInternet;
    public static volatile SingularAttribute<usuario, Long> usrCodigo;
    public static volatile SingularAttribute<usuario, Integer> usrGenero;
    public static volatile SingularAttribute<usuario, Integer> usrAppInstall;
    public static volatile SingularAttribute<usuario, Integer> usrEdad;
    public static volatile SingularAttribute<usuario, Integer> usrIntereses;
    public static volatile SingularAttribute<usuario, Integer> usrNumApp;

}