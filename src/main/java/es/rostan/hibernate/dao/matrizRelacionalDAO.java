package es.rostan.hibernate.dao;

import es.rostan.hibernate.entidades.app;
import es.rostan.hibernate.entidades.dispositivo;
import es.rostan.hibernate.entidades.dispositivoApp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Rostan on 25/02/2017.
 */
public class matrizRelacionalDAO {
    private static EntityManagerFactory emf = new Persistence().createEntityManagerFactory("Persistencia");

    public List<dispositivo> searchDspConApp(app app){
        System.out.println("Matriz de Relación: Buscando relación de dispositivos con App: "+app.getAppDescripcion());
        List<dispositivo> lstDsp = new ArrayList<dispositivo>();
        lstDsp.clear();

        EntityManager em = emf.createEntityManager();
        Query qry = em.createQuery("SELECT DISTINCT d FROM dispositivoApp da " +
                "INNER JOIN dispositivo d " +
                "ON da.dspCodigo = d.dspCodigo " +
                "WHERE da.appCodigo = :appCodigo");
        qry.setParameter("appCodigo", app.getAppCodigo());
        lstDsp = qry.getResultList();
        return lstDsp;
    }

    public void calculoMatrizRelacional(app app){
        System.out.println("Matriz Relacional: elimina los registros actuales en la tabla de relación");
        deleteMatrizRelacional(app);

        System.out.println("Matriz Relacional: Insertando datos en base...");
        this.insertMatrizRelacional(app);
    }

    public void deleteMatrizRelacional(app app){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
//        Query qry = em.createQuery("DELETE FROM dispositivoApp da WHERE da.appCodigo = :a");
//        qry.setParameter("a", app.getAppCodigo());
        Query qry = em.createQuery("DELETE FROM dispositivoApp da");
        qry.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    public void insertMatrizRelacional(app app){
        System.out.println("Matriz Relacional: Calculando matriz relacional para la app: "+app.getAppDescripcion());

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

//        Query qry = em.createQuery("SELECT uv.dsp, " +
//                "uv.app, sum(uv.usrDspAppValor), " +
//                "Count(uv), " +
//                "CASE WHEN SUM(uv.usrDspAppValor) <> 0 THEN Sum(uv.usrDspAppValor)/count(uv) ELSE 0 END\n" +
//                "FROM usrDspAppValoracion uv\n" +
//                "WHERE uv.appCodigo = :a\n" +
//                "GROUP BY uv.dspCodigo, uv.appCodigo");
//        qry.setParameter("a", app.getAppCodigo());

        Query qry = em.createQuery("SELECT uv.dsp,\n" +
                "  uv.app,\n" +
                "  sum(uv.usrDspAppValor),\n" +
                "  Count(uv),\n" +
                "  CASE WHEN SUM(uv.usrDspAppValor) <> 0 THEN Sum(uv.usrDspAppValor)/count(uv) ELSE 0 END\n" +
                "FROM usrDspAppValoracion  as uv\n" +
                "  INNER JOIN usrDspAppValoracion as b\n" +
                "  ON uv.dspCodigo = b.dspCodigo\n" +
                "WHERE b.appCodigo = :a\n" +
                "GROUP BY uv.dspCodigo, uv.appCodigo");
        qry.setParameter("a", app.getAppCodigo());

        Iterator resultSet = qry.getResultList().iterator();
        while (resultSet.hasNext()){
            Object[] tuple = (Object[]) resultSet.next();
            dispositivoApp da = new dispositivoApp();
//            da.setApp(app);
//            da.setAppCodigo(app.getAppCodigo());
            da.setDsp((dispositivo) tuple[0]);
            da.setDspCodigo(((dispositivo) tuple[0]).getDspCodigo());
            da.setApp((app) tuple[1]);
            da.setAppCodigo(((app) tuple[1]).getAppCodigo());
            da.setDspAppCalificacion(((BigDecimal) tuple[4]).doubleValue());
            em.persist(da);
        }
        em.getTransaction().commit();
        em.close();
    }

}
