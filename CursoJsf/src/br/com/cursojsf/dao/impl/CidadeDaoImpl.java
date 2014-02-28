package br.com.cursojsf.dao.impl;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.com.cursojsf.dao.CidadeDao;
import br.com.cursojsf.model.Cidade;

/**
 * DAO da entidade Cidade.
 * @author Fabio Barros
 */
@ApplicationScoped
@ManagedBean(name = "cidadeDao")
public class CidadeDaoImpl extends SimpleDaoGenerico<Cidade> implements
		CidadeDao {

	/** {@inheritDoc} */
	public void salvarCidade(Cidade cidade) {
		super.salvarEntidade(cidade);
	}

	/** {@inheritDoc} */
	public void excluirCidade(Cidade cidade) {
		super.excluirEntidade(cidade);
	}

	/** {@inheritDoc} */
	@Override
	public Cidade selecionar(Cidade cidade) {
		return super.selecionar(cidade);
	}

	/** {@inheritDoc} */
	@Override
	public List<Cidade> selecionarTodos() {
		return super.selecionarTodos();
	}

	/** {@inheritDoc} */
	@Override
	public void salvarCidades(List<Cidade> cidades) {
		if (cidades != null) {
			for (Cidade cidade : cidades) {
				salvarCidade(cidade);
			}
		}
	}
}
