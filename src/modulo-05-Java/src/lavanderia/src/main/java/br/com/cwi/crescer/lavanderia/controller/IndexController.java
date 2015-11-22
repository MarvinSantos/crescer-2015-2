package br.com.cwi.crescer.lavanderia.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cwi.crescer.lavanderia.service.CidadeService;
import br.com.cwi.crescer.lavanderia.service.ClienteService;
import br.com.cwi.crescer.lavanderia.service.ItemService;
import br.com.cwi.crescer.lavanderia.service.MaterialService;
import br.com.cwi.crescer.lavanderia.service.PedidoService;
import br.com.cwi.crescer.lavanderia.service.ProdutoService;
import br.com.cwi.crescer.lavanderia.service.ServicoService;


@Controller
public class IndexController {
	
	//private ClienteService clienteService;
	//private CidadeService cidadeService;
	//private ServicoService servicoService;
	//private MaterialService materialService;
	//private ProdutoService produtoService;
	//private PedidoService pedidoService;
	private ItemService itemService;
	
	@Autowired
	public IndexController(ItemService itemService) {
		super();
		this.itemService = itemService;
	}

    @RequestMapping(name = "/")
    public String index(Model model) {

        String bemVindo = "Bem vindo à lavanderia crescer";

        model.addAttribute("mensagem", bemVindo);

        return "index";
    }
    
    
    @RequestMapping("/testes")
    public String testes(Model model) {
		
		String nome = "";
		double valorUnit = 0.00;
		try{
			valorUnit = itemService.buscarValorUnitario(1L);  
		}catch(Exception e){
			e.printStackTrace();
		}
		
		nome = Double.toString(valorUnit);
			
		model.addAttribute("nome", nome);
		
		return "testes";	
    }
    
//    @RequestMapping("/testes")
//    public String testes(Model model) {
//		
//		double valor = 0.00;
//		try{
//			valor = produtoService.buscarValor(1L); 
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		
//		String nome = Double.toString(valor);
//			
//		model.addAttribute("nome", nome);
//		
//		return "testes";	
//    }
    
}
