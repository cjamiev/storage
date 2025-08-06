-- Used to reset storage_test table

-- Drop Tables
DROP TABLE IF EXISTS public.email;
DROP TABLE IF EXISTS public.library;
DROP TABLE IF EXISTS public.location;
DROP TABLE IF EXISTS public.name;
DROP TABLE IF EXISTS public.password;
DROP TABLE IF EXISTS public.random;
DROP TABLE IF EXISTS public.street;

-- Recreate Tables
CREATE TABLE IF NOT EXISTS public.email
(
    id character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT email_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.email
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.library
(
    records text COLLATE pg_catalog."default",
    type character varying(30) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT library_pkey PRIMARY KEY (type)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.library
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.location
(
    code character varying(2) COLLATE pg_catalog."default" NOT NULL,
    state character varying(30) COLLATE pg_catalog."default" NOT NULL,
    cities text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT city_pkey PRIMARY KEY (code)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.location
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.name
(
    id character varying(50) COLLATE pg_catalog."default" NOT NULL,
    is_first_name boolean DEFAULT true,
    is_last_name boolean NOT NULL DEFAULT false,
    gender "char" NOT NULL,
    CONSTRAINT name_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.name
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.password
(
    id character varying(50) COLLATE pg_catalog."default" NOT NULL,
    username character varying(50) COLLATE pg_catalog."default" NOT NULL,
    password character varying(50) COLLATE pg_catalog."default" NOT NULL,
    url character varying(100) COLLATE pg_catalog."default",
    created_date character varying(30) COLLATE pg_catalog."default" NOT NULL,
    tags text COLLATE pg_catalog."default",
    history text COLLATE pg_catalog."default",
    CONSTRAINT password_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.password
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.random
(
    id character varying(50) COLLATE pg_catalog."default" NOT NULL,
    type character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT random_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.random
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.street
(
    id character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT street_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.street
    OWNER to postgres;

-- Reset Entries
INSERT INTO public.library(
	records, type)
	VALUES ('[]', 'constructed-words');

INSERT INTO public.library(
	records, type)
	VALUES ('[]', 'words');

INSERT INTO public.library(
	records, type)
	VALUES ('[]', 'word-parts');

INSERT INTO public.library(
	records, type)
	VALUES ('[]', 'phrases');

INSERT INTO public.library(
	records, type)
	VALUES ('[]', 'references');

INSERT INTO public.library(
	records, type)
	VALUES ('[]', 'names');

INSERT INTO public.library(
	records, type)
	VALUES ('[]', 'games');

INSERT INTO public.library(
	records, type)
	VALUES ('[]', 'songs');

INSERT INTO public.library(
	records, type)
	VALUES ('[]', 'films');

INSERT INTO public.library(
	records, type)
	VALUES ('[]', 'shows');

INSERT INTO public.library(
	records, type)
	VALUES ('[]', 'books');

INSERT INTO public.library(
	records, type)
	VALUES ('[]', 'projects');

INSERT INTO public.library(
	records, type)
	VALUES ('[]', 'purchases');

INSERT INTO public.library(
	records, type)
	VALUES ('[]', 'countdowns');

INSERT INTO public.library(
	records, type)
	VALUES ('[]', 'favorites');

INSERT INTO public.library(
	records, type)
	VALUES ('[]', 'contacts');

INSERT INTO public.library(
	records, type)
	VALUES ('[]', 'notes');