create database if not exists SharEducaDB;
use SharEducaDB;

create table if not exists Usuario(
id int primary key auto_increment,
nome varchar(200) not null,
email varchar(250) unique not null,
senha varchar(80) not null,
acesso int default 0
);

create table if not exists Conteudo(
id int primary key auto_increment,
nome varchar(200) not null,
descrip varchar(500) default "Sem descrição",
img varchar(80) default "logo.jpeg" #experimental
);

create table if not exists Item(
id int primary key auto_increment,
conteudo int default 0,
nome varchar(250) not null,
tipo varchar(25) not null,
tamanho int not null,
descrip varchar(500) default "Sem descrição",
valor double(5,2) default 0.0,
constraint FK_id_Conteudo_Item foreign key (conteudo) references Conteudo(id)
);#engine = MyISAM;

create table if not exists Carrinho(
id int primary key auto_increment,
usuario int not null,
item int not null,
constraint FK_id_Usuario foreign key (usuario) references Usuario(id),
constraint FK_id_Item foreign key (item) references Item(id)
);

delimiter $$
create procedure add_ItemCarrinho(n_user int, n_item int)
begin
	declare verifica int;
    select count(item) into verifica from Carrinho where 
		usuario = n_user and item = n_item;
    
    if verifica like 0 then
		insert into Carrinho(usuario, item) values (n_user, n_item);
	end if;
end $$
delimiter ;

delimiter $$
create procedure clear_Carrinho(n_user int)
begin
	delete from Carrinho where usuario like n_user limit 500;
end $$
delimiter ;

delimiter $$
create procedure remove_ItemCarrinho(n_user int, n_item int)
begin
	delete from Carrinho 
		where usuario like n_user and
        item like n_item
        limit 1;
end $$
delimiter ;

#----------Testes----------#

select * from Usuario;
select * from Conteudo;
select * from Item;
select * from Carrinho;


truncate table Item;
truncate table Carrinho;

select * from Item where nome like "Exercícios de Inglês - Nível 1.pdf" limit 1;


insert into Item values 
(2,1,"teste","exe",666,"description",10.10);

update Item set conteudo = 1, descrip = "...", valor = 19.90 where nome = "Pontuação.pdf" limit 1;
update Usuario set acesso = 1 where nome like "Leo" limit 1;
select * from Item where nome = "Pontuação.pdf";

select * from Item_Carrinho where carrinho = 1003;
select * from Item where id = 1 or id = 2;

truncate table Usuario;

delete from Item where conteudo = 0;

insert into Conteudo values
(1,"Português","Decrição do conteúdo de Língua Portuguêsa.","lp.jpg"),
(2,"Inglês","Descrição do conteúdo de Inglês.","ing.jpg"),
(3,"Matemática Discreta","Descrição do conteúdo de Matemática Discreta.","math.jpg"),
(4,"Laboratório de Hardware","Descrição do conteúdo de Laboratório de Hardware.","lab-hard.jpg");
