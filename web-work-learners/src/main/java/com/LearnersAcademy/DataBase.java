package com.LearnersAcademy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class DataBase {
	
	public static final String DB_URLTOCONNECT = "jdbc:mysql://localhost:3306/learners_academy";

	public static final String DB_USERNAME = "root";

	public static final String DB_PASSWORD = "";
	
	static private Connection dbCon;

	private static String qry;

	private static Statement theStatement;

	private static ResultSet resultSet;
	
	public List<String> students = new ArrayList<>();
	
	public List<String> classes = new ArrayList<>();
	
	public List<String> subjects = new ArrayList<>();
	
	public List<String> teachers = new ArrayList<>();
	
	public String student;
	
	public String studentId;
	
	public String classId;
	
	public String grade;
	
	public String teacher;
	
	public String teacherId;
	
	public String subject;

	public void met() {
		System.out.println("works?");
		
//		Load the driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
//			Try to establish the connection
			Connection dbCon = DriverManager.getConnection(DB_URLTOCONNECT, DB_USERNAME, DB_PASSWORD);
			
			System.out.println("Connected to db now...");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
 

	
//	public class t {
//		
//		public String student;
//		
//		public String studentId;
//		
//		public String classId;
//		
//		public String grade;
//		
//		public String subject;
//		
//		public List getStudentList() throws SQLException {
//			Connection dbCon = DriverManager.getConnection(DB_URLTOCONNECT, DB_USERNAME, DB_PASSWORD);
//			students.clear();
//			System.out.println("inside student ");
//			qry = "SELECT * FROM students";
//			
//			try {
//				Statement theStatment = dbCon.createStatement();
//				resultSet = theStatment.executeQuery(qry);
//				while (resultSet.next()) {
//					System.out.print("Student ID: " + resultSet.getString("student_ID") + " ");
//					System.out.print("Student Name: " + resultSet.getString("student_name"));
//					System.out.print(" In " + resultSet.getString("grade") + "th grade");
//					System.out.println(" at class: " + resultSet.getString("class_ID"));
//					
//					students.add("Student ID: " + resultSet.getString("student_ID") + " "
//					+"Student Name: " + resultSet.getString("student_name")
//					+" In " + resultSet.getString("grade") + "th grade"
//					+" at class: " + resultSet.getString("class_ID")+ "<br>");
//				}
//				dbCon.close(); // close connection
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return students;
//		}
//	}
	

}
