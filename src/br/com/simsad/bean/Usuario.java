package br.com.simsad.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class Usuario extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "SENHA", nullable = false, length = 20)
	private String senha;

	public String getSenha() {

		return senha;
	}

	public void setSenha(String senha) {

		this.senha = senha;
	}

}
