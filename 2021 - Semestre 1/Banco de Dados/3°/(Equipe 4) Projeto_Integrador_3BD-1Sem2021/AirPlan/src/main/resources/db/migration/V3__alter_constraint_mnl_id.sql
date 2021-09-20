alter table manual_flag drop constraint fk_manual_flag_mnl_id;
alter table codelist drop constraint fk_codelist_mnl_id;
alter table manual_flag add constraint fk_manual_flag_mnl_id foreign key(mnl_id) references manual(mnl_id) ON DELETE CASCADE;
alter table codelist add constraint fk_codelist_mnl_id foreign key(mnl_id) references manual_flag(mnl_id) ON DELETE CASCADE;
