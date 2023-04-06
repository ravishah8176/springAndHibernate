package com.ravi.hibernate.demo.entity.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ravi.hibernate.demo.entity.Course;
import com.ravi.hibernate.demo.entity.Instructor;
import com.ravi.hibernate.demo.entity.InstructorDetail;
import com.ravi.hibernate.demo.entity.Review;
import com.ravi.hibernate.demo.entity.Student;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			
			session.beginTransaction();
			
			Course theCourse = new Course("The new chapter");
			
			System.out.println("Saving the course");
			session.save(theCourse);
			System.out.println("Saving done" + theCourse);
			
			Student theStudent1 = new Student("Ravi", "shah", "ravishah@gmail.com");
			Student theStudent2 = new Student("Ranjan", "Chaudhary", "ranjanchaudhary@gmail.com");
			theCourse.addStudent(theStudent1);
			theCourse.addStudent(theStudent2);
			
			// saving student
			session.save(theStudent1);
			session.save(theStudent2);
			
			// printing associated students
			System.out.println("The associated students are: " + theCourse.getStudents());
			
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
