-- Table: public.library

-- DROP TABLE IF EXISTS public.library;

CREATE TABLE IF NOT EXISTS public.library
(
    records text COLLATE pg_catalog."default",
    type character varying(30) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT library_pkey PRIMARY KEY (type)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.library
    OWNER to postgres;