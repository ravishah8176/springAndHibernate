package com.ravi.hibernate.demo.entity;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			int studentId =1;
			// begin the transaction
			System.out.println("Begin the transcation");
			session.beginTransaction();	
			
			// retrieve the student object based on studentId;
			Student theStudent = session.get(Student.class, studentId);
			
			// update the student object
			System.out.println("Updating student...");
			theStudent.setFirstName("Ram");
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
			// new code
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			for(Student student : theStudents) {
				String mailId = student.getFirstName();
				mailId += student.getLastName();
				mailId = mailId.toLowerCase();
				mailId += "@gmail.com";
				student.setEmail(mailId);
			}
			
			session.getTransaction().commit();
			
			
			System.out.println("Done");
			
		}
		finally {
			session.close();
		}
	}

}
