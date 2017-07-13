package SourceLogin;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, IOException {  

		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		
		String n=request.getParameter("username");  
		String p=request.getParameter("userpass"); 
		
		HttpSession session = request.getSession(false);
		if(session!=null)
		session.setAttribute("name", n);

		if(LoginDAO.validate(n, p)){  
			RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");  
			rd.forward(request,response);  
		}  
		else{  
			out.print("<p style=\"color:red\">Sorry login or password error</p>");  
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
			rd.include(request,response);  
		}if (true) {
                out.print("<p style=\"color:blue\">maby you wont registration</p>");  
			RequestDispatcher rd=request.getRequestDispatcher("registration.jsp");  
			rd.include(request,response);
            } 
            

		out.close();  
	}  
}  