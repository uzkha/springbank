package br.com.springbank.services;

import br.com.springbank.model.Agencia;

public interface AgenciaService {
	
	public void cadastrarAgencia(Agencia agencia);
	
	public void alterarAgencia(Agencia agencia);
	
	public void deletarAgencia(int id);

}
