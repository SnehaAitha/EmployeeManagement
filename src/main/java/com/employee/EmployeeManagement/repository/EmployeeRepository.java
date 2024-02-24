package com.employee.EmployeeManagement.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.employee.EmployeeManagement.dto.Department;
import com.employee.EmployeeManagement.dto.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,String> {

	List<Employee> findByDepartment(Department department);

}