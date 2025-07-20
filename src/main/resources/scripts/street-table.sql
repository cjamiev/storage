-- Create Table
CREATE TABLE IF NOT EXISTS public.street
(
    id character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT street_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.street
    OWNER to postgres;

-- Delete Table
DROP TABLE IF EXISTS public.street;

-- Insert Into Table
INSERT INTO public.street(
	id)
	VALUES ('');

