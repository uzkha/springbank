package br.com.springbank.services;

import br.com.springbank.model.Conta;

public interface ContaService {
	
	public void cadastrarConta(Conta conta);
	
	public void alterarConta(Conta conta);
	
	public void deletarConta(int id);

}
