package es.rostan.hibernate.entidades;

/**
 * Created by Rostan on 23/02/2017.
 */
public class matrizContenidoResultado {

    public app app = new app();

    public dispositivo dispositivo = new dispositivo();

    public double valor = 0.0;

//    CONSTRUCTORES
    public matrizContenidoResultado(){}

    public matrizContenidoResultado(app app, dispositivo dispositivo, double valor) {
        this.app = app;
        this.dispositivo = dispositivo;
        this.valor = valor;
    }

//    GETTER Y SETTERS
    public es.rostan.hibernate.entidades.app getApp() {
        return app;
    }

    public void setApp(es.rostan.hibernate.entidades.app app) {
        this.app = app;
    }

    public es.rostan.hibernate.entidades.dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(es.rostan.hibernate.entidades.dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "matrizContenidoResultado{" +
                "app=" + app +
                ", dispositivo=" + dispositivo +
                ", valor=" + valor +
                '}';
    }
}
