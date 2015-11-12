using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Locadora.Repositorio.EF;
using Locadora.Dominio.Repositorio;
using Locadora.Dominio;
using Locadora.Web.MVC.Filters;

namespace Locadora.Web.MVC.Controllers
{
    [Autorizador]
    public class RelatorioController : Controller
    {
        IJogoRepositorio repo = new JogoRepositorio();

        public ActionResult JogosDisponiveis(string nomeJogo)
        {      
            RelatorioModel model = new RelatorioModel();
            IList<Jogo> jogos;

            if (!string.IsNullOrEmpty(nomeJogo))
            {
                jogos = repo.BuscarPorNome(nomeJogo);                     
            }
            else 
            {
                jogos = repo.BuscarTodos();
            }

            if (jogos.Count > 0)
            {
                foreach (var jogo in jogos)
                {
                    JogoModel jogoModel = new JogoModel();
                    jogoModel.Nome = jogo.Nome;
                    
                    jogoModel.Categoria = jogo.Categoria.ToString();
                    jogoModel.Id = jogo.Id;

                    model.Jogos.Add(jogoModel);
                }

               
                model.QuantidadeDeJogos = jogos.Count();
              
            }

            return View(model);
        }
    }
}