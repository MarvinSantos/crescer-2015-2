using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Locadora.Dominio;

namespace UnitTestProject1
{
    [TestClass]
    public class UnitTestDB
    {
        [TestMethod]
        public void PesquisandoJogoPorNome()
        {

            BaseDeDados dbXml = new BaseDeDados();
            Jogo jogo = dbXml.GetJogo("Goof Troop");
            string informacoesDoJogo = jogo.ToString();
            string informacoesEsperadas = "Nome: Goof Troop\r\nID: 19\r\nCategoria: AVENTURA\r\nStatus: disponivel\r\nPreço: $41.90 ";
            
            Assert.AreEqual(informacoesDoJogo,informacoesEsperadas);
        }


        [TestMethod]
        public void PegandoIDDoJogo()
        {

            BaseDeDados dbXml = new BaseDeDados();
            int id = dbXml.GetIdJogo("Goof Troop");
            int idEsperado = 19;
            Assert.AreEqual(id, idEsperado);
        }

        [TestMethod]
        public void PegandoQuantidadeTotalDeJogos()
        {

            BaseDeDados dbXml = new BaseDeDados();
            int quantidadeTotal = dbXml.QuantidadeTotalDeJogos();
            int quantidadeEsperada = 21;
            Assert.AreEqual(quantidadeTotal, quantidadeEsperada);
        }

        [TestMethod]
        public void PegandoQuantidadeDeJogosDisponiveis()
        {

            BaseDeDados dbXml = new BaseDeDados();
            int quantidadeDisponiveis = dbXml.QuantidadeJogosDisponiveis();
            int quantidadeEsperada = 20;
            Assert.AreEqual(quantidadeDisponiveis, quantidadeEsperada);
        }

        [TestMethod]
        public void JogoMaisCaro()
        {

            BaseDeDados dbXml = new BaseDeDados();
            string nomeJogoMaisCaro = dbXml.JogoMaisCaro();
            string nomeEsperado = "Zelda: A link to the past";
            Assert.AreEqual(nomeEsperado,nomeJogoMaisCaro);
        }

        [TestMethod]
        public void JogoMaisBarato()
        {

            BaseDeDados dbXml = new BaseDeDados();
            string nomeJogoMaisBarato = dbXml.jogoMaisBarato();
            string nomeEsperado = "Final Fight";
            Assert.AreEqual(nomeEsperado, nomeJogoMaisBarato);
        }

        [TestMethod]
        public void MediaDePrecoDosJogos()
        {

            BaseDeDados dbXml = new BaseDeDados();
            double media = Math.Round(dbXml.MediaDePrecoDosJogos());
            double mediaEsperada = 38;
            Assert.AreEqual(mediaEsperada, media);
        }

        [TestMethod]
        public void DiminuiNomeDeJogoQueForMuitoGrande()
        {

            BaseDeDados dbXml = new BaseDeDados();
            string nome = "International Super Star Soccer Deluxe";
            string nomeEsperado = "International Super Star Soc";
            nome = dbXml.DiminuiNomeGrandeDeJogo(nome);
            Assert.AreEqual(nomeEsperado, nome);
        }

        [TestMethod]
        public void EditandoUmJogo()
        {
            
            BaseDeDados dbXml = new BaseDeDados();

            Jogo jogoEditado = new Jogo("Super Zelda 2", "Aventura", 50, 21, "locado");
            dbXml.AlterarCamposDoJogo(jogoEditado, "Super Zelda 2");
            Jogo jogoEsperado = new Jogo("Super Zelda 2", "Aventura", 50, 21, "locado");
            Jogo jogo = dbXml.GetJogo("Super Zelda 2");

            Assert.AreEqual(jogo, jogoEsperado);
        }

        [TestMethod]
        public void CadastrandoUmNovoJogo()
        {

            BaseDeDados dbXml = new BaseDeDados();
            Jogo jogo = new Jogo("Yugioh","duel cards",109.90,dbXml.nextID(),"locado");
            dbXml.cadastrarJogo(jogo);
            Jogo jogoEsperado = new Jogo("Yugioh", "duel cards", 109.90, 22, "locado");

            Assert.AreEqual(jogo, jogoEsperado);
        }


        
    }
}
