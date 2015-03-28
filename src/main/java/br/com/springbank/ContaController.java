package br.com.springbank;

import java.util.ArrayList;
import java.util.Collection;
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
import br.com.springbank.model.Cliente;
import br.com.springbank.model.Conta;
import br.com.springbank.model.Gerente;
import br.com.springbank.model.Transacao;
import br.com.springbank.model.Usuario;
import br.com.springbank.service.AgenciaService;
import br.com.springbank.service.ClienteService;
import br.com.springbank.service.ContaService;
import br.com.springbank.service.GerenteService;
import br.com.springbank.service.UsuarioService;
import br.com.springbank.util.Auxiliar;

@Controller
@RequestMapping(value= "/conta")
public class ContaController {

	@Autowired
	private ContaService contaService;
	
	@Autowired
	private AgenciaService agenciaService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private GerenteService gerenteService;
	
	@Autowired
	private UsuarioService usuarioService;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listar(Locale locale, ModelMap model) {
		
		Collection<Conta> contas = new ArrayList<Conta>();
		
		String userName = Auxiliar.buscarUsuarioSessao();
		
		Usuario usuario = usuarioService.buscarNome(userName);
		
		if(usuario.getTipo().equals("G")){
			contas = contaService.listar();
		}else{
			Cliente cliente = clienteService.buscarClienteUsuario(usuario);		
			contas = contaService.listar(cliente);
		}
		
		model.addAttribute("contas", contas);	
		return "conta/listar";
	}
	
	@RequestMapping(value = "/adicionar", method = RequestMethod.GET)
	public String contaCadastrar(Locale locale, ModelMap model, HttpSession session) {	
		
		listarEntidadeConta(locale, model);		
		return "/conta/form";
	}
	

	@RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
	public String editar(Locale locale, ModelMap model, @PathVariable("id") Long id) {
		
		
		Conta conta = contaService.buscarId(id);
		listarEntidadeConta(locale, model);		
		model.addAttribute("conta", conta);	
		model.addAttribute("disabled", "disabled");	
		
		
		return "/conta/form";
	}
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvar(Locale locale, ModelMap model, Conta conta, Long agenciaId, Long clienteId, Long gerenteId) {
		
		try{
						
			//busca as entidades
			Agencia agencia = agenciaService.buscarId(agenciaId);
			Cliente cliente = clienteService.buscarId(clienteId);
			Gerente gerente = gerenteService.buscarId(gerenteId);
			
			//seta objtos na conta
			conta.setAgencia(agencia);
			conta.setCliente(cliente);
			conta.setGerente(gerente);
			
			contaService.salvar(conta);		
			model.addAttribute("contas", contaService.listar());
			model.addAttribute("message", "Cadastro efetuado com sucesso!");
			
			return "conta/listar";
			
		}catch (ServiceException e){
			
			model.addAttribute("conta", conta);
			model.addAttribute("message", e.getMessage());
			listarEntidadeConta(locale, model);		
			return "conta/form";			
		}
		
		
	}
	
	@RequestMapping(value = "/deletar/{id}", method = RequestMethod.GET)
	public String deletar(Locale locale, ModelMap model, @PathVariable("id") Long id) {
		
		contaService.deletar(id);
		
		model.addAttribute("contas", contaService.listar());	
		model.addAttribute("message", "Exclusão efetuada com sucesso!");
		
		return "conta/listar";
	}

	private void listarEntidadeConta(Locale locale, ModelMap model) {
		model.addAttribute("agencias", agenciaService.listar());
		model.addAttribute("clientes", clienteService.listar());	
		model.addAttribute("gerentes", gerenteService.listar());			
	}
	
}
