create schema chatbot_helpdesk;

use chatbot_helpdesk;

create user 'user'@'localhost' identified by 'pass123';

grant select, insert, delete, update on chatbot_helpdesk.* to user@'localhost';

create table usr_usuario (
  usr_id bigint unsigned not null auto_increment,
  usr_nome varchar(20) not null,
  usr_senha varchar(50) not null,
  usr_avatar varchar(255) not null,
  primary key (usr_id),
  unique key uni_usuario_nome (usr_nome)
);

create table aut_autorizacao (
  aut_id bigint unsigned not null auto_increment,
  aut_nome varchar(20) not null,
  primary key (aut_id),
  unique key uni_aut_nome (aut_nome)
);

create table uau_usuario_autorizacao (
  usr_id bigint unsigned not null,
  aut_id bigint unsigned not null,
  primary key (usr_id, aut_id),
  foreign key aut_usuario_fk (usr_id) references usr_usuario (usr_id) on delete restrict on update cascade,
  foreign key aut_autorizacao_fk (aut_id) references aut_autorizacao (aut_id) on delete restrict on update cascade
);

create table usr_atividades (
  atv_id bigint unsigned not null auto_increment,
  atv_remetente_id bigint unsigned not null,
  atv_destinatario_id bigint unsigned not null,
  atv_titulo varchar(20) not null,
  atv_data_disparo date not null,
  atv_data_limite date not null,
  atv_data_conclusao date,
  atv_status int not null,
  atv_conteudo varchar(255) not null,
  primary key (atv_id),
  foreign key (atv_remetente_id) references usr_usuario (usr_id) on delete restrict on update cascade,
  foreign key (atv_destinatario_id) references usr_usuario (usr_id) on delete restrict on update cascade
);


create table conversas (
  chat_id bigint unsigned not null auto_increment,
  primary key (chat_id)
);

create table usuarios_conversas(
  chat_id bigint unsigned not null,
  usr_id bigint unsigned not null,
  primary key (chat_id, usr_id),
  foreign key chat_id_fk (chat_id) references conversas (chat_id) on delete restrict on update cascade,
  foreign key usr_id_fk (usr_id) references usr_usuario (usr_id) on delete restrict on update cascade
);

create table mensagens(
  mensagem_id bigint unsigned not null auto_increment,
  chat_id bigint unsigned not null,
  destinatario bigint unsigned not null,
  data_hora varchar(20) not null,
  conteudo varchar(255) not null,
  primary key (mensagem_id),
  foreign key chat_id_fk (chat_id) references conversas (chat_id) on delete restrict on update cascade,
  foreign key destinatario_fk (destinatario) references usr_usuario (usr_id) on delete restrict on update cascade
);

create table usuarios_mensagens(
  mensagem_id bigint unsigned not null,
  usr_id bigint unsigned not null,
  primary key (mensagem_id, usr_id),
  foreign key mensagem_id_fk (mensagem_id) references mensagens (mensagem_id) on delete restrict on update cascade,
  foreign key usr_id_fk (usr_id) references usr_usuario (usr_id) on delete restrict on update cascade
);

insert into usr_usuario (usr_nome, usr_senha, usr_avatar) values('Fabiola', '12345', 'base64 image');
insert into usr_usuario (usr_nome, usr_senha, usr_avatar) values('Arthur', '12342345', 'base64 image');
insert into aut_autorizacao (aut_nome)
    values('ROLE_ADMIN');
insert into uau_usuario_autorizacao values (1, 1);
insert into usr_notificacoes  values (1, 1, 'Teste 2', 'Teste teste teste tet',2);
-- INSERT INTO `conversas` (`chat_id`, `origem`, `conteudo`, `status`, `data`, `inicio`, `final`, `participante1_id`, `participante2_id`) VALUES
-- (1, 'cliente', 'string json', 1, '2020-09-20', '21:36:02', '21:36:02', 1, 2),
-- (3, 'cliente', 'string json', 0, '2020-09-20', '21:52:11', '21:52:11', 1, 2),
-- (4, 'cliente', 'string json', 0, '2020-09-20', '21:52:11', '21:52:11', 1, 2),
-- (5, 'painel', 'string json', 0, '2020-09-20', '21:52:11', '21:52:11', 1, 2);