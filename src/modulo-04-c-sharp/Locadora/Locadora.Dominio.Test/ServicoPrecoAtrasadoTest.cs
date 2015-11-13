using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Locadora.Dominio.Servicos;

namespace Locadora.Dominio.Test
{
    [TestClass]
    public class ServicoPrecoAtrasadoTest
    {
        [TestMethod]
        public void JogoEDevolvidoNoPrazoEClienteNaoPagaMulta()
        {

            Jogo jogo = new Jogo();
            jogo.Selo = Selo.OURO;
            jogo.DataLocacao = DateTime.Now;
            decimal precoEsperado = 15.00m;

            ServicoDeValidacaoPreco validadorPreco = new ServicoDeValidacaoPreco();
            decimal precoAPagar = validadorPreco.CalcularPreco(jogo);

            Assert.AreEqual(precoEsperado,precoAPagar);
        }

    }
}
