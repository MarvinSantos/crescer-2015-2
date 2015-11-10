using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class ManterJogoModel
    {
        [Required]
        public string Nome { get; set; }

        [Required]
        [Range(1, int.MaxValue, ErrorMessage = "Selecione uma Categoria")]
        public Categoria Categoria { get; set; }

        [Required]
        [DisplayName("Preço")]
        public decimal Preco { get; set; }

        public int? Id { get; set; }

        [Required]
        [DisplayName("Descrição")]
        public string Descricao { get; set; }

        [DisplayName("Url da imagem")]
        public string Imagem { get; set; }

        [DisplayName("Url do video")]
        public string Video { get; set; }

        [Required]
        [Range(1, int.MaxValue, ErrorMessage = "Selecione um Selo")]
        public Selo Selo { get; set; }
    }
}