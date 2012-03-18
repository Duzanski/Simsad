package br.com.simsad.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_paciente")
public class Paciente extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column(name = "CARTAO_SUS", nullable = false, length = 17)
	private String cartaoSUS;

	@Column(name = "DATA_NASC", nullable = false)
	private Date dataNasc;

	@Column(name = "ESTADO_CIVIL", nullable = false, length = 15)
	private String estadoCivil;


	public String getCartaoSUS() {

		return cartaoSUS;
	}

	public void setCartaoSUS(String cartaoSUS) {

		this.cartaoSUS = cartaoSUS;
	}

	public Date getDataNasc() {

		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {

		this.dataNasc = dataNasc;
	}

	public String getEstadoCivil() {

		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {

		this.estadoCivil = estadoCivil;
	}

}
