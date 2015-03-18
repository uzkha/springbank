package br.com.springbank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="agencia")
public class Agencia {
	
	@Id
	@Column
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "agencia")  
    @SequenceGenerator(name = "agencia", sequenceName = "agencia_id_seq") 
	private int id;
	
	@Column
	private String nome;
	
	@Column
	private String cidade;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

}
