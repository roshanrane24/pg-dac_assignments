package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import utils.DBUtils;

/**
 * Application Lifecycle Listener implementation class CMSListener
 *
 */
@WebListener
public class DBListener implements ServletContextListener {

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	// Close DB Connection
    	try {
			DBUtils.closeConnection();
		} catch (Exception e) {
			throw new RuntimeException("[ERROR] (Closing Connection) : " + e);
		}
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	// Open DB Connection
    	try {
			DBUtils.openConnection();
		} catch (Exception e) {
			throw new RuntimeException("[ERROR] (Closing Connection) : " + e);
		}
    }
	
}
