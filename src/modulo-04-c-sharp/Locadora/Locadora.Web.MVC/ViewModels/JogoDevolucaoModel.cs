using Locadora.Web.MVC.ViewModels.BaseModels;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.ViewModels
{
    public class JogoDevolucaoModel : JogoBase
    {
        public DateTime? DataLocacao { get; set; }

        public decimal ValorFinal { get; set; }

    }
}