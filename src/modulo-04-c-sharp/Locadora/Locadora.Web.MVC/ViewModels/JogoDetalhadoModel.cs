using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Locadora.Dominio;
using Locadora.Web.MVC.ViewModels.BaseModels;

namespace Locadora.Web.MVC.Models
{
    public class JogoDetalhadoModel : JogoBase
    {
        
        public string Categoria { get; set; }
        public string Descricao { get; set; }
        public string Imagem { get; set; }
        public string Video { get; set; }
        public Selo Selo { get; set; }
    }
}