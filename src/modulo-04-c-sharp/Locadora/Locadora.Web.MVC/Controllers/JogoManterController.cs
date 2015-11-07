﻿using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using Locadora.Repositorio.ADO;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public class JogoManterController : Controller
    {
        IJogoRepositorio repo = new JogoRepositorio();


        [HttpGet]
        public ActionResult JogoManter(int? id)
        {
            if(id.HasValue)
            {

                var jogo = repo.BuscarPorId((int)id);

                var model = new ManterJogoModel()
                {
                    Id = jogo.Id,
                    Nome = jogo.Nome,
                    Categoria = jogo.Categoria,
                    Preco = jogo.Preco,
                    Descricao = jogo.Descricao,
                    Imagem = jogo.Imagem,
                    Video = jogo.Video,
                    Selo = jogo.Selo

                };

                return View(model);
            }
            else
            {
                return View();
            }
         
        }


        [ValidateAntiForgeryToken]
        [HttpPost]
        public ActionResult Salvar(ManterJogoModel model)
        {
            if (ModelState.IsValid)
            {

                if (model.Id != null)
                {

                    Jogo jogo = new Jogo((int)model.Id)
                    {
                        Nome = model.Nome,
                        Descricao = model.Descricao,
                        Preco = model.Preco,
                        Categoria = model.Categoria,
                        Imagem = model.Imagem,
                        Video = model.Video,
                        Selo = model.Selo
                    };

                    repo.Atualizar(jogo);
                    TempData["MensagemSalvarEditar"] = "Jogo Editado com sucesso!";

                    return RedirectToAction("JogosDisponiveis", "Relatorio");

                }
                else
                {

                    Jogo jogo = new Jogo()
                    {
                        Nome = model.Nome,
                        Descricao = model.Descricao,
                        Preco = model.Preco,
                        Categoria = model.Categoria,
                        Imagem = model.Imagem,
                        Video = model.Video,
                        Selo = model.Selo
                    };

                    repo.Criar(jogo);
                    TempData["MensagemSalvarEditar"] = "Jogo salvo com sucesso!";

                    return RedirectToAction("JogosDisponiveis", "Relatorio");
                }
            }
            else
            {
                return View("JogoManter",model);
            }
        }
    }
}