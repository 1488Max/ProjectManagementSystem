Create table developer
(
    id BIGINT AUTO_INCREMENT ,
    name        varchar(100),
    sex         varchar(100),
    PRIMARY KEY(id)

);
Create table company
(
    id BIGINT AUTO_INCREMENT ,
    name      varchar(100),
    area      varchar(100),
    primary key(id)
);

Create table customer
(
    id BIGINT AUTO_INCREMENT ,
    name       varchar(100),
    surname    varchar(100),
    primary key(id)
);
Create table skill
(
    id BIGINT AUTO_INCREMENT ,
    technology varchar(100),
    skill      varchar(100),
    primary key(id)
);


CREATE table developer_skill
(
    developer_id bigint not null,
    skill_id     bigint not null,

    FOREIGN KEY (developer_id) REFERENCES developer(id),
    FOREIGN KEY (skill_id) REFERENCES skill(id)
);
Create table project
(
    id BIGINT AUTO_INCREMENT  ,
    name        varchar(100),
    time_of_creation DATE,
    customer_id BIGINT,
    company_id  BIGINT,
    foreign key (customer_id) REFERENCES customer(id),
    foreign key (company_id) REFERENCES company(id),
    primary key(id)
);



CREATE table developer_project
(
    developer_id BIGINT not null,
    project_id   BIGINT not null,
    PRIMARY KEY (developer_id, project_id),
    FOREIGN KEY (developer_id) REFERENCES developer (id),
    FOREIGN KEY (project_id) REFERENCES project (id)
);

ALTER TABLE skill
    ADD CONSTRAINT technologies_names
        Check (TECHNOLOGY IN ('Java', 'C++', 'C#', 'JS'));

ALTER TABLE skill
    ADD CONSTRAINT skills_levels
        Check (SKILL IN ('Senior', 'Middle', 'Junior'));

ALTER TABLE DEVELOPER
    add salary int;

UPDATE DEVELOPER set DEVELOPER.salary = 2000 where ID = 1;

UPDATE DEVELOPER set DEVELOPER.salary = 6000 where ID = 2;

UPDATE DEVELOPER set DEVELOPER.salary = 8000 where ID = 3;
INSERT into COMPANY (NAME, AREA)
VALUES ('Samsung', 'Technology Development'),
       ('Asus', 'Technology Development'),
       ('Apple', 'Technology Development');

INSERT into CUSTOMER (name, surname)
VALUES ('Max', 'Parker'),
       ('Igor', 'Prokopenko'),
       ('Andrew', 'Tate');

INSERT into DEVELOPER (name, sex)
VALUES ('Nix', 'male'),
       ('OLeg', 'male'),
       ('Volodya', 'male');

INSERT into SKILL (technology, skill)
VALUES ('Java', 'Senior'),
       ('C++', 'Senior'),
       ('C#', 'Senior'),
       ('JS', 'Senior'),
       ('Java', 'Middle'),
       ('C++', 'Middle'),
       ('C#', 'Middle'),
       ('JS', 'Middle'),
       ('Java', 'Junior'),
       ('C++', 'Junior'),
       ('C#', 'Junior'),
       ('JS', 'Junior');

INSERT INTO PROJECT(name, time_of_creation, customer_id, company_id)
VALUES ('S20',CURRENT_DATE  , 1, 1),
       ('V30',CURRENT_DATE , 1, 1),
       ('B40', CURRENT_DATE , 3, 2),
       ('C50', CURRENT_DATE , 2, 3),
       ('Z60', CURRENT_DATE , 3, 3);

INSERT INTO DEVELOPER_PROJECT(developer_id, project_id)
VALUES (1, 1),
       (2, 5),
       (1, 2),
       (2, 1),
       (3, 1),
       (2, 3),
       (3, 4);

INSERT INTO DEVELOPER_SKILL(developer_id, SKILL_ID)
VALUES (1, 1),
       (2, 1),
       (1, 8),
       (3, 1),
       (2, 9);

UPDATE DEVELOPER set DEVELOPER.salary = 2000 where ID = 1;

UPDATE DEVELOPER set DEVELOPER.salary = 6000 where ID = 2;

UPDATE DEVELOPER set DEVELOPER.salary = 8000 where ID = 3;

