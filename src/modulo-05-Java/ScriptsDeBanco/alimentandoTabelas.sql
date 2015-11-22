select * from cliente;

insert into cliente(idcliente,nome,cpf,email,endereco,bairro,idcidade,cep,situacao) values(SEQ_Cliente.nextval,'marvin','11111111111','marvincenteno23@gmail.com','rua erico verissimo','sao jose',1,33333333,'A');



select* from cidade;

insert into cidade(idcidade,nome,uf) values(SEQ_Cidade.nextval,'esteio','RS');



select * from servico;

insert into servico(idservico,descricao) values(SEQ_Servico.nextval,'lavagem simples');




select * from material;

insert into material(idmaterial,descricao) values(SEQ_Material.nextval,'sabão em pó');





select * from produto;

insert into produto(idproduto,idservico,idmaterial,valor) values(SEQ_Produto.nextval,1,1,50.5);




select * from pedido;

insert into pedido(idpedido,idcliente,DATAINCLUSAO,DATAENTREGA,valor,SITUACAO) values(SEQ_Pedido.nextval,2,'5-oct-2010' ,'5-oct-2011',51.5,'A');



select * from item;

insert into item(iditem,idpedido,idproduto,peso,valorunitario,VALORDESCONTO,VALORTOTAL,SITUACAO) values(SEQ_Item.nextval,3,1,20.6,100.5,10.5,90,'B');


commit




