package com.employee.EmployeeManagement.service;

import java.util.List;
import java.util.Optional;
import com.employee.EmployeeManagement.dto.Employee;

public interface EmployeeService {
	
	public List<Employee> fetchAllEmployees();
	
	public Employee addEmployeeInDepartment(Employee emp);

	public void deleteEmployeeInDepartment(String empId);

	public Optional<Employee> fetchEmployee(String empId);

	public List<Employee> fetchEmployeesInDepartment(String deptId);

}
