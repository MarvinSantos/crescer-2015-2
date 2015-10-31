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

        public void cadastrarJogo(Jogo jogo)
        {
            
            XDocument documentoXml = XDocument.Load(caminhoArquivo);

            documentoXml.Element("jogos").Add(jogo.ToXElement());
            documentoXml.Save(caminhoArquivo);
                 
        }

        public int nextID()
        {
            
            XDocument documentoXml = XDocument.Load(caminhoArquivo);
            int proximoID = Convert.ToInt32(documentoXml.Element("jogos").Elements().Count()) + 1;
            return proximoID;
                  
        }

        public XElement PesquisarPorNome(string nome)
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

        public Jogo GetJogo(string nomeDoJogo)
        {
            Jogo jogo;
            try
            {
                XElement xejogo = PesquisarPorNome(nomeDoJogo);
                string nomeJogo = xejogo.Element("nome").Value;
                double precoJogo = Convert.ToDouble(xejogo.Element("preco").Value);
                string categoriaJogo = xejogo.Element("categoria").Value;
                int idJogo = Convert.ToInt32(xejogo.Attribute("id").Value);
                string statusJogo = xejogo.Element("status").Value;
                jogo = new Jogo(nomeJogo, categoriaJogo, precoJogo, idJogo,statusJogo);
            }
            catch (Exception)
            {

                throw;
            }
            
            return jogo;
        }

        public void AlterarCamposDoJogo(Jogo jogo, string jogoParaAlterar)
        {
            XElement xeJogo = PesquisarPorNome(jogoParaAlterar);
            xeJogo.Element("nome").Value = jogo.Nome;
            xeJogo.Element("categoria").Value = jogo.Categoria;
            xeJogo.Element("preco").Value = Convert.ToString(jogo.Preco);
            xeJogo.Attribute("id").Value = Convert.ToString(jogo.Id);
            xeJogo.Element("status").Value = jogo.Status;
            jogos.Save(caminhoArquivo);
        }

        public int GetIdJogo(string nomeDoJogo)
        {
            XElement xeJogo = PesquisarPorNome(nomeDoJogo);
            return Convert.ToInt32(xeJogo.Attribute("id").Value);
        }

        public int QuantidadeTotalDeJogos()
        {
            return jogos.Elements("jogo").Count();
        }

        public string JogoMaisCaro()
        {
            
            double maiorPreco = jogos.Elements("jogo").Max(jogo => Convert.ToDouble(jogo.Element("preco").Value));
            var jogoMaisCaro = jogos.Elements("jogo").First(jogo => Convert.ToDouble(jogo.Element("preco").Value) == maiorPreco);
            return jogoMaisCaro.Element("nome").Value;
        }

        public string jogoMaisBarato()
        {
            double menorPreco = jogos.Elements("jogo").Min(jogo => Convert.ToDouble(jogo.Element("preco").Value));
            var jogoMaisBarato = jogos.Elements("jogo").First(jogo => Convert.ToDouble(jogo.Element("preco").Value) == menorPreco);
            return jogoMaisBarato.Element("nome").Value;
        }

        public int QuantidadeJogosDisponiveis()
        {
            return jogos.Elements("jogo").Count(jogo => jogo.Element("status").Value == "disponivel");
        }

        public double MediaDePrecoDosJogos()
        {
            double media;
            media = jogos.Elements("jogo").Sum(jogo => Convert.ToDouble(jogo.Element("preco").Value)) / QuantidadeTotalDeJogos();
            return media;
        }

        public string ListaDeJogosEmString()
        {
            string listaJogos = "";
            string quebraLinha = Environment.NewLine;
            foreach (var xeJogo in jogos.Elements("jogo"))
            {
                string nome = xeJogo.Element("nome").Value;
                nome = DiminuiNomeGrandeDeJogo(nome);
                string categoria = xeJogo.Element("categoria").Value;
                string id = xeJogo.Attribute("id").Value;
                string preco = xeJogo.Element("preco").Value.Replace(".",",");
                string status = xeJogo.Element("status").Value;
                listaJogos += String.Format("{0,-9}{1,-17}{2,-34}{3,-3}R$ {4,-8}{5,-15}{6}",id,categoria, nome,"  ", preco ,status,quebraLinha);
            }

            return listaJogos;
        }


        public string DiminuiNomeGrandeDeJogo(string nome)
        {
            string nome2;
            if(nome.Length > 28)
            {
                nome2 = nome.Substring(0, 28);
            }
            else
            {
                nome2 = nome;
            }
            return nome2;
        }

    }
}
