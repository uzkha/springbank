package br.com.springbank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="conta")
public class Conta {
	
	@Id	
	@GenericGenerator(name="contaid" , strategy="increment")
	@GeneratedValue(generator="contaid") 
	private Long id;
	
	@ManyToOne
    @JoinColumn(nullable=false)
	private Agencia agencia;
	
	@Column
	private double saldo;
	
	@Column
	private double limite;
	
	@Column
	private int cliente;
	
	@Column
	private Gerente gerente;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Agencia getAgencia() {
		return agencia;
	}
	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public double getLimite() {
		return limite;
	}
	public void setLimite(double limite) {
		this.limite = limite;
	}
	public int getCliente() {
		return cliente;
	}
	public void setCliente(int cliente) {
		this.cliente = cliente;
	}
	public Gerente getGerente() {
		return gerente;
	}
	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

}
