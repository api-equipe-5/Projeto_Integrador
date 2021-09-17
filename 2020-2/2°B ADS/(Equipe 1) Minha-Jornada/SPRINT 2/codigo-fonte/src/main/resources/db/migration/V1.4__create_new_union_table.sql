create TABLE IF NOT EXISTS "union" (
    "id" bigserial NOT NULL PRIMARY KEY,
    "name" character varying (100) NOT NULL,
    "working_hours" integer NOT NULL,
    "resting_hours" decimal(8,2) NOT NULL,
    "first_fraction" integer NOT NULL,
    "second_fraction" integer NOT NULL,
    "third_fraction" integer NOT NULL,
    "lunch_time" integer NOT NULL,
    "time_off" decimal(8,2) NOT NULL,
    "allowed_extra_hours" integer,
    "allowed_clock_hours" integer
);