/****** Script for SelectTopNRows command from SSMS  ******/
SELECT TOP 1000 [Id]
      ,[Email]
      ,[Senha]
  FROM [LocadoraDeJogos_Code_First].[dbo].[Usuario]

  INSERT INTO dbo.usuario VALUES ('joao@gmail.com','123456789');
  INSERT INTO dbo.usuario VALUES ('ana@gmail.com','987654321');