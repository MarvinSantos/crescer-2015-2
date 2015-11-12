namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class NomeUsuario_TirarPrecoJogo : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Usuario", "Nome", c => c.String(nullable: false, maxLength: 300));
        }
        
        public override void Down()
        {
            DropColumn("dbo.Usuario", "Nome");
        }
    }
}
