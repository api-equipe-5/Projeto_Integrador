create TABLE IF NOT EXISTS "driver" (
    "id" bigserial NOT NULL PRIMARY KEY,
    "name" character varying (100) NOT NULL,
    "surname" character varying (100) NOT NULL,
    "category_license" character varying (10) NOT NULL,
    "year_admission" integer NOT NULL,
    "telephone" character varying (10) NOT NULL,
    "union" character varying (100) NOT NULL,
    "email" character varying (100) NOT NULL
);