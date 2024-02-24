package com.employee.EmployeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.employee.EmployeeManagement.dto.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,String> {

}