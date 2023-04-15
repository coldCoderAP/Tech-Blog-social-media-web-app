package com.tech.blog.servlets;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.Message;
import com.tech.blog.entities.User;
import com.tech.blog.helper.ConnectionProvider;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    } 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>LoginServlet</title></head><body bgcolor=cyan text=red> ");
		  
        HttpSession s=request.getSession();
        
        s.removeAttribute("currentuser");
        Message m=new Message("Logout Successfully","success","alert-success");
        s.setAttribute("msg",m);
        response.sendRedirect("login.jsp");
        
		out.println(" </body></html>");
		}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
	}

}
