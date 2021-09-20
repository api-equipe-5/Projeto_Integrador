create table if not exists tb_doacao(
    id int auto_increment not null primary key,
    nome varchar(40) not null,
    cpf varchar(14) not null,
    tel_number varchar (11) not null,
    celular varchar (11) not null, 
    endereco varchar (40) not null,
    anonimo varchar (10) null

)default charset utf8;

create table if not exists tb_conteudo(
    id int auto_increment not null primary key,
    pagina varchar(255) not null,
    localizacao varchar(255) not null,
    conteudo text not null   

)default charset utf8;
INSERT INTO `tb_conteudo` (`id`, `pagina`, `localizacao`, `conteudo`) VALUES (NULL, 'formulario_doador', 'esquerda', 'Com as doações, o centro tenta proporcionar um elevado nível de educação e oportunidades para o desenvolvimento e criatividade das crianças. De modo a assegurar o dinheiro que nos é fornecido, preparamos um relatório detalhado sobre a utilização de fundos para todos os nossos doadores. Pode também contribuir diretamente, ajudando a pagar as contas de consumo (água, luz e aluguel).');