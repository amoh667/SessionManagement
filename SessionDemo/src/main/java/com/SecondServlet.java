package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.User;

/**
 * Servlet implementation class SecondServlet
 */
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondServlet() {
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
					u.setEmail(request.getParameter("email"));
					u.setAge(Integer.parseInt(request.getParameter("age")));
					
					// Using session object to call the setAttribute method
					// Set attribute's parameters are the unique key and dto object
					session.setAttribute("user", u);
					
					// Redirecting user to the third page
					response.sendRedirect("three.html");
				
				}
	}

}
