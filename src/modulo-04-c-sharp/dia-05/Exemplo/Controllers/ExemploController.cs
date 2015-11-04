using Exemplo.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Exemplo.Controllers
{
    public class ExemploController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult ExemploRetornandoDadosDoServidor()
        {
            var listaPersonagesFemininos = new List<string>()
            {
                "Bulma",
                "Nami",
                "Bob Esponja",
                "Barbie",
                "Patric"
            };

            return View(listaPersonagesFemininos);
        }

        public ActionResult Exemplo3()
        {
            var listaPersonagesFemininos = new List<string>()
            {
                "Bulma",
                "Nami",
                "Bob Esponja",
                "Barbie",
                "Patric"
            };

            return View("ExemploRetornandoDadosDoServidor", listaPersonagesFemininos);
        }

        public ActionResult PaginaComLayout()
        {
            ViewData["Mensagem"] = "Olá enfermeira com view data";
            //ViewBag.Mensagem = "Olá enfermeira";

            return View("Exemplo3");
        }

        public ActionResult ExemploComModel()
        {
            var listaPersonagens = new List<PersonagemModel>()
            {
                new PersonagemModel() { Nome = "Goku", Anime = "DBZ", Fodao = true },
                new PersonagemModel() { Nome = "Bob Esponja", Anime = "Bob Esponja", Fodao = false },
                new PersonagemModel() { Nome = "Nunes", Anime = "CWI", Fodao = true }
            };

            var model = new AnimeModel()
            {
                Personagens = listaPersonagens
            };

            return View(model);
        }
    }
}