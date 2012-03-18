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

	/* Objeto da classe Usu�rio */

	private Usuario usuarioBean = new Usuario();

	/* Lista de Usu�rios */

	private List<Usuario> listUsuario;

	/* DataModel de Usu�rios */

	private DataModel<Usuario> listUsuarioData;

	/* Vari�vel de controle do Painel de Consulta */

	private Integer visPanelConsulta = 0;

	/* M�todo respons�vel pelo envio do objeto para a persist�ncia */
	
	public void salvar() {

		FacesContext context = FacesContext.getCurrentInstance();

		try {

			UsuarioDAO dao = new UsuarioDAO();
			dao.salvar(usuarioBean);
			context.addMessage(null, new FacesMessage("Usu�rio salvo com sucesso !"));
			limpaFormulario();

		} catch (Exception e) {

			System.out.print("Erro" + e.getMessage() + "Causa" + e.getCause());
		}

	}

	/* M�todo respons�vel pelo envio do objeto para a exclus�o */

	public void excluir(ActionEvent e) {

		FacesContext context = FacesContext.getCurrentInstance();

		try {	

			usuarioBean = (Usuario) (listUsuarioData.getRowData());
			UsuarioDAO dao = new UsuarioDAO();
			dao.excluir(usuarioBean);
			this.setVisPanelConsulta(0);
			limpaFormulario();
			context.addMessage(null, new FacesMessage("Usuario exclu�do com sucesso !"));

		} catch (Exception ex) {

		}

	}

	/* M�todo respons�vel pelo preenchimento do objeto com a linha selecionada */

	public void alterar(ActionEvent e) {

		usuarioBean = (Usuario) (listUsuarioData.getRowData());

	}

	/* M�todo respons�vel pela conver�o de List em DataModel */

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

	/* M�todo respons�vel pela limpeza do objeto e da lista */

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
