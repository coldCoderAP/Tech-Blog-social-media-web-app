package com.tech.blog.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import com.tech.blog.dao.PostDao;
import com.tech.blog.entities.Post;
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
public class AddPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		int cid = Integer.parseInt(request.getParameter("cid"));

		String pTitle = request.getParameter("pTitle");
		String pContent = request.getParameter("pContent");
		String pCode = request.getParameter("pCode" );
		Part part = request.getPart("pic");

		// getting currentuser id

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("currentuser");

//		out.println("Your title is " + pTitle);   // it prints in console of browser beacuse of jquery
//		out.println(part.getSubmittedFileName());

		Post p = new Post(pTitle, pContent, pCode, part.getSubmittedFileName(), null, cid, user.getId());

		PostDao dao = new PostDao(ConnectionProvider.getConnection());

		if (dao.savePost(p)) {
			String path=request.getRealPath("/")+"blog_pics"+File.separator+part.getSubmittedFileName();
			
			Helper.saveFile(part.getInputStream(),path);
			out.println("done");
		} else {
			out.println("error");
		}

	} 
}
