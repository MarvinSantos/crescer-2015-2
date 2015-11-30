package br.com.cwi.crescer.lavanderia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.lavanderia.DTO.PedidoVisualizarDTO;
import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.service.ClienteService;
import br.com.cwi.crescer.lavanderia.service.MaterialService;
import br.com.cwi.crescer.lavanderia.service.PedidoService;
import br.com.cwi.crescer.lavanderia.service.ServicoService;

@Controller
@RequestMapping("/pedido/status")
public class PedidoStatusController {
	
	private PedidoService pedidoService;
	private MaterialService materialService;
	private ServicoService servicoService;
	
	@Autowired
	public PedidoStatusController(PedidoService pedidoService,
			MaterialService materialService,
			ServicoService servicoService){
		
		this.pedidoService = pedidoService;
		this.materialService =  materialService;
		this.servicoService =  servicoService;
	}
	
	@RequestMapping(path = "/finalizar/{id}", method = RequestMethod.GET)
	public ModelAndView processando(@PathVariable("id") Long id,final RedirectAttributes redirectAttributes){
		
		Pedido pedido = pedidoService.mudarStatusParaProcessando(id);
		if(pedido != null){
			redirectAttributes.addFlashAttribute("menssagemFlash", "Secesso! Agora o pedido esta processando");
		}else{
			
		}
		
		return new ModelAndView("pedido/lista", "pedidos", pedidoService.listarPedidosListaDTO());
	}
	

	@RequestMapping(path = "/cancelar/{id}", method = RequestMethod.GET)
	public ModelAndView cancelar(@PathVariable("id") Long id,final RedirectAttributes redirectAttributes){
		
		Pedido pedido = pedidoService.cancelar(id);
		if(pedido != null){
			redirectAttributes.addFlashAttribute("menssagemFlash", "Cancelado com sucesso");
		}else{
			
		}
		
		return new ModelAndView("pedido/lista", "pedidos", pedidoService.listarPedidosListaDTO());
	}
	
	
	@RequestMapping(path = "/encerrar/{id}", method = RequestMethod.GET)
	public ModelAndView encerrar(@PathVariable("id") Long id,final RedirectAttributes redirectAttributes){
		
		Pedido pedido = pedidoService.encerrar(id);
		if(pedido != null){
			redirectAttributes.addFlashAttribute("menssagemFlash", "Encerrado com sucesso");
		}else{
			redirectAttributes.addFlashAttribute("menssagemFlash", "O pedido não está processado ainda ou ja foi encerrado, para processar os itens do pedido clicar em visualizar/processar itens");
			return new ModelAndView("redirect:/pedidos");
		}
		
		return new ModelAndView("pedido/visualizar", "pedido",pedidoService.visualizarPedidoDTO(id));
	}
	
	@RequestMapping(path = "/processar/{id}", method = RequestMethod.GET)
	public ModelAndView processar(@PathVariable("id") Long id){
		
		return new ModelAndView("pedido/processar", "pedido", pedidoService.visualizarPedidoDTO(id));
	}
	
	
	@RequestMapping(path = "/processar", method = RequestMethod.POST)
	public ModelAndView processar(@ModelAttribute("pedido")PedidoVisualizarDTO pedido,
									final RedirectAttributes redirectAttributes){
		
		boolean processou = pedidoService.processarPedido(pedido.getIdPedido());
		if(processou){
			redirectAttributes.addFlashAttribute("menssagemFlash", "Processado Com Sucesso");
		}else{
			redirectAttributes.addFlashAttribute("menssagemFlash", "O pedido não pôde ser processado :)");
		}
		
		return new ModelAndView("pedido/lista", "pedidos", pedidoService.listarPedidosListaDTO());
	}
	
	
		
}
