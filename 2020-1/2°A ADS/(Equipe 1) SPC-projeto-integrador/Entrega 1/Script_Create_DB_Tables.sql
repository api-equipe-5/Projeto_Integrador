create database SPC_DB
default collate utf8_general_ci
default character set utf8;

use SPC_DB;


create table fonte(
id_fonte int(10) primary key,
cnpj varchar(250),
complemento_cnpj varchar(250),
nome_comercial varchar(250),
razao_social varchar(250),
data_entrada_dbo varchar(250)
) default charset = utf8;

desc fonte;

select * from fonte;

drop table fonte;



create table modalidade(
id_modalidade int(10) primary key,
cod_modalidade varchar(250),
desc_modalidade varchar(250),
data_entrada_dbo varchar(250)
) default charset = utf8;

desc modalidade;

select * from modalidade;

drop table modalidade;



create table movimento(
id_movimento int(10) primary key,
saldo_utilizado varchar(250),
valor_total varchar(250),
valor_minimo varchar(250),
valor_parcelado varchar(250),
quant_cli_cad_pos varchar(250),
quant_mvt varchar(250),
tipo_cliente varchar(250),
id_fonte varchar(250),
cod_modalidade varchar(250),
data_ult_alteracao date,
data_entrada_dbo varchar(250),
foreign key (id_fonte) references fonte(id_fonte),
foreign key (cod_modalidade) references modalidade(cod_modalidade)
) default charset = utf8;

desc movimento;

select * from movimento;

drop table movimento;



create table operacao(
id_registro_base int(10) primary key,
valor_total_contrato varchar(250),
quant_parcelas_contratadas varchar(250),
valor_ainda_não_pago varchar(250),
quant_cli_cad_pos varchar(250),
quant_opr varchar(250),
id_fonte int(10),
cod_modalidade varchar(250),
tipo_cliente enum("F", "J"),
data_ult_alteracao date,
data_entrada_dbo varchar(250),
foreign key (id_fonte) references fonte(id_fonte),
foreign key (cod_modalidade) references modalidade(cod_modalidade)
) default charset = utf8;

desc operacao;

select * from operacao;

drop table operacao;



create table pagamento(
id_pagamento int(10) primary key,
valor_pago varchar(250),
data_vencimento date,
cod_modalidade varchar(250),
quant_cli_cad_pos varchar(250),
quant_pgt varchar(250),
id_fonte int(10),
tipo_cliente varchar(250),
data_ult_alteracao date,
data_entrada_dbo varchar(250),
foreign key (id_fonte) references fonte(id_fonte),
foreign key (cod_modalidade) references modalidade(cod_modalidade)
) default charset = utf8;

desc pagamento;

select * from pagamento;

drop table pagamento;



