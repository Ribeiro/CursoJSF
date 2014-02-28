package br.com.cursojsf.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validators.CepValidator")
public class CepValidator implements Validator{
	
	private final static String CEP_REGEX = "\\d{5}-\\d{3}";

	@Override
	public void validate(FacesContext context, UIComponent component,
            Object value)
			throws ValidatorException {
		
        if (value != null) {
        	String valor = value.toString();
            if (!valor.matches(CEP_REGEX)) {
                FacesMessage message = new FacesMessage();
                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                message.setSummary("Erro de Validação");
                message.setDetail("CEP Inválido");
                throw new ValidatorException(message);
            }
        }
		
	}

}