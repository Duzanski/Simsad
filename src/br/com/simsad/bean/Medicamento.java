package br.com.simsad.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tb_medicamento")
public class Medicamento implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_MEDICAMENTO")
	private Integer idMedicamento;

	@Column(name = "NOME", nullable = false, length = 15)
	private String nome;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_LABORATORIO")
	private Laboratorio beanLaboratorio = new Laboratorio();


	public Integer getIdMedicamento() {

		return idMedicamento;
	}

	public void setIdMedicamento(Integer idMedicamento) {

		this.idMedicamento = idMedicamento;
	}

	public String getNome() {

		return nome;
	}

	public void setNome(String nome) {

		this.nome = nome;
	}

	public Laboratorio getBeanLaboratorio() {

		return beanLaboratorio;
	}

	public void setBeanLaboratorio(Laboratorio beanLaboratorio) {

		this.beanLaboratorio = beanLaboratorio;
	}


}
