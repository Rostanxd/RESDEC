package es.rostan.hibernate.tests;

import es.rostan.hibernate.entidades.usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by HP on 13/12/2016.
 */
public class testUsuario {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public static void main(String[] args){
        ingresarUsuario();

        listarUsuarios();
    }

    public static void ingresarUsuario(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        usuario usr = new usuario();
        usr.setUsrCodigo(2);
        usr.setUsrEdad(20);
        usr.setUsrGenero(1);
        usr.setUsrOcupacion(1);
        usr.setUsrEstudios(2);
        usr.setUsrIntereses(1);
        usr.setUsrFrcInternet(2);
        usr.setUsrNumApp(15);
        usr.setUsrAppInstall(5);
        usr.setUsrAppProm(4);

        em.persist(usr);
        em.getTransaction().commit();
        em.close();
    }

    public static void listarUsuarios(){
        EntityManager em = emf.createEntityManager();
        List<usuario> lstUsr = (List<usuario>) em.createQuery("FROM usuario u").getResultList();
        System.out.println("El sistema registra los siguientes usuarios: ");
        for (usuario u : lstUsr){
            System.out.println(u.toString());
        }
        em.close();
    }
}
