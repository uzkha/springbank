package br.com.springbank.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="users")
public class Usuario {
	
	@Id
	@GenericGenerator(name="usuarioid" , strategy="increment")
	@GeneratedValue(generator="usuarioid") 
	private Long id;
	
	@Column(name="username")
	@NotNull
	private String login;
	
	@Column(name="password")
	@NotNull
	private String senha;
	
	
	@Column(name="enabled")
	private Boolean ativo;
	
	@Column(name="type")
	@NotNull
	private String tipo;
	
	@Transient
	private String senhaConfirmacao;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getSenhaConfirmacao() {
		return senhaConfirmacao;
	}

	public void setSenhaConfirmacao(String senhaConfirmacao) {
		this.senhaConfirmacao = senhaConfirmacao;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	
}
