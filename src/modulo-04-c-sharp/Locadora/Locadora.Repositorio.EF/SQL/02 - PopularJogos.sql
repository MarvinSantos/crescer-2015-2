INSERT INTO dbo.Categoria VALUES (1, 'RPG')
INSERT INTO dbo.Categoria VALUES (2, 'Corrida')
INSERT INTO dbo.Categoria VALUES (3, 'Aventura')
INSERT INTO dbo.Categoria VALUES (4, 'Luta')
INSERT INTO dbo.Categoria VALUES (5, 'Esporte')


INSERT INTO dbo.Selo VALUES (1, 'Ouro')
INSERT INTO dbo.Selo VALUES (2, 'Prata')
INSERT INTO dbo.Selo VALUES (3, 'Bronze')


INSERT INTO dbo.Jogo VALUES ('Chrono Trigger',1,'é um jogo de magia e aventura',null,null,1, null,null)
INSERT INTO dbo.Jogo VALUES ('Top Gear',2,'é um jogo de corrida com muitas fases',null,null,1,null,null)
INSERT INTO dbo.Jogo VALUES ('Megaman X',3,'é um jogo de aventura de um robo',null,null,1,null,null)
INSERT INTO dbo.Jogo VALUES ('Super Metroid',3,'é um jogo de luta de um robo inteligente',null,null,3,null,null)
INSERT INTO dbo.Jogo VALUES ('Donkey Kong Country',3,'é um jogo de aventura onde dois macacos passam fases',null,null,2,null,null)
INSERT INTO dbo.Jogo VALUES ('Super Mario Kart',2,'é o mario em estilo corrida, da pra atirar tartaruga',null,null,2,null,null)
INSERT INTO dbo.Jogo VALUES ('Super Street Fighter',4,'é um jogo de luta entre pessoas normais',null,null,1,null,null)
INSERT INTO dbo.Jogo VALUES ('Mortal Kombat 2',4,'é um jogo de luta entre pessoas com super poderes',null,null,3,null,null)
INSERT INTO dbo.Jogo VALUES ('Killer Instinct',4,'é um jogo de assasinos',null,null,2,null,null)
INSERT INTO dbo.Jogo VALUES ('Final Fight',3,'é um jogo de luta com fases',null,null,1,null,null)
INSERT INTO dbo.Jogo VALUES ('Super Mario 1',1,'é um jogo de fases onde o encanador deve resgatar a princesa','https://upload.wikimedia.org/wikipedia/pt/0/06/Super-Mario-World.jpg','<iframe width="420" height="315" src="https://www.youtube.com/embed/_sb6-RjnOUc" frameborder="0" allowfullscreen></iframe>',2,null,null)
INSERT INTO dbo.Jogo VALUES ('Aladdin',3,'é um jogo de aventura onde o personagem tem um genio e um macaco',null,null,2,null,null)
INSERT INTO dbo.Jogo VALUES ('Rock ''n Roll Racing',2,'é um jogo de corrida com rock n''roll',null,null,1,null,null)
INSERT INTO dbo.Jogo VALUES ('Zelda: A link to the past',3,'é um jogo de aventura onde o link tem que resgatar a zelda',null,null,1,null,null)
INSERT INTO dbo.Jogo VALUES ('Final Fantasy VI',1,'é um jogo de magia com fases',null,null,2,null,null)
INSERT INTO dbo.Jogo VALUES ('International Super Star Soccer Deluxe',5,'é um jogo que simula fotebol',null,null,1,null,null)
INSERT INTO dbo.Jogo VALUES ('Contra III',3,'é um jogo de guerra contra aliens',null,null,3,null,null)
INSERT INTO dbo.Jogo VALUES ('Sunset Riders',3,'é um jogo de corrida de motos',null,null,2,null,null)
INSERT INTO dbo.Jogo VALUES ('Goof Troop',3,'é um jogo de fases do pateta e max',null,null,1,null,null)
INSERT INTO dbo.Jogo VALUES ('Mickey to Donald: Magical Adventure 3',3,'é um jogo de aventura que tem fases',null,null,3,null,null)

select * from jogo