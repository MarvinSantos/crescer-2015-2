using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.ViewModels.BaseModels
{
    public abstract class JogoBase
    {
        public string Nome { get; set; }
        public int Id { get; set; }
    }
}