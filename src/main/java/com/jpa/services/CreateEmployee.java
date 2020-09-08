package com.jpa.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jpa.entity.Employee;

/**
 * https://www.tutorialspoint.com/jpa/jpa_orm_components.htm
 * https://webdev.jhuep.com/~jcs/ejava-javaee/coursedocs/content/html/jpa-entity-entitymap.html
 * https://webdev.jhuep.com/~jcs/ejava-javaee/coursedocs/content/html_single/jpa-entity-book.html
 * https://docs.jboss.org/hibernate/annotations/3.5/reference/en/html/xml-overriding.html
 * https://webdev.jhuep.com/~jcs/ejava-javaee/coursedocs/605-784-site/docs/content/html/hibernate-migration-orm.html
 * hibernate.cfg.xml -> persistence.xml
 * hbm.xml -> orm.xml (mapping.xml)
 * https://wiki.eclipse.org/EclipseLink/Examples/MOXy/JPA
 * https://thorben-janssen.com/mapping-definitions-jpa-hibernate-annotations-xml/?unapproved=60082&moderation-hash=fbb7b8db36f1fef8733eae7645878304#comment-60082
 * https://openjpa.apache.org/builds/1.2.3/apache-openjpa/docs/jpa_overview_meta.html
 */
public class CreateEmployee {

	public static void main(String[] args) {
		// ConfigurableApplicationContext context = new
		// ClassPathXmlApplicationContext("applicationContext.xml");

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Employee employee = new Employee();
		employee.setEid(1217);
		employee.setEname("Gopalaaa");
		employee.setSalary(44400);
		employee.setDeg("Technical Manager");

		entitymanager.persist(employee);
		entitymanager.getTransaction().commit();

		entitymanager.close();
		emfactory.close();
	}
}