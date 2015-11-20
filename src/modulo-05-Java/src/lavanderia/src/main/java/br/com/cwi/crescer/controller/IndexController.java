package br.com.cwi.crescer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping(name = "/")
    public String index(Model model) {

        String bemVindo = "Bem vindo à lavanderia crescer";

        model.addAttribute("mensagem", bemVindo);

        return "index";
    }
}
