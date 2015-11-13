using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Servicos
{
    public class ServicoDeValidacaoPreco
    {
        public decimal CalcularPreco(Jogo jogo)
        {
            decimal precoFinal = 0.00m;

            if(jogo.DataLocacao != null && jogo.DataPrevistaEntrega != null)
            {
                TimeSpan? diasAtrasados = DateTime.Now - jogo.DataPrevistaEntrega;
                TimeSpan diasAtrasados2 = (TimeSpan)diasAtrasados;
                int dias = diasAtrasados2.Days;
                for(var i = 0; i< dias; i++)
                {
                    precoFinal += 5.00m;
                }

            }

            return precoFinal;
           
        }
    }
}
