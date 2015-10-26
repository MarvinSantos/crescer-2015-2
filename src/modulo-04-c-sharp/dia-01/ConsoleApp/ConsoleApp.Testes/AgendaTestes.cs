using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace ConsoleApp.Testes
{
    [TestClass]
    public class AgendaTestes
    {
        [TestMethod]
        public void AgendaTemUmContato()
        {
            var agenda = new Agenda();
            var contato1 = new Contato("marvinn",23873);

            agenda.AdcionarContato(contato1);

            Assert.AreEqual(agenda.quantidadeContatos, 1);
        }

        [TestMethod]
        public void UmContatoEhRemovidoPorNumero()
        {
            var agenda = new Agenda();
            var contato1 = new Contato("marvinn", 23873);
            var contato2 = new Contato("marvin", 23873);

            agenda.AdcionarContato(contato1);
            agenda.AdcionarContato(contato2);
            agenda.RemoverContatoPorNumero(23873);

            Assert.AreEqual(agenda.quantidadeContatos, 0);
        }
    }
}
