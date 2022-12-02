# db-conn
Example project for database connection and CRUD operation


Run this query in you database console:

CREATE TABLE IF NOT EXISTS employee
(
    id          SERIAL PRIMARY KEY ,
    name        varchar(255) not null,
    hire_date   timestamp
);


CREATE TABLE IF NOT EXISTS account
(
    account_id          SERIAL PRIMARY KEY ,
    balance             numeric,
    account_type        varchar(25) NOT NULL ,
    employee_id         INT,

    CONSTRAINT fk_account_employee FOREIGN KEY (employee_id)
    REFERENCES employee(id)
);

-- This is test comment. This is another test commit - from student 1 of Sunway college
