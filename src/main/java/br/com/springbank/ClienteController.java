package br.com.springbank;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.springbank.model.Cliente;
import br.com.springbank.services.PessoaService;

public class ClienteController {

	@Autowired
	private PessoaService pessoaService;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/cliente", method = RequestMethod.GET)
	public String cliente(Locale locale, Cliente cliente, ModelMap model) {
		
		//busca lista de cliente
		pessoaService.cadastrarCliente(cliente);
		
		
		return "cliente";
	}

}
