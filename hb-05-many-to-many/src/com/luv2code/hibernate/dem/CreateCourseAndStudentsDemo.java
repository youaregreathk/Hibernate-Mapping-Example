package com.luv2code.hibernate.dem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

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
	
			//Create a course
			Course tmpCourse = new Course("Advance Spring Java");
			
			System.out.println("\nSaving the course....");
			//save the course... and leverage the cascade all save
			session.save(tmpCourse);
			System.out.println("\nSaved the course....");
			
			Student tmp1 = new Student("John", "Doe", "john@gmail.com");
			Student tmp2 = new Student("Marry", "Doe", "Marry@gmail.com");
			Student tmp3 = new Student("Peter", "Doe", "Peter@gmail.com");
			
			tmpCourse.addStudent(tmp1);
			tmpCourse.addStudent(tmp2);
			tmpCourse.addStudent(tmp3);
			
			session.save(tmp1);
			session.save(tmp2);
			session.save(tmp3);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
		}
		finally {
			session.close();
			factory.close();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}












