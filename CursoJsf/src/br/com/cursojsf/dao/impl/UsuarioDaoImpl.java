package br.com.cursojsf.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.com.cursojsf.dao.UsuarioDao;
import br.com.cursojsf.model.Usuario;

/**
 * DAO da entidade Usuario.
 * 
 * @author Fabio Barros
 */
@ApplicationScoped
@ManagedBean(name = "usuarioDao")
public class UsuarioDaoImpl extends SimpleDaoGenerico<Usuario> implements
		UsuarioDao {

	public UsuarioDaoImpl() {
		Calendar dataNascimento = Calendar.getInstance();

		Usuario usuario = new Usuario();
		usuario.setNomeReduzido("Pedro de Alcantara");
		usuario.setNomeCompleto("Pedro de Alcantara Francisco Antanio "
				+ "Joao Carlos Xavier de Paula Miguel Rafael Joaquim Jose "
				+ "Gonzaga Pascoal Cipriano Serafim de Braganca e Bourbon");
		usuario.setEmail("pedro.alcantara@gmail.com");
		usuario.setSenha("teste");
		usuario.setCpf("11111111111");
		dataNascimento.set(1798, 9, 12);
		usuario.setDataNascimento(dataNascimento.getTime());
		usuario.setSenha("teste");
		super.salvarEntidade(usuario);

		usuario = new Usuario();
		usuario.setNomeReduzido("Santos Dumont");
		usuario.setNomeCompleto("Alberto Santos Dumont");
		usuario.setEmail("santos.dumont@gmail.com");
		usuario.setSenha("teste");
		usuario.setCpf("22222222222");
		dataNascimento.set(1873, 6, 20);
		usuario.setDataNascimento(dataNascimento.getTime());
		super.salvarEntidade(usuario);

		usuario = new Usuario();
		usuario.setNomeReduzido("Isabel de Braganca");
		usuario.setNomeCompleto("Isabel Cristina Leopoldina Augusta "
				+ "Micaela Gabriela Rafaela Gonzaga de Braganca e Bourbon");
		usuario.setEmail("maria@gmail.com");
		usuario.setSenha("teste");
		usuario.setCpf("33333333333");
		dataNascimento.set(1846, 6, 29);
		usuario.setDataNascimento(dataNascimento.getTime());
		super.salvarEntidade(usuario);
	}

	/** {@inheritDoc} */
	public void salvarUsuario(Usuario usuario) {
		super.salvarEntidade(usuario);
	}

	/** {@inheritDoc} */
	public void excluirUsuario(Usuario usuario) {
		super.excluirEntidade(usuario);
	}

	/** {@inheritDoc} */
	@Override
	public Usuario selecionar(Usuario usuario) {
		return super.selecionar(usuario);
	}

	/** {@inheritDoc} */
	@Override
	public List<Usuario> selecionarTodos() {
		return super.selecionarTodos();
	}

	/** {@inheritDoc} */
	public Usuario selecionar(String cpf) {
		List<Usuario> usuarios = selecionarTodos();
		for (Usuario usuarioLista : usuarios) {
			if (usuarioLista.getCpf().equals(cpf)) {
				return usuarioLista;
			}
		}

		return null;
	}
}
