package com.ravi.hibernate.demo.entity.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ravi.hibernate.demo.entity.Course;
import com.ravi.hibernate.demo.entity.Instructor;
import com.ravi.hibernate.demo.entity.InstructorDetail;
import com.ravi.hibernate.demo.entity.Review;
import com.ravi.hibernate.demo.entity.Student;

public class AddMoreCoursesToAStudentDemo {

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
			
			int theId = 2;
			
			Student theStudent = session.get(Student.class, theId);
			
			Course theCourse1 = new Course("Java Mastery Class");
			Course theCourse2 = new Course("Python Mastery Class");
			
			theStudent.addCourse(theCourse2);
			theStudent.addCourse(theCourse1);
			
			session.save(theCourse1);
			session.save(theCourse2);
			
			System.out.println("Printing student: " + theStudent);
			System.out.println("Printing associated course: " + theStudent.getCourses());
			
			
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
