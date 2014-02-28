package br.com.cursojsf.business.impl;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import br.com.cursojsf.business.UsuarioBusiness;
import br.com.cursojsf.business.UsuarioInvalidoException;
import br.com.cursojsf.dao.UsuarioDao;
import br.com.cursojsf.model.Usuario;

@ApplicationScoped
@ManagedBean(name = "usuarioBusiness")
public class UsuarioBusinessImpl implements UsuarioBusiness {

    @ManagedProperty("#{usuarioDao}")
	private UsuarioDao usuarioDao;

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	/** {@inheritDoc} */
	public Usuario autenticarUsuario(String cpf, String senha)
			throws UsuarioInvalidoException {
		Usuario usuario = usuarioDao.selecionar(cpf);
		if (usuario == null || !usuario.getSenha().equals(senha)) {
			throw new UsuarioInvalidoException();
		}
		return usuario;
	}

	/** {@inheritDoc} */
	public void excluirUsuario(Usuario usuario) {
		usuarioDao.excluirUsuario(usuario);
	}

	/** {@inheritDoc} */
	public void salvarUsuario(Usuario usuario) {
		usuarioDao.salvarUsuario(usuario);
	}

	/** {@inheritDoc} */
	public Usuario selecionar(Usuario usuario) {
		return usuarioDao.selecionar(usuario);
	}

	/** {@inheritDoc} */
	public List<Usuario> selecionarTodos() {
		return usuarioDao.selecionarTodos();
	}

}
