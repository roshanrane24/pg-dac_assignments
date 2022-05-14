package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TutorialDao;
import pojos.Tutorial;

/**
 * Servlet implementation class AddTutorialServlet
 */
@WebServlet("/add_tutorial")
public class AddTutorialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Set response type
		response.setContentType("text/html");

		// get session
		HttpSession session = request.getSession();

		// Get dao instance fron session
		TutorialDao tutorialDao = (TutorialDao) session.getAttribute("tutorial_dao");

		// get data from request
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		LocalDate date = LocalDate.parse(request.getParameter("date"));
		String content = request.getParameter("content");
		int topicId = Integer.parseInt(request.getParameter("topic"));

		// Get request dispatcher
		RequestDispatcher rd = request.getRequestDispatcher("admin");

		// Get print writer
		try (PrintWriter pw = response.getWriter()) {
			// <---------- Validations ---------->
			// validate date
			if (date.isBefore(LocalDate.now().minusMonths(6))) {
				pw.print("<h3 style=''>Published date must be after " + LocalDate.now().minusMonths(6) + "</h3>");
				rd.include(request, response);
				return;
			}

			// validate content
			if (content.length() > 255) {
				pw.print("<h3 color='red'>Content length must be less than 255 characters</h3>");
				rd.include(request, response);
				return;
			}

			// Create a Tutorial
			Tutorial tutorial = new Tutorial();
			tutorial.setName(name);
			tutorial.setAuthor(author);
			tutorial.setPublishedDate(Date.valueOf(date));
			tutorial.setTopicId(topicId);
			tutorial.setContent(content);

			// Add tutorial to database
			tutorialDao.addTutorial(tutorial);
			
			pw.print("<div><h2>Succesfully Added Tutorial</h2></div>");
			
			pw.print("<h4><a href='admin'>Go Back</a><h4><h4><a href='logout'>Log OUT</a><h4>");

		} catch (Exception e) {
			throw new RuntimeException("[ERROR] (doPost) in " + this.getClass() + " : " + e);
		}
	}

}
