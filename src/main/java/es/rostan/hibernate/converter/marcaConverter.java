package es.rostan.hibernate.converter;

import es.rostan.hibernate.beans.DispositivoBean;
import es.rostan.hibernate.beans.subcategoriasSelectBean;
import es.rostan.hibernate.entidades.caracteristica;
import es.rostan.hibernate.entidades.marca;
import es.rostan.hibernate.entidades.subcategoria;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * Created by Rostan on 16/02/2017.
 */
@FacesConverter(forClass = marca.class , value = "marcaConverter")
public class marcaConverter implements Converter {
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return (value instanceof marca) ? ((marca) value).getMrcNombre() : null;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        if (value == null)
            return null;

        DispositivoBean data = context.getApplication().evaluateExpressionGet(context, "#{dispositivoBean}", DispositivoBean.class);

        for (marca marca : data.getLstMarcas()) {
            if (marca.getMrcNombre().equals(value))
                return marca;
        }

        throw new ConverterException(new FacesMessage(String.format("Cannot convert %s to marca", value)));
    }
}
