-- Create Table
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

-- Delete Table
DROP TABLE IF EXISTS public.location;

-- Insert into Table
INSERT INTO public.location(
	code, state, cities)
	VALUES (?, ?, ?);



