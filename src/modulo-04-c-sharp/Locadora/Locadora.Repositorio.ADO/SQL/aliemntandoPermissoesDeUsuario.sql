/****** Script for SelectTopNRows command from SSMS  ******/
SELECT TOP 1000 [IdUsuario]
      ,[IdPermissao]
  FROM [LocadoraDeJogos_Code_First].[dbo].[Usuario_Permissao]

  INSERT INTO dbo.usuario_permissao VALUES (1,1);
  INSERT INTO dbo.usuario_permissao VALUES (2,2);