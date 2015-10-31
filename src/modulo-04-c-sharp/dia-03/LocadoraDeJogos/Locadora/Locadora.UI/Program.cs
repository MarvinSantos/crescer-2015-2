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
        

        public static void Main(string[] args)
        {
            BaseDeDados dbXml = new BaseDeDados();
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
                        menuPrincipal.PedirNomeDoJogoASerAlterado();
                        string jogoParaAlterar = Console.ReadLine();
                        if(jogoParaAlterar != "")
                        {
                            try
                            {
                                dbXml.GetJogo(jogoParaAlterar);
                                EditarJogo(jogoParaAlterar);
                                loopEditarJogo = false;
                            }
                            catch (Exception)
                            {

                                menuPrincipal.ExceptionJogoNaoExistenteNaBase();
                            }
                            

                        }
                        else
                        {
                            menuPrincipal.ExceptionDigitarNome();
                        }

                    }


                }
                else if (indice == EXPORTARRELATORIO)
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
            BaseDeDados dbXml = new BaseDeDados();

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
                    menuPrincipal.ExceptionJogoNaoExistenteNaBase();
                }
            }
            
            
            
        }

        public static void CadastrarNovoJogo()
        {
            BaseDeDados dbXml = new BaseDeDados();

            string nomeJogo = "";
            double preco = 0.0;
            string categoria = "";
            string status = "";
            int id;
            bool primeiroLoop = true;
            bool rodando = true;
            bool loopCategoria = true;
            bool loopStatus = true;

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
                            menuPrincipal.PedirParaDigitarValorDouble();
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
                            menuPrincipal.ExceptionDigitarCategoria();
                        }

                    }

                    while (loopStatus)
                    {
                        menuPrincipal.PedirStatus();
                        status = Console.ReadLine();
                        
                        if(status.ToLower() == "disponivel" || status.ToLower() == "locado")
                        {
                            loopStatus = false;
                        }
                        else
                        {
                            menuPrincipal.ExceptionStatus();
                        }           

                    }
                        
                    id = dbXml.nextID();
                    Jogo jogo = new Jogo(nomeJogo, categoria, preco, id,  status);
                    dbXml.cadastrarJogo(jogo);
                }
                else
                {
                    menuPrincipal.ExceptionDigitarNome();
                }
           
            }

        }

        public static void EditarJogo(string jogoASerAlterado)
        {
            BaseDeDados dbXml = new BaseDeDados();

            bool rodando = true;
            string novoNome = "";
            double preco = 0.0;
            string categoria = "";
            string status = "";
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
                        menuPrincipal.PedirParaDigitarValorDouble();
                    }               

                }

                rodando = true;
                
                while (rodando)
                {
                    menuPrincipal.PerguntarSeQuerMudarOId();
                    try
                    {          
                               
                        respostaSeQuerMudarID = Convert.ToInt32(Console.ReadLine());
                        if(respostaSeQuerMudarID == 1 || respostaSeQuerMudarID == 2)
                        {
                            rodando = false;
                        }
                        else
                        {
                            throw new FormatException();
                        }

                    }
                    catch (FormatException)
                    {
                        menuPrincipal.ExcepitionSeQuermudarID();
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
                    else
                    {

                    }
                }

                rodando = true;
                while (rodando)
                {
                    menuPrincipal.PedirStatus();
                    status = Console.ReadLine();

                    if (status.ToLower() == "disponivel" || status.ToLower() == "locado")
                    {
                        rodando = false;
                    }
                    else
                    {
                        menuPrincipal.ExceptionStatus();
                    }

                }


                Jogo jogo = new Jogo(novoNome, categoria, preco, id,status);

                dbXml.AlterarCamposDoJogo(jogo, jogoASerAlterado);
            }
        }

        public static void ExportarRelatorio()
        {

        }
    }
}
