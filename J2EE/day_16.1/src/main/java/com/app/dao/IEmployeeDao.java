package com.app.dao;

import java.util.List;

import com.app.pojos.Employee;

public interface IEmployeeDao {
	// Get Employee Roles
	List<String> getDepartments();
	
	// Get Employee list for given role
	List<Employee> getEmployees(String dept);
	
}
