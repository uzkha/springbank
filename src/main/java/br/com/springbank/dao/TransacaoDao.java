package br.com.springbank.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import br.com.springbank.model.Cliente;
import br.com.springbank.model.Transacao;
import br.com.springbank.model.Usuario;


@Repository
public class TransacaoDao extends AbstractClassSessionFactory{
	
	public void salvar(Transacao transacao) {
		super.getSession().saveOrUpdate(transacao);
		//Long id = paciente.getId();
		//db.put(id, paciente);
		
	}
	
	public Collection<Transacao>listar() {
		
		List<Transacao> transacaos = getSession().createCriteria(Transacao.class).list();
		
		return transacaos;
	}
	
	public Collection<Transacao>listar(Cliente cliente){  	  
		
		Criteria cr = getSession().createCriteria(Transacao.class);
		cr.add(Restrictions.eq("cliente", cliente));
		List<Transacao> transacoes = cr.list();
		
		return transacoes; 
	}  

	public Transacao get(Long id) {
		Transacao transacao = (Transacao)getSession().load(Transacao.class, id);
		return transacao; //db.get(id);
	}

	public void deletar(Long id) {
		Transacao transacao = new Transacao();
		transacao.setId(id);
		getSession().delete(transacao);
		//db.remove(id);
	}
	
	public Transacao buscarId(Long id){  	  
		Transacao transacao = (Transacao)getSession().load(Transacao.class, id);
		return transacao; //db.get(id);
	}  
	
	/*public Transacao buscarIdOrigem(Long idOrigem){  	  
		Transacao transacao = (Transacao) getSession().createCriteria(Transacao.class).add(Restrictions.eq("idOrigem", idOrigem)).uniqueResult();
		return transacao; //db.get(id);
	}*/  

}
