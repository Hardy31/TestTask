INSERT INTO public.client( first_name, last_name, father_name, birthday)
VALUES ('Ivan', 'Pohomov', 'Vasilevich','1972-02-02'),
       ('Semen', 'Shevtsov', 'Semenovich','1972-02-03'),
       ('Arhip', 'Kalashnikov', 'Ignatievich','1972-02-10');


INSERT INTO public.phone( phone, client_id)
VALUES ('+7 (123)123-45-61',  1),
       ('+7 (123)123-45-62',  1),
       ('+7 (123)123-45-65',  2),
       ('+7 (123)123-45-66',  3);


INSERT INTO public.email( email, client_id)
VALUES ('Ivan@mail.ru',  1),
       ('Vano@mail.ru',  1),
       ('Semen@list.ru',  2),
       ('Arhip@gmail.comu',  3);



INSERT INTO public.account( name, balance, client_id)
VALUES ('number1', 100, 1),
       ('number2', 1000, 2),
       ('number3', 200, 3 );

