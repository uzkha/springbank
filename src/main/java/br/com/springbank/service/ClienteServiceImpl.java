package br.com.springbank.service;

import java.util.Collection;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.springbank.dao.ClienteDao;
import br.com.springbank.model.Cliente;

@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteDao clienteDao;

	@Override
	public void salvar(Cliente cliente) throws ServiceException {
		
		//verifica se existe cliente com o mesmo nome
		validarCpfCliente(cliente);
		
		//regras de negocio	
		clienteDao.salvar(cliente);
	}

	@Override
	public Collection<Cliente> listar() {
		return clienteDao.listar();		
	}


	@Override
	public Cliente buscarId(Long id) {
		return clienteDao.buscarId(id);
	}

	@Override
	public void deletar(Long id) {
		clienteDao.deletar(id);		
	}
	
	
	
	/****************VALIDACAO
	 * @throws Exception **************/
	
	private void validarCpfCliente(Cliente cliente) throws ServiceException {
				
		List<Cliente> clientes = clienteDao.buscarCpfIdDiferente(cliente);
		
		if(clientes.size() > 0){
			throw new ServiceException("Já existe um cliente com o mesmo nome");
		}
		
		
	}

}
