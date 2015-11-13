using Locadora.Web.MVC.Models;
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
using Locadora.Dominio.Servicos;

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

        
        
        public ActionResult Locacao(int id)
        {
            IJogoRepositorio repositorio = FabricaDeModulos.CriarJogoRepositorio();
            
            var jogo = repositorio.BuscarPorId(id);
            JogoLocacaoModel jogolocacao = new JogoLocacaoModel()
            {
                Cliente = jogo.ClienteLocacao,
                Id = jogo.Id,
                Descricao = jogo.Descricao,
                Imagem = jogo.Imagem,
                Nome = jogo.Nome,
                DataPrevistaEntrega = jogo.DataPrevistaEntrega,
                PrecoPorSelo = jogo.Preco
            };

            return View(jogolocacao);
               
        }

        [HttpPost]
        public ActionResult SalvarLocacao(JogoLocacaoModel jogoLocacaoModel)
        {
            IClienteRepositorio clienteRepo = FabricaDeModulos.CriarClienteRepositorio();
            var clienteLocador = clienteRepo.BuscarPorNome(jogoLocacaoModel.Cliente.Nome).FirstOrDefault(j => j.Nome == jogoLocacaoModel.Cliente.Nome);
    
            IJogoRepositorio repositorioJogo = FabricaDeModulos.CriarJogoRepositorio();
            var jogo = repositorioJogo.BuscarPorId(jogoLocacaoModel.Id);

            bool estaLocado = repositorioJogo.VerificarSeEstaLocado(jogo);

            if (clienteLocador != null && !estaLocado)
            {

                jogo.LocarPara(clienteLocador);
                jogo.DataLocacao = DateTime.Now;

                ServicoValidacaoLocacao servicoValidadorLocacao = FabricaDeModulos.CriarServicoValidacaoLocacao();
                bool podeLocar = servicoValidadorLocacao.ValidarLocacaoParaCliente(jogo.ClienteLocacao);

                if (podeLocar)
                {
                    repositorioJogo.Atualizar(jogo);
                    TempData["MensagemSalvarEditar"] = "Locado com sucesso :D";
                }
                else
                {
                    TempData["MensagemSalvarEditar"] = "o cliente ja possui 3 jogos locados";
                }
            }
            else
            {
                TempData["MensagemSalvarEditar"] = "O jogo esta locado, ou o cliente não esta cadastrado";
            }

            return RedirectToAction("JogosDisponiveis", "Relatorio");
        }


        //public ActionResult Devolver(JogoLocacaoModel jogoLocacaoModel)
        //{

        //}
    }
}