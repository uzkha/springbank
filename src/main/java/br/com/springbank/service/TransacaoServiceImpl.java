package br.com.springbank.service;

import java.util.Collection;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.springbank.dao.TransacaoDao;
import br.com.springbank.model.Transacao;

@Service
@Transactional
public class TransacaoServiceImpl implements TransacaoService {

	@Autowired
	private TransacaoDao transacaoDao;

	@Override
	public void salvar(Transacao transacao) throws ServiceException {
			
		//regras de negocio	
		transacaoDao.salvar(transacao);
	}

	@Override
	public Collection<Transacao> listar() {
		return transacaoDao.listar();		
	}


	@Override
	public Transacao buscarId(Long id) {
		return transacaoDao.buscarId(id);
	}
	
	
	/****************VALIDACAO
	 * @throws Exception **************/

}
