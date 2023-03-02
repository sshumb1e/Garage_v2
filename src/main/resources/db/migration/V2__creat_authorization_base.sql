CREATE TABLE IF NOT EXISTS "authorization"
(
    name text NOT NULL,
    password text NOT NULL,
    role text NOT NULL,
    PRIMARY KEY (name)
    );

INSERT INTO "authorization"(
    name, password, role)
VALUES ('admin', '$2a$10$lJmMXHCk7zrVjTHgS0APUOzhOZpY598.Fhs4rsIce8IiZpYU6mRD2', 'ADMIN'),
       ('user', '$2a$12$AJLrYIt45IK2t/QjVeFSUuV0.EakWOjQikMQ1PXsl/fz13yyc6vda', 'USER');