using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Locadora.Dominio;

namespace UnitTestProject1
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void PesquisandoJogoPorNome()
        {

            BaseDeDados dbXml = new BaseDeDados();
            Jogo jogo = dbXml.GetJogo("Goof Troop");
            string informacoesDoJogo = jogo.ToString();
            string informacoesEsperadas = "Nome: Goof Troop\r\nID: 19\r\nCategoria: AVENTURA\r\nStatus: Disponivel\r\nPreço: $41.90 ";
            
            Assert.AreEqual(informacoesDoJogo,informacoesEsperadas);
        }


        [TestMethod]
        public void CadastrandoUmNovoJogo()
        {

            BaseDeDados dbXml = new BaseDeDados();
            Jogo jogo = new Jogo("Yugioh","duel cards",109.90,dbXml.nextID(),"locado");
            dbXml.cadastrarJogo(jogo);
            Jogo jogoEsperado = new Jogo("Yugioh", "duel cards", 109.90, 21, "locado");

            Assert.AreEqual(jogo, jogoEsperado);
        }


        [TestMethod]
        public void EditandoUmJogo()
        {
            //consertar
            BaseDeDados dbXml = new BaseDeDados();
            Jogo jogo = new Jogo("Zelda", "Aventura", 50, dbXml.nextID(), "locado");
            dbXml.cadastrarJogo(jogo);
            Jogo jogoEditado = new Jogo("Super Zelda 2", "Aventura", 50, 22, "locado");
            dbXml.AlterarCamposDoJogo(jogoEditado, "Zelda");
            Jogo jogoEsperado = dbXml.GetJogo("Super Zelda 2");

            Assert.AreEqual(jogo, jogoEsperado);
        }
    }
}
