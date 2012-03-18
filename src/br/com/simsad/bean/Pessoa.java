package br.com.simsad.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Table(name = "tb_pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_PESSOA", nullable = false)
	private Integer idPessoa;


	@Column(name = "NOME", nullable = false, length = 50)
	private String nome;

	@Column(name = "SEXO", nullable = true, length = 3)
	private String sexo;

	@Column(name = "RG", nullable = true, length = 19)
	private String rg;

	@Column(name = "CPF", nullable = true, length = 15)
	private String cpf;

	@Column(name = "TELEFONE", nullable = true, length = 15)
	private String telefone;

	@Column(name = "CELULAR", nullable = true, length = 15)
	private String celular;


	public String getTelefone() {

		return telefone;
	}

	public void setTelefone(String telefone) {

		this.telefone = telefone;
	}

	public String getCelular() {

		return celular;
	}

	public void setCelular(String celular) {

		this.celular = celular;
	}


	public Integer getIdPessoa() {

		return idPessoa;
	}


	public void setIdPessoa(Integer idPessoa) {

		this.idPessoa = idPessoa;
	}


	public String getNome() {

		return nome;
	}


	public void setNome(String nome) {

		this.nome = nome;
	}


	public String getSexo() {

		return sexo;
	}


	public void setSexo(String sexo) {

		this.sexo = sexo;
	}


	public String getRg() {

		return rg;
	}


	public void setRg(String rg) {

		this.rg = rg;
	}


	public String getCpf() {

		return cpf;
	}


	public void setCpf(String cpf) {

		this.cpf = cpf;
	}
}
