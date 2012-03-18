package br.com.simsad.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tb_agente_saude")
public class AgenteSaude extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "NUMERO_REGISTRO", nullable = false, length = 15)
	private Integer numeroRegistro;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_UNIDADE_SAUDE")
	private UnidadeSaude beanUnidadeSaude = new UnidadeSaude();


	public Integer getNumeroRegistro() {

		return numeroRegistro;
	}


	public void setNumeroRegistro(Integer numeroRegistro) {

		this.numeroRegistro = numeroRegistro;
	}


	public UnidadeSaude getBeanUnidadeSaude() {

		return beanUnidadeSaude;
	}


	public void setBeanUnidadeSaude(UnidadeSaude beanUnidadeSaude) {

		this.beanUnidadeSaude = beanUnidadeSaude;
	}
}
