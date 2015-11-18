/*
create table cliente(
    idCliente number(10) primary key,
    nmCliente varchar2(50),
    nrCpf varchar2(11)
);

create table servico (
    idServico number(10) primary key,
    dsServico varchar2(50)
);
*/

select * from cliente
create sequence cliente_seq;

/*create table pedido(
    idpedido number(10) primary key,
       idcliente number(10) not null,
    dsPedido varchar2(200)
);
alter table pedido add constraint PED_CLI_FK foreign key(idcliente) references cliente(idcliente);
create index PED_CLI_FK on pedido(idcliente);

create sequence pedido_seq;*/

select * from pedido