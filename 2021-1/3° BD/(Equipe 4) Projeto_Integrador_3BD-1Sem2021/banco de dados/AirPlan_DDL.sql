create database codelist;

create user 'admin'@'localhost' identified by 'admin';

grant select, insert, delete, update on codelist.* to admin@'localhost';

use codelist;

create table flag (

flg_secundary varchar(10),
flg_tag varchar(30) not null,
constraint pk_flag primary key (flg_secundary)
);

create table manual (

mnl_id int auto_increment, 
mnl_name varchar(30),
constraint pk_manual primary key(mnl_id),
constraint uk_manual_mnl_name unique(mnl_name)
);

select mnl_id from manual where mnl_name = ?;


create table manual_flag (
mnl_id int, 
flg_secundary varchar(10), 
constraint pk_manual_flag primary key(mnl_id,flg_secundary)
);

create table codelist (

mnl_id int,
flg_secundary varchar(10),
cdl_section varchar(30), 
cdl_sub_section varchar(30),
cdl_block int, 
cdl_block_name varchar(80) not null,
cdl_code int not null,
/*emp_id int,*/
constraint pk_codelist primary key (mnl_id,flg_secundary,cdl_section,cdl_block)
);

create table employee (

emp_id int auto_increment, 
emp_name varchar(50) not null,
emp_password varchar(50), 
typ_id int, 
constraint pk_employee primary key(emp_id),
constraint uk_employee_emp_passwork unique(emp_password)
);

create table employee_type(

typ_id int auto_increment, 
typ_desc varchar(50) not null,
constraint pk_employee_type primary key(typ_id)
);

alter table manual_flag add constraint fk_manual_flag_mnl_id foreign key(mnl_id) references manual(mnl_id);
alter table manual_flag add constraint fk_manual_flag_flg_secundary foreign key(flg_secundary) references flag(flg_secundary);
alter table codelist add constraint fk_codelist_mnl_id foreign key(mnl_id) references manual_flag(mnl_id);
alter table codelist add constraint fk_codelist_flg_secundary foreign key(flg_secundary) references manual_flag(flg_secundary);
/*alter table codelist add constraint fk_codelist_emp_id foreign key(emp_id) references employee(emp_id);
alter table employee add constraint fk_employee_typ_id foreign key(typ_id) references employee_type(typ_id);*/

