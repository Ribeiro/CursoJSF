package br.com.cursojsf.dao;

import java.util.List;

import br.com.cursojsf.model.Usuario;

public interface UsuarioDao {
	/**
	 * Insere o usuario na base de dados.
	 * 
	 * @param usuario
	 *            Usuario a ser persistida.
	 */
	void salvarUsuario(Usuario usuario);

	/**
	 * Exclui o usuario na base de dados.
	 * 
	 * @param usuario
	 *            usuario a ser excluido
	 */
	void excluirUsuario(Usuario usuario);

	/**
	 * Seleciona todos os registros aramzenados de um usuario {@link Usuario}.
	 * 
	 * @return lista de {@link Usuario}
	 */
	List<Usuario> selecionarTodos();

	/**
	 * Seleciona os usuarios que possuem atributos que correspondam aos
	 * atributos setados no usuario exemplo.
	 * 
	 * @param usuario
	 *            Usuario contendo os parametros da consulta.
	 * @return a usuario que corresponde ao parametro da consulta.
	 */
	Usuario selecionar(Usuario usuario);

	/**
	 * Seleciona o usuario que possue o CPF que corresponda ao parametro.
	 * 
	 * @param cpf
	 *            CPF do usuario desejado
	 * @return {@link Usuario} correspondente ou null caso nao seja encontrado.
	 */
	Usuario selecionar(String cpf);
}