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

import br.com.springbank.model.Cliente;
import br.com.springbank.model.Usuario;
import br.com.springbank.service.ClienteService;

@Controller
@RequestMapping(value = "/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listar(Locale locale, ModelMap model) {

		model.addAttribute("clientes", clienteService.listar());
		return "cliente/listar";
	}

	@RequestMapping(value = "/adicionar", method = RequestMethod.GET)
	public String clienteCadastrar(Locale locale, ModelMap model,
			HttpSession session) {
		
		setarCampos(locale, model, null);
		return "/cliente/form";
	}

	@RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
	public String editar(Locale locale, ModelMap model,
			@PathVariable("id") Long id) {

		Cliente cliente = clienteService.buscarId(id);
		model.addAttribute("cliente", cliente);
		setarCampos(locale, model, cliente);
		
		return "/cliente/form";
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvar(Locale locale, ModelMap model, Cliente cliente) {

		try {
			clienteService.salvar(cliente);
			model.addAttribute("clientes", clienteService.listar());
			model.addAttribute("message", "Cadastro efetuado com sucesso!");

			return "cliente/listar";

		} catch (ServiceException e) {

			model.addAttribute("cliente", cliente);
			model.addAttribute("message", e.getMessage());
			setarCampos(locale, model, cliente);
			return "cliente/form";
		}

	}

	@RequestMapping(value = "/deletar/{id}", method = RequestMethod.GET)
	public String deletar(Locale locale, ModelMap model,
			@PathVariable("id") Long id) {

		clienteService.deletar(id);

		model.addAttribute("clientes", clienteService.listar());
		model.addAttribute("message", "Exclusão efetuada com sucesso!");

		return "cliente/listar";
	}

	private void setarCampos(Locale locale, ModelMap model, Cliente cliente) {

		if (cliente == null) {
			model.addAttribute("fisica", "checked");

		} else {

			// verifica se usuario ativo
			if (cliente.getTipoCliente().equals("F")) {
				model.addAttribute("fisica", "checked");
			}

			// verifica se usuario ativo
			if (cliente.getTipoCliente().equals("J")) {
				model.addAttribute("jurifica", "checked");
			}
		}

	}

}
