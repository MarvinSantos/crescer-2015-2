using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.EF
{
    public class BancoDeDados : DbContext
    {
        public BancoDeDados() : base("LOCADORA_CODE_FIRST")
        {

        }

        public DbSet<Jogo> Jogo { get; set; }

        public DbSet<Cliente> Cliente { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new JogoMap());

            base.OnModelCreating(modelBuilder);
        }

    }

    class JogoMap : EntityTypeConfiguration<Jogo>
    {
        public JogoMap()
        {
            ToTable("jogo");
            HasKey(p => p.Id);

            Property(p => p.Nome).IsRequired();
            Property(p => p.Preco).IsRequired();
            Property(p => p.Descricao).IsRequired();
            Property(p => p.Imagem).IsOptional();
            Property(p => p.Video).IsOptional();
            Property(p => p.Categoria).IsRequired();
            Property(p => p.Selo).IsRequired();

            HasOptional(p => p.ClienteLocacao).WithRequired().Map(m => m.MapKey("IdClienteLocacao"));

        }
    }

    class ClienteMap : EntityTypeConfiguration<Cliente>
    {
        public ClienteMap()
        {
            ToTable("Cliente");
            HasKey(p => p.Id);

            Property(p => p.Nome).IsRequired();
        }
    }
}
