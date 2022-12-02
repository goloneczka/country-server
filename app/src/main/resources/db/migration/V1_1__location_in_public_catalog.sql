CREATE TABLE IF NOT EXISTS LOCATION (
    id SERIAL PRIMARY KEY,
    name VARCHAR(1024) not null,
    city VARCHAR(127),
    latitude REAL,
    longitude REAL
);

DROP TABLE country.LOCATION;

DROP SCHEMA country;

