DROP TABLE IF EXISTS ACCOUNTS;
DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(250) NOT NULL,
    password VARCHAR(250) NOT NULL,
    clazz    VARCHAR(250) NOT NULL,
    role     varchar(45)  NOT NULL,
    enabled  BIT DEFAULT NULL
);

insert into users (user_name, password, clazz, role, enabled)
values ('test', '$2a$10$XptfskLsT1l/bRTLRiiCgejHqOpgXFreUnNUa35gJdCr2v2QbVFzu', 'test', 'ADMIN', true),
       ('test1', '$2a$10$XptfskLsT1l/bRTLRiiCgejHqOpgXFreUnNUa35gJdCr2v2QbVFzu', 'test1', 'USER', true);


DROP TABLE IF EXISTS students;
CREATE TABLE students
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    id_parent  INT          NOT NULL,
    first_name VARCHAR(250) NOT NULL,
    last_name  VARCHAR(250) NOT NULL,
    clazz      VARCHAR(250) NOT NULL
);

insert into students (id_parent, first_name, last_name, clazz)
values (1, 'test', 'test', 'test');
