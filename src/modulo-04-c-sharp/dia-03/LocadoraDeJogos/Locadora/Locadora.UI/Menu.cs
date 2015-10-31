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

        public void PedirStatus()
        {
            Console.WriteLine("Informe o Status do Jogo: disponivel - locado");
        }

        public void MostrarInformacoesDoJogoNaTela(string nomeJogo)
        {
            BaseDeDados dbXml = new BaseDeDados();
            Jogo jogo;
            try
            {
                jogo = dbXml.GetJogo(nomeJogo);
            }
            catch (Exception)
            {

                throw;
            }
            
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

        public void ExcepitionSeQuermudarID()
        {
            Console.WriteLine("Você deve digitar 1 para SIM e 2 Para NÃO");
        }
        
        public void PedirParaDigitarValorDouble()
        {
            Console.WriteLine("Você deve digitar um valor numerico. EX: 12.95");
        }

        public void ExceptionDigitarCategoria()
        {
            Console.WriteLine("voce deve digitar a categoria deste jogo, se não souber coloque 'outro' e edite mais tarde");
        }

        public void ExceptionDigitarNome()
        {
            Console.WriteLine("voce deve digitar um nome");
        }

        public void ExceptionJogoNaoExistenteNaBase()
        {
            Console.WriteLine("Voce Deve Digitar Um nome Valido, Na Duvida verifique como está escrito o nome deste jogo na base");
        }

        public void PedirNomeDoJogoASerAlterado()
        {
            Console.WriteLine("digite o nome do jogo que deseja alterar");
        }

        public void ExceptionStatus()
        {
            Console.WriteLine("você deve informar o Status do Jogo");
        }
    }
}
