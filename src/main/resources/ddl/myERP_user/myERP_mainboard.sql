create table myERP_mainboard(
    mainboard_bno int primary key
    , mainboard_writer varchar2(100) not null,
    mainboard_title varchar2(300) not null,
    mainboard_content varchar2(4000),
    mainboard_viewcnt number(38) default 0,
    mainboard_regdate date,
    mainboard_user_id varchar2(20),
    mainboard_modifiy_regdate date
);
commit;