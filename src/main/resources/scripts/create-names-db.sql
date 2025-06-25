-- Table: main.names

-- DROP TABLE IF EXISTS main.names;

CREATE TABLE IF NOT EXISTS main.names
(
    name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    gender character varying(30) COLLATE pg_catalog."default",
    origin character varying(100) COLLATE pg_catalog."default",
    is_real_name boolean,
    CONSTRAINT names_pkey PRIMARY KEY (name)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS main.names
    OWNER to postgres;