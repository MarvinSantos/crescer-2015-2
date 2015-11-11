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
        
        private IServicoCriptografia ServicoCriptografia;
        private IUsuarioRepositorio Repositorio;

        public ServicoAutenticacaoUsuario(IUsuarioRepositorio repositorio, IServicoCriptografia servicoCriptografia)
        {
            this.Repositorio = repositorio;
            this.ServicoCriptografia = servicoCriptografia;
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
                string senhaCriptografada = ServicoCriptografia.CriptografarSenha(senha);

                if (usuario.Senha == senha)
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
