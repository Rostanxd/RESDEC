package es.rostan.hibernate.tests;

import es.rostan.hibernate.entidades.caracteristica;
import es.rostan.hibernate.entidades.dispositivo;
import es.rostan.hibernate.entidades.dispositivoCrc;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static es.rostan.hibernate.entidades.dispositivo_.crcs;

/**
 * Created by Rostan on 20/09/2016.
 */
public class testDspCrc {
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public static void main(String[] args){
//        EntityManager em = emf.createEntityManager();
//
//        em.getTransaction().begin();
//
//        dispositivoCrc dspCrc = new dispositivoCrc();
//
//        dspCrc.setDspCodigo(1);
//        dspCrc.setCrcCodigo(1);
//
//        em.persist(dspCrc);
//
//        em.getTransaction().commit();
//        em.close();

        imprimirTodo();

    }

    public static void imprimirTodo(){
        EntityManager em = emf.createEntityManager();
        List<dispositivoCrc> lstDc = new ArrayList<dispositivoCrc>();

        Query qry = em.createQuery("FROM dispositivoCrc dc ");
        lstDc = (List<dispositivoCrc>) qry.getResultList();

        em.close();

        for(dispositivoCrc dc: lstDc){
            System.out.println("Resultados: "+dc.getDsp().getDspDescripcion()+' '+dc.getCrc().getCrcDescripcion());
        }
    }
}
