package br.com.springbank.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.annotations.Table;

@Entity
//@DiscriminatorValue(value = "G")
public class Gerente extends Pessoa{
	
	@Column
	private Date dataContratacao;

	public Date getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(Date dataContratacao) {
		this.dataContratacao = dataContratacao;
	}
	
}
