-- Table: main.games

-- DROP TABLE IF EXISTS main.games;

CREATE TABLE IF NOT EXISTS main.games
(
    name character varying(200) COLLATE pg_catalog."default" NOT NULL,
    genre character varying(100) COLLATE pg_catalog."default" NOT NULL,
    price character varying(30) COLLATE pg_catalog."default",
    lowest_price character varying(30) COLLATE pg_catalog."default",
    interest character varying(30) COLLATE pg_catalog."default",
    release_date character varying(100) COLLATE pg_catalog."default",
    notes text COLLATE pg_catalog."default",
    CONSTRAINT games_pkey PRIMARY KEY (name)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS main.games
    OWNER to postgres;