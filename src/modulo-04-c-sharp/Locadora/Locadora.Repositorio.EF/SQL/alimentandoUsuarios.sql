/****** Script for SelectTopNRows command from SSMS  ******/
SELECT TOP 1000 [Id]
      ,[Email]
      ,[Senha]
	  ,[Nome]
  FROM [LocadoraDeJogos_Code_First].[dbo].[Usuario]

  INSERT INTO dbo.usuario VALUES ('marvin@gmail.com','501C3E9279882FFB776A1D1E506D0410','Marvin Santos');
  INSERT INTO dbo.usuario VALUES ('anaOperadora@gmail.com','983ED4D51DFDA04C6690F2A987FBCA55','Ana Julia');