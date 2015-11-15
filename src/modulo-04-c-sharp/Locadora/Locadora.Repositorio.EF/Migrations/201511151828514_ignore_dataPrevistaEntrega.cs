namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class ignore_dataPrevistaEntrega : DbMigration
    {
        public override void Up()
        {
            DropColumn("dbo.jogo", "DataPrevistaEntrega");
        }
        
        public override void Down()
        {
            AddColumn("dbo.jogo", "DataPrevistaEntrega", c => c.DateTime());
        }
    }
}
