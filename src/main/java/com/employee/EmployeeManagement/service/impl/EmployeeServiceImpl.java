package com.employee.EmployeeManagement.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.EmployeeManagement.dao.EmployeeDao;
import com.employee.EmployeeManagement.dto.Employee;
import com.employee.EmployeeManagement.service.EmployeeService;

@Service("EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {
		
	@Autowired
	EmployeeDao empDao;
	
	@Override
	public List<Employee> fetchAllEmployees() {
		return empDao.fetchAllEmployees();
	}

	@Override
	public List<Employee> fetchEmployeesInDepartment(String deptId) {
		return empDao.fetchEmployeesInDepartment(deptId);
	}

	@Override
	public boolean deleteEmployeeInDepartment(String empId) {
		return empDao.deleteEmployeeInDepartment(empId);
	}
	
	@Override
	public Employee addEmployeeInDepartment(Employee emp) {
		return empDao.addEmployeeInDepartment(emp);
	}

	
}