-- Table: main.shows

-- DROP TABLE IF EXISTS main.shows;

CREATE TABLE IF NOT EXISTS main.shows
(
    name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    platforms character varying(100) COLLATE pg_catalog."default",
    genre character varying(100) COLLATE pg_catalog."default",
    is_film boolean,
    CONSTRAINT shows_pkey PRIMARY KEY (name)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS main.shows
    OWNER to postgres;