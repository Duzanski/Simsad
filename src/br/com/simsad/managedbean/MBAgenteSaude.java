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

import br.com.simsad.bean.AgenteSaude;
import br.com.simsad.dao.AgenteSaudeDAO;


@ManagedBean(name = "MBAgenteSaude")
@ViewScoped
public class MBAgenteSaude implements Serializable {

	private static final long serialVersionUID = 1L;

	/* Objeto da classe AgenteSaude */

	private AgenteSaude agenteSaudeBean = new AgenteSaude();

	/* Lista de Agentes de Sa�de */

	private List<AgenteSaude> listAgenteSaude;

	/* DataModel de Agentes de Sa�de */

	private DataModel<AgenteSaude> listAgenteSaudeData;

	/* Vari�vel de controle do Painel de Consulta */

	private Integer visPanelConsulta = 0;

	/* M�todo respons�vel pelo envio do objeto para a persist�ncia */

	public void salvar() {

		FacesContext context = FacesContext.getCurrentInstance();

		try {

			AgenteSaudeDAO dao = new AgenteSaudeDAO();
			dao.salvar(agenteSaudeBean);
			context.addMessage(null, new FacesMessage("Agente de Sa�de Salvo Com Sucesso !"));
			limpaFormulario();

		} catch (Exception e) {

			System.out.print("Erro" + e.getMessage() + "Causa" + e.getCause());
		}

	}

	/* M�todo respons�vel pelo envio do objeto para a exclus�o */

	public void excluir(ActionEvent e) {

		FacesContext context = FacesContext.getCurrentInstance();

		try {

			agenteSaudeBean = (AgenteSaude) (listAgenteSaudeData.getRowData());
			AgenteSaudeDAO dao = new AgenteSaudeDAO();
			dao.excluir(agenteSaudeBean);
			this.setVisPanelConsulta(0);
			limpaFormulario();
			context.addMessage(null, new FacesMessage("Agente de Sa�de exclu�do com sucesso !"));

		} catch (Exception ex) {

		}

	}

	/* M�todo respons�vel pelo preenchimento do objeto com a linha selecionada */

	public void alterar(ActionEvent e) {

		agenteSaudeBean = (AgenteSaude) (listAgenteSaudeData.getRowData());


	}

	/* M�todo respons�vel pela conver�o de List em DataModel */

	public DataModel<AgenteSaude> pesquisarPorNome() {

		try {

			this.listAgenteSaude = new ArrayList<AgenteSaude>();
			AgenteSaudeDAO dao = new AgenteSaudeDAO();
			listAgenteSaude = dao.buscarPorNome(agenteSaudeBean);
			listAgenteSaudeData = new ListDataModel<AgenteSaude>(listAgenteSaude);
			this.setVisPanelConsulta(1);


		} catch (Exception e) {
			System.out.println("Erro ao buscar por nome:" + e.getMessage());
		}

		return listAgenteSaudeData;
	}

	/* M�todo respons�vel pela limpeza do objeto e da lista */

	public void limpaFormulario() {

		agenteSaudeBean = new AgenteSaude();
		
		if (listAgenteSaude != null){
		
			listAgenteSaude.clear();
			
		}
		

	}

	/* Getters and Setters */

	public AgenteSaude getAgenteSaudeBean() {

		return agenteSaudeBean;
	}

	public void setAgenteSaudeBean(AgenteSaude agenteSaudeBean) {

		this.agenteSaudeBean = agenteSaudeBean;
	}

	public List<AgenteSaude> getListAgenteSaude() {

		return listAgenteSaude;
	}

	public void setListAgenteSaude(List<AgenteSaude> listAgenteSaude) {

		this.listAgenteSaude = listAgenteSaude;
	}

	public DataModel<AgenteSaude> getListAgenteSaudeData() {

		return listAgenteSaudeData;
	}

	public void setListAgenteSaudeData(DataModel<AgenteSaude> listAgenteSaudeData) {

		this.listAgenteSaudeData = listAgenteSaudeData;
	}

	public Integer getVisPanelConsulta() {

		return visPanelConsulta;
	}

	public void setVisPanelConsulta(Integer visPanelConsulta) {

		this.visPanelConsulta = visPanelConsulta;
	}


}
