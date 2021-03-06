package br.com.springbank.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import br.com.springbank.model.Cliente;
import br.com.springbank.model.Conta;
import br.com.springbank.model.Transacao;

@Repository
public class ContaDao extends AbstractClassSessionFactory {

	public void salvar(Conta conta) {
		super.getSession().saveOrUpdate(conta);
		// Long id = paciente.getId();
		// db.put(id, paciente);

	}

	public Collection<Conta> listar() {

		List<Conta> contas = getSession().createCriteria(Conta.class).list();

		return contas;
	}

	public Collection<Conta> listar(Cliente cliente) {

		Criteria cr = getSession().createCriteria(Conta.class);
		cr.add(Restrictions.eq("cliente", cliente));
		List<Conta> contas = cr.list();

		return contas;
	}

	public Collection<Conta> listarDiff(Cliente cliente) {

		Criteria cr = getSession().createCriteria(Conta.class);
		cr.add(Restrictions.ne("cliente", cliente));
		List<Conta> contas = cr.list();

		return contas;
	}

	public Conta get(Long id) {
		Conta conta = (Conta) getSession().load(Conta.class, id);
		return conta; // db.get(id);
	}

	public void deletar(Long id) {
		Conta conta = new Conta();
		conta.setId(id);
		getSession().delete(conta);
		// db.remove(id);
	}

	public Conta buscarId(Long id) {
		Conta conta = (Conta) getSession().load(Conta.class, id);
		return conta; // db.get(id);
	}

}
