package com.tech.blog.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.tech.blog.entities.*;
import com.tech.blog.helper.*;
import com.tech.blog.dao.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@MultipartConfig
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
	 

		// Fetch all form data

		String check = request.getParameter("check");
		if (check == null) {
			pw.println("Box not checked");
		} else {
			String name = request.getParameter("user_name");
			String email = request.getParameter("user_email");
			String password = request.getParameter("user_password");
			String gender = request.getParameter("gender");
			String about = request.getParameter("about");

			// create user object and set all data to their object
			User user = new User(name, email, password, gender, about);

			// create userDao object
			UserDao dao = new UserDao(ConnectionProvider.getConnection());
			try {
				if (dao.saveUser(user)) {
					// save..
					pw.println("done");
					//response.sendRedirect("login.jsp");

				} else {
					pw.println("error");

				}

			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		 
	}

}
