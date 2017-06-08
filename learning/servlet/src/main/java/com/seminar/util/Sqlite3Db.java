package com.seminar.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
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
			connection = connection();
			connection.setAutoCommit(false);
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private Connection connection() throws SQLException {
		return ds.getConnection();
	}
	
	public void truncateCourse() {
		String query = "truncate table Course";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.executeUpdate();
			connection.commit();
			ps.close();
//			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insert(Course course) {
		
		int id = course.id();
		String name = course.name();
		String description = course.description();
		String location = course.location();
		int totalSeats = course.totalSeats();
		String startDate = course.startDate();
		
		String sql = "INSERT OR REPLACE INTO Course (id, name, description, location, totalSeats, start) values (?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			
			if(id < 1) {
				ps.setNull(1, Types.INTEGER);
			} else {
				ps.setInt(1, id);
			}
			
			ps.setString(2, name);
			ps.setString(3, description);
			ps.setString(4, location);
			ps.setInt(5, totalSeats);
			ps.setString(6, startDate);
			ps.executeUpdate();
			connection.commit();
			ps.close();
//			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void delete(int id) {
		String sql = "delete from Course where id = ?";
		 
        try {
 
        	PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            connection.commit();
            ps.close();
//            connection.close();
 
        } catch (SQLException e) {
            e.getMessage();
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

	public Course selectCourse(int id) {
		
		String query = "select * from Course where id = " + id;
		Course course = new EmptyCourse();
		
		try {
			 
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			course = (retrieveCourse(rs));
				
			statement.close();
			rs.close();
			
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		return course;
	}

}
