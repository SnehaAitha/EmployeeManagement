package com.employee.EmployeeManagement.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.employee.EmployeeManagement.dto.Department;
import com.employee.EmployeeManagement.response.Response;
import com.employee.EmployeeManagement.service.DepartmentService;
import java.io.OutputStream;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(path = "/department")
public class DepartmentController {
	
	@Autowired
	DepartmentService depService;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping(value = "/fetchAllDepartments")
	public Response<List<Department>> fetchAllDepartments() {

		try {
			logger.debug("In fetchAllDepartments.");
			List<Department> departments = depService.fetchAllDepartments();
			if(departments != null && departments.size() == 0) 
				return new Response<List<Department>>(HttpStatus.OK, "Departments retrived successfully with no rows." , departments);
			return new Response<List<Department>>(HttpStatus.OK, "Departments retrived successfully.", departments);
		} catch (Exception ex) {
			logger.error("Departments retrival failed with exception.");
			return new Response<List<Department>>(HttpStatus.INTERNAL_SERVER_ERROR, "Departments retrival failed.");
		}
	}
	
	/*@GetMapping("/generateDepartmentReport")
	    public void generateReport(HttpServletResponse response) throws Exception {
	        byte[] reportBytes = depService.generateDepEmpReport();

	        response.setContentType("application/pdf");
	        response.setHeader("Content-Disposition", "inline; depemp-report.pdf");

	        OutputStream outputStream = response.getOutputStream();
	        outputStream.write(reportBytes);
	        outputStream.flush();
	    }*/

}
