package br.com.cursojsf.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import br.com.cursojsf.model.Cidade;

/**
 * Classe de visao para o caso de uso Cadastro de Estados durante a edicao de
 * cidades.
 * 
 * @author Fabio Barros
 */
@ManagedBean
@SessionScoped
public class CidadeBean {

    /**
     * Referenciapara o bean de Estado. Necessario por usar metodos do mesmo.
     */
    @ManagedProperty("#{estadoBean}")
    private EstadoBean estadoBean;

    /**
     * Cidade a ser editada.
     */
    private Cidade cidade;

    public void setEstadoBean(EstadoBean estadoBean) {
        this.estadoBean = estadoBean;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String novo() {
        cidade = new Cidade();
        return "cidadesEditar";
    }

    public String salvar() {
        if (estadoBean.getEstado().getCidades() == null) {
            estadoBean.getEstado().setCidades(new ArrayList<Cidade>());
        }
        List<Cidade> cidades = estadoBean.getEstado().getCidades();

        cidade.setEstado(estadoBean.getEstado());
        if (cidades.contains(cidade)) {
            int pos = cidades.indexOf(cidade);
            cidades.set(pos, cidade);
        } else {
            cidades.add(cidade);
        }

        return "estadosEditar";
    }

    public String excluir() {
        estadoBean.getEstado().getCidades().remove(cidade);
        return "estadosEditar";
    }
}
