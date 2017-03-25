package es.rostan.hibernate.dao;

import es.rostan.hibernate.entidades.dispositivo;
import es.rostan.hibernate.entidades.topPopularity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Rostan on 20/03/2017.
 */
public class topPopularityDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public List<topPopularity> cargaTopPopularity(String order){
        System.out.println("Top Popularity: Cargando...");

        List<topPopularity> lstTopPopularity = new ArrayList<topPopularity>();
        EntityManager em = emf.createEntityManager();

        Query qry;

        if (order.equals("dsc")) {
            qry = em.createQuery("SELECT a.dsp, sum(a.usrDspAppValor)/Count(a) as promedio " +
                    "FROM usrDspAppValoracion as a " +
                    "GROUP BY a.dspCodigo " +
                    "ORDER BY promedio DESC ");
        }else{
            qry = em.createQuery("SELECT a.dsp, sum(a.usrDspAppValor)/Count(a) as promedio " +
                    "FROM usrDspAppValoracion as a " +
                    "GROUP BY a.dspCodigo " +
                    "ORDER BY promedio ASC ");
        }

        Iterator resultado = qry.getResultList().iterator();
        while(resultado.hasNext()){
            Object[] tuple = (Object[]) resultado.next();
            topPopularity tp = new topPopularity();
            tp.setDispositivo((dispositivo) tuple[0]);

//          Casteo para Long a Double
            Long l = new Long((Long) tuple[1]);
            Object o = l;
            tp.setValor((double) l);

            lstTopPopularity.add(tp);
        }

        return lstTopPopularity;
    }
}
