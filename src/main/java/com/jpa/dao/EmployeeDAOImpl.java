package com.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.jpa.entity.Employee;

@Service
public class EmployeeDAOImpl implements EmployeeDAO {

	@PersistenceContext(unitName = "Eclipselink_JPA")
	private EntityManager entityManager;

	@Transactional
	public void persistEmployee(Employee employee) {
		entityManager.merge(employee);
	}

	public Employee findEmployee(int eId) {
	     Query query = entityManager.createNamedQuery("find employee by id");
	      
	      query.setParameter("id", eId);
	      List<Employee> list = query.getResultList( );
	    
	      if(list.size() ==0 )
	    	  return new Employee();
	      
	      for( Employee e:list ){
	         System.err.print("Employee ID :" + e.getEid( ));
	         System.err.println("\t Employee Name :" + e.getEname( ));
	      }
		return list.get(0);
		
	}

}

