/****** Script for SelectTopNRows command from SSMS  ******/
SELECT TOP 1000 [Id]
      ,[Nome]
  FROM [LocadoraDeJogos_Code_First].[dbo].[Cliente]

INSERT INTO dbo.Cliente VALUES ('Monkey D. Luffy')
INSERT INTO dbo.Cliente VALUES ('Portgas D. Ace')
INSERT INTO dbo.Cliente VALUES ('Tralfagar D. Water Law')
INSERT INTO dbo.Cliente VALUES ('Nami Swan')
INSERT INTO dbo.Cliente VALUES ('Tony Tony Chopper')