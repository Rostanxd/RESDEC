package es.rostan.hibernate.dao;

import es.rostan.hibernate.entidades.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rostan on 23/02/2017.
 */
public class matrizBooleanaDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public void insertarMatrizBooleana(app a){
        this.deleteMatrizBooleanaXApp(a);

        List<matrizReferencial> lstMr = new ArrayList<matrizReferencial>();
        matrizReferencialDAO md = new matrizReferencialDAO();
        lstMr = md.listaMatrizReferencialxApp(a);

        dspDAO da = new dspDAO();
        List<dispositivo> lstDsp = new ArrayList<dispositivo>();
        lstDsp = da.getLstDsp();

        System.out.println("Matriz Booleana: Insertando datos...");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try{
            for(dispositivo d : lstDsp){

                for(matrizReferencial mr : lstMr){
                    Boolean flag = false;

                    for(caracteristica c : d.getCrcs()){
                        if(c.getCrcCodigo() == mr.getCrcCodigo()) {
                            flag = true;
                            break;
                        }else{
                            flag = false;
                        }
                    }
                    matrizBooleana mb = new matrizBooleana();
                    mb.setDspCodigo(d.getDspCodigo());
                    mb.setAppCodigo(a.getAppCodigo());
                    mb.setCrcCodigo(mr.getCrcCodigo());
                    mb.setDispositivo(d);
                    mb.setApp(a);
                    mb.setCaracteristica(mr.getCaracteristica());
                    mb.setMtrBolExiste(flag);
                    em.persist(mb);
                }
            }
            em.getTransaction().commit();
        }catch (Exception e){
            e.toString();
        }finally {
            em.close();
        }
        System.out.println("Matriz Booleana: Datos insertados...");
    }

    public void deleteMatrizBooleanaXApp(app app){
        System.out.println("Matriz Booleana: Eliminando datos de la Matriz Booleana para la app "+app.getAppDescripcion()+"...");
        EntityManager em = emf.createEntityManager();
        Query qry = em.createQuery("DELETE FROM matrizBooleana WHERE appCodigo = :a");
        qry.setParameter("a", app.getAppCodigo());
        em.getTransaction().begin();
        qry.executeUpdate();
        em.getTransaction().commit();
        em.close();
        System.out.println("Matriz Booleana: Datos eliminados...");
    }

    public List<matrizBooleana> listaMatrizBooleana(app app){
        List<matrizBooleana> lstMb = new ArrayList<matrizBooleana>();

        EntityManager em = emf.createEntityManager();
        Query qry = em.createQuery("FROM matrizBooleana mb WHERE mb.appCodigo = :a ", matrizBooleana.class);
        qry.setParameter("a", app.getAppCodigo());
        lstMb = qry.getResultList();

        return lstMb;
    }
}
