package com.employee.EmployeeManagement.dao;

import java.util.List;
import com.employee.EmployeeManagement.dto.Department;

import net.sf.jasperreports.engine.JRException;

public interface DepartmentDao{
	
	public List<Department> fetchAllDepartments();

	public byte[] generateDepEmpReport() throws JRException;

}