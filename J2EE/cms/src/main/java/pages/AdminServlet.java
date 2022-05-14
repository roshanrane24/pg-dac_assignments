package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TopicDao;
import pojos.Topic;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set content Type
		response.setContentType("text/html");
		
		// Get session
		HttpSession session = request.getSession();
		
		// Get Dao instances from session
		TopicDao topicDao = (TopicDao) session.getAttribute("topic_dao");
		
		// <---------- Create a dynamic form ---------->
		// Get print writer
		try (PrintWriter pw = response.getWriter()) {
			pw.print("    <form action=\"add_tutorial\" method=\"post\">"
					+ "      <div>"
					+ "        <label for=\"topic\">Topic : </label>"
					+ "        <select name=\"topic\" id=\"topic\">");
			
			// get list of topics
			List<Topic> topics = topicDao.getTopics();
		
			topics.forEach(topic -> pw.print("<option value='" + topic.getId() + "'>" + topic.getName() + "</option>\n"));
			
			pw.print("</select>"
					+ "      </div>"
					+ "      <div>"
					+ "        <label for=\"name\">Name : </label>\n"
					+ "        <input type=\"text\" name=\"name\" id=\"name\" placeholder=\"Name\" required />"
					+ "      </div>"
					+ "      <div>"
					+ "        <label for=\"author\">Author : </label>"
					+ "        <input type=\"text\" name=\"author\" id=\"author\" placeholder=\"Author\" required />"
					+ "      </div>"
					+ "      <div>"
					+ "        <label for=\"date\">Published Date : </label>"
					+ "        <input type=\"date\" name=\"date\" id=\"date\" required required />"
					+ "      </div>\n"
					+ "      <div>\n"
					+ "        <label for=\"content\">Content : </label>"
					+ "        <textarea name=\"content\" id=\"content\" row=\"5\" cols=\"33\" required></textarea>\n"
					+ "      </div>\n"
					+ "		 <input type='submit' value='Add Tutorial'>"
					+ "    </form>\n"
					+ "");
			pw.print("<h4><a href='logout'>Log OUT</a><h4>");
			
		} catch (Exception e) {
			throw new ServletException("[ERROR] (" + this.getClass() + ") : " + e);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

}
