CREATE TABLE portData_tbl(
    id                SERIAL PRIMARY KEY,
    "accountId" INTEGER REFERENCES account_tbl(id) ON DELETE CASCADE
);