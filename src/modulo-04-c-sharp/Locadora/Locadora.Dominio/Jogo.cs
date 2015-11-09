using System;
using System.Globalization;
using System.Text;

namespace Locadora.Dominio
{
    public class Jogo : EntidadeBase
    {
        public String Nome { get; set; }

        public decimal Preco { get; set; }

        public Categoria Categoria { get; set; }

        public Cliente ClienteLocacao { get; private set; }

        public String Descricao { get; set; }

        public String Imagem { get; set; }

        public String Video { get; set; }

        public Selo Selo { get; set; }

        public Jogo()
        {

        }

        public Jogo(int id, Cliente cliente = null)
        {
            this.Id = id;
            this.ClienteLocacao = cliente;
        }

        public void LocarPara(Cliente cliente)
        {
            this.ClienteLocacao = cliente;
        }

        public override string ToString()
        {
            var builder = new StringBuilder();
            builder.AppendLine("Id: " + this.Id);
            builder.AppendLine("Nome: " + this.Nome);
            builder.AppendLine("Preço: " + this.Preco.ToString("C", CultureInfo.GetCultureInfo("pt-BR")));
            builder.AppendLine("Categoria: " + this.Categoria);

            return builder.ToString();
        }

        public override int GetHashCode()
        {
            return base.GetHashCode();
        }

        public override bool Equals(object obj)
        {
            if(obj.GetType() == typeof(Jogo))
            {
                Jogo jogoComp = (Jogo)obj;

                return this.Id == jogoComp.Id
                    && this.Nome == jogoComp.Nome
                    && this.Preco == jogoComp.Preco
                    && this.Categoria == jogoComp.Categoria
                    && this.ClienteLocacao == jogoComp.ClienteLocacao;
            }

            return false;
        }
    }
}
