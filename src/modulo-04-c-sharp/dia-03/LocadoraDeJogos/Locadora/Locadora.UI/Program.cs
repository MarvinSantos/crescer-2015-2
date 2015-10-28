using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Locadora.Dominio;


namespace Locadora.UI
{
    class Program
    {
        
        public const bool RODANDO = true;

        static void Main(string[] args)
        {
            Tela telaDoJogo = new Tela();
            BaseDeDados dbXml = new BaseDeDados();

            while (RODANDO)
            {
                telaDoJogo.mostrarTela();
                try
                {
                    var indice = Convert.ToInt32(Console.ReadLine());
                }
                catch (FormatException)
                {
                    Console.WriteLine("Você deve digitar um Numero Inteiro entre 1-6");
                }
                   

            }
            

        }
    }
}
