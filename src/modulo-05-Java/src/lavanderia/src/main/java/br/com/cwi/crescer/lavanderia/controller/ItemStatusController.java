package br.com.cwi.crescer.lavanderia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.lavanderia.domain.Item;
import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.service.ItemService;
import br.com.cwi.crescer.lavanderia.service.PedidoService;

@Controller
@RequestMapping("/item/status")
public class ItemStatusController {

	private ItemService itemService;
	private PedidoService pedidoService;
	
	@Autowired
	public ItemStatusController(ItemService itemService, PedidoService pedidoService){
		this.itemService = itemService;
		this.pedidoService = pedidoService;
	}
	
	@RequestMapping(path = "/processar/{id}",method = RequestMethod.GET)
	public ModelAndView processar(@PathVariable("id") Long id, final RedirectAttributes redirectAttributes){
		Item item = itemService.processarItem(id);
		Long idPedido = item.getPedido().getIdPedido();
		Pedido pedido = pedidoService.verificarSituacaoItensEAtualizar(idPedido);
			
		if(pedido != null){
			redirectAttributes.addFlashAttribute("menssagemFlash", "Todos os itens foram processados, o pedido Foi processado");
			return new ModelAndView("redirect:/pedidos");
		}
		
		redirectAttributes.addFlashAttribute("menssagemFlash", "o pedido foi processado");
		return new ModelAndView("pedido/visualizar", "pedido", pedidoService.visualizarPedidoDTO(idPedido));
	}
}
