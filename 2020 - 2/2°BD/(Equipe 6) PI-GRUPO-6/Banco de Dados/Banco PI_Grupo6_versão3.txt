# Criando o Banco de dados:
create database pi_grupo6
default character set utf8
default collate utf8_general_ci;

# Selecionando o Banco de dados:
use pi_grupo6;

# Criando a tabela Usuário:
create table usuario(
id_user int not null auto_increment,
nome_user varchar(40) not null,
cpf_user varchar(11) not null,
login_user varchar(20) not null,
senha_user varchar(20) not null,
tipo_user varchar(20) not null,
primary key(id_user)
) default charset = utf8;

# Criando o usuário administrador:
insert into usuario(nome_user, cpf_user, login_user, senha_user, tipo_user)
values('Administrador', '00000000000', 'Admin', 'admin', 'Administrador');

# Criando a tabela Cliente:
create table cliente(
id_cli int not null auto_increment,
nome_cli varchar(40) not null,
cpf_cnpj_cli varchar(14) not null,
rua_cli varchar(40) not null,
numero_cli int not null,
complemento_cli varchar(20),
bairro_cli varchar(20) not null,
cidade_cli varchar(20) not null,
estado_cli char(2) not null,
cep_cli int not null,
telefone_cli varchar(12),
primary key(id_cli)
) default charset = utf8;

#Criando a tabela conta de Luz:
create table conta(
id_conta int not null auto_increment,
id_cliente_conta int not null
references cliente(id_cli),
cod_identif_conta int,
grupo_subgrupo_conta varchar(10),
tpfornecimento_conta varchar(15),
modtarifaria_conta varchar(15),
rotleitura_conta varchar(20),
codfiscal_conta varchar(10),
classe_subclasse_conta varchar(20),
tensaonominal_conta varchar(15),
medidor_conta int,
id_clienteconsumo_conta int not null
references cliente(id_cli),
valortotal_conta float,
numeroinstalacao_conta int,
consumo_conta int,
datavenc_conta date,
contames_conta varchar(20),
bandtarifárias varchar(300),
emissao_conta date,
leituraanterior_conta date,
leituraatual_conta date,
prevproxleit_conta date,
diasfatura_conta int,
avisos_conta varchar(150),
leit_ant_conta float,
leit_atual_conta float,
const_mult_conta float,

tipoligacao_conta varchar(20),
hidrometro_conta varchar(20),
tipofaturamento_conta varchar(20),
periodoconsumo_conta varchar(20),
agua_conta float,
esgoto_conta float,

segmento_conta varchar(20),
diasconsumo_conta int,
tipomedidor_conta varchar(20),
numeromedidor_conta varchar(20),
consumocorrigido_conta int,

primary key(id_conta)
)default charset = utf8;

# Verificando as tabelas criadas:
select * from usuario;
select * from cliente;
select * from conta;