package br.com.springbank.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="transacao")
public class Transacao {

	@Id	
	@GenericGenerator(name="transcaoid" , strategy="increment")
	@GeneratedValue(generator="transcaoid") 
	private Long id;
	
	@Column
	@NotNull
	private String tipoTransacao;
	
	@ManyToOne
    @JoinColumn(nullable=false)
	private Conta conta;
	
	@ManyToOne
    @JoinColumn(nullable=false)
	private Cliente cliente;
		
	@Column
	@NotNull
	private double valor;
	
	@Column
	@NotNull
	private String tipoMovimento;
	
	@Column
	@NotNull
	private Date dataMovimento;
	
	@Column
	private String codigoPagamento;
	
	@Column
	private Long idOrigem;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getTipoTransacao() {
		return tipoTransacao;
	}
	public void setTipoTransacao(String tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}
	public String getTipoMovimento() {
		return tipoMovimento;
	}
	public void setTipoMovimento(String tipoMovimento) {
		this.tipoMovimento = tipoMovimento;
	}
	public Date getDataMovimento() {
		return dataMovimento;
	}
	public void setDataMovimento(Date dataMovimento) {
		this.dataMovimento = dataMovimento;
	}
	public String getCodigoPagamento() {
		return codigoPagamento;
	}
	public void setCodigoPagamento(String codigoPagamento) {
		this.codigoPagamento = codigoPagamento;
	}
	public Long getIdOrigem() {
		return idOrigem;
	}
	public void setIdOrigem(Long idOrigem) {
		this.idOrigem = idOrigem;
	}
	
}
