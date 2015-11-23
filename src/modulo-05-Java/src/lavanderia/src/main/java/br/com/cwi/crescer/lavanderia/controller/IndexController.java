package br.com.cwi.crescer.lavanderia.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cwi.crescer.lavanderia.service.ItemService;


@Controller
public class IndexController {

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
        String valorString = "";
        BigDecimal valor = itemService.buscarValorUnitario(1L);
        if (valor != null) {
            valorString = valor.toString();
        }

        model.addAttribute("mensagem", valorString);

        return "testes";
    }

}
