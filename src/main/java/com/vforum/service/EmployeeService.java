package com.vforum.service;

	
	
	
	import java.util.List;

import com.vforum.model.Employee;
	 
	
	 
	public interface EmployeeService {
	     
	    public void addEmployee(Employee employee);
	 
	    //public List<Employee> getAllEmployeeDetails();
//	 
//	    public void deleteEmployee(Integer employeeId);
//	 
	    public Employee getEmployee(int employeeid);
	 
	   // public Employee updateEmployee(Employee employee);
	}
