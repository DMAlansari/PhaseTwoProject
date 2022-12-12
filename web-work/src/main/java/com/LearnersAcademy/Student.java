package com.LearnersAcademy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.LearnersAcademy.DataBase;

public class Student  { 
	public static final String DB_URLTOCONNECT = "jdbc:mysql://localhost:3306/learners_academy";

	public static final String DB_USERNAME = "root";

	public static final String DB_PASSWORD = "";
	
	static private Connection dbCon;

	private static String qry;

	private static Statement theStatement;

	private static ResultSet resultSet;

	
	public String student;
	
	public String teacher;
	
	public String teacherId;
	
	public String subject;
// UserDetails Class Begins
	private String studentId;
	private String studentName;
	private String classId;
	private String grade;

	List<Student> studentList = new ArrayList<>();

//	@Override
//	public String toString() {
//		return "ID: " + id + " User Name: " + this.firstName + " " + this.lastName + " is " + age
//				+ " years old with a qualification of " + skills + ".";
//	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String id) {
		studentId = id;
	}
	
	

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}



	public Student() {

	}

	public Student(String studentId, String studentName, String classId, String grade) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.classId = classId;
		this.grade = grade;
	}
	
	public List<Student> getStudentList() throws SQLException {
		Connection dbCon = DriverManager.getConnection(DB_URLTOCONNECT, DB_USERNAME, DB_PASSWORD);
	//	studentList.clear();
		System.out.println("inside student ");
	//	String s1,s2,s3,s4;
		qry = "SELECT * FROM students";
		
		try {
			Statement theStatment = dbCon.createStatement();
			resultSet = theStatment.executeQuery(qry);
			while (resultSet.next()) {
//				System.out.print("Student ID: " + resultSet.getString("student_ID") + " ");
//				System.out.print("Student Name: " + resultSet.getString("student_name"));
//				System.out.print(" In " + resultSet.getString("grade") + "th grade");
//				System.out.println(" at class: " + resultSet.getString("class_ID"));
//				s1 = resultSet.getString("student_ID");
//				s2 = resultSet.getString("student_name");
//				s3 = resultSet.getString("grade");
//				s4 = resultSet.getString("class_ID");
				//studentList.add(new Student(s1,s2,s3,s4));
				studentList.add(new Student(resultSet.getString("student_ID")
						,resultSet.getString("student_name")
						,resultSet.getString("class_ID")
						,resultSet.getString("grade")));
			}
			dbCon.close(); // close connection
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentList;
	}
	
	

}
