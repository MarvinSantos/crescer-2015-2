package br.com.cwi.crescer.lavanderia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.lavanderia.DTO.ClienteDTO;
import br.com.cwi.crescer.lavanderia.domain.Cidade;
import br.com.cwi.crescer.lavanderia.service.CidadeService;
import br.com.cwi.crescer.lavanderia.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteService clienteService;
    private CidadeService cidadeService;

    @Autowired
    public ClienteController(ClienteService clienteService, CidadeService cidadeService) {
        this.clienteService = clienteService;
        this.cidadeService = cidadeService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar() {

        return new ModelAndView("cliente/lista", "clientes", clienteService.listarClientesAtivos());

    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ModelAndView exibe(@PathVariable("id") Long id) {

        return new ModelAndView("cliente/exibe", "cliente", clienteService.buscarClientePorId(id));
    }

    @RequestMapping(path = "/editar/{id}", method = RequestMethod.GET)
    public ModelAndView edita(@PathVariable("id") Long id) {
        return new ModelAndView("cliente/editar", "cliente", clienteService.buscarClientePorId(id));
    }
    
    @RequestMapping(path = "/editar", method = RequestMethod.POST)
    public ModelAndView editarSalvando(ClienteDTO cliente) {
    	clienteService.atualizar(cliente);
        return new ModelAndView("redirect:/clientes");
    }
    
    @RequestMapping(path = "/incluir",method = RequestMethod.GET )
    public ModelAndView viewInlcuir(ClienteDTO cliente) {
        return new ModelAndView("cliente/incluir", "cliente", new ClienteDTO());
    }
    
    @RequestMapping(path = "/incluir", method = RequestMethod.POST)
    public ModelAndView incluir(ClienteDTO cliente) {
    	clienteService.incluir(cliente);
        return new ModelAndView("redirect:/clientes");
    }
    
    @RequestMapping(path = "/remover/{id}", method = RequestMethod.GET)
    public ModelAndView removerView(@PathVariable("id") Long id) {
    	return new ModelAndView("cliente/remover", "cliente", clienteService.buscarClientePorId(id) );
    }
    
    @RequestMapping(path = "/remover", method = RequestMethod.POST)
    public ModelAndView remover(ClienteDTO cliente) {
    	clienteService.remover(cliente);
        return new ModelAndView("redirect:/clientes");
    }

    @ModelAttribute("cidades")
    public List<Cidade> comboCidades() {
        return cidadeService.listar();
    }

}
