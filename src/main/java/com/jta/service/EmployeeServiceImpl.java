package com.jta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jta.dao.EmployeeADAO;
import com.jta.dao.EmployeeBDAO;
import com.jta.model.EmployeeA;
import com.jta.model.EmployeeB;




@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeADAO employeeADAO;

	@Autowired
	EmployeeBDAO employeeBDAO;

	@Transactional("jta")
	public void persistEmployees(EmployeeA employeeA, EmployeeB employeeB) throws Exception {
		System.out.println("Persist A");
		employeeADAO.persistEmployee(employeeA);
		System.out.println("Persist A OK - persist B");
		employeeBDAO.persistEmployee(employeeB);
		System.out.println("Persist B okk");
	}

	@Transactional("jta")
	public void persistEmployeeA(EmployeeA employeeA) throws Exception {
		System.out.println("Persist A");
		employeeADAO.persistEmployee(employeeA);
	}

}
