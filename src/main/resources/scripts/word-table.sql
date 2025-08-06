-- Create Table
CREATE TABLE IF NOT EXISTS public.word
(
    id character varying(50) COLLATE pg_catalog."default" NOT NULL,
    type character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT word_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.word
    OWNER to postgres;

-- Delete Table
DROP TABLE IF EXISTS public.word;

-- Insert into Table
INSERT INTO public.word(
	id, type)
	VALUES ('', '');