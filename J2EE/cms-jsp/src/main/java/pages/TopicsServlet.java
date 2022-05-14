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
import pojos.User;

/**
 * Servlet implementation class TopicsServlet
 */
@WebServlet("/topics")
public class TopicsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Set content type
		response.setContentType("text/html");

		try (PrintWriter pw = response.getWriter()) {
			// response for customer
			pw.print("<h1> Customer Login Successful</h1>");

			// Get session
			HttpSession hs = request.getSession();

			// get user details from session
			User user = (User) hs.getAttribute("user_details");

			if (user != null) {
				// get topic DAO instance from session scope
				TopicDao dao = (TopicDao) hs.getAttribute("topic_dao");

				// invoke topic dao's method to get all topics
				List<Topic> topics = dao.getTopics();

				// Generate form dynamically for topics
				pw.print("<form action='tutorials' align='center'>");
				for (Topic t : topics)
					pw.print(
							"<input type='radio' name='topic_id' value='" + t.getId() + "' title='Please select topic' required />" + t.getName() + "<br/>");
				pw.print("<input type='submit' value='Choose A Topic'/>");
				pw.print("</form>");

				// add a link (temp) to log out the user
				pw.print("<h5><a href='logout'>Log Me Out</a></h5>");
			} else {
				// Did not found user in current session
				pw.print("<h4> Check if cookies are enabled.</h4>");
				pw.print("<h5> Please <a href='login.html'>login again</a></h5>");
				hs.invalidate();
			}

		} catch (Exception e) {
			throw new RuntimeException("[ERROR] (doGet) in " + this.getClass() + " : " + e);
		}
	}
}
