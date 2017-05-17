package com.seminar.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Sqlite3Db {
	
	private DataSource ds;
	private Connection connection;

	public Sqlite3Db() {
		
		try {
			ds = (DataSource)new InitialContext().lookup("java:/comp/env/jdbc/ds");
			connection = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void truncateCourse() {
		String query = "truncate table Course";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insert(Course course) {
		
		String name = course.name();
		String description = course.description();
		String location = course.location();
		int totalSeats = course.totalSeats();
		String startDate = course.startDate();
		
		String sql = "INSERT INTO Course (name, description, location, totalSeats, start) values (?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, name);
			ps.setString(2, description);
			ps.setString(3, location);
			ps.setInt(4, totalSeats);
			ps.setString(5, startDate);
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public List<Course> courses() {
		
		String query = "select * from Course";
		List<Course> courses = new ArrayList<>();
		
		try {
			Statement statement = connection.createStatement();
			
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				
				courses.add(retrieveCourse(rs));
				
			}
			
			statement.close();
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return courses;
	}

	private Course retrieveCourse(ResultSet rs) throws SQLException {
		
		String id = rs.getString(1);
		String name = rs.getString(2);
		String description = rs.getString(3);
		String location = rs.getString(4);
		String totalSeats = rs.getString(5);
		String startDate = rs.getString(6);
		
		return new ValidCourse(name, id, description, startDate, location, totalSeats);
	}

}
