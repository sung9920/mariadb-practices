-- 테이블 조인(JOIN) SQL 문제입니다.

-- 문제 1. 
-- 현재 급여가 많은 직원부터 직원의 사번, 이름, 그리고 연봉을 출력 하시오.

select a.emp_no, b.last_name, a.salary
from salaries a, employees b
where a.emp_no = b.emp_no
and a.to_date = '9999-01-01'
order by a.salary desc;

-- 문제2.
-- 전체 사원의 사번, 이름, 현재 직책을 이름 순서로 출력하세요.

select a.emp_no, b.last_name, a.title
from titles a, employees b
where a.emp_no = b.emp_no
and a.to_date = '9999-01-01'
order by b.last_name asc;

-- 문제3.
-- 전체 사원의 사번, 이름, 현재 부서를 이름 순서로 출력하세요.

select b.emp_no, b.last_name, c.dept_name
from dept_emp a, employees b, departments c
where a.emp_no = b.emp_no
and a.dept_no = c.dept_no
and a.to_date = '9999-01-01'
order by b.last_name asc;

-- 문제4.
-- 현재 근무중인 전체 사원의 사번, 이름, 연봉, 직책, 부서를 모두 이름 순서로 출력합니다.

select b.emp_no, b.last_name, a.salary, c.title, e.dept_name
from salaries a, employees b, titles c, dept_emp d, departments e
where a.emp_no = b.emp_no
and b.emp_no = c.emp_no
and c.emp_no = d.emp_no
and d.dept_no = e.dept_no
and a.to_date = '9999-01-01'
order by b.last_name asc;

-- 문제5.
-- 'Technique Leader'의 직책으로 과거에 근무한 적이 있는 모든 사원의 사번과 이름을 출력하세요.
-- (현재 'Technique Leader'의 직책으로 근무하는 사원은 고려하지 않습니다.)

select b.emp_no, b.last_name
from titles a, employees b
where a.emp_no = b.emp_no
and title = 'Technique Leader'
and a.to_date != '9999-01-01';

-- 문제6.
-- 직원 이름(last_name) 중에서 S로 시작하는 직원들의 이름, 부서명, 직책을 조회하세요.

select b.last_name, d.dept_name, a.title 
from titles a, employees b, dept_emp c, departments d
where a.emp_no = b.emp_no
and b.emp_no = c.emp_no
and c.dept_no = d.dept_no
and last_name like 'S%';

-- 문제7.
-- 현재, 직책이 Engineer인 사원 중에서 현재 급여가 40,000 이상인 사원들의 사번, 이름, 급여 그리고 타이틀을 급여가 큰 순서대로 출력하세요.

select a.emp_no, b.last_name, a.salary, c.title
from salaries a, employees b, titles c
where a.emp_no = b.emp_no
and b.emp_no = c.emp_no
and salary >= 40000
and a.to_date = '9999-01-01'
order by a.salary desc;

-- 문제8.
-- 현재, 평균급여가 50,000이 넘는 직책을 직책과 평균급여을 평균급여가 큰 순서대로 출력하세요.

select b.title, avg(a.salary) as '평균급여'
from salaries a, titles b
where a.emp_no = b.emp_no
and avg(a.salary) >= 50000
and a.to_date = '9999-01-01'
group by b.title
order by avg(a.salary) desc;

-- 문제9.
-- 현재, 부서별 평균급여을 평균급여가 큰 순서대로 부서명과 평균연봉을 출력 하세요.



-- 문제10.
-- 현재, 직책별 평균급여를 평균급여가 큰 직책 순서대로 직책명과 그 평균연봉을 출력 하세요.


