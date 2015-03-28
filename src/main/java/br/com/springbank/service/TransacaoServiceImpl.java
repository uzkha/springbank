package br.com.springbank.service;

import java.util.Collection;

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
	
	@Autowired
	private ClienteService clienteService;

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
	
	/*@Override
	public Transacao buscarIdOrigem(Long id) {
		return transacaoDao.buscarIdOrigem(id);
	}*/

	@Override
	public Collection<Transacao> listar(Cliente cliente) {
		return transacaoDao.listar(cliente);
	}
	

	@Override
	public void transferir(Transacao transacaoOrigem, Conta conta) {
		
		//busca cliente
		Cliente cliente = clienteService.buscarId(conta.getCliente().getId());
		
		//nova transacao
		Transacao transacao = new Transacao();
		transacao.setCliente(cliente);
		transacao.setCodigoPagamento(transacaoOrigem.getCodigoPagamento());
		transacao.setConta(conta);
		transacao.setDataMovimento(transacaoOrigem.getDataMovimento());
		transacao.setIdOrigem(transacaoOrigem.getId());
		transacao.setTipoMovimento("C");
		transacao.setTipoTransacao(transacaoOrigem.getTipoTransacao());
		transacao.setValor(transacaoOrigem.getValor());
		
		
		transacaoDao.salvar(transacao);
		
		//atualiza saldo conta destino
		setarSaldo(conta, transacao);	
		
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
