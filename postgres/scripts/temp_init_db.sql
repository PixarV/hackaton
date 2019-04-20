-- Table: public.temp

--DROP TABLE public.temp;

CREATE TABLE public.temp
(
    id serial,
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT temp_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.temp
    OWNER to postgres;