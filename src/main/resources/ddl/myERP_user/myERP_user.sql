create table myERP_user(
	user_id varchar(20) not null,
    user_pw varchar(200) not null,
    user_name varchar(10) not null,
    user_tel varchar(45) not null,
    user_no int not null,
    user_flag varchar(10) not null,
    user_regdate date not null,
    user_modify_regdate date,
    primary key(user_id)
);

delete from myERP_user where user_id='mong@naver.com';
commit;
delete from myERP_user;
insert into myERP_user(user_id, user_pw, user_name, user_tel, user_no, user_flag, user_regdate) values('hong3@naver.com', 'hong23', 'È«±æµ¿', '010-1234-5678', 1, '»ç¿ø', sysdate);
select * from myERP_user;
where user_id = 'hom@naver.com';
