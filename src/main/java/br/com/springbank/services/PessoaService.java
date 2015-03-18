package br.com.springbank.services;

import br.com.springbank.model.Cliente;
import br.com.springbank.model.Gerente;

public interface PessoaService {
	
	public void cadastrarCliente(Cliente cliente);
	
	public void alterarCliente(Cliente cliente);
	
	public void deletarCliente(int id);
	
	public void cadastrarGerente(Gerente gerente);
	
	public void alterarGerente(Gerente gerente);
	
	public void deletarGerente(Gerente gerente);

}
