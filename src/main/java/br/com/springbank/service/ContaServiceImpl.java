package br.com.springbank.service;

import java.util.Collection;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.springbank.dao.ContaDao;
import br.com.springbank.model.Cliente;
import br.com.springbank.model.Conta;

@Service
@Transactional
public class ContaServiceImpl implements ContaService {

	@Autowired
	private ContaDao contaDao;

	@Override
	public void salvar(Conta conta) throws ServiceException {
			
		//regras de negocio	
		contaDao.salvar(conta);
	}

	@Override
	public Collection<Conta> listar() {
		return contaDao.listar();		
	}
	
	@Override
	public Collection<Conta> listar(Cliente cliente) {
				return contaDao.listar(cliente);	
	}

	@Override
	public Conta buscarId(Long id) {
		return contaDao.buscarId(id);
	}

	@Override
	public void deletar(Long id) {
		contaDao.deletar(id);		
	}
	
	
	/****************VALIDACAO
	 * @throws Exception **************/

}
