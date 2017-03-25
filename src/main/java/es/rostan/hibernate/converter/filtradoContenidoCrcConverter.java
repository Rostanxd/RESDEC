package es.rostan.hibernate.converter;

import es.rostan.hibernate.beans.filtradoContenidoBean;
import es.rostan.hibernate.entidades.caracteristica;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * Created by Rostan on 16/02/2017.
 */
@FacesConverter(forClass = caracteristica.class , value = "filtradoContenidoCrcConverter")
public class filtradoContenidoCrcConverter implements Converter {
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return (value instanceof caracteristica) ? ((caracteristica) value).getCrcDescripcion() : null;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null)
            return null;

        filtradoContenidoBean data = context.getApplication().evaluateExpressionGet(context, "#{filtradoContenidoBean}", filtradoContenidoBean.class);

        for (caracteristica caracteristica : data.getLstCaracteristicas()) {
            if (caracteristica.getCrcDescripcion().equals(value))
                return caracteristica;
        }

        throw new ConverterException(new FacesMessage(String.format("Cannot convert %s to caracteristica", value)));
    }
}
