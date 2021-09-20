create database if not exists bd_voluntario
default character set utf8
default collate utf8_general_ci;

use bd_voluntario;
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

use bd_voluntario;
create table if not exists tb_conteudo(
    id int auto_increment not null primary key,
    pagina varchar(255) not null,
    localizacao varchar(255) not null,
    conteudo text not null   

)default charset utf8;
INSERT INTO `tb_conteudo` (`id`, `pagina`, `localizacao`, `conteudo`) VALUES (NULL, 'cadastro_voluntario', 'esquerda', 'Seja um voluntário do nosso centro comunitário, qualquer ajuda é válida. Não é apenas quem é “especialista” em alguma atividade que pode ser voluntário. Todos podem participar e contribuir. O que conta é a motivação solidária, o desejo de ajudar, o prazer de se sentir útil.\r\n\r\n\r\n– Você pode compartilhar apenas com as crianças os seus talentos e paixões, abrindo para elas um mundo totalmente diferente.\r\n\r\n\r\n– Você pode participar na renovação e nas obras de construção.\r\n\r\n\r\n– Pode pintar nossas paredes ou colocar algumas pichações sobre eles, trazendo um pouco mais de cor na vida cotidiana das crianças.\r\n\r\n\r\n– Se você é fotógrafo ou operador, pode nos ajudar a criar meios de comunicação de base com boas fotos e vídeos da nossa escola e alunos.\r\n\r\n\r\n– Se você é um especialista em qualquer área do desenvolvimento infantil e educação: médico, dançarino, músico, professor de línguas estrangeiras ou psicólogo venha colaborar conosco.\r\n\r\n\r\n– Se você tem suas próprias ideias teremos gosto em discuti-las.');


create database if not exists bd_sobre
default character set utf8
default collate utf8_general_ci;

use bd_sobre;
create table if not exists tb_conteudo(
    id int auto_increment not null primary key,
    pagina varchar(255) not null,
    localizacao varchar(255) not null,
    conteudo text not null   

)default charset utf8;
INSERT INTO `tb_conteudo` (`id`, `pagina`, `localizacao`, `conteudo`) VALUES (NULL, 'sobre', 'direita_missao', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptates eum praesentium est. Ab tempore reiciendis ducimus illum minima ipsa consequatur laborum quod, nihil aliquam deserunt nisi atque, veniam esse enim.'), (NULL, 'sobre', 'direita_visao', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptates eum praesentium est. Ab tempore reiciendis ducimus illum minima ipsa consequatur laborum quod, nihil aliquam deserunt nisi atque, veniam esse enim.'), (NULL, 'sobre', 'direita_valores', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptates eum praesentium est. Ab tempore reiciendis ducimus illum minima ipsa consequatur laborum quod, nihil aliquam deserunt nisi atque, veniam esse enim.');


create database if not exists bd_projetos
default character set utf8
default collate utf8_general_ci;

use bd_projetos;
create table if not exists tb_projetos(
    id int auto_increment not null primary key,
    nome varchar(40) not null,
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

use bd_projetos;
create table if not exists tb_conteudo(
    id int auto_increment not null primary key,
    pagina varchar(255) not null,
    localizacao varchar(255) not null,
    conteudo text not null   

)default charset utf8;
INSERT INTO `tb_conteudo` (`id`, `pagina`, `localizacao`, `conteudo`) VALUES (NULL, 'projetos', 'esquerda', '                    Lorem ipsum dolor sit, amet consectetur adipisicing elit. Maxime velit iure quia rerum sunt placeat veritatis ab nulla blanditiis inventore similique autem sequi a nemo unde qui aut, officiis dolores?Lorem ipsum dolor sit amet consectetur adipisicing elit. Libero neque vel harum in nobis molestiae adipisci culpa cum voluptatem minima iusto ullam voluptates laudantium doloremque tempore saepe, a perspiciatis? At.\r\n                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Quia deserunt dignissimos nulla eos facilis saepe incidunt commodi ex autem. Rerum, deserunt odio reiciendis nisi magni sequi non ex fugit voluptas.');


create database if not exists bd_participantes
default character set utf8
default collate utf8_general_ci;

use bd_participantes;
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

use bd_participantes;
create table if not exists tb_conteudo(
    id int auto_increment not null primary key,
    pagina varchar(255) not null,
    localizacao varchar(255) not null,
    conteudo text not null   

)default charset utf8;
INSERT INTO `tb_conteudo` (`id`, `pagina`, `localizacao`, `conteudo`) VALUES (NULL, 'cadastro_participantes', 'centro', 'Bem-vindo, a pré-inscrição online possibilita ao futuro estudante solicitar uma vaga para o ano vigente. Primeiramente solicitamos que preencha os campos abaixo. Esses dados serão usados para chegarmos até você.\r\n\r\nA sua pré-inscrição será realizada de modo on-line e será analisada, e entraremos em contato caso tenha vaga');


create database if not exists bd_home
default character set utf8
default collate utf8_general_ci;

use bd_home;
create table if not exists tb_conteudo(
    id int auto_increment not null primary key,
    pagina varchar(255) not null,
    localizacao varchar(255) not null,
    conteudo text not null   

)default charset utf8;
INSERT INTO `tb_conteudo` (`id`, `pagina`, `localizacao`, `conteudo`) VALUES (NULL, 'home', 'esquerda', '<p>O Centro comunitário \"VÓ MARIA FÉLIX\" recebe crianças desde os 0 até aos 5 anos de idade.</p><br />\r\n                            <p>Cerca de quarenta alunos fizeram parte do ano pioneiro. Ao longo do tempo este número foi aumentando significativamente, sendo que hoje a escola conta com cerca de duzentos e cinquenta alunos. No entanto, temos a ânsia de crescer ainda mais</p><br />\r\n                            <p>Os nossos principais fins são: contribuir para o bem-estar, a valorização pessoal e a plena integração social das crianças e dos jovens que, por razões de natureza diversa, passam por dificuldades no seu cotidiano.</p>');
INSERT INTO `tb_conteudo` (`id`, `pagina`, `localizacao`, `conteudo`) VALUES (NULL, 'home', 'direita', '');


create database if not exists bd_contato
default character set utf8
default collate utf8_general_ci;

use bd_contato;
create table if not exists tb_contato(
    id int auto_increment not null primary key,
    nome varchar(40) not null,
    telefone varchar (11) not null, 
    email varchar (40) not null,
    descricao varchar (230) not null
)default charset utf8;

use bd_contato;
create table if not exists tb_conteudo(
    id int auto_increment not null primary key,
    pagina varchar(255) not null,
    localizacao varchar(255) not null,
    conteudo text not null   

)default charset utf8;
INSERT INTO `tb_conteudo` (`id`, `pagina`, `localizacao`, `conteudo`) VALUES (NULL, 'Contato2', 'esquerda', 'TELEFONE: (12) 3966-2823 E-MAIL: administracao@aamu.org.br FACEBOOK: CECOI VÓ MARIA FÉLIX Horário de Segunda a Sexta das 07:00h ás 17:00h');



create database if not exists bd_admin
default character set utf8
default collate utf8_general_ci;

use bd_admin;
create table if not exists tb_user(
    id int auto_increment not null primary key,
    email varchar(255) not null,
    password varchar(255) not null,
    name varchar(255) not null  

)default charset utf8;
INSERT INTO `tb_user` (`id`, `email`, `password`, `name`) VALUES (NULL, 'admin@admin.com.br', '@admin123', 'Administrador');


create database if not exists bd_doacao
default character set utf8
default collate utf8_general_ci; 

use bd_doacao;
create table if not exists tb_doacao(
    id int auto_increment not null primary key,
    nome varchar(40) not null,
    cpf varchar(14) not null,
    tel_number varchar (11) not null,
    celular varchar (11) not null, 
    endereco varchar (40) not null,
    anonimo varchar (10) null

)default charset utf8;

use bd_doacao;
create table if not exists tb_conteudo(
    id int auto_increment not null primary key,
    pagina varchar(255) not null,
    localizacao varchar(255) not null,
    conteudo text not null   

)default charset utf8;
INSERT INTO `tb_conteudo` (`id`, `pagina`, `localizacao`, `conteudo`) VALUES (NULL, 'formulario_doador', 'esquerda', 'Seja um voluntário do nosso centro comunitário, qualquer ajuda é válida. Não é apenas quem é “especialista” em alguma atividade que pode ser voluntário. Todos podem participar e contribuir. O que conta é a motivação solidária, o desejo de ajudar, o prazer de se sentir útil.\r\n\r\n– Você pode compartilhar apenas com as crianças os seus talentos e paixões, abrindo para elas um mundo totalmente diferente.');

























