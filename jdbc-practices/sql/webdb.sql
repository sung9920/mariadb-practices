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
ALTER TABLE book AUTO_INCREMENT = 1;

--
-- email application
-- 

desc email;

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
select last_insert_id();

insert into book(title,author_id) values ('제목1', 2);

-- findAll
select a.id, a.title, b.name, a.status from book a, author b where a.author_id = b.id;

-- update
update book set status = '대여중' where id = 1;

--
-- guestbook
--

desc guestbook;

-- insert
insert into guestbook values(null, 'sung', '1234', 'hi', now());

-- findAll
select id, name, message, date_format(reg_date, '%Y-%m-%d %h:%i:%s') from guestbook order by id desc;

-- deleteByIdAndPassword
delete from guestbook where id = 1 and password = '1234';

select * from guestbook;

TRUNCATE TABLE guestbook;