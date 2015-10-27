using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp
{
    public class Contato
    {
        public string Nome;
        public int Numero;

        public Contato(string nome, int numero)
        {
            this.Nome = nome;
            this.Numero = numero;
        }

        public override string ToString()
        {
            return Nome + "-" + Numero;
        }

    }
}
