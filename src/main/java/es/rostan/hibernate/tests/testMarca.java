package es.rostan.hibernate.tests;

import es.rostan.hibernate.entidades.marca;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP on 23/12/2016.
 */
public class testMarca {

    public static EntityManagerFactory emf = new Persistence().createEntityManagerFactory("Persistencia");

    public static void main(String[] args){
//        ingresarMarca();
        leerMarcas();
    }

    public static void ingresarMarca(){
        EntityManager em = emf.createEntityManager();
        marca mrc = new marca();
        mrc.setMrcNombre("Huawei");
        mrc.setMrcEstado("A");

        em.getTransaction().begin();
        em.persist(mrc);
        em.getTransaction().commit();
        em.close();
    }

    public static void leerMarcas(){
        List<marca> lstMarca = new ArrayList<marca>();
        EntityManager em = emf.createEntityManager();
        lstMarca = em.createQuery("FROM marca m ").getResultList();
        em.close();

        System.out.println("El listado de marcas es el siguiente...");
        for(marca m : lstMarca){
            System.out.println("- "+m.toString());
        }
    }
}
