using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace Locadora.Dominio
{
    public class Jogo
    {
        public string Nome { get; set; }
        public string Categoria { get; set; }
        public double Preco { get; set; } 
        public int Id { get; set; }

        public Jogo(string nome, string categoria, double preco,int id)
        {
            this.Nome = nome;
            this.Categoria = categoria;
            this.Preco = preco;
            this.Id = id;
        }

        public XElement ToXElement()
        {
            XElement jogoXElemento = new XElement("jogo", new XAttribute("id", Id), new XElement("nome", Nome), new XElement("preco", Preco), new XElement("categoria", Categoria));
            return jogoXElemento;
        }

        public override string ToString()
        {
            string informacoes = string.Format("Nome: " + Nome + "\r\nID: "+ this.Id + "\r\nCategoria: " + this.Categoria + "\r\nPreço: {0:C} ",this.Preco);
            return informacoes;
        }

    }


}
