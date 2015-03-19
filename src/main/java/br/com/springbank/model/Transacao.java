package br.com.springbank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="transacao")
public class Transacao {

	@Id	
	@GenericGenerator(name="transcaoid" , strategy="increment")
	@GeneratedValue(generator="transcaoid") 
	private Long id;
	
	@Column
	private String tipo;
	
	@ManyToOne
    @JoinColumn(nullable=false)
	private Conta conta;
	
	@ManyToOne
    @JoinColumn(nullable=false)
	private Cliente cliente;
		
	@Column
	private double valor;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
		
}
