package br.com.cwi.crescer.lavanderia.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.lavanderia.DTO.ItemDTO;
import br.com.cwi.crescer.lavanderia.DTO.PedidoResumoDTO;
import br.com.cwi.crescer.lavanderia.DTO.ProdutoDTO;
import br.com.cwi.crescer.lavanderia.domain.Item;
import br.com.cwi.crescer.lavanderia.domain.Material;
import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.domain.Produto;
import br.com.cwi.crescer.lavanderia.domain.Servico;
import br.com.cwi.crescer.lavanderia.service.ItemService;
import br.com.cwi.crescer.lavanderia.service.MaterialService;
import br.com.cwi.crescer.lavanderia.service.PedidoService;
import br.com.cwi.crescer.lavanderia.service.ProdutoService;
import br.com.cwi.crescer.lavanderia.service.ServicoService;

@Controller
@RequestMapping("/itens")
public class ItemController {

	private ItemService itemService;
	private MaterialService materialService;
	private ServicoService servicoService;
	private PedidoService pedidoService;
	
	@Autowired
	public ItemController(ItemService itemService,
						MaterialService materialService,
						PedidoService pedidoService,
						ServicoService servicoService){
		this.itemService = itemService;
		this.materialService = materialService;
		this.pedidoService = pedidoService;
		this.servicoService = servicoService;
	}
	
	@RequestMapping(path = "/incluir", method = RequestMethod.GET)
    public ModelAndView incluir(ItemDTO item){
        return new ModelAndView("item/incluir","item",item);
    }
	
	
 


	
	@RequestMapping(path = "/manter", method = RequestMethod.POST)
    public ModelAndView manter(@Valid @ModelAttribute("item")ItemDTO itemDTO,
    							BindingResult result,
    							final RedirectAttributes redirectAttributes) {
		
		if (result.hasErrors()) {
		    return new ModelAndView("itens/manter");
		}
		
		Item incluido = itemService.incluirItem(itemDTO);	
		if(incluido != null){
			redirectAttributes.addFlashAttribute("menssagemFlash", "incluiu Com Sucesso");
		}else{
			redirectAttributes.addFlashAttribute("menssagemFlash", "não foi possivel incluir");
		}
		
		Pedido pedidoAtualizado = pedidoService.atualizarComItem(incluido);
		
		ItemDTO outroItem = new ItemDTO();
		outroItem.setIdPedido(pedidoAtualizado.getIdPedido());
        return new ModelAndView("item/manter","item",outroItem);
    }
	
	 @ModelAttribute("materiais")
	 public List<Material> comboMateriais() {
	     return materialService.listar();
	 }
	    
	 @ModelAttribute("servicos")
	 public List<Servico> comboServicos() {
	     return servicoService.listar();
	 }
}
