CREATE TABLE test.filme
(
    id integer NOT NULL,
    nome character varying(200) COLLATE pg_catalog."default",
    genero character varying(200) COLLATE pg_catalog."default",
    CONSTRAINT filme_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE test.seq_filme
    INCREMENT 1
    START 236
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

CREATE TABLE test.recommendation
(
    id integer NOT NULL,
    nome character varying(200) COLLATE pg_catalog."default",
    CONSTRAINT filme_r4u_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE test.seq_recommendation
    INCREMENT 1
    START 236
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
