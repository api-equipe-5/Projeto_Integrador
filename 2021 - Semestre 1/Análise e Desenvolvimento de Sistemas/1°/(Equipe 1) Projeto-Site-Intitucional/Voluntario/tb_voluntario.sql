create table if not exists tb_voluntario(
    id int auto_increment not null primary key,
    nome varchar(40) not null,
    nascimento varchar (11) not null,
    cpf varchar(14) not null,
    rg varchar(14) not null,
    tel_number varchar (11),
    celular varchar (11) not null, 
    email varchar (40) not null,
    voluntario varchar (12) null,
    redesocial varchar (12) null,
    youtube varchar (10) null,
    outros varchar (10) null,
    especialidade varchar (80)

)default charset utf8;

create table if not exists tb_conteudo(
    id int auto_increment not null primary key,
    pagina varchar(255) not null,
    localizacao varchar(255) not null,
    conteudo text not null   

)default charset utf8;

INSERT INTO `tb_conteudo` (`id`, `pagina`, `localizacao`, `conteudo`) VALUES (NULL, 'cadastro_voluntario', 'esquerda', 'Seja um voluntário do nosso centro comunitário, qualquer ajuda é válida. Não é apenas quem é “especialista” em alguma atividade que pode ser voluntário. Todos podem participar e contribuir. O que conta é a motivação solidária, o desejo de ajudar, o prazer de se sentir útil.\r\n\r\n\r\n– Você pode compartilhar apenas com as crianças os seus talentos e paixões, abrindo para elas um mundo totalmente diferente.\r\n\r\n\r\n– Você pode participar na renovação e nas obras de construção.\r\n\r\n\r\n– Pode pintar nossas paredes ou colocar algumas pichações sobre eles, trazendo um pouco mais de cor na vida cotidiana das crianças.\r\n\r\n\r\n– Se você é fotógrafo ou operador, pode nos ajudar a criar meios de comunicação de base com boas fotos e vídeos da nossa escola e alunos.\r\n\r\n\r\n– Se você é um especialista em qualquer área do desenvolvimento infantil e educação: médico, dançarino, músico, professor de línguas estrangeiras ou psicólogo venha colaborar conosco.\r\n\r\n\r\n– Se você tem suas próprias ideias teremos gosto em discuti-las.');