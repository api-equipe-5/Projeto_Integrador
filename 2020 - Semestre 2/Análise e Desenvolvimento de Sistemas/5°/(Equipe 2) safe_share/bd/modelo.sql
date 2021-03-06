-- Criar a Base de Dados:

CREATE DATABASE safe_share;


-- Criar as tabelas:

CREATE TABLE CLIENTE ( 

    cli_id SERIAL, 
	cli_cpf varchar(11) NOT NULL,
	cli_nome varchar(50) NOT NULL,
	cli_sobrenome varchar(50) NOT NULL,
	cli_telefone varchar(11) NOT NULL,
	cli_endereco varchar(200) NOT NULL,
	cli_email varchar(50) NOT NULL, 	
	cli_senha varchar(100) NOT NULL,
	
    CONSTRAINT PK_CLIENTE_ID PRIMARY KEY (cli_id),
	CONSTRAINT UK_CLIENTE_CPF UNIQUE (cli_cpf)
);
	
CREATE TABLE EMPRESA (
	emp_id SERIAL ,
	emp_nome varchar(50) NOT NULL,
	
	CONSTRAINT PK_EMPRESA_ID PRIMARY KEY (emp_id)
);

CREATE TABLE CONFIGURACAOCOMPARTILHAMENTO (
	conf_id SERIAL,
	CLIENTE_cli_id SERIAL,
	conf_comp_dados boolean,
	conf_comp_compras boolean,
	
	CONSTRAINT PK_CONFIGURACOMPA_ID PRIMARY KEY (conf_id)	
);

CREATE TABLE CATEGORIA (
	cat_id SERIAL,
	cat_descricao varchar(250) NOT NULL,
	
	CONSTRAINT PK_CATEGORIA_ID PRIMARY KEY (cat_id)	
);

CREATE TABLE PRODUTO (
	prod_id SERIAL,
	CATEGORIA_cat_id SERIAL,
	prod_nome varchar(50) NOT NULL,
	prod_descricao varchar(250) NOT NULL,
	prod_valor numeric NOT NULL,
	
	CONSTRAINT PK_PRODUTO_ID PRIMARY KEY (prod_id)
);

CREATE TABLE CARRINHO (
	car_id SERIAL,
	CLIENTE_cli_id SERIAL,
	PRODUTO_prod_id SERIAL,
	
	CONSTRAINT PK_CARRINHO_ID PRIMARY KEY(car_id)
);

CREATE TABLE PEDIDO (
	ped_id SERIAL,
	CLIENTE_cli_id SERIAL,
	CARRINHO_car_id SERIAL,
	ped_dataPedido timestamp without time zone DEFAULT now() NOT NULL,
	ped_valor numeric NOT NULL,
	
	CONSTRAINT PK_PEDIDO_ID PRIMARY KEY(ped_id)
);

CREATE TABLE CARRINHO_PEDIDO (
	CARRINHO_car_id SERIAL,
	PEDIDO_ped_id SERIAL,
	
	CONSTRAINT PK_CARRINHO_PEDIDO_ID PRIMARY KEY (CARRINHO_car_id, PEDIDO_ped_id)
);

CREATE TABLE LOGCOMPARTILHAMENTO (
	log_id SERIAL,
	CLIENTE_cli_id SERIAL,
	EMPRESA_emp_id SERIAL,
	log_dataInicio timestamp without time zone DEFAULT now() NOT NULL,
	log_dataFinal timestamp without time zone DEFAULT now() NOT NULL,
	log_dadoCompartilhado varchar(100),
	
	CONSTRAINT PK_LOGCOMPARTILHAMENTO_ID PRIMARY KEY (log_id)
);



-- Alter Tables para inserir as chaves estrangeiras: 


ALTER TABLE CONFIGURACAOCOMPARTILHAMENTO ADD CONSTRAINT FK_CONF_CLIENTE
	FOREIGN KEY (CLIENTE_cli_id ) 
    REFERENCES CLIENTE (cli_id);
	
ALTER TABLE PRODUTO ADD CONSTRAINT FK_CAT_PRODUTO
	FOREIGN KEY (CATEGORIA_cat_id ) 
    REFERENCES CATEGORIA (cat_id);

ALTER TABLE CARRINHO ADD CONSTRAINT FK_CARRINHO_CLIENTE
	FOREIGN KEY (CLIENTE_cli_id ) 
    REFERENCES CLIENTE (cli_id);
	
ALTER TABLE CARRINHO ADD CONSTRAINT FK_CARRINHO_PRODUTO
	FOREIGN KEY (PRODUTO_prod_id)
	REFERENCES PRODUTO (prod_id);

ALTER TABLE PEDIDO ADD CONSTRAINT FK_PEDIDO_CLIENTE
	FOREIGN KEY (CLIENTE_cli_id) 
    REFERENCES CLIENTE (cli_id);
	
ALTER TABLE PEDIDO ADD CONSTRAINT FK_PEDIDO_CARRINHO
	FOREIGN KEY (CARRINHO_car_id)
	REFERENCES CARRINHO (car_id);

ALTER TABLE LOGCOMPARTILHAMENTO ADD CONSTRAINT FK_LOGCOMPARTILHAMENTO_CLIENTE
	FOREIGN KEY (CLIENTE_cli_id ) 
    REFERENCES CLIENTE (cli_id);	

ALTER TABLE LOGCOMPARTILHAMENTO ADD CONSTRAINT FK_LOGCOMPARTILHAMENTO_EMPRESA
	FOREIGN KEY (EMPRESA_emp_id ) 
    REFERENCES EMPRESA (emp_id);
	

	

	

