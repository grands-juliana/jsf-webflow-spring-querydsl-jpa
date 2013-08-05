package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa;

import br.com.insula.opes.InscricaoEstadual;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("inscricaoConverter")
public class InscricaoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc,
            UIComponent uic,
            String string) {
        try {
            return InscricaoEstadual.fromString(string);
        } catch (IllegalArgumentException ex) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null));
        }
    }

    @Override
    public String getAsString(FacesContext fc,
            UIComponent uic,
            Object o) {
        if (o == null) {
            return null;
        }
        return o.toString();
    }
}
