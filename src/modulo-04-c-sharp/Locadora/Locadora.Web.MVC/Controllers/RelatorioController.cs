using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Locadora.Repositorio.ADO;
using Locadora.Dominio.Repositorio;

namespace Locadora.Web.MVC.Controllers
{
    public class RelatorioController : Controller
    {
        IJogoRepositorio repo = new JogoRepositorio();

        public ActionResult JogosDisponiveis()
        {      
            RelatorioModel model = new RelatorioModel();

            foreach (var jogo in repo.BuscarTodos())
            {
                JogoModel jogoModel = new JogoModel();
                jogoModel.Nome = jogo.Nome;
                jogoModel.Preco = jogo.Preco;
                jogoModel.Categoria = jogo.Categoria.ToString();

                model.Jogos.Add(jogoModel);
            }

            return View(model);
        }
    }
}