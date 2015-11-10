namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class ajuste : DbMigration
    {
        public override void Up()
        {
            RenameTable(name: "dbo.Clientes", newName: "Cliente");
            DropIndex("dbo.Cliente", new[] { "IdClienteLocacao" });
            AddColumn("dbo.jogo", "IdClienteLocacao", c => c.Int());
            AlterColumn("dbo.Cliente", "Nome", c => c.String(nullable: false));
            CreateIndex("dbo.jogo", "IdClienteLocacao");
            DropColumn("dbo.Cliente", "IdClienteLocacao");
        }
        
        public override void Down()
        {
            AddColumn("dbo.Cliente", "IdClienteLocacao", c => c.Int(nullable: false));
            DropIndex("dbo.jogo", new[] { "IdClienteLocacao" });
            AlterColumn("dbo.Cliente", "Nome", c => c.String());
            DropColumn("dbo.jogo", "IdClienteLocacao");
            CreateIndex("dbo.Cliente", "IdClienteLocacao");
            RenameTable(name: "dbo.Cliente", newName: "Clientes");
        }
    }
}
