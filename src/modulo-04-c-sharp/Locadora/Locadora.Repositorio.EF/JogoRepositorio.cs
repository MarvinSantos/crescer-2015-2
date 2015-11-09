using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Locadora.Dominio;
using System.Data.SqlClient;
using System.Data;


namespace Locadora.Repositorio.EF
{
    public class JogoRepositorio : IJogoRepositorio
    {
        

        public int Atualizar(Jogo entidade)
        {
            using (BancoDeDados db = new BancoDeDados())
            {                
                
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
            using (IDbConnection conexao = CriarConexao())
            {
            }
        }

        public IList<Jogo> BuscarTodos()
        {
            using (IDbConnection conexao = CriarConexao())
            {
               
            }
        }

        public int Criar(Jogo entidade)
        {
            using (IDbConnection conexao = CriarConexao())
            {
               
            }
        }

        public int Excluir(int id)
        {
            using (IDbConnection conexao = CriarConexao())
            {
            }
        }


    }
}
