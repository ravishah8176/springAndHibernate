package com.ravi.hibernate.demo.entity;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;




public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// use the session objects to save the Java objects
			
			// begin the transaction
			session.beginTransaction();
			
			// query student
			List<Student> theStudents = session.createQuery("from Student").getResultList();  //getResultList()
			
			// display student
			displayStudents(theStudents);
			
			
			theStudents = session.createQuery("from Student s where s.lastName='shah'").getResultList();
			System.out.println("Student name whose last name is shah: ");
			displayStudents(theStudents);
			
			theStudents = session.createQuery("from Student s where"+ " s.lastName='Bothara' OR s.lastName='Shah'").getResultList();
			System.out.println("Student name whose last name is shah: ");
			displayStudents(theStudents);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
			
		}
		finally {
			session.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student theStudent:theStudents) {
			System.out.println(theStudent);
		}
	}

}
