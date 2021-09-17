alter table manual_flag add constraint fk_manual_flag_mnl_id foreign key(mnl_id) references manual(mnl_id);
alter table manual_flag add constraint fk_manual_flag_flg_secundary foreign key(flg_secundary) references flag(flg_secundary);
alter table codelist add constraint fk_codelist_mnl_id foreign key(mnl_id) references manual_flag(mnl_id);
alter table codelist add constraint fk_codelist_flg_secundary foreign key(flg_secundary) references manual_flag(flg_secundary);
