package com.employee.EmployeeManagement.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.EmployeeManagement.dto.Department;
import com.employee.EmployeeManagement.dto.Employee;
import com.employee.EmployeeManagement.repository.DepartmentRepository;
import com.employee.EmployeeManagement.repository.EmployeeRepository;
import com.employee.EmployeeManagement.service.EmployeeService;

@Service("EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {
		
	@Autowired
	EmployeeRepository empRepo;
	
	@Autowired
	DepartmentRepository deptRepo;
	
	@Override
	public List<Employee> fetchAllEmployees() {
		return empRepo.findAll();	
	}

	@Override
	public List<Employee> fetchEmployeesInDepartment(String deptId) {
		Optional<Department> department = deptRepo.findById(deptId);
		return empRepo.findByDepartment(department.get());
	}

	@Override
	public void deleteEmployeeInDepartment(String empId) {
		 empRepo.deleteById(empId);
	}
	
	@Override
	public Employee addEmployeeInDepartment(Employee emp) {
		return empRepo.save(emp);
	}

	@Override
	public Optional<Employee> fetchEmployee(String empId) {
		return empRepo.findById(empId);
	}

	
}