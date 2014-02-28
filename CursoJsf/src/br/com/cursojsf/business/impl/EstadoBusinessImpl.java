package br.com.cursojsf.business.impl;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import br.com.cursojsf.business.EstadoBusiness;
import br.com.cursojsf.business.PibInalidoException;
import br.com.cursojsf.dao.CidadeDao;
import br.com.cursojsf.dao.EstadoDao;
import br.com.cursojsf.model.Cidade;
import br.com.cursojsf.model.Estado;

/**
 * Classe de regra de negocio para a entidade Estado.
 * @author Fabio Barros
 */
@ApplicationScoped
@ManagedBean(name = "estadoBusiness")
public class EstadoBusinessImpl implements EstadoBusiness {

    @ManagedProperty("#{estadoDao}")
	private EstadoDao estadoDao;

    @ManagedProperty("#{cidadeDao}")
    private CidadeDao cidadeDao;
    
	public void setEstadoDao(EstadoDao estadoDao) {
		this.estadoDao = estadoDao;
	}
	
	public void setCidadeDao(CidadeDao cidadeDao) {
		this.cidadeDao = cidadeDao;
	}

	/** {@inheritDoc} */
	public void salvarEstado(Estado estado) throws PibInalidoException {
		validarCidades(estado);
		cidadeDao.salvarCidades(estado.getCidades());
		estadoDao.salvarEstado(estado);
	}

	private void validarCidades(Estado estado) throws PibInalidoException {
		if (estado.getCidades() != null) {
			for (Cidade cidade : estado.getCidades()) {
				Double populacao = cidade.getPopulacao().doubleValue();
				if (populacao.compareTo(cidade.getPib()) > 0) {
					throw new PibInalidoException();
				} else {
					cidade.setEstado(estado);
				}
			}
		}
	}

	/** {@inheritDoc} */
	public void excluirEstado(Estado estado) {
		estadoDao.excluirEstado(estado);
	}

	/** {@inheritDoc} */
	public Estado selecionar(Estado estado) {
		return estadoDao.selecionar(estado);
	}

	/** {@inheritDoc} */
	public List<Estado> selecionarTodos() {
		return estadoDao.selecionarTodos();
	}
}
