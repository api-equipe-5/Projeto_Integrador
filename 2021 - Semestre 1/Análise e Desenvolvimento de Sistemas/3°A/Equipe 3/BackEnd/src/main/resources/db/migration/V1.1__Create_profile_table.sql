CREATE TABLE IF NOT EXISTS "user_account"
(
    "id"       SERIAL PRIMARY KEY,
    "name"     TEXT        NOT NULL,
    "email"    TEXT        NOT NULL,
    "password" TEXT        NOT NULL,
    "role"     VARCHAR(10) NOT NULL
);
