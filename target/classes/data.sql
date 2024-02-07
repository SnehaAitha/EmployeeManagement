CREATE TABLE employee (
    id varchar(10) PRIMARY KEY,
    name varchar(50),
    email varchar(50),
    position varchar(50),
    salary int,
    dept_id varchar(10)
  );

CREATE TABLE department (
    id varchar(10) PRIMARY KEY,
    name varchar(50),
    location varchar(50)
   );


INSERT INTO DEPARTMENT (id, name,location) VALUES ('dept01', 'Human Resources','Building A');
INSERT INTO DEPARTMENT (id, name,location) VALUES ('dept02', 'Engineering','Building B');

INSERT INTO EMPLOYEE (id, name,email,position,salary,dept_id) VALUES ('emp001', 'Alice Smith','alice.smith@example.com','Recruiter',60000,'dept01');
INSERT INTO EMPLOYEE (id, name,email,position,salary,dept_id) VALUES ('emp002', 'Bob Johnson','bob.johnson@example.com','Software Engineer',80000,'dept02');
INSERT INTO EMPLOYEE (id, name,email,position,salary,dept_id) VALUES ('emp003', 'Charlie Brown','charlie.brown@example.com','HR Assistant',40000,'dept01');
INSERT INTO EMPLOYEE (id, name,email,position,salary,dept_id) VALUES ('emp004', 'Diana Prince','diana.prince@example.com','System Architect',90000,'dept02');