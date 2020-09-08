package com.jta.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.jta.model.EmployeeB;


@Service
public class EmployeeBDAOImpl implements EmployeeBDAO {

	@PersistenceContext(unitName = "PersistenceUnitB")
	private EntityManager entityManager;

	public void persistEmployee(EmployeeB employee) {
		// entityManager.getTransaction().begin();

		entityManager.persist(employee);
		// entityManager.getTransaction().commit();

		System.err.println("");
	}

}