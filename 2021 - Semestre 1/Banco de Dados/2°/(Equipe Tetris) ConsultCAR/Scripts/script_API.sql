USE ConsultCar;

CREATE TABLE municipios_br(
	gid		SERIAL,
	cod_imovel	VARCHAR(100),
	num_area	NUMERIC,
	cod_estado	VARCHAR(2),
	nome_munici	VARCHAR(60),
	num_modulo	NUMERIC,
	tipo_imove	VARCHAR(3),
	situacao	VARCHAR(2),
	condicao_i	VARCHAR(36),
	geom		GEOMETRY
)
;

ALTER TABLE municipios_br ADD cod_imovel VARCHAR(100) null; 

ALTER TABLE municipios_br ADD gid SERIAL;

ALTER TABLE municipios_br ADD num_area NUMERIC;

ALTER TABLE municipios_br ADD cod_estado VARCHAR(2);

ALTER TABLE municipios_br ADD nome_munici VARCHAR(60);

ALTER TABLE municipios_br ADD num_modulo NUMERIC;

ALTER TABLE municipios_br ADD tipo_imove VARCHAR(3);

ALTER TABLE municipios_br ADD situacao	VARCHAR(2);

ALTER TABLE municipios_br ADD condicao_i VARCHAR(36);

ALTER TABLE municipios_br ADD PRIMARY KEY (gid);

SELECT AddGeometryColumn('','municipios_br','geom','4674','MULTIPOLYGON',2);

ALTER TABLE municipios_br DROP COLUMN cod_imovel;

