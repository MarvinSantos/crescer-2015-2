package br.com.cwi.crescer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cwi.crescer.service.ClienteService;
import br.com.cwi.crescer.service.PessoaService;

@Controller
public class IndexController {
	
	private ClienteService clienteService;
	
	@Autowired
	public IndexController(ClienteService clienteService) {
		super();
		this.clienteService = clienteService;
	}

    @RequestMapping(name = "/")
    public String index(Model model) {

        String bemVindo = "Bem vindo à lavanderia crescer";

        model.addAttribute("mensagem", bemVindo);

        return "index";
    }
    
    
    @RequestMapping("/testes")
    public String textes(Model model) {
		
		String mensagem = "pagina para debugar";
		String nome = clienteService.buscarNome(1L);
			
		model.addAttribute("nome", nome);
		
		return "testes";	
    }
    
}
