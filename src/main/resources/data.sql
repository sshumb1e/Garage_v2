CREATE TABLE IF NOT EXISTS "owner"
(
    owner_id integer NOT NULL AUTO_INCREMENT,
    name text NOT NULL,
    age integer NULL,
    PRIMARY KEY (owner_id)
    );

INSERT INTO "owner"(
    name,age)
VALUES ('Tomas', 24), ('James', 55);

CREATE TABLE IF NOT EXISTS "car"
(
    car_id integer NOT NULL AUTO_INCREMENT,
    brand text NOT NULL,
    colour text NOT NULL,
    owner_id integer NULL,
    PRIMARY KEY (car_id)
    );

INSERT INTO "car"(
    brand, colour)
VALUES ('Nissan', 'Yellow');

INSERT INTO "car"(
    brand, colour, owner_id)
VALUES ('Ford', 'Gray', 1);