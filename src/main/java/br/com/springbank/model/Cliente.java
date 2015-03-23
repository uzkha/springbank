package br.com.springbank.model;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "C")
public class Cliente extends Pessoa {
	
	@Column
	private String tipoCliente;
		
	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipo) {
		this.tipoCliente = tipo;
	}

}
