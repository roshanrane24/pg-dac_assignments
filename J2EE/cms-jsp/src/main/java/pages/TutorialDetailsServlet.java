package pages;

import java.io.IOException;
import java.io.PrintWriter;

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
@WebServlet("/details")
public class TutorialDetailsServlet extends HttpServlet {
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

					// Get parameters
					int topicId = Integer.parseInt(request.getParameter("topic_id"));
					String name = request.getParameter("tutorial_name");

					// get tutorial details
					Tutorial tutorial = dao.getTutorialByTutorialName(name);

					// Generate form dynamically for topics
					pw.print("Tutorial id : " + tutorial.getId() + "<br>");
					pw.print("Tutorial Name : " + tutorial.getName() + "<br>");
					pw.print("Tutorial Author : " + tutorial.getAuthor() + "<br>");
					pw.print("Tutorial Published Date : " + tutorial.getPublishedDate() + "<br>");
					pw.print("Tutorial Visits : " + tutorial.getVisits() + "<br>");
					pw.print("Tutorial Content : " + tutorial.getContent() + "<br>");
					pw.print("Tutorial Topic Id : " + tutorial.getTopicId());
					
					// Add a visit count
					dao.visitATutorial(tutorial.getId());

					// add a link to log out the user or go back to previous page
					pw.print("<h5><a href='tutorials?topic_id=" + topicId
							+ "'> Go Back </a> <a href='logout'> Log Me Out </a></h5>");

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
