package es.rostan.hibernate.modelos;

import es.rostan.hibernate.entidades.caracteristica;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by HP on 03/12/2016.
 */
public class caracteristicaModel {
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");;

    public static void main(String arg[]){
        List<caracteristica> crcs = getCaracteristicas();

        for(caracteristica c : crcs){
            System.out.println(c.getCrcCodigo()+" "+c.getCrcDescripcion());
        }
    }

    public static List<caracteristica> getCaracteristicas(){
        EntityManager em = emf.createEntityManager();

        List<caracteristica> crcs = (List<caracteristica>) em.createQuery("FROM caracteristica").getResultList();

        return crcs;
    }
}
