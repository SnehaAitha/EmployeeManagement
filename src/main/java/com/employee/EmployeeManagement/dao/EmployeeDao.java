package com.employee.EmployeeManagement.dao;

import java.util.List;
import com.employee.EmployeeManagement.dto.Employee;

public interface EmployeeDao{
	
	public List<Employee> fetchAllEmployees();
	
	public List<Employee> fetchEmployeesInDepartment(String deptId);

	public boolean deleteEmployeeInDepartment(String empId);
	
	public Employee addEmployeeInDepartment(Employee emp);


}