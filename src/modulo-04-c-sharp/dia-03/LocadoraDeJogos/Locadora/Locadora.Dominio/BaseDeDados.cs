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
        public string caminhoArquivo;
        XElement jogos;
        public BaseDeDados()
        {
            this.caminhoArquivo = @"C:\Users\marvi\Documents\crescer-2015-2\src\modulo-04-c-sharp\dia-03\LocadoraDeJogos\dbDeJogos.xml";
            this.jogos = XElement.Load(caminhoArquivo);
        }

        public void cadastrarJogo(string nome, int id, string categoria, double preco)
        {
            
            XDocument documentoXml = XDocument.Load(caminhoArquivo);
            Jogo jogo = new Jogo(nome, categoria, preco, id);

            documentoXml.Element("jogos").Add(jogo.ToXElement());
            documentoXml.Save(caminhoArquivo);
                 
        }

        public int nextID()
        {
            
            XDocument documentoXml = XDocument.Load(caminhoArquivo);
            int proximoID = Convert.ToInt32(documentoXml.Element("jogos").Elements().Count()) + 1;
            return proximoID;
                  
        }

        public XElement pasquisarPorNome(string nome)
        {
            try
            {
                XElement jogo = jogos.Elements().First(jogo2 => jogo2.Element("nome").Value == nome);
                return jogo;
            }
            catch (Exception)
            {
                throw;
            }
             
        }

        public Jogo getJogo(string nomeDoJogo)
        {
            XElement xejogo = pasquisarPorNome(nomeDoJogo);
            string nomeJogo = xejogo.Element("nome").Value;
            double precoJogo = Convert.ToDouble(xejogo.Element("preco").Value);
            string categoriaJogo = xejogo.Element("categoria").Value;
            int idJogo = Convert.ToInt32(xejogo.Attribute("id").Value);
            Jogo jogo = new Jogo(nomeJogo,categoriaJogo,precoJogo,idJogo);
            return jogo;
        }
    }
}
