-- Create Table
CREATE TABLE IF NOT EXISTS public.email
(
    id character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT email_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.email
    OWNER to postgres;

-- Delete Table
DROP TABLE IF EXISTS public.email;

-- Insert into Table
INSERT INTO public.email(
	id)
	VALUES ('');