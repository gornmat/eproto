DROP TABLE IF EXISTS accounts;

CREATE TABLE accounts
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    login    VARCHAR(250) NOT NULL,
    password VARCHAR(250) NOT NULL,
    clazz    VARCHAR(250) NOT NULL,
    teacher  BIT          NOT NULL
);

insert into accounts (login, password, clazz, teacher)
values ('test', 'test', 'test', true),
       ('test1', 'test1', 'test1', false);

DROP TABLE IF EXISTS students;

CREATE TABLE students
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    login    VARCHAR(250) NOT NULL,
    password VARCHAR(250) NOT NULL,
    clazz    VARCHAR(250) NOT NULL
);
