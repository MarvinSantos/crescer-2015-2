package br.com.cwi.crescer.lavanderia.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.lavanderia.DTO.ClienteDTO;
import br.com.cwi.crescer.lavanderia.DTO.ProdutoDTO;
import br.com.cwi.crescer.lavanderia.DTO.ProdutoEditarDTO;
import br.com.cwi.crescer.lavanderia.domain.Cliente.SituacaoCliente;
import br.com.cwi.crescer.lavanderia.domain.Material;
import br.com.cwi.crescer.lavanderia.domain.Produto.SituacaoProduto;
import br.com.cwi.crescer.lavanderia.domain.Servico;
import br.com.cwi.crescer.lavanderia.service.MaterialService;
import br.com.cwi.crescer.lavanderia.service.ProdutoService;
import br.com.cwi.crescer.lavanderia.service.ServicoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

	private MaterialService materialService;
    private ServicoService servicoService;
    private ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService,MaterialService materialService, ServicoService servicoService) {
        this.produtoService = produtoService;
    	this.materialService = materialService;
        this.servicoService = servicoService;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar() {

        return new ModelAndView("produto/lista", "produtos", produtoService.listarProdutos());

    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(path = "/incluir",method = RequestMethod.GET )
    public ModelAndView viewInlcuir(ProdutoDTO produto) {
        return new ModelAndView("produto/incluir", "produto", new ProdutoDTO());
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(path = "/incluir", method = RequestMethod.POST)
    public ModelAndView incluir(@Valid @ModelAttribute("produto")ProdutoDTO produto,
            BindingResult result,
            final RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return new ModelAndView("produto/incluir");
        }

        produtoService.incluir(produto);
        redirectAttributes.addFlashAttribute("menssagemFlash", "Adicionado Com Sucesso");
        return new ModelAndView("redirect:/produtos");
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(path = "/editar/{id}", method = RequestMethod.GET)
    public ModelAndView edita(@PathVariable("id") Long id) {
        return new ModelAndView("produto/editar", "produto", produtoService.buscarPorId(id));
    }



    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(path = "/editar", method = RequestMethod.POST)
    public ModelAndView editarSalvando(@Valid @ModelAttribute("produto")ProdutoEditarDTO produto,
            BindingResult result,
            final RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return new ModelAndView("produto/editar");
        }

        produtoService.atualizar(produto);
        redirectAttributes.addFlashAttribute("menssagemFlash", "Editado Com Sucesso");
        return new ModelAndView("redirect:/produtos");
    }
    
    @ModelAttribute("materiais")
    public List<Material> comboMateriais() {
        return materialService.listar();
    }
    
    @ModelAttribute("servicos")
    public List<Servico> comboServicos() {
        return servicoService.listar();
    }
    
    @ModelAttribute("situacoes")
    public List<SituacaoProduto> comboSituacoes() {
        return produtoService.listarSituacoes();
    }
    
}
