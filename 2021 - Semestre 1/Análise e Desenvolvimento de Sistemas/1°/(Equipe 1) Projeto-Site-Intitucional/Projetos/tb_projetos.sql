create table if not exists tb_projetos(
    id int auto_increment not null primary key,
    nome_empreendedor varchar(40) not null,
    nome_empresa varchar(40) not null,
    cpf varchar(14) not null,
    email varchar (40) not null,
    tel_number varchar (11),
    celular varchar (11) not null, 
    cidade varchar (40) not null,
    estado varchar (40) not null,
    fisica_juridica varchar (10) null,
    redesocial varchar (12) null,
    youtube varchar (10) null,
    outros varchar (10) null,
    descricao varchar (230) not null

)default charset utf8;

create table if not exists tb_conteudo(
    id int auto_increment not null primary key,
    pagina varchar(255) not null,
    localizacao varchar(255) not null,
    conteudo text not null   

)default charset utf8;

INSERT INTO `tb_conteudo` (`id`, `pagina`, `localizacao`, `conteudo`) VALUES (NULL, 'projetos', 'esquerda', '                    Lorem ipsum dolor sit, amet consectetur adipisicing elit. Maxime velit iure quia rerum sunt placeat veritatis ab nulla blanditiis inventore similique autem sequi a nemo unde qui aut, officiis dolores?Lorem ipsum dolor sit amet consectetur adipisicing elit. Libero neque vel harum in nobis molestiae adipisci culpa cum voluptatem minima iusto ullam voluptates laudantium doloremque tempore saepe, a perspiciatis? At.\r\n                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Quia deserunt dignissimos nulla eos facilis saepe incidunt commodi ex autem. Rerum, deserunt odio reiciendis nisi magni sequi non ex fugit voluptas.');