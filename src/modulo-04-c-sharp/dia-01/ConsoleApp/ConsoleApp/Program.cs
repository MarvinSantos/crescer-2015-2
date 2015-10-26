using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp
{
    class Program
    {
        static void Main(string[] args)
        {
            var agenda = new Agenda();
            Console.WriteLine(" 1 - ADD um contato \n 2 - Remover um contato por nome \n 3 - Remover um contato por numero \n 4 - Listar contatos \n 5 - Ordenar contatos Por Nome A>Z");
            
            var indice = Convert.ToInt32(Console.ReadLine());
            switch (indice)
            {
                case 1:              
                    Console.Clear();
                    Console.WriteLine("Digite O Nome:");
                    var nome = Console.ReadLine();
                    Console.WriteLine("Digite O Numero:");
                    var numero = Convert.ToInt32(Console.ReadLine());
                    Contato contato = new Contato(nome, numero);
                    agenda.AdcionarContato(contato);

                    break;
                    
                case 2:

                case 3:

                case 4:

                case 5:
                    break;                    

                    
            }
        }

        public static void EscreverContatosNaTela(Agenda agenda)
        {
            string listaDeContatos = agenda.ListarContatos();

            Console.WriteLine(listaDeContatos);
            
        }
    }
}
