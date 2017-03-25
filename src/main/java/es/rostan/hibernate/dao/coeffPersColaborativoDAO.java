package es.rostan.hibernate.dao;

import es.rostan.hibernate.entidades.app;
import es.rostan.hibernate.entidades.dispositivo;
import es.rostan.hibernate.entidades.dispositivoApp;
import es.rostan.hibernate.*;
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
 * Created by Rostan on 19/12/2016.
 */
public class coeffPersColaborativoDAO {
    EntityManagerFactory emf = new Persistence().createEntityManagerFactory("Persistencia");

    //    Crea la matriz de promedios dsp x app
    public void matrizDspApp(dispositivo dsp){
        deleteDspApp();

        dspDAO dd = new dspDAO();
        List<dispositivo> lstDsp = new ArrayList<dispositivo>();
        lstDsp = dd.getLstDsp();

        appDAO ad = new appDAO();
        List<app> lstApp = new ArrayList<app>();
        lstApp = ad.getLstApp();

        EntityManager em = emf.createEntityManager();
        for(dispositivo d : lstDsp){

            List<Integer> dspValores = new ArrayList<Integer>(); // Valoraciones
            Integer dspNum = 0; // Numero de dispositivos
            Integer sumValores = 0;
            double dspPromedio = 0.0;

            for(app a : lstApp){
                Query qry = em.createQuery("SELECT uv.usrDspAppValor FROM usrDspAppValoracion uv WHERE uv.dspCodigo = :dspCodigo and " +
                        "uv.appCodigo = :appCodigo");
                qry.setParameter("dspCodigo", d.getDspCodigo());
                qry.setParameter("appCodigo", a.getAppCodigo());

                dspValores = (List<Integer>) qry.getResultList();

                dspNum = dspValores.size();
                sumValores = 0;
                dspPromedio = 0.0;
                for (int i = 0; i < dspValores.size(); i++) {
                    sumValores += dspValores.get(i);
                }

                if(dspValores.size() > 0) {
                    if (dspNum > 0) {
                        dspPromedio = (float) sumValores / dspNum;
                    }

                    dispositivoApp dspApp = new dispositivoApp();
                    dspApp.setAppCodigo(a.getAppCodigo());
                    dspApp.setDspCodigo(d.getDspCodigo());
                    dspApp.setDspAppCalificacion(dspPromedio);

                    em.getTransaction().begin();
                    em.persist(dspApp);
                    em.getTransaction().commit();
                }
            }
        }
        em.close();
    }

    //    Realiza un Delete de la informacion en la tabla.
    public void deleteDspApp(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("DELETE FROM dispositivoApp da").executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    //  Calculo del metodo de pearson. Recibe el dispositvo Base.
    public void calculoCoeffPearson(dispositivo dspBase){
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

            double z = 0.0;
            z = MethodsRecomm.coeffPearson(x, y);

        }
    }
}
