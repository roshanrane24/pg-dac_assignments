package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
//@WebServlet("annotation")
//@WebServlet("/annotation")
@WebServlet(urlPatterns = {"/annotation", "/anno"})
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		System.out.println("Inside init of " + this.getClass() + " Thread : " + Thread.currentThread());
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("Inside destroy of " + this.getClass() + " Thread : " + Thread.currentThread());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Add content type
		response.setContentType("text/html");
		
		// Get writer from response
		try (PrintWriter pw = response.getWriter()) {
			pw.print("<h1>Response for GET request for /x/annotation<h1>");
			pw.write("<h3>Server Time : " + LocalDateTime.now() + "</h3>");
		}
	}

}
