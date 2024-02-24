package com.employee.EmployeeManagement.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.EmployeeManagement.dto.Department;
import com.employee.EmployeeManagement.repository.DepartmentRepository;
import com.employee.EmployeeManagement.service.DepartmentService;
import net.sf.jasperreports.engine.JRException;

@Service("DepartmentService")
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	DepartmentRepository depRepo;
	
	@Override
	public List<Department> fetchAllDepartments() {
		return depRepo.findAll();
	}	
	
	/*@Override
	public byte[] generateDepEmpReport() throws JRException {
		return depRepo.generateDepEmpReport();
	}*/
	
}