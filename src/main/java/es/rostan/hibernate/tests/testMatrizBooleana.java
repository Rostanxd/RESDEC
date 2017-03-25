package es.rostan.hibernate.tests;

import es.rostan.hibernate.entidades.matrizBooleana;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;

/**
 * Created by Rostan on 23/02/2017.
 */
public class testMatrizBooleana {
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public static void main(String[] args){
        leerTodo();
        exit(0);
    }

    public static void leerTodo(){
        List<matrizBooleana> lstMtrBoo = new ArrayList<matrizBooleana>();
        EntityManager em = emf.createEntityManager();
        Query qry = em.createQuery("FROM matrizBooleana ");
        lstMtrBoo = qry.getResultList();
        System.out.println("Leyendo la Matriz Booleana...");
        for(matrizBooleana mb : lstMtrBoo){
            System.out.println(mb.toString());
        }
        System.out.println("Lectura terminada.");
        em.close();
    }
}
