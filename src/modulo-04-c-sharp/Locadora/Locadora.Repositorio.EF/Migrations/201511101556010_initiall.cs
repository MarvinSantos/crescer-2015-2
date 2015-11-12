namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class initiall : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Cliente",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(nullable: false),
                    })
                .PrimaryKey(t => t.Id);


            CreateTable(
                "dbo.Selo",
                c => new
                {
                    Id = c.Int(nullable: false, identity: false),
                    Nome = c.String(nullable: false),
                })
                .PrimaryKey(t => t.Id);


            CreateTable(
                "dbo.Categoria",
                c => new
                {
                    Id = c.Int(nullable: false, identity: false),
                    Nome = c.String(nullable: false),
                })
                .PrimaryKey(t => t.Id);

            CreateTable(
                "dbo.jogo",
                c => new
                {
                    Id = c.Int(nullable: false, identity: true),
                    Nome = c.String(nullable: false),
                    Categoria = c.Int(nullable: false),
                    Descricao = c.String(nullable: false),
                    Imagem = c.String(),
                    Video = c.String(),
                    Selo = c.Int(nullable: false),
                    IdClienteLocacao = c.Int(),
                })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Cliente", t => t.IdClienteLocacao)
                .ForeignKey("dbo.Selo", t => t.Selo)
                .ForeignKey("dbo.Categoria", t => t.Categoria)
                .Index(t => t.Categoria)
                .Index(t => t.Selo)
                .Index(t => t.IdClienteLocacao);

        }

        

    public override void Down()
        {
            DropForeignKey("dbo.jogo", "IdClienteLocacao", "dbo.Cliente");
            DropIndex("dbo.jogo", new[] { "IdClienteLocacao" });
            DropTable("dbo.jogo");
            DropTable("dbo.Cliente");
        }
    }
}
