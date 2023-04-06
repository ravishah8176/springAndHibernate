package com.ravi.hibernate.demo.entity.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ravi.hibernate.demo.entity.Course;
import com.ravi.hibernate.demo.entity.Instructor;
import com.ravi.hibernate.demo.entity.InstructorDetail;
import com.ravi.hibernate.demo.entity.Review;

public class DeleteCourseAndReviewsDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			// begin transaction
			// begin transaction
			session.beginTransaction();
			
			int theId = 12;
			
			Course theCourse = session.get(Course.class, theId);
			
			System.out.println("Printing the course: " + theCourse);
			
			System.out.println("Printing associated reviews " + theCourse.getReviews());
			
			session.delete(theCourse);
			
			System.out.println("Done");
			
			// transaction done
			session.getTransaction().commit();
		}
		
		finally {
			session.close();
			factory.close();
		}
		
	}

}
