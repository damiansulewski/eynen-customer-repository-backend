CREATE SEQUENCE user_status_id_seq START 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS user_status
(
    id            BIGINT             NOT NULL
        CONSTRAINT user_status_pkey
            PRIMARY KEY,
    code          VARCHAR(20) UNIQUE NOT NULL,
    created_by    VARCHAR(60)        NOT NULL,
    created_date  TIMESTAMP          NOT NULL,
    modified_by   VARCHAR(60)        NOT NULL,
    modified_date TIMESTAMP          NOT NULL
);

CREATE SEQUENCE gender_id_seq START 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS gender
(
    id            BIGINT             NOT NULL
        CONSTRAINT gender_pkey
            PRIMARY KEY,
    code          VARCHAR(20) UNIQUE NOT NULL,
    created_by    VARCHAR(60)        NOT NULL,
    created_date  TIMESTAMP          NOT NULL,
    modified_by   VARCHAR(60)        NOT NULL,
    modified_date TIMESTAMP          NOT NULL
);

CREATE SEQUENCE user_info_id_seq START 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS user_info
(
    id            BIGINT              NOT NULL
        CONSTRAINT user_info_pkey
            PRIMARY KEY,
    email         VARCHAR(255) UNIQUE NOT NULL,
    name          VARCHAR(255)        NOT NULL,
    surname       VARCHAR(255)        NOT NULL,
    gender_id     BIGINT              NOT NULL REFERENCES gender,
    created_by    VARCHAR(60)         NOT NULL,
    created_date  TIMESTAMP           NOT NULL,
    modified_by   VARCHAR(60)         NOT NULL,
    modified_date TIMESTAMP           NOT NULL
);

CREATE SEQUENCE user_id_seq START 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS "user"
(
    id                BIGINT              NOT NULL
        CONSTRAINT user_pkey
            PRIMARY KEY,
    uuid              VARCHAR(255) UNIQUE NOT NULL,
    password          VARCHAR(255)        NOT NULL,
    user_status_id    BIGINT              NOT NULL REFERENCES user_status,
    user_info_id      BIGINT              NOT NULL REFERENCES user_info,
    registration_date TIMESTAMP           NOT NULL,
    activation_date   TIMESTAMP,
    created_by        VARCHAR(60)         NOT NULL,
    created_date      TIMESTAMP           NOT NULL,
    modified_by       VARCHAR(60)         NOT NULL,
    modified_date     TIMESTAMP           NOT NULL
);