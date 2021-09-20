create table if not exists tb_user(
    id int auto_increment not null primary key,
    email varchar(255) not null,
    password varchar(255) not null,
    name varchar(255) not null  

)default charset utf8;

INSERT INTO `tb_user` (`id`, `email`, `password`, `name`) VALUES (NULL, 'admin@admin.com.br', '@admin123', 'Administrador');