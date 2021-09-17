create TABLE IF NOT EXISTS "user" (
    "id" SERIAL PRIMARY KEY,
    "name" varchar(30) UNIQUE  NOT NULL,
    "password" varchar(30)  NOT NULL,
    "profile" varchar(30)  NOT NULL
);