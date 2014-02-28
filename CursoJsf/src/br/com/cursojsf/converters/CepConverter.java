package br.com.cursojsf.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import br.com.cursojsf.model.Cep;

@FacesConverter("converters.CepConverter")
public class CepConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value != null && !value.equals("")) {
			try{
				validate(value);
				String [] cepArguments = value.split("-");
				Cep cep = new Cep();
				cep.setRegiao(cepArguments[0]);
				cep.setSufixo(cepArguments[1]);
				return cep;
			}catch (Exception e){
				 FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de conversão",
						  "O CEP informado não é valido!");
				 throw new ConverterException(message);
			}
			
		}
		
		return value;

	}

	private void validate(String value) throws Exception {
		if (!value.contains("-")) {
			throw new Exception("CEP inválido!");
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value == null) {
			return "";
		} else {
			return ((Cep) value).toString();
		}

	}

}