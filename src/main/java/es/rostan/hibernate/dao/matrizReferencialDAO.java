package es.rostan.hibernate.dao;

import es.rostan.hibernate.entidades.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rostan on 19/02/2017.
 */
public class matrizReferencialDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public void cargaMatrizReferencial(app a, List<caracteristica> lstCrc){
        System.out.println("Matriz Referencial: Actualizando datos...");

        EntityManager em = emf.createEntityManager();

//        Obtengo todas las valoraciones con esa app base
        List<usrDspAppValoracion> lstUsrVal = new ArrayList<usrDspAppValoracion>();
        Query qry = em.createQuery("FROM usrDspAppValoracion uv " +
                "WHERE uv.app = :a");
        qry.setParameter("a", a);
        lstUsrVal = qry.getResultList();

        for(usrDspAppValoracion uv : lstUsrVal){
            for(caracteristica c : uv.getDsp().getCrcs()){
                for(caracteristica cl : lstCrc){
                    if (c.getCrcCodigo() == cl.getCrcCodigo()){

                        qry = em.createQuery("FROM matrizReferencial m WHERE m.appCodigo = :appCodigo and m.crcCodigo = :crcCodigo", matrizReferencial.class);
                        qry.setParameter("appCodigo", uv.getAppCodigo());
                        qry.setParameter("crcCodigo", c.getCrcCodigo());
                        matrizReferencial mr = (matrizReferencial) qry.getSingleResult();

                        em.getTransaction().begin();
                        mr.setMtrRefSumatoria(mr.getMtrRefSumatoria() + uv.getUsrDspAppValor());
                        mr.setMtrRefContador(mr.getMtrRefContador() + 1);
                        em.getTransaction().commit();
                        break;
                    }
                }
            }
        }
        em.close();
        System.out.println("Matriz Referencial: Datos actualizados...");
    }

//    Caracteristicas por app y subcategoria
    public List<caracteristica> searchCrcXSubApp(Long sb, app a){
        List<caracteristica> lstCrc = new ArrayList<caracteristica>();
        EntityManager em = emf.createEntityManager();
        Query qry = em.createQuery("SELECT DISTINCT dc.crc FROM dispositivoCrc dc " +
                "INNER JOIN caracteristica c on (c.crcCodigo = dc.crcCodigo) \n" +
                "WHERE dc.dspCodigo in (SELECT DISTINCT da.dspCodigo \n" +
                "  FROM usrDspAppValoracion da\n" +
                "  WHERE da.appCodigo = :a and c.subcategoria.subCodigo = :sb)", caracteristica.class);
        qry.setParameter("a", a.getAppCodigo());
        qry.setParameter("sb", sb);
        lstCrc = qry.getResultList();
        em.close();

        return lstCrc;
    }

//    Se eliminan los registros anteriores en la Matriz con relacion a la app.
    public void deleteMatrizReferencial(app a){
        System.out.println("Matriz Referencial: Eliminando datos de la Matriz Referencial para la app "+a.getAppDescripcion()+"...");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query qry = em.createQuery("DELETE FROM matrizReferencial a WHERE a.app = :a");
        qry.setParameter("a", a);
        qry.executeUpdate();
        em.getTransaction().commit();
        em.close();
        System.out.println("Matriz Referencial: Datos eliminados...");
    }

//    Caracteristicas por app seleccionada
    public List<caracteristica> buscaCaracteristicasXApp(app a){
        List<caracteristica> lstCrc = new ArrayList<caracteristica>();

        EntityManager em = emf.createEntityManager();
        Query qry = em.createQuery("SELECT DISTINCT dc.crc FROM dispositivoCrc as dc\n" +
                "WHERE dc.dspCodigo in (SELECT DISTINCT da.dspCodigo\n" +
                "  FROM usrDspAppValoracion as da\n" +
                "  WHERE da.app = :a)", caracteristica.class);
        qry.setParameter("a", a);

        lstCrc = qry.getResultList();
        return lstCrc;
    }

//    Inserta los datos iniciales para la matriz referencial como la aplicacion y las caracteriticas bases.
    public void insertaMatrizReferencial(app a, List<caracteristica> lstCrc){
        this.deleteMatrizReferencial(a);

        System.out.println("Matriz Referencial: Insertando datos...");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            for (caracteristica c : lstCrc) {
                matrizReferencial mr = new matrizReferencial();
                mr.setAppCodigo(a.getAppCodigo());
                mr.setCrcCodigo(c.getCrcCodigo());
                mr.setApp(a);
                mr.setCaracteristica(c);
                mr.setMtrRefSumatoria(0);
                mr.setMtrRefContador(0);

                em.persist(mr);
            }
            em.getTransaction().commit();
            em.close();
        }catch(Exception e){
            e.toString();
        }

        System.out.println("Matriz Referencial: Datos insertados...");
    }

    public List<matrizReferencial> listaMatrizReferencialxApp(app app){
        List<matrizReferencial> lstMr = new ArrayList<matrizReferencial>();

        EntityManager em = emf.createEntityManager();
        Query qry = em.createQuery("FROM matrizReferencial mr WHERE mr.appCodigo = :a", matrizReferencial.class);
        qry.setParameter("a", app.getAppCodigo());
        lstMr = qry.getResultList();

        return lstMr;
    }
}
