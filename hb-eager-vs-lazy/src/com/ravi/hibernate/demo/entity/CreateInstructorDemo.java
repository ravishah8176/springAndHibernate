package com.ravi.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			
			
			// create the objects
//			Instructor theInstructor = new Instructor("Anshu", "Agrawal", "anshuagrawal@gmail.com");
//			
//			InstructorDetail theInstructorDetail = new InstructorDetail("https://www.youtube.com/anshuagrawawl", "writing letter");
//			theInstructor.setInstructorDetail(theInstructorDetail);
//			Course theCourse = new Course("The girl");
//			theInstructor.addCourse(theCourse);
			
//			retrieving instructor detail from database
			
			session.beginTransaction();
			int theId=1;
			Instructor theInstructor = session.get(Instructor.class, theId);
			
			InstructorDetail theInstructorDetail = theInstructor.getInstructorDetail();
			
			System.out.println("Printing theInstructor is " + theInstructor);
			System.out.println("Printing associated Instructor detail is " + theInstructorDetail);
			
			session.getTransaction().commit();
			
			
			
		}
		finally {
			session.close();
			factory.close();
		}
		

	}

}
