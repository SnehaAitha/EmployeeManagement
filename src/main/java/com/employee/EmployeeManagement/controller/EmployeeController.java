package com.employee.EmployeeManagement.controller;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.employee.EmployeeManagement.dto.Department;
import com.employee.EmployeeManagement.dto.Employee;
import com.employee.EmployeeManagement.response.Response;
import com.employee.EmployeeManagement.service.EmployeeService;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@GetMapping(value = "/fetchAllEmployees")
	public Response<List<Employee>> fetchAllEmployees() {

		try {
			logger.debug("In fetchAllEmployees.");
			List<Employee> employees = empService.fetchAllEmployees();
			if(employees != null && employees.size() == 0) 
				return new Response<List<Employee>>(HttpStatus.OK, "Employees retrived successfully with no rows." , employees);
			return new Response<List<Employee>>(HttpStatus.OK, "Employees retrived successfully.", employees);
		} catch (Exception ex) {
			logger.error("Employees retrival failed with exception.");
			return new Response<List<Employee>>(HttpStatus.INTERNAL_SERVER_ERROR, "Employees retrival failed.");
		}
	}
	
	@GetMapping(value = "/fetchEmployeesInDepartment/{deptId}")
	public Response<List<Employee>> fetchEmployeesInDepartment(@PathVariable("deptId") String deptId) {

		try {
			logger.debug("In fetchEmployeesInDepartment.");
			List<Employee> employees = empService.fetchEmployeesInDepartment(deptId);
			if(employees != null && employees.size() == 0) 
				return new Response<List<Employee>>(HttpStatus.OK, "Employees in a department retrived successfully with no rows." , employees);
			return new Response<List<Employee>>(HttpStatus.OK, "Employees in a department retrived successfully.", employees);
		} catch (Exception ex) {
			logger.error("Employees retrival failed with exception.");
			return new Response<List<Employee>>(HttpStatus.INTERNAL_SERVER_ERROR, "Employees in a department retrival failed.");
		}
	}
	
	@DeleteMapping(value = "/deleteEmployeeInDepartment/{empId}")
	public Response<String> deleteEmployeeInDepartment(@PathVariable("empId") String empId) {

		try {
			logger.debug("In deleteEmployeeInDepartment.");
			
			Optional<Employee> employee = empService.fetchEmployee(empId);
			if(employee.isEmpty() || !employee.isPresent()) 
				return new Response<String>(HttpStatus.NOT_FOUND, "Employee doesnt exists.");
			empService.deleteEmployeeInDepartment(empId);
			Optional<Employee> deletedEmployee = empService.fetchEmployee(empId);
			if(deletedEmployee.isEmpty() || !deletedEmployee.isPresent()) 
				return new Response<String>(HttpStatus.OK, "Employee deleted successfully.");
			return new Response<String>(HttpStatus.NOT_ACCEPTABLE, "Employee deletion failed.");
		} catch (Exception ex) {
			logger.error("Employee deletion failed with exception.");
			return new Response<String>(HttpStatus.INTERNAL_SERVER_ERROR, "Employee deletion failed.");
		}
	}
	
	@PostMapping(value = "/addEmployeeInDepartment")
	public Response<Employee>  addEmployeeInDepartment(@RequestBody Employee emp) 
	{
		try {
			logger.debug("In addEmployeeInDepartment.");
			Employee employee = empService.addEmployeeInDepartment(emp);
			if(employee != null)
				return new Response<Employee>(HttpStatus.OK, "Employee details saved successfully.", employee);
			return new Response<Employee>(HttpStatus.OK, "Employee details saving failed.",employee);
		} catch (Exception ex) {
			logger.error("Employee details save failed with exception.", ex);
			return new Response<Employee>(HttpStatus.INTERNAL_SERVER_ERROR, "Employee details saving failed with exception.");
		}
	}
	
}



