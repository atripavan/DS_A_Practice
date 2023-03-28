Department
	-department_id
	-department_name
	
employee
	employee_id
	employee_name
	employee_salary
	department_id
	

	
select d.department_name, sum(e.employee_salary) as total_salary from employee e, department d where e.department_id = d.department_id group by d.department_name
union all
select d.department_name, '0' from department d where not exists (select e2.id from employee e2, department d where e2.department_id = d.department_id)