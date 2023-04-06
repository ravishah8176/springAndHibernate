package com.ravi.hibernate.Hibernate.and.Jpa;

import ch.qos.logback.classic.pattern.LineSeparatorConverter;
import com.ravi.hibernate.Hibernate.and.Jpa.dao.StudentDAO;
import com.ravi.hibernate.Hibernate.and.Jpa.dao.StudentDAOImpl;
import com.ravi.hibernate.Hibernate.and.Jpa.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HibernateAndJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateAndJpaApplication.class, args);
	}

	// command line runner
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);
//			readStudent(studentDAO);
//			readAllStudent(studentDAO);
//			updateFirstName(studentDAO);
			deleteStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO){
		// create the student object
		System.out.println("Creating student object");
		Student theStudent = new Student("Shyam", "Singh", "shyamsingh@gmail.com");

		// saving the student
		System.out.println("saving the student object to the database");
		studentDAO.save(theStudent);

		// display the id of the saved student
		System.out.println("save student generated id is " + theStudent.getId());

	}

	private void readStudent(StudentDAO studentDAO){
		// retrieving the student from the database
		Student theStudent = studentDAO.findById(1);
		System.out.println(theStudent);
	}

	private void readAllStudent(StudentDAO studentDAO){
		List<Student> theStudents = studentDAO.findAll();
		System.out.println(theStudents);
	}

	private void updateFirstName(StudentDAO studentDAO){
		// read the student with the id 4
		Student theStudent = studentDAO.findById(4);
		System.out.println(theStudent);

		// set first name of the student with id 4
		theStudent.setFirstName("Kumar");
		theStudent.setEmail("kumarsingh@mail.com");
		System.out.println(theStudent);
	}

	private void deleteStudent(StudentDAO studentDAO){
		studentDAO.delete(4);
	}
}
