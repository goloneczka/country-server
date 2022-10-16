CREATE SCHEMA IF NOT EXISTS country;

CREATE TABLE IF NOT EXISTS country.LOCATION (
    id SERIAL PRIMARY KEY,
    name VARCHAR(1024) not null,
    city VARCHAR(127),
    latitude REAL,
    longitude REAL
)
