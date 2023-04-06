package com.ravi.hibernate.demo.entity;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateStudentDemo {

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
			// create the student objects
			System.out.println("Creating new student objects...");
			Student theStudent = new Student("Ramesh", "Shah", "rameshshah@gmail.com");
			
			// begin the transaction
			System.out.println("Begin the transcation");
			session.beginTransaction();			
			
			// save the student object
			System.out.println("saving student....");
			session.save(theStudent);
			
			// commit transaction
			System.out.println("Commit");
			session.getTransaction().commit();
			System.out.println("Done");
			
		}
		finally {
			session.close();
		}
	}

}
