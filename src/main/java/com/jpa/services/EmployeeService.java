package com.jpa.services;

import com.jpa.entity.Employee;

public interface EmployeeService {

	void persistEmployee(Employee employee) throws Exception;
	Employee findEmployee(int eId) throws Exception;
	
}
