package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import pojos.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet({ "/authenticate", "/validate" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		try {
			// Create User DAO Instance
			userDao = new UserDao();
		} catch (Exception e) {
			throw new ServletException("[ERROR] (init) in " + this.getClass() + " : " + e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			userDao.cleanUp();
		} catch (Exception e) {
			throw new RuntimeException("[ERROR] (destroy) in " + this.getClass() + " : " + e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get email & password from request
		String email = request.getParameter("em");
		String password = request.getParameter("pass");

		try {
			// Get user from User Dao
			User user = userDao.getValidUser(email, password);

			if (user != null) {
				// Valid User. Check the role of user.
				if (user.getRole().equals("ADMIN")) {
					// User is admin. Redirect to AdminServlet
					response.sendRedirect("admin");
				} else if (user.getRole().equals("CUSTOMER")) {
					// User is customer. Redirect to user to TopicsServlet
					response.sendRedirect("topics");
				}
			} else {
				// Set Content Type
				response.setContentType("text/html");
				
				// Invalid User. Retry Page.
				try (PrintWriter pw = response.getWriter()) {
					pw.print("<h1> Login Failed </h1>");
					pw.print("<h3> <a href='login.html'> Retry </a> </h2>");
				}
			}

		} catch (Exception e) {
			throw new RuntimeException("[ERROR] (doGet) in " + this.getClass() + " : " + e);
		}
	}

}
