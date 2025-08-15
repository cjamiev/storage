-- Create Table
CREATE TABLE IF NOT EXISTS public.city
(
    id character varying(50) COLLATE pg_catalog."default" NOT NULL,
    origin character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT city_pkey1 PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.city
    OWNER to postgres;

-- Delete Table
DROP TABLE IF EXISTS public.city;

-- Insert into Table
INSERT INTO public.city(id, origin)
	VALUES (?, ?);