DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    username    VARCHAR(250) NOT NULL,
    password VARCHAR(250) NOT NULL,
    clazz    VARCHAR(250) NOT NULL,
    teacher  BIT          NOT NULL,
    role varchar(45) NOT NULL,
    enabled  BIT DEFAULT NULL
);

insert into users (username, password, clazz, teacher, role, enabled)
values ('test', '$2a$10$XptfskLsT1l/bRTLRiiCgejHqOpgXFreUnNUa35gJdCr2v2QbVFzu', 'test', true, 'ROLE_USER', true),
       ('test1', '$2a$10$XptfskLsT1l/bRTLRiiCgejHqOpgXFreUnNUa35gJdCr2v2QbVFzu', 'test1', false, 'ROLE_USER', true);

-- DROP TABLE IF EXISTS students;

-- CREATE TABLE students
-- (
--     id        INT AUTO_INCREMENT PRIMARY KEY,
--     id_parent INT          NOT NULL,
--     first_name     VARCHAR(250) NOT NULL,
--     last_name  VARCHAR(250) NOT NULL,
--     clazz     VARCHAR(250) NOT NULL
-- );
--
-- insert into students (id_parent, first_name, last_name, clazz)
-- values (1, 'test', 'test', 'test');
