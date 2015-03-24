package br.com.springbank.dao;

import java.util.Collection;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.hibernate.Query;
import br.com.springbank.model.Cliente;


@Repository
public class ClienteDao extends AbstractClassSessionFactory{
	
	public void salvar(Cliente cliente) {
		super.getSession().saveOrUpdate(cliente);
		//Long id = paciente.getId();
		//db.put(id, paciente);
		
	}
	
	public Collection<Cliente>listar() {
		
		List<Cliente> clientes = getSession().createCriteria(Cliente.class).list();
		
		return clientes;
	}

	public Cliente get(Long id) {
		Cliente cliente = (Cliente)getSession().load(Cliente.class, id);
		return cliente; //db.get(id);
	}


	public void deletar(Long id) {
		Cliente cliente = new Cliente();
		cliente.setId(id);
		getSession().delete(cliente);
		//db.remove(id);
	}
	
	public Cliente buscarId(Long id){  	  
		Cliente cliente = (Cliente)getSession().load(Cliente.class, id);
		return cliente; //db.get(id);
	}  
	
	public List<Cliente> buscarCpfIdDiferente(Cliente cliente){
		
		//converte null para 0, em caso de insercao nao existe ainda o ID
		Long id = cliente.getId() == null ? 0: cliente.getId();
		
		String hql = "from Cliente where cpfcnpj = :cpfcnpj and id <> :id"; 
		Query query = getSession().createQuery(hql); 
		query.setParameter("id", id);
		query.setParameter("cpfcnpj", cliente.getCpfCnpj());
		
		
		List<Cliente> clientes = query.list();
		
		
		return clientes;
	}
	
	public List<Cliente> buscarEmailIdDiferente(Cliente cliente){
		
		//converte null para 0, em caso de insercao nao existe ainda o ID
		Long id = cliente.getId() == null ? 0: cliente.getId();
		
		String hql = "from Cliente where email = :email and id <> :id"; 
		Query query = getSession().createQuery(hql); 
		query.setParameter("id", id);
		query.setParameter("email", cliente.getEmail());
		
		
		List<Cliente> clientes = query.list();
		
		
		return clientes;
	}
	


}
