package com.jpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.dao.EmployeeDAO;
import com.jpa.entity.Employee;

@Service("employeeServices")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO employeeDAO;

	@Transactional	("jpa")

	public void persistEmployee(Employee employeeA) throws Exception {
		System.out.println("Persist A");
		employeeDAO.persistEmployee(employeeA);
		System.out.println("Persist A OK - persist B");
		// employeeBDAO.persistEmployee(employeeB);
		// System.out.println("Persist B okk");
	}

	@Transactional(rollbackFor = Exception.class)
	public Employee findEmployee(int eId) throws Exception {
		return employeeDAO.findEmployee(eId);
		 
		
	}

}
