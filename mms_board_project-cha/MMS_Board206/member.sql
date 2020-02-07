create table member3(
	id varchar2(6) primary key,
	name varchar2(15) not null,
	pw varchar2(15) not null,
	birth date default sysdate,
	email varchar2(15)
)



select * from member3

drop table member3

select id, pw, name, to_char(birth, 'yyyy/mm/dd') birth, email from member3

insert into member3(id, name, pw, birth, email) values('m001', 'lee', 'abcd', '1980-12-31', 'abc@oh.com')
insert into member3 values('m002', 'john', 'abcdc', '1999-02-27', 'bcd@aa.com')
insert into member3 values('m003', 'ryu', '1234', '1989-07-01', 'aaa@bbc.com')
insert into member3 values('m004', 'kim', 'abc12', '1990-05-21', 'ddd@korea.com')
insert into member3 values('m005', '홍길동', 'dddd', '1970-09-13', 'abc@mbc.net')
insert into member3 values('m006', '아무개', 'aaaa', '1999-01-08', 'dada@abc.com')

commit