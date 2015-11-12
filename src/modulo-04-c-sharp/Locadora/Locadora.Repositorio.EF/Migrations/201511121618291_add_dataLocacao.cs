namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class add_dataLocacao : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.jogo", "DataLocacao", c => c.DateTime());
        }
        
        public override void Down()
        {
            DropColumn("dbo.jogo", "DataLocacao");
        }
    }
}
