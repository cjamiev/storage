-- Create Table
CREATE TABLE IF NOT EXISTS public.library
(
    records text COLLATE pg_catalog."default",
    type character varying(30) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT library_pkey PRIMARY KEY (type)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.library
    OWNER to postgres;

-- Delete Table
DROP TABLE IF EXISTS public.library;

-- Insert into Table
INSERT INTO public.library(
	records, type)
	VALUES ('', 'readme');

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
	VALUES ('[]', 'passwords');

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

-- Delete row
DELETE FROM public.library
	WHERE type = '<type>';

-- Clear all entries
UPDATE public.library
	SET records = '[]';