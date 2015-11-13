using Locadora.Dominio;
using Locadora.Web.MVC.ViewModels.BaseModels;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.ViewModels
{
    public class JogoLocacaoModel : JogoBase
    {
        public string Descricao { get; set; }
        public string Imagem { get; set; }
        public Cliente Cliente { get; set; }
        public DateTime? DataLocacao { get; set; }
        public decimal PrecoPorSelo { get; set; }
        public DateTime? DataPrevistaEntrega { get; set; }
       
    }
}