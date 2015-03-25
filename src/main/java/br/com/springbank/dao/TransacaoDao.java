package br.com.springbank.dao;

import java.util.Collection;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.hibernate.Query;
import br.com.springbank.model.Transacao;




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

}
