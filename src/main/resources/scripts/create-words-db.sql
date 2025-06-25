-- Table: main.words

-- DROP TABLE IF EXISTS main.words;

CREATE TABLE IF NOT EXISTS main.words
(
    name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    type character varying(30) COLLATE pg_catalog."default",
    definition text COLLATE pg_catalog."default",
    is_real_word boolean,
    tags character varying(100) COLLATE pg_catalog."default",
    CONSTRAINT words_pkey PRIMARY KEY (name)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS main.words
    OWNER to postgres;