package br.com.springbank.service;

import java.util.Collection;

import br.com.springbank.model.Usuario;

public interface UsuarioService {
	
	public void salvar(Usuario usuario);
	
	public Collection<Usuario> listar();
	
	public void deletar(Long id);
	
	public Usuario buscarId(Long id);

}
