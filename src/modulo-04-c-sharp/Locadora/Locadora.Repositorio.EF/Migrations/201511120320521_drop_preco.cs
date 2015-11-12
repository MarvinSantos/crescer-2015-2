namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class drop_preco : DbMigration
    {
        public override void Up()
        {
            //DropColumn("dbo.jogo", "Preco");
        }
        
        public override void Down()
        {
           // AddColumn("dbo.jogo", "Preco", c => c.Decimal(nullable: false, precision: 18, scale: 2));
        }
    }
}
