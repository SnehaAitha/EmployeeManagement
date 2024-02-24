package com.employee.EmployeeManagement.service;

import java.util.List;
import com.employee.EmployeeManagement.dto.Department;
import net.sf.jasperreports.engine.JRException;

public interface DepartmentService {
	
	public List<Department> fetchAllDepartments();
	
	//public byte[] generateDepEmpReport() throws JRException ;
	
}
