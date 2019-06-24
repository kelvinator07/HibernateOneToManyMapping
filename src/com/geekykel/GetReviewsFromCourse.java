package com.geekykel;

import com.geekykel.entities.Course;
import com.geekykel.entities.Instructor;
import com.geekykel.entities.InstructorDetail;
import com.geekykel.entities.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetReviewsFromCourse {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			int id = 4;

			// start a transaction
			session.beginTransaction();

			Course course = session.get(Course.class, id);

			System.out.println("Course: " + course);

			System.out.println("Reviews: " + course.getReviews());
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			session.close();

			factory.close();
		}
	}

}





