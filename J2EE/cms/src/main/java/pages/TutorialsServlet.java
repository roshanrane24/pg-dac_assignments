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

import dao.TutorialDao;
import pojos.Tutorial;
import pojos.User;

/**
 * Servlet implementation class TutorialsServlet
 */
@WebServlet("/tutorials")
public class TutorialsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Set content type of response
		response.setContentType("text/html");

		// Get session
		HttpSession hs = request.getSession(false);

		try (PrintWriter pw = response.getWriter()) {
			if (hs != null) {
				// Get user from session
				User user = (User) hs.getAttribute("user_details");

				if (user != null) {
					// Get tutorial DAO from session
					TutorialDao dao = (TutorialDao) hs.getAttribute("tutorial_dao");

					int topicId = Integer.parseInt(request.getParameter("topic_id"));

					List<Tutorial> tutorials = dao.getTutorialsByTopicId(topicId);

					// Generate form dynamically for topics
					pw.print("<ul>");
					tutorials.forEach(t -> pw.print("<li> <a href='details?topic_id=" + t.getTopicId()
							+ "&tutorial_name=" + t.getName() + "'>" + t.getName() + "<a> </li>"));
					pw.print("</ul>");

					// add a link to log out the user or go back to previous page
					pw.print("<h5><a href='topics'> Go Back </a> <a href='logout'> Log Me Out </a></h5>");

					return;
				}
			}

			// No Session found
			pw.print("<h1> User session not found </h1> ");
			pw.print("<h3> Check if cookies are enabled <a href='login.html'>login again</a></h3> ");
		} catch (Exception e) {
			throw new RuntimeException("[ERROR] (doGet) in " + this.getClass() + " : " + e);
		}
	}

}
