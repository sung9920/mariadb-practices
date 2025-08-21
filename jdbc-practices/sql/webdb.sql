--
-- JDBC Test SQL
--

desc dept;

-- select
select id, name from dept;

-- insert
insert into dept(name) values('UX팀');

-- delete
delete from dept where id = 18;

-- update
update dept set name = '서비스개발팀' where id = 2;

-- auto_increment 값 설정
ALTER TABLE dept AUTO_INCREMENT = 8;

--
-- email application
-- 

-- findAll
select id, first_name, last_name, email from email order by id desc;

-- deleteByEmail
delete from email where email = 'dooly@gmail.com';

-- insert
insert into email(first_name, last_name, email) values ( '둘', '리', 'dooly@gmail.com');

--
-- bookshop application
--

-- select
select * from author;
select * from book;

-- deleteAll
delete from book;
delete from author;

-- insert
insert into author(name) values ('박성철');
insert into book(title,author_id) values ('제목1', 2);

-- findAll
select a.id, a.title, b.name, a.status from book a, author b where a.author_id = b.id;

-- update
update book set status = '대여중' where id = 1;

