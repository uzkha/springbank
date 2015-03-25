package br.com.springbank.dao;

import java.util.Collection;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.hibernate.Query;
import br.com.springbank.model.Conta;




@Repository
public class ContaDao extends AbstractClassSessionFactory{
	
	public void salvar(Conta conta) {
		super.getSession().saveOrUpdate(conta);
		//Long id = paciente.getId();
		//db.put(id, paciente);
		
	}
	
	public Collection<Conta>listar() {
		
		List<Conta> contas = getSession().createCriteria(Conta.class).list();
		
		return contas;
	}

	public Conta get(Long id) {
		Conta conta = (Conta)getSession().load(Conta.class, id);
		return conta; //db.get(id);
	}


	public void deletar(Long id) {
		Conta conta = new Conta();
		conta.setId(id);
		getSession().delete(conta);
		//db.remove(id);
	}
	
	public Conta buscarId(Long id){  	  
		Conta conta = (Conta)getSession().load(Conta.class, id);
		return conta; //db.get(id);
	}  

}
