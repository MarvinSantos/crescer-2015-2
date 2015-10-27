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
        public void DoisContatosSaoRemovidosPorNumero()
        {
            var agenda = new Agenda();
            var contato1 = new Contato("marvinn", 23873);
            var contato2 = new Contato("marvin", 23873);

            agenda.AdcionarContato(contato1);
            agenda.AdcionarContato(contato2);
            agenda.RemoverContatoPorNumero(23873);

            Assert.AreEqual(agenda.quantidadeContatos, 0);
        }



        [TestMethod]
        public void UmContatoEhRemovidoPorNome()
        {
            var agenda = new Agenda();
            var contato1 = new Contato("marvinSantos", 23873);
            var contato2 = new Contato("marvin", 23873);

            agenda.AdcionarContato(contato1);
            agenda.AdcionarContato(contato2);
            agenda.RemoverContatoPorNome("marvinSantos");

            Assert.AreEqual(agenda.quantidadeContatos, 1);
        }

        [TestMethod]
        public void Adiciona5ContatosEChamaOMetodoListar()
        {
            var agenda = new Agenda();
            var contato1 = new Contato("marvinSantos", 23873);
            var contato2 = new Contato("Ben10", 558);
            var contato3 = new Contato("Goku", 383);
            var contato4 = new Contato("Bills", 397);
            var contato5 = new Contato("JavaScript", 844);

            agenda.AdcionarContato(contato1);
            agenda.AdcionarContato(contato2);
            agenda.AdcionarContato(contato3);
            agenda.AdcionarContato(contato4);
            agenda.AdcionarContato(contato5);

            string textoEsperado = "marvinSantos-23873\nBen10-558\nGoku-383\nBills-397\nJavaScript-844\n";
            string textoObtido = agenda.ListarContatos();
            Assert.AreEqual(textoObtido,textoEsperado);
        }

        [TestMethod]
        public void Adiciona5ContatosEChamaOMetodoListarContatosOrdenados()
        {
            var agenda = new Agenda();
            var contato1 = new Contato("marvinSantos", 23873);
            var contato2 = new Contato("Ben10", 558);
            var contato3 = new Contato("Goku", 383);
            var contato4 = new Contato("Bills", 397);
            var contato5 = new Contato("JavaScript", 844);

            agenda.AdcionarContato(contato1);
            agenda.AdcionarContato(contato2);
            agenda.AdcionarContato(contato3);
            agenda.AdcionarContato(contato4);
            agenda.AdcionarContato(contato5);

            string textoEsperado = "Ben10-558\nBills-397\nGoku-383\nJavaScript-844\nmarvinSantos-23873\n";
            string textoObtido = agenda.ListarOrdenadosPorNome();
            Assert.AreEqual(textoObtido, textoEsperado);
        }
    }
}
