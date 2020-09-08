 package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hibernate.models.User;
import com.hibernate.models.Vehicle;

public class HibernateMain {
	public static void main(String[] args) {

		Vehicle vehicle = new Vehicle();
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		vehicle.setName("Fortuner");
		vehicle.setVehicleId(4344);
		vehicle.setVehicleType("4 Wheeler");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(vehicle);
		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();
		session.beginTransaction();
		User user = new User();
		user.setUserName("Saurabh");
		user.setRollNo(2204);

		session.save(user);
		session.getTransaction().commit();

		session.close();

	}

}
