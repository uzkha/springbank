package br.com.springbank.service;

import java.text.ParseException;
import java.util.Collection;

import org.hibernate.service.spi.ServiceException;

import br.com.springbank.model.Gerente;


public interface GerenteService {
	
	public void salvar(Gerente gerente) throws ServiceException, ParseException;
	
	public Collection<Gerente> listar();
	
	public void deletar(Long id);
	
	public Gerente buscarId(Long id);

}
