package es.rostan.hibernate.tests;

import es.rostan.hibernate.entidades.modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP on 23/12/2016.
 */
public class testModelo {
    public static EntityManagerFactory emf = new Persistence().createEntityManagerFactory("Persistencia");

    public static void main(String[] args){
        ingresarModelo();
        listarModelos();
    }

    public static void ingresarModelo(){
        EntityManager em = emf.createEntityManager();
        modelo modelo = new modelo();
        modelo.setMdlNombre("Galaxy S1");
        modelo.setMdlEstado("A");

        em.getTransaction().begin();
        em.persist(modelo);
        em.getTransaction().commit();
        em.close();
    }

    public static void listarModelos(){
        EntityManager em = emf.createEntityManager();
        List<modelo> lstModelo = new ArrayList<modelo>();
        lstModelo = em.createQuery("FROM modelo m").getResultList();
        em.close();
        System.out.println("Los modelos en la base de datos son los siguientes...");
        for (modelo m : lstModelo){
            System.out.println("- "+m.toString());
        }
    }
}
