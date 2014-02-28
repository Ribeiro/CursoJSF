package br.com.cursojsf.business;

import java.util.List;

import br.com.cursojsf.model.Estado;

/**
 * Interface da regra de negocio para a entidade Estado.
 * @author Fabio Barros
 */
public interface EstadoBusiness {

	/**
	 * Insere o estado na base de dados.
	 * @param estado Estado a ser persistido.
	 * @throws PibInalidoException Caso o valor do PIB de uma cidade seja menor
	 *             que a populacao
	 */
	void salvarEstado(Estado estado) throws PibInalidoException;

	/**
	 * Exclui o estado na base de dados.
	 * @param estado estado a ser excluido
	 */
	void excluirEstado(Estado estado);

	/**
	 * Seleciona todos os registros aramzenados de um estado {@link Estado}.
	 * @return lista de {@link Estado}
	 */
	List<Estado> selecionarTodos();

	/**
	 * Seleciona os estados que possuem atributos que correspondam aos atributos
	 * setados no estado exemplo.
	 * @param estado Estado contendo os parametros da consulta.
	 * @return a estado que corresponde ao parametro da consulta.
	 */
	Estado selecionar(Estado estado);

}