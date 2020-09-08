package com.jta.service;

import com.jta.model.EmployeeA;
import com.jta.model.EmployeeB;

public interface EmployeeService {

void persistEmployees(EmployeeA employeeA, EmployeeB employeeB) throws Exception;
void persistEmployeeA(EmployeeA employeeA) throws Exception;

		
}
