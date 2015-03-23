package br.com.springbank.service;

import java.util.Collection;

import br.com.springbank.model.Cliente;


public interface ClienteService {
	
	public void salvar(Cliente cliente);
	
	public Collection<Cliente> listar();
	
	public void deletar(Long id);
	
	public Cliente buscarId(Long id);

}
