package com.ravi.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

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
				Student theStudent1 = new Student("Suraj", "Bothara", "surajbothara6@gmail.com");
				Student theStudent2 = new Student("Anshu", "Agrawal", "anshuagrawal@gmail.com");
				Student theStudent3 = new Student("Tejas", "Tiwary", "tejastiwary@gmail.com");
				Student theStudent4 = new Student("Ravi", "Shah", "ravishah@gmail.com");
				
				// begin the transaction
				System.out.println("Begin the transcation");
				session.beginTransaction();			
				
				// save the student object
				System.out.println("saving student....");
				session.save(theStudent1);
				session.save(theStudent2);
				session.save(theStudent3);
				session.save(theStudent4);
			
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
