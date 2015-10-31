using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public class Relatorio
    {

        public string caminhoArquivo;

        public Relatorio()
        {
            this.caminhoArquivo = @"C:\Users\marvi\Documents\crescer-2015-2\src\modulo-04-c-sharp\dia-03\LocadoraDeJogos\Relatorio.txt";
        }


        public void ExportarRelatorio(BaseDeDados baseDeDados)
        {
            DateTime data = DateTime.Now;
            string listaDeJogos = baseDeDados.ListaDeJogosEmString();
            string quebraLinha = Environment.NewLine;
            string nomeLocadora = "                                 LOCADORA NUNES GAMES                                   "+quebraLinha;
            string dataEHora = String.Format("{0:dd/MM/yyyy}                                                                      {0:hh/mm/ss}{1}",data,quebraLinha);
            string cabecalho = "                                  Relatório de jogos                                    "+quebraLinha;
            string divisao = quebraLinha + "========================================================================================" + quebraLinha;
            string colunas = "ID       Categoria        Nome                                 Preço      Status"+quebraLinha;

            string divisao2 = quebraLinha + "----------------------------------------------------------------------------------------" + quebraLinha;
            string quantidadeTotalJogos = "Quantidade total de jogos: " + baseDeDados.QuantidadeTotalDeJogos() + quebraLinha;
            string quantidadeJogosDisponiveis = "Quantidade de jogos disponíveis: " + baseDeDados.QuantidadeJogosDisponiveis() + quebraLinha;
            string valorMedio = String.Format("Valor médio por jogo: R$ {0:#000.00}{1}", baseDeDados.MediaDePrecoDosJogos(), quebraLinha);
            string jogoMaisCaro = "Jogo mais caro: " + baseDeDados.JogoMaisCaro() + quebraLinha;
            string jogoMaisBarato = "Jogo mais barato: " + baseDeDados.jogoMaisBarato() + quebraLinha;

            using (StreamWriter writer = new StreamWriter(caminhoArquivo))
            {
                writer.Write(nomeLocadora);
                writer.Write(dataEHora);
                writer.Write(cabecalho);
                writer.Write(divisao);
                writer.Write(colunas);
                writer.Write(listaDeJogos);

                writer.Write(divisao2);
                writer.Write(quantidadeTotalJogos);
                writer.Write(quantidadeJogosDisponiveis);
                writer.Write(valorMedio);
                writer.Write(jogoMaisCaro);
                writer.Write(jogoMaisBarato);
                writer.Write(divisao);

                writer.Close();
            }

        }
    }
}
