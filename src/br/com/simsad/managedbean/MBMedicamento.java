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

import br.com.simsad.bean.Medicamento;
import br.com.simsad.dao.MedicamentoDAO;


@ManagedBean(name = "MBMedicamento")
@ViewScoped
public class MBMedicamento implements Serializable {

	private static final long serialVersionUID = 1L;

	/* Objeto da classe Medicamento */

	private Medicamento medicamentoBean = new Medicamento();

	/* Lista de Medicamentos */

	private List<Medicamento> listMedicamento;

	/* DataModel de Medicamentos */

	private DataModel<Medicamento> listMedicamentoData;

	/* Variável de controle do Painel de Consulta */

	private Integer visPanelConsulta = 0;

	/* Método responsável pelo envio do objeto para a persistência */

	public void salvar() {

		FacesContext context = FacesContext.getCurrentInstance();


		try {

			MedicamentoDAO dao = new MedicamentoDAO();
			dao.salvar(medicamentoBean);
			context.addMessage(null, new FacesMessage("Medicamento Salvo Com Sucesso !"));
			limpaFormulario();

		} catch (Exception e) {

			System.out.print("Erro" + e.getMessage() + "Causa" + e.getCause());
		}

	}

	/* Método responsável pelo envio do objeto para a exclusão */

	public void excluir(ActionEvent e) {

		FacesContext context = FacesContext.getCurrentInstance();

		try {

			medicamentoBean = (Medicamento) (listMedicamentoData.getRowData());
			MedicamentoDAO dao = new MedicamentoDAO();
			dao.excluir(medicamentoBean);
			this.setVisPanelConsulta(0);
			limpaFormulario();
			context.addMessage(null, new FacesMessage("Medicamento excluído com sucesso !"));

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	/* Método responsável pelo preenchimento do objeto com a linha selecionada */

	public void alterar(ActionEvent e) {

		medicamentoBean = (Medicamento) (listMedicamentoData.getRowData());

	}

	/* Método responsável pela converão de List em DataModel */

	public DataModel<Medicamento> pesquisarPorNome() {

		try {

			this.listMedicamento = new ArrayList<Medicamento>();
			MedicamentoDAO dao = new MedicamentoDAO();
			listMedicamento = dao.buscarPorNome(medicamentoBean);
			listMedicamentoData = new ListDataModel<Medicamento>(listMedicamento);
			this.setVisPanelConsulta(1);


		} catch (Exception e) {
			System.out.println("Erro ao buscar por nome:" + e.getMessage());
		}

		return listMedicamentoData;
	}

	/* Método responsável pela limpeza do objeto e da lista */

	public void limpaFormulario() {

		medicamentoBean = new Medicamento();

		if (listMedicamento != null) {

			listMedicamento.clear();

		}

	}

	/* Getters and Setters */


	public Medicamento getMedicamentoBean() {

		return medicamentoBean;
	}


	public void setMedicamentoBean(Medicamento medicamentoBean) {

		this.medicamentoBean = medicamentoBean;
	}


	public List<Medicamento> getListMedicamento() {

		return listMedicamento;
	}


	public void setListMedicamento(List<Medicamento> listMedicamento) {

		this.listMedicamento = listMedicamento;
	}


	public DataModel<Medicamento> getListMedicamentoData() {

		return listMedicamentoData;
	}


	public void setListMedicamentoData(DataModel<Medicamento> listMedicamentoData) {

		this.listMedicamentoData = listMedicamentoData;
	}


	public Integer getVisPanelConsulta() {

		return visPanelConsulta;
	}


	public void setVisPanelConsulta(Integer visPanelConsulta) {

		this.visPanelConsulta = visPanelConsulta;
	}


}
