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

CREATE TABLE IF NOT EXISTS orders
(
    id           bigserial          PRIMARY KEY,
    order_number decimal            NOT NULL,
    customer_id  int8               NOT NULL,
    created      timestamp          NOT NULL,
    updated      timestamp          NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TABLE IF NOT EXISTS order_details
(
    id           bigserial          PRIMARY KEY,
    order_id     int8               NOT NULL,
    item_id      int8               NOT NULL,
    price        float              NOT NULL,
    amount       decimal            NOT NULL,
    quantity     decimal            NOT NULL,
    customer_id  int8               NOT NULL,
    created      timestamp          NOT NULL,
    updated      timestamp          NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (item_id) REFERENCES item(id),
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TABLE IF NOT EXISTS cargo
(
    id               bigserial          PRIMARY KEY,
    number           decimal            NOT NULL,
    weight           float              NOT NULL,
    declared_value   decimal            NOT NULL,
    length           float              NOT NULL,
    width            float              NOT NULL,
    height           float              NOT NULL,
    shop_id          int8               NOT NULL,
    order_id         int8               NOT NULL,
    created          timestamp          NOT NULL,
    updated          timestamp          NOT NULL,
    FOREIGN KEY (shop_id) REFERENCES shop(id),
    FOREIGN KEY (order_id) REFERENCES orders(id)
);

CREATE TABLE IF NOT EXISTS delivery
(
    id                   bigserial      PRIMARY KEY,
    declared_value       decimal        NOT NULL,
    tracking_number      varchar(30)    NOT NULL,
    shipping_address_id  int8           NOT NULL,
    sending_address_id   int8           NOT NULL,
    customer_id          int8           NOT NULL,
    cargo_id             int8           NOT NULL,
    status               varchar(10)    NOT NULL,
    created              timestamp      NOT NULL,
    updated              timestamp      NOT NULL,
    FOREIGN KEY (cargo_id) REFERENCES cargo(id),
    FOREIGN KEY (shipping_address_id) REFERENCES address(id),
    FOREIGN KEY (sending_address_id) REFERENCES address(id),
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);
