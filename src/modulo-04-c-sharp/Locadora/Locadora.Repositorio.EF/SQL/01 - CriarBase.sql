CREATE TABLE dbo.Categoria
(    
    Id               INT             NOT NULL CONSTRAINT PK_IdCategoria PRIMARY KEY,
    Descricao        VARCHAR(250)    NOT NULL
)

CREATE TABLE dbo.Cliente
(    
    Id              INT             NOT NULL CONSTRAINT PK_IdCliente PRIMARY KEY,
    Nome            VARCHAR(250)    NOT NULL
)

CREATE TABLE dbo.Selo
(    
    Id               INT            NOT NULL CONSTRAINT PK_IdSelo PRIMARY KEY,
    Descricao        VARCHAR(50)    NOT NULL
)

CREATE TABLE dbo.Jogo
(    
    Id               INT IDENTITY (1,1)		NOT NULL CONSTRAINT PK_IdJogo PRIMARY KEY,
    Nome             VARCHAR(250)			NOT NULL,
    Preco            DECIMAL(19,2)			NOT NULL,
    IdCategoria      INT					NOT NULL CONSTRAINT FK_IdCategoria FOREIGN KEY REFERENCES Categoria(Id),
    IdClienteLocacao INT					NULL CONSTRAINT FK_IdClienteLocacao FOREIGN KEY REFERENCES Cliente(Id),
	Descricao        varchar(300)           not null,
	IdSelo           INT                    not NULL CONSTRAINT FK_IdSelo FOREIGN KEY REFERENCES Selo(Id),
	Imagem           varchar(600)           null,
	Video            varchar(600)           null
)