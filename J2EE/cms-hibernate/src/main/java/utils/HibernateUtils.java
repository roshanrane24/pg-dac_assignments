package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory sf;
	
	// getter for session factory
	public static SessionFactory getFactory() {
		return sf;
	}
	
	public static void buildFactory() {
		// Configure hibernate & build session factory
		sf = new Configuration().configure().buildSessionFactory();
	}
	
	public static void closeFactory() {
		// Close all factory resourses
		sf.close();
	}
}
