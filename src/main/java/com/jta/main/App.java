package com.jta.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jta.model.EmployeeA;
import com.jta.model.EmployeeB;
import com.jta.service.EmployeeService;

/**
 * companya.employeea 
 * companya.employeeb
 * Distributed Txn by Atomikos
 * 
 */
public class App {

	public static void main(String[] args) throws Exception {
		System.out.println("load context");
//		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		EmployeeA em1 = new EmployeeA();
		em1.setId("12346");
		em1.setName("John4");
		em1.setAge(35);
		EmployeeB em2 = new EmployeeB();
		em2.setId("1253");
		em2.setName("Mary3");
		em2.setAge(31);
		EmployeeService emService = (EmployeeService) context.getBean("employeeService");
		emService.persistEmployees(em1, em2);
		context.close();
	}

}
