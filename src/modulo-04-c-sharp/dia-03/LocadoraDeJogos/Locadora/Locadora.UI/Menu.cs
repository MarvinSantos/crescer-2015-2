using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

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

        public void PedirNovoNome()
        {
            Console.WriteLine("Digite o novo Nome");
        }

        public void PedirNovoPreco()
        {
            Console.WriteLine("Digite o novo Preço que este jogo terá");
        }

        public void MostrarInformacoesDoJogoNaTela(XElement jogo)
        {
            Console.WriteLine("Nome: " + jogo.Element("nome").Value);
            Console.WriteLine("Preço: " + jogo.Element("preco").Value);
            Console.WriteLine("Categoria: " + jogo.Element("categoria").Value);
            Console.WriteLine("ID: " + jogo.Attribute("id").Value);
        }

        
    }
}
