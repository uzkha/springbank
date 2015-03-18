package br.com.springbank.model;

import java.sql.Date;

public class Gerente extends Pessoa{
	
	private Date dataContratacao;

	public Date getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(Date dataContratacao) {
		this.dataContratacao = dataContratacao;
	}
	
}
