﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Repositorio
{
    public interface IUsuarioRepositorio
    {
        Usuario BuscarUsuarioPorEmail(string email);
    }
}