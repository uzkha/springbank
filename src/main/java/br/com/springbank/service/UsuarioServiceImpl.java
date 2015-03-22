package br.com.springbank.service;

import java.util.Collection;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.springbank.dao.UsuarioDao;
import br.com.springbank.model.Usuario;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDao usuarioDao;

	@Override
	public void salvar(Usuario usuario) throws ServiceException {
		
		//verifica se existe usuario com o mesmo nome
		validarLoginUsuario(usuario);
		
		//validar senha usuario
		validarSenha(usuario);
		
		//regras de negocio	
		usuarioDao.salvar(usuario);
	}


	@Override
	public Collection<Usuario> listar() {
		return usuarioDao.listar();		
	}


	@Override
	public Usuario buscarId(Long id) {
		return usuarioDao.buscarId(id);
	}

	@Override
	public void deletar(Long id) {
		usuarioDao.deletar(id);		
	}
	
	
	
	/****************VALIDACAO
	 * @throws Exception **************/
	
	private void validarLoginUsuario(Usuario usuario) throws ServiceException {
				
		List<Usuario> usuarios = usuarioDao.buscarLoginIdDiferente(usuario);
		
		if(usuarios.size() > 0){
			throw new ServiceException("Já existe um usuario com o mesmo nome");
		}
		
	}
	
	private void validarSenha(Usuario usuario) {
		
		String senha    = usuario.getSenha().trim();
		String senhaCfm = usuario.getSenhaConfirmacao().trim();
		
		if(senha.isEmpty()){
			throw new ServiceException("O campo senha é obrigatório");
		}
		
		if(senhaCfm.isEmpty()){
			throw new ServiceException("O campo de confirmação da senha é obrigatório");
		}
		
		System.out.println(senha);
		System.out.println(senhaCfm);
		
		if (! senha.equals(senhaCfm)){
			throw new ServiceException("Senhas digitadas não conferem.");
		}
		
	}

}
