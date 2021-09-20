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

create table manual_flag (
     mnl_id int,
     flg_secundary varchar(10),
     constraint pk_manual_flag primary key(mnl_id,flg_secundary)
);

create table codelist (

      cdl_id int auto_increment,
      mnl_id int not null,
      flg_secundary varchar(10) not null,
      cdl_section varchar(30) not null,
      cdl_sub_section varchar(30),
      cdl_block_number int not null not null,
      cdl_block_name varchar(80) not null,
      cdl_code int not null,
      constraint cdl_id primary key (cdl_id),
      constraint uk_codelist unique key (mnl_id,flg_secundary,cdl_section,cdl_block_number)
);
