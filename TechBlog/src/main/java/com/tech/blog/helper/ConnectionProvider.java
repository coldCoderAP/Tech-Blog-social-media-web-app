package com.tech.blog.helper;
import java.sql.*;
public class ConnectionProvider {
  
	private static Connection con;
	
	public static Connection getConnection() {
		try {
			if(con==null) {
				//Class.forName("oracle.jdbc.driver.OracleDriver");
			 
			//	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1527:orcl","scott","tiger");
				Class.forName("com.mysql.jdbc.Driver");  
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/new", "root", "root");
				 
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
}
