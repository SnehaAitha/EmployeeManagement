package com.employee.EmployeeManagement.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import com.employee.EmployeeManagement.dao.EmployeeDao;
import com.employee.EmployeeManagement.dto.Employee;
import org.springframework.jdbc.core.RowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{


	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<Employee> fetchAllEmployees() {
		
		MapSqlParameterSource param = new MapSqlParameterSource();	
		String sql = "select * from employee";

		logger.info("Query to get the notification details: ["+sql+"]");
		Map<String, Object> map = param.getValues();
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			logger.debug(entry.getKey()+" : "+entry.getValue());
		}	
		List<Employee> employees =  namedParameterJdbcTemplate.query(sql, param, new FetchAllEmployeesMapper()); 
			
		if(employees == null || employees.size() == 0) {
			return null;
		}
		return employees;
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
	public List<Employee> fetchEmployeesInDepartment(String deptId) {
		MapSqlParameterSource param = new MapSqlParameterSource();	
		
		String sql = "select * from employee where dept_id=:deptId";
		
		param.addValue("deptId", deptId);
	
		logger.info("Query to get the employee details in a department: ["+sql+"]");
		Map<String, Object> map = param.getValues();
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			logger.debug(entry.getKey()+" : "+entry.getValue());
		}	
		List<Employee> employees =  namedParameterJdbcTemplate.query(sql, param, new FetchAllEmployeesMapper()); 
			
		if(employees == null || employees.size() == 0) {
			return null;
		}
		return employees;
	}


	@Override
	public boolean deleteEmployeeInDepartment(String empId) {

		MapSqlParameterSource param = new MapSqlParameterSource();	

		String sql = "delete from employee where id=:empId";

		param.addValue("empId", empId);

		logger.info("Query to delete the employee details in a department: ["+sql+"]");
		Map<String, Object> map = param.getValues();
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			logger.debug(entry.getKey()+" : "+entry.getValue());
		}	
		int delStatus =  namedParameterJdbcTemplate.update(sql, param); 
		
		System.out.println(delStatus);

		if(delStatus == 1) {
			return true;
		}
		return false;
	}


	@Override
	public Employee addEmployeeInDepartment(Employee emp) {
		MapSqlParameterSource param = new MapSqlParameterSource();	

		String sql = "INSERT INTO EMPLOYEE (id, name,email,position,salary,dept_id) VALUES (:id, :name,:email,:position,:salary,:dept_id)";

		param.addValue("id", emp.getId());
		param.addValue("name", emp.getName());
		param.addValue("email", emp.getEmail());
		param.addValue("position", emp.getPosition());
		param.addValue("salary", emp.getSalary());
		param.addValue("dept_id", emp.getDeptId());

		logger.info("Query to insert the employee details in a department: ["+sql+"]");
		Map<String, Object> map = param.getValues();
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			logger.debug(entry.getKey()+" : "+entry.getValue());
		}	
		int insertStatus =  namedParameterJdbcTemplate.update(sql, param); 
		return emp;
	}
}
