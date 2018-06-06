package com.luv2code.hibernate.dem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteDemo2 {

	public DeleteDemo2() {}
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
			
			
			session.beginTransaction();
			
			//Get instructor by primary key
			int theId = 2;
			Instructor tmpInstructor = session.get(Instructor.class, theId);
			
			System.out.println(tmpInstructor);
			
			if(tmpInstructor != null) {
				System.out.println("Deleting the insturtor " + tmpInstructor);
				session.delete(tmpInstructor);
			}
			//delete the instructor
			
			session.getTransaction().commit();
			System.out.println("Done");
		}
		finally {
			factory.close();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}












