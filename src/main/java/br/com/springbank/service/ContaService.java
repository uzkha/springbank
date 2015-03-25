package br.com.springbank.service;

import java.util.Collection;

import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import br.com.springbank.model.Conta;


public interface ContaService {
	
	public void salvar(Conta conta);
	
	public Collection<Conta> listar();
	
	public void deletar(Long id);
	
	public Conta buscarId(Long id);

}
