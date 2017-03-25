package es.rostan.hibernate.modelos;

import es.rostan.hibernate.entidades.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by HP on 03/12/2016.
 */
public class appModel {
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public static void main (String args[]){
        List<app> apps = getApps();

        for(app a : apps){
            System.out.println(a.getAppCodigo()+" "+a.getAppDescripcion());
        }
    }

    public static List<app> getApps(){
        EntityManager em = emf.createEntityManager();

        List<app> apps = (List<app>) em.createQuery("FROM app").getResultList();
        return apps;
    }
}
