using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Seguranca.Models
{
    public class UsuarioLogado
    {
        public string Email { get; private set; }

        public string[] Permissoes { get; private set; }

        public UsuarioLogado(string email, string[] permissoes)
        {
            this.Email = email;
            this.Permissoes = permissoes;
        }
    }
}