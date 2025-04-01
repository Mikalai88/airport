CREATE TABLE location (
    id SERIAL PRIMARY KEY,
    city VARCHAR(100),
    country VARCHAR(100)
);

CREATE TABLE luggage (
    id SERIAL PRIMARY KEY,
    weight DECIMAL(5,2)
);

CREATE TABLE personal (
    id SERIAL PRIMARY KEY,
    type VARCHAR(100),
    name VARCHAR(100),
    date_of_birth DATE
);

CREATE TABLE airplane (
    id SERIAL PRIMARY KEY,
    model VARCHAR(100),
    capacity INT
);

CREATE TABLE passanger (
    id SERIAL PRIMARY KEY,
    passport VARCHAR(50),
    name VARCHAR(100),
    email VARCHAR(100)
);

CREATE TABLE route (
    id SERIAL PRIMARY KEY,
    airplaneId INT REFERENCES airplane(id),
    arrivalTime TIMESTAMP,
    departureTime TIMESTAMP,
    arrivalLocationId INT REFERENCES location(id),
    departureLocationId INT REFERENCES location(id)
);

CREATE TABLE airplane_personal (
    airplaneId INT REFERENCES airplane(id),
    personalId INT REFERENCES personal(id),
    PRIMARY KEY (airplaneId, personalId)
);

CREATE TYPE ticket_class AS ENUM ('economy', 'comfort', 'business');

CREATE TABLE ticket (
    id SERIAL PRIMARY KEY,
    routeId INT REFERENCES route(id),
    passangerId INT REFERENCES passanger(id),
    passport VARCHAR(50),
    personalId INT REFERENCES personal(id),
    class ticket_class,
    luggageId INT REFERENCES luggage(id)
);

