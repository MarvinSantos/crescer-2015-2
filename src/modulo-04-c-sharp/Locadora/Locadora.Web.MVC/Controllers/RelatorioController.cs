using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Locadora.Repositorio.ADO;
using Locadora.Dominio.Repositorio;
using Locadora.Dominio;

namespace Locadora.Web.MVC.Controllers
{
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
                    jogoModel.Preco = jogo.Preco;
                    jogoModel.Categoria = jogo.Categoria.ToString();
                    jogoModel.Id = jogo.Id;

                    model.Jogos.Add(jogoModel);
                }

                model.MaisBarato = jogos.OrderBy(jogo => jogo.Preco).First().Nome;
                model.MaisCaro = jogos.OrderByDescending(jogo => jogo.Preco).First().Nome;
                model.QuantidadeDeJogos = jogos.Count();
                model.MediaDePreco = jogos.Sum(jogo => jogo.Preco) / jogos.Count;
            }

            return View(model);
        }
    }
}