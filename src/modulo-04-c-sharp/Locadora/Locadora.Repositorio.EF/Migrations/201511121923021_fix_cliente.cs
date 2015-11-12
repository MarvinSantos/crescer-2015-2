namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class fix_cliente : DbMigration
    {
        public override void Up()
        {
            RenameColumn(table: "dbo.jogo", name: "IdClienteLocacao", newName: "IdCliente");
            RenameIndex(table: "dbo.jogo", name: "IX_IdClienteLocacao", newName: "IX_IdCliente");
        }
        
        public override void Down()
        {
            RenameIndex(table: "dbo.jogo", name: "IX_IdCliente", newName: "IX_IdClienteLocacao");
            RenameColumn(table: "dbo.jogo", name: "IdCliente", newName: "IdClienteLocacao");
        }
    }
}
