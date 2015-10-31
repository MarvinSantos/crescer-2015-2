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
            double precoEsperado = 41.9;
            string informacoesDoJogo = jogo.ToString();
            string informacoesEsperadas = "Nome: Goof Troop\r\nID: 19\r\nCategoria: AVENTURA\r\nStatus: Disponivel\r\nPreço: $41.90 ";
            
            Assert.AreEqual(informacoesDoJogo,informacoesEsperadas);
        }
    }
}
