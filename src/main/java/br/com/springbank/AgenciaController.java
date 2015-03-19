package br.com.springbank;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.springbank.model.Agencia;
import br.com.springbank.services.AgenciaService;

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
		
		model.addAttribute("view", "agencia/listar.jsp");
		
		return "dashboard";
	}
	
	@RequestMapping(value = "/adicionar", method = RequestMethod.GET)
	public String agenciaCadastrar(Locale locale, ModelMap model) {
		
		model.addAttribute("view", "agencia/form.jsp");
		
		return "dashboard";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") Long id) {
		return "form";
	}
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvar(Locale locale, ModelMap model, Agencia agencia) {
		
		//agenciaService.cadastrarAgencia(agencia);
		
		model.addAttribute("view", "agencia/listar.jsp");
		
		return "dashboard";
	}

}
