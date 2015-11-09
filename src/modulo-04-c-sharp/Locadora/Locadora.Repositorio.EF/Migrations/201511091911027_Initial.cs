namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;

    public partial class Initial : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Clientes",
                c => new
                {
                    Id = c.Int(nullable: false, identity: true),
                    Nome = c.String(),
                    IdClienteLocacao = c.Int(nullable: false),
                })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.jogo", t => t.IdClienteLocacao)
                .Index(t => t.IdClienteLocacao);

            CreateTable(
                "dbo.jogo",
                c => new
                {
                    Id = c.Int(nullable: false, identity: true),
                    Nome = c.String(nullable: false),
                    Preco = c.Decimal(nullable: false, precision: 18, scale: 2),
                    Categoria = c.Int(nullable: false),
                    Descricao = c.String(nullable: false),
                    Imagem = c.String(),
                    Video = c.String(),
                    Selo = c.Int(nullable: false),
                })
                .PrimaryKey(t => t.Id);

            Sql("CREATE TABLE dbo.Selo(Id INT NOT NULL CONSTRAINT PK_IdSelo PRIMARY KEY,Descricao VARCHAR(50) NOT NULL)");
            Sql("CREATE TABLE dbo.Categoria(Id INT NOT NULL CONSTRAINT PK_IdCategoria PRIMARY KEY,Descricao VARCHAR(250) NOT NULL)");

        }

        public override void Down()
        {
            DropForeignKey("dbo.Clientes", "IdClienteLocacao", "dbo.jogo");
            DropIndex("dbo.Clientes", new[] { "IdClienteLocacao" });
            DropTable("dbo.jogo");
            DropTable("dbo.Clientes");
        }
    }
}
