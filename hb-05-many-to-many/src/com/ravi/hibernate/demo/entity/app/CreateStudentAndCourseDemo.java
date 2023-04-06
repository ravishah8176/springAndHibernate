package com.ravi.hibernate.demo.entity.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ravi.hibernate.demo.entity.Course;
import com.ravi.hibernate.demo.entity.Instructor;
import com.ravi.hibernate.demo.entity.InstructorDetail;
import com.ravi.hibernate.demo.entity.Review;
import com.ravi.hibernate.demo.entity.Student;

public class CreateStudentAndCourseDemo {

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
			
			Student theStudent = new Student("ram", "lal", "ramlal@gmail.com");
			
			session.save(theStudent);
			
			Course theCourse1 = new Course("The rag -1 ");
			Course theCourse2 = new Course("The ball -1");
			
			System.out.println("Printing student" + theStudent);
			
			theStudent.addCourse(theCourse1);
			theStudent.addCourse(theCourse2);
			
			session.save(theCourse1);
			session.save(theCourse2);
			
		
			System.out.println("Printing associated courses: " + theStudent.getCourses());
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
