package br.com.springbank.service;

import java.util.Collection;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.springbank.dao.ClienteDao;
import br.com.springbank.model.Cliente;
import br.com.springbank.model.Usuario;

@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteDao clienteDao;

	@Override
	public void salvar(Cliente cliente) throws ServiceException {
		
		//verifica se existe cliente com o mesmo cpf
		validarCpfCliente(cliente);
		
		//verifica se existe cliente com o mesmo email
		validarEmail(cliente);
		
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
	
	@Override
	public Cliente buscarClienteUsuario(Usuario usuario) {
		return clienteDao.buscarClienteUsuario(usuario);
	}
	
	
	/****************VALIDACAO
	 * @throws Exception **************/
	
	private void validarCpfCliente(Cliente cliente) throws ServiceException {
				
		List<Cliente> clientes = clienteDao.buscarCpfIdDiferente(cliente);
		
		if(clientes.size() > 0){
			throw new ServiceException("Já existe um cliente com o mesmo nome");
		}
		
		
	}
	
	private void validarEmail(Cliente cliente) throws ServiceException{
		
		List<Cliente> clientes = clienteDao.buscarEmailIdDiferente(cliente);
		
		if(clientes.size() > 0){
			throw new ServiceException("Já existe um cliente com o mesmo email");
		}
		
	}


}
