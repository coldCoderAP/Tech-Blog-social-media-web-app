package com.tech.blog.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.Message;
import com.tech.blog.entities.User;
import com.tech.blog.helper.ConnectionProvider;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>LoginServlet</title></head><body bgcolor=cyan text=red> ");
		// login
		// fetch user name and password from request

		String userEmail = request.getParameter("email");
		String userPassword = request.getParameter("password");

		UserDao dao = new UserDao(ConnectionProvider.getConnection());

		User u = dao.getUserByEmailAndPassword(userEmail, userPassword);

		if (u == null) {
			// login...
			// error
			//out.println("Invalid details.Try again...");
			
			Message msg=new Message("Invalid Details ! try t with another","error","alert-danger");
			HttpSession s=request.getSession();
			s.setAttribute("msg", msg);
			response.sendRedirect("login.jsp");
		} else {
			// ..login Sucess..
			HttpSession s = request.getSession();
			s.setAttribute("currentuser", u);
			response.sendRedirect("profile.jsp");
		}

		out.println(" </body></html>");
	}

}
