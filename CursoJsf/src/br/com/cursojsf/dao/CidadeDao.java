package br.com.cursojsf.dao;

import java.util.List;

import br.com.cursojsf.model.Cidade;

public interface CidadeDao {

	/**
	 * Insere a cidade na base de dados.
	 * 
	 * @param cidade
	 *            Cidade a ser persistida.
	 */
	void salvarCidade(Cidade cidade);

	/**
	 * Exclui a cidade na base de dados.
	 * 
	 * @param cidade
	 *            cidade a ser excluido
	 */
	void excluirCidade(Cidade cidade);

	/**
	 * Seleciona todos os registros aramzenados de um cidade {@link Cidade}.
	 * 
	 * @return lista de {@link Cidade}
	 */
	List<Cidade> selecionarTodos();

	/**
	 * Seleciona as cidades que possuem atributos que correspondam aos atributos
	 * setados na cidade exemplo.
	 * 
	 * @param cidade
	 *            Cidade contendo os parametros da consulta.
	 * @return a cidade que corresponde ao parametro da consulta.
	 */
	Cidade selecionar(Cidade cidade);

	/**
	 * Insere uma lista de cidades na base de dados.
	 * 
	 * @param cidades
	 *            Lista de cidades a serem persistida
	 */
	void salvarCidades(List<Cidade> cidades);
}