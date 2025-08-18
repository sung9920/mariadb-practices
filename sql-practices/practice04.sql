-- 서브쿼리(SUBQUERY) SQL 문제입니다.

-- 단 조회결과는 급여의 내림차순으로 정렬되어 나타나야 합니다. 

-- 문제1.
-- 현재 전체 사원의 평균 급여보다 많은 급여를 받는 사원은 몇 명이나 있습니까?

select count(*)
from salaries
where to_date = '9999-01-01'
and salary > ( select avg(salary)
				from salaries 
				where to_date = '9999-01-01');

-- 문제2. 
-- 현재, 각 부서별로 최고의 급여를 받는 사원의 사번, 이름, 부서 급여을 조회하세요. 단 조회결과는 급여의 내림차순으로 정렬합니다.

select a.emp_no, b.first_name, d.dept_name, a.salary
from salaries a, employees b, dept_emp c, departments d
where a.emp_no = b.emp_no
and b.emp_no = c.emp_no
and c.dept_no = d.dept_no
and a.to_date = '9999-01-01'
and c.to_date = '9999-01-01'
and salary in ( select max(salary) 
				from salaries a, dept_emp b, departments c 
				where a.emp_no = b.emp_no
                and b.dept_no = c.dept_no
                and a.to_date = '9999-01-01'
                group by dept_name )
order by salary desc;

-- 문제3.
-- 현재, 사원 자신들의 부서의 평균급여보다 급여가 많은 사원들의 사번, 이름 그리고 급여를 조회하세요 

select a.emp_no, b.first_name, a.salary, d.dept_no
from salaries a, employees b, dept_emp c, 
		( select c.dept_no, avg(salary) as '평균급여'
			from salaries a, dept_emp b, departments c 
			where a.emp_no = b.emp_no
			and b.dept_no = c.dept_no
			and a.to_date = '9999-01-01' 
			group by dept_name ) d
where a.emp_no = b.emp_no
and b.emp_no = c.emp_no
and c.dept_no = d.dept_no
and a.to_date = '9999-01-01'
and a.salary > 평균급여
order by a.salary asc;

-- 문제4.
-- 현재, 사원들의 사번, 이름, 그리고 매니저 이름과 부서 이름을 출력해 보세요. 

select a.emp_no, b.first_name, a.salary, e.first_name as 'manager_name', d.dept_name, a.to_date
from salaries a, employees b, dept_emp c, departments d, (select a.dept_no, b.first_name
															from dept_manager a, employees b
															where a.to_date = '9999-01-01'
															and a.emp_no = b.emp_no) e
where a.emp_no = b.emp_no
and b.emp_no = c.emp_no
and c.dept_no = d.dept_no
and d.dept_no = e.dept_no
and a.to_date = '9999-01-01'
and c.to_date = '9999-01-01';

-- 문제5.
-- 현재, 평균급여가 가장 높은 부서의 사원들의 사번, 이름, 직책 그리고 급여를 조회하고 급여 순으로 출력하세요.

select a.emp_no, b.first_name, c.title, a.salary
from salaries a, employees b, titles c
where a.emp_no = b.emp_no
and b.emp_no = c.emp_no
and a.to_date = '9999-01-01'
and c.to_date = '9999-01-01'
and c.title = (select b.title
				from salaries a, titles b
				where a.emp_no = b.emp_no
				and a.to_date = '9999-01-01'
				and b.to_date = '9999-01-01'
				group by b.title
				order by avg(salary) desc
				limit 1)
order by salary desc;

-- 문제6.
-- 현재, 평균 급여가 가장 높은 부서의 이름 그리고 평균급여를 출력하세요.

-- having절 서브쿼리
select b.title, avg(a.salary)
from salaries a, titles b
where a.emp_no = b.emp_no
and a.to_date = '9999-01-01'
and b.to_date = '9999-01-01'
group by b.title
having avg(a.salary) = (select max(평균급여) 
						from ( select b.title, avg(a.salary) as 평균급여
								from salaries a, titles b
                                where a.emp_no = b.emp_no
                                and a.to_date = '9999-01-01'
								and b.to_date = '9999-01-01'
                                group by b.title) a);

-- top-k (limit)
select b.title, avg(a.salary)
from salaries a, titles b
where a.emp_no = b.emp_no
and a.to_date = '9999-01-01'
and b.to_date = '9999-01-01'
group by b.title
order by avg(salary) desc
limit 1;   

-- 문제7.
-- 현재, 평균 급여가 가장 높은 직책의 타이틀 그리고 평균급여를 출력하세요.

-- having절 서브쿼리
select c.dept_name, avg(a.salary)
from salaries a, dept_emp b, departments c
where a.emp_no = b.emp_no
and b.dept_no = c.dept_no
and a.to_date = '9999-01-01'
and b.to_date = '9999-01-01'
group by c.dept_name
having avg(a.salary) = (select max(평균급여) 
						from ( select c.dept_name, avg(a.salary) as 평균급여
								from salaries a, dept_emp b, departments c
                                where a.emp_no = b.emp_no
								and b.dept_no = c.dept_no
                                and a.to_date = '9999-01-01'
								and b.to_date = '9999-01-01'
                                group by c.dept_name) a);

-- top-k (limit)
select c.dept_name, avg(a.salary)
from salaries a, dept_emp b, departments c
where a.emp_no = b.emp_no
and b.dept_no = c.dept_no
and a.to_date = '9999-01-01'
and b.to_date = '9999-01-01'
group by c.dept_name
order by avg(salary) desc
limit 1;       

