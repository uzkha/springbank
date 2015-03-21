package br.com.springbank.services;

import java.util.Collection;

import org.springframework.stereotype.Service;

import br.com.springbank.model.Agencia;


public interface AgenciaService {
	
	public void salvar(Agencia agencia);
	
	public Collection<Agencia> listar();
	
	public void deletar(Long id);
	
	public Agencia buscarId(Long id);

}
