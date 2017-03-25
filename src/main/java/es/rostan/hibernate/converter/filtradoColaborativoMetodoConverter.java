package es.rostan.hibernate.converter;

import es.rostan.hibernate.beans.filtradoColaborativoBean;
import es.rostan.hibernate.entidades.metodo;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * Created by Rostan on 16/02/2017.
 */
@FacesConverter(forClass = metodo.class , value = "filtradoColaborativoMetodoConverter")
public class filtradoColaborativoMetodoConverter implements Converter {
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return (value instanceof metodo) ? String.valueOf(((metodo) value).getMetCodigo()) : null;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null)
            return null;

        filtradoColaborativoBean data = context.getApplication().evaluateExpressionGet(context,
                "#{filtradoColaborativoBean}", filtradoColaborativoBean.class);

        for (metodo metodo : data.getLstMetodos()) {
            if (metodo.getMetCodigo() == Integer.valueOf(value))
                return metodo;
        }

        throw new ConverterException(new FacesMessage(String.format("Cannot convert %s to metodo", value)));
    }
}
