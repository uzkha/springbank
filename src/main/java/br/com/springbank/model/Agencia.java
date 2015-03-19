package br.com.springbank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="agencia")
public class Agencia {
	
	@Id	
	@GenericGenerator(name="agenciaid" , strategy="increment")
	@GeneratedValue(generator="agenciaid") 
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	private String cidade;

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
