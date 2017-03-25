package es.rostan.hibernate.converter;

import es.rostan.hibernate.beans.panelSubctgBean;
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
@FacesConverter(forClass = caracteristica.class , value = "crcConverterVideo")
public class crcConverterVideo implements Converter {
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return (value instanceof caracteristica) ? ((caracteristica) value).getCrcDescripcion() : null;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null)
            return null;

        panelSubctgBean data = context.getApplication().evaluateExpressionGet(context, "#{panelSubctgBean}", panelSubctgBean.class);

        for (caracteristica caracteristica : data.getLstCrcVideo()) {
            if (caracteristica.getCrcDescripcion().equals(value))
                return caracteristica;
        }

        throw new ConverterException(new FacesMessage(String.format("Cannot convert %s to caracteristica", value)));
    }
}
