namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Permisao_Usuario : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Permicao",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(nullable: false, maxLength: 50),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Usuario",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Email = c.String(nullable: false, maxLength: 100),
                        Senha = c.String(nullable: false, maxLength: 256),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Usuario_Permissao",
                c => new
                    {
                        IdUsuario = c.Int(nullable: false),
                        IdPermissao = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.IdUsuario, t.IdPermissao })
                .ForeignKey("dbo.Usuario", t => t.IdUsuario, cascadeDelete: true)
                .ForeignKey("dbo.Permicao", t => t.IdPermissao, cascadeDelete: true)
                .Index(t => t.IdUsuario)
                .Index(t => t.IdPermissao);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Usuario_Permissao", "IdPermissao", "dbo.Permicao");
            DropForeignKey("dbo.Usuario_Permissao", "IdUsuario", "dbo.Usuario");
            DropIndex("dbo.Usuario_Permissao", new[] { "IdPermissao" });
            DropIndex("dbo.Usuario_Permissao", new[] { "IdUsuario" });
            DropTable("dbo.Usuario_Permissao");
            DropTable("dbo.Usuario");
            DropTable("dbo.Permicao");
        }
    }
}
