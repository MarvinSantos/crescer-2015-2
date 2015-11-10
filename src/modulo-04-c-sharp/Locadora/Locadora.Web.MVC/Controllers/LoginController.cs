using Locadora.Web.MVC.Seguranca.Models;
using Locadora.Web.MVC.ViewModels;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Security;

namespace Locadora.Web.MVC.Controllers
{
    public class LoginController : Controller
    {

        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Login(LoginModel model)
        {

            if (model.Email == "didi" && model.Senha == "die")
            {
                var usuarioLogadoModel = new UsuarioLogado("didi", new string[] { "Jogo_Detalhado" });

                FormsAuthentication.SetAuthCookie(model.Email, true);
                Session["USUARIO_LOGADO"] = usuarioLogadoModel;

                return RedirectToAction("Index", "Home");
            }
            else
            {
                return RedirectToAction("Index",model);
            }     

        }
    }
}