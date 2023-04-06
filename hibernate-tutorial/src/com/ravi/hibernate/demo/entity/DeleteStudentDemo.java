package com.ravi.hibernate.demo.entity;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
//			int studentId = 7;
//			
//			// the current session
//			session = factory.getCurrentSession();
//			
//			// start the session
//			session.beginTransaction();
//			
//			// retrieve the student object based on studentId
//			Student theStudent = session.get(Student.class, studentId);
//			
//			// delete the student
//			session.delete(theStudent);
//			
//			// close the session
//			session.getTransaction().commit();
			
			
			// new code
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			session.createQuery("delete from Student where id=8")
					.executeUpdate();
			
			session.getTransaction().commit();
			
		}
		finally {
			session.close();
		}
	}

}
