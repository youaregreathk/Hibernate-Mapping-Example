package com.luv2code.hibernate.dem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class GetInstructorDetailDemo {

	public GetInstructorDetailDemo() {}
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			
			int id = 22345;
			InstructorDetail tmpInstructorDetail = session.get(InstructorDetail.class, id);
			
			System.out.println("tmpInstructorDetail is " + tmpInstructorDetail);
			
			System.out.println("tmpInstructor is " + tmpInstructorDetail.getInstructor());
			
			//get instructor detail object
			
			//print the instructor detail
			
			//print the associated instructor
			session.getTransaction().commit();
			System.out.println("Done");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}












