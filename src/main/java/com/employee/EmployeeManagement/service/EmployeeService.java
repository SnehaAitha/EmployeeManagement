package com.employee.EmployeeManagement.service;

import java.util.List;
import com.employee.EmployeeManagement.dto.Employee;

public interface EmployeeService {
	
	public List<Employee> fetchAllEmployees();

	public List<Employee> fetchEmployeesInDepartment(String deptId);

	public boolean deleteEmployeeInDepartment(String empId);

	public Employee addEmployeeInDepartment(Employee emp);

}
