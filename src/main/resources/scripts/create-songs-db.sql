-- Table: main.songs

-- DROP TABLE IF EXISTS main.songs;

CREATE TABLE IF NOT EXISTS main.songs
(
    id character varying(200) COLLATE pg_catalog."default" NOT NULL,
    name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    album character varying(100) COLLATE pg_catalog."default" NOT NULL,
    platforms character varying(100) COLLATE pg_catalog."default",
    interest character varying(30) COLLATE pg_catalog."default",
    link character varying(200) COLLATE pg_catalog."default",
    CONSTRAINT songs_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS main.songs
    OWNER to postgres;