package es.rostan.hibernate.entidades;

import es.rostan.hibernate.entidades.dispositivo;
import es.rostan.hibernate.entidades.subcategoria;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-02-17T17:51:08")
@StaticMetamodel(caracteristica.class)
public class caracteristica_ { 

    public static volatile SingularAttribute<caracteristica, String> crcDescripcion;
    public static volatile SetAttribute<caracteristica, dispositivo> disps;
    public static volatile SingularAttribute<caracteristica, subcategoria> subcategoria;
    public static volatile SingularAttribute<caracteristica, Long> crcCodigo;

}