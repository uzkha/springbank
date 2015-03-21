package br.com.springbank.dao;
import java.nio.channels.SeekableByteChannel;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.springbank.model.Agencia;



@Repository
public class AgenciaDao extends AbstractClassSessionFactory{
	
 //   @Autowired
 //   private SessionFactory sessionFactory;

  //  protected Session getSession() {
//        return sessionFactory.getCurrentSession(); 
 //   }

	//private static Map<Long, Paciente> db = new HashMap<Long, Paciente>();
	//private Session session;
/*
	@Deprecated
	public AgenciaDao() {}

	@Inject
	public AgenciaDao(Session session) {
		this.session = session;
	}*/
	
	public void salvar(Agencia agencia) {
		super.getSession().saveOrUpdate(agencia);
		//Long id = paciente.getId();
		//db.put(id, paciente);
		
	}
	
	public Collection<Agencia>listar() {
		List<Agencia> agencias = getSession().createCriteria(Agencia.class).list();
		
		System.out.println("");
		
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
	
	public String getNameById(Long id){  	  
	    Agencia agencia= (Agencia) getSession().createCriteria(Agencia.class).add(Restrictions.eq("nome", id)).uniqueResult();  
	    return agencia.getNome();  
	}  

}
