package com.jpa.services;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.jpa.entity.Employee;

public class NamedQueries {
   public static void main( String[ ] args ) {
   
      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
      EntityManager entitymanager = emfactory.createEntityManager();
      Query query = entitymanager.createNamedQuery("find employee by id");
      
      query.setParameter("id", 1204);
      List<Employee> list = query.getResultList( );
      
      for( Employee e:list ){
         System.err.print("Employee ID :" + e.getEid( ));
         System.err.println("\t Employee Name :" + e.getEname( ));
      }
   }
}