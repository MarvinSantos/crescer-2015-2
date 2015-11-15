using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Helpers;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public class ClienteController : Controller
    {
        public JsonResult Autocomplete(string term)
        {
            IClienteRepositorio repositorio = FabricaDeModulos.CriarClienteRepositorio();

            return Json(repositorio.BuscarPorNome(term).Select(j => new { label = j.Nome, value = j.Nome }), JsonRequestBehavior.AllowGet);
        }
    }
}