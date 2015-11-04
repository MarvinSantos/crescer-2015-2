using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Exemplo.Models
{
    public class AnimeModel
    {
        public List<PersonagemModel> Personagens { get; set; }

        public int QuantidadeDePersonagensFodoes
        {
            get
            {
                return Personagens.Count(x => x.Fodao);
            }
        }
    }
}