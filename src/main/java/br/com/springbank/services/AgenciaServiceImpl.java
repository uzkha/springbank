package br.com.springbank.services;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.springbank.dao.AgenciaDao;
import br.com.springbank.model.Agencia;

@Service
@Transactional
public class AgenciaServiceImpl implements AgenciaService {

	@Autowired
	private AgenciaDao agenciaDao;

	@SuppressWarnings("deprecation")
	@Override
	public void salvar(Agencia agencia) {
		
		//regras de negocio	
		agenciaDao.salvar(agencia);
	}

	@Override
	public Collection<Agencia> listar() {
		return agenciaDao.listar();		
	}


	@Override
	public Agencia buscarId(Long id) {
		return agenciaDao.buscarId(id);
	}

	@Override
	public void deletar(Long id) {
		agenciaDao.deletar(id);		
	}
	


}
