﻿using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Locadora.Repositorio.EF;
using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Filters;
using Locadora.Web.MVC.Helpers;
using Locadora.Web.MVC.ViewModels;

namespace Locadora.Web.MVC.Controllers
{
    [Autorizador]
    public class JogoController : Controller
    {
        
        public ActionResult JogoDetalhado(int id)
        {
            IJogoRepositorio repo = new JogoRepositorio();
            var jogo = repo.BuscarPorId(id);

            JogoDetalhadoModel jogoDetalhadoModel = new JogoDetalhadoModel()
            {
                Nome = jogo.Nome,
                Categoria = jogo.Categoria.ToString(),
                Id = jogo.Id,
                Imagem = jogo.Imagem,
                Video = jogo.Video,
                Descricao = jogo.Descricao,
                Selo = jogo.Selo
            };
           

            return View(jogoDetalhadoModel);
        }

        [HttpPost]
        [HttpGet]
        public ActionResult Locacao(int? id)
        {
            IJogoRepositorio repositorio = FabricaDeModulos.CriarJogoRepositorio();
            if(id != null)
            {
                var jogo = repositorio.BuscarPorId((int)id);
                JogoLocacaoModel jogolocacao = new JogoLocacaoModel()
                {
                    Cliente = jogo.ClienteLocacao,
                    Id = jogo.Id,
                    Descricao = jogo.Descricao,
                    Imagem = jogo.Imagem,
                    Nome = jogo.Nome
                    
                };

                return View(jogolocacao);
            }
            else
            {
                return RedirectToAction("JogosDisponiveis","Relatorio");
            }
            
        }
    }
}