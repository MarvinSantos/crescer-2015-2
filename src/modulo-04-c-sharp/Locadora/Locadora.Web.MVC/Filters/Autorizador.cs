using Locadora.Web.MVC.Seguranca.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Principal;
using System.Threading;
using System.Web;
using System.Web.Mvc;
using System.Web.Routing;

namespace Locadora.Web.MVC.Filters
{
    public class Autorizador : AuthorizeAttribute
    {
        public override void OnAuthorization(AuthorizationContext filterContext)
        {
            UsuarioLogado usuarioLogado = filterContext.HttpContext.Session["USUARIO_LOGADO"] as UsuarioLogado;
            bool usuarioEstaLogado = usuarioLogado != null;

            if (usuarioEstaLogado)
            {
                var identidade = new GenericIdentity(usuarioLogado.Email);
                string[] roles = usuarioLogado.Permissoes;

                var principal = new GenericPrincipal(identidade, roles);

                Thread.CurrentPrincipal = principal;
                HttpContext.Current.User = principal;

                base.OnAuthorization(filterContext);
            }
            else
            {
                RedirecionarParaPaginaLogin(filterContext);
            }

            
        }


        private void RedirecionarParaPaginaLogin(AuthorizationContext filterContext)
        {
            filterContext.Result = new RedirectToRouteResult(new RouteValueDictionary
                                                             {
                                                                 {"action","Index"},
                                                                 {"controller","Login"}
                                                              });
        }
    }
}