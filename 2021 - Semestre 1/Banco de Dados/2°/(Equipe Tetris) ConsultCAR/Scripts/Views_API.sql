-- VIEWS 
	-- Tabela com todos os municípios inseridos até o momento no banco de dados. 
	CREATE VIEW municipios_cadastrados AS
    SELECT 
		cod_imovel AS codigo_imovel,
		num_area AS area,
		cod_estado AS estado,
		nom_munici AS municipio,
		num_modulo AS modulo,
		tipo_imove AS tipo_imovel,
		situacao,
		condicao_i AS condicao,
		geom AS poligono
	
    FROM municipios_br
	ORDER BY nom_munici;
	
	-- Tabela com todos os municípios do Estado de SAO PAULO cadastrados
	CREATE VIEW sao_paulo AS
    SELECT 
		cod_imovel AS codigo_imovel,
		num_area AS area,
		cod_estado AS estado,
		nom_munici AS municipio,
		num_modulo AS modulo,
		tipo_imove AS tipo_imovel,
		situacao,
		condicao_i AS condicao,
		geom AS poligono
	
    FROM municipios_br
	WHERE cod_estado = 'SP'
	ORDER BY nom_munici;
	
	-- Tabela com todos os municípios do Estado do ACRE cadastrados
	CREATE VIEW acre AS
    SELECT 
		cod_imovel AS codigo_imovel,
		num_area AS area,
		cod_estado AS estado,
		nom_munici AS municipio,
		num_modulo AS modulo,
		tipo_imove AS tipo_imovel,
		situacao,
		condicao_i AS condicao,
		geom AS poligono
	
    FROM municipios_br
	WHERE cod_estado = 'AC'
	ORDER BY nom_munici;
	
	-- Tabela com todos os municípios do Estado de RONDONIA cadastrados
	CREATE VIEW rondonia AS
    SELECT 
		cod_imovel AS codigo_imovel,
		num_area AS area,
		cod_estado AS estado,
		nom_munici AS municipio,
		num_modulo AS modulo,
		tipo_imove AS tipo_imovel,
		situacao,
		condicao_i AS condicao,
		geom AS poligono
	
    FROM municipios_br
	WHERE cod_estado = 'RO'
	ORDER BY nom_munici;
	
	-- Tabela com todos os municípios do Estado de AMAZONAS cadastrados
	CREATE VIEW amazonas AS
    SELECT 
		cod_imovel AS codigo_imovel,
		num_area AS area,
		cod_estado AS estado,
		nom_munici AS municipio,
		num_modulo AS modulo,
		tipo_imove AS tipo_imovel,
		situacao,
		condicao_i AS condicao,
		geom AS poligono
	
    FROM municipios_br
	WHERE cod_estado = 'AM'
	ORDER BY nom_munici;
	
	-- Tabela com todos os municípios do Estado de RORAIMA cadastrados
	CREATE VIEW roraima AS
    SELECT 
		cod_imovel AS codigo_imovel,
		num_area AS area,
		cod_estado AS estado,
		nom_munici AS municipio,
		num_modulo AS modulo,
		tipo_imove AS tipo_imovel,
		situacao,
		condicao_i AS condicao,
		geom AS poligono
	
    FROM municipios_br
	WHERE cod_estado = 'RR'
	ORDER BY nom_munici;
	
	-- Tabela com todos os municípios do Estado do PARÁ cadastrados
	CREATE VIEW para AS
    SELECT 
		cod_imovel AS codigo_imovel,
		num_area AS area,
		cod_estado AS estado,
		nom_munici AS municipio,
		num_modulo AS modulo,
		tipo_imove AS tipo_imovel,
		situacao,
		condicao_i AS condicao,
		geom AS poligono
	
    FROM municipios_br
	WHERE cod_estado = 'PA'
	ORDER BY nom_munici;
	
	-- Tabela com todos os municípios do Estado de AMAPÁ cadastrados
	CREATE VIEW amapa AS
    SELECT 
		cod_imovel AS codigo_imovel,
		num_area AS area,
		cod_estado AS estado,
		nom_munici AS municipio,
		num_modulo AS modulo,
		tipo_imove AS tipo_imovel,
		situacao,
		condicao_i AS condicao,
		geom AS poligono
	
    FROM municipios_br
	WHERE cod_estado = 'AP'
	ORDER BY nom_munici;
	
	-- Tabela com todos os municípios do Estado de TOCANTINS cadastrados
	CREATE VIEW tocantins AS
    SELECT 
		cod_imovel AS codigo_imovel,
		num_area AS area,
		cod_estado AS estado,
		nom_munici AS municipio,
		num_modulo AS modulo,
		tipo_imove AS tipo_imovel,
		situacao,
		condicao_i AS condicao,
		geom AS poligono
	
    FROM municipios_br
	WHERE cod_estado = 'TO'
	ORDER BY nom_munici;
	
	-- Tabela com todos os municípios do Estado do MARANHÃO cadastrados
	CREATE VIEW maranhao AS
    SELECT 
		cod_imovel AS codigo_imovel,
		num_area AS area,
		cod_estado AS estado,
		nom_munici AS municipio,
		num_modulo AS modulo,
		tipo_imove AS tipo_imovel,
		situacao,
		condicao_i AS condicao,
		geom AS poligono
	
    FROM municipios_br
	WHERE cod_estado = 'MA'
	ORDER BY nom_munici;
	
	-- Tabela com todos os municípios do Estado de PIAUÍ cadastrados
	CREATE VIEW piaui AS
    SELECT 
		cod_imovel AS codigo_imovel,
		num_area AS area,
		cod_estado AS estado,
		nom_munici AS municipio,
		num_modulo AS modulo,
		tipo_imove AS tipo_imovel,
		situacao,
		condicao_i AS condicao,
		geom AS poligono
	
    FROM municipios_br
	WHERE cod_estado = 'PI'
	ORDER BY nom_munici;
	
	-- Tabela com todos os municípios do Estado de CEARÁ cadastrados
	CREATE VIEW ceara AS
    SELECT 
		cod_imovel AS codigo_imovel,
		num_area AS area,
		cod_estado AS estado,
		nom_munici AS municipio,
		num_modulo AS modulo,
		tipo_imove AS tipo_imovel,
		situacao,
		condicao_i AS condicao,
		geom AS poligono
	
    FROM municipios_br
	WHERE cod_estado = 'CE'
	ORDER BY nom_munici;
	
	-- Tabela com todos os municípios do Estado de RIO GRANDE DO NORTE cadastrados
	CREATE VIEW rio_grande_do_norte AS
    SELECT 
		cod_imovel AS codigo_imovel,
		num_area AS area,
		cod_estado AS estado,
		nom_munici AS municipio,
		num_modulo AS modulo,
		tipo_imove AS tipo_imovel,
		situacao,
		condicao_i AS condicao,
		geom AS poligono
	
    FROM municipios_br
	WHERE cod_estado = 'RN'
	ORDER BY nom_munici;
	
	-- Tabela com todos os municípios do Estado do PARAÍBA cadastrados
	CREATE VIEW paraiba AS
    SELECT 
		cod_imovel AS codigo_imovel,
		num_area AS area,
		cod_estado AS estado,
		nom_munici AS municipio,
		num_modulo AS modulo,
		tipo_imove AS tipo_imovel,
		situacao,
		condicao_i AS condicao,
		geom AS poligono
	
    FROM municipios_br
	WHERE cod_estado = 'PB'
	ORDER BY nom_munici;
	
	-- Tabela com todos os municípios do Estado de PERNAMBUCO cadastrados
	CREATE VIEW pernambuco AS
    SELECT 
		cod_imovel AS codigo_imovel,
		num_area AS area,
		cod_estado AS estado,
		nom_munici AS municipio,
		num_modulo AS modulo,
		tipo_imove AS tipo_imovel,
		situacao,
		condicao_i AS condicao,
		geom AS poligono
	
    FROM municipios_br
	WHERE cod_estado = 'PE'
	ORDER BY nom_munici;
	
	-- Tabela com todos os municípios do Estado de ALAGOAS cadastrados
	CREATE VIEW alagoas AS
    SELECT 
		cod_imovel AS codigo_imovel,
		num_area AS area,
		cod_estado AS estado,
		nom_munici AS municipio,
		num_modulo AS modulo,
		tipo_imove AS tipo_imovel,
		situacao,
		condicao_i AS condicao,
		geom AS poligono
	
    FROM municipios_br
	WHERE cod_estado = 'AL'
	ORDER BY nom_munici;
	
	-- Tabela com todos os municípios do Estado de SERGIPE cadastrados
	CREATE VIEW sergipe AS
    SELECT 
		cod_imovel AS codigo_imovel,
		num_area AS area,
		cod_estado AS estado,
		nom_munici AS municipio,
		num_modulo AS modulo,
		tipo_imove AS tipo_imovel,
		situacao,
		condicao_i AS condicao,
		geom AS poligono
	
    FROM municipios_br
	WHERE cod_estado = 'SE'
	ORDER BY nom_munici;
	
	-- Tabela com todos os municípios do Estado da BAHIA cadastrados
	CREATE VIEW bahia AS
    SELECT 
		cod_imovel AS codigo_imovel,
		num_area AS area,
		cod_estado AS estado,
		nom_munici AS municipio,
		num_modulo AS modulo,
		tipo_imove AS tipo_imovel,
		situacao,
		condicao_i AS condicao,
		geom AS poligono
	
    FROM municipios_br
	WHERE cod_estado = 'BA'
	ORDER BY nom_munici;
	
	-- Tabela com todos os municípios do Estado de MINAS GERIAS cadastrados
	CREATE VIEW minas_gerais AS
    SELECT 
		cod_imovel AS codigo_imovel,
		num_area AS area,
		cod_estado AS estado,
		nom_munici AS municipio,
		num_modulo AS modulo,
		tipo_imove AS tipo_imovel,
		situacao,
		condicao_i AS condicao,
		geom AS poligono
	
    FROM municipios_br
	WHERE cod_estado = 'MG'
	ORDER BY nom_munici;
	
	-- Tabela com todos os municípios do Estado do ESPÍRTO SANTO cadastrados
	CREATE VIEW espirito_santo AS
    SELECT 
		cod_imovel AS codigo_imovel,
		num_area AS area,
		cod_estado AS estado,
		nom_munici AS municipio,
		num_modulo AS modulo,
		tipo_imove AS tipo_imovel,
		situacao,
		condicao_i AS condicao,
		geom AS poligono
	
    FROM municipios_br
	WHERE cod_estado = 'ES'
	ORDER BY nom_munici;
	
	-- Tabela com todos os municípios do Estado do PARANÁ cadastrados
	CREATE VIEW parana AS
    SELECT 
		cod_imovel AS codigo_imovel,
		num_area AS area,
		cod_estado AS estado,
		nom_munici AS municipio,
		num_modulo AS modulo,
		tipo_imove AS tipo_imovel,
		situacao,
		condicao_i AS condicao,
		geom AS poligono
	
    FROM municipios_br
	WHERE cod_estado = 'PR'
	ORDER BY nom_munici;
	
	-- Tabela com todos os municípios do Estado de SANTA CATARINA cadastrados
	CREATE VIEW santa_catarina AS
    SELECT 
		cod_imovel AS codigo_imovel,
		num_area AS area,
		cod_estado AS estado,
		nom_munici AS municipio,
		num_modulo AS modulo,
		tipo_imove AS tipo_imovel,
		situacao,
		condicao_i AS condicao,
		geom AS poligono
	
    FROM municipios_br
	WHERE cod_estado = 'SC'
	ORDER BY nom_munici;
	
	-- Tabela com todos os municípios do Estado de RIO GRANDE DO SUL cadastrados
	CREATE VIEW rio_grande_do_sul AS
    SELECT 
		cod_imovel AS codigo_imovel,
		num_area AS area,
		cod_estado AS estado,
		nom_munici AS municipio,
		num_modulo AS modulo,
		tipo_imove AS tipo_imovel,
		situacao,
		condicao_i AS condicao,
		geom AS poligono
	
    FROM municipios_br
	WHERE cod_estado = 'RS'
	ORDER BY nom_munici;

	-- Tabela com todos os municípios do Estado de MATO GROSSO DO SUL cadastrados
	CREATE VIEW mato_grosso_do_sul AS
    SELECT 
		cod_imovel AS codigo_imovel,
		num_area AS area,
		cod_estado AS estado,
		nom_munici AS municipio,
		num_modulo AS modulo,
		tipo_imove AS tipo_imovel,
		situacao,
		condicao_i AS condicao,
		geom AS poligono
	
    FROM municipios_br
	WHERE cod_estado = 'MS'
	ORDER BY nom_munici;
	
	-- Tabela com todos os municípios do Estado de MATO GROSSO cadastrados
	CREATE VIEW mato_grosso AS
    SELECT 
		cod_imovel AS codigo_imovel,
		num_area AS area,
		cod_estado AS estado,
		nom_munici AS municipio,
		num_modulo AS modulo,
		tipo_imove AS tipo_imovel,
		situacao,
		condicao_i AS condicao,
		geom AS poligono
	
    FROM municipios_br
	WHERE cod_estado = 'MT'
	ORDER BY nom_munici;
	
	-- Tabela com todos os municípios do Estado de GOIAS cadastrados
	CREATE VIEW goias AS
    SELECT 
		cod_imovel AS codigo_imovel,
		num_area AS area,
		cod_estado AS estado,
		nom_munici AS municipio,
		num_modulo AS modulo,
		tipo_imove AS tipo_imovel,
		situacao,
		condicao_i AS condicao,
		geom AS poligono
	
    FROM municipios_br
	WHERE cod_estado = 'GO'
	ORDER BY nom_munici;
	
	-- Tabela com todos os municípios do Estado de DISTRITO FEDERAL cadastrados
	CREATE VIEW distrito_federal AS
    SELECT 
		cod_imovel AS codigo_imovel,
		num_area AS area,
		cod_estado AS estado,
		nom_munici AS municipio,
		num_modulo AS modulo,
		tipo_imove AS tipo_imovel,
		situacao,
		condicao_i AS condicao,
		geom AS poligono
	
    FROM municipios_br
	WHERE cod_estado = 'DF'
	ORDER BY nom_munici;
	
  
