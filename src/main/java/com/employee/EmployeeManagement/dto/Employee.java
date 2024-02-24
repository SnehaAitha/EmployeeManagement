
package com.employee.EmployeeManagement.dto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table(name="EMPLOYEE")
public class Employee implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;	
	
	private String name;	
	private String email;
	private String position;
    private int salary;
    
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="dept_id", nullable=false)
	@JsonBackReference
	private Department department;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", position=" + position + ", salary="
				+ salary + ", department=" + department + "]";
	}	

}
