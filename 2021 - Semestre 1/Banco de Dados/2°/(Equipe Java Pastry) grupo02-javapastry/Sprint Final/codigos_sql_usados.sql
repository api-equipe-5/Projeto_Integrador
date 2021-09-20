
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[area_imovel](
	[ogr_fid] [int] IDENTITY(1,1) NOT NULL,
	[GEOM] [geometry] NULL,
	[cod_imovel] [nvarchar](100) NULL,
	[num_area] [numeric](32, 10) NULL,
	[cod_estado] [nvarchar](2) NULL,
	[nom_munici] [nvarchar](60) NULL,
	[num_modulo] [numeric](32, 10) NULL,
	[tipo_imove] [nvarchar](3) NULL,
	[situacao] [nvarchar](2) NULL,
	[condicao_i] [nvarchar](85) NULL)
 



-- FUNÇÃO PARA SELECT DOS DADOS NO FORMATO UTF-8 COM ACENTOS

CREATE FUNCTION dbo.DecodeUTF8String (@value varchar(max))
RETURNS nvarchar(max)
AS
BEGIN
    -- Transforms a UTF-8 encoded varchar string into Unicode
    -- By Anthony Faull 2014-07-31
    DECLARE @result nvarchar(max);

    -- If ASCII or null there's no work to do
    IF (@value IS NULL
        OR @value NOT LIKE '%[^ -~]%' COLLATE Latin1_General_BIN
    )
        RETURN @value;

    -- Generate all integers from 1 to the length of string
    WITH e0(n) AS (SELECT TOP(POWER(2,POWER(2,0))) NULL FROM (VALUES (NULL),(NULL)) e(n))
        , e1(n) AS (SELECT TOP(POWER(2,POWER(2,1))) NULL FROM e0 CROSS JOIN e0 e)
        , e2(n) AS (SELECT TOP(POWER(2,POWER(2,2))) NULL FROM e1 CROSS JOIN e1 e)
        , e3(n) AS (SELECT TOP(POWER(2,POWER(2,3))) NULL FROM e2 CROSS JOIN e2 e)
        , e4(n) AS (SELECT TOP(POWER(2,POWER(2,4))) NULL FROM e3 CROSS JOIN e3 e)
        , e5(n) AS (SELECT TOP(POWER(2.,POWER(2,5)-1)-1) NULL FROM e4 CROSS JOIN e4 e)
    , numbers(position) AS
    (
        SELECT TOP(DATALENGTH(@value)) ROW_NUMBER() OVER (ORDER BY (SELECT NULL))
        FROM e5
    )
    -- UTF-8 Algorithm (http://en.wikipedia.org/wiki/UTF-8)
    -- For each octet, count the high-order one bits, and extract the data bits.
    , octets AS
    (
        SELECT position, highorderones, partialcodepoint
        FROM numbers a
        -- Split UTF8 string into rows of one octet each.
        CROSS APPLY (SELECT octet = ASCII(SUBSTRING(@value, position, 1))) b
        -- Count the number of leading one bits
        CROSS APPLY (SELECT highorderones = 8 - FLOOR(LOG( ~CONVERT(tinyint, octet) * 2 + 1)/LOG(2))) c
        CROSS APPLY (SELECT databits = 7 - highorderones) d
        CROSS APPLY (SELECT partialcodepoint = octet % POWER(2, databits)) e
    )
    -- Compute the Unicode codepoint for each sequence of 1 to 4 bytes
    , codepoints AS
    (
        SELECT position, codepoint
        FROM
        (
            -- Get the starting octect for each sequence (i.e. exclude the continuation bytes)
            SELECT position, highorderones, partialcodepoint
            FROM octets
            WHERE highorderones <> 1
        ) lead
        CROSS APPLY (SELECT sequencelength = CASE WHEN highorderones in (1,2,3,4) THEN highorderones ELSE 1 END) b
        CROSS APPLY (SELECT endposition = position + sequencelength - 1) c
        CROSS APPLY
        (
            -- Compute the codepoint of a single UTF-8 sequence
            SELECT codepoint = SUM(POWER(2, shiftleft) * partialcodepoint)
            FROM octets
            CROSS APPLY (SELECT shiftleft = 6 * (endposition - position)) b
            WHERE position BETWEEN lead.position AND endposition
        ) d
    )
    -- Concatenate the codepoints into a Unicode string
    SELECT @result = CONVERT(xml,
        (
            SELECT NCHAR(codepoint)
            FROM codepoints
            ORDER BY position
            FOR XML PATH('')
        )).value('.', 'nvarchar(max)');

    RETURN @result;
END
GO;




--VIEW PARA O SELECT GERAL --

CREATE view [dbo].[consulta] as
SELECT ogr_fid,GEOM,cod_imovel,num_area,cod_estado,nom_munici = dbo.DecodeUTF8String(nom_munici),num_modulo,tipo_imove,situacao, condicao_i = dbo.DecodeUTF8String(condicao_i)
FROM area_imovel2
WHERE condicao_i <> dbo.DecodeUTF8String(condicao_i)
and nom_munici <> dbo.DecodeUTF8String(nom_munici)
GO

