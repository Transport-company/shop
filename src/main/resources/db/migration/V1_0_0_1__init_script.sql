CREATE TABLE IF NOT EXISTS shop
(
    id      bigserial        PRIMARY KEY,
    name    varchar(255)     NOT NULL,
    city    varchar(128)     NOT NULL
);

CREATE TABLE IF NOT EXISTS address
(
    id           bigserial          PRIMARY KEY,
    region       varchar(128)       NOT NULL,
    city         varchar(128)       NOT NULL,
    street       varchar(255)       ,
    house        varchar(16)        NOT NULL,
    apartment    varchar(16)        ,
    created      timestamp          NOT NULL,
    updated      timestamp          NOT NULL
);

CREATE TABLE IF NOT EXISTS item
(
    id           bigserial          PRIMARY KEY,
    name         varchar(255)       NOT NULL,
    price        float              NOT NULL,
    weight       float              NOT NULL,
    length       float              NOT NULL,
    width        float              NOT NULL,
    height       float              NOT NULL,
    created      timestamp          NOT NULL,
    updated      timestamp          NOT NULL
);

CREATE TABLE IF NOT EXISTS customer
(
    id           bigserial          PRIMARY KEY,
    surname      varchar(50)        ,
    name         varchar(50)        NOT NULL,
    patronymic   varchar(50)        ,
    birthday     timestamp          NOT NULL,
    phone        varchar(11)        NOT NULL,
    email        varchar(62)        NOT NULL,
    created      timestamp          NOT NULL,
    updated      timestamp          NOT NULL
);

CREATE TABLE IF NOT EXISTS delivery
(
    id                   bigserial      PRIMARY KEY,
    declared_value       decimal        NOT NULL,
    tracking_number      varchar(30)    NOT NULL,
    shipping_address_id  int8           NOT NULL,
    sending_address_id   int8           NOT NULL,
    customer_id          int8           NOT NULL,
    status               varchar(10)    NOT NULL,
    created              timestamp      NOT NULL,
    updated              timestamp      NOT NULL,
    FOREIGN KEY (shipping_address_id) REFERENCES address(id),
    FOREIGN KEY (sending_address_id) REFERENCES address(id),
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TABLE IF NOT EXISTS cart_line
(
    id          bigserial PRIMARY KEY,
    item_id     int8      NOT NULL,
    amount      int8     NOT NULL,
    FOREIGN KEY (item_id) REFERENCES item(id)
);

CREATE TABLE IF NOT EXISTS cart
(
    id          bigserial PRIMARY KEY,
    cart_lines  int8      NOT NULL,
    total_price decimal   NOT NULL,
    FOREIGN KEY (cart_lines) REFERENCES cart_line(id)
)

