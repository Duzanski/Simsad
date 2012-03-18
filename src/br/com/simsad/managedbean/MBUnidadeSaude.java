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

import br.com.simsad.bean.UnidadeSaude;
import br.com.simsad.dao.UnidadeSaudeDAO;


@ManagedBean(name = "MBUnidadeSaude")
@ViewScoped
public class MBUnidadeSaude implements Serializable {

	private static final long serialVersionUID = 1L;

	/* Objeto da classe UnidadeSaude */

	private UnidadeSaude unidadeSaudeBean = new UnidadeSaude();

	/* Lista de Unidades de Saúde */

	private List<UnidadeSaude> listUnidadeSaude;

	/* DataModel de Unidades de Saúde */

	private DataModel<UnidadeSaude> listUnidadeSaudeData;

	/* Variável de controle do Painel de Consulta */

	private Integer visPanelConsulta = 0;

	/* Método responsável pelo envio do objeto para a persistência */

	public void salvar() {

		FacesContext context = FacesContext.getCurrentInstance();

		try {

			UnidadeSaudeDAO dao = new UnidadeSaudeDAO();
			dao.salvar(unidadeSaudeBean);
			context.addMessage(null, new FacesMessage("Unidade de Saúde salva com sucesso !"));
			limpaFormulario();

		} catch (Exception e) {

			System.out.print("Erro" + e.getMessage() + "Causa" + e.getCause());
		}

	}

	/* Método responsável pelo envio do objeto para a exclusão */

	public void excluir(ActionEvent e) {

		FacesContext context = FacesContext.getCurrentInstance();

		try {

			unidadeSaudeBean = (UnidadeSaude) (listUnidadeSaudeData.getRowData());
			UnidadeSaudeDAO dao = new UnidadeSaudeDAO();
			dao.excluir(unidadeSaudeBean);
			this.setVisPanelConsulta(0);
			limpaFormulario();
			context.addMessage(null, new FacesMessage("Unidae de Saúde excluído com sucesso !"));

		} catch (Exception ex) {

		}

	}

	/* Método responsável pelo preenchimento do objeto com a linha selecionada */

	public void alterar(ActionEvent e) {

		unidadeSaudeBean = (UnidadeSaude) (listUnidadeSaudeData.getRowData());

	}

	/* Método responsável pela converão de List em DataModel */

	public DataModel<UnidadeSaude> pesquisarPorNome() {

		try {

			this.listUnidadeSaude = new ArrayList<UnidadeSaude>();
			UnidadeSaudeDAO dao = new UnidadeSaudeDAO();
			listUnidadeSaude = dao.buscarPorNome(unidadeSaudeBean);
			listUnidadeSaudeData = new ListDataModel<UnidadeSaude>(listUnidadeSaude);
			this.setVisPanelConsulta(1);

		} catch (Exception e) {
			System.out.println("Erro ao buscar por nome:" + e.getMessage());
		}

		return listUnidadeSaudeData;
	}

	/* Método responsável pela limpeza do objeto e da lista */

	public void limpaFormulario() {

		unidadeSaudeBean = new UnidadeSaude();
		
		if (listUnidadeSaude != null){
			
			listUnidadeSaude.clear();
			
		}
		

	}

	/* Getters and Setters */

	public UnidadeSaude getUnidadeSaudeBean() {

		return unidadeSaudeBean;
	}

	public void setUnidadeSaudeBean(UnidadeSaude unidadeSaudeBean) {

		this.unidadeSaudeBean = unidadeSaudeBean;
	}

	public List<UnidadeSaude> getListUnidadeSaude() {

		return listUnidadeSaude;
	}

	public void setListUnidadeSaude(List<UnidadeSaude> listUnidadeSaude) {

		this.listUnidadeSaude = listUnidadeSaude;
	}

	public DataModel<UnidadeSaude> getListUnidadeSaudeData() {

		return listUnidadeSaudeData;
	}

	public void setListUnidadeSaudeData(DataModel<UnidadeSaude> listUnidadeSaudeData) {

		this.listUnidadeSaudeData = listUnidadeSaudeData;
	}

	public Integer getVisPanelConsulta() {

		return visPanelConsulta;
	}

	public void setVisPanelConsulta(Integer visPanelConsulta) {

		this.visPanelConsulta = visPanelConsulta;
	}

}
