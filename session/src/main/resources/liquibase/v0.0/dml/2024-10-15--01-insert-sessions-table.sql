--liquibase formatted sql
--changeset Minich_Nikolay:4
INSERT INTO sessions (login)
VALUES ('One'),
       ('Two'),
       ('Three');