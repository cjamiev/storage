-- Create Table
CREATE TABLE IF NOT EXISTS public.name
(
    id character varying(50) COLLATE pg_catalog."default" NOT NULL,
    is_first_name boolean DEFAULT true,
    CONSTRAINT name_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.name
    OWNER to postgres;

-- Delete Table
DROP TABLE IF EXISTS public.name;


-- Insert into Table
INSERT INTO public.name(
	id, is_first_name)
	VALUES ('', true);