package com.jta.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.jta.model.EmployeeA;

@Service
public class EmployeeADAOImpl implements EmployeeADAO {

	@PersistenceContext(unitName = "PersistenceUnitA")
	private EntityManager entityManager;

	public void persistEmployee(EmployeeA employee) {
		// entityManager.getTransaction().begin();

		entityManager.persist(employee);
		// entityManager.getTransaction().commit();

		System.err.println("");
	}

}