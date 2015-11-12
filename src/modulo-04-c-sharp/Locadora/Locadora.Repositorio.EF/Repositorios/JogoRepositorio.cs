using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;

using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.EF
{
    public class JogoRepositorio : IJogoRepositorio
    {


        public int Atualizar(Jogo entidade)
        {
            using (BancoDeDados db = new BancoDeDados())
            {
                db.Entry(entidade).State = System.Data.Entity.EntityState.Modified;
                return db.SaveChanges();

            }
        }

        public Jogo BuscarPorId(int id)
        {
            using (BancoDeDados db = new BancoDeDados())
            {
                Jogo jogo = db.Jogo.Find(id);
                return jogo;
            }
        }

        public IList<Jogo> BuscarPorNome(string nome)
        {
            using (BancoDeDados db = new BancoDeDados())
            {
                return db.Jogo.Where(jogo => jogo.Nome.Contains(nome)).ToList();
            }
            
        }

        public IList<Jogo> BuscarTodos()
        {
            using (BancoDeDados db = new BancoDeDados())
            {
                return db.Jogo.Include("clienteLocacao").Select(j => j).ToList();
            }
            
        }

        public int Criar(Jogo entidade)
        {
            using (BancoDeDados db = new BancoDeDados())
            {
                db.Entry(entidade).State = System.Data.Entity.EntityState.Added;
                return db.SaveChanges();
            }
            
        }

        public int Excluir(int id)
        {
            Jogo entidade = new Jogo(id);

            using (BancoDeDados db = new BancoDeDados())
            {
                db.Entry(entidade).State = System.Data.Entity.EntityState.Deleted;
                return db.SaveChanges();
            }
            
        }

        public int BuscarNumeroDeJogosLocados(Cliente cliente)
        {
            using (var db = new BancoDeDados())
            {
                return db.Jogo.Count(j => j.ClienteLocacao.Id == cliente.Id);
            }
        }

    }
}
