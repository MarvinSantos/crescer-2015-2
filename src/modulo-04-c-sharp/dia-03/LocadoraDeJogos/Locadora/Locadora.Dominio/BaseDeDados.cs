using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace Locadora.Dominio
{
    public class BaseDeDados
    {
        public string caminhoArquivo = @"C:\Users\marvin.santos\Documents\crescer-2015-2\src\modulo-04-c-sharp\dia-03\LocadoraDeJogos";

        public void cadastrarJogo(string nome, short id, string categoria, double preco)
        {
            Jogo jogo = new Jogo(nome, categoria, preco, id);
            XElement jogos = XElement.Load(caminhoArquivo);
            jogos.Element("jogos").Add(jogo.ToXElement());
                 
        }
    }
}
