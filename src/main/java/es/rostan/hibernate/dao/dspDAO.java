package es.rostan.hibernate.dao;

import es.rostan.hibernate.entidades.app;
import es.rostan.hibernate.entidades.caracteristica;
import es.rostan.hibernate.entidades.dispositivo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Rostan on 04/12/2016.
 */
public class dspDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public List<dispositivo> getLstDsp(){
        List<dispositivo> lstDsp = new ArrayList();

        EntityManager em = emf.createEntityManager();

        lstDsp = (List<dispositivo>) em.createQuery("FROM dispositivo d", dispositivo.class).getResultList();

        return lstDsp;
    }

    public dispositivo getDsp(dispositivo inDsp){
        dispositivo dsp;

        EntityManager em = emf.createEntityManager();

        Query qry = em.createQuery("FROM dispositivo d " +
                "WHERE d.dspCodigo = :dspCodigo");
        qry.setParameter("dspCodigo", inDsp.getDspCodigo());

        dsp = (dispositivo)qry.getSingleResult();

        return dsp;
    }

    public void insertDsp(dispositivo dsp) throws Exception{
        EntityManager man = emf.createEntityManager();
        try{
            man.getTransaction().begin();
            man.persist(dsp);
            man.getTransaction().commit();
        }catch(Exception e){
            man.getTransaction().rollback();
            throw e;
        }finally{
            man.close();
        }

    }

    public void updateDsp(dispositivo dsp) throws Exception{
        EntityManager man = emf.createEntityManager();
        dispositivo dspOld = new dispositivo();
        try{
            man.getTransaction().begin();

            dspOld = man.find(dispositivo.class, dsp.getDspCodigo());

            dspOld.setDspEstado(dsp.getDspEstado());
            dspOld.setDspDescripcion(dsp.getDspDescripcion());

            man.getTransaction().commit();
        }catch(Exception e){
            man.getTransaction().rollback();
            throw e;
        }finally{
            man.close();
        }
    }

    public void deleteDsp(dispositivo dsp) throws Exception{
        EntityManager man = emf.createEntityManager();
        dispositivo dspOld = man.find(dispositivo.class, dsp.getDspCodigo());
        try {
            man.getTransaction().begin();
            man.remove(dspOld);
            man.getTransaction().commit();
        }catch(Exception e){
            man.getTransaction().rollback();
            throw e;
        }finally {
            man.close();
        }
    }

    public String existCrc(dispositivo dsp, caracteristica crc) throws Exception{
        EntityManager man = emf.createEntityManager();
        String res = "0";
        try {
            man.getTransaction().begin();
            dsp = man.find(dispositivo.class, dsp.getDspCodigo());
            Set<caracteristica> crcrs = dsp.getCrcs();
            for(caracteristica c: crcrs){
                if(crc == c){
                    res = "1";
                    break;
                }
            }
        }catch(Exception e){
            throw e;
        }finally{
            man.close();
        }
        return res;

    }

}
