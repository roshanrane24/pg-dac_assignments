package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import utils.HibernateUtils;

/**
 * Application Lifecycle Listener implementation class DBConnectionManager
 *
 */
@WebListener
public class SessionFactoryManager implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public SessionFactoryManager() {
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		try {
			// Build Session Factory
			HibernateUtils.buildFactory();
		} catch (Exception e) {
			throw new RuntimeException("Error while building hibernet session factory : " + e);
		}
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		try {
			HibernateUtils.closeFactory();
		} catch (Exception e) {
			throw new RuntimeException("Error while disposing hibernet session factory : " + e);
		}
	}

}
