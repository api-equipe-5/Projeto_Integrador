create database salao_cabeleireiro;

use salao_cabeleireiro;

create table funcionario(
	id_func integer auto_increment,
    cpf_func varchar(11) not null,
    nome_func varchar(50) not null,
    email_func varchar(100),
    nasc_func date not null,
    cargo_func varchar(25) not null,
    
constraint PK_Id_funcionario primary key (id_func),    
constraint UK_cpf_funcionario unique(cpf_func)
);

create table telef_funcionario(
	id_tel_func integer auto_increment,
    id_func integer not null,
    numero_tel_func varchar(15) not null,
    
constraint PK_Id_telef_funcionario primary key(id_tel_func),
constraint FK_Id_func_telef_funcionario foreign key (id_func) references funcionario(id_func)
);

create table ender_funcionario(
	id_ender_func integer auto_increment,
    id_func integer not null,
    cep_ender_func varchar(10) not null,
    numero_ender_func integer not null,
    complem_ender_func varchar(100),
    
constraint PK_Ender_funcionario primary key(id_ender_func),
constraint FK_Id_func_ender_funcionario foreign key (id_func) references funcionario(id_func),
constraint CK_numero_ender_funcionario check(numero_ender_func>0)
);

create table cliente(
	id_cliente integer auto_increment,
    cpf_cliente varchar(11) not null,
    nome_cliente varchar(50) not null,
    email_cliente varchar(100),
    nasc_cliente date not null,
    ponto_cliente smallint not null default 0,
    
constraint PK_Id_cliente primary key(id_cliente),
constraint UK_cpf_cliente unique(cpf_cliente)
);

create table telef_cliente(
	id_tel_cli integer auto_increment,
    id_cliente integer not null,
    numero_tel_cli varchar(15) not null,
    
constraint PK_Id_telef_cliente primary key(id_tel_cli),
constraint FK_Id_cliente_telef_cliente foreign key(id_cliente) references cliente(id_cliente)
);

create table ender_cliente(
	id_ender_cli integer auto_increment,
    id_cliente integer not null,
    cep_ender_cli varchar(10) not null,
    numero_ender_cli  integer not null,
    complem_ender_cli varchar(100),
    
constraint PK_Id_ender_cliente primary key(id_ender_cli),
constraint FK_Id_cliente_ender_cliente foreign key(id_cliente) references cliente(id_cliente),
constraint CK_numero_ender_cliente check(numero_ender_cli>0)
);

create table servico(
	id_servico integer auto_increment,
    nome_servico varchar(50) not null,
    descr_servico varchar(255) not null,
    preco_servico decimal(6,2) not null,
    tempoDura_servico varchar(20) not null,
    
constraint PK_Id_servico primary key(id_servico),
constraint CK_preco_servico check(preco_servico>0)
);

create table agenda(
	id_agenda integer auto_increment,
    data_agenda date not null,

constraint PK_Id_agenda primary key(id_agenda),
constraint UK_data_agenda unique(data_agenda)
);

create table agendamento(
	id_agendamento integer auto_increment,
    id_cliente integer not null,
    id_servico integer not null,
    id_agenda integer not null,
    horaMarcada_agendamento time not null,
    
constraint PK_Id_agendamento primary key(id_agendamento),
constraint FK_Id_cliente_agendamento foreign key(id_cliente) references cliente(id_cliente),
constraint FK_Id_servico_agendamento foreign key(id_servico) references servico(id_servico),
constraint FK_Id_agenda_agendamento foreign key(id_agenda) references agenda(id_agenda)
);
    

    
    