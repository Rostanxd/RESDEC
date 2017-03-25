package es.rostan.hibernate.dao;

import es.rostan.hibernate.entidades.categoria;
import es.rostan.hibernate.entidades.subcategoria;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rostan on 16/02/2017.
 */
public class subcategoriaDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public List<subcategoria> getLstSubCtg(){
        List<subcategoria> lstSubCtg = new ArrayList<subcategoria>();
        EntityManager em = emf.createEntityManager();
        lstSubCtg = em.createQuery("SELECT s FROM subcategoria s", subcategoria.class).getResultList();
        em.close();
        return lstSubCtg;
    }

    public List<subcategoria> searchLstSubxCt(categoria ctg){
        List<subcategoria> lstSubCtg = new ArrayList<subcategoria>();
        EntityManager em = emf.createEntityManager();
        Query qry = em.createQuery("SELECT s FROM subcategoria s WHERE s.categoria = :categoria", subcategoria.class);
        qry.setParameter("categoria", ctg);
        lstSubCtg = qry.getResultList();
        em.close();
        return lstSubCtg;
    }
}
