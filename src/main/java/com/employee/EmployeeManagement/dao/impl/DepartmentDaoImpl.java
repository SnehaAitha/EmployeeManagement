package com.employee.EmployeeManagement.dao.impl;

import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import com.employee.EmployeeManagement.dao.DepartmentDao;
import com.employee.EmployeeManagement.dto.Department;
import com.employee.EmployeeManagement.dto.Employee;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Repository
public class DepartmentDaoImpl implements DepartmentDao{


	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<Department> fetchAllDepartments() {
		
		List<Department> depList = new ArrayList<Department>();

		MapSqlParameterSource param = new MapSqlParameterSource();	
		String sql = "select * from department";
	
		logger.info("Query to get the department details: ["+sql+"]");
		
		Map<String, Object> map = param.getValues();
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			logger.debug(entry.getKey()+" : "+entry.getValue());
		}		
		List<Department> departments =  namedParameterJdbcTemplate.query(sql, param, new FetchAllDepartmentsMapper()); 
			
		if(departments == null || departments.size() == 0) {
			return null;
		}
		
		for(Department dep:departments)
		{
			MapSqlParameterSource param2 = new MapSqlParameterSource();	
			
			String sql2 = "select * from employee where dept_id=:deptId";
			
			param2.addValue("deptId", dep.getId());
			
			logger.info("Query to get the employee details for a department: ["+sql2+"]");
			
			List<Employee> employees =  namedParameterJdbcTemplate.query(sql2, param2, new FetchAllEmployeesMapper());
			if(employees == null || employees.size() == 0) {
				dep.setEmployees(null);
			}
			else {
				dep.setEmployees(employees);
			}
			depList.add(dep);

		}
		return depList;
	}
	
	public static final class FetchAllDepartmentsMapper implements RowMapper<Department> {
		public Department mapRow(ResultSet rs, int rowNum) throws SQLException {

			Department dep = new Department();

			dep.setId(rs.getString("ID"));
			dep.setLocation(rs.getString("LOCATION"));
			dep.setName(rs.getString("NAME"));
			
			return dep;
		}
	}
	
	public static final class FetchAllEmployeesMapper implements RowMapper<Employee> {
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {

			Employee emp = new Employee();

			emp.setId(rs.getString("ID"));
			emp.setEmail(rs.getString("EMAIL"));
			emp.setName(rs.getString("NAME"));
			emp.setPosition(rs.getString("POSITION"));
			emp.setSalary(rs.getInt("SALARY"));
			emp.setDeptId(rs.getString("DEPT_ID"));
			
			return emp;
		}
	}

	@Override
	public byte[] generateDepEmpReport() throws JRException {
		
		List<Department> departments = fetchAllDepartments();
		
        InputStream reportTemplate = getClass().getResourceAsStream("/reports/depEmpReport.jrxml");
 
        JasperReport jasperReport = JasperCompileManager.compileReport(reportTemplate);
 
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(departments);
 
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);
 
        byte[] reportBytes = JasperExportManager.exportReportToPdf(jasperPrint);
 
        return reportBytes;
	}

}
