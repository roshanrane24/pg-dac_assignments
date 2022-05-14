package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory factory;
	
	static {
		// Initialize session factory
		factory = new Configuration().configure().buildSessionFactory();
	}
	
	// Getter
	public static SessionFactory getFactory() {
		return factory;
	}
}
