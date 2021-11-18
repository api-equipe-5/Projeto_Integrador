CREATE DATABASE yourcad;

USE yourcad;

CREATE TABLE concessionaria (
concessionaria_id int(11) AUTO_INCREMENT,
concessionaria_cnpj VARCHAR(20),
concessionaria_nome VARCHAR(80),
concessionaria_inscricao_estadual VARCHAR(20),
concessionaria_endereco VARCHAR(40),
concessionaria_bairro VARCHAR(40),
concessionaria_numero_endereco INT(8),
concessionaria_complemento_endereco VARCHAR(50),
concessionaria_cep VARCHAR(12),
concessionaria_cidade VARCHAR(30),
concessionaria_uf VARCHAR(20),
concessionaria_email VARCHAR(30),
concessionaria_site VARCHAR(30),
PRIMARY KEY(concessionaria_id)
);

CREATE TABLE cliente (
cliente_id int(11) AUTO_INCREMENT,
cliente_nome VARCHAR(100),
cliente_apelido VARCHAR(50),
cliente_documento VARCHAR(50),
cliente_endereco VARCHAR(150),
cliente_complemento_endereco VARCHAR(100),
cliente_numero_endereco VARCHAR(20),
cliente_bairro VARCHAR(100),
cliente_cep VARCHAR(20),
cliente_cidade VARCHAR(100),
cliente_uf VARCHAR(50),
PRIMARY KEY(cliente_id)
);

CREATE TABLE instalacao (
instalacao_id INT(11) NOT NULL AUTO_INCREMENT,
instalacao_numero VARCHAR(20),
instalacao_apelido VARCHAR(50),
instalacao_tipo VARCHAR(20),
concessionaria_id INT(11),
cliente_id INT(11),
PRIMARY KEY(instalacao_id)
);

CREATE TABLE instalacao_agua (
instalacao_id INT(11),
instalacao_agua_hidrometro VARCHAR(20),
instalacao_agua_cod_sabesp VARCHAR(40),
instalacao_agua_cod_cliente VARCHAR(30),
instalacao_agua_economias VARCHAR(255),
instalacao_agua_tipo_ligacao VARCHAR(50),
PRIMARY KEY(instalacao_id)
);

CREATE TABLE instalacao_energia (
instalacao_id int(11),
instalacao_energia_codigo_identificacao VARCHAR(30),
instalacao_energia_codigo_fiscal VARCHAR(30),
instalacao_energia_grupo VARCHAR(30),
instalacao_energia_subgrupo VARCHAR(30),
instalacao_energia_classe VARCHAR(30),
instalacao_energia_tipo_fornecimento VARCHAR(30),
instalacao_energia_modalidade_tarifaria VARCHAR(30),
instalacao_energia_tensao VARCHAR(30),
instalacao_energia_roteiro_leitura VARCHAR(30),
instalacao_energia_medidor VARCHAR(30),
PRIMARY KEY(instalacao_id)
);

CREATE TABLE conta(
conta_id INT(11) AUTO_INCREMENT,
instalacao_id INT(11),
cliente_id INT(11),
conta_numero_instalacao VARCHAR(30),
conta_tipo VARCHAR(20),
PRIMARY KEY(conta_id)
);

CREATE TABLE conta_agua (
conta_id int(11),
conta_agua_mes VARCHAR(10),
conta_agua_vencimento VARCHAR(20),
conta_agua_data_atual_leitura VARCHAR(20),
conta_agua_data_previsao_proxima_leitura VARCHAR(20),
conta_agua_valor_atual_leitura VARCHAR(20),
conta_agua_valor_agua VARCHAR(20),
conta_agua_valor_esgoto VARCHAR(20),
conta_agua_multa VARCHAR(20),
conta_agua_trcf VARCHAR(20),
conta_agua_base_pis_cofins VARCHAR(20),
conta_agua_aliquota_pis_cofins VARCHAR(20),
PRIMARY KEY(conta_id)
);

CREATE TABLE conta_energia (
conta_id INT(11),
conta_energia_valor VARCHAR(11),
conta_energia_competencia VARCHAR(20),
conta_energia_consumo_mes VARCHAR(50),
conta_energia_vencimento VARCHAR(20),
conta_energia_bandeira_cor VARCHAR(20),
conta_energia_bandeira_periodoini VARCHAR(20),
conta_energia_bandeira_periodo_fim VARCHAR(20),
conta_energia_faturamento_emissao VARCHAR(20),
conta_energia_faturamento_leitatual VARCHAR(20),
conta_energia_faturamento_dias VARCHAR(20),
conta_energia_faturamento_cci VARCHAR(20),
conta_energia_faturamento_produto VARCHAR(20),
conta_energia_faturamento_qtd VARCHAR(20),
conta_energia_faturamento_tarifa VARCHAR(20),
conta_energia_faturamento_valorfornecido VARCHAR(20),
conta_energia_faturamento_tarifaimposto VARCHAR(20),
conta_energia_faturamento_baseicms VARCHAR(20),
conta_energia_faturamento_aliqicms VARCHAR(20),
conta_energia_faturamento_valoricms VARCHAR(20),
conta_energia_faturamento_basepis VARCHAR(20),
conta_energia_faturamento_aliqpis VARCHAR(20),
conta_energia_faturamento_valorpis VARCHAR(20),
conta_energia_consumo_descricao VARCHAR(50),
conta_energia_consumo_medidor VARCHAR(20),
conta_energia_consumo_leitatual VARCHAR(20),
conta_energia_consumo_constmult VARCHAR(20),
conta_energia_consumo_kwh VARCHAR(20),
PRIMARY KEY(conta_id)
);

CREATE TABLE usuarios (
usuario_id INT(11) AUTO_INCREMENT,
usuario_nome VARCHAR(100),
usuario_login VARCHAR(100),
usuario_senha VARCHAR(255),
usuario_email VARCHAR(150),
usuario_nivel_acesso VARCHAR(50),
usuario_status VARCHAR(50),
PRIMARY KEY(usuario_id)
);

INSERT INTO usuarios (
usuario_nome, 
usuario_login, 
usuario_senha, 
usuario_email, 
usuario_nivel_acesso,
usuario_status )
VALUES (
"Administrador",
"admin",
"123456",
"a.a@a.com",
"Administrador",
"Ativo");

CREATE TABLE acessos (
acesso_id INT(11) AUTO_INCREMENT,
acesso_usuario_id INT(11),
acesso_data VARCHAR(50),
acesso_hora VARCHAR(50),
PRIMARY KEY(acesso_id)
);

CREATE TABLE relatorio_digitador (
relat_id INT(11) AUTO_INCREMENT,
usuario_id INT(11),
conta_id INT(11),
relat_data VARCHAR(50),
relat_hora VARCHAR(50),
PRIMARY KEY(relat_id)
);




