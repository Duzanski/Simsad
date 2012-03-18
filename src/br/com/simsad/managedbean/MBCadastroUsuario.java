package br.com.simsad.managedbean;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.simsad.bean.Usuario;
import br.com.simsad.dao.UsuarioDAO;


@ManagedBean(name = "MBCadastroUsuario")
@ViewScoped
public class MBCadastroUsuario implements Serializable {

	private static final long serialVersionUID = 1L;

	/* Objeto da classe Usuário */

	private Usuario usuarioBean = new Usuario();

	/* Lista de Usuários */

	private List<Usuario> listUsuario;

	/* DataModel de Usuários */

	private DataModel<Usuario> listUsuarioData;

	/* Variável de controle do Painel de Consulta */

	private Integer visPanelConsulta = 0;

	/* Método responsável pelo envio do objeto para a persistência */
	
	public void salvar() {

		FacesContext context = FacesContext.getCurrentInstance();

		try {

			UsuarioDAO dao = new UsuarioDAO();
			dao.salvar(usuarioBean);
			context.addMessage(null, new FacesMessage("Usuário salvo com sucesso !"));
			limpaFormulario();

		} catch (Exception e) {

			System.out.print("Erro" + e.getMessage() + "Causa" + e.getCause());
		}

	}

	/* Método responsável pelo envio do objeto para a exclusão */

	public void excluir(ActionEvent e) {

		FacesContext context = FacesContext.getCurrentInstance();

		try {	

			usuarioBean = (Usuario) (listUsuarioData.getRowData());
			UsuarioDAO dao = new UsuarioDAO();
			dao.excluir(usuarioBean);
			this.setVisPanelConsulta(0);
			limpaFormulario();
			context.addMessage(null, new FacesMessage("Usuario excluído com sucesso !"));

		} catch (Exception ex) {

		}

	}

	/* Método responsável pelo preenchimento do objeto com a linha selecionada */

	public void alterar(ActionEvent e) {

		usuarioBean = (Usuario) (listUsuarioData.getRowData());

	}

	/* Método responsável pela converão de List em DataModel */

	public DataModel<Usuario> pesquisarPorNome() {

		try {

			this.listUsuario = new ArrayList<Usuario>();
			UsuarioDAO dao = new UsuarioDAO();
			listUsuario = dao.buscarPorNome(usuarioBean);
			listUsuarioData = new ListDataModel<Usuario>();
			listUsuarioData.setWrappedData(listUsuario);
			this.setVisPanelConsulta(1);

		} catch (Exception e) {
			System.out.println("Erro ao buscar por nome:" + e.getMessage());
		}

		return listUsuarioData;
	}

	/* Método responsável pela limpeza do objeto e da lista */

	public void limpaFormulario() {

		usuarioBean = new Usuario();
		
		if (listUsuario != null){
		
			listUsuario.clear();
			
		}
		
	}

	/* Getters and Setters */

	public DataModel<Usuario> getListUsuarioData() {

		return listUsuarioData;
	}


	public void setListUsuarioData(DataModel<Usuario> listUsuarioData) {

		this.listUsuarioData = listUsuarioData;
	}


	public Usuario getUsuarioBean() {

		return usuarioBean;
	}

	public void setUsuarioBean(Usuario usuarioBean) {

		this.usuarioBean = usuarioBean;
	}

	public List<Usuario> getListUsuario() {

		return listUsuario;
	}

	public void setListUsuario(List<Usuario> listUsuario) {

		this.listUsuario = listUsuario;
	}

	public Integer getVisPanelConsulta() {

		return visPanelConsulta;
	}

	public void setVisPanelConsulta(Integer visPanelConsulta) {

		this.visPanelConsulta = visPanelConsulta;
	}


}
