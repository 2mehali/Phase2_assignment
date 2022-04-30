package com.LearnersAcademy;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.LearnersAcademy.Classes;
import com.LearnersAcademy.Students;
import com.LearnersAcademy.Subjects;
import com.LearnersAcademy.Teachers;

public class HibernateUtil {

	public static SessionFactory buildSessionFactory() {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Teachers.class)
				.addAnnotatedClass(Subjects.class)
				.addAnnotatedClass(Classes.class)
				.addAnnotatedClass(Students.class)
				.buildSessionFactory();
				
		return sessionFactory;
	}
}