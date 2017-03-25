package es.rostan.hibernate.tests;

import es.rostan.hibernate.entidades.matrizReferencial;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by HP on 19/02/2017.
 */
public class testMatrizReferencial {
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public static void main(String[] args){
        leerTodo();
    }

    public static void leerTodo(){
        EntityManager em = emf.createEntityManager();
        Query qry = em.createQuery("FROM matrizReferencial mr");
        List<matrizReferencial> lstMatrizReferencial = qry.getResultList();

        for(matrizReferencial mr : lstMatrizReferencial){
            mr.toString();
        }
    }
}
