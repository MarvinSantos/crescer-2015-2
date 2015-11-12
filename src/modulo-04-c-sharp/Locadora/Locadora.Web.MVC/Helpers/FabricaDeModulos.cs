using Locadora.Dominio.Repositorio;
using Locadora.Dominio.Servicos;
using Locadora.Repositorio.EF;
using Locadora.Repositorio.EF.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Locadora.Infraestrutura.Servicos;

namespace Locadora.Web.MVC.Helpers
{
    public class FabricaDeModulos
    {
        public static IJogoRepositorio CriarJogoRepositorio()
        {
            return new JogoRepositorio();
        }

        public static IClienteRepositorio CriarClienteRepositorio()
        {
            return new ClienteRepositorio();
        }

        public static IUsuarioRepositorio CriarUsuarioRepositorio()
        {
            return new UsuarioRepositorio();
        }

        public static IServicoCriptografia CriarServicoCriptografia()
        {
            return new ServicoCriptografia();
        }

        public static ServicoAutenticacaoUsuario CriarServicoAutenticacao()
        {
            return new ServicoAutenticacaoUsuario(CriarUsuarioRepositorio(), CriarServicoCriptografia());
        }

        public static ServicoValidacaoLocacao CriarServicoValidacaoLocacao()
        {
            return new ServicoValidacaoLocacao(CriarJogoRepositorio());
        }

        
    }
}