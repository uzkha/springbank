package br.com.springbank.dao;

import java.util.Collection;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.hibernate.Query;
import br.com.springbank.model.Agencia;




@Repository
public class AgenciaDao extends AbstractClassSessionFactory{
	
	public void salvar(Agencia agencia) {
		super.getSession().saveOrUpdate(agencia);
		//Long id = paciente.getId();
		//db.put(id, paciente);
		
	}
	
	public Collection<Agencia>listar() {
		
		List<Agencia> agencias = getSession().createCriteria(Agencia.class).list();
		
		return agencias;
	}

	public Agencia get(Long id) {
		Agencia agencia = (Agencia)getSession().load(Agencia.class, id);
		return agencia; //db.get(id);
	}


	public void deletar(Long id) {
		Agencia agencia = new Agencia();
		agencia.setId(id);
		getSession().delete(agencia);
		//db.remove(id);
	}
	
	public Agencia buscarId(Long id){  	  
		Agencia agencia = (Agencia)getSession().load(Agencia.class, id);
		return agencia; //db.get(id);
	}  
	
	public List<Agencia> buscarNomeIdDiferente(Agencia agencia){
		
		//converte null para 0, em caso de insercao nao existe ainda o ID
		Long id = agencia.getId() == null ? 0: agencia.getId();
		
		String hql = "from Agencia where nome = :nome and id <> :id"; 
		Query query = getSession().createQuery(hql); 
		query.setParameter("id", id);
		query.setParameter("nome", agencia.getNome());
		
		
		List<Agencia> agencias = query.list();
		
		
		return agencias;
	}
	


}
