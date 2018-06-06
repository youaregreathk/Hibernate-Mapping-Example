package com.luv2code.hibernate.dem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class GetCourseForMaryDemo {

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
	
			int id = 5;
			Student marry = session.get(Student.class, id);
			
			System.out.println("Loaded student " + marry);
			System.out.println("Loaded student courses" + marry.getCourses());
			
			//create more courses
			Course course1 = new Course("Music 101");
			Course course2 = new Course("Physics 101");
			
			//Add student to course
			course1.addStudent(marry);
			course2.addStudent(marry);
			
			session.save(course1);
			session.save(course2);
			
		
			
			//Commit the transaction
			session.getTransaction().commit();
			System.out.println("Done");
		}
		finally {
			session.close();
			factory.close();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}












