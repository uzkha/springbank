package br.com.springbank;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.springbank.model.Agencia;
import br.com.springbank.model.Cliente;
import br.com.springbank.model.Conta;
import br.com.springbank.model.Transacao;
import br.com.springbank.model.Gerente;
import br.com.springbank.model.Usuario;
import br.com.springbank.service.AgenciaService;
import br.com.springbank.service.ClienteService;
import br.com.springbank.service.ContaService;
import br.com.springbank.service.TransacaoService;
import br.com.springbank.service.GerenteService;
import br.com.springbank.service.UsuarioService;

@Controller
@RequestMapping(value= "/transacao")
public class TransacaoController {

	@Autowired
	private TransacaoService transacaoService;
	
	@Autowired
	private ContaService contaService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listar(Locale locale, ModelMap model) {
						
		Usuario usuario = buscarUsuarioSessao();
		
		if(usuario.getTipo().equals("G")){
		
			transacao  = transacaoService.listar(); //lista todas as atividades
		
		}else{
			
			
			Cliente cliente = clienteService.buscarClienteUsuario(usuario);			
	    	transacao = transacaoService.listar(cliente);
			
		}
				
		model.addAttribute("transacoes", transacao);	
		return "transacao/listar";
	}


	@RequestMapping(value = "/adicionar", method = RequestMethod.GET)
	public String transacaoCadastrar(Locale locale, ModelMap model, HttpSession session) {	
			
    			
		listarEntidadeTransacao(locale, model);		
		setarCampos(locale, model, null);
		return "/transacao/form";
	}
	

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvar(Locale locale, ModelMap model, Transacao transacao, Long contaId) {
		
		try{
						
			//busca as entidades
			Conta conta     = contaService.buscarId(contaId);		
			Cliente cliente = clienteService.buscarId(conta.getCliente().getId());
			
			transacao.setConta(conta);
			transacao.setCliente(cliente);
						
			transacaoService.salvar(transacao);					
						
			model.addAttribute("transacoes", transacaoService.listar(cliente));
			model.addAttribute("message", "Movimento realizado com sucesso!");
			
			return "transacao/listar";
			
		}catch (ServiceException e){
			
			model.addAttribute("transacao", transacao);
			model.addAttribute("message", e.getMessage());
			listarEntidadeTransacao(locale, model);		
			return "transacao/form";			
		}
		
		
	}
	
	@RequestMapping(value = "/visualizar/{id}", method = RequestMethod.GET)
	public String deletar(Locale locale, ModelMap model, @PathVariable("id") Long id) {		
		
		Transacao transacao = transacaoService.buscarId(id);
		
		model.addAttribute("transacao",transacao);		
		model.addAttribute("disabled","disabled");	
		
		setarCampos(locale, model, transacao);
		return "transacao/form";
	}

	private void listarEntidadeTransacao(Locale locale, ModelMap model) {
		
		Usuario usuario = buscarUsuarioSessao();
		Cliente cliente = clienteService.buscarClienteUsuario(usuario);	
		
		model.addAttribute("contas", contaService.listar(cliente));	
		
	}
	
	private void setarCampos(Locale locale, ModelMap model, Transacao transacao) {
		
		if(transacao == null){
			model.addAttribute("pagamento", "checked");	
		}else{
			
			if(transacao.getTipoTransacao().equals("P")){
				model.addAttribute("pagamento", "checked");	
			}
			
			if(transacao.getTipoTransacao().equals("T")){
				model.addAttribute("transferencia", "checked");	
			}
		}
		
	}
	
	private Usuario buscarUsuarioSessao() {
		// TODO Auto-generated method stub
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		Usuario usuario = usuarioService.buscarNome(user.getUsername());
		
		return usuario;
		
	}
}
