using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Locadora.Dominio;

namespace Locadora.Repositorio.EF.Repositorios
{
    public class UsuarioRepositorio : IUsuarioRepositorio
    {
        public Usuario BuscarUsuarioPorEmail(string email)
        {
            Usuario usuario;
            using (var db = new BancoDeDados())
            {
                usuario = db.Usuario.Include("Permissoes").FirstOrDefault(user => user.Email == email);
                return usuario;
            }
        }
    }
}
