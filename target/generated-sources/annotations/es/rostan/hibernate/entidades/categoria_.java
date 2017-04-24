package es.rostan.hibernate.entidades;

import es.rostan.hibernate.entidades.subcategoria;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-04-24T15:32:57")
@StaticMetamodel(categoria.class)
public class categoria_ { 

    public static volatile ListAttribute<categoria, subcategoria> lstSubcategoria;
    public static volatile SingularAttribute<categoria, String> ctgDescripcion;
    public static volatile SingularAttribute<categoria, Long> ctgCodigo;

}