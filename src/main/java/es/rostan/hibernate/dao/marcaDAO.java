package es.rostan.hibernate.dao;

import es.rostan.hibernate.entidades.marca;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP on 26/03/2017.
 */
public class marcaDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public List<marca> lstMarcas(){
        List<marca> lstMarcas = new ArrayList<marca>();
        EntityManager em = emf.createEntityManager();
        Query qry = em.createQuery("SELECT m FROM marca m ORDER BY m.mrcNombre");
        lstMarcas = (List<marca>) qry.getResultList();
        return lstMarcas;
    }
}
