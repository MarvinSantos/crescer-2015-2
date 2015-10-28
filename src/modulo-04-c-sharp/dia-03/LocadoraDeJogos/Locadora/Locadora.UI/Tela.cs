using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.UI
{
    class Tela
    {
        public void mostrarTela()
        {
            Console.WriteLine(" 1- Cadastrar Um novo jogo \r\n 2- Realizar pesquisa de jogos por nome \r\n 3- Editar um jogo \r\n 4-Exportar relatorio de jogos em TXT \r\n 5- Sair");
        }

        public void pedirNomeDoJogo()
        {
            Console.WriteLine("Digite o nome Do Jogo");
                    
        }

        public void pedirNovoNome()
        {
            Console.WriteLine("Digite o novo Nome");
        }

        public void pedirNovoPreco()
        {
            Console.WriteLine("");
        }

        
    }
}
