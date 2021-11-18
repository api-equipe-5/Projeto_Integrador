DROP DATABASE tecsus;
CREATE DATABASE tecsus;
USE tecsus;

CREATE TABLE cli_cliente (
	id INT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
    apelido VARCHAR(50) NOT NULL,
    documento VARCHAR(14) NOT NULL,
    endereco VARCHAR(30) NOT NULL,
    complemento_endereco VARCHAR(15) DEFAULT NULL,
    numero_endereco INT NOT NULL,
    cep VARCHAR(8) NOT NULL,
    cidade VARCHAR(30) NOT NULL,
    uf VARCHAR(2) NOT NULL,
    CONSTRAINT pk_cli_cliente PRIMARY KEY (id),
    CONSTRAINT uq_cli_cliente_apelido UNIQUE (apelido),
    CONSTRAINT uq_cli_cliente_documento UNIQUE (documento)
);

CREATE TABLE csa_concessionaria (
	id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(70) NOT NULL,
    documento VARCHAR(14) NOT NULL,
    inscricao_estadual VARCHAR(12) DEFAULT NULL,
    endereco VARCHAR(30) NOT NULL,
    numero_endereco INT NOT NULL,
    complemento_endereco VARCHAR(20) DEFAULT NULL,
    cep VARCHAR(8) NOT NULL,
    cidade VARCHAR(30) NOT NULL,
    uf VARCHAR(2) NOT NULL,
    email VARCHAR(40) NOT NULL,
    CONSTRAINT pk_csa_concessionaria PRIMARY KEY (id),
    CONSTRAINT uq_csa_concessionaria_inscricao_estadual UNIQUE (inscricao_estadual),
    CONSTRAINT uq_csa_concessionaria_documento UNIQUE (documento)
);

CREATE TABLE ins_instalacao (
	id INT NOT NULL AUTO_INCREMENT,
	numero VARCHAR(10) NOT NULL,
    id_concessionaria INT NOT NULL,
    apelido VARCHAR(50) NOT NULL,
    id_cliente INT NOT NULL,
    CONSTRAINT pk_ins_instalacao PRIMARY KEY (id),
    CONSTRAINT fk_ins_instalacao_cli_cliente FOREIGN KEY (id_cliente) REFERENCES cli_cliente (id),
    CONSTRAINT fk_ins_instalacao_csa_concessionaria FOREIGN KEY (id_concessionaria) REFERENCES csa_concessionaria (id),
    CONSTRAINT uq_ins_instalacao_apelido UNIQUE (apelido),
    CONSTRAINT uq_ins_instalacao_csa_concessionaria UNIQUE (numero, id_concessionaria)
);

CREATE TABLE ins_instalacao_energia (
	id INT NOT NULL,
    cod_identificacao INT NOT NULL,
    cod_fiscal_oper INT NOT NULL,
    grupo VARCHAR(1) NOT NULL,
    subgrupo VARCHAR(2) NOT NULL,
    classe VARCHAR(20) NOT NULL,
    tipo_fornecimento VARCHAR(20) NOT NULL,
    modalidade_tarifaria VARCHAR(20) NOT NULL,
    tensao_nominal VARCHAR(8) NOT NULL,
    roteiro_leitura VARCHAR(14) NOT NULL,
    medidor INT NOT NULL,
    CONSTRAINT pk_ins_instalacao_energia PRIMARY KEY (id),
    CONSTRAINT fk_ins_instalacao_energia FOREIGN KEY (id) 
		REFERENCES ins_instalacao (id)
);

CREATE TABLE ins_instalacao_agua (
	id INT NOT NULL,
    hidrometro VARCHAR(10) NOT NULL,
    cod_sabesp VARCHAR(23),
    cod_cliente VARCHAR(12),
    economias VARCHAR(30),
    tipo_ligacao VARCHAR(15),
	CONSTRAINT pk_ins_instalacao_agua PRIMARY KEY (id),
    CONSTRAINT fk_ins_instalacao_agua FOREIGN KEY (id) 
		REFERENCES ins_instalacao (id)
);

CREATE TABLE cnt_conta (
	id_instalacao INT NOT NULL,
	mes DATE NOT NULL,
    vencimento DATE NOT NULL,
    data_leitura DATE NOT NULL,
    data_previsao_prox_leitura DATE NOT NULL,
    valor_leitura DOUBLE NOT NULL,
    CONSTRAINT pk_cnt_conta PRIMARY KEY (id_instalacao, mes),
    CONSTRAINT fk_cnt_conta_ins_instalacao FOREIGN KEY (id_instalacao)
		REFERENCES ins_instalacao (id)
);

CREATE TABLE cnt_conta_energia (
	id_instalacao INT NOT NULL,
	mes DATE NOT NULL,
    constante_mult DOUBLE NOT NULL,
    CONSTRAINT pk_cnt_conta_energia PRIMARY KEY (id_instalacao, mes),
    CONSTRAINT fk_cnt_conta_energia FOREIGN KEY (id_instalacao, mes) 
		REFERENCES cnt_conta (id_instalacao, mes)
);

CREATE TABLE cnt_conta_agua (
	id_instalacao INT NOT NULL,
	mes DATE NOT NULL,
    valor_agua DOUBLE DEFAULT NULL,
    valor_esgoto DOUBLE DEFAULT NULL,
    multa DOUBLE DEFAULT NULL,
    trcf DOUBLE DEFAULT NULL,
    base_pis_coffins DOUBLE NOT NULL,
    aliquota_pis_coffins DOUBLE NOT NULL,
	CONSTRAINT pk_cnt_conta_agua PRIMARY KEY (id_instalacao, mes),
	CONSTRAINT fk_cnt_conta_agua FOREIGN KEY (id_instalacao, mes) 
		REFERENCES cnt_conta (id_instalacao, mes)
);

CREATE TABLE cnt_conta_energia_encargo (
	id_instalacao INT NOT NULL,
	mes DATE NOT NULL,
    cci VARCHAR(5) NOT NULL,
    descricao_produto VARCHAR(20) NOT NULL,
    consumo_kwh DOUBLE NOT NULL,
    tarifa_aplicada DOUBLE NOT NULL,
    valor_fornec DOUBLE NOT NULL,
    tarifa_c_imposto DOUBLE NOT NULL,
    base_icms DOUBLE NOT NULL,
    aliquota_icms DOUBLE NOT NULL,
    base_pis_coffins DOUBLE NOT NULL,
    aliquota_pis DOUBLE NOT NULL,
    aliquota_coffins DOUBLE NOT NULL,
    CONSTRAINT pk_cnt_conta_energia_encargo PRIMARY KEY (id_instalacao, mes, descricao_produto),
    CONSTRAINT fk_cnt_conta_energia_encargo FOREIGN KEY (id_instalacao, mes) 
		REFERENCES cnt_conta_energia (id_instalacao, mes)
);

CREATE TABLE cnt_conta_energia_bandeira (
	id_instalacao INT NOT NULL,
    mes DATE NOT NULL,
    cor VARCHAR(10) NOT NULL,
    data_inicio DATE NOT NULL,
    data_fim DATE NOT NULL,
	CONSTRAINT pk_cnt_conta_energia_bandeira PRIMARY KEY (id_instalacao, mes, cor),
    CONSTRAINT fk_cnt_conta_energia_bandeira FOREIGN KEY (id_instalacao, mes) 
		REFERENCES cnt_conta_energia (id_instalacao, mes)
);