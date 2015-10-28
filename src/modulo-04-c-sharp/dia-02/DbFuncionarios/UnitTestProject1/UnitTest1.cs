using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using DbFuncionarios;
using System.Collections.Generic;

namespace UnitTestProject1
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void OrdenaPorCategoria()
        {
            var baseDeDados = new BaseDeDados();
            IList<Funcionario> funcionarios = baseDeDados.OrdenadosPorCategoria();
            string textoEsperado = "Analista,Analista,Desenvolvedor,Desenvolvedor,Desenvolvedor,Desenvolvedor,Desenvolvedor,Desenvolvedor,Desenvolvedor,Desenvolvedor,Gerente,";
            string resposta = "";
            foreach (var funcionario in funcionarios)
            {
                resposta += funcionario.Cargo.Titulo + ",";
            }
            Assert.AreEqual(textoEsperado, resposta);
        }

        [TestMethod]
        public void Busca2FuncionariosPorNome()
        {
            var baseDeDados = new BaseDeDados();
            IList<Funcionario> funcionario = baseDeDados.BuscarPorNome("Felipe Nervo");
            IList<Funcionario> funcionario2 = baseDeDados.BuscarPorNome("Gabriel Alboy");
            string nomeEsperado1 = "Felipe Nervo";
            string nomeEsperado2 = "Gabriel Alboy";

            Assert.AreEqual(nomeEsperado1, funcionario[0].Nome);
            Assert.AreEqual(nomeEsperado2, funcionario2[0].Nome);


        }


        [TestMethod]
        public void BuscaFuncionariosPorTurnoTardeENoite()
        {
            var baseDeDados = new BaseDeDados();
            IList<Funcionario> funcionarios = baseDeDados.BuscarPorTurno(TurnoTrabalho.Tarde, TurnoTrabalho.Noite);
            string nomesEsperados = "Jean Pinzon,Rafael Benetti,Felipe Nervo,Lucas Kauer,Eduardo Arnold,Carlos Henrique,";
            string nomesRecebidos = "";

            foreach (var funcionario in funcionarios)
            {
                nomesRecebidos += funcionario.Nome + ",";
            }
            Assert.AreEqual(nomesEsperados, nomesRecebidos);


        }


        

        [TestMethod]
        public void BuscaPorCargo()
        {
            var baseDeDados = new BaseDeDados();
            Cargo analista = new Cargo("Analista", 250);
            IList<Funcionario> funcionarios = baseDeDados.BuscarPorCargo(analista);
            string nomesEsperados = "Gabriel Alboy,Carlos Henrique,";
            string nomesRecebidos = "";

            foreach (var funcionario in funcionarios)
            {
                nomesRecebidos += funcionario.Nome + ",";
            }
            Assert.AreEqual(nomesEsperados, nomesRecebidos);


        }

        [TestMethod]
        public void filtrandoPorIdadeAproximada()
        {
            var baseDeDados = new BaseDeDados();
            IList<Funcionario> funcionarios = baseDeDados.FiltrarPorIdadeAproximada(31);
            string nomesEsperados = "Eduardo Arnold,Margarete Ricardo,";
            string nomesRecebidos = "";

            foreach (var funcionario in funcionarios)
            {
                nomesRecebidos += funcionario.Nome + ",";
            }
            Assert.AreEqual(nomesEsperados, nomesRecebidos);


        }


        [TestMethod]
        public void tirandoAMediaSalarialPorTurno()
        {
            var baseDeDados = new BaseDeDados();
      
            double numeroRecebido = baseDeDados.SalarioMedio(TurnoTrabalho.Manha);
            double numeroEsperado = 274.1;
            Assert.AreEqual(numeroEsperado, numeroRecebido);

        }


        [TestMethod]
        public void procurandoOAniversarianteDoMes()
        {
            var baseDeDados = new BaseDeDados();
            IList<Funcionario> funcionarios = baseDeDados.AniversariantesDoMes();
            string nomesEsperados = "Margarete Ricardo,";
            string nomesRecebidos = "";
            foreach (var item in funcionarios)
            {
                nomesRecebidos += item.Nome + ",";
            }

        }


    }
}
