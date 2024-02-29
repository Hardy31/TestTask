drop table if exists public.email cascade;
create table public.email (
                                id int8 generated by default as identity,
                                email varchar(255),
                                client_id int8,
                                primary key (id)
    );

drop table if exists public.phone cascade;
create table public.phone (
                              id int8 generated by default as identity,
                              phone varchar(255),
                              client_id int8,
                              primary key (id)
);


drop table if exists public.client cascade;
create table public.client (
                               id int8 generated by default as identity,
                               first_name varchar(255),
                               last_name varchar(255),
                               father_name varchar(255),
                               birthday timestamp,
                               primary key (id)
);

drop table if exists public.account cascade;
create table public.account (
                               id int8 generated by default as identity,
                               name varchar(255),
                               balance float8,
                               client_id int8,
                               primary key (id)
);

alter table if exists public.phone
    add constraint phone_client_id_fkey
    foreign key (client_id)
    references public.client;

alter table if exists public.email
    add constraint email_client_id_fkey
    foreign key (client_id)
    references public.client;

alter table if exists public.account
    add constraint account_client_id_fkey
    foreign key (client_id)
    references public.client;