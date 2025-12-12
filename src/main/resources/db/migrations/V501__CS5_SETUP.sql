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
    water_body_type character varying(20),
    dynamic_risk_assessment boolean,
    estimated_width double precision,
    estimated_depth double precision,
    water_flow character varying(20),
    water_level character varying(20),
    temperature double precision,
    total_dissolved_solids double precision,
    turbidity double precision,
    phosphate double precision,
    ph double precision,
    nitrate character varying(20),
    ammonia character varying(20),
    Date date,
    CONSTRAINT cs5_data_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.cs5_data_types
(
    data_id uuid NOT NULL,
    types_id int NOT NULL,
    CONSTRAINT cs5_data_types_pkey PRIMARY KEY (data_id, types_id),
    CONSTRAINT cs5_data_types_data_fkey FOREIGN KEY (data_id)
        REFERENCES public.cs5_data (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT cs5_data_types_types_fkey FOREIGN KEY (types_id)
        REFERENCES public.cs5_types (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE OR REPLACE FUNCTION ST_CS5DataPropertiesToJson(data_id uuid, property_name text)
RETURNS jsonb AS
$BODY$
      SELECT jsonb_build_object(
	           $2, jsonb_path_query(to_jsonb(property), '$.array')
	          )
      FROM (SELECT ARRAY(SELECT t.name FROM public.cs5_data as d 
	  join public.cs5_data_types as o on d.id = o.data_id 
	  join public.cs5_types as t on t.id = o.types_id 
	  join public.cs5_types_names as tn on tn.id = t.type where d.id = $1 and tn.name ilike $2))  property;
$BODY$
LANGUAGE SQL;


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
        'properties', to_jsonb(row) - 'id' - 'coordinate' || ST_CS5DataPropertiesToJson(row.id, 'landUse')
		|| ST_CS5DataPropertiesToJson(row.id, 'pollutionEvidence')
		|| ST_CS5DataPropertiesToJson(row.id, 'pollutionSource')
		|| ST_CS5DataPropertiesToJson(row.id, 'flowImpedance')
		|| ST_CS5DataPropertiesToJson(row.id, 'invasivePlant')
		|| ST_CS5DataPropertiesToJson(row.id, 'wildlife')
		|| ST_CS5DataPropertiesToJson(row.id, 'bankVegetation')
		|| ST_CS5DataPropertiesToJson(row.id, 'landUse')
      ) AS feature
      FROM (SELECT * FROM public.cs5_data) row) features;
$BODY$
LANGUAGE SQL;