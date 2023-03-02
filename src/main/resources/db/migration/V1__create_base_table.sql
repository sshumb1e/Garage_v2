CREATE TABLE IF NOT EXISTS "owner"
(
    owner_id integer NOT NULL GENERATED ALWAYS AS IDENTITY,
    name text NOT NULL,
    age integer NULL,
    PRIMARY KEY (owner_id)
);

CREATE TABLE IF NOT EXISTS "car"
(
    car_id integer NOT NULL GENERATED ALWAYS AS IDENTITY,
    brand text NOT NULL,
    colour text NOT NULL,
    owner_id integer NULL,
    PRIMARY KEY (car_id)
);