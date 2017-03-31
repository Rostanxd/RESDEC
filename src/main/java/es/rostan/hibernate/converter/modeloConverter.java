package es.rostan.hibernate.converter;

import es.rostan.hibernate.beans.DispositivoBean;
import es.rostan.hibernate.entidades.modelo;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * Created by Rostan on 16/02/2017.
 */
@FacesConverter(forClass = modelo.class , value = "modeloConverter")
public class modeloConverter implements Converter {
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return (value instanceof modelo) ? ((modelo) value).getMdlNombre() : null;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        if (value == null)
            return null;

        DispositivoBean data = context.getApplication().evaluateExpressionGet(context, "#{dispositivoBean}", DispositivoBean.class);

        for (modelo modelo : data.getLstModelos()) {
            if (modelo.getMdlNombre().equals(value))
                return modelo;
        }

        throw new ConverterException(new FacesMessage(String.format("Cannot convert %s to marca", value)));
    }
}
