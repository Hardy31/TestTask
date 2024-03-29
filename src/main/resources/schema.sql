drop table if exists public.emails cascade;
create table public.emails (
                                id int8 generated by default as identity,
                                email varchar(255) unique ,
                                client_id int8,
                                primary key (id)
    );

drop table if exists public.phones cascade;
create table public.phones (
                              id int8 generated by default as identity,
                              phone varchar(255) unique ,
                              client_id int8,
                              primary key (id)
);


drop table if exists public.clients cascade;
create table public.clients (
                               id int8 generated by default as identity,
                               first_name varchar(255),
                               last_name varchar(255),
                               father_name varchar(255),
                               birthday timestamp,
                               primary key (id)
);

drop table if exists public.accounts cascade;
create table public.accounts (
                               id int8 generated by default as identity,
                               name varchar(255),
                               balance float8,
                               client_id int8,
                               primary key (id)
);

drop table if exists public.transactions cascade;
create table public.transactions (
                                 id int8 generated by default as identity,
                                 type varchar(50),
                                 created_at timestamp,
                                 transfer_amount float8,
                                 debit_account_id int8,
                                 credit_account_id int8,
                                 primary key (id)
);




alter table if exists public.phones
    add constraint phone_client_id_fkey
    foreign key (client_id)
    references public.clients;

alter table if exists public.emails
    add constraint email_client_id_fkey
    foreign key (client_id)
    references public.clients;

alter table if exists public.accounts
    add constraint account_client_id_fkey
    foreign key (client_id)
    references public.clients;
