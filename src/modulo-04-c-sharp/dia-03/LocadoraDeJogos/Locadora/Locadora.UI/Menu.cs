using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;
using Locadora.Dominio;

namespace Locadora.UI
{
    class Menu
    {
        public void MostrarTela()
        {
            Console.WriteLine(" 1- Cadastrar Um novo jogo \r\n 2- Realizar pesquisa de jogos por nome \r\n 3- Editar um jogo \r\n 4-Exportar relatorio de jogos em TXT \r\n 5- Sair");
        }

        public void PedirNomeDoJogo()
        {
            Console.WriteLine("Digite o nome Do Jogo");
                    
        }

        public void PedirPreco()
        {
            Console.WriteLine("Digite o preço que este jogo terá");
        }

        public void PedirCategoria()
        {
            Console.WriteLine("Digite a categoria do jogo");
        }


        public void MostrarInformacoesDoJogoNaTela(string nomeJogo)
        {
            BaseDeDados dbXml = new BaseDeDados();
            Jogo jogo = dbXml.GetJogo(nomeJogo);
            string informacoesDoJogo = jogo.ToString();
            Console.WriteLine(informacoesDoJogo);
            
        }

        public void PerguntarSeQuerMudarOId()
        {
            Console.WriteLine("Você quer mudar o id do jogo? \r\n 1- SIM \r\n 2- NAO ");
        }

        public void PedirId()
        {
            Console.WriteLine("Digite o ID: ");
        }

        
    }
}
