using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Servicos
{
    public class ServicoAutenticacaoUsuario
    {
        IUsuarioRepositorio Repositorio;

        public ServicoAutenticacaoUsuario(IUsuarioRepositorio repositorio)
        {
            this.Repositorio = repositorio;
        }

        public Usuario AutenticarEBuscar(string email,string senha)
        {
            Usuario usuario = Repositorio.BuscarUsuarioPorEmail(email);

            if(usuario == null)
            {
                return null;
            }
            else
            {
                if(usuario.Senha == senha)
                {
                    return usuario;
                }
                else
                {
                    return null;
                }
            }
        }
    }
}
