CREATE TABLE IF NOT EXISTS shop
(
    id      bigserial        PRIMARY KEY,
    name    varchar(255)     NOT NULL,
    city    varchar(128)     NOT NULL
);

CREATE TABLE IF NOT EXISTS cargo
(
    id        bigserial    PRIMARY KEY,
    client    varchar(128) NOT NULL,
    city      varchar(128) NOT NULL,
    address   varchar(128) NOT NULL,
    shop_id   int8         NOT NULL,
    FOREIGN KEY (shop_id) REFERENCES shop(id)
);

CREATE TABLE IF NOT EXISTS delivery
(
    id        bigserial   PRIMARY KEY,
    cargo_id  int8        NOT NULL,
    status    varchar(10) NOT NULL,
    FOREIGN KEY (cargo_id) REFERENCES cargo(id)
);
