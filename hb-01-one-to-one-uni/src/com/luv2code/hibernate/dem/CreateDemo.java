package com.luv2code.hibernate.dem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
			/*
			Instructor tmpInstructor = new Instructor("Michael", "Shea", "shea.3100@gmail.com");
			
			InstructorDetail tmpInstructorDetail = new InstructorDetail("www.youtube.com", "Play Football");
			
			tmpInstructor.setInstructorDetail(tmpInstructorDetail);
			*/
			Instructor tmpInstructor = new Instructor("Madhu", "Patel", "Patel@gmail.com");
			
			InstructorDetail tmpInstructorDetail = new InstructorDetail("www.youtube.com", "Play music");
			
			tmpInstructor.setInstructorDetail(tmpInstructorDetail);
			
			session.beginTransaction();
			//Cascade save all 
			session.save(tmpInstructor);
			
			session.getTransaction().commit();
			System.out.println("Done");
		}
		finally {
			factory.close();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}












