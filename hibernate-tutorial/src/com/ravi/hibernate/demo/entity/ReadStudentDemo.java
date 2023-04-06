package com.ravi.hibernate.demo.entity;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ReadStudentDemo {

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
			Student theStudent = new Student("Ankit", "Songara", "ankitsongara@gmail.com");
			
			// begin the transaction
			System.out.println("Begin the transcation");
			session.beginTransaction();			
			
			// save the student object
			System.out.println("saving student....");
			System.out.println(theStudent);
			session.save(theStudent);
			
			// commit transaction
			System.out.println("Commit");
			session.getTransaction().commit();
			
			// find out the student's id: primary key
			System.out.println("Saved student id: " + theStudent.getId());
			
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: " + theStudent.getId());
			
			Student myStudent = session.get(Student.class, theStudent.getId());
			
			System.out.println("Get complete: "+ myStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}
		finally {
			session.close();
		}
	}

}
