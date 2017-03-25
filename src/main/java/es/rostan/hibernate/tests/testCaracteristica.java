package es.rostan.hibernate.tests;

import es.rostan.hibernate.entidades.caracteristica;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rostan on 19/09/2016.
 */
public class testCaracteristica {

    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public static void main(String[] args){

//        EntityManager man = emf.createEntityManager();
//        caracteristica c = new caracteristica(1,"Wi-Fi");
//        man.getTransaction().begin();
//        man.persist(c);
//        man.getTransaction().commit();
//        man.close();

        imprimirTodo();

    }

    public static void imprimirTodo(){
        EntityManager man = emf.createEntityManager();
        List<caracteristica> listCrc = (List<caracteristica>) man.createQuery("FROM caracteristica").getResultList();
        System.out.println("En esta base de datos hay "+ listCrc.size()+ " dispositivos.");
        for (caracteristica c : listCrc){
            System.out.println(c.toString());
        }
        man.close();
    }
}
