package br.com.springbank;

import java.text.ParseException;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.springbank.model.Gerente;
import br.com.springbank.model.Usuario;
import br.com.springbank.service.GerenteService;
import br.com.springbank.service.UsuarioService;

@Controller
@RequestMapping(value = "/gerente")
public class GerenteController {

	@Autowired
	private GerenteService gerenteService;
	
	@Autowired
	private UsuarioService usuarioService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listar(Locale locale, ModelMap model) {

		model.addAttribute("gerentes", gerenteService.listar());
		return "gerente/listar";
	}

	@RequestMapping(value = "/adicionar", method = RequestMethod.GET)
	public String gerenteCadastrar(Locale locale, ModelMap model,
			HttpSession session) {
		
		return "/gerente/form";
	}

	@RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
	public String editar(Locale locale, ModelMap model,
			@PathVariable("id") Long id) {

		Gerente gerente = gerenteService.buscarId(id);		
		model.addAttribute("gerente", gerente);
				
		return "/gerente/form";
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvar(Locale locale, ModelMap model, Gerente gerente) {

		try {
			gerenteService.salvar(gerente);
			model.addAttribute("gerentes", gerenteService.listar());
			model.addAttribute("message", "Cadastro efetuado com sucesso!");

			return "gerente/listar";

		} catch (ServiceException | ParseException e) {

			model.addAttribute("gerente", gerente);
			model.addAttribute("message", e.getMessage());
			
			return "gerente/form";
		}

	}

	@RequestMapping(value = "/deletar/{id}", method = RequestMethod.GET)
	public String deletar(Locale locale, ModelMap model,
			@PathVariable("id") Long id) {

		gerenteService.deletar(id);

		model.addAttribute("gerentes", gerenteService.listar());
		model.addAttribute("message", "Exclusão efetuada com sucesso!");

		return "gerente/listar";
	}
	
	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET)
	public String gerenteUsuario(Locale locale, ModelMap model,	@PathVariable("id") Long id) {

		//busca o gerente
		Gerente gerente = gerenteService.buscarId(id);
		

		model.addAttribute("gerente", gerente);
		model.addAttribute("usuario", gerente.getUsuario());
		
		setarCamposUsuario(locale, model, gerente.getUsuario());
		
		return "gerente/formUsuario";
	}
	
	
	@RequestMapping(value = "/salvarUsuario", method = RequestMethod.POST)
	public String salvarUsuario(Locale locale, ModelMap model, Usuario usuario, Long gerenteId) {

		try {
			
			//gerente
			usuario.setTipo("C");
			
			//adiciona / atualiza usuario
			usuarioService.salvar(usuario);
			
			//busca gerente
			Gerente gerente = gerenteService.buscarId(gerenteId);
			
			//seta codigo usuario ao gerente
			gerente.setUsuario(usuario);
			
			//salva dados gerente
			gerenteService.salvar(gerente);
			
			model.addAttribute("gerente",gerente);
			model.addAttribute("usuario",usuario);
			model.addAttribute("message", "Usuário para o gerente cadastrado com sucesso!");
			
			setarCamposUsuario(locale, model, usuario);
			
			return "gerente/formUsuario";

		} catch (ServiceException | ParseException e) {
			
			Gerente gerente = gerenteService.buscarId(gerenteId);
			
			model.addAttribute("gerente", gerente);
			model.addAttribute("usuario", usuario);
			model.addAttribute("message", e.getMessage());
			
			setarCamposUsuario(locale, model, usuario);
			
			return "gerente/formUsuario";
		}

	}


	
	private void setarCamposUsuario(Locale locale, ModelMap model, Usuario usuario) {

		if (usuario == null) {
			model.addAttribute("ativo", "checked");

		} else {

			// verifica se usuario ativo
			if (usuario.getAtivo().equals(true)) {
				model.addAttribute("ativo", "checked");
			}

		}

	}


}
