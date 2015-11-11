﻿using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Seguranca.Models;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Security;
using Locadora.Repositorio.EF.Repositorios;
using Locadora.Dominio.Servicos;
using Locadora.Dominio;

namespace Locadora.Web.MVC.Controllers
{
    public class LoginController : Controller
    {

        public ActionResult Index(LoginModel model)
        {
            return View(model);
        }

        [ValidateAntiForgeryToken]
        [HttpPost]
        public ActionResult Login(LoginModel model)
        {
            if (ModelState.IsValid)
            {
                IUsuarioRepositorio repositorioUsuario = new UsuarioRepositorio();
                ServicoAutenticacaoUsuario servicoAutenticacao = new ServicoAutenticacaoUsuario(repositorioUsuario);

                Usuario usuarioAutenticado = servicoAutenticacao.AutenticarEBuscar(model.Email, model.Senha);

                if (usuarioAutenticado != null)
                {

                    ControladorDeSessao.CriarSessaoUsuario(usuarioAutenticado);

                    return RedirectToAction("Index", "Home",model);

                }
                else
                {
                    ModelState.AddModelError("ERRO_LOGIN", "Algum dos campos não está correto, arrume.");
                    return RedirectToAction("Index", model);
                }

            }
            else
            {
                ModelState.AddModelError("ERRO_LOGIN", "Algum dos campos não está correto, arrume.");
                return RedirectToAction("Index", model);
            }

        }

        public ActionResult LogOut()
        {
            ControladorDeSessao.LogOut();
            return RedirectToAction("Index", "Login");
        }
    }
}