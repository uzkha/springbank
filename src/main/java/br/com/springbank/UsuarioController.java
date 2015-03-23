package br.com.springbank;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.springbank.model.Usuario;
import br.com.springbank.service.UsuarioService;

@Controller
@RequestMapping(value= "/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listar(Locale locale, ModelMap model) {
		
		model.addAttribute("usuarios", usuarioService.listar());	
		return "usuario/listar";
	}
	
	@RequestMapping(value = "/adicionar", method = RequestMethod.GET)
	public String usuarioCadastrar(Locale locale, ModelMap model, HttpSession session) {	
		setarCampos(locale, model, null);
		return "/usuario/form";
	}
	

	@RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
	public String editar(Locale locale, ModelMap model, @PathVariable("id") Long id) {
		
		Usuario usuario = usuarioService.buscarId(id);
		setarCampos(locale, model, usuario);
		model.addAttribute("usuario", usuario);	
		
		return "/usuario/form";
	}
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvar(Locale locale, ModelMap model, Usuario usuario) {
		
		try{
			usuarioService.salvar(usuario);		
			model.addAttribute("usuarios", usuarioService.listar());
			model.addAttribute("message", "Cadastro efetuado com sucesso!");
			
			return "usuario/listar";
			
		}catch (ServiceException e){
			
			model.addAttribute("usuario", usuario);
			model.addAttribute("message", e.getMessage());
			setarCampos(locale, model, usuario);
			
			return "usuario/form";			
		}
		
		
	}
	
	@RequestMapping(value = "/deletar/{id}", method = RequestMethod.GET)
	public String deletar(Locale locale, ModelMap model, @PathVariable("id") Long id) {
		
		usuarioService.deletar(id);
		
		model.addAttribute("usuarios", usuarioService.listar());	
		model.addAttribute("message", "Exclusão efetuada com sucesso!");
		
		return "usuario/listar";
	}
	
	private void setarCampos(Locale locale, ModelMap model, Usuario usuario) {
		
		if (usuario == null){
			model.addAttribute("cliente", "checked");	
			model.addAttribute("ativo", "checked");	
			
		}else{
			
			//verifica se usuario ativo
			if(usuario.getAtivo().equals(true)){
				model.addAttribute("ativo", "checked");	
			}
			
			//verifica se usuario cliente
			if(usuario.getTipo().equals("C")){
				model.addAttribute("cliente", "checked");	
			}
			
			//verifica se usuario cliente
			if(usuario.getTipo().equals("G")){
				model.addAttribute("gerente", "checked");	
			}
		}
		
	}

}
