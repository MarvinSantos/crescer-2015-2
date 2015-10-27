using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp
{
    class Program
    {
        public const int ADD = 1;
        public const int REMOVERPORNOME = 2;
        public const int REMOVERPORNUMERO  = 3;
        public const int LISTAR = 4;
        public const int LISTARORDENADO = 5;
        public const int SAIR = 6;


        static void Main(string[] args)
        {
            var nome = "";
            var numero = 0;
            var agenda = new Agenda();
            int indice = 12;
            string listaDeContatos;
            string listaDeContatosOrdenados;
            var rodando = true;
            do
            { 
                
                Console.WriteLine(" 1 - ADD um contato \n 2 - Remover um contato por nome \n 3 - Remover um contato por numero \n 4 - Listar contatos \n 5 - Listar contatos Ordenados Por Nome A>Z \n 6 - Sair");
                
                indice = Convert.ToInt32(Console.ReadLine());
                switch (indice)
                {
                    case ADD:
                        Console.Clear();
                        Console.WriteLine("Digite O Nome:");
                        nome = Console.ReadLine();
                        Console.WriteLine("Digite O Numero:");
                        numero = Convert.ToInt32(Console.ReadLine());                    
                        agenda.AdcionarContato(new Contato(nome, numero));
                        Console.Clear();
                        break;


                    case REMOVERPORNOME:
                        Console.Clear();
                        Console.WriteLine("Digite O Nome:");
                        nome = Console.ReadLine();
                        agenda.RemoverContatoPorNome(nome);
                        Console.Clear();
                        break;


                    case REMOVERPORNUMERO:
                        Console.Clear();
                        Console.WriteLine("Digite O Numero:");
                        numero = Convert.ToInt32(Console.ReadLine());
                        agenda.RemoverContatoPorNumero(numero);
                        Console.Clear();
                        break;


                    case LISTAR:
                        Console.Clear();
                        listaDeContatos = agenda.ListarContatos();
                        Console.WriteLine(listaDeContatos);
                        Console.WriteLine("Para Sair Aperte Enter");
                        Console.ReadKey();
                        Console.Clear();
                        break;


                    case LISTARORDENADO:
                        Console.Clear();
                        listaDeContatosOrdenados = agenda.ListarOrdenadosPorNome();
                        Console.WriteLine(listaDeContatosOrdenados);
                        Console.WriteLine("Para Sair Aperte Enter");
                        Console.ReadKey();
                        Console.Clear();
                        break;


                    case SAIR:
                        rodando = false;
                        break;


                    default:
                        Console.WriteLine("Esta opção é invalida, Escolha uma das opções na lista, digite o indice da opção e aperte enter.");
                        break;


                }   
            } while (rodando);
        }

        public static void EscreverContatosNaTela(Agenda agenda)
        {
            string listaDeContatos = agenda.ListarContatos();

            Console.WriteLine(listaDeContatos);
            
        }
    }
}
