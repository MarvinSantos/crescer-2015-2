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

        public DbSet<Permissao> Permissao { get; set; }

        public DbSet<Usuario> Usuario { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            
            modelBuilder.Configurations.Add(new JogoMap());
            modelBuilder.Configurations.Add(new ClienteMap());
            modelBuilder.Configurations.Add(new UsuarioMap());
            modelBuilder.Configurations.Add(new PermissaoMap());

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
            Property(p => p.Descricao).IsRequired();
            Property(p => p.Imagem).IsOptional();
            Property(p => p.Video).IsOptional();
            Property(p => p.Categoria).IsRequired();
            Property(p => p.Selo).IsRequired();

            HasOptional(p => p.ClienteLocacao).WithOptionalDependent().Map(m => m.MapKey("IdClienteLocacao"));

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

    class UsuarioMap : EntityTypeConfiguration<Usuario>
    {
        public UsuarioMap()
        {
            ToTable("Usuario");
            HasKey(p => p.Id);

            Property(p => p.Email).IsRequired().HasMaxLength(100);
            Property(p => p.Senha).IsRequired().HasMaxLength(256);
            Property(p => p.Nome).IsRequired().HasMaxLength(300);
            
            HasMany(u => u.Permissoes).WithMany(p => p.Usuarios)
                                      .Map(m =>
                                      {
                                          m.ToTable("Usuario_Permissao");
                                          m.MapLeftKey("IdUsuario");
                                          m.MapRightKey("IdPermissao");
                                      });
        }
    }

    class PermissaoMap : EntityTypeConfiguration<Permissao>
    {
        public PermissaoMap()
        {
            ToTable("Permicao");

            HasKey(p => p.Id);

            Property(p => p.Nome).IsRequired().HasMaxLength(50);
        }
    }
}
