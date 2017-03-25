package es.rostan.hibernate.dao;

import es.rostan.hibernate.entidades.app;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rostan on 04/12/2016.
 */
public class appDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public List<app> getLstApp(){
        List<app> lstApp = new ArrayList();

        EntityManager em = emf.createEntityManager();

        lstApp = (List<app>) em.createQuery("FROM app a", app.class).getResultList();

        return lstApp;
    }

    public app getApp(app inApp){
        app app;
        EntityManager em = emf.createEntityManager();
        Query qry = em.createQuery("FROM app a WHERE a.appCodigo = :appCodigo");
        qry.setParameter("appCodigo", inApp.getAppCodigo());
        app = (app)qry.getSingleResult();
        return app;
    }

    public void insertApp(app app) throws Exception{
        EntityManager man = emf.createEntityManager();
        try{
            man.getTransaction().begin();
            man.persist(app);
            man.getTransaction().commit();
        }catch(Exception e){
            man.getTransaction().rollback();
            throw e;
        }finally{
            man.close();
        }
    }

    public void updateApp(app app) throws Exception{
        EntityManager man = emf.createEntityManager();
        app appOld = new app();
        try{
            man.getTransaction().begin();
            appOld = man.find(app.class, app.getAppCodigo());
            appOld.setAppCodigo(app.getAppCodigo());
            appOld.setAppDescripcion(app.getAppDescripcion());
            man.getTransaction().commit();
        }catch(Exception e){
            man.getTransaction().rollback();
            throw e;
        }finally{
            man.close();
        }
    }

    public void deleteApp(app app) throws Exception{
        EntityManager man = emf.createEntityManager();
        try{
            man.getTransaction().begin();
            man.remove(app);
            man.getTransaction().commit();
        }catch(Exception e){
            man.getTransaction().rollback();
            throw e;
        }finally{
            man.close();
        }
    }
}
