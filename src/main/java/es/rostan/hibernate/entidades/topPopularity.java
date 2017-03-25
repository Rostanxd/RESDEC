package es.rostan.hibernate.entidades;

/**
 * Created by Rostan on 20/03/2017.
 */
public class topPopularity {

    public dispositivo dispositivo;

    public Double valor;

    //  CONSTRUCTOR
    public topPopularity() {
    }

    public topPopularity(es.rostan.hibernate.entidades.dispositivo dispositivo, Double valor) {
        this.dispositivo = dispositivo;
        this.valor = valor;
    }

    //  GETTERS Y SETTERS
    public es.rostan.hibernate.entidades.dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(es.rostan.hibernate.entidades.dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    //  SOBREESCRITURA DE METODOS
    @Override
    public String toString() {
        return super.toString();
    }
}
