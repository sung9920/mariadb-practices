--
-- outer join
--

-- insert into dept values(null, '총무');
-- insert into dept values(null, '개발');
-- insert into dept values(null, '영업');
-- insert into dept values(null, '마케팅');
select * from dept;

-- insert into emp values(null, '둘리', 1);
-- insert into emp values(null, '마이콜', 2);
-- insert into emp values(null, '또치', 3);
-- insert into emp values(null, '길동', null);
select * from emp;


-- (inner) join
select a.name as '이름', b.name as '부서'
  from emp a join dept b on a.dept_id = b.id;
  
-- left (outer) join  
select a.name as '이름', ifnull(b.name, '없음') as '부서'
  from emp a left join dept b on a.dept_id = b.id;
  
-- right (outer) join  
select ifnull(a.name, '없음') as '이름', b.name as '부서'
  from emp a right join dept b on a.dept_id = b.id;

-- full (outer) join
-- mariadb 지원 안함  
  