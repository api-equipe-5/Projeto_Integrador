USE tecsus;

INSERT INTO cli_cliente (id, nome, apelido, documento, endereco, complemento_endereco, numero_endereco, cep, cidade, uf)
	VALUES (0, "MATEUS DE SENNE", "SENNE", "47224459828", "RUA BENEDITA NUNES DE CAMPOS", NULL, 514, "12239008", "SÃO JOSÉ DOS CAMPOS", "SP"),
	(0, "LUCAS APARECIDO", "LUCAS", "47782889958", "RUA RODRIGUES ALVES", NULL, 377, "12322760", "JACAREÍ", "SP"),
	(0, "LUIS AUGUSTO DE SOUZA BARROS", "LUIS", "48625806880", "RUA DAS ORQUIDEAS", NULL, 77, "12224130", "SÃO JOSÉ DOS CAMPOS", "SP");

INSERT INTO csa_concessionaria (id, nome, documento, inscricao_estadual, endereco, numero_endereco, complemento_endereco, cep, cidade, uf, email)
	VALUES (0, "EDP SÃO PAULO DISTRIBUIÇÃO DE ENERGIA", "03983431000103", NULL, "RUA GOMES DE CARVALHO", 1996, "8º ANDAR", "04547006", "SÃO PAULO", "SP", "RI@EDPBR.COM.BR"),
	(0, "ANEEL SÃO PAULO - AGÊNCIA NACIONAL DE ENERGIA ELÉTRICA", "39517888000185", "121716025311", "AVENIDA NOVE DE JULHO", 3981, NULL, "01407100", "SÃO PAULO", "SP", "PROTOCOLOGERAL@ANEEL.GOV.BR"),
    (0, "COMPANHIA DE SANEAMENTO BÁSICO DO ESTADO DE SÃO PAULO - SABESP", "43776517000180", "109091792118", "RUA COSTA CARVALHO", 300, NULL, "05429900", "SÃO PAULO", "SP", "OUVIDORIA@SABESP.COM.BR");

INSERT INTO ins_instalacao (id, numero, id_concessionaria, apelido, id_cliente)
	VALUES (0, "0791669033", 3, "ÁGUA CASA SENNE", 1),
    (0, "1505199113", 1, "ENERGIA CASA SENNE", 1),
    (0, "1333074591", 2, "ENERGIA ESCRITÓRIO LUCAS", 2),
    (0, "0680558922", 3, "ÁGUA ESCRITÓRIO LUCAS", 2);
    
INSERT INTO ins_instalacao_agua (id, hidrometro, cod_sabesp, cod_cliente, economias, tipo_ligacao)
	VALUES (1, "Y12T206163", "04645480230100000000103", "303112", "1 RES + 0 COM + 0 IND + 0 PUB", "ÁGUA E ESGOTO"),
    (4, "X01T195052", "05730120102550000000024", "201922", "1 RES + 0 COM + 0 IND + 0 PUB", "ÁGUA E ESGOTO");

INSERT INTO ins_instalacao_energia (id, cod_identificacao, cod_fiscal_oper, grupo, subgrupo, classe, tipo_fornecimento, modalidade_tarifaria, tensao_nominal, roteiro_leitura, medidor)
	VALUES (2, 94366802, 5258, "B", "B1", "RESIDENCIAL", "BIFÁSICO", "CONVENCIONAL", "220/127V", "B06SJ20M00613", 11149725),
    (3, 214393449, 1520, "A", "A1", "COMERCIAL", "BIFÁSICO", "CONVENCIONAL BINÔMIA", "220/127V", "F4JIZT34ERYAY8", 18274811);

INSERT INTO cnt_conta (id_instalacao, mes, vencimento, data_leitura, data_previsao_prox_leitura, valor_leitura)
	VALUES (1, 01/09/2020, 16/09/2020, 01/09/2020, 01/10/2020, 771),
	(4, 01/09/2020, 15/09/2020, 01/09/2020, 01/10/2020, 1209),
    (2, 01/09/2020, 28/09/2020, 12/09/2020, 14/10/2020, 21.89),
    (3, 01/09/2020, 15/09/2020, 02/09/2020, 30/10/2020, 46.71);

INSERT INTO cnt_conta_energia (id_instalacao, mes, constante_mult)
	VALUES (2, 01/09/2020, 1.00000),
    (3, 01/09/2020, 1.00000);
    
INSERT INTO cnt_conta_agua (id_instalacao, mes, valor_agua, valor_esgoto, multa, trcf, base_pis_coffins, aliquota_pis_coffins)
	VALUES (1, 01/09/2020, 27.07, 21.71, NULL, 0.24, 48.34, 6.56),
    (4, 01/09/2020, 50.10, 42.20, NULL, 0.30, 92.30, 12.59);
    
INSERT INTO cnt_conta_energia_encargo (id_instalacao, mes, cci, descricao_produto, consumo_kwh, tarifa_aplicada, valor_fornec, tarifa_c_imposto, base_icms, aliquota_icms, base_pis_coffins, aliquota_pis, aliquota_coffins)
	VALUES (2, 01/09/2020, "0605", "TUSD", 276.0000, 0.264490000, 73.00, 0.36155797, 99.79, 25, 74.84, 0.44, 2.02),
    (2, 01/09/2020, "0701", "TE", 276.0000, 0.261240000, 72.10, 0.35710145, 98.56, 25, 73.92, 0.44, 2.02),
    (3, 01/09/2020, "1210", "REEL", 481.0000, 0.470123000, 140.33, 0.71091233, 187.91, 25, 142.39, 0.44, 2.02);

INSERT INTO cnt_conta_energia_bandeira (id_instalacao, mes, cor, data_inicio, data_fim)
	VALUES (2, 01/09/2020, "VERDE", 13/08/2020, 12/09/2020),
    (3, 01/09/2020, "AMARELA", 04/08/2020, 03/09/2020);
    
