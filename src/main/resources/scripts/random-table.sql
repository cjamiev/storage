-- Create Table
CREATE TABLE IF NOT EXISTS public.random
(
    id character varying(50) COLLATE pg_catalog."default" NOT NULL,
    type character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT random_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.random
    OWNER to postgres;

-- Delete Table
DROP TABLE IF EXISTS public.random;

-- Insert into Table
INSERT INTO public.random(
	id, type)
	VALUES ('', '');