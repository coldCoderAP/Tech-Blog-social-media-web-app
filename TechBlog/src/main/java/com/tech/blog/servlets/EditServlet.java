package com.tech.blog.servlets;

import java.io.*;

import java.io.IOException;
import java.io.PrintWriter;

import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.Message;
import com.tech.blog.entities.User;
import com.tech.blog.helper.ConnectionProvider;
import com.tech.blog.helper.Helper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@MultipartConfig
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		// fetch all data
		String userEmail = request.getParameter("user_email");
		String userName = request.getParameter("user_name");
		String userPassword = request.getParameter("user_password");
		String userAbout = request.getParameter("user_about");
		Part part = request.getPart("image");
		String imageName = part.getSubmittedFileName();

		// get the user from the session
		HttpSession s = request.getSession();
		User user = (User) s.getAttribute("currentuser");
		user.setEmail(userEmail);
		user.setName(userName);
		user.setAbout(userAbout);
		user.setPassword(userPassword);
		String oldFile = user.getProfile();
		user.setProfile(imageName);

		UserDao userDao = new UserDao(ConnectionProvider.getConnection());

		boolean ans = userDao.updateUser(user);

		if (ans) {
			out.println("updated to db");
			String path = request.getRealPath("/") + "pics" + File.separator + user.getProfile();

			// delete code(file)
			String pathOldFile = request.getRealPath("/") + "pics" + File.separator + oldFile;

			if (!oldFile.equals("default.jpg")) {
				Helper.deleteFile(pathOldFile);
			}

			if (Helper.saveFile(part.getInputStream(), path)) {
				out.println("Profile Upadated");
				Message msg = new Message("Profile updated...", "success", "alert-success");
				s.setAttribute("msg", msg);
			} else {
				Message msg = new Message("Something Went Wrong", "error", "alert-danger");
				s.setAttribute("msg", msg);
			}

		} else {
			out.println("not upated");
			Message msg = new Message("Something Went Wrong", "error", "alert-danger");
			s.setAttribute("msg", msg);
		}

		response.sendRedirect("profile.jsp");
	}

}
