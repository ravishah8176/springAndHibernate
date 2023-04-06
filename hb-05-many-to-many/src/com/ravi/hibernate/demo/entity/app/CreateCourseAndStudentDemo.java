package com.ravi.hibernate.demo.entity.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ravi.hibernate.demo.entity.Course;
import com.ravi.hibernate.demo.entity.Instructor;
import com.ravi.hibernate.demo.entity.InstructorDetail;
import com.ravi.hibernate.demo.entity.Review;

public class CreateCourseAndStudentDemo {

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
			
			
			session.beginTransaction();
			
			Course theCourse = new Course("The golden gate");
			
			theCourse.addReview(new Review("large golden gate"));
			theCourse.addReview(new Review("coated with golden color"));
			
			System.out.println("Saving the course");
			session.save(theCourse);
			
			System.out.println("Printing the Course: " + theCourse);
			System.out.println("Printing the reviews: " + theCourse.getReviews());
			
			session.getTransaction().commit();
			System.out.println("Done");
		}
		
		finally {
			// closing factory and session
			session.close();
			factory.close();
		}
		
	}

}
