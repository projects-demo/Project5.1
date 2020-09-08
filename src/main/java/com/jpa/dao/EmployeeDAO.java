package com.jpa.dao;

import com.jpa.entity.Employee;

public interface EmployeeDAO {
	
		  void persistEmployee(Employee employee);		  
		  Employee findEmployee(int eId) ;

}
