 package com.hibernate.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hibernate.models.Vehicle;

public class HibernateMain {
	public static void main(String[] args) {

		Vehicle vehicle = new Vehicle();
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory2");

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Department d = new Department();
	    d.setDepartmentName("ERS");
	    d.setId(new Long(17));
		session.save(d);
		
		
		session.getTransaction().commit();

		session.close();

	}

}
