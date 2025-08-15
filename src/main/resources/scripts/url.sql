-- Create Table
CREATE TABLE IF NOT EXISTS public.url
(
    id character varying(200) COLLATE pg_catalog."default" NOT NULL,
    category character varying(30) COLLATE pg_catalog."default",
    CONSTRAINT url_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.url
    OWNER to postgres;

-- Delete Table
DROP TABLE IF EXISTS public.url;

-- Insert into Table
INSERT INTO public.city(id, category)
  	VALUES (?, ?);