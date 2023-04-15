package com.tech.blog.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.tech.blog.dao.LikeDao;
import com.tech.blog.helper.ConnectionProvider;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LikeServlet
 */
public class LikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LikeServlet() {
        super();
        // TODO Auto-generated constructor stub
    } 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String operation=request.getParameter("operation");
		 int uid=Integer.parseInt(request.getParameter("uid"));
		 int pid=Integer.parseInt(request.getParameter("pid"));
		 
		 PrintWriter out=response.getWriter();
//		 out.println("data from server");   //this data goes to server and prints to console 
//		 out.println(operation);
//		 out.println(uid);
//		 out.println(pid);
		 
		 LikeDao ldao=new LikeDao(ConnectionProvider.getConnection());
			 
		if(operation.equals("like")) {
		//	boolean f=ldao.insertLike(pid, uid);
			//out.println(f);
			 
		  boolean isLiked=ldao.isLikedByUser(pid, uid);
		  
		  if(isLiked!=true)
		  {
			  boolean f=ldao.insertLike(pid, uid);
				out.println(f);
		  }else {
			  boolean f=ldao.deleteLike(pid, uid);
			  out.println( "deleted"+f);
		  } 
		} 
	} 
}
