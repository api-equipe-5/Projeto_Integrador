create table if not exists tb_contato(
    id int auto_increment not null primary key,
    nome varchar(40) not null,
    celular varchar (11) not null, 
    email varchar (40) not null,
    descriçao varchar (230) not null
)default charset utf8;

create table if not exists tb_conteudo(
    id int auto_increment not null primary key,
    pagina varchar(255) not null,
    localizacao varchar(255) not null,
    conteudo text not null   

)default charset utf8;

INSERT INTO `tb_conteudo` (`id`, `pagina`, `localizacao`, `conteudo`) VALUES (NULL, 'Contato2', 'esquerda', 'TELEFONE: (12) 3966-2823 E-MAIL: administracao@aamu.org.br FACEBOOK: CECOI VÓ MARIA FÉLIX Horário de Segunda a Sexta das 07:00h ás 17:00h');