package es.rostan.hibernate.dao;

import es.rostan.hibernate.entidades.modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP on 26/03/2017.
 */
public class modeloDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public List<modelo> lstModelos(){
        List<modelo> lstModelos = new ArrayList<modelo>();
        EntityManager em = emf.createEntityManager();
        Query qry = em.createQuery("select m from modelo m ORDER BY m.mdlNombre");
        lstModelos = (List<modelo>) qry.getResultList();
        return lstModelos;
    }
}
