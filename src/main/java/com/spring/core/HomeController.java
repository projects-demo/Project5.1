
package com.spring.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hibernate.mapping.Department;
import com.hibernate.models.ProductDetails;
import com.hibernate.models.User;
import com.hibernate.models.Vehicle;
import com.jpa.entity.Employee;
import com.jta.model.EmployeeA;
import com.jta.service.EmployeeService;
import com.spring.model.BeanModel;

//http://localhost:8085/hello //http://localhost:8080/swagger-ui.html
//http://localhost:8080/hello //http://localhost:8081/Project5/get-vehicles

@Controller
public class HomeController {

	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	SessionFactory sessionFactory2;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	EmployeeService employeeService;

	@Autowired(required=false)
	com.jpa.services.EmployeeService employeeServices;


	@RequestMapping("/welcome")
	public String getGreetingsMessage() {
		System.out.println("Inside Greetings Message");
		return  "welcome";
	}
	
	@GetMapping("/list-beans")
	@ResponseBody
	public ArrayList<BeanModel> listAllBeans() {
		ArrayList<BeanModel> listOfBeans = new ArrayList<BeanModel>();

		StringBuffer beansSB = new StringBuffer();
		BeanModel currentBean;
		String[] beanNames = applicationContext.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println("---> " + beanName);
			currentBean = new BeanModel(beanName);
			listOfBeans.add(currentBean);
			beansSB.append("---> " + beanName).append("\n\r");
		}

		return listOfBeans;
	}

	/**
	 * Hibernate query
	 * Employee.Vehicle
	 */
	@RequestMapping(value = "/get-vehicles", method = RequestMethod.GET)
	@ResponseBody
	public Vehicle getVehicles(@RequestParam int vehicleId) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Vehicle vehicle = session.get(Vehicle.class, vehicleId);
		session.getTransaction().commit();
		session.close();
		return vehicle;

	}

	/**
	 * Hibernate query
	 * Employee.Vehicle
	 */
	@PostMapping(path = "/set-vehicles", consumes = "application/json", produces = "application/json")
	public void addVehicle(@RequestBody Vehicle vehicle) {
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setName(vehicle.getName());
		vehicle.setVehicleId(vehicle.getVehicleId());
		vehicle.setVehicleType(vehicle.getVehicleType());
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(vehicle);
		session.getTransaction().commit();
		session.close();
	}

	/**
	 * Hibernate query
	 * Employee.User
	 */

	@PostMapping(path = "/set-user", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public User setUser(@RequestBody User user1) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		User user = new User();
		user.setUserName(user1.getUserName());
		user.setRollNo(user1.getRollNo());
		user.setId(user1.getId());

		session.save(user);
		session.getTransaction().commit();

		session.close();
		return user1;
	}

	/**
	 * Hibernate query
	 * Employee.User
	 */
	@RequestMapping(value = "/get-user", method = RequestMethod.GET)
	@ResponseBody
	public User getUser(@RequestParam int userId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		User user = session.get(User.class, userId);
		session.getTransaction().commit();
		session.close();
		return user;
	}

	/**
	 * jdbcTemplate query
	 * companyA.product_details
	 */
	@RequestMapping(value = "/get-products", method = RequestMethod.GET)
	@ResponseBody
	public String getProducts(@RequestParam String productName) {
		String sql = "SELECT pfunctionality FROM product_details where pname = '" + productName + "' limit 1;";

		List<String> result = jdbcTemplate.queryForList(sql, String.class);
		return productName + " is good for " + result.get(0);

	}

	/**
	 * jdbcTemplate query
	 * companyA.product_details
	 */
	@RequestMapping(value = "/add-products", method = RequestMethod.POST)
	@ResponseBody
	public String addProducts(@RequestBody ProductDetails product) {
		String query = "INSERT INTO product_details VALUES ('" + product.getId() + "','"
				+ product.getPfunctionality() + "','" + product.getPname() + "');";
		jdbcTemplate.execute(query);
		return "Product " + product.getPname() + " added succesfully!";
	}

	/**
	 * Atomikos Distributed Txn
	 * PersistenceUnitA
	 * companya.EMPLOYEEA
	 */

	@RequestMapping(value = "/add-employee", method = RequestMethod.POST)
	@ResponseBody
	public String addEmployee(@RequestBody EmployeeA em1) {
		try {
			employeeService.persistEmployeeA(em1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return em1.getName() + " added succesfully!";

	}

	/**
	 * JPA persistence entity mapping query
	 * Eclipselink_JPA
	 * jpadb.EMPLOYEETABLE
	 */

	@RequestMapping(value = "/insert-employee", method = RequestMethod.POST)
	@ResponseBody
	public String insertEmployee(@RequestBody Employee employee) {
		try {
			employeeServices.persistEmployee(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee.getEname() + " added succesfully!";

	}

	/**
	 * JPA persistence entity mapping query
	 * Eclipselink_JPA
	 * jpadb.EMPLOYEETABLE
	 */
	@RequestMapping(value = "/find-employee", method = RequestMethod.GET)
	@ResponseBody
	public Employee findEmployee(@RequestParam int eId) {
		Employee emp = null;
		try {
			emp = employeeServices.findEmployee(eId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;

	}

	/**
	 * hbm.xml mapping file example
	 * hbtutorial.Department
	 */
	@RequestMapping(value = "/add-dept", method = RequestMethod.POST)
	@ResponseBody
	public String insertDept(@RequestBody Department department) {
		try {
			Session session = sessionFactory2.openSession();
			session.beginTransaction();

			session.save(department);

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return department.getDepartmentName() + " added succesfully!";

	}

}
