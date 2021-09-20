create table if not exists tb_participantes(
    id int auto_increment not null primary key,
    nome varchar(40) not null,
    nome_pai varchar (40),
    nascimento varchar (11) not null,
    nome_mae varchar (40) not null,
    cpf varchar(14) not null,
    tel_number varchar (11),
    celular varchar (11) not null, 
    email varchar (40) not null,
    redesocial varchar (12) null,
    youtube varchar (10) null,
    outros varchar (10) null,
    especifique varchar (80)

)default charset utf8;


create table if not exists tb_conteudo(
    id int auto_increment not null primary key,
    pagina varchar(255) not null,
    localizacao varchar(255) not null,
    conteudo text not null   

)default charset utf8;
INSERT INTO `tb_conteudo` (`id`, `pagina`, `localizacao`, `conteudo`) VALUES (NULL, 'cadastro_participantes', 'centro', 'Bem-vindo, a pré-inscrição online possibilita ao futuro estudante solicitar uma vaga para o ano vigente. Primeiramente solicitamos que preencha os campos abaixo. Esses dados serão usados para chegarmos até você.\r\n\r\nA sua pré-inscrição será realizada de modo on-line e será analisada, e entraremos em contato caso tenha vaga');