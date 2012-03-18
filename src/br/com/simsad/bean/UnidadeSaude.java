package br.com.simsad.bean;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tb_unidade_saude")
public class UnidadeSaude implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_UNIDADE_SAUDE")
	private Integer idUnidadeSaude;

	@Column(name = "NOME", nullable = false, length = 50)
	private String nome;


	public Integer getIdUnidadeSaude() {

		return idUnidadeSaude;
	}

	public void setIdUnidadeSaude(Integer idUnidadeSaude) {

		this.idUnidadeSaude = idUnidadeSaude;
	}


	public String getNome() {

		return nome;
	}


	public void setNome(String nome) {

		this.nome = nome;
	}

}
