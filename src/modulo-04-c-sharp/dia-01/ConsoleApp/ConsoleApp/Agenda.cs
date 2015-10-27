using System.Collections.Generic;
using System.Linq;

namespace ConsoleApp
{
    public class Agenda
    {
        private List<Contato> contatos = new List<Contato>();

        public int quantidadeContatos { get { return contatos.Count; } }

       
        public void AdcionarContato(Contato contato)
        {
            contatos.Add(contato);
        }

        //public void RemoverContato(string nomeContato)
        //{
        //    foreach (var contato in contatos)
        //    {
        //        if(contato.Nome == nomeContato)
        //        {
        //            contatos.Remove(contato);
        //            break;
        //        }
        //    }
        //}

        public void RemoverContatoPorNome(string nomeContato)
        {
            var contatosASeremRemovidos = new List<Contato>();
            for (int i = 0; i < contatos.Count; i++)
            {
                if (contatos[i].Nome == nomeContato)
                {
                    contatosASeremRemovidos.Add(contatos[i]);
                }
            }

            foreach (var contato in contatosASeremRemovidos)
            {
                contatos.Remove(contato);
            }
        }


        public void RemoverContatoPorNumero(int numeroContato)
        {
            var contatosASeremRemovidos = new List<Contato>();
            for (int i = 0; i < contatos.Count; i++)
            {
                if (contatos[i].Numero == numeroContato)
                {
                    contatosASeremRemovidos.Add(contatos[i]);
                }
            }

            foreach (var contato in contatosASeremRemovidos)
            {
                contatos.Remove(contato);
            }
        }

        public string ListarContatos()
        {
            string texto = "";

            foreach (var contato in contatos)
            {
                texto += contato.Nome + "-" + contato.Numero + "\n";
            }

            return texto;
        }

        public string ListarOrdenadosPorNome()
        {
            string texto = "";
            var nomesOrdenados = contatos.OrderBy(contato => contato.Nome).ToList();

            foreach (var contato in nomesOrdenados)
            {
                texto += contato.Nome + "-" + contato.Numero + "\n";
            }


            return texto;

        }

    }
}
