create table if not exists tb_conteudo(
    id int auto_increment not null primary key,
    pagina varchar(255) not null,
    localizacao varchar(255) not null,
    conteudo text not null   

)default charset utf8;

INSERT INTO `tb_conteudo` (`id`, `pagina`, `localizacao`, `conteudo`) VALUES (NULL, 'sobre', 'direita_missao', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptates eum praesentium est. Ab tempore reiciendis ducimus illum minima ipsa consequatur laborum quod, nihil aliquam deserunt nisi atque, veniam esse enim.'), (NULL, 'sobre', 'direita_visao', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptates eum praesentium est. Ab tempore reiciendis ducimus illum minima ipsa consequatur laborum quod, nihil aliquam deserunt nisi atque, veniam esse enim.'), (NULL, 'sobre', 'direita_valores', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptates eum praesentium est. Ab tempore reiciendis ducimus illum minima ipsa consequatur laborum quod, nihil aliquam deserunt nisi atque, veniam esse enim.');
