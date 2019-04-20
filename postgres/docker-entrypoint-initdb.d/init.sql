create role app_group_master login password 'app_group_master';
create user rmis_user password 'rmis_user' in group app_group_master;

create role custom_for_cas login password 'custom_for_cas';
create user cas password 'cas' in group custom_for_cas;

create role app_group_slave nologin;
create user rmis_user_ro password 'rmis_user_ro' in group app_group_slave;

create database rmisdb owner app_group_master;

CREATE EXTENSION dblink;
CREATE EXTENSION fuzzystrmatch;
CREATE EXTENSION hstore;
CREATE EXTENSION ltree;
CREATE EXTENSION pg_trgm;
CREATE EXTENSION pgcrypto;
CREATE EXTENSION "uuid-ossp";
CREATE EXTENSION btree_gist;

