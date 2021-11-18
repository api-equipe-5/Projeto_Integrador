
-- executar linhas 4 , 5 , 14 , 26 , 36 e 44 

create database meuBanco;  -- *** 1º executar  *** 
use meuBanco;  -- *** 2º executar *** 
-- -----------------------------------------------------------
/* em caso de erro => */ drop database meuBanco;
-- ----------------------------------------------------------
/* em caso de erro => */ drop table cadastro_cliente;
-- ----------------------------------------------------------
-- 
 -- *** 3º executar *** 

create table cadastro_cliente -- 3) cria a tabela que vai conter os dados do cliente
	(
        nome varchar (20) not null,
		cpf int  (20) not null primary key,
        email varchar (50) not null,
        funcionario_check varchar (3) not null, -- preenche 'sim' ou 'nao' conforme formulario
		curriculo_id int(11) auto_increment,
        foreign key (curriculo_id) references curriculo (curriculo_id) on delete restrict -- importando chave da tabela curriculo 
        );
-- ------------------------------------------------------------       
 -- *** 4 º executar *** 
 
CREATE TABLE curriculo (  -- cria tabela que vai conter os dados do curriculo 
  curriculo_id int(11) primary key auto_increment ,
  arquivo_nome varchar(50) DEFAULT NULL,
  arquivo_conteudo longblob,
  arquivo_tipo varchar(50) DEFAULT NULL
);
-- -----------------------------------------------------------------------------------------------------

-- 5  º executar 

create table adminUser ( 
id_adminUser int (3) auto_increment primary key,
usuario varchar (20) not null,
senha varchar (20) not null
);

-- 6º executar (insere usuario e senha do admin) 

insert into adminUser (usuario,senha) values ("admin","admin");

-- -----------------------------------------------------------------------------------------------------




-- DAQUI PARA BAIXO AINDA EM DESENVOLVIMENTO 
--             ||
--              v

create table vagas (  -- cria tabela que vai conter as dados das vagas (e quem esta interessado nela) 
	id_vaga int (11) auto_increment key,
    descricao varchar (100) not null
);

insert into vagas(descricao) values("Programador");
insert into vagas(descricao) values("Designer");


create table VagasXinteressados (
	id_vXi int (4) auto_increment primary key,
    id_vaga int (11) not null,
    cpf int (11) not null,
    foreign key(cpf) references cadastro_cliente(cpf) on delete restrict,
    foreign key(id_vaga) references vagas(id_vaga) on delete restrict
); 
-- --------------------------------------------------------------------------------------------------------
select * from VagasXinteressados where id_vaga = 2;
select count(*) from VagasXinteressados where id_vaga = 1;

select * from cadastro_cliente;  -- exibe todas as informações da tabela de clientes
select * from curriculo; -- exibe todas as informações da tabela curriculo. 
-- -------------------------------------------------------------
-- INNER JOIN para buscar os dados nas duas tabelas (cadastro x curriculo) e juntar as informações. 
select F.curriculo_id, F.nome, F.cpf, F.email,F.funcionario_check, D.arquivo_nome from cadastro_cliente F INNER JOIN curriculo D on F.curriculo_id = D.curriculo_id where F.cpf = 3;

 select count(*)from VagasXInteressados;  -- exibe o numero TOTAL de pessoas que estão interessados em vagas 