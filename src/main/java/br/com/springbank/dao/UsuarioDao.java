package br.com.springbank.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import br.com.springbank.model.Usuario;




@Repository
public class UsuarioDao extends AbstractClassSessionFactory{
	
	public void salvar(Usuario usuario) {
		super.getSession().saveOrUpdate(usuario);
		//Long id = paciente.getId();
		//db.put(id, paciente);
		
	}
	
	public Collection<Usuario>listar() {
		
		List<Usuario> usuarios = getSession().createCriteria(Usuario.class).list();
		
		return usuarios;
	}

	public Usuario get(Long id) {
		Usuario usuario = (Usuario)getSession().load(Usuario.class, id);
		return usuario; //db.get(id);
	}


	public void deletar(Long id) {
		Usuario usuario = new Usuario();
		usuario.setId(id);
		getSession().delete(usuario);
		//db.remove(id);
	}
	
	public Usuario buscarId(Long id){  	  
		Usuario usuario = (Usuario)getSession().load(Usuario.class, id);
		return usuario; //db.get(id);
	}  
	
	public Usuario buscarNome(String username){  	  
		Usuario usuario = (Usuario) getSession().createCriteria(Usuario.class).add(Restrictions.eq("login", username)).uniqueResult();
		return usuario; //db.get(id);
	}  
	
	
	public List<Usuario> buscarLoginIdDiferente(Usuario usuario){
		
		//converte null para 0, em caso de insercao nao existe ainda o ID
		Long id = usuario.getId() == null ? 0: usuario.getId();
		
		String hql = "from Usuario where login = :login and id <> :id"; 
		Query query = getSession().createQuery(hql); 
		query.setParameter("id", id);
		query.setParameter("login", usuario.getLogin());
		
		
		List<Usuario> usuarios = query.list();
		
		
		return usuarios;
	}
	


}
