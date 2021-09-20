create table if not exists tb_conteudo(
    id int auto_increment not null primary key,
    pagina varchar(255) not null,
    localizacao varchar(255) not null,
    conteudo text not null   

)default charset utf8;

INSERT INTO `tb_conteudo` (`id`, `pagina`, `localizacao`, `conteudo`) VALUES (NULL, 'home', 'esquerda', '<p>O Centro comunitário \"VÓ MARIA FÉLIX\" recebe crianças desde os 0 até aos 5 anos de idade.</p><br />\r\n                            <p>Cerca de quarenta alunos fizeram parte do ano pioneiro. Ao longo do tempo este número foi aumentando significativamente, sendo que hoje a escola conta com cerca de duzentos e cinquenta alunos. No entanto, temos a ânsia de crescer ainda mais</p><br />\r\n                            <p>Os nossos principais fins são: contribuir para o bem-estar, a valorização pessoal e a plena integração social das crianças e dos jovens que, por razões de natureza diversa, passam por dificuldades no seu cotidiano.</p>');

INSERT INTO `tb_conteudo` (`id`, `pagina`, `localizacao`, `conteudo`) VALUES (NULL, 'home', 'direita', '');