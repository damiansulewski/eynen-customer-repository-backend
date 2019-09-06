CREATE SEQUENCE user_status_id_seq START 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS dictionary.user_status
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

CREATE TABLE IF NOT EXISTS dictionary.gender
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

CREATE SEQUENCE country_id_seq START 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS dictionary.country
(
    id            BIGINT             NOT NULL
        CONSTRAINT country_pkey
            PRIMARY KEY,
    code          VARCHAR(20) UNIQUE NOT NULL,
    created_by    VARCHAR(60)        NOT NULL,
    created_date  TIMESTAMP          NOT NULL,
    modified_by   VARCHAR(60)        NOT NULL,
    modified_date TIMESTAMP          NOT NULL
);