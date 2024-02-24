package com.employee.EmployeeManagement.dto;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="DEPARTMENT")
public class Department implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;	
	
	private String name;	
	private String location;	
	
	@OneToMany(mappedBy="department",cascade = CascadeType.REMOVE)
	@JsonManagedReference
	private List<Employee> employees;

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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", location=" + location + ", employees=" + employees + "]";
	}
	
}
