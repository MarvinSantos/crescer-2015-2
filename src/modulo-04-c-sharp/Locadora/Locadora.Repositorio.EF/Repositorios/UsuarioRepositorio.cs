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

        public int Atualizar(Usuario user)
        {
            using (BancoDeDados db = new BancoDeDados())
            {
                db.Entry(user).State = System.Data.Entity.EntityState.Modified;
                return db.SaveChanges();

            }
        }


        public IList<Usuario> BuscarTodos()
        {
            using (BancoDeDados db = new BancoDeDados())
            {
                return db.Usuario.ToList();
            }

        }

        public int Criar(Usuario user)
        {
            using (BancoDeDados db = new BancoDeDados())
            {
                db.Entry(user).State = System.Data.Entity.EntityState.Added;
                return db.SaveChanges();
            }

        }

        public int Excluir(string email)
        {
            Usuario user = new Usuario()
            {
                Email = email
            };

            using (BancoDeDados db = new BancoDeDados())
            {
                db.Entry(user).State = System.Data.Entity.EntityState.Deleted;
                return db.SaveChanges();
            }

        }
    }
}
