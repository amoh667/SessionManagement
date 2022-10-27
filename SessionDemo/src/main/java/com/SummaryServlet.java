package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.User;

/**
 * Servlet implementation class SummaryServlet
 */
public class SummaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SummaryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// Creating an object of the User class
		User u = new User();
		
		// Creating an object of the http session
		HttpSession session = request.getSession(false);
		
		if(session != null)
		{
			
			u = (User) session.getAttribute("user");
			// Setting values in User class
			u.setCity(request.getParameter("city"));
			u.setContact(Long.parseLong(request.getParameter("contact")));
			
			/*// Using session object to call the setAttribute method
			// Set attribute's parameters are the unique key and dto object
			session.setAttribute("user", u); */
			
			PrintWriter out = response.getWriter();
			out.println("<h2> Hello "+ u.getEmail() + "</h2>");
			out.println("<h3> Details .. "+ u + "</h3>");
			out.println("<h4> Session Id is "+ session.getId() + "</h4>");
			out.println("<h4> Session created at "+ session.getCreationTime() + "</h4>");
			
			// Destroying the session
			session.invalidate();
		
		}
	}

}
