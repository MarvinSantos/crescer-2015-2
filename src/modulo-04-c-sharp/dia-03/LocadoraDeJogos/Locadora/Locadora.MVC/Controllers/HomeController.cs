using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.MVC.Controllers
{
    public class HomeController : Controller
    {
        
        public ActionResult HomePage()
        {
            return View("HomePage");
        }
    }
}