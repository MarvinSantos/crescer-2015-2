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
    public class JogoController : Controller
    {

        public ActionResult JogoDetalhado(int id)
        {
            IJogoRepositorio repo = new JogoRepositorio();
            var jogo = repo.BuscarPorId(id);

            JogoDetalhadoModel jogoDetalhadoModel = new JogoDetalhadoModel();
            jogoDetalhadoModel.Nome = jogo.Nome;
            jogoDetalhadoModel.Preco = jogo.Preco;
            jogoDetalhadoModel.Categoria = jogo.Categoria.ToString();
            jogoDetalhadoModel.Id = jogo.Id;
            jogoDetalhadoModel.Imagem = jogo.Imagem;
            jogoDetalhadoModel.Video = jogo.Video;
            jogoDetalhadoModel.Descricao = jogo.Descricao;
            jogoDetalhadoModel.Selo = jogo.Selo;

            return View(jogoDetalhadoModel);
        }
    }
}