package es.rostan.hibernate.dao;

import es.rostan.hibernate.entidades.app;
import es.rostan.hibernate.entidades.dispositivo;
import es.rostan.hibernate.entidades.matrizContenidoResultado;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Rostan on 23/02/2017.
 */
public class matrizContenidoResultadoDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public List<matrizContenidoResultado> listaContenidoResultado(app app){
        List<matrizContenidoResultado> lstMcr = new ArrayList<matrizContenidoResultado>();

        EntityManager em = emf.createEntityManager();
        Query qry = em.createQuery("SELECT b.dispositivo, sum(r.mtrRefSumatoria)\n" +
                "FROM matrizBooleana AS b\n" +
                "  INNER JOIN matrizReferencial as r ON (b.appCodigo = r.appCodigo and b.crcCodigo = r.crcCodigo)\n" +
                "WHERE b.mtrBolExiste = TRUE and r.appCodigo = :a\n" +
                "GROUP BY b.dspCodigo");
        qry.setParameter("a", app.getAppCodigo());

        Iterator resultado = qry.getResultList().iterator();
        while(resultado.hasNext()){
            Object[] tuple = (Object[]) resultado.next();
            matrizContenidoResultado mcr = new matrizContenidoResultado();
            mcr.setApp(app);
            mcr.setDispositivo((dispositivo) tuple[0]);

//            Casteo para Long a Double
            Long l = new Long((Long) tuple[1]);
            Object o = l;
            mcr.setValor((double) l);

            lstMcr.add(mcr);
        }

        return lstMcr;
    }
}
