package br.com.cwi.crescer.lavanderia.controller;

import java.util.List;

import javax.validation.Valid;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.lavanderia.DTO.ItemDTO;
import br.com.cwi.crescer.lavanderia.DTO.ProdutoDTOCombos;
import br.com.cwi.crescer.lavanderia.domain.Item;
import br.com.cwi.crescer.lavanderia.domain.Material;
import br.com.cwi.crescer.lavanderia.domain.Pedido;
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
    private ProdutoService produtoService;

    @Autowired
    public ItemController(ItemService itemService,
            MaterialService materialService,
            PedidoService pedidoService,
            ServicoService servicoService,
            ProdutoService produtoService) {
        this.itemService = itemService;
        this.materialService = materialService;
        this.pedidoService = pedidoService;
        this.servicoService = servicoService;
        this.produtoService = produtoService;
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

    @ResponseBody
    @RequestMapping(path = "/rest/{id}")
    public String buscarServicos(@PathVariable("id") Long id) {
        JSONArray produtoArray = new JSONArray();
        for (ProdutoDTOCombos produtoDTOCombos : produtoService.listPorServico(id)) {
            JSONObject objJSON = new JSONObject();
            objJSON.put("idMaterial", produtoDTOCombos.getIdMaterial());
            objJSON.put("materialDescricao", produtoDTOCombos.getDescricaoMaterial());
            produtoArray.put(objJSON);
        }
        return produtoArray.toString();
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
