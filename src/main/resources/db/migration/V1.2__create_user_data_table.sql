CREATE SEQUENCE address_id_seq START 1 INCREMENT 1;

CREATE TABLE IF NOT EXISTS address
(
    id               BIGINT       NOT NULL
        CONSTRAINT address_pkey
            PRIMARY KEY,
    street           VARCHAR(255) NOT NULL,
    house_number     VARCHAR(255) NOT NULL,
    apartment_number VARCHAR(255),
    post_code        VARCHAR(255) NOT NULL,
    city             VARCHAR(255) NOT NULL,
    country_id       BIGINT       NOT NULL REFERENCES dictionary.country,
    created_by       VARCHAR(60)  NOT NULL,
    created_date     TIMESTAMP    NOT NULL,
    modified_by      VARCHAR(60)  NOT NULL,
    modified_date    TIMESTAMP    NOT NULL
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
    gender_id     BIGINT              NOT NULL REFERENCES dictionary.gender,
    address_id    BIGINT REFERENCES address,
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
    user_status_id    BIGINT              NOT NULL REFERENCES dictionary.user_status,
    user_info_id      BIGINT              NOT NULL REFERENCES user_info,
    registration_date TIMESTAMP           NOT NULL,
    activation_date   TIMESTAMP,
    created_by        VARCHAR(60)         NOT NULL,
    created_date      TIMESTAMP           NOT NULL,
    modified_by       VARCHAR(60)         NOT NULL,
    modified_date     TIMESTAMP           NOT NULL
);