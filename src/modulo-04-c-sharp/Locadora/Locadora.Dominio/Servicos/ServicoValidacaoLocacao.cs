using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Servicos
{
    public class ServicoValidacaoLocacao
    {

        private IJogoRepositorio Repositorio;
       

        public ServicoValidacaoLocacao(IJogoRepositorio repositorio)
        {
            this.Repositorio = repositorio;
            
        }

        public bool ValidarLocacaoParaCliente(Cliente cliente)
        {
            bool podeLocar;

            int quantidadeJogosLocados = Repositorio.BuscarNumeroDeJogosLocados(cliente);

            if(quantidadeJogosLocados >= 3)
            {
                podeLocar = false;
                return podeLocar;
            }
            else
            {
                podeLocar = true;
                return podeLocar;
            }
        }
    }
}
