package es.rostan.hibernate.tests;


import es.rostan.hibernate.entidades.dispositivo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by Rostan on 19/09/2016.
 */
public class testDispositivo {
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public static void main(String[] args){

        EntityManager man = emf.createEntityManager();
        dispositivo d = new dispositivo(1,"Samsung S3","A");
        man.getTransaction().begin();
        man.persist(d);
        man.getTransaction().commit();
        man.close();

        imprimirTodo();

    }

//    @SuppressWarnings("unchecked")
    public static void imprimirTodo(){
        EntityManager man = emf.createEntityManager();
        List<dispositivo> dsp = (List<dispositivo>) man.createQuery("FROM dispositivo").getResultList();
        System.out.println("En esta base de datos hay "+ dsp.size()+ " dispositivos.");
        for (dispositivo d : dsp){
            System.out.println(d.toString());
        }
        man.close();
    }

}
