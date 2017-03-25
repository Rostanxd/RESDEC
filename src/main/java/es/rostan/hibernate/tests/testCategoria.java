package es.rostan.hibernate.tests;

import es.rostan.hibernate.entidades.categoria;
import es.rostan.hibernate.entidades.subcategoria;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rostan on 12/02/2017.
 */
public class testCategoria {
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public static void main(String[] args){
        EntityManager man = emf.createEntityManager();

        categoria categoria = new categoria("Categoria prueba");
        subcategoria subCtg = new subcategoria("Subcategoria prueba", categoria);

        man.getTransaction().begin();
        man.persist(categoria);
        man.persist(subCtg);
        man.getTransaction().commit();
        man.close();

        imprimirTodo();

    }

    public static void imprimirTodo(){
        EntityManager man = emf.createEntityManager();
        System.out.println("Categorias en el sistema");
        List<subcategoria> lstSubCtg = new ArrayList<subcategoria>();

        Query qry = man.createQuery("FROM subcategoria ");
        lstSubCtg = qry.getResultList();
        man.close();

        for (subcategoria sb: lstSubCtg){
            System.out.println("Categoria: "+sb.getCategoria().getCtgDescripcion()+" SubCategoria: "+sb.getSubDescripcion());
        }
    }
}
