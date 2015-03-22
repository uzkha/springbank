package br.com.springbank.service;

import java.util.Collection;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
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
	public void salvar(Agencia agencia) throws ServiceException {
		
		//verifica se existe agencia com o mesmo nome
		validarNomeAgencia(agencia);
		
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
	
	
	
	/****************VALIDACAO
	 * @throws Exception **************/
	
	private void validarNomeAgencia(Agencia agencia) throws ServiceException {
				
		List<Agencia> agencias = agenciaDao.buscarNomeIdDiferente(agencia);
		
		if(agencias.size() > 0){
			throw new ServiceException("Já existe um agencia com o mesmo nome");
		}
		
		
	}

}
