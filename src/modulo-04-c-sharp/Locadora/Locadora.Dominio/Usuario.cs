using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public class Usuario : EntidadeBase
    {
        
        public String Email { get; set; }
      
        public String Senha { get; set; }

        public ICollection<Permissao> Permissoes { get; set; }
    }
}
