using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Locadora.Dominio;

namespace Locadora.Web.MVC.Models
{
    public class JogoDetalhadoModel
    {
        public string Nome { get; set; }
        public string Categoria { get; set; }
        public decimal Preco { get; set; }
        public int Id { get; set; }
        public string Descricao { get; set; }
        public string Imagem { get; set; }
        public string Video { get; set; }
        public Selo Selo { get; set; }
    }
}