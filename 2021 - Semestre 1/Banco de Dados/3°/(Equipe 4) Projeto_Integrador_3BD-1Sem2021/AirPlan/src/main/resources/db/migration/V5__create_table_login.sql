create table employee (

emp_id int auto_increment,
emp_name varchar(50) not null,
emp_password varchar(50) not null,
typ_id int,
constraint pk_employee primary key(emp_id),
constraint uk_employee_emp_passwork unique(emp_password)
);

create table employee_type(

typ_id int auto_increment,
typ_desc varchar(50) not null,
constraint pk_employee_type primary key(typ_id)
);

alter table employee add constraint fk_employee_typ_id foreign key(typ_id) references employee_type(typ_id);