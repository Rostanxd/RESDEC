package es.rostan.hibernate.entidades;

import java.io.Serializable;

/**
 * Created by Rostan on 25/02/2017.
 */
public class metodo implements Serializable{

    public long metCodigo = 0;

    public String metDescripcion = "";

//    CONSTRUCTOR

    public metodo(){}

    public metodo(long metCodigo, String metDescripcion) {
        this.metCodigo = metCodigo;
        this.metDescripcion = metDescripcion;
    }

//    GETTER Y SETTER

    public long getMetCodigo() {
        return metCodigo;
    }

    public void setMetCodigo(long metCodigo) {
        this.metCodigo = metCodigo;
    }

    public String getMetDescripcion() {
        return metDescripcion;
    }

    public void setMetDescripcion(String metDescripcion) {
        this.metDescripcion = metDescripcion;
    }

    @Override
    public String toString() {
        return metDescripcion;
    }
}
