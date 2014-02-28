package br.com.cursojsf.dao.impl;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.com.cursojsf.dao.EstadoDao;
import br.com.cursojsf.model.Estado;

/**
 * DAO da entidade Estado.
 * @author Fabio Barros
 */
@ApplicationScoped
@ManagedBean(name = "estadoDao")
public class EstadoDaoImpl extends SimpleDaoGenerico<Estado> implements
		EstadoDao {

	public EstadoDaoImpl() {
		for (int i = 1; i <= 10; i++) {
			Estado estado = new Estado();
			estado.setNome("Nome do estado " + i);
			estado.setSigla("EST" + i);
			salvarEntidade(estado);
		}
	}

	/** {@inheritDoc} */
	public void salvarEstado(Estado estado) {
		super.salvarEntidade(estado);
	}

	/** {@inheritDoc} */
	public void excluirEstado(Estado estado) {
		super.excluirEntidade(estado);
	}

	/** {@inheritDoc} */
	@Override
	public Estado selecionar(Estado estado) {
		return super.selecionar(estado);
	}

	/** {@inheritDoc} */
	@Override
	public List<Estado> selecionarTodos() {
		return super.selecionarTodos();
	}

}
