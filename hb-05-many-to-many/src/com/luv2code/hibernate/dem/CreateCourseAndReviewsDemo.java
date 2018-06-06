package com.luv2code.hibernate.dem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndReviewsDemo {

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
			
			//Create a course
			Course tmpCourse = new Course("Advance Spring Java");
			
			//add some reviews
			tmpCourse.addReivew(new Review("Great course...loved it"));
			tmpCourse.addReivew(new Review("Cool course, good job"));
			tmpCourse.addReivew(new Review("Excellent"));
			
			
			//save the course... and leverage the cascade all save
			session.save(tmpCourse);
			
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












