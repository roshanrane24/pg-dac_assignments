package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TopicDao;
import pojos.Topic;

/**
 * Servlet implementation class TopicsServlet
 */
@WebServlet("/topics")
public class TopicsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TopicDao topicDao;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		try {
			// Create User DAO Instance
			topicDao = new TopicDao();
		} catch (Exception e) {
			throw new ServletException("[ERROR] (init) in " + this.getClass() + " : " + e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			topicDao.cleanUp();
		} catch (Exception e) {
			throw new RuntimeException("[ERROR] (destroy) in " + this.getClass() + " : " + e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Set Content Type
		response.setContentType("text/html");

		// create list to store topics
		List<Topic> list;
		try {
			// Get list of topic
			list = topicDao.getTopics();
		} catch (SQLException e) {
			throw new ServletException("[ERROR] (doGet) in " + this.getClass() + " : " + e);
		}

		try (PrintWriter pw = response.getWriter()) {
			// response for customer
			pw.print("<h1> Customer Login Successful</h1>");
			pw.print("<ul>");
			list.forEach( topic -> pw.print("<li>" + topic.getName() + "</l1>"));
			pw.print("</ul>");

		}
	}
}
