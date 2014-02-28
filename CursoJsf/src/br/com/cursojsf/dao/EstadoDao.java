package br.com.cursojsf.dao;

import java.util.List;

import br.com.cursojsf.model.Estado;

public interface EstadoDao {
	/**
	 * Insere o estado na base de dados.
	 * 
	 * @param estado
	 *            Estado a ser persistida.
	 */
	void salvarEstado(Estado estado);

	/**
	 * Exclui o estado na base de dados.
	 * 
	 * @param estado
	 *            estado a ser excluido
	 */
	void excluirEstado(Estado estado);

	/**
	 * Seleciona todos os registros aramzenados de um estado {@link Estado}.
	 * 
	 * @return lista de {@link Estado}
	 */
	List<Estado> selecionarTodos();

	/**
	 * Seleciona as estados que possuem atributos que correspondam aos atributos
	 * setados no estado exemplo.
	 * 
	 * @param estado
	 *            Estado contendo os parametros da consulta.
	 * @return a estado que corresponde ao parametro da consulta.
	 */
	Estado selecionar(Estado estado);
}