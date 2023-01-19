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

drop table 
select * from myERP_mainboard;
create sequence mainboard_bno_seq
start with 1
increment by 1
nocache;

insert into myERP_mainboard(mainboard_bno, mainboard_writer, mainboard_title, mainboard_content, mainboard_regdate, mainboard_user_id)
values(mainboard_bno_seq.nextval, '홍길동', '제목', '내용', sysdate, 'mong@naver.com');
alter table myERP_mainboard add constraint myERP_mainboard_mainboard_user_id_fk
foreign key(mainboard_user_id)references myERP_user(user_id);