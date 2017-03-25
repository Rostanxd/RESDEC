package es.rostan.hibernate.dao;

import es.rostan.hibernate.entidades.categoria;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rostan on 16/02/2017.
 */
public class categoriaDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public List<categoria> getLstCategoria(){
        List<categoria> lstCtg = new ArrayList<categoria>();
        EntityManager em = emf.createEntityManager();
        lstCtg = em.createQuery("SELECT c FROM categoria c", categoria.class).getResultList();
        return lstCtg;
    }
}
