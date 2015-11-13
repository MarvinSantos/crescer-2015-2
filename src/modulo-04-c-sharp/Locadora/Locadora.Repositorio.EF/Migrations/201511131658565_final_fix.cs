namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class final_fix : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.jogo", "DataPrevistaEntrega", c => c.DateTime());
        }
        
        public override void Down()
        {
            DropColumn("dbo.jogo", "DataPrevistaEntrega");
        }
    }
}
