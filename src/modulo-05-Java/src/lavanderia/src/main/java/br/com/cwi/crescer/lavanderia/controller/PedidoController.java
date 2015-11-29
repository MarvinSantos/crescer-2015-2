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
import br.com.cwi.crescer.lavanderia.DTO.PedidoDTO;
import br.com.cwi.crescer.lavanderia.DTO.PedidoResumoDTO;
import br.com.cwi.crescer.lavanderia.domain.Cliente;
import br.com.cwi.crescer.lavanderia.domain.Material;
import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.domain.Servico;
import br.com.cwi.crescer.lavanderia.service.ClienteService;
import br.com.cwi.crescer.lavanderia.service.MaterialService;
import br.com.cwi.crescer.lavanderia.service.PedidoService;
import br.com.cwi.crescer.lavanderia.service.ServicoService;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

	private PedidoService pedidoService;
	private ClienteService clienteService;
	private MaterialService materialService;
	private ServicoService servicoService;
	
	@Autowired
	public PedidoController(PedidoService pedidoService,
			ClienteService clienteService,
			MaterialService materialService,
			ServicoService servicoService){
		
		this.pedidoService = pedidoService;
		this.clienteService = clienteService;
		this.materialService =  materialService;
		this.servicoService =  servicoService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar() {

        return new ModelAndView("pedido/lista", "pedidos", pedidoService.listarPedidosListaDTO());

    }
	
	
	
	@RequestMapping(path = "/incluir",method = RequestMethod.GET )
    public ModelAndView viewInlcuir(PedidoResumoDTO pedido) {
        return new ModelAndView("pedido/escolheCliente", "pedido", new PedidoResumoDTO());
    }



    @RequestMapping(path = "/incluir", method = RequestMethod.POST)
    public ModelAndView incluir(@Valid @ModelAttribute("pedido")PedidoResumoDTO pedidoResumo,
            BindingResult result,
            final RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return new ModelAndView("pedido/incluir");
        }

        Pedido pedido = pedidoService.incluirInicial(pedidoResumo);
        redirectAttributes.addFlashAttribute("menssagemFlash", "agora você pode adicionar itens a esse pedido");
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setIdPedido(pedido.getIdPedido());
        return new ModelAndView("item/manter","item",itemDTO);
    }

    
    @ModelAttribute("clientes")
    public List<Cliente> comboClientes() {
        return clienteService.listar();
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
