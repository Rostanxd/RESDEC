package es.rostan.hibernate.entidades;

import es.rostan.hibernate.entidades.caracteristica;
import es.rostan.hibernate.entidades.categoria;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-04-24T15:32:57")
@StaticMetamodel(subcategoria.class)
public class subcategoria_ { 

    public static volatile SingularAttribute<subcategoria, Long> subCodigo;
    public static volatile SingularAttribute<subcategoria, String> subDescripcion;
    public static volatile ListAttribute<subcategoria, caracteristica> lstCaracteristicas;
    public static volatile SingularAttribute<subcategoria, categoria> categoria;

}