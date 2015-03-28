package br.com.springbank.service;

import java.util.Collection;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.springbank.dao.TransacaoDao;
import br.com.springbank.model.Cliente;
import br.com.springbank.model.Conta;
import br.com.springbank.model.Transacao;

@Service
@Transactional
public class TransacaoServiceImpl implements TransacaoService {

	@Autowired
	private TransacaoDao transacaoDao;
	
	@Autowired 
	private ContaService contaServive;

	@Override
	public void salvar(Transacao transacao) throws ServiceException {
			
		//regras de negocio	
		Conta conta = contaServive.buscarId(transacao.getConta().getId());
		
		validarPagamento(conta, transacao);
		setarSaldo(conta, transacao);
				
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

	@Override
	public Collection<Transacao> listar(Cliente cliente) {
		return transacaoDao.listar(cliente);
	}
	
	
	/****************VALIDACAO
	 * @throws Exception **************/
	
	private void validarPagamento(Conta conta, Transacao transacao) {
		
		if(transacao.getValor() > (conta.getSaldo() + conta.getLimite())){
			throw new ServiceException("Sua conta não tem saldo suficiente para esta transação.");
		}
		
	}
	

	private void setarSaldo(Conta conta, Transacao transacao) {
		
		Double valor = transacao.getValor();
		Double saldo = conta.getSaldo();
		
		if(transacao.getTipoMovimento().equals("D")){ //debito
			valor = valor * -1;
		}
				
		conta.setSaldo(saldo + valor);
		
		contaServive.salvar(conta);
		
	}

}
