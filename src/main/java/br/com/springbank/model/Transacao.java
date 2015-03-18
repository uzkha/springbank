package br.com.springbank.model;

public class Transacao {

	private int id;
	private String tipo;
	private Conta contaOrigem;
	private Conta contaDestino;
	private double valor;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Conta getContaOrigem() {
		return contaOrigem;
	}
	public void setContaOrigem(Conta contaOrigem) {
		this.contaOrigem = contaOrigem;
	}
	public Conta getContaDestino() {
		return contaDestino;
	}
	public void setContaDestino(Conta contaDestino) {
		this.contaDestino = contaDestino;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
