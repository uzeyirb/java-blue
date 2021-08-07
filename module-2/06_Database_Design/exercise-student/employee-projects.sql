

create table office(
office_id serial,
office_name varchar (32) not null,
office_street_address varchar (128) not null,
office_city varchar (128) not null,
office_state varchar (32) not null,
office_zip varchar (12) not null,
office_phone varchar (32) not null,
office_email varchar (32) not null,
office_hours varchar (256) not null,
office_parking varchar (256),
office_additional_info varchar (256),
office_url varchar (128),
constraint pk_office primary key(office_id)
);
 
create table department(
dept_id serial ,
department_name varchar (32) not null,
constraint pk_department primary key(dept_id)
);
create table employee(
emp_id serial,
job_title varchar (32) not null,
first_name varchar(32) not null,
last_name varchar(32) not null,
gender varchar (10) not null,
date_of_birth DATE not null,
date_of_hire DATE NOT NULL,
dept_id int not null,
project_id int not null,
constraint pk_employee primary key(emp_id),
constraint fk_employee_dept foreign key (dept_id)references department(dept_id),
constraint fk_employee_project foreign key (project_id)references project(project_id)
);

select * from department;
INSERT INTO department VALUES ('1', 'Finance');
INSERT INTO department VALUES ('2', 'People Team'); 
INSERT INTO department VALUES ('3', 'Security');
INSERT INTO department VALUES ('4', 'Reporting');

select * from project;
insert into project values('1','UEFA Europa League','2012-06-14');
insert into project values('2','World Cup of Soccer','2012-06-14');
insert into project values('3','NBA','2012-06-14');

select * from employee;
INSERT INTO employee VALUES ('1', 'Security Guard','Jon','DOE', 'male','1990-11-12', '2021-08-10', '2', '2');
INSERT INTO employee VALUES ('2', 'Marriage & Family Therapist','Lois','Lane', 'male', '1994-11-12' ,'2021-08-10' ,'1','2');
INSERT INTO employee VALUES ('3', 'Fitness Trainer','Liza','Doolittle','female', '1992-07-12', '2021-08-10','2','1');
INSERT INTO employee VALUES ('4','Security Guard','Henry','Higgins', 'male', '1989-08-12','2020-06-11','1','3');
INSERT INTO employee VALUES ('7','Auto Mechanic','Dixie','Normous','female', '1988-12-12','2021-12-10','1','2');
INSERT INTO employee VALUES ('9','Registered Nurse','Michael','Souris','male', '1987-12-12', '2020-10-11', '2', '2');
INSERT INTO employee VALUES ('10', 'Reporter', 'Donald','Canard', 'male', '1991-01-11','2021-01-10', '1','3');
INSERT INTO employee VALUES ('13','Photographer','Kissy','Suzuki', 'female','1992-01-02','2021-01-10','2','2'); 