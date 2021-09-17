alter table codelist add column emp_id int not null;
alter table codelist add constraint fk_codelist_emp_id foreign key(emp_id) references employee(emp_id);