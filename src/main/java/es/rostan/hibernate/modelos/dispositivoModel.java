package es.rostan.hibernate.modelos;

import es.rostan.hibernate.entidades.dispositivo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by HP on 03/12/2016.
 */
public class dispositivoModel {
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public static void main(String args[]){
        List<dispositivo> disps = getDispositivos();

        for (dispositivo d : disps){
            System.out.println(d.getDspCodigo()+" "+d.getDspDescripcion());
        }
    }

    public static List<dispositivo> getDispositivos(){
        EntityManager em = emf.createEntityManager();

        List<dispositivo> disps = (List<dispositivo>) em.createQuery("FROM dispositivo ").getResultList();

        return disps;
    }
}
