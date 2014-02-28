package br.com.cursojsf.managedbean;

import static br.com.cursojsf.util.MessageHelper.addErrorMessage;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import br.com.cursojsf.business.EstadoBusiness;
import br.com.cursojsf.business.PibInalidoException;
import br.com.cursojsf.model.Estado;

/**
 * Classe de visao para o caso de uso Cadastro de Estados.
 * @author Fabio Barros
 */
@ManagedBean
@SessionScoped
public class EstadoBean {

	/**
	 * Regra de negocio da entidade Estado.
	 */
    @ManagedProperty("#{estadoBusiness}")
	private EstadoBusiness estadoBusiness;

	/**
	 * Lista de estados selecionados para ser usado na tabela do cadastro.
	 */
	private List<Estado> estados;

	/**
	 * Estado selecionado para edicao.
	 */
	private Estado estado;

	public void setEstadoBusiness(EstadoBusiness estadoBusiness) {
		this.estadoBusiness = estadoBusiness;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String consultar() {
		estados = estadoBusiness.selecionarTodos();
		return "estados";
	}

	public String novo() {
		estado = new Estado();
		return "estadosEditar";
	}

	public String salvar() {
		try {
			estadoBusiness.salvarEstado(estado);
		} catch (PibInalidoException e) {
			addErrorMessage("estadoForm", "bean.estadoBean.pibInalidoException");
			return null;
		}
		return consultar();
	}

	public String excluir() {
		estado = estadoBusiness.selecionar(estado);
		estadoBusiness.excluirEstado(estado);
		return consultar();

	}

	public String editar() {
		estado = estadoBusiness.selecionar(estado);
		return "estadosEditar";
	}
}
