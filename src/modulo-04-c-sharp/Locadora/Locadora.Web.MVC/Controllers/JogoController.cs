using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Locadora.Repositorio.EF;
using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Filters;

namespace Locadora.Web.MVC.Controllers
{
    public class JogoController : Controller
    {
        [Autorizador(Roles ="Jogo_Detalhado")]
        public ActionResult JogoDetalhado(int id)
        {
            IJogoRepositorio repo = new JogoRepositorio();
            var jogo = repo.BuscarPorId(id);

            JogoDetalhadoModel jogoDetalhadoModel = new JogoDetalhadoModel()
            {
                Nome = jogo.Nome,
                Preco = jogo.Preco,
                Categoria = jogo.Categoria.ToString(),
                Id = jogo.Id,
                Imagem = jogo.Imagem,
                Video = jogo.Video,
                Descricao = jogo.Descricao,
                Selo = jogo.Selo
            };
           

            return View(jogoDetalhadoModel);
        }
    }
}