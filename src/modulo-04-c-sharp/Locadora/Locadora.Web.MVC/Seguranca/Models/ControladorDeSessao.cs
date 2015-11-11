using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Security;

namespace Locadora.Web.MVC.Seguranca.Models
{
    public class ControladorDeSessao
    {

        public static UsuarioLogado UsuarioLogado
        {
            get
            {
                return HttpContext.Current.Session["USUARIO_LOGADO"] as UsuarioLogado;
            }
        }

        public static void CriarSessaoUsuario(Usuario usuarioAutenticado)
        {
            string[] permicoes = usuarioAutenticado.Permissoes.Select(perm => perm.Nome).ToArray();
            var usuarioLogadoModel = new UsuarioLogado(usuarioAutenticado.Email, permicoes);

            FormsAuthentication.SetAuthCookie(usuarioAutenticado.Email, true);
            HttpContext.Current.Session["USUARIO_LOGADO"] = usuarioLogadoModel;
        }

        public static void LogOut()
        {
            FormsAuthentication.SignOut();
            HttpContext.Current.Session.Abandon();
        }

    }
}