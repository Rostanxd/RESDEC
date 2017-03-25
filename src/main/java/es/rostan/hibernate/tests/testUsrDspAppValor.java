package es.rostan.hibernate.tests;

import es.rostan.hibernate.entidades.app;
import es.rostan.hibernate.entidades.dispositivo;
import es.rostan.hibernate.entidades.usrDspAppValoracion;
import es.rostan.hibernate.entidades.usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by HP on 13/12/2016.
 */
public class testUsrDspAppValor {
    private static EntityManagerFactory emf = new Persistence().createEntityManagerFactory("Persistencia");

    public static void main(String[] args){
        ingresarValoracion();
        listarValoraciones();
    }

    public static void ingresarValoracion(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        usuario usr = new usuario();
        dispositivo dsp = new dispositivo();
        app app = new app();
        usrDspAppValoracion uv = new usrDspAppValoracion();

        usr = (usuario) em.createQuery("FROM usuario u WHERE u.usrCodigo = 1").getSingleResult();
        dsp = (dispositivo) em.createQuery("FROM dispositivo d WHERE d.dspCodigo = 1").getSingleResult();
        app = (app) em.createQuery("FROM app a WHERE a.appCodigo = 1").getSingleResult();

        uv.setUsrCodigo(usr.getUsrCodigo());
        uv.setDspCodigo(dsp.getDspCodigo());
        uv.setAppCodigo(app.getAppCodigo());
        uv.setUsrDspAppValor(4);

        em.persist(uv);

        em.getTransaction().commit();
        em.close();
    }

    public static void listarValoraciones(){
        EntityManager em = emf.createEntityManager();
        List<usrDspAppValoracion> lstUv = (List<usrDspAppValoracion>) em.createQuery("FROM usrDspAppValoracion uv").getResultList();
        System.out.println("Las valoraciones dadas por usuarios fueron de: ");
        for(usrDspAppValoracion uv : lstUv){
            System.out.println(uv.toString());
        }
        em.close();
    }
}
