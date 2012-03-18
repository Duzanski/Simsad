package br.com.simsad.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import br.com.simsad.bean.Laboratorio;
import br.com.simsad.bean.Paciente;
import br.com.simsad.bean.UnidadeSaude;
import br.com.simsad.dao.LaboratorioDAO;
import br.com.simsad.dao.PacienteDAO;
import br.com.simsad.dao.UnidadeSaudeDAO;


@ManagedBean(name = "MBCombo")
@ViewScoped
public class MBCombo implements Serializable {

	private static final long serialVersionUID = 1L;

	/* List e SelectItem de Unidades de Saúde */

	private List<UnidadeSaude> unidadeSaudeList;
	private List<SelectItem> unidadeSaudeItem;

	/* List e SelectItem de Pacientes */

	private List<Paciente> pacienteList;
	private List<SelectItem> pacienteItem;

	/* List e SelectItem de Laboratórios */

	private List<Laboratorio> laboratorioList;
	private List<SelectItem> laboratorioItem;

	/* Método responsável pela busca de Unidades de Saúde */

	public List<SelectItem> comboUnidadeSaude() {

		try {

			this.unidadeSaudeItem = new ArrayList<SelectItem>();
			UnidadeSaudeDAO dao = new UnidadeSaudeDAO();
			unidadeSaudeList = dao.buscarUnidadeSaude();

			for (UnidadeSaude u : unidadeSaudeList) {

				SelectItem select = new SelectItem(u.getIdUnidadeSaude(), u.getNome());
				this.unidadeSaudeItem.add(select);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return unidadeSaudeItem;

	}

	public List<SelectItem> getUnidadeSaudeItem() {

		unidadeSaudeItem = comboUnidadeSaude();
		return unidadeSaudeItem;
	}

	/* Método responsável pela busca de Pacientes */

	public List<SelectItem> comboPaciente() {

		try {

			this.pacienteItem = new ArrayList<SelectItem>();
			PacienteDAO dao = new PacienteDAO();
			pacienteList = dao.buscarPacienteTodos();

			for (Paciente u : pacienteList) {

				SelectItem select = new SelectItem(u.getIdPessoa(), u.getNome());
				this.pacienteItem.add(select);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return pacienteItem;


	}

	public List<SelectItem> getPacienteItem() {

		pacienteItem = comboPaciente();
		return pacienteItem;
	}

	/* Método responsável pela busca de Laboratórios */

	public List<SelectItem> comboLaboratorio() {

		try {

			this.laboratorioItem = new ArrayList<SelectItem>();
			LaboratorioDAO dao = new LaboratorioDAO();
			laboratorioList = dao.buscarLaboratorio();

			for (Laboratorio u : laboratorioList) {

				SelectItem select = new SelectItem(u.getIdLaboratorio(), u.getNome());
				this.laboratorioItem.add(select);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return laboratorioItem;

	}

	public List<SelectItem> getLaboratorioItem() {

		laboratorioItem = comboLaboratorio();
		return laboratorioItem;
	}

}
