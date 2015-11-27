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

import br.com.cwi.crescer.lavanderia.DTO.UserDTO;
import br.com.cwi.crescer.lavanderia.domain.Authorities;
import br.com.cwi.crescer.lavanderia.service.AuthoritiesService;
import br.com.cwi.crescer.lavanderia.service.UserService;

@Controller
@RequestMapping("/users")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class UserController {


    private UserService userService;
    private AuthoritiesService authoritiesService;


    @Autowired
    public UserController(UserService userService, AuthoritiesService authoritiesService) {
        this.userService = userService;
        this.authoritiesService = authoritiesService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar() {

        return new ModelAndView("user/lista", "users", userService.listarUsersAtivos());

    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ModelAndView exibe(@PathVariable("id") String id) {

        return new ModelAndView("user/exibe", "user", userService.buscarPorId(id));
    }



    @RequestMapping(path = "/editar/{id}", method = RequestMethod.GET)
    public ModelAndView edita(@PathVariable("id") String id) {
        return new ModelAndView("user/editar", "user", userService.buscarPorId(id));
    }




    @RequestMapping(path = "/editar", method = RequestMethod.POST)
    public ModelAndView editarSalvando(@Valid @ModelAttribute("user")UserDTO user,
            BindingResult result,
            final RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return new ModelAndView("user/editar");
        }

        userService.atualizar(user);
        redirectAttributes.addFlashAttribute("menssagemFlash", "Editado Com Sucesso");
        return new ModelAndView("redirect:/users");
    }



    @RequestMapping(path = "/incluir",method = RequestMethod.GET )
    public ModelAndView viewInlcuir(UserDTO user) {
        return new ModelAndView("user/incluir", "user", new UserDTO());
    }



    @RequestMapping(path = "/incluir", method = RequestMethod.POST)
    public ModelAndView incluir(@Valid @ModelAttribute("user")UserDTO user,
            BindingResult result,
            final RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return new ModelAndView("user/incluir");
        }

        userService.incluir(user);
        redirectAttributes.addFlashAttribute("menssagemFlash", "Adicionado Com Sucesso");
        return new ModelAndView("redirect:/users");
    }



    @RequestMapping(path = "/remover/{id}", method = RequestMethod.GET)
    public ModelAndView removerView(@PathVariable("id") String id) {
        return new ModelAndView("user/remover", "user", userService.buscarPorId(id) );
    }




    @RequestMapping(path = "/remover", method = RequestMethod.POST)
    public ModelAndView remover(UserDTO user,
            final RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute("menssagemFlash", "Inativado Com Sucesso");
        userService.remover(user);
        return new ModelAndView("redirect:/users");
    }

    @ModelAttribute("permissoes")
    public List<Authorities> comboAuthorities() {
        return authoritiesService.listar();
    }

}
