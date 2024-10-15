--liquibase formatted sql
--changeset Minich_Nikolay:2
CREATE TABLE IF NOT EXISTS black_list
(
    id    BIGSERIAL PRIMARY KEY,
    login VARCHAR(50) NOT NULL UNIQUE REFERENCES sessions (login) ON DELETE CASCADE
);