package br.com.springbank.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="pessoa")
@DiscriminatorValue(value = "C")
public class Cliente {
	
	@Column
	private String tipoCliente;
		
	public String getTipo() {
		return tipoCliente;
	}

	public void setTipo(String tipo) {
		this.tipoCliente = tipo;
	}

}
