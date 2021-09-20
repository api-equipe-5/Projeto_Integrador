-- FUNÇÃO de busca por Estado e Município

CREATE OR REPLACE FUNCTION public.estadoMunicipio(IN cod_estado VARCHAR(2), nome_munici VARCHAR(60))
  RETURNS SETOF public.municipios_br AS
$BODY$
    SELECT * 
    FROM public.municipios_br 
    WHERE cod_estado = estadoMunicipio.cod_estado AND nome_munici = estadoMunicipio.nome_munici; 
    $BODY$
LANGUAGE sql;

-- select * from public.estadoMunicipio (' ',' ');


-- FUNÇÃO por Situação em estado e municipio específico
CREATE OR REPLACE FUNCTION public.situacaoEstadoMunicipio(IN cod_estado VARCHAR(2), nome_munici VARCHAR(60), situacao VARCHAR(2))
  RETURNS SETOF public.municipios_br AS
$BODY$
    SELECT * 
    FROM public.municipios_br 
    WHERE cod_estado = situacaoEstadoMunicipio.cod_estado AND nome_munici = situacaoEstadoMunicipio.nome_munici AND situacao = situacaoEstadoMunicipio.situacao; 
    $BODY$
LANGUAGE sql;

-- select * from public.situacaoEstadoMunicipio (' ',' ',' ');

-- FUNÇÃO por Situação em estado
CREATE OR REPLACE FUNCTION public.situacaoEstado(IN cod_estado VARCHAR(2),situacao VARCHAR(2))
  RETURNS SETOF public.municipios_br AS
$BODY$
    SELECT * 
    FROM public.municipios_br 
    WHERE cod_estado = situacaoEstado.cod_estado AND situacao = situacaoEstado.situacao; 
    $BODY$
LANGUAGE sql;

-- select * from public.situacaoEstado (' ',' ');

-- FUNÇÃO por Situação
CREATE OR REPLACE FUNCTION public.situacao(IN situacao VARCHAR(2))
  RETURNS SETOF public.municipios_br AS
$BODY$
    SELECT * 
    FROM public.municipios_br 
    WHERE situacao = situacao.situacao; 
    $BODY$
LANGUAGE sql;

-- select * from public.situacao (' ');

-- FUNÇÃO por Condição em estado e municipio especifico
CREATE OR REPLACE FUNCTION public.condicaoEstadoMunicipio(IN cod_estado VARCHAR(2), nome_munici VARCHAR(60), condicao VARCHAR(36))
  RETURNS SETOF public.municipios_br AS
$BODY$
    SELECT * 
    FROM public.municipios_br 
    WHERE cod_estado = condicaoEstadoMunicipio.cod_estado AND nome_munici = condicaoEstadoMunicipio.nome_munici AND condicao_i = condicaoEstadoMunicipio.condicao; 
    $BODY$
LANGUAGE sql;

-- select * from public.condicaoEstadoMunicipio (' ',' ',' ');

-- FUNÇÃO por Condição em estado
CREATE OR REPLACE FUNCTION public.condicaoEstado(IN cod_estado VARCHAR(2),condicao VARCHAR(36))
  RETURNS SETOF public.municipios_br AS
$BODY$
    SELECT * 
    FROM public.municipios_br 
    WHERE cod_estado = condicaoEstado.cod_estado AND condicao_i = condicaoEstado.condicao; 
    $BODY$
LANGUAGE sql;

-- select * from public.condicaoEstado(' ',' ');

-- FUNÇÃO por Condição
CREATE OR REPLACE FUNCTION public.condicao(IN condicao VARCHAR(36))
  RETURNS SETOF public.municipios_br AS
$BODY$
    SELECT * 
    FROM public.municipios_br 
    WHERE condicao_i = condicao.condicao; 
    $BODY$
LANGUAGE sql;

-- select * from public.condicao (' ');

-- FUNÇÃO por Tipo de Imóvel em estado e municipio especifico
CREATE OR REPLACE FUNCTION public.tipoImovelEstadoMunicipio(IN cod_estado VARCHAR(2), nome_munici VARCHAR(60), tipo_imovel VARCHAR(3))
  RETURNS SETOF public.municipios_br AS
$BODY$
    SELECT * 
    FROM public.municipios_br 
    WHERE cod_estado = tipoImovelEstadoMunicipio.cod_estado AND nome_munici = tipoImovelEstadoMunicipio.nome_munici AND tipo_imove = tipoImovelEstadoMunicipio.tipo_imovel; 
    $BODY$
LANGUAGE sql;

-- select * from public.tipoImovelEstadoMunicipio (' ',' ',' ');

-- FUNÇÃO por Tipo de Imóvel em estado
CREATE OR REPLACE FUNCTION public.tipoImovelEstado(IN cod_estado VARCHAR(2), tipo_imovel VARCHAR(3))
  RETURNS SETOF public.municipios_br AS
$BODY$
    SELECT * 
    FROM public.municipios_br 
    WHERE cod_estado = tipoImovelEstadoMunicipio.cod_estado AND tipo_imove = tipoImovelEstadoMunicipio.tipo_imovel; 
    $BODY$
LANGUAGE sql;

-- select * from public.tipoImovelEstado(' ',' ');

-- FUNÇÃO por Tipo de Imóvel
CREATE OR REPLACE FUNCTION public.tipoImovel(IN tipo_imovel VARCHAR(3))
  RETURNS SETOF public.municipios_br AS
$BODY$
    SELECT * 
    FROM public.municipios_br 
    WHERE tipo_imove = tipoImovel.tipo_imovel; 
    $BODY$
LANGUAGE sql;

-- select * from public.tipoImovel(' ');