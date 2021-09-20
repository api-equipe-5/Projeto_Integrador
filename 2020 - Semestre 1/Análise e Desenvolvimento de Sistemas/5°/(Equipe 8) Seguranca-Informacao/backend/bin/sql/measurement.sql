CREATE TABLE measurement_tbl(
    id                SERIAL PRIMARY KEY,
    "measurementDate" TIMESTAMP NOT NULL,
    "measurementData" BYTEA,
    "deviceId"        INTEGER,
    FOREIGN KEY ("deviceId") REFERENCES device_tbl(id) ON DELETE CASCADE
);