package es.rostan.hibernate.dao;

import es.rostan.hibernate.entidades.coeffPearResultSet;
import es.rostan.hibernate.entidades.dispositivo;
import es.rostan.hibernate.entidades.dispositivoApp;
import es.rostan.hibernate.metodos.MethodsRecomm;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Rostan on 25/02/2017.
 */
public class coeffPearsonDAO {
    EntityManagerFactory emf = new Persistence().createEntityManagerFactory("Persistencia");

    public List<coeffPearResultSet> calculoCoeffPearson(dispositivo dsp){
        dispositivo dspBase = dsp;
        List<coeffPearResultSet> lstCPerResSet = new ArrayList<coeffPearResultSet>();

        System.out.println("El dispositvo Base es: "+dspBase.getDspDescripcion());

        Set<dispositivoApp> lstDaBase = new HashSet<dispositivoApp>(0);   //  Dsp-Apps del dispositivo base
        lstDaBase = dspBase.getApps();

        List<dispositivo> lstDspItr = new ArrayList<dispositivo>();    //  Dispositivos a Iterar

        //  Conjunto de arrays - Coeficiente de Pearson
        ArrayList<Double> x = new ArrayList<Double>();  //  Array Base
        ArrayList<Double> y = new ArrayList<Double>();  //  Array a comparar
        ArrayList<Double> x2 = new ArrayList<Double>();
        ArrayList<Double> xy = new ArrayList<Double>();
        ArrayList<Double> y2 = new ArrayList<Double>();

        double xSum = 0.0;
        double ySum = 0.0;
        double xMed = 0.0;
        double yMed = 0.0;
        double y2Sum = 0.0;
        double xySum = 0.0;
        double x2Sum = 0.0;
        double coeff = 0.0;

        //  Conexion a la base para hayar los dispositivos a Iterar
        EntityManager em = emf.createEntityManager();

        Query qry = em.createQuery("FROM dispositivo d WHERE d.dspCodigo <> :dspCodigo");
        qry.setParameter("dspCodigo", dspBase.getDspCodigo());
        lstDspItr = (List<dispositivo>) qry.getResultList();

        System.out.println("Comparando...");
        //  Comparacion y creacion de los 2 arrays de igual longitud para poder aplica el teorema de person.
        for (dispositivo dItr : lstDspItr){     //  C / Dispositvo
            x.clear();
            y.clear();
            x2.clear();
            xy.clear();
            y2.clear();
            xSum = 0.0;
            ySum = 0.0;
            xMed = 0.0;
            yMed = 0.0;
            y2Sum = 0.0;
            xySum = 0.0;
            x2Sum = 0.0;
            coeff = 0.0;

            //  Lista de los votos de aplicaciones para cada dispostivo
            Set<dispositivoApp> lstDaItr = new HashSet<dispositivoApp>(0);
            lstDaItr = dItr.getApps();

            if (lstDaItr.size() > 0) {
                System.out.println("- "+dItr.getDspDescripcion()+"...");
                for (dispositivoApp daBase : lstDaBase) {
                    for (dispositivoApp daItr : lstDaItr) {
                        if (daItr.getAppCodigo() == daBase.getAppCodigo()) {
                            x.add(daBase.getDspAppCalificacion());
                            xSum += daBase.getDspAppCalificacion();
                            y.add(daItr.getDspAppCalificacion());
                            ySum += daItr.getDspAppCalificacion();
                        }
                    }
                }
            }

            //  Variable para almacenar el coeff de pearson entre los 2 dispositivos
            double z = 0.0;
            z = MethodsRecomm.coeffPearson(x, y);

            //  Se crea un objeto en que se guarda la relacion del dispositivo evaluado y su calificacion
            coeffPearResultSet cp = new coeffPearResultSet();
            cp.setDspRs(dItr);
            cp.setValRs(z);
            if (z != 0){
                lstCPerResSet.add(cp);
            }
        }

        return lstCPerResSet;
    }
}
