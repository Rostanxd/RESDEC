package es.rostan.hibernate.dao;

import es.rostan.hibernate.entidades.caracteristica;
import es.rostan.hibernate.entidades.categoria;
import es.rostan.hibernate.entidades.subcategoria;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rostan on 04/12/2016.
 */
public class caracteristicaDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public List<caracteristica> getLstCrc(){
        List<caracteristica> lstCrc = new ArrayList();

        EntityManager em = emf.createEntityManager();

        lstCrc = (List<caracteristica>) em.createQuery("FROM caracteristica c", caracteristica.class).getResultList();

        return lstCrc;
    }

    public caracteristica getCrc(caracteristica inCrc){
        caracteristica crc;
        EntityManager em = emf.createEntityManager();
        Query qry = em.createQuery("FROM caracteristica as c " +
                "WHERE c.crcCodigo = :crcCodigo");
        qry.setParameter("crcCodigo", inCrc.getCrcCodigo());
        crc = (caracteristica)qry.getSingleResult();

        return crc;
    }

    public void insertCrc(caracteristica crc) throws Exception{
        EntityManager man = emf.createEntityManager();
        try{
            man.getTransaction().begin();
            man.persist(crc);
            man.getTransaction().commit();
        }catch(Exception e){
            man.getTransaction().rollback();
            throw e;
        }finally{
            man.close();
        }
    }

    public void updateCrc(caracteristica crc) throws Exception{
        EntityManager man = emf.createEntityManager();
        caracteristica crcOld = new caracteristica();
        try{
            man.getTransaction().begin();
            crcOld = man.find(caracteristica.class,crc.getCrcCodigo());
            crcOld.setCrcDescripcion(crc.getCrcDescripcion());
            man.getTransaction().commit();
        }catch(Exception e){
            man.getTransaction().rollback();
            throw e;
        }finally{
            man.close();
        }
    }

    public void deleteCrc(caracteristica crc) throws Exception{
        EntityManager man = emf.createEntityManager();
        caracteristica crcOld = man.find(caracteristica.class, crc.getCrcCodigo());
        try{
            man.getTransaction().begin();
            man.remove(crcOld);
            man.getTransaction().commit();
        }catch(Exception e){
            man.getTransaction().rollback();
            throw e;
        }finally{
            man.close();
        }
    }

    public List<caracteristica> searchLstCrcXSubctg(Long subCodigo){
        List<caracteristica> lstCrc = new ArrayList<caracteristica>();

        EntityManager em = emf.createEntityManager();
        Query qry = em.createQuery("SELECT c FROM caracteristica c " +
                "WHERE c.subcategoria.subCodigo = :subCodigo", caracteristica.class);
        qry.setParameter("subCodigo", subCodigo);
        lstCrc = qry.getResultList();

        return lstCrc;
    }
}
