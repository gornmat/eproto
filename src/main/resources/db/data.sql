DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(250) NOT NULL,
    password  VARCHAR(250) NOT NULL,
    clazz     VARCHAR(250) NOT NULL,
    role      varchar(45)  NOT NULL,
    enabled   BIT DEFAULT NULL
);

insert into users (user_name, password, clazz, role, enabled)
values ('n@test.test', '$2a$10$Tr.GLjjbwoEZMo.8VsR7JOkTo7YYjN9ZHXHrRG6bM1rtgMx8XmPtO', 'testClazz', 'ROLE_ADMIN', true),
       ('r@test.test', '$2a$10$Tr.GLjjbwoEZMo.8VsR7JOkTo7YYjN9ZHXHrRG6bM1rtgMx8XmPtO', 'testClazz', 'ROLE_USER', true);


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
values (2, 'test', 'test', 'testClazz');

DROP TABLE IF EXISTS files;
CREATE TABLE files
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    id_parent INT          NOT NULL,
    file_name VARCHAR(250) NOT NULL,
    img       BLOB
);

DROP TABLE IF EXISTS tasks;
CREATE TABLE tasks
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    id_teacher  INT          NOT NULL,
    description VARCHAR(250) NOT NULL,
    due_date    DATE
);

DROP TABLE IF EXISTS student_tasks;
CREATE TABLE student_tasks
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    id_task     INT          NOT NULL,
    id_student  INT          NOT NULL,
    description VARCHAR(250) NOT NULL,
    grade       VARCHAR(10) NULL,
    due_date    DATE
);

DROP TABLE IF EXISTS messages;
CREATE TABLE messages
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    id_teacher   INT          NOT NULL,
    id_parent    INT          NOT NULL,
    message_text VARCHAR(250) NOT NULL,
    enabled      BIT DEFAULT NOT NULL
);
