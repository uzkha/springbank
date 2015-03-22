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

import br.com.springbank.model.Agencia;
import br.com.springbank.service.AgenciaService;

@Controller
@RequestMapping(value= "/agencia")
public class AgenciaController {

	@Autowired
	private AgenciaService agenciaService;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listar(Locale locale, ModelMap model) {
		
		model.addAttribute("agencias", agenciaService.listar());	
		return "agencia/listar";
	}
	
	@RequestMapping(value = "/adicionar", method = RequestMethod.GET)
	public String agenciaCadastrar(Locale locale, ModelMap model, HttpSession session) {		
		return "/agencia/form";
	}
	
	@RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
	public String editar(Locale locale, ModelMap model, @PathVariable("id") Long id) {
		
		Agencia agencia = agenciaService.buscarId(id);
		model.addAttribute("agencia", agencia);	
		
		return "/agencia/form";
	}
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvar(Locale locale, ModelMap model, Agencia agencia) {
		
		try{
			agenciaService.salvar(agencia);		
			model.addAttribute("agencias", agenciaService.listar());
			model.addAttribute("message", "Cadastra efetuado com sucesso!");
			
			return "agencia/listar";
			
		}catch (ServiceException e){
			
			model.addAttribute("agencia", agencia);
			model.addAttribute("message", e.getMessage());
			return "agencia/form";			
		}
		
		
	}
	
	@RequestMapping(value = "/deletar/{id}", method = RequestMethod.GET)
	public String deletar(Locale locale, ModelMap model, @PathVariable("id") Long id) {
		
		agenciaService.deletar(id);
		
		model.addAttribute("agencias", agenciaService.listar());	
		model.addAttribute("message", "Exclusão efetuada com sucesso!");
		
		return "agencia/listar";
	}

}
