--liquibase formatted sql
--changeset Minich_Nikolay:1
CREATE TABLE IF NOT EXISTS sessions
(
    id           BIGSERIAL PRIMARY KEY,
    login        VARCHAR(50) NOT NULL UNIQUE,
    opening_time TIMESTAMP   NOT NULL default now()
);