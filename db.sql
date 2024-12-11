create database user_db;

create table users
(
    id               uuid    not null,
    first_name       varchar,
    midlle_name      varchar,
    last_name        varchar,
    birthday         date,
    profile          varchar not null,
    institution_name varchar,
    institution_code varchar,
    email            varchar not null,
    street           varchar,
    street_number    integer,
    city             varchar,
    postal_code      varchar,
    province         varchar,
    version          integer,
    constraint user_pk
        primary key (id)
);

create table account
(
    id        uuid    not null,
    username  varchar not null,
    password  varchar not null,
    is_active boolean not null,
    version   integer,
    constraint account_pk
        primary key (id),
    constraint account_users_id_fk
        foreign key (id) references users
);

create unique index account_username_uindex
    on account (username);

create unique index user_id_uindex
    on users (id);