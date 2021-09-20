CREATE TABLE IF NOT EXISTS "class"
(
    "id"          SERIAL PRIMARY KEY,
    "name"        TEXT NOT NULL,
    "total_hours" INT  NOT NULL DEFAULT 0,
    "professor"   INT REFERENCES user_account (id)
);
