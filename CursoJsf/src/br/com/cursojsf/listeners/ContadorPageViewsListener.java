package br.com.cursojsf.listeners;

import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class ContadorPageViewsListener implements ServletRequestListener {

	private static final String CONTADOR = "contador";

	@Override
	public void requestInitialized(ServletRequestEvent event) {
		ServletRequest servletRequest = event.getServletRequest();
		HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
		String url = httpRequest.getRequestURL().toString();
		if (url.endsWith(".xhtml")) {
			ServletContext context = httpRequest.getServletContext();

			// Utilizando ConcurrentHashMap para garantir o controle de
			// concorrencia em caso de muitos acessos a aplicacao
			ConcurrentHashMap<String, Integer> contador = getContador(context);

			// Somente inicializa se nao existir
			Integer quantidade = 0;
			contador.putIfAbsent(url, quantidade);
			do {
				// Obtem a quantidade de acessos
				quantidade = contador.get(url);
				
				// Altera o valor se este ainda nao foi alterado
			} while (!contador.replace(url, quantidade, ++quantidade));
		}
	}

	@Override
	public void requestDestroyed(ServletRequestEvent event) {
	}

	@SuppressWarnings("unchecked")
	private ConcurrentHashMap<String, Integer> getContador(ServletContext context) {
		ConcurrentHashMap<String, Integer> contador = 
			(ConcurrentHashMap<String, Integer>) context.getAttribute(CONTADOR);
		if (contador == null) {
			contador = new ConcurrentHashMap<String, Integer>();
			context.setAttribute(CONTADOR, contador);
		}
		return contador;
	}
}
