-- Create Table
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

-- Delete Table
DROP TABLE IF EXISTS public.password;

-- Insert into Table
INSERT INTO public.password(
	id, username, password, url, created_date, tags, history)
	VALUES ('', '', '', '', '', '', '');

-- Update Row
UPDATE public.password
	SET password=?, url=?, created_date=?, tags=?, history=?
	WHERE id = '';