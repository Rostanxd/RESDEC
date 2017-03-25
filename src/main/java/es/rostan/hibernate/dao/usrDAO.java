package es.rostan.hibernate.dao;

import es.rostan.hibernate.entidades.usrDspAppValoracion;
import es.rostan.hibernate.entidades.usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rostan on 14/12/2016.
 */
public class usrDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public List<usuario> getLstUsr() {
        List<usuario> lstUsr = new ArrayList<usuario>();
        EntityManager em = emf.createEntityManager();
        lstUsr = (List<usuario>) em.createQuery("FROM usuario u", usuario.class).getResultList();
        em.close();
        return lstUsr;
    }

    public List<usrDspAppValoracion> getLstUsrValoracion(usuario usr){
        List<usrDspAppValoracion> lstUsrValoraciones = new ArrayList<usrDspAppValoracion>();
        EntityManager em = emf.createEntityManager();
        Query qry = em.createQuery("FROM usrDspAppValoracion uv " +
                "WHERE uv.usrCodigo = :usrCodigo");
        qry.setParameter("usrCodigo", usr.getUsrCodigo());

        lstUsrValoraciones = (List<usrDspAppValoracion>) qry.getResultList();

        return lstUsrValoraciones;
    }
}
