create table depart(
did varchar2(6) primary key,
dname varchar2(21) not null
)

create table member(
id varchar2(6) primary key,
name varchar2(12) not null,
did varchar2(6),
age number(3) default 0,
constraint check_member_age_200_down check(age<200),
constraint fk_member_did_depart_did foreign key(did) references depart(did)
)

drop table member
drop table depart
drop table depart cascade constraints

--since dName is a not null constraint, 
--insert first 
insert into depart values('d001', '영문과')
insert into depart values('d002', '기계공학')
insert into depart values('d003', '법학')
insert into depart values('d004', '물리')
commit

insert into member(id, name, did, age)
values('m001', 'kim', null, 22)

insert into member(id, name, did, age)
values('m002', 'kiem', 'd001', 22)

insert into member(id, name, did, age) values('m003', 'lee', 'd003', 22)
insert into member values('m004', 'choi', null, 18)
insert into member values('m005', 'ryu', 'd004',25)
insert into member values('m006', 'oh', 'd001', 19)
insert into member values('m007', 'kang', null, 22)
commit
update member set name ='park' where id='m002'


select * from depart
select * from member


select m.id, m.name, m.age, d.dname 
from depart d natural join member m

--create table member(
--id varchar2(6),
--name varchar2(12),
--age number(3)
--)

--create table member(
--id varchar2(6) primary key,
--name varchar2(12) not null,
--age number(3) default 0
--constraint check_member_age_200_down check(age<200)
--)


insert into member(id, name, age) values('m001','kim', 11)
insert into member(id, name) values('m002','lee')
insert into member(id, name, age) values('m001','lee', 21)  
select age from member where id = 'm002'
insert into member(id, name, age) values('m00','park', 100)  
update member set id='m003' where name = 'park'
insert into member(id, name, age) values('m004','choi', 27)
insert into member values('m005', 'kim', 160)
alter table member add job varchar2(12)
alter table member add address varchar2(48)

update member set address ='ksk-aadfa-dd-aa' where id='m001'
update member set address ='adfa-dfdd-aa-ddd' where id='m002'
update member set job='kr'where id='m001'
update member set job='com'where id='m002'

select job from member where id='m003'
select job from member
select address from member
select id from member
select name from member
select address from member where name='kim'

alter table member modify name null

update member set name=null where id='m003'
    
alter table member add unique(id)
insert into member(id, name, age) values('m001', 'kim', 11)
insert into member(id, name, age) values('m001', 'lee', 7)
alter table member drop unique(id)

insert into member(id, name, age) values('m001', 'lee', 7)
alter table member modify name not null
insert into member(id, age) values('m003', 11)

alter table member add constraint check_member_age_200_down check(age>200)
insert into member values('m005', 'kim', 150)
select * from member
alter table member drop column job
select * from member

alter table member drop constraint check_member_age_200_down
insert into member values('m005', 'kim', 150)

alter table member add job varchar2(12)
alter table member modify job varchar2(24)
alter table member rename column job to work
alter table member drop column work

alter table member add job varchar2(12)
insert into member('001', 'aa', 3);
insert into member(id, name, age) values('001', 'aa', 3);
alter table member add job varchar2(12)
select * from member