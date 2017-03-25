package es.rostan.hibernate.metodos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rostan on 19/12/2016.
 */
public final class MethodsRecomm {

    private MethodsRecomm(){}

    public static final Double coeffPearson(List<Double> x, List<Double> y){
        List<Double> x2 = new ArrayList<Double>();
        List<Double> xy = new ArrayList<Double>();
        List<Double> y2 = new ArrayList<Double>();

        double xSum = 0.0;
        double ySum = 0.0;
        double xMed = 0.0;
        double yMed = 0.0;
        double y2Sum = 0.0;
        double xySum = 0.0;
        double x2Sum = 0.0;
        double coeff = 0.0;

        for (int i = 0; i < x.size(); i++) {
            xSum += x.get(i);
            ySum += y.get(i);
        }

        if (x.size() > 0) {

            xMed = xSum/x.size();
            yMed = ySum/y.size();

            for (int i = 0; i < x.size(); i++) {
                x2.add(Math.pow(x.get(i)-xMed, 2));         //  X
                xy.add((x.get(i)-xMed)*(y.get(i)-yMed));    //  XY
                y2.add(Math.pow(y.get(i)-yMed, 2));         //  Y

                x2Sum += Math.pow(x.get(i)-xMed, 2);
                xySum += (x.get(i)-xMed)*(y.get(i)-yMed);
                y2Sum += Math.pow(y.get(i)-yMed, 2);
            }
        }
        double raiz = 0.0;
        raiz = Math.sqrt((x2Sum)*(y2Sum));
        if (raiz > 0) {
            coeff = xySum / raiz;
            System.out.println("    El Coeff. Pearson es de : "+coeff);
        }

        return coeff;
    }
}

