CREATE TABLE IF NOT EXISTS public.cs5_types_names
(
    id int NOT NULL,
    name character varying(255) NOT NULL,
    CONSTRAINT cs5_types_names_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS public.cs5_types_names_seq
    INCREMENT 1
    START 9
    MINVALUE 1
    MAXVALUE 10000
    CACHE 1;
    
INSERT INTO public.cs5_types_names VALUES (1, 'NoneType');
INSERT INTO public.cs5_types_names VALUES (2, 'pollutionEvidence');
INSERT INTO public.cs5_types_names VALUES (3, 'pollutionSource');
INSERT INTO public.cs5_types_names VALUES (4, 'flowImpedance');
INSERT INTO public.cs5_types_names VALUES (5, 'invasivePlant');
INSERT INTO public.cs5_types_names VALUES (6, 'wildlife');
INSERT INTO public.cs5_types_names VALUES (7, 'bankVegetation');
INSERT INTO public.cs5_types_names VALUES (8, 'landUse');

CREATE TABLE IF NOT EXISTS public.cs5_types
(
    id int NOT NULL,
    name character varying(255) NOT NULL,
    type int NOT NULL,
    CONSTRAINT cs5_types_pkey PRIMARY KEY (id),
    CONSTRAINT cs5_types_names_fkey FOREIGN KEY (type)
        REFERENCES public.cs5_types_names (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE SEQUENCE IF NOT EXISTS public.cs5_types_seq
    INCREMENT 1
    START 2
    MINVALUE 1
    MAXVALUE 10000
    CACHE 1;
    
INSERT INTO public.cs5_types VALUES (1, 'None', 1);

CREATE TABLE IF NOT EXISTS public.cs5_data
(
    id UUID not null,
    unnamed_0 int,
    coordinate geometry(Point,4326),
    water_body_type character varying(255),
    dynamic_risk_assessment boolean,
    estimated_width double precision,
    estimated_depth double precision,
    water_flow character varying(255),
    water_level character varying(255),
    temperature double precision,
    total_dissolved_solids double precision,
    turbidity double precision,
    phosphate double precision,
    ph double precision,
    nitrate double precision,
    ammonia double precision,
    Date date,
    pollution_evidence int[],
    pollution_source int[],
    flow_impedance int[],
    invasive_plant int[],
    wildlife int[],
    bank_vegetation int[],
    land_use int[],    
    CONSTRAINT cs5_data_pkey PRIMARY KEY (id)
);
    
CREATE OR REPLACE FUNCTION ST_Cs5DataToGeoJson()
RETURNS jsonb AS
$BODY$
    SELECT jsonb_build_object(
        'type',     'FeatureCollection',
        'features', jsonb_agg(feature)
    )
    FROM (
      SELECT jsonb_build_object(
        'type',       'Feature',
        'id',         row.id,
        'geometry',   ST_AsGeoJSON(coordinate)::jsonb,
        'properties', to_jsonb(row) - 'id' - 'lat' - 'long'
      ) AS feature
      FROM (SELECT * FROM public.cs5_data) row) features;
$BODY$
LANGUAGE SQL;