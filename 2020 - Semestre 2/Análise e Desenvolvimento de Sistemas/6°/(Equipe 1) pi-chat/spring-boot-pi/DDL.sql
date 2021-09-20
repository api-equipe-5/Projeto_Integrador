/*
mysql -u porps -pfatec2020* -h porpschat.mysql.uhserver.com porpschat

Admin -> {"document":"58478548858","password":"senha123"}
Padrao -> {"document":"987654321541","password":"senha123"}



create database chatbd;
use chatbd;

create user 'usuario'@'localhost' identified by 'pass321';
GRANT ALL PRIVILEGES ON * . * TO 'usuario'@'localhost';
FLUSH PRIVILEGES;


create table tipo_usuario(
	id_tipo_usuario bigint unsigned not null auto_increment,
	nome_tipo_usuario varchar(30) not null,
	primary key (id_tipo_usuario)
);

create table usuario(
	id_usuario bigint unsigned not null auto_increment,
	nome_usuario varchar(30) not null,
	cpf_usuario varchar(20) not null,
	id_tipo_usuario bigint unsigned not null,
	data_criado date,
	primary key (id_usuario),
	unique key uni_cpf (cpf_usuario),
	foreign key fk_tipo_usuario (id_tipo_usuario) references tipo_usuario (id_tipo_usuario)
);

create table arquivos(
	id_arquivo bigint unsigned not null auto_increment,
	nome_arquivo varchar(30) not null,
	id_usuario bigint unsigned not null,
	primary key (id_arquivo),
	foreign key fk_id_usuario (id_usuario) references usuario (id_usuario)
);

create table conversa(
	id_conversa bigint unsigned not null auto_increment,
	data_inicio date,
	data_ultima_conversa date,
	primary key (id_conversa)
);

create table mensagem(
	id_mensagem bigint unsigned not null auto_increment,
	id_conversa bigint unsigned not null,
	id_usuario bigint unsigned not null,
	data_criado date,
	conteudo_mensagem longtext not null,
	primary key (id_mensagem),
	foreign key fk_id_conversa (id_conversa) references conversa (id_conversa),
	foreign key fk_id_usuario (id_usuario) references usuario (id_usuario)
);

create table usuario_conversa(
	id_usuario bigint unsigned not null,
	id_conversa bigint unsigned not null,
    primary key (id_usuario, id_conversa),
	foreign key fk_id_conversa (id_conversa) references conversa (id_conversa),
	foreign key fk_id_usuario (id_usuario) references usuario (id_usuario)
);

insert into tipo_usuario (nome_tipo_usuario) values ('ROLE_ADMIN');
insert into tipo_usuario (nome_tipo_usuario) values ('ROLE_USUARIO');

insert into usuario (nome_usuario, cpf_usuario, id_tipo_usuario, data_criado) values ('Usuario1', '111.111.111-12',1,date(now()));
insert into usuario (nome_usuario, cpf_usuario, id_tipo_usuario, data_criado) values ('Usuario2', '987.654.321-54',2,date(now()));


insert into conversa (data_inicio, data_ultima_conversa) values ('2020-09-21','2020-09-21');
insert into usuario_conversa(id_usuario,id_conversa) values (1,1);
insert into usuario_conversa(id_usuario,id_conversa) values (2,1);

mysql -u porps -pfatec2020* -h porpschat.mysql.uhserver.com

/* INSERTS */

