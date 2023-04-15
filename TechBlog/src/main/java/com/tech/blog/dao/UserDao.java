package com.tech.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tech.blog.entities.User;

public class UserDao {

	private Connection con;

	public UserDao(Connection con) {
		this.con = con;
	}

	// method to insert user to date base:
	public boolean saveUser(User user) {
		boolean f = false;
		try {
			// user --> Database
			String query = "insert into users1(name,email,password,gender,about) values(?,?,?,?,?)";

			PreparedStatement pstmt = this.con.prepareStatement(query);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getGender());
			pstmt.setString(5, user.getAbout());
			pstmt.executeUpdate();
			f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;

		// get user by email and password
	}

	public User getUserByEmailAndPassword(String email, String password) {
		User user = null;

		try {
			String query = "select * from users1 where email=? and password=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			ResultSet set = pstmt.executeQuery();

			if (set.next()) {
				user = new User();

				// data from db
				String name = set.getString("name");
				// set to user object
				user.setName(name);
				user.setEmail(set.getString("email"));
				user.setId(set.getInt("id"));
				user.setPassword(set.getString("password"));
				user.setGender(set.getString("gender"));
				user.setAbout(set.getString("about"));
				user.setDateTime(set.getTimestamp("rdate"));
				user.setProfile(set.getString("profile"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;

	}

	public boolean updateUser(User user) {
		boolean f = false;

		try {
			String Query = "update users1 set name=? ,email=?, password=?, gender=?,about=?, profile=? where id=? ";
			PreparedStatement p = con.prepareStatement(Query);
			p.setString(1, user.getName());
			p.setString(2, user.getEmail());
			p.setString(3, user.getPassword());
			p.setString(4, user.getGender());
			p.setString(5, user.getAbout());
			p.setString(6, user.getProfile());
			p.setInt(7, user.getId());
			p.executeUpdate();
			f = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return f;
	}

	public User getUserByUserId(int userId) {

		User user = null;

		try {
			String q = "select * from users1 where id=?";
			PreparedStatement pstmt = this.con.prepareStatement(q);
			pstmt.setInt(1,userId);
			ResultSet set=pstmt.executeQuery();
			if(set.next()) {
				user = new User();

				// data from db
				String name = set.getString("name");
				// set to user object
				user.setName(name);
				user.setEmail(set.getString("email"));
				user.setId(set.getInt("id"));
				user.setPassword(set.getString("password"));
				user.setGender(set.getString("gender"));
				user.setAbout(set.getString("about"));
				user.setDateTime(set.getTimestamp("rdate"));
				user.setProfile(set.getString("profile"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}

}
