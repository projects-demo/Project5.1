package com.jpa.services;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jpa.entity.Employee;

/**
 * jpadb.employeetable Txn
 * 
 */
public class App {

	public static void main(String[] args) throws Exception {
		System.out.println("load context");
		int eId = 10;
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Employee employee = new Employee();
		// employee.setEid(1218);
		employee.setEname("Shourya Gupta12");
		employee.setSalary(44400);
		employee.setDeg("Technical Manager yes");

		EmployeeService emService = (EmployeeService) context.getBean("employeeServices");
		emService.persistEmployee(employee);

		// emService.findEmployee(eId);

		context.close();
	}

}
