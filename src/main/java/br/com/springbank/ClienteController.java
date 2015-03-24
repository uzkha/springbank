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

import br.com.springbank.model.Cliente;
import br.com.springbank.model.Usuario;
import br.com.springbank.service.ClienteService;
import br.com.springbank.service.UsuarioService;

@Controller
@RequestMapping(value = "/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private UsuarioService usuarioService;

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

		} catch (Exception e) {

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
	
	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET)
	public String clienteUsuario(Locale locale, ModelMap model,	@PathVariable("id") Long id) {

		//busca o cliente
		Cliente cliente = clienteService.buscarId(id);
		

		model.addAttribute("cliente", cliente);
		model.addAttribute("usuario", cliente.getUsuario());
		
		setarCamposUsuario(locale, model, cliente.getUsuario());
		
		return "cliente/formUsuario";
	}
	
	
	@RequestMapping(value = "/salvarUsuario", method = RequestMethod.POST)
	public String salvarUsuario(Locale locale, ModelMap model, Usuario usuario, Long clienteId) {

		try {
			
			//cliente
			usuario.setTipo("C");
			
			//adiciona / atualiza usuario
			usuarioService.salvar(usuario);
			
			//busca cliente
			Cliente cliente = clienteService.buscarId(clienteId);
			
			//seta codigo usuario ao cliente
			cliente.setUsuario(usuario);
			
			//salva dados cliente
			clienteService.salvar(cliente);
			
			model.addAttribute("cliente",cliente);
			model.addAttribute("usuario",usuario);
			model.addAttribute("message", "Usuário para o cliente cadastrado com sucesso!");
			
			setarCamposUsuario(locale, model, usuario);
			
			return "cliente/formUsuario";

		} catch (ServiceException e) {
			
			Cliente cliente = clienteService.buscarId(clienteId);
			
			model.addAttribute("cliente", cliente);
			model.addAttribute("usuario", usuario);
			model.addAttribute("message", e.getMessage());
			
			setarCamposUsuario(locale, model, usuario);
			
			return "cliente/formUsuario";
		}

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
