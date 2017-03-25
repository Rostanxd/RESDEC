package es.rostan.hibernate.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Created by HP on 14/12/2016.
 */
@FacesConverter("sexoconverter")
public class sexoConverter implements Converter{
    public Object getAsObject(FacesContext contect, UIComponent component, String value){
        return value;
    }

    public String getAsString(FacesContext context, UIComponent component, Object value){
        String sexo = "";

        if(value != null) {
            sexo = (String) value;
            if (sexo.equals("1")) {
                sexo = "Masculino";

            } else if (sexo.equals("2")) {
                sexo = "Femenino";

            }else{
                sexo = "No definido";
            }
        }
        return sexo;
    }
}
