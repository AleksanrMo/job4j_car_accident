
create table accident_type(
    id serial primary key,
    name varchar(2000)
);

CREATE TABLE rules (
    id SERIAL PRIMARY KEY,
    name VARCHAR(2000)
);

CREATE TABLE accident (
    id serial primary key,
    name varchar(2000),
    text text,
    address text,
    accident_tipe_id int references accident_type(id)

);

CREATE TABLE accidents_rules (
    rules_id INT REFERENCES rules (id),
    accidents_id INT REFERENCES accident(id)
);



insert into accident(name, text, address, accident_tipe_id) values('Ivan', 'Проехал на красный цвет светофора', 'Космонавтов 56','1'),
                                                                  ('Виктор', 'Пересек сплошную', 'Попова 34', '2');
insert into accident_type(name) values ('Две машины'),
                                       ('Машина и велосипед'),
                                       ('Машина и человек');

insert into rules(name) values ('Статья 1'),
                               ('Статья 2'),
                               ('Статья 3');

select distinct * from accidents_rules;

CREATE TABLE authorities (
                             id serial primary key,
                             authority VARCHAR(50) NOT NULL unique
);

CREATE TABLE users (
                       id serial primary key,
                       username VARCHAR(50) NOT NULL unique,
                       password VARCHAR(100) NOT NULL,
                       enabled boolean default true,
                       authority_id int not null references authorities(id)
);
insert into authorities (authority) values ('ROLE_USER');
insert into authorities (authority) values ('ROLE_ADMIN');
insert into users (username, enabled, password, authority_id)
values ('root', true, '$2a$10$DskqlBtuzjycdWNEKuMeu.ZLgiWZL/sKLlQUpaLyq9iy2HWXaUiTG',
        (select id from authorities where authority = 'ROLE_ADMIN'));
drop table authorities;
drop table users;
select * from users;
select * from authorities;