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

import br.com.simsad.bean.Laboratorio;
import br.com.simsad.dao.LaboratorioDAO;


@ManagedBean(name = "MBLaboratorio")
@ViewScoped
public class MBLaboratorio implements Serializable {

	private static final long serialVersionUID = 1L;

	/* Objeto da classe Laboratório */

	private Laboratorio laboratorioBean = new Laboratorio();

	/* Lista de Laboratórios */

	private List<Laboratorio> listLaboratorio;

	/* DataModel de Laboratórios */

	private DataModel<Laboratorio> listLaboratorioData;

	/* Variável de controle do Painel de Consulta */

	private Integer visPanelConsulta = 0;

	/* Método responsável pelo envio do objeto para a persistência */

	public void salvar() {

		FacesContext context = FacesContext.getCurrentInstance();

		try {

			LaboratorioDAO dao = new LaboratorioDAO();
			dao.salvar(laboratorioBean);
			context.addMessage(null, new FacesMessage("Laboratorio salvo com sucesso !"));
			limpaFormulario();

		} catch (Exception e) {

			System.out.print("Erro" + e.getMessage() + "Causa" + e.getCause());
			e.printStackTrace();
		}

	}

	/* Método responsável pelo envio do objeto para a exclusão */

	public void excluir(ActionEvent e) {

		FacesContext context = FacesContext.getCurrentInstance();

		try {

			laboratorioBean = (Laboratorio) (listLaboratorioData.getRowData());
			LaboratorioDAO dao = new LaboratorioDAO();
			dao.excluir(laboratorioBean);
			this.setVisPanelConsulta(0);
			limpaFormulario();
			context.addMessage(null, new FacesMessage("Laboratorio excluído com sucesso !"));

		} catch (Exception ex) {

		}

	}

	/* Método responsável pelo preenchimento do objeto com a linha selecionada */

	public void alterar(ActionEvent e) {

		laboratorioBean = (Laboratorio) (listLaboratorioData.getRowData());

	}

	/* Método responsável pela converão de List em DataModel */

	public DataModel<Laboratorio> pesquisarPorNome() {

		try {

			this.listLaboratorio = new ArrayList<Laboratorio>();
			LaboratorioDAO dao = new LaboratorioDAO();
			listLaboratorio = dao.buscarPorNome(laboratorioBean);
			listLaboratorioData = new ListDataModel<Laboratorio>(listLaboratorio);
			this.setVisPanelConsulta(1);

		} catch (Exception e) {
			System.out.println("Erro ao buscar por nome:" + e.getMessage());
		}

		return listLaboratorioData;
	}


	/* Método responsável pela limpeza do objeto e da lista */

	public void limpaFormulario() {

		laboratorioBean = new Laboratorio();

		if (listLaboratorio != null){
			
			listLaboratorio.clear();
			
		}
		
	}

	/* Getters and Setters */

	public Integer getVisPanelConsulta() {

		return visPanelConsulta;
	}


	public void setVisPanelConsulta(Integer visPanelConsulta) {

		this.visPanelConsulta = visPanelConsulta;
	}


	public Laboratorio getLaboratorioBean() {

		return laboratorioBean;
	}


	public void setLaboratorioBean(Laboratorio laboratorioBean) {

		this.laboratorioBean = laboratorioBean;
	}


	public List<Laboratorio> getListLaboratorio() {

		return listLaboratorio;
	}


	public void setListLaboratorio(List<Laboratorio> listLaboratorio) {

		this.listLaboratorio = listLaboratorio;
	}


	public DataModel<Laboratorio> getListLaboratorioData() {

		return listLaboratorioData;
	}


	public void setListLaboratorioData(DataModel<Laboratorio> listLaboratorioData) {

		this.listLaboratorioData = listLaboratorioData;
	}


}
