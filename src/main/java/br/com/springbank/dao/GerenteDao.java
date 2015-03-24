package br.com.springbank.dao;

import java.util.Collection;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.hibernate.Query;
import br.com.springbank.model.Gerente;


@Repository
public class GerenteDao extends AbstractClassSessionFactory{
	
	public void salvar(Gerente gerente) {
		super.getSession().saveOrUpdate(gerente);
		//Long id = paciente.getId();
		//db.put(id, paciente);
		
	}
	
	public Collection<Gerente>listar() {
		
		List<Gerente> gerentes = getSession().createCriteria(Gerente.class).list();
		
		return gerentes;
	}

	public Gerente get(Long id) {
		Gerente gerente = (Gerente)getSession().load(Gerente.class, id);
		return gerente; //db.get(id);
	}


	public void deletar(Long id) {
		Gerente gerente = new Gerente();
		gerente.setId(id);
		getSession().delete(gerente);
		//db.remove(id);
	}
	
	public Gerente buscarId(Long id){  	  
		Gerente gerente = (Gerente)getSession().load(Gerente.class, id);
		return gerente; //db.get(id);
	}  
	
	public List<Gerente> buscarCpfIdDiferente(Gerente gerente){
		
		//converte null para 0, em caso de insercao nao existe ainda o ID
		Long id = gerente.getId() == null ? 0: gerente.getId();
		
		String hql = "from Gerente where cpfcnpj = :cpfcnpj and id <> :id"; 
		Query query = getSession().createQuery(hql); 
		query.setParameter("id", id);
		query.setParameter("cpfcnpj", gerente.getCpfCnpj());
		
		
		List<Gerente> gerentes = query.list();
		
		
		return gerentes;
	}
	
	public List<Gerente> buscarEmailIdDiferente(Gerente gerente){
		
		//converte null para 0, em caso de insercao nao existe ainda o ID
		Long id = gerente.getId() == null ? 0: gerente.getId();
		
		String hql = "from Gerente where email = :email and id <> :id"; 
		Query query = getSession().createQuery(hql); 
		query.setParameter("id", id);
		query.setParameter("email", gerente.getEmail());
		
		
		List<Gerente> gerentes = query.list();
		
		
		return gerentes;
	}
	


}
