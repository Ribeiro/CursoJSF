package br.com.cursojsf.business;

import java.util.List;

import br.com.cursojsf.model.Usuario;

public interface UsuarioBusiness {

	/**
	 * Efetua autenticacao do usuario cujos dados foram passados como parametro.
	 * @param cpf CPF do usuario
	 * @param senha Senha do usuario
	 * @return {@link Usuario} caso a autenticacao seja bem sucedida
	 * @throws UsuarioInvalidoException caso a autenticacao seja mal sucedida
	 */
	Usuario autenticarUsuario(String cpf, String senha)
			throws UsuarioInvalidoException;

	/**
	 * Insere o estado na base de dados.
	 * @param usuario Usuario a ser persistido.
	 */
	void salvarUsuario(Usuario usuario);

	/**
	 * Exclui o estado na base de dados.
	 * @param estado estado a ser excluido
	 */
	void excluirUsuario(Usuario usuario);

	/**
	 * Seleciona todos os registros aramzenados de um usuario {@link Usuario}.
	 * @return lista de {@link Usuario}
	 */
	List<Usuario> selecionarTodos();

	/**
	 * Seleciona os usuarios que possuem atributos que correspondam aos
	 * atributos setados no usuario exemplo.
	 * @param usuario Usuario contendo os parametros da consulta.
	 * @return a usuario que corresponde ao parametro da consulta.
	 */
	Usuario selecionar(Usuario usuario);
}
