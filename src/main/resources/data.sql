INSERT INTO public.clients( first_name, last_name, father_name, birthday)
VALUES ('Ivan', 'Pohomov', 'Vasilevich','2024-02-24 00:00:00.000000'),
       ('Semen', 'Shevtsov', 'Semenovich','1972-02-03 00:00:00.000000'),
       ('Arhip', 'Kalashnikov', 'Ignatievich','1972-02-10 00:00:00.000000');


INSERT INTO public.phones( phone, client_id)
VALUES ('+7 (123)123-45-61',  1),
       ('+7 (123)123-45-62',  1),
       ('+7 (123)123-45-65',  2),
       ('+7 (123)123-45-66',  3);


INSERT INTO public.emails( email, client_id)
VALUES ('Ivan@mail.ru',  1),
       ('Vano@mail.ru',  1),
       ('Semen@list.ru',  2),
       ('Arhip@gmail.comu',  3);



INSERT INTO public.accounts( name, balance, client_id)
VALUES ('number1', 100, 1),
       ('number2', 1000, 2),
       ('number3', 200, 3);

INSERT INTO public.transactions( type, created_at, transfer_amount, debit_account_id, credit_account_id)
VALUES ('PUT', '2024-02-28 23:28:05.123456', 100, 1, null),
       ('WITHDRAWAL', '2024-02-28 23:28:05.223456', 900, null, 2),
       ('WITHDRAWAL', '2024-02-28 23:28:05.323456', 100, null, 2),
       ('TRANSFER', '2024-02-28 23:28:05.423456', 100, 2, 3);



