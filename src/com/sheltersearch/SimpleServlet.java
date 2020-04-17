package com.sheltersearch;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class SimpleServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		if(name !=null) {
		resp.getWriter().printf("Hello %s",name);
		}
		else
		{
			resp.getWriter().write("Please Enter Your Name");
		}
	}
	
}


//RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
//request.setAttribute("student", student);
//dispatcher.forward(request, response);