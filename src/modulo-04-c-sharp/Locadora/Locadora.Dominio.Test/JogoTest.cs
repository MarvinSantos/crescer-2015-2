using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Locadora.Dominio.Test
{
    [TestClass]
    public class JogoTest
    {
        [TestMethod]
        public void JogoADeveSerIgualJogoB()
        {
            
            Jogo jogoA = new Jogo(id: 1);
            jogoA.IdCliente = null;
            Jogo jogoB = new Jogo(id: 1);
            jogoB.IdCliente = null;

            Assert.AreEqual(jogoA, jogoB);
        }

        [TestMethod]
        public void LocacaoParaClienteTemIdCorreto()
        {
            Jogo jogo = new Jogo();

            jogo.LocarPara(new Cliente(id: 1));

            
            Assert.AreEqual(1, jogo.IdCliente);
        }

        [TestMethod]
        public void PrecoEh15PqSeloEhOuro()
        {
            Jogo jogo = new Jogo();
            jogo.Selo = Selo.OURO;

            Assert.AreEqual(15.00m, jogo.Preco);
        }

        [TestMethod]
        public void PrecoEh10PqSeloEhPrata()
        {
            Jogo jogo = new Jogo();
            jogo.Selo = Selo.PRATA;

            Assert.AreEqual(10.00m, jogo.Preco);
        }

        [TestMethod]
        public void PrecoEh5PqSeloEhBronze()
        {
            Jogo jogo = new Jogo();
            jogo.Selo = Selo.BRONZE;

            Assert.AreEqual(5.00m, jogo.Preco);
        }

        [TestMethod]
        public void DataPrevistaDeentregaEhDe3DiasPqSeloEhBronze()
        {
            Jogo jogo = new Jogo();
            jogo.Selo = Selo.BRONZE;
            jogo.DataLocacao = DateTime.Now;
            DateTime? dataEsperada = jogo.DataLocacao;
            DateTime dataEsperada2 = dataEsperada.Value;
            dataEsperada2 = dataEsperada2.AddDays(3);

            Assert.AreEqual(dataEsperada2, jogo.DataPrevistaEntrega);
        }

        [TestMethod]
        public void DataPrevistaDeEntregaEhDe2DiasPqSeloEhPrata()
        {
            Jogo jogo = new Jogo();
            jogo.Selo = Selo.PRATA;
            jogo.DataLocacao = DateTime.Now;
            DateTime? dataEsperada = jogo.DataLocacao;
            DateTime dataEsperada2 = dataEsperada.Value;
            dataEsperada2 = dataEsperada2.AddDays(2);

            Assert.AreEqual(dataEsperada2, jogo.DataPrevistaEntrega);
        }

        [TestMethod]
        public void DataPrevistaDeEntregaEhDe1DiasPqSeloEhOuro()
        {
            Jogo jogo = new Jogo();
            jogo.Selo = Selo.OURO;
            jogo.DataLocacao = DateTime.Now;
            DateTime? dataEsperada = jogo.DataLocacao;
            DateTime dataEsperada2 = dataEsperada.Value;
            dataEsperada2 = dataEsperada2.AddDays(1);

            Assert.AreEqual(dataEsperada2, jogo.DataPrevistaEntrega);
        }
    }
}
