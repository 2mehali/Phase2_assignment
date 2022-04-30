package com.LearnersAcademy;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static boolean isLoggedIn = false;
    public static String email = "admin";
    public static String password = "adminpassword";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("emailEntered");
		String password = request.getParameter("passwordEntered");
		 
	     
		if( username.equals(Login.email) && password.equals(Login.password)	) {
			
			HttpSession session = request.getSession();
			session.setAttribute("isLoggedIn", true);
			session.setAttribute("username", username);
			
			response.sendRedirect("dashboard.html");
		}
		   else {
				PrintWriter out = response.getWriter(); 
			   isLoggedIn = false;
	            out.println("Login Failed");
	        }
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
