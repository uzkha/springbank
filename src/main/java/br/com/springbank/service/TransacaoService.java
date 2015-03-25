package br.com.springbank.service;

import java.util.Collection;


import br.com.springbank.model.Transacao;


public interface TransacaoService {
	
	public void salvar(Transacao transacao);
	
	public Collection<Transacao> listar();	
		
	public Transacao buscarId(Long id);

}
