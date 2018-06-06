package com.luv2code.hibernate.dem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCoursesDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
			
			session.beginTransaction();
			
			int id = 1;
			Instructor tmpInstructor = session.get(Instructor.class, id);
			Course tmpcourse1 = new Course("English");
			Course tmpcourse2 = new Course("Math");
			
			tmpInstructor.add(tmpcourse1);
			tmpInstructor.add(tmpcourse2);
			
			session.save(tmpcourse1);
			session.save(tmpcourse2);
			
			session.getTransaction().commit();
			System.out.println("Done");
		}
		finally {
			session.close();
			factory.close();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}












