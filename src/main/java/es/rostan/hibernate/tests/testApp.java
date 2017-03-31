package es.rostan.hibernate.tests;

import es.rostan.hibernate.entidades.app;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by HP on 19/09/2016.
 */
public class testApp {
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public  static void main(String[] args){

//        EntityManager man = emf.createEntityManager();
//        app a = new app(1, "FaceBook");
//        man.getTransaction().begin();
//        man.persist(a);
//        man.getTransaction().commit();
//        man.close();
//        imprimirTodo();

        estadoAppDesplegadas();

    }

    @SuppressWarnings("unchecked")
    public static void imprimirTodo(){
        EntityManager man = emf.createEntityManager();
        List<app> listApp = (List<app>) man.createQuery("FROM app").getResultList();
        System.out.println("En esta base de datos hay "+ listApp.size()+ " dispositivos.");
        for (app a : listApp){
            System.out.println(a.toString());
        }
        man.close();
    }

    public static void estadoAppDesplegadas(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query qry = em.createQuery("UPDATE app SET appEstado = 'D'");
        qry.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

}
