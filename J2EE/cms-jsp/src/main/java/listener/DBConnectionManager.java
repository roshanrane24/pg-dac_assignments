package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import utils.DBUtils;

/**
 * Application Lifecycle Listener implementation class DBConnectionManager
 *
 */
@WebListener
public class DBConnectionManager implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public DBConnectionManager() {
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  {
    	// Get context
    	ServletContext ctx = sce.getServletContext();
    	
    	// Access parameter & open connection
    	try {
    		// Get parameters from context
    		String url = ctx.getInitParameter("db_url");
    		String user = ctx.getInitParameter("db_user");
    		String pass = ctx.getInitParameter("db_pass");
    		
    		// OPen Connection
			DBUtils.openConnection(url, user, pass);
		} catch (Exception e) {
			throw new RuntimeException("Error opening DB Connection");
		}
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	try {
			DBUtils.closeConnection();
		} catch (Exception e) {
			throw new RuntimeException("Error closing DB Connection");
		}
    }
	
}
