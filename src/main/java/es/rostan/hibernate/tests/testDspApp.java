package es.rostan.hibernate.tests;

import es.rostan.hibernate.dao.dspAppDAO;
import es.rostan.hibernate.entidades.app;
import es.rostan.hibernate.entidades.dispositivo;
import es.rostan.hibernate.entidades.dispositivoApp;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Rostan on 20/09/2016.
 */
public class testDspApp {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public static void main(String[] args) {
        dspAppDAO dd = new dspAppDAO();

        // Creacion de la matriz con los valores promedios por app en dsp
//        dd.matrizDspApp();

        EntityManager em = emf.createEntityManager();

        dispositivo dsp = new dispositivo();
        List<dispositivoApp> dspApps = new ArrayList<dispositivoApp>();
        dsp = (dispositivo) em.createQuery("FROM dispositivo d WHERE d.dspCodigo = 1").getSingleResult();

//        dd.appsDspBase(dsp);
        dd.coeffPearson(dsp);
        em.close();

//        ingresarDspApp();
//        imprimirTodo();
    }

    public static void ingresarDspApp() {
        EntityManager em = emf.createEntityManager();
        dispositivo dsp = new dispositivo();
        app app = new app();
        dispositivoApp dspApp = new dispositivoApp();
        em.getTransaction().begin();

        dsp = (dispositivo) em.createQuery("FROM dispositivo d WHERE d.dspCodigo = '001'").getSingleResult();
        app = (app) em.createQuery("FROM app a WHERE a.appCodigo = '006'").getSingleResult();
        dspApp.setDspCodigo(dsp.getDspCodigo());
        dspApp.setAppCodigo(app.getAppCodigo());
        dspApp.setDspAppCalificacion(4.0);
        dspApp.setDsp(dsp);
        dspApp.setApp(app);
        em.persist(dspApp);
        em.getTransaction().commit();

        System.out.println("Relacion ingresada.");
    }

    public static void imprimirTodo() {
        EntityManager em = emf.createEntityManager();
        List<dispositivoApp> dspAppList = (List<dispositivoApp>) em.createQuery("FROM dispositivoApp da").getResultList();

        for (dispositivoApp da : dspAppList) {
            System.out.println("Las relaciones de Dispositivo - Aplicacion son: " + da.toString());
        }
        em.close();
    }

    public static EntityManagerFactory getEmf() {
        return emf;
    }

    public static void setEmf(EntityManagerFactory emf) {
        testDspApp.emf = emf;
    }
}
