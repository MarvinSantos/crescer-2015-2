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
        public const int SIM = 1;
        public const int NAO = 2;

        public static Menu menuPrincipal = new Menu();
        public static BaseDeDados dbXml = new BaseDeDados();

        static void Main(string[] args)
        {

            int indice = 5;
            bool rodando = true;

            while (rodando)
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
                    bool loopEditarJogo = true;
                    while (loopEditarJogo)
                    {
                        Console.WriteLine("digite o nome do jogo que deseja alterar");
                        string jogoParaAlterar = Console.ReadLine();
                        if(jogoParaAlterar != "")
                        {
                            loopEditarJogo = false;
                            EditarJogo(jogoParaAlterar);

                        }
                        else
                        {
                            Console.WriteLine("Voce deve digitar o nome do jogo");
                        }

                    }


                }
                   

            }
            

        }

        public static void DesenharMenuNaTela()
        {
            menuPrincipal.MostrarTela();
        }


        public static void pesquisarJogoPorNome()
        {
            bool rodando = true;
            string nomeJogo = " ";
            while (rodando)
            {
                menuPrincipal.PedirNomeDoJogo();
                nomeJogo = Console.ReadLine();
                try
                {
                    menuPrincipal.MostrarInformacoesDoJogoNaTela(nomeJogo);
                    rodando = false;
                }
                catch (Exception)
                {
                    Console.WriteLine("Voce Deve Digitar Um nome Valido, Em Duvida verifique como está escrito o nome deste jogo na base");
                }
            }
            
            
            
        }

        public static void CadastrarNovoJogo()
        {
            string nomeJogo = "";
            double preco = 0.0;
            string categoria = "";
            int id;
            bool primeiroLoop = true;
            bool rodando = true;
            bool loopCategoria = true;

            while (rodando)
            {

                menuPrincipal.PedirNomeDoJogo();
                nomeJogo = Console.ReadLine();

                if (nomeJogo != "")
                {
                    rodando = false;
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

                    while (loopCategoria)
                    {
                        menuPrincipal.PedirCategoria();
                        categoria = Console.ReadLine();
                        if(categoria != "")
                        {
                            loopCategoria = false;
                        }
                        else
                        {
                            Console.WriteLine("voce deve digitar a categoria deste jogo, se não souber coloque 'outro' e edite mais tarde");
                        }

                    }
                        
                    id = dbXml.nextID();

                    dbXml.cadastrarJogo(nomeJogo, id, categoria, preco);
                }
                else
                {
                    Console.WriteLine("voce deve digitar um nome");
                }
           
            }

        }

        public static void EditarJogo(string jogoASerAlterado)
        {
            bool rodando = true;
            string novoNome = "";
            double preco = 0.0;
            string categoria = "";
            int id = dbXml.nextID();
            int respostaSeQuerMudarID = NAO;

            if (jogoASerAlterado != "")
            {

                while (rodando)
                {
                    menuPrincipal.PedirNomeDoJogo();
                    novoNome = Console.ReadLine();
                    if(novoNome != "")
                    {
                        rodando = false;
                    }
                }
                

                rodando = true;
                while (rodando)
                {

                    try
                    {
                        menuPrincipal.PedirPreco();
                        preco = Convert.ToDouble(Console.ReadLine());
                        rodando = false;
                    }
                    catch (FormatException)
                    {
                        Console.WriteLine("Você deve digitar um valor numerico. EX: 12.95");
                    }               

                }

                rodando = true;
                
                while (rodando)
                {
                    menuPrincipal.PerguntarSeQuerMudarOId();
                    try
                    {                 
                        respostaSeQuerMudarID = Convert.ToInt32(Console.ReadLine());
                        rodando = false;
                    }
                    catch (FormatException)
                    {
                        Console.WriteLine("Você deve digitar 1 para SIM e 2 Para NÃO");
                    }
                }

                rodando = true;

                if (respostaSeQuerMudarID == SIM)
                {
                    while (rodando)
                    {
                        menuPrincipal.PedirId();
                        try
                        {
                            id = Convert.ToInt32(Console.ReadLine());
                            rodando = false;
                        }
                        catch (FormatException)
                        {
                            Console.WriteLine("Você deve digitar um numero inteiro");
                        }
                    }

                }
                else
                {
                    id = dbXml.GetIdJogo(jogoASerAlterado);
                }

                rodando = true;
                while (rodando)
                {
                    menuPrincipal.PedirCategoria();
                    categoria = Console.ReadLine();
                    if (categoria != "")
                    {
                        rodando = false;
                    }
                }
       
                
                Jogo jogo = new Jogo(novoNome, categoria, preco, id);

                dbXml.AlterarCamposDoJogo(jogo, jogoASerAlterado);
            }
        }
    }
}
