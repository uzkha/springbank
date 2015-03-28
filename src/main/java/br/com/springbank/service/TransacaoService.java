package br.com.springbank.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import br.com.springbank.model.Cliente;
import br.com.springbank.model.Conta;
import br.com.springbank.model.Transacao;


public interface TransacaoService {
	
	public void salvar(Transacao transacao);
	
	public Collection<Transacao> listar();	
	
	public Collection<Transacao> listar(Cliente cliente);	
		
	public Transacao buscarId(Long id);
	
	//public Transacao buscarIdOrigem(Long id);
	
	public void transferir(Transacao transacao, Conta conta);

}
