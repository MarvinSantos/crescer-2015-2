using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Locadora.Dominio;
using System.Xml.Linq;

namespace Locadora.UI
{
    class Program
    {
        public const int CADASTRARJOGO = 1;
        public const int PESQUISAPORNOME = 2;
        public const int EDITARJOGO = 3;
        public const int EXPORTARRELATORIO = 4;
        public const int SAIR = 5;
        public const bool RODANDO = true;
        public static Menu menuPrincipal = new Menu();
        public static BaseDeDados dbXml = new BaseDeDados();

        static void Main(string[] args)
        {

            int indice = 5;

            while (RODANDO)
            {
                DesenharMenuNaTela();
                
                try
                {
                    indice = Convert.ToInt32(Console.ReadLine());
                }
                catch (FormatException)
                {
                    Console.WriteLine("Você deve digitar um Numero Inteiro entre 1-5");
                }

                if(indice == CADASTRARJOGO)
                {
                    CadastrarNovoJogo();
                }
                else if(indice == PESQUISAPORNOME)
                {
                    pesquisarJogoPorNome();
                }
                else if(indice == EDITARJOGO)
                {

                }
                   

            }
            

        }

        public static void DesenharMenuNaTela()
        {
            menuPrincipal.MostrarTela();
        }


        public static void pesquisarJogoPorNome()
        {
            string nomeJogo = " ";
            menuPrincipal.PedirNomeDoJogo();
            nomeJogo = Console.ReadLine();
            try
            {
                
                menuPrincipal.MostrarInformacoesDoJogoNaTela(nomeJogo);
            }
            catch (Exception)
            {
                Console.WriteLine("Voce Deve Digitar Um nome Valido, Em Duvida verifique como está escrito o nome deste jogo na base");
            }
            
            
        }

        public static void CadastrarNovoJogo()
        {
            string nomeJogo = " ";
            double preco = 0.0;
            string categoria = " ";
            int id;
            bool primeiroLoop = true;
           

            menuPrincipal.PedirNomeDoJogo();
            nomeJogo = Console.ReadLine();

            
            while (primeiroLoop)
            {

                menuPrincipal.PedirPreco();
                try
                {
                    preco = Convert.ToDouble(Console.ReadLine());
                    primeiroLoop = false;
                }
                catch (FormatException)
                {
                    primeiroLoop = true;
                    Console.WriteLine("Você deve digitar um valor numerico. EX: 12.95");
                }

            }
            
            menuPrincipal.PedirCategoria();
            categoria = Console.ReadLine();
            id = dbXml.nextID();

            dbXml.cadastrarJogo(nomeJogo,id,categoria,preco);


        }
    }
}
